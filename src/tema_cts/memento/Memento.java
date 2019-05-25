package tema_cts.memento;

public class Memento {
	//date ce sunt salvate intr-o versiune de client
	protected String name;
	protected String telephone;
	protected String email;
	
	public Memento(String name, String telephone, String email) {
		super();
		this.name = name;
		this.telephone = telephone;
		this.email = email;
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
	
}
