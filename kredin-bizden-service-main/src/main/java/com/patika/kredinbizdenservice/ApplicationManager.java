package com.patika.kredinbizdenservice;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Loan;
import com.patika.kredinbizdenservice.model.User;

//Class has been build according to singleton design pattern
public class ApplicationManager {
	private static volatile ApplicationManager instance;
	private List<Application> applications;

    private ApplicationManager() {
        applications = new ArrayList<>();
    }
    
    public static ApplicationManager getInstance() {
    	if (instance == null) {
            synchronized (ApplicationManager.class) {
                if (instance == null) {
                    instance = new ApplicationManager();
                }
            }
        }
        return instance;
    }
    
    public void applyForCredit(User user, Loan loan, LocalDateTime localDateTime) {
        Application application = new Application(loan, user, localDateTime);
        applications.add(application);
        user.getApplicationList().add(application);
    }

    public User findTopApplicant() {
        Map<User, Integer> applicationCounts = new HashMap<>();
        for (Application application : applications) {
            User user = application.getUser();
            applicationCounts.put(user, applicationCounts.getOrDefault(user, 0) + 1);
        }
        return Collections.max(applicationCounts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public User findTopCreditRequestedUser() {
        return applications.stream()
                .max(Comparator.comparing(app -> app.getLoan().getAmount()))
                .map(Application::getUser)
                .orElse(null);
    }

    public List<Application> getLastMonthApplications() {
        LocalDateTime lastMonth = LocalDateTime.now().minus(1, ChronoUnit.MONTHS);
        List<Application> lastMonthApplications = new ArrayList<>();
        for (Application application : applications) {
            if (application.getLocalDateTime().isAfter(lastMonth)) {
                lastMonthApplications.add(application);
            }
        }
        return lastMonthApplications;
    }

    public List<Application> getApplicationsByEmail(String email) {
        List<Application> userApplications = new ArrayList<>();
        for (Application application : applications) {
            if (application.getUser().getEmail().equals(email)) {
                userApplications.add(application);
            }
        }
        return userApplications;
    }

    
    public List<Application> getCreditOffersByCampaign() {
        Map<String, List<Application>> offersByCampaign = new HashMap<>();
        for (Application application : applications) {
            String campaignName = application.getLoan().getCampaign().getTitle();
            List<Application> offers = offersByCampaign.getOrDefault(campaignName, new ArrayList<>());
            offers.add(application);
            offersByCampaign.put(campaignName, offers);
        }
        List<Application> sortedApplications = new ArrayList<>();
        for (List<Application> offers : offersByCampaign.values()) {
            sortedApplications.addAll(offers);
        }
        return sortedApplications;
    }

}
