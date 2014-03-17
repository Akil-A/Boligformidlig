public class Bolig 
{
private String adresse;
private String boligtype;
private int boareal;
private int antrom;
private String byggeaar;
private String beskrivelse;
private String utleiepris;
private int aar;
private int maaned;
private int dag;

public Bolig(String adresse,String boligtype, int boareal, int antrom,String byggeaar,String beskrivelse, String utleiepris, int aar, int maaned, int dag)
{
	this.adresse = adresse;
	this.boligtype = boligtype;
	this.boareal = boareal;
	this.antrom = antrom;
	this.byggeaar = byggeaar;
	this.beskrivelse = beskrivelse;
	this.utleiepris = utleiepris;
	this.aar = aar;
	this.maaned = maaned;
	this.dag = dag;
}

public String getAdresse()
{
	return adresse;
}
public String getBoligtype()
{
	return boligtype;
}
public int getBoareal()
{
	return boareal;
}
public int getAntrom()
{
	return antrom;
}
public String getByggeaar()
{
	return byggeaar;
}
public String getBeskrivelse()
{
	return beskrivelse;
}
public String getUtleiepris()
{
	return utleiepris;
}
public int getAar()
{
	return aar;
}
public int getMaaned()
{
	return maaned;
}
public int getDag()
{
	return dag;
}
}
