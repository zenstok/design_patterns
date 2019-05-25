package tema_cts.flyweight;

import tema_cts.command.Sale;

public interface PrintableReceiptInterface {
	void print(Sale sale); // ca date despre receipt nu vom folosi alta clasa ReceiptData pentru ca avem deja Sale
}
