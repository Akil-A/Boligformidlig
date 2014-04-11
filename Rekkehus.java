import java.io.Serializable;

public class Rekkehus extends Bolig implements Serializable
{
	private int antetasjer;
	private boolean kjeller;
	private int tomtestr;
	
	public Rekkehus(String adresse, int postnr, String poststed, int utleiepris)
	{
		super(adresse, postnr, poststed, utleiepris);
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
