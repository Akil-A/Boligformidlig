/* Klasse for Utleier-objektet. Inneholder boliglisten.
 * laget av Ali og Joakim
 */

import java.util.ArrayList;

public class Utleier extends Person 
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
	
	public void slettBolig(int indeks)
	{
		boliger.remove(indeks);
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
	
	public ArrayList<Bolig> sokBoliger( String kriterier )
	{
		ArrayList<Bolig> bl = new ArrayList<>();
		
		// loop gjennom boliger, returner de som matcher kriterier
		
		return bl;
	}
}
