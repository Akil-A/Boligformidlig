import java.io.Serializable;

/*
 * Klasse som forteller hvilken boligsoker som er interessert i hvilken bolig.
 */

public class Interesse implements Serializable
{
	private Boligsoker boligsokeren;
	private Bolig boligen;
	
	public Interesse(Boligsoker bs, Bolig bl)
	{
		boligsokeren = bs;
		boligen = bl;
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
