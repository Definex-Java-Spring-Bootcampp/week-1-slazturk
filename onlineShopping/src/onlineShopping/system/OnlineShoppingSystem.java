package onlineShopping.system;

import java.util.*;
import java.util.stream.Collectors;

import onlineShopping.entities.Customer;
import onlineShopping.entities.Invoice;
import onlineShopping.entities.Order;

public class OnlineShoppingSystem {
    private List<Customer> customers;

    public OnlineShoppingSystem() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public int getTotalCustomers() {
        return customers.size();
    }

    public int getProductCountOfCustomer(String name) {
        return customers.stream()
                        .filter(customer -> customer.getName().equals(name))
                        .mapToInt(customer -> customer.getOrders().stream().mapToInt(order -> order.getProducts().size()).sum())
                        .sum();
    }

    public double getTotalPurchaseAmountOfCustomers() {
        return customers.stream()
                        .filter(customer -> customer.getName().equals("Cem") && customer.getAge() < 30 && customer.getAge() > 25)
                        .flatMap(customer -> customer.getOrders().stream())
                        .mapToDouble(order -> order.getInvoice().getTotalAmount())
                        .sum();
    }

    public List<Invoice> getHighValueInvoices(double threshold) {
        return customers.stream()
                        .flatMap(customer -> customer.getOrders().stream())
                        .filter(order -> order.getInvoice().getTotalAmount() > threshold)
                        .map(Order::getInvoice)
                        .collect(Collectors.toList());
    }
}