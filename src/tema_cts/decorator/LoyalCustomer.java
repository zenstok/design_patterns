package tema_cts.decorator;

import tema_cts.builder.Customer;

//exista o singura decorare a clasei deci nu avem nevoie de o clasa abstracta Decorator pentru ca nu vom decora vreodata cu altceva
public class LoyalCustomer extends Customer {
	private int loyaltyPoints;

	public LoyalCustomer(Customer customer) {
		super();
		this.name = customer.getName();
		this.telephone = customer.getTelephone();
		this.email = customer.getEmail();
		this.loyaltyPoints = 1;
	}

	public int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}
	

}
