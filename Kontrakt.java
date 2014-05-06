import java.io.Serializable;
import java.util.Date;

public class Kontrakt implements Serializable
{
	private int kontraktNr;
	private static int kontraktTeller = 0;
	
	private Boligsoker leietaker;
	private int boligNr;
	private Date startdato;
	private Date sluttdato;
	private Date oppsagtDato;
	private Date skrevetDato;
	private String oppsigelsesgrunn;
	
	public Kontrakt(Boligsoker leietaker, int boligNr, Date startdato, Date sluttdato)
	{
		kontraktNr = kontraktTeller++;
		skrevetDato = new Date();
		this.leietaker = leietaker;
		this.boligNr = boligNr;
		this.startdato = startdato;
		this.sluttdato = sluttdato;
		
	}
	
	public boolean getFungerer()
	{
		return sluttdato.after(new Date()) && (oppsagtDato == null || oppsagtDato.after(new Date()));
	}

	public int getKontraktNr()
	{
		return kontraktNr;
	}

	public Boligsoker getLeietaker()
	{
		return leietaker;
	}

	public void setLeietaker(Boligsoker b)
	{
		this.leietaker = b;
	}

	public int getBoligNr()
	{
		return boligNr;
	}

	public void setBoligNr(int boligNr)
	{
		this.boligNr = boligNr;
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

	public Date getSkrevetDato() {
		return skrevetDato;
	}
}
