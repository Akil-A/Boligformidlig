import java.io.Serializable;

public class Leilighet extends Bolig implements Serializable
{
	 private Integer etasje;
	 private Boolean garasje;
	 private Boolean vaskeri;
	 
	 public Leilighet(String adresse, int postnr, String poststed, int utleiepris)
	 {
		super(adresse, postnr, poststed, utleiepris);
	 }
	
	public Integer getEtasje()
	{
		return etasje;
	}
	
	public void setEtasje(Integer etasje) 
	{
		this.etasje = etasje;
	}
	
	public Boolean getGarasje() 
	{
		return garasje;
	}
	
	public void setGarasje(Boolean g) 
	{
		garasje = g;
	}
	
	public Boolean getVaskeri() 
	{
		return vaskeri;
	}
	
	public void setVaskeri(Boolean v) 
	{
		vaskeri = v;
	}
}
