import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Kontrakt implements Serializable
{
	private Boligsoker leietaker;
	private Bolig bolig;
	private Calendar startdato;
	private Calendar sluttdato;
	private Calendar oppsigelsesdato;
	private String oppsigelsesgrunn;
	
	public Kontrakt(Boligsoker leietaker, Bolig bolig, Calendar sluttdato)
	{
		this.leietaker = leietaker;
		this.bolig = bolig;
		this.startdato = Calendar.getInstance();
		this.sluttdato = sluttdato;
	}
	
	public boolean getFungerer()
	{
		Calendar cal = Calendar.getInstance();
		return sluttdato.after(cal) && (oppsigelsesdato == null || oppsigelsesdato.after(cal));
	}

	public Boligsoker getLeietaker()
	{
		return leietaker;
	}

	public Bolig getBolig()
	{
		return bolig;
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

	public Calendar getOppsigelsesdato()
	{
		return oppsigelsesdato;
	}

	public void setOppsigelsesdato(Calendar oppsigelsesdato)
	{
		this.oppsigelsesdato = oppsigelsesdato;
	}

	public String getOppsigelsesgrunn()
	{
		return oppsigelsesgrunn;
	}

	public void setOppsigelsesgrunn(String oppsigelsesgrunn)
	{
		this.oppsigelsesgrunn = oppsigelsesgrunn;
	}
}
