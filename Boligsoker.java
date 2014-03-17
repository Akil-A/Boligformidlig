
public class Boligsoker extends Person {
	
	private int antallPersoner;
	private String sivilstatus;
	private String yrke;
	private String arbeidsforhold;
	private boolean royker;
	private boolean husdyr;
	private int boareal;
	private int antallRom;
	private String byggeaar;
	private String utleiepris;
	
	public Boligsoker(int antallPersoner, String sivilstatus, String yrke, String arbeidsforhold, boolean royker,boolean husdyr, int boareal, int antallRom, String byggeaar, String utleiepris, String navn, String adresse, String email, String telefon)
	{
		super(navn,adresse,email,telefon);
		
		this.antallPersoner = antallPersoner;
		this.sivilstatus = sivilstatus;
		this.yrke = yrke;
		this.arbeidsforhold = arbeidsforhold;
		this.royker = royker;
		this.husdyr = husdyr;
		this.boareal = boareal;
		this.antallRom = antallRom;
		this.byggeaar = byggeaar;
		this.utleiepris = utleiepris;
	}

	public int getAntallPersoner() {
		return antallPersoner;
	}

	public void setAntallPersoner(int antallPersoner) {
		this.antallPersoner = antallPersoner;
	}

	public String getSivilstatus() {
		return sivilstatus;
	}

	public void setSivilstatus(String sivilstatus) {
		this.sivilstatus = sivilstatus;
	}

	public String getYrke() {
		return yrke;
	}

	public void setYrke(String yrke) {
		this.yrke = yrke;
	}

	public String getArbeidsforhold() {
		return arbeidsforhold;
	}

	public void setArbeidsforhold(String arbeidsforhold) {
		this.arbeidsforhold = arbeidsforhold;
	}

	public boolean isRoyker() {
		return royker;
	}

	public void setRoyker(boolean royker) {
		this.royker = royker;
	}

	public boolean isHusdyr() {
		return husdyr;
	}

	public void setHusdyr(boolean husdyr) {
		this.husdyr = husdyr;
	}

	public int getBoareal() {
		return boareal;
	}

	public void setBoareal(int boareal) {
		this.boareal = boareal;
	}

	public int getAntallRom() {
		return antallRom;
	}

	public void setAntallRom(int antallRom) {
		this.antallRom = antallRom;
	}

	public String getByggeaar() {
		return byggeaar;
	}

	public void setByggeaar(String byggeaar) {
		this.byggeaar = byggeaar;
	}

	public String getUtleiepris() {
		return utleiepris;
	}

	public void setUtleiepris(String utleiepris) {
		this.utleiepris = utleiepris;
	}
}

