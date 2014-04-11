import java.io.Serializable;

/*
 * Klasse som forteller hvilken boligsoker som er interessert i hvilken bolig.
 */

public class Interesse implements Serializable
{
	private int interesseNr;
	private static int interesseTeller = 0;
	
	private int boligsokerNr;
	private int boligNr;
	
	public Interesse(int boligsokerNr, int boligNr)
	{
		interesseNr = interesseTeller++;
		
		this.boligsokerNr = boligsokerNr;
		this.boligNr = boligNr;
	}
	
	public int getInteresseNr()
	{
		return interesseNr;
	}
	
	public int getBoligsokerNr()
	{
		return boligsokerNr;
	}
	
	public int getBoligNr()
	{
		return boligNr;
	}
}
