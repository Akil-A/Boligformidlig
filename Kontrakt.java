import java.io.Serializable;
import java.util.Date;

public class Kontrakt implements Serializable
{
	private Boligsoker leietaker;
	private Bolig bolig;
	private Date startdato;
	private Date sluttdato;
	private Date oppsagtDato;
	private Date skrevetDato;
	private String oppsigelsesgrunn;
	
	public Kontrakt(Boligsoker leietaker, Bolig bolig, Date startdato, Date sluttdato)
	{
		skrevetDato = new Date();
		
		this.leietaker = leietaker;
		this.bolig = bolig;
		this.startdato = startdato;
		this.sluttdato = sluttdato;
	}
	
	public boolean getFungerer()
	{
		return sluttdato.after(new Date()) && (oppsagtDato == null || oppsagtDato.after(new Date()));
	}

	public Boligsoker getLeietaker()
	{
		return leietaker;
	}

	public void setLeietaker(Boligsoker b)
	{
		this.leietaker = b;
	}

	public Bolig getBolig()
	{
		return bolig;
	}

	public void setBolig(Bolig bolig)
	{
		this.bolig = bolig;
	}

	public Date getStartdato()
	{
		return startdato;
	}

	public void setStartdato(Date startdato)
	{
		this.startdato = startdato;
	}

	public Date getSluttdato()
	{
		return sluttdato;
	}

	public void setSluttdato(Date sluttdato)
	{
		this.sluttdato = sluttdato;
	}

	public Date getOppsagtDato()
	{
		return oppsagtDato;
	}

	public void setOppsagtDato(Date oppsagtDato)
	{
		this.oppsagtDato = oppsagtDato;
	}

	public String getOppsigelsesgrunn()
	{
		return oppsigelsesgrunn;
	}

	public void setOppsigelsesgrunn(String oppsigelsesgrunn)
	{
		this.oppsigelsesgrunn = oppsigelsesgrunn;
	}
	
	public Date getSkrevetDato()
	{
		return skrevetDato;
	}
}
