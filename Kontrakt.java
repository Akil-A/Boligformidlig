import java.io.Serializable;
import java.util.Date;

public class Kontrakt implements Serializable
{
	private int kontraktNr;
	private static int kontraktTeller = 0;
	
	private int utleierNr;
	private int leietakerNr; // leietaker er det samme som boligsoker
	private int boligNr;
	private Date startdato;
	private Date sluttdato;
	private Date oppsagtDato;
	private String oppsigelsesgrunn;
	
	public Kontrakt(int utleierNr, int leietakerNr, int boligNr, Date startdato, Date sluttdato)
	{
		kontraktNr = kontraktTeller++;
		
		this.utleierNr = utleierNr;
		this.leietakerNr = leietakerNr;
		this.boligNr = boligNr;
		this.startdato = startdato;
		this.sluttdato = sluttdato;
	}

	public int getKontraktNr()
	{
		return kontraktNr;
	}

	public int getUtleierNr()
	{
		return utleierNr;
	}

	public void setUtleier(int utleierNr)
	{
		this.utleierNr = utleierNr;
	}

	public int getLeietakerNr()
	{
		return leietakerNr;
	}

	public void setLeietakerNr(int leietakerNr)
	{
		this.leietakerNr = leietakerNr;
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
}
