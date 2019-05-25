package tema_cts.singleton;

import java.util.ArrayList;
import java.util.Iterator;

import tema_cts.strategy.ClinicComission;
import tema_cts.strategy.HospitalComission;

public class ApiManager {
	//pharma specific
	private ArrayList<MedicalUnit> medicalUnits = new ArrayList<>();
	
	public void removeMedicalUnit(MedicalUnit mu) {
		medicalUnits.remove(mu);
	}
	
	public void addMedicalUnit(MedicalUnit mu) {
		medicalUnits.add(mu);
	}
	
	public int numberOfMedicalUnits() {
		return medicalUnits.size();
	}
	
	public void removeMedicalUnitsWithExpiredContract() {
		Iterator<MedicalUnit> iter = medicalUnits.iterator();
		while(iter.hasNext()) {
		    MedicalUnit mu = iter.next();
		    if (mu.isEnabled() == false) {
		        iter.remove();
		    }
		}
	}
	
	public ArrayList<MedicalUnit> getMedicalUnits() {
		return medicalUnits;
	}
	
	private MedicalUnit findMedicalUnitFromApiKey(String apiKey) {
		for(MedicalUnit mu: medicalUnits) {
			if(mu.getApiKey() == apiKey) {
				return mu;
			}
		}
		return null;
	}
	
	public void processApiRequestData(String apiKey, Prescription prescription) {
		MedicalUnit mu = findMedicalUnitFromApiKey(apiKey);
		//setam strategia pentru prescriptia medicala primita
		if(mu.getType() == MedicalUnitType.CLINICA) {
			prescription.setComission(new ClinicComission());
			Prescription.prescriptions.add(prescription);
		} else {
			prescription.setComission(new HospitalComission());
			Prescription.prescriptions.add(prescription);
		}
		
	}
	//end pharma specific
	
	private static ApiManager instance = null;
	
	private ApiManager() throws Exception {
		if(instance!=null)
			throw new Exception("Object already created!");
	}
	
	public static ApiManager getInstance() throws Exception {
		if(instance == null) {
			instance = new ApiManager();
		}
		return instance;
	}
	
	
}
