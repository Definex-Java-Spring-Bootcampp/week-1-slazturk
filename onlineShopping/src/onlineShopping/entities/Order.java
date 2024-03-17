package onlineShopping.entities;

import java.util.*;

public class Order {
	private List<Product> products;
    private Invoice invoice;

    public Order() {
        this.setProducts(new ArrayList<>());
    }

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}
    
	public void addProduct(Product product) {
        products.add(product);
    }
}
