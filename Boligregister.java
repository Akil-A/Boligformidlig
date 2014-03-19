/*
 * Underliggende klasse som holder rede på lister av Personer, Boliger og Kontrakter. 
 * Objektet av denne klassen skal være med i alle programmets vindusklasser.
 */

import java.util.ArrayList;

public class Boligregister
{
	private ArrayList<Person> personer;
	private ArrayList<Kontrakt> kontrakter;
	private ArrayList<Interesse> interesser;
	
	public Boligregister(ArrayList<Person> p, ArrayList<Kontrakt> k, ArrayList<Interesse> i)
	{
		personer = p;
		kontrakter = k;
		interesser = i;
	}
	
	
	
	// ###############################################################################################
	// PERSON-METODER
	// ###############################################################################################
	
	public Person finnPerson( int personNr )
	{
		for (Person p : personer)
			if (p.getPersonNr() == personNr)
				return p;
		
		return null;
	}
	
	public void settInnPerson(Person p)
	{
		personer.add(p);
	}

	public Person slettPerson(int personNr)
	{
		Person pers = null;
		
		for (Person p : personer)
			if (p.getPersonNr() == personNr)
			{
				pers = p;
				personer.remove(p);
			}
		
		return pers;
	}
	
	public ArrayList<Person> getPersoner()
	{
		return personer;
	}
	
	public ArrayList<Boligsoker> getBoligsokere()
	{
		ArrayList<Boligsoker> pl = new ArrayList<>();
		
		for (Person p : personer)
			if (p instanceof Boligsoker)
				pl.add((Boligsoker) p);
		
		return pl;
	}
	
	public ArrayList<Utleier> getUtleiere()
	{
		ArrayList<Utleier> pl = new ArrayList<>();
		
		for (Person p : personer)
			if (p instanceof Utleier)
				pl.add((Utleier) p);
		
		return pl;
	}
	
	
	
	
	
	
	
	
	// ###############################################################################################
	// BOLIG-METODER
	// ###############################################################################################
	
	public Bolig finnBolig( int boligNr )
	{
		for (Utleier u : getUtleiere())
			for (Bolig b : u.getBoliger())
				if (b.getBoligNr() == boligNr)
					return b;
		
		return null;
	}
	
	public ArrayList<Bolig> sokBoliger( String kriterier )
	{
		// loop gjennom Utleiere, søk gjennom boliglistene deres etter boliger som matcher kriteriene
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	// ###############################################################################################
	// KONTRAKT-METODER
	// ###############################################################################################

	
	public void settInnKontrakt(Kontrakt k)
	{
		kontrakter.add(k);
	}	
	
	public Kontrakt finnKontrakt( int kontraktNr )
	{
		for (Kontrakt k : kontrakter)
			if (k.getKontraktNr() == kontraktNr)
				return k;
		
		return null;
	}	
	
	public ArrayList<Kontrakt> getKontrakter()
	{
		return kontrakter;
	}
	
	public Kontrakt slettKontrakt(int kontraktNr)
	{
		Kontrakt kontr = null;
		
		for (Kontrakt k : kontrakter)
			if (k.getKontraktNr() == kontraktNr)
			{
				kontr = k;
				kontrakter.remove(k);
			}
		
		return kontr;
	}
	
	

	
	
	
	
	
	// ###############################################################################################
	// INTERESSE-METODER
	// ###############################################################################################
		
	public void settInnInteresse(Interesse i)
	{
		interesser.add(i);
	}	
	
	public ArrayList<Interesse> getInteresser()
	{
		return interesser;
	}
	
	public Interesse slettInteresse(int interesseNr)
	{
		Interesse inter = null;
		
		for (Interesse i : interesser)
			if (i.getInteresseNr() == interesseNr)
			{
				inter = i;
				interesser.remove(i);
			}
		
		return inter;
	}
}
