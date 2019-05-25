package tema_cts.proxy;

import java.util.Date;

import tema_cts.observer.AbstractEvent;
import tema_cts.observer.EventHandler;
import tema_cts.observer.RequestEvent;
import tema_cts.singleton.ApiManager;
import tema_cts.singleton.Prescription;

public class RequestHandler implements EventHandler {

	@Override
	public void handleEvent(AbstractEvent event) throws Exception {
		if(event instanceof RequestEvent) {
			RequestEvent requestEvent = (RequestEvent) event;
			String apiKey = requestEvent.getApiKey();
			Prescription prescription = requestEvent.getPrescription();
			
			if(RequestProxy.validateApiKey(apiKey)) {
				ApiManager.getInstance().processApiRequestData(apiKey, prescription);
			} else {
				Log.addMessage("Request with an unauthorized key at "+ (new Date(System.currentTimeMillis()).toString()));
			}
			
		} else {
			throw new Exception("Expected event parameter to be an instance of RequestEvent");
		}
		
	}

}
