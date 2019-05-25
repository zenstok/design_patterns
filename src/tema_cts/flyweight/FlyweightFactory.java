package tema_cts.flyweight;

import java.util.HashMap;


public class FlyweightFactory {
	static HashMap<Pharmacy, Receipt> receiptList = new HashMap<>();
	
	public static Receipt getReceipt(Pharmacy unit) {
		if(receiptList.containsKey(unit))
			return receiptList.get(unit);
		
		Receipt receipt = new Receipt(unit);
		receiptList.put(unit, receipt);
		return receipt;
		
	}
	
	public static int numberOfReceipts() {
		return receiptList.size();
	}

}
