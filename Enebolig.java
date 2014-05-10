// Klasse for bolig av typen enebolig

public class Enebolig extends Bolig
{
	private static final long serialVersionUID = 1L;
	
	private Integer tomtestr;
	private Integer antetasjer;
	private Boolean kjeller;

	public Enebolig(String adresse, String postnr, String poststed, int utleiepris)
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

