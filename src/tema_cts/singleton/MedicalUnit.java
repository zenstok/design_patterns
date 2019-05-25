package tema_cts.singleton;

public class MedicalUnit {
	private String name;
	private String address;
	private MedicalUnitType type;
	private String apiKey;
	private boolean enabled = false;
	
	public MedicalUnit(String name, String address, String apiKey, MedicalUnitType type) {
		super();
		this.name = name;
		this.address = address;
		this.type = type;
		this.apiKey = apiKey;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public MedicalUnitType getType() {
		return type;
	}

	public void setType(MedicalUnitType type) {
		this.type = type;
	}

	public boolean isEnabled() {
		return enabled == true ? true : false;
	}
	
	public void setEnabled(boolean value) {
		this.enabled = value;
	}
		
}
