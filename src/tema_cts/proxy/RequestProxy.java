package tema_cts.proxy;

import java.util.ArrayList;

import tema_cts.observer.AbstractEventSubscriber;
import tema_cts.singleton.ApiManager;
import tema_cts.singleton.MedicalUnit;

public class RequestProxy extends AbstractEventSubscriber {
	static boolean validateApiKey(String apiKey) throws Exception {
		ArrayList<MedicalUnit> medicalUnits = ApiManager.getInstance().getMedicalUnits();
		for(MedicalUnit mu: medicalUnits) {
			if(apiKey == mu.getApiKey()) {
				return true;
			}
		}
		return false;
	}
}
