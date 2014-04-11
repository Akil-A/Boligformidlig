import java.io.Serializable;

public class Enebolig extends Bolig implements Serializable
{
	private int antetasjer;
	private boolean kjeller;
	private int tomtestr;

	public Enebolig(String adresse, int postnr, String poststed, int utleiepris)
	{
		super(adresse, postnr, poststed, utleiepris);
	}
	
	public void setAntetasjer(int antetasjer)
	{
		this.antetasjer = antetasjer;
	}
	public int getAntetasjer()
	{
		return antetasjer;
	}
	
	public void setKjeller(boolean kjeller)
	
	{
		this.kjeller = kjeller;
	}
	
	public boolean isKjeller() 
	
	{
		return kjeller;
	}
	
	public void setTomtestr(int tomtestr)
	
	{
		this.tomtestr = tomtestr;
	}
	
	public int getTomtestr() 
	{
		return tomtestr;
	}
	
	
	public String toString()
	{
		return super.toString() +
				"\nAntall etasjer: " + antetasjer +
				"\nKjeller: " + (kjeller ? "ja" : "nei") +
				"\nTomtestr.: " + tomtestr + " kvm";
	}

}

