// Klasse for bolig av typen leilighet

public class Leilighet extends Bolig
{
	private static final long serialVersionUID = 1L;
	
	private Integer etasje;
	private Boolean heis;
	private Boolean balkong;
	private Boolean garasje;
	private Boolean vaskeri;
	 
	public Leilighet(String adresse, String postnr, String poststed, int utleiepris)
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
	
	public Boolean getHeis() 
	{
		return heis;
	}
	
	public void setHeis(Boolean h) 
	{
		heis = h;
	}
	
	public Boolean getBalkong() 
	{
		return balkong;
	}
	
	public void setBalkong(Boolean b) 
	{
		balkong = b;
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
