import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

abstract public class Bolig implements Serializable
{
	private Date annonsedato;
	private ArrayList<Boligsoker> interesserte;
	
	private Utleier utleier;
	private String adresse;
	private String postnr;
	private String poststed;
	private int utleiepris;
	private String togst;
	private int boareal;
	private int antrom;
	private int byggeaar;
	private String tittel;
	private String bildefilnavn;
	
	public Bolig(String adresse, String postnr, String poststed, int utleiepris)
	{
		annonsedato = new Date();
		
		this.adresse = adresse;
		this.postnr = postnr;
		this.poststed = poststed;
		this.utleiepris = utleiepris;
	}
	
	public Date getAnnonsedato()
	{
		return annonsedato;
	}
	
	public ArrayList<Boligsoker> getInteresserte()
	{
		return interesserte;
	}
	
	public void leggtilInteressert(Boligsoker b)
	{
		interesserte.add(b);
	}
	
	public boolean fjernInteressert(Boligsoker b)
	{
		return interesserte.remove(b);
	}
	
	public Utleier getUtleier()
	{
		return utleier;
	}
	
	public void setUtleier(Utleier u)
	{
		utleier = u;
	}
	
	public String getBildefilnavn()
	{
		return bildefilnavn;
	}
	
	public void setBildefilnavn(String n)
	{
		bildefilnavn = n;
	}
	
	public String getTittel() 
	{
		return tittel;
	}
	
	public void setTittel(String tittel) 
	{
		this.tittel = tittel;
	}
	
	public void setAdresse(String adresse) 
	{
		this.adresse = adresse;
	}
	
	public String getAdresse()
	{
		return adresse;
	}
	
	public void setPostnr(String postnr) 
	{
		this.postnr = postnr;
	}
	
	public String getPostnr() 
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
}
