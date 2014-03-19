public class Utleier extends Person 
{

	private String firma;
	private Boligliste boligliste;
	
	public Utleier (String fornavn, String etternavn, String adresse, int postnr, String poststed, String email, String telefon)
	{
		super(fornavn, etternavn, adresse, postnr, poststed, email, telefon);
		boligliste = new Boligliste();
	}
	
	public String getFirma() 
	{
		return firma;
	}
	
	public void setFirma(String firma) 
	{
		this.firma = firma;
	}
	
	public Boligliste getBoligliste() 
	{
		return boligliste;
	}
	
	public void setBoligliste(Boligliste boligliste) 
	{
		this.boligliste = boligliste;
	}
}
