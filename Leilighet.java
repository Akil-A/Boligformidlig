import java.io.Serializable;

public class Leilighet extends Bolig implements Serializable
{
	 private int etasje;
	 private boolean garasje;
	 private boolean vaskeri;
	 
	 public Leilighet(String adresse, int postnr, String poststed, int utleiepris)
	 {
		super(adresse, postnr, poststed, utleiepris);
	 }
	
	public int getEtasje()
	{
		return etasje;
	}
	
	public void setEtasje(int etasje) 
	{
		this.etasje = etasje;
	}
	
	public boolean getGarasje() 
	{
		return vaskeri;
	}
	
	public void setGarasje(boolean g) 
	{
		garasje = g;
	}
	
	public boolean getVaskeri() 
	{
		return vaskeri;
	}
	
	public void setVaskeri(boolean v) 
	{
		vaskeri = v;
	}
	
	public String toString()
	{
		return super.toString() +
				"\nEtasje: " + etasje +
				"\nGarasje: " + (garasje ? "ja" : "nei") +
				"\nVaskeri: " + (vaskeri ? "ja" : "nei");
	}
}
