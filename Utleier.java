import java.util.ArrayList;
import java.util.ListIterator;

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
	// OPERASJONER PÅ BOLIGLISTEN
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
		ListIterator<Bolig> iter = boliger.listIterator();
		
		while(iter.hasNext())
			if(iter.next().getBoligNr() == boligNr)
				return iter.next();
		
		return null;
	}
}
