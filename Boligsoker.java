package prosjekttest;


public class Boligsoker extends Person
{
    private int antallPersoner;
    private String sivilstatus;
    private String yrke;
    private String arbeidsforhold;
    private boolean royker;
    private boolean husdyr;
    private boolean hage;
    private boolean heis;
    private boolean balkong;
    private boolean parkering;
    private boolean enebolig;
    private boolean rekkehus;
    private boolean leilighet;
    private int fraStorrelse;
    private int tilStorrelse;
    private int antallRom;
    private String byggeaar;
    private int utleiepris;
    private String firma;
    private String togst;
    
    public Boligsoker(String fornavn, String etternavn, String adresse, int postnr, String poststed, String email, String telefon)
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

    public boolean isRoyker()
    {
        return royker;
    }

    public void setRoyker(boolean royker)
    {
        this.royker = royker;
    }

    public boolean isHusdyr()
    {
        return husdyr;
    }

    public void setHusdyr(boolean husdyr)
    {
        this.husdyr = husdyr;
    }

    public int getAntallRom()
    {
        return antallRom;
    }

    public void setAntallRom(int antallRom)
    {
        this.antallRom = antallRom;
    }

    public String getByggeaar()
    {
        return byggeaar;
    }

    public void setByggeaar(String byggeaar)
    {
        this.byggeaar = byggeaar;
    }

    public int getUtleiepris()
    {
        return utleiepris;
    }

    public void setUtleiepris(int utleiepris)
    {
        this.utleiepris = utleiepris;
    }

    public int getFraStorrelse()
    {
        return fraStorrelse;
    }

    public void setFraStorrelse(int fraStorrelse)
    {
        this.fraStorrelse = fraStorrelse;
    }

    public int getTilStorrelse()
    {
        return tilStorrelse;
    }


    public void setTilStorrelse(int tilStorrelse)
    {
        this.tilStorrelse = tilStorrelse;
    }

    public String getFirma()
    {
        return firma;
    }

    public void setFirma(String firma)
    {
        this.firma = firma;
    }
    
    public String getTogst()
    {
        return togst;
    }

    public void setTogst (String t)
    {
        this.togst = t;
    }

	public boolean isHage() {
		return hage;
	}

	public void setHage(boolean hage) {
		this.hage = hage;
	}

	public boolean isHeis() {
		return heis;
	}

	public void setHeis(boolean heis) {
		this.heis = heis;
	}

	public boolean isParkering() {
		return parkering;
	}

	public void setParkering(boolean parkering) {
		this.parkering = parkering;
	}

	public boolean isBalkong() {
		return balkong;
	}

	public void setBalkong(boolean balkong) {
		this.balkong = balkong;
	}

	public boolean isEnebolig() {
		return enebolig;
	}

	public void setEnebolig(boolean enebolig) {
		this.enebolig = enebolig;
	}

	public boolean isRekkehus() {
		return rekkehus;
	}

	public void setRekkehus(boolean rekkehus) {
		this.rekkehus = rekkehus;
	}

	public boolean isLeilighet() {
		return leilighet;
	}

	public void setLeilighet(boolean leilighet) {
		this.leilighet = leilighet;
	}
}
