package tema_cts.singleton;

import java.util.ArrayList;
import java.util.HashMap;

import tema_cts.strategy.Comission;

public class Prescription {
	private String doctor;
	private HashMap<String, Float> randuriMedicamente = new HashMap<>();
	private Comission comission;
	
	//lista prescriptii medicale
	public static ArrayList<Prescription> prescriptions = new ArrayList<Prescription>();
	
	public Prescription() {
		super();
	}

	public Prescription(String doctor, HashMap<String, Float> randuriMedicamente) {
		super();
		this.doctor = doctor;
		this.randuriMedicamente = randuriMedicamente;
	}

	public float getTotal() {
		float total = 0F;
		for(Float valoare: randuriMedicamente.values()) {
			total+=valoare.floatValue();
		}
		return total;
	}

	public Comission getComission() {
		return comission;
	}

	public void setComission(Comission comission) {
		this.comission = comission;
	}

	public String getDoctor() {
		return doctor;
	}
	
	
}
