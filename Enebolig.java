public class Enebolig extends Bolig
{
	private int antetasjer;
	private boolean kjeller;
	private int tomtestr;
	
	public Enebolig(int antetasjer, boolean kjeller, int tomtestr,String adresse, int boareal, int antrom,String byggeaar,String beskrivelse, String utleiepris, int aar, int maaned, int dag)
	{
	super(adresse,boareal,antrom,byggeaar,beskrivelse,utleiepris,aar,maaned,dag);	
	
	this.antetasjer = antetasjer;
	this.kjeller = kjeller;
	this.tomtestr = tomtestr;
	}
public int getAntetasjer()
{
	return antetasjer;
}
public boolean getKjeller()
{
	return kjeller;
}
public int getTomtestr()
{
	return tomtestr;
}
}
