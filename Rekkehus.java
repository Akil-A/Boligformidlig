public class Rekkehus extends Bolig
{
		private int antetasjer;
		private boolean kjeller;
		private int tomtestr;
	
	public Rekkehus(int antetasjer, boolean kjeller, int tomtestr,String adresse, int postnr, String poststed, int boareal, int antrom,String byggeaar,String beskrivelse, int utleiepris, int aar, int maaned, int dag)
	{
	
		super(adresse, postnr, poststed, boareal,antrom,byggeaar,beskrivelse,utleiepris,aar,maaned,dag);	
	
			this.antetasjer = antetasjer;
			this.kjeller = kjeller;
			this.tomtestr = tomtestr;
	}
	
	public int getAntetasjer() 
	
	{
		return antetasjer;
	}
	
	public void setAntetasjer(int antetasjer) 
	
	{
		this.antetasjer = antetasjer;
	}
	
	public boolean isKjeller() 
	
	{
		return kjeller;
	}
	
	public void setKjeller(boolean kjeller) 
	
	{
		this.kjeller = kjeller;
	}
	
	public int getTomtestr() 
	
	{
		return tomtestr;
	}
	
	public void setTomtestr(int tomtestr) 
	
	{
		this.tomtestr = tomtestr;
	}
	
	
	public String toString()
	
	{
		return super.toString() +
			"\nAntall etasjer: " + antetasjer +
			"\nKjeller: " + (kjeller ? "ja" : "nei") +
			"\nTomtestr.: " + tomtestr + " kvm";
	}

}
