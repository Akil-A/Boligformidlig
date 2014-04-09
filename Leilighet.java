public class Leilighet extends Bolig
{
	 private int etasje;
	 private boolean heis;
	 private boolean balkong;
	 
	 public Leilighet(String adresse, int postnr, String poststed, int utleiepris)
	 {
		super(adresse, postnr, poststed, utleiepris);
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
	
	public String toString()
	{
		return super.toString() +
				"\nEtasje: " + etasje +
				"\nHeis: " + (heis ? "ja" : "nei") +
				"\nBalkong: " + (balkong? "ja" : "nei");
	}
}
