public class Bolig 
{
	private int boligNr;
	private static int boligTeller = 0;
	
	private String adresse;
	private int postnr;
	private String poststed;
	private int boareal;
	private int antrom;
	private String byggeaar;
	private String beskrivelse;
	private int utleiepris;
	private int aar;
	private int maaned;
	private int dag;
	
	public Bolig(String adresse, int postnr, String poststed, int boareal, int antrom,String byggeaar,String beskrivelse, int utleiepris, int aar, int maaned, int dag)
	{
		boligNr = boligTeller++;
		
		this.adresse = adresse;
		this.postnr = postnr;
		this.poststed = poststed;
		this.boareal = boareal;
		this.antrom = antrom;
		this.byggeaar = byggeaar;
		this.beskrivelse = beskrivelse;
		this.utleiepris = utleiepris;
		this.aar = aar;
		this.maaned = maaned;
		this.dag = dag;
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
	
	public void setAar(int aar) 
	{
		this.aar = aar;
	}
	
	public int getAar()
	{
		return aar;
	}
	
	public void setMaaned(int maaned) 
	{
		this.maaned = maaned;
	}
	
	public int getMaaned()
	{
		return maaned;
	}
	
	public void setDag(int dag)
	{
		this.dag = dag;
	}
	
	public int getDag()
	{
		return dag;
	}
	public String toString()
	{
		String s = "Boareal: " + boareal + "/n"
				+ "Antall rom: " + antrom + "/n"
				+ "Byggaar: " + byggeaar + "/n"
				+ "Beskrivelse: " + beskrivelse + "/n"
				+ "Utleiepris: " + utleiepris + "/n"
				+ "AAr: " + aar + "."
				+ "maaned: " + "." 
				+ "Dag: " + dag;
		return s;
	}
}
