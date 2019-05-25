package tema_cts.state;

import tema_cts.command.Sale;

public class StatusEfectuata implements IStatus {

	@Override
	public void report(Sale s, Report r) {
		r.sales.add(s);
		
	}

}
