package onlineShopping;

import java.util.*;

import onlineShopping.entities.Customer;
import onlineShopping.entities.Invoice;
import onlineShopping.entities.Order;
import onlineShopping.entities.Product;
import onlineShopping.system.OnlineShoppingSystem;

public class Main {

	public static void main(String[] args) {
		
		OnlineShoppingSystem onlineShoppingSystem=new OnlineShoppingSystem();
		
		Customer customer1 = new Customer("Ahmet", "ahmet@mail.com", 28);
        Customer customer2 = new Customer("Cem", "cem@mail.com", 26);
        Customer customer3 = new Customer("Mehmet", "mehmet@mail.com", 35);
        Customer customer4 = new Customer("Cem", "cem2@mail.com", 45);

        Order order1 = new Order();
        order1.addProduct(new Product("Laptop", "Elektronik", 3000.0, 1));
        order1.addProduct(new Product("Telefon", "Elektronik", 2000.0, 1));
        order1.setInvoice(new Invoice(order1, 5000.0));
        customer1.addOrder(order1);

        Order order2 = new Order();
        order2.addProduct(new Product("Kamera", "Elektronik", 1500.0, 1));
        order2.setInvoice(new Invoice(order2, 1500.0));
        customer2.addOrder(order2);

        Order order3 = new Order();
        order3.addProduct(new Product("Bisiklet", "Spor", 2500.0, 1));
        order3.setInvoice(new Invoice(order3, 2500.0));
        customer3.addOrder(order3);

        Order order4 = new Order();
        order4.addProduct(new Product("Telefon", "Elektronik", 2500.0, 1));
        order4.setInvoice(new Invoice(order3, 2500.0));
        customer4.addOrder(order4);
        
        onlineShoppingSystem.addCustomer(customer1);
        onlineShoppingSystem.addCustomer(customer2);
        onlineShoppingSystem.addCustomer(customer3);
        onlineShoppingSystem.addCustomer(customer4);
        
        //Total number of customers
        int totalCustomers = onlineShoppingSystem.getTotalCustomers();
        System.out.println("Total customers: " + totalCustomers);
        System.out.println();
        
        // Finding the number of products purchased by customers named Cem
        int productCountOfCem = onlineShoppingSystem.getProductCountOfCustomer("Cem");
        System.out.println("Product count of customers named Cem: " + productCountOfCem);
        System.out.println();
        
        // Calculating the total shopping amount of customers younger than 30 and older than 25 whose name is Cem
        double totalPurchaseAmount = onlineShoppingSystem.getTotalPurchaseAmountOfCustomers();
        System.out.println("Total purchase amount of customers named Cem aged between 25 and 30: " + totalPurchaseAmount);
        System.out.println();
        
        // Listing invoices over 1500 TL in the system
        double threshold = 1500.0;
        List<Invoice> highValueInvoices = onlineShoppingSystem.getHighValueInvoices(threshold);
        System.out.println("Invoices over " + threshold + " TL:");
        for (Invoice invoice : highValueInvoices) {
            System.out.println("Invoice total amount: " + invoice.getTotalAmount());
            System.out.println("Products:");
            for (Product product : invoice.getOrder().getProducts()) {
                System.out.println("- " + product.getName() + ": " + product.getPrice() + " TL");
            }
            System.out.println();
        }
	}

}
