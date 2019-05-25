package tema_cts.observer;

import tema_cts.singleton.Prescription;

public class RequestEvent extends AbstractEvent {
	private String apiKey;
	private Prescription prescription;
	
	public RequestEvent(String apiKey, Prescription prescription) {
		super();
		this.apiKey = apiKey;
		this.prescription = prescription;
	}

	public String getApiKey() {
		return apiKey;
	}

	public Prescription getPrescription() {
		return prescription;
	}

	public void makeRequest() throws Exception {
		System.out.println("A request is happening...");
		this.notifySubscribers();
	}
}
