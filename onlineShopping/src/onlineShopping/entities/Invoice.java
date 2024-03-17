package onlineShopping.entities;

public class Invoice {
	private Order order;
    private double totalAmount;

    public Invoice(Order order, double totalAmount) {
        this.setOrder(order);
        this.setTotalAmount(totalAmount);
    }

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
    
}
