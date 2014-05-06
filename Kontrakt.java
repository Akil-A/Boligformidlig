import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Kontrakt implements Serializable
{
	private Boligsoker leietaker;
	private Bolig bolig;
	private Calendar startdato;
	private Calendar sluttdato;
	private Calendar oppsagtDato;
	private Date skrevetDato;
	private String oppsigelsesgrunn;
	
	public Kontrakt(Boligsoker leietaker, Bolig bolig, Calendar startdato, Calendar sluttdato)
	{
		skrevetDato = new Date();
		
		this.leietaker = leietaker;
		this.bolig = bolig;
		this.startdato = startdato;
		this.sluttdato = sluttdato;
	}
	
	public boolean getFungerer()
	{
		Calendar cal = Calendar.getInstance();
		return sluttdato.after(cal) && (oppsagtDato == null || oppsagtDato.after(cal));
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

	public Calendar getStartdato()
	{
		return startdato;
	}

	public void setStartdato(Calendar startdato)
	{
		this.startdato = startdato;
	}

	public Calendar getSluttdato()
	{
		return sluttdato;
	}

	public void setSluttdato(Calendar sluttdato)
	{
		this.sluttdato = sluttdato;
	}

	public Calendar getOppsagtDato()
	{
		return oppsagtDato;
	}

	public void setOppsagtDato(Calendar oppsagtDato)
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
