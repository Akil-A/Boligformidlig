/* Klasse for Utleier-objektet. Inneholder boliglisten.
 * laget av Ali og Joakim
 */

import java.io.Serializable;
import java.util.ArrayList;

public class Utleier extends Person  implements Serializable
{
	private String firma;
	private ArrayList<Bolig> boliger;
	
	public Utleier (String fornavn, String etternavn, String adresse, int postnr, String poststed, String email, String telefon)
	{
		super(fornavn, etternavn, adresse, postnr, poststed, email, telefon);
		boliger = new ArrayList<>();
	}
	
	public String getFirma()
	{
		return firma;
	}
	
	public void setFirma(String firma) 
	{
		this.firma = firma;
	}
	
	// ###############################################################################################
	// OPERASJONER PAA BOLIGLISTEN
	// ###############################################################################################
	
	public void settInnBolig(Bolig b)
	{
		boliger.add(b);
	}
	
	public Bolig slettBolig(int boligNr)
	{
		Bolig bol = null;
		
		for (Bolig b : boliger)
			if (b.getBoligNr() == boligNr)
			{
				bol = b;
				break;
			}
		
		if (bol != null)
			boliger.remove(bol);
		
		return bol;
	}
	
	public ArrayList<Bolig> getBoliger() 
	{
		return boliger;
	}
	
	public Bolig finnBolig(int boligNr)
	{
		for (Bolig b : boliger)
			if (b.getBoligNr() == boligNr)
				return b;
		
		return null;
	}
}
