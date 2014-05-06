import java.io.Serializable;

/*
 * Klasse som forteller hvilken boligsoker som er interessert i hvilken bolig.
 */

public class Interesse implements Serializable
{
	private int interesseNr;
	private static int interesseTeller = 0;
	
	private Boligsoker boligsokeren;
	private Bolig boligen;
	
	public Interesse(Boligsoker bs, Bolig bl)
	{
		interesseNr = interesseTeller++;
		
		boligsokeren = bs;
		boligen = bl;
	}
	
	public int getInteresseNr()
	{
		return interesseNr;
	}
	
	public Boligsoker getBoligsokerern()
	{
		return boligsokeren;
	}
	
	public Bolig getBolig()
	{
		return boligen;
	}
}
