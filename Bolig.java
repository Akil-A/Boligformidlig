import java.io.Serializable;
import java.util.Date;

abstract public class Bolig implements Serializable
{
	private int boligNr;
	private static int boligTeller = 0;
	private Date annonsedato;
	
	private String adresse;
	private int postnr;
	private String poststed;
	private int utleiepris;
	private String togst;
	private int boareal;
	private int antrom;
	private int byggeaar;
	private String tittel;
	private String bildefilnavn;
	
	public Bolig(String adresse, int postnr, String poststed, int utleiepris)
	{
		boligNr = boligTeller++;
		annonsedato = new Date();
		
		this.adresse = adresse;
		this.postnr = postnr;
		this.poststed = poststed;
		this.utleiepris = utleiepris;
	}
	
	public int getBoligNr()
	{
		return boligNr;
	}
	
	public Date getAnnonsedato()
	{
		return annonsedato;
	}
	
	public String getBildefilnavn()
	{
		return bildefilnavn;
	}
	
	public void setBildefilnavn(String n)
	{
		bildefilnavn = n;
	}
	
	public void setTittel(String tittel) 
	{
		this.tittel = tittel;
	}
	
	public String getBeskrivelse()
	{
		return tittel;
	}
	
	public void setAdresse(String adresse) 
	{
		this.adresse = adresse;
	}
	
	public String getAdresse()
	{
		return adresse;
	}
	
	public void setPostnr(int postnr) 
	{
		this.postnr = postnr;
	}
	
	public int getPostnr() 
	{
		return postnr;
	}
	
	public String getPoststed() {
		return poststed;
	}
	
	public void setPoststed(String poststed) {
		this.poststed = poststed;
	}
	
	public String getTogst() {
		return togst;
	}
	
	public void setTogst(String t) {
		this.togst = t;
	}
	
	public void setAntrom(int antrom) 
	{
		this.antrom = antrom;
	}
	
	public int getAntrom()
	{
		return antrom;
	}
	
	public void setBoareal(int boareal) 
	{
		this.boareal = boareal;
	}
	
	public int getBoareal()
	{
		return boareal;
	}
	
	public void setByggeaar(int byggeaar) 
	{
		this.byggeaar = byggeaar;
	}
	
	public int getByggeaar()
	{
		return byggeaar;
	}
	
	public void setUtleiepris(int utleiepris) 
	{
		this.utleiepris = utleiepris;
	}
	
	public int getUtleiepris()
	{
		return utleiepris;
	}
	
	public String toString()
	{
		String s = "Naermeste togstasjon: " + togst +
					"\nBoareal: " + boareal +
					"\nAntall rom: " + antrom +
					"\nByggeår: " + byggeaar +
					"\nTittel: " + tittel +
					"\nUtleiepris: " + utleiepris +
					"\nAnnonsen lagt ut: " + annonsedato;
		return s;
	}
}
