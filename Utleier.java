// Klasse for person som er utleier
// Laget av Akil
// Sist oppdatert 10/5

public class Utleier extends Person
{
	private static final long serialVersionUID = 1L;
	
	private String firma;
	
	public Utleier (String fornavn, String etternavn, String adresse, String postnr, String poststed, String email, String telefon)
	{
		super(fornavn, etternavn, adresse, postnr, poststed, email, telefon);
	}
	
	public String getFirma()
	{
		return firma;
	}
	
	public void setFirma(String firma) 
	{
		this.firma = firma;
	}
}
