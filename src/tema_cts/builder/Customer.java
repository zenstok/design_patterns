package tema_cts.builder;

import tema_cts.memento.Memento;

public class Customer {
	//necessary fields
	protected String name;
	protected String telephone;
	
	// optional field
	protected String email;
	
	// constructor for decorator
	protected Customer() {
		
	}

	private Customer(Builder builder) {
		super();
		this.name = builder.name;
		this.telephone = builder.telephone;
		this.email = builder.email;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Memento saveToMemento() {
		return new Memento(this.name,this.telephone,this.email);
	}
	
	public void restoreFromMemento(Memento m) {
		this.name = m.getName();
		this.telephone = m.getTelephone();
		this.email = m.getEmail();
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", telephone=" + telephone + ", email=" + email + "]";
	}


	public static class Builder {
		//necessary fields
		private String name;
		private String telephone;
		
		// optional field
		private String email;

		public Builder(String name, String telephone) {
			super();
			this.name = name;
			this.telephone = telephone;
		}
		
		
		public Builder setEmail(String email) {
			this.email = email;
			return this;
		}


		public Customer build() {
			return new Customer(this);
		}
		
	}

}
