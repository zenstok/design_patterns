package tema_cts.state;

import tema_cts.command.Sale;

public class StatusNeefectuata implements IStatus {

	@Override
	public void report(Sale s, Report r) {
		System.out.println("Atentie, ati incercat sa adaugati in raport o vanzare care nu are status efectuata!");
		
	}

}
