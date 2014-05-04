
public class Boligsoker extends Person
{
    private int antallPersoner;
    private String sivilstatus;
    private String yrke;
    private String arbeidsforhold;
    private boolean royker;
    private boolean husdyr;
    private boolean kravEnebolig;
    private boolean kravRekkehus;
    private boolean kravLeilighet;
    private int kravArealFra;
    private int kravArealTil;
    private int kravMinAntRom;
    private int kravMinByggeaar;
    private int kravMaksPris;
    
    public Boligsoker(String fornavn, String etternavn, String adresse, String postnr, String poststed, String email, String telefon)
    {
        super(fornavn, etternavn, adresse, postnr, poststed, email, telefon);
    }

    public int getAntallPersoner()
    {
        return antallPersoner;
    }

    public void setAntallPersoner(int antallPersoner)
    {
        this.antallPersoner = antallPersoner;
    }

    public String getSivilstatus()
    {
        return sivilstatus;
    }

    public void setSivilstatus(String sivilstatus)
    {
        this.sivilstatus = sivilstatus;
    }

    public String getYrke()
    {
        return yrke;
    }

    public void setYrke(String yrke)
    {
        this.yrke = yrke;
    }

    public String getArbeidsforhold()
    {
        return arbeidsforhold;
    }

    public void setArbeidsforhold(String arbeidsforhold)
    {
        this.arbeidsforhold = arbeidsforhold;
    }

    public boolean getRoyker()
    {
        return royker;
    }

    public void setRoyker(boolean royker)
    {
        this.royker = royker;
    }

    public boolean getHusdyr()
    {
        return husdyr;
    }

    public void setHusdyr(boolean husdyr)
    {
        this.husdyr = husdyr;
    }

	public boolean getKravEnebolig()
	{
		return kravEnebolig;
	}

	public void setKravEnebolig(boolean kravEnebolig)
	{
		this.kravEnebolig = kravEnebolig;
	}

	public boolean getKravRekkehus()
	{
		return kravRekkehus;
	}

	public void setKravRekkehus(boolean kravRekkehus)
	{
		this.kravRekkehus = kravRekkehus;
	}

	public boolean getKravLeilighet()
	{
		return kravLeilighet;
	}

	public void setKravLeilighet(boolean kravLeilighet)
	{
		this.kravLeilighet = kravLeilighet;
	}

	public int getKravArealFra()
	{
		return kravArealFra;
	}

	public void setKravArealFra(int kravArealFra)
	{
		this.kravArealFra = kravArealFra;
	}

	public int getKravArealTil()
	{
		return kravArealTil;
	}

	public void setKravArealTil(int kravArealTil)
	{
		this.kravArealTil = kravArealTil;
	}

	public int getKravMinAntRom()
	{
		return kravMinAntRom;
	}

	public void setKravMinAntRom(int kravMinAntRom)
	{
		this.kravMinAntRom = kravMinAntRom;
	}

	public int getKravMinByggeaar()
	{
		return kravMinByggeaar;
	}

	public void setKravMinByggeaar(int kravMinByggeaar)
	{
		this.kravMinByggeaar = kravMinByggeaar;
	}

	public int getKravMaksUtleiepris()
	{
		return kravMaksPris;
	}

	public void setKravMaksUtleiepris(int kravMaksPris)
	{
		this.kravMaksPris = kravMaksPris;
	}
}
