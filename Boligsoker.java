
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

	public String getSivilstatus() {
		return sivilstatus;
	}

	public String getYrke() {
		return yrke;
	}

	public String getArbeidsforhold() {
		return arbeidsforhold;
	}

	public boolean isRoyker() {
		return royker;
	}

	public boolean isHusdyr() {
		return husdyr;
	}

	public int getBoareal() {
		return boareal;
	}

	public int getAntallRom() {
		return antallRom;
	}

	public String getByggeaar() {
		return byggeaar;
	}

	public String getUtleiepris() {
		return utleiepris;
	}	
}

