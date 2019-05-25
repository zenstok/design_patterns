package tema_cts.command;

import java.util.ArrayList;

public class SaleManager {
	private ArrayList<SaleRow> saleRows = new ArrayList<>();
	
	public void addSaleRow(SaleRow row) {
		saleRows.add(row);
	}
	
	public Sale createSale() {
		return new Sale(this.saleRows);
	}
}
