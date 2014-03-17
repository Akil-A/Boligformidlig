public class Utleier extends Person {
	
	private String firma;
	private Boligliste boligliste;
	
	public Utleier (String navn, String adresse, String email, String telefon, String firma, Boligliste boligliste)
	{
		super(navn, adresse, email, telefon);
	}

	public String getFirma() {
		return firma;
	}

	public void setFirma(String firma) {
		this.firma = firma;
	}

	public Boligliste getBoligliste() {
		return boligliste;
	}

	public void setBoligliste(Boligliste boligliste) {
		this.boligliste = boligliste;
	}
}
