package tema_cts.memento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import tema_cts.builder.Customer;

public class CustomerManager {
	private HashMap<Customer, ArrayList<Memento>> customersList = new HashMap<>();

	public void addVersion(Customer customer) {
		Memento m = customer.saveToMemento();
		boolean exists = false;
		for (Map.Entry<Customer, ArrayList<Memento>> entry : customersList.entrySet()) {
			if (entry.getKey() == customer) {
				entry.getValue().add(m);
				exists = true;
				break;
			}
		}
		if (exists == false) {
			ArrayList<Memento> versions = new ArrayList<>();
			versions.add(m);
			customersList.put(customer, versions);
		}
	}

	public Memento getVersion(Customer customer, int i)  {
		for(Map.Entry<Customer, ArrayList<Memento>> entry: customersList.entrySet()) {
			if(entry.getKey() == customer) {
				return entry.getValue().get(i);
			}
		}
		return null;
	}

}
