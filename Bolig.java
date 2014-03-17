public class Bolig 
{
private String adresse;

private int boareal;
private int antrom;
private String byggeaar;
private String beskrivelse;
private int utleiepris;
private int aar;
private int maaned;
private int dag;

public Bolig(String adresse, int boareal, int antrom,String byggeaar,String beskrivelse, int utleiepris, int aar, int maaned, int dag)
{
	this.adresse = adresse;
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
	String s  "Boareal: " + boareal + "/n"
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
}
