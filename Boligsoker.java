
public class Boligsoker extends Person
{
    private int antallPersoner;
    private String sivilstatus;
    private String yrke;
    private String arbeidsforhold;
    private boolean royker;
    private boolean husdyr;
    private int fraStorrelse;
    private int tilStorrelse;
    private int antallRom;
    private String byggeaar;
    private String utleiepris;

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

    public String getUtleiepris()
    {
        return utleiepris;
    }

    public void setUtleiepris(String utleiepris)
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
}
