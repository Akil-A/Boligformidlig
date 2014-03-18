public class Leilighet extends Bolig
{
 private int etasje;
 private boolean heis;
 private boolean balkong;
 private String leilighetsnr;
 
 public Leilighet(int etasje, boolean heis, boolean balkong, String leilighetsnr, String adresse, int postnr, String poststed, int boareal, int antrom, String byggeaar, String beskrivelse, int utleiepris, int aar, int maaned, int dag)
 {
    super(adresse, postnr, poststed, boareal,antrom,byggeaar,beskrivelse,utleiepris,aar,maaned,dag);
    
    this.etasje = etasje;
    this.heis = heis;
    this.balkong = balkong;
    this.leilighetsnr = leilighetsnr;
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
