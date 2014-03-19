import java.util.Date;

abstract public class Bolig 
{
	private int boligNr;
	private static int boligTeller = 0;
	private Date annonsedato;
	
	private String adresse;
	private int postnr;
	private String poststed;
	private int boareal;
	private int antrom;
	private String byggeaar;
	private String beskrivelse;
	private int utleiepris;
	
	public Bolig(String adresse, int postnr, String poststed, int boareal, int antrom, String byggeaar, String beskrivelse, int utleiepris)
	{
		boligNr = boligTeller++;
		annonsedato = new Date();
		
		this.adresse = adresse;
		this.postnr = postnr;
		this.poststed = poststed;
		this.boareal = boareal;
		this.antrom = antrom;
		this.byggeaar = byggeaar;
		this.beskrivelse = beskrivelse;
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
	
	public void setByggeaar(String byggeaar) 
	{
		this.byggeaar = byggeaar;
	}
	
	public String getByggeaar()
	{
		return byggeaar;
	}
	
	public void setBeskrivelse(String beskrivelse) 
	{
		this.beskrivelse = beskrivelse;
	}
	
	public String getBeskrivelse()
	{
		return beskrivelse;
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
		String s = "Boareal: " + boareal +
					"\nAntall rom: " + antrom +
					"\nByggeår: " + byggeaar +
					"\nBeskrivelse: " + beskrivelse +
					"\nUtleiepris: " + utleiepris +
					"\nAnnonsen lagt ut: " + annonsedato;
		return s;
	}
}
