
public class Kontrakt 
{
	private Utleier utleier;
	private Boligsoker leietaker;
	private Bolig bolig;
	private String startdato;
	private String sluttdato;
	
	public Kontrakt(Utleier utleier, Boligsoker leietaker, Bolig bolig, String startdato, String sluttdato)
	{
		this.utleier = utleier;
		this.leietaker = leietaker;
		this.bolig = bolig;
		this.startdato = startdato;
		this.sluttdato = sluttdato;
	}

	public Utleier getUtleier() {
		return utleier;
	}

	public void setUtleier(Utleier utleier) {
		this.utleier = utleier;
	}

	public Boligsoker getLeietaker() {
		return leietaker;
	}

	public void setLeietaker(Boligsoker leietaker) {
		this.leietaker = leietaker;
	}

	public Bolig getBolig() {
		return bolig;
	}

	public void setBolig(Bolig bolig) {
		this.bolig = bolig;
	}

	public String getStartdato() {
		return startdato;
	}

	public void setStartdato(String startdato) {
		this.startdato = startdato;
	}

	public String getSluttdato() {
		return sluttdato;
	}

	public void setSluttdato(String sluttdato) {
		this.sluttdato = sluttdato;
	}
}
