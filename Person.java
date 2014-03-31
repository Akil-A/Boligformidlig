abstract public class Person
{
	private int personNr;
	private static int personTeller = 0;
	
	private String fornavn;
	private String etternavn;
	private String adresse;
	private String email;
	private String telefon;
	private String poststed;
	private String yrke;
	private int postnr;
	
	public Person(String fornavn, String etternavn, String adresse, int postnr, String poststed, String email, String telefon)
	{
		personNr = personTeller++;
		
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.adresse = adresse;
		this.email = email;
		this.telefon = telefon;
		this.poststed = poststed;
		this.postnr = postnr;
	}
	
	public int getPersonNr()
	{
		return personNr;
	}
	
	public String getFornavn()
	{
		return fornavn;
	}
	
	public void setFornavn(String fornavn)
	{
		this.fornavn = fornavn;
	}
	
	public String getEtternavn()
	{
		return etternavn;
	}
	
	public void setEtternavn(String etternavn)
	{
		this.etternavn = etternavn;
	}
	
	public String getAdresse()
	{
		return adresse;
	}
	
	public void setAdresse(String adresse)
	{
		this.adresse = adresse;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getTelefon()
	{
		return telefon;
	}
	
	public void setTelefon(String telefon)
	{
		this.telefon = telefon;
	}
	
	public String getPoststed()
	{
		return poststed;
	}
	
	public void setPoststed(String poststed)
	{
		this.poststed = poststed;
	}
	
	public int getPostnr()
	{
		return postnr;
	}
	
	public void setPostnr(int postnr)
	{
		this.postnr = postnr;
	}
	
	public String getYrke()
	{
		return yrke;
	}
	
	public void setyrke(String yrke)
	{
		this.postnr = postnr;
	}
}
