
public class Person {
	
	private String navn;
	private String adresse;
	private String email;
	private String telefon;
	
	public Person(String navn, String adresse, String email, String telefon)
	{
		this.navn = navn;
		this.adresse = adresse;
		this.email = email;
		this.telefon = telefon;
	}
	
	public String getNavn()
	{
		return navn;
	}
	
	public String getAdresse()
	{
		return adresse;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getTelefon()
	{
		return telefon;
	}
	
}
