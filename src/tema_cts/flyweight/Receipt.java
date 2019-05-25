package tema_cts.flyweight;

import java.util.Date;

import tema_cts.command.Sale;
import tema_cts.command.SaleRow;
import tema_cts.singleton.MedicalUnit;

public class Receipt implements PrintableReceiptInterface {
	private String currentTime;
	private String pharmacyName;
	private String pharmacyAddress;

	public Receipt(Pharmacy pharma) {
		this.pharmacyName = pharma.getName();
		this.pharmacyAddress = pharma.getAddress();
	}
	

	@Override
	public void print(Sale sale) {
		this.currentTime = new Date(System.currentTimeMillis()).toString();
		System.out.println("Nume farmacie: "+pharmacyName+"\n"+
						   "Adresa: "+pharmacyAddress+"\n"+
						   "Data: "+currentTime+"\n"+
						   "Produse:"
				);
		for(SaleRow row: sale.getSaleRows()) {
			System.out.println(row.getProdus()+" "+row.getPret());
		}
		System.out.print(System.lineSeparator());
		
	}

}
