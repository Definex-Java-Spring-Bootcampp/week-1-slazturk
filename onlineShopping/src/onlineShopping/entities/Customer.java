package onlineShopping.entities;

import java.util.*;

public class Customer {
	private String name;
    private String email;
    private List<Order> orders;
    private int age;
    
    public Customer(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
    
    
}
