package tema_cts.strategy;

public class HospitalComission implements Comission {

	@Override
	public float getComissionValue() {
		return 5;
	}

	@Override
	public String getDescription() {
		return "This medical prescription has "+getComissionValue()+"% comission";
	}

}
