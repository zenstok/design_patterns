package tema_cts.command;

import java.util.ArrayList;

import tema_cts.state.IStatus;
import tema_cts.state.Report;
import tema_cts.state.Status;
import tema_cts.state.StatusEfectuata;
import tema_cts.state.StatusNeefectuata;

public class Sale {
	private IStatus status;
	private ArrayList<SaleRow> saleRows;
	
	public Sale(ArrayList<SaleRow> saleRows) {
		super();
		this.status = new StatusNeefectuata();
		this.saleRows = saleRows;
	}

	public void putInReport(Report r) {
		this.status.report(this, r);
	}

	public void setStatus(Status status) {
		if(status == Status.NEEFECTUATA) {
			this.status = new StatusNeefectuata();
		} else if (status == Status.EFECTUATA) {
			this.status = new StatusEfectuata();
		}
	}

	public ArrayList<SaleRow> getSaleRows() {
		return saleRows;
	}
	
}
