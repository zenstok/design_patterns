package tema_cts.command;

public class SaleRow {
	private String produs;
	private float pret;
	
	public SaleRow(String produs, float pret) {
		super();
		this.produs = produs;
		this.pret = pret;
	}

	public String getProdus() {
		return produs;
	}

	public float getPret() {
		return pret;
	}
	
	
}
