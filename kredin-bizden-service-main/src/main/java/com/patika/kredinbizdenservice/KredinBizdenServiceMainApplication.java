package com.patika.kredinbizdenservice;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.patika.kredinbizdenservice.enums.SectorType;
import com.patika.kredinbizdenservice.model.Application;
import com.patika.kredinbizdenservice.model.Campaign;
import com.patika.kredinbizdenservice.model.ConsumerLoan;
import com.patika.kredinbizdenservice.model.Loan;

//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.patika.kredinbizdenservice.model.User;

//@SpringBootApplication
public class KredinBizdenServiceMainApplication {

	public static void main(String[] args) {
		//SpringApplication.run(KredinBizdenServiceMainApplication.class, args);
		
		UserManager userManager=UserManager.getInstance();//created according to singleton design pattern
		ApplicationManager applicationManager=ApplicationManager.getInstance();
		
		User user1=new User("User1","Surname1","user1@mail.com","password","5371455589",true);
		userManager.registerUser(user1);
		
		User user2=new User("User2","Surname2","user2@mail.com","password","5371455582",true);
		userManager.registerUser(user2);
		
		User user3=new User("User3","Surname3","cemdrman@gmail.com","password","5371455583",true);
		userManager.registerUser(user3);
		
		Campaign campaign1= new Campaign("Campaign1", "Lorem ipsum dolor sit amet", 
				LocalDate.of(2024, 12, 12), LocalDate.of(2024, 01, 01), LocalDate.of(2024, 11, 11),
				SectorType.MARKET);
		Campaign campaign2= new Campaign("Campaign2", "Lorem ipsum dolor sit amet", 
				LocalDate.of(2024, 12, 12), LocalDate.of(2024, 01, 01), LocalDate.of(2024, 11, 11),
				SectorType.TRAVELS);
		Loan consumerLoan1=new ConsumerLoan(new BigDecimal(15000), 10, 3.59, campaign1);//created according to factory design pattern
		Loan consumerLoan2=new ConsumerLoan(new BigDecimal(10000), 10, 3.59, campaign2);
		
		Application application1=new Application(consumerLoan1, user1, LocalDateTime.now());
		applicationManager.applyForCredit(user1, consumerLoan1, application1.getLocalDateTime());
		
		Application application2=new Application(consumerLoan1, user3, LocalDateTime.now());
		applicationManager.applyForCredit(user3, consumerLoan1, application2.getLocalDateTime());
		
		Application application3=new Application(consumerLoan1, user3, LocalDateTime.now());
		applicationManager.applyForCredit(user3, consumerLoan2, application3.getLocalDateTime());

		Application application4=new Application(consumerLoan1, user2, LocalDateTime.now());
		applicationManager.applyForCredit(user2, consumerLoan1, application4.getLocalDateTime());
		
		
		System.out.println("Top Applicant: " + applicationManager.findTopApplicant().getEmail());
		System.out.println();
		
        System.out.println("Top Credit Requested User Email: " + applicationManager.findTopCreditRequestedUser().getEmail());
        System.out.println("Requested Credit:");
        applicationManager.findTopCreditRequestedUser().getApplicationList().stream()
                .map(application -> application.getLoan().getAmount())
                .forEach(System.out::println);
        System.out.println();
        
        System.out.println("Last Month Applications:");
        List<Application> lastMonthApplications = applicationManager.getLastMonthApplications();
        for (Application application : lastMonthApplications) {
            System.out.println("User: " + application.getUser().getEmail() + ", Loan Type: " + application.getLoan().getClass().getSimpleName() + ", Amount: " + application.getLoan().getAmount() + ", Date: " + application.getLocalDateTime());
        }
        System.out.println("\n");
        
        System.out.println("Applications by Email (cemdrman@gmail.com):");
        List<Application> userApplications = applicationManager.getApplicationsByEmail("cemdrman@gmail.com");
        for (Application application : userApplications) {
            System.out.println("Loan Type: " + application.getLoan().getClass().getSimpleName()+ ", Amount: " + application.getLoan().getAmount() + ", Date: " + application.getLocalDateTime());
        }
        System.out.println("\n");
       
        System.out.println("Credit Offers by Campaign:");
        List<Application> creditOffers = applicationManager.getCreditOffersByCampaign();
        for (Application application : creditOffers) {
            System.out.println("Credit Type: " + application.getLoan().getClass().getSimpleName() + ", Amount: " + application.getLoan().getAmount());
        }
        System.out.println("\n");
		
	}

}
