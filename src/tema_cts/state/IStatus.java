package tema_cts.state;

import tema_cts.command.Sale;

public interface IStatus {
	void report(Sale s, Report r);
}
