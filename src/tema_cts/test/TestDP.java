package tema_cts.test;

import java.util.HashMap;

import tema_cts.builder.Customer;
import tema_cts.command.Sale;
import tema_cts.command.SaleManager;
import tema_cts.command.SaleRow;
import tema_cts.decorator.LoyalCustomer;
import tema_cts.flyweight.FlyweightFactory;
import tema_cts.flyweight.Pharmacy;
import tema_cts.flyweight.Receipt;
import tema_cts.memento.CustomerManager;
import tema_cts.memento.Memento;
import tema_cts.observer.RequestEvent;
import tema_cts.proxy.Log;
import tema_cts.proxy.RequestHandler;
import tema_cts.proxy.RequestProxy;
import tema_cts.singleton.ApiManager;
import tema_cts.singleton.MedicalUnit;
import tema_cts.singleton.MedicalUnitType;
import tema_cts.singleton.Prescription;
import tema_cts.state.Report;
import tema_cts.state.Status;

public class TestDP {

	public static void main(String[] args) throws Exception {
		MedicalUnit clinica = new MedicalUnit("Clinica1", "Adresa1", "dsa423frewtgwy53", MedicalUnitType.CLINICA);
		MedicalUnit spital = new MedicalUnit("Spital1", "Adresa12345", "fds5234gtegerhbedgdaq324436gsdf",
				MedicalUnitType.SPITAL);
		spital.setEnabled(true);

		ApiManager API = ApiManager.getInstance();
		API.addMedicalUnit(clinica);
		API.addMedicalUnit(spital);
		System.out.println(API.numberOfMedicalUnits());
		API.removeMedicalUnitsWithExpiredContract();
		System.out.println(API.numberOfMedicalUnits());

		// cream requestEventuri
		RequestHandler requestHandler = new RequestHandler();
		RequestEvent requestEventInvalid = new RequestEvent("oCheieInvalida", new Prescription());
		RequestProxy requestProxy = new RequestProxy();
		requestProxy.addEventListener(requestEventInvalid, requestHandler);
		requestEventInvalid.makeRequest();
		System.out.println(Log.messages.get(0));

		HashMap<String, Float> randuriMedicamente = new HashMap<>();
		randuriMedicamente.put("Paracetamol", 12.5F);
		randuriMedicamente.put("Strepsils", 30.22F);
		randuriMedicamente.put("Nurofen Forte", 19.3F);
		Prescription prescription = new Prescription("Doctor Ciprian Ionescu", randuriMedicamente);
		RequestEvent requestEventValid = new RequestEvent("fds5234gtegerhbedgdaq324436gsdf", prescription);
		requestProxy.addEventListener(requestEventValid, requestHandler);
		requestEventValid.makeRequest();

		// cream un client care nu doreste materiale promotionale pe email
		Customer customer1 = new Customer.Builder("Gigel", "0723451254").build();
		// cream un client care doreste materiale promotionale pe email
		Customer customer2 = new Customer.Builder("Marcel", "0754345434").setEmail("marcel23@gmail.com").build();
		System.out.println(customer1.toString());
		System.out.println(customer2.toString());

		// un client devine fidel
		LoyalCustomer loyalCustomer = new LoyalCustomer(new LoyalCustomer(customer2));
		loyalCustomer.setLoyaltyPoints(6);
		System.out.println("Clientul "+ loyalCustomer.getName() +" are "+ loyalCustomer.getLoyaltyPoints() + " puncte de fidelitate");
		
		// un angajat a introdus date malitioase si se vrea recuperarea datelor anterioare ale unui client
		CustomerManager manager = new CustomerManager();
		manager.addVersion(customer2);
		customer2.setEmail("malicious@abc.com");
		System.out.println(customer2.toString());
		customer2.restoreFromMemento(manager.getVersion(customer2, 0));
		System.out.println(customer2.toString());
		
		// un client vine si cere medicamente treptat
		SaleManager saleManager = new SaleManager();
		saleManager.addSaleRow(new SaleRow("Nurofen", 20));
		Thread.sleep(2000); // simulam timp de asteptare
		saleManager.addSaleRow(new SaleRow("Parasinus", 15));
		Sale sale = saleManager.createSale(); // daca clientul se razgandeste si nu mai vrea sa cumpere nimic nu se mai creeaza o vanzare aiurea
		System.out.println(sale.toString());
		
		// adaugare vanzare intr-un raport
		Report report = new Report();
		sale.putInReport(report);
		sale.setStatus(Status.EFECTUATA);
		sale.putInReport(report);
		System.out.println(report.sales.size());
		
		// avem de printat 5 de bonuri la farmacia Catena
		Pharmacy pharma = new Pharmacy("Catena", "str. Mareelor nr.21");
		Sale[] sales = new Sale[5];
		for(int i=0;i<5;i++) {
			sales[i] = sale;
		}
		Receipt[] receipts = new Receipt[5];
		for(int i=0;i<5;i++) {
			receipts[i] = FlyweightFactory.getReceipt(pharma);
		}

		for(int i=0;i<5;i++) {
			receipts[i].print(sales[i]);
		}
		
		System.out.print("S-a creat un numar de "+FlyweightFactory.numberOfReceipts()+" bonuri");

	}

}
