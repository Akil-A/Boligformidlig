// Klasse for bolig av typen rekkehus

public class Rekkehus extends Bolig
{
	private static final long serialVersionUID = 1L;
	
	private Integer tomtestr;
	private Integer antetasjer;
	private Boolean kjeller;
	
	public Rekkehus(String adresse, String postnr, String poststed, int utleiepris)
	{
		super(adresse, postnr, poststed, utleiepris);
	}
	
	public void setTomtestr(Integer tomtestr)
	{
		this.tomtestr = tomtestr;
	}
	
	public Integer getTomtestr() 
	{
		return tomtestr;
	}
	
	public void setAntetasjer(Integer antetasjer)
	{
		this.antetasjer = antetasjer;
	}
	public Integer getAntetasjer()
	{
		return antetasjer;
	}
	
	public void setKjeller(Boolean kjeller)
	{
		this.kjeller = kjeller;
	}
	
	public Boolean isKjeller() 
	{
		return kjeller;
	}
}
