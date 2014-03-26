public class Leilighet extends Bolig
{
	 private int etasje;
	 private boolean heis;
	 private boolean balkong;
	 private String leilighetsnr;
	 
	 public Leilighet(String adresse, int postnr, String poststed, int boareal, int antrom, int byggeaar, String beskrivelse, int utleiepris)
	 {
		super(adresse, postnr, poststed, boareal, antrom, byggeaar, beskrivelse, utleiepris);
	 }
	
	public int getEtasje()
	{
		return etasje;
	}
	
	public void setEtasje(int etasje) 
	{
		this.etasje = etasje;
	}
	
	public boolean isHeis() 
	{
		return heis;
	}
	
	public void setHeis(boolean heis)
	{
		this.heis = heis;
	}
	
	public boolean isBalkong() 
	{
		return balkong;
	}
	
	public void setBalkong(boolean balkong) 
	{
		this.balkong = balkong;
	}
	
	public String getLeilighetsnr() 
	{
		return leilighetsnr;
	}
	
	public void setLeilighetsnr(String leilighetsnr) 
	{
		this.leilighetsnr = leilighetsnr;
	}
	
	public String toString()
	{
		return super.toString() +
				"\nEtasje: " + etasje +
				"\nHeis: " + (heis ? "ja" : "nei") +
				"\nBalkong: " + (balkong? "ja" : "nei") +
				"\nLeilighet nr." + leilighetsnr;
	}
}
