// Klassen som holder rede paa lister og operasjoner mot listene.
// Laget av Joakim og Akil
// Sist oppdatert 14/5

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class Boligregister implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Person> personer;
	private ArrayList<Bolig> boliger;
	private ArrayList<Kontrakt> kontrakter;
	
	public Boligregister(ArrayList<Person> p, ArrayList<Bolig> b, ArrayList<Kontrakt> k)
	{
		personer = p;
		boliger = b;
		kontrakter = k;
	}
	
	
	
	// ###############################################################################################
	// PERSON-METODER
	// ###############################################################################################
	
	public void settInnPerson(Person p)
	{
		personer.add(p);
	}
	
	// returnerer true hvis det finnes boliger som er registrert paa angitt utleier
	public boolean utleierHarBoliger(Utleier utleier)
	{
		for (Bolig b : boliger)
			if (b.getUtleier() == utleier)
				return true;
		
		return false;
	}

	public boolean slettPerson(Person p)
	{
		return personer.remove(p);
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
	
	public ArrayList<Boligsoker> getBoligsokereMedBolig()
	{
		ArrayList<Boligsoker> pl = new ArrayList<>();
		
		for (Kontrakt k : getFungerende())
			if (!pl.contains(k.getLeietaker()))
				pl.add(k.getLeietaker());
		
		return pl;
	}
	
	public ArrayList<Boligsoker> getBoligsokereUtenBolig()
	{
		ArrayList<Boligsoker> pl = new ArrayList<>();
		
		for (Boligsoker p : getBoligsokere())
			if (!getBoligsokereMedBolig().contains(p))
				pl.add(p);
		
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
	
	public ArrayList<Utleier> getUtleiereMedBolig()
	{
		ArrayList<Utleier> pl = new ArrayList<>();
		
		for (Bolig b : boliger)
			if (!pl.contains(b.getUtleier()))
				pl.add(b.getUtleier());
				
		return pl;
	}
	
	
	
	
	
	
	// ###############################################################################################
	// BOLIG-METODER
	// ###############################################################################################
	
	
	public ArrayList<Bolig> getBoliger()
	{
		return boliger;
	}	
	
	public void settInnBolig(Bolig b)
	{
		boliger.add(b);
	}
	
	public boolean slettBolig(Bolig b)
	{
		return boliger.remove(b);
	}
	
	public ArrayList<Bolig> getUtleide()
	{
		ArrayList<Bolig> u = new ArrayList<>();
		
		for (Kontrakt k : getFungerende())
			u.add(k.getBolig());
		
		return u;
	}
	
	public ArrayList<Bolig> getLedige()
	{
		ArrayList<Bolig> l = new ArrayList<>();
		l.addAll(getBoliger());
		l.removeAll(getUtleide());
		
		return l;
	}
	
	
	
	
	
	// ###############################################################################################
	// KONTRAKT-METODER
	// ###############################################################################################

	
	public void settInnKontrakt(Kontrakt k)
	{
		kontrakter.add(k);
	}	
	
	// oppdaterer kontrakt med ny data. gammelkontrakt er kontrakten som allerede eksisterer i systemet.
	public boolean oppdaterKontrakt(Kontrakt gammelkontrakt, Kontrakt nykontrakt)
	{
		for (Kontrakt k : kontrakter)
			if (k == gammelkontrakt)
			{
				k = nykontrakt;
				return true;
			}
		
		return false;
	}
	
	public ArrayList<Kontrakt> getKontrakter()
	{
		return kontrakter;
	}
	
	// undersOker om angitt bolig er leid ut for Oyeblikket. er den det returneres den aktuelle kontrakten.
	public Kontrakt finnFungerende(Bolig b)
	{
		for (Kontrakt k : getFungerende())
			if (k.getBolig() == b)
				return k;
		
		return null;
	}
	
	public ArrayList<Kontrakt> getFungerende()
	{
		ArrayList<Kontrakt> kl = new ArrayList<>();
		
		for (Kontrakt k : kontrakter)
			if (k.getFungerer())
				kl.add(k);
				
		return kl;			
	}
	
	public ArrayList<Kontrakt> getUtgaatte()
	{
		ArrayList<Kontrakt> kl = new ArrayList<>();
		
		for (Kontrakt k : kontrakter)
			if (!k.getFungerer())
				kl.add(k);
				
		return kl;	
	}
	
	// returnerer antall boliger som er utleid dette kalenderaaret
	public int getUtleideiAAr()
	{	
		int counter = 0;
		
		for (Kontrakt k : kontrakter)
			if (!k.getFeilinntasting() && (k.getStartdato().get(Calendar.YEAR)) == Calendar.getInstance().get(Calendar.YEAR))
				counter++;
		
		return counter;
	}
}

