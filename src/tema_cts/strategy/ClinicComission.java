package tema_cts.strategy;

public class ClinicComission implements Comission {

	@Override
	public float getComissionValue() {
		return 3.5f;
	}

	@Override
	public String getDescription() {
		return "This medical prescription has "+getComissionValue()+"% comission";
	}

}
