import java.util.*;

public class Personliste

{
	List<Person> personer;
	
	public Personliste()
	{
		personer = new ArrayList<>();
	}
	
	public Bolig finnBolig(int boligNr)
	{
		// loop gjennom alle Utleiere, ta Utleier.Boligliste.finnBolig(boligNr)
		
		return null;
	}
	
	public Boligliste sokBoliger(String kriterier)
	{
		// loop gjennom Utleiere, søk gjennom boliglistene deres etter boliger som matcher kriteriene
		
		return null;
	}

	public void settInnPerson(Person p)
	{
		personer.add(p);
	}
	
	// indeks-parametern må gjøres om til personNr. loop gjennom, ta iterator.remove()
	public void slettPerson(int indeks)
	{
		personer.remove(indeks);
	}
	
	public Person finnPerson(int personNr)
	{
		ListIterator<Person> iter = personer.listIterator();
		
		while(iter.hasNext())
			if(iter.next().getPersonNr() == personNr)
				return iter.next();
		
		return null;
	}
	
	public String visListe()
	{
		Iterator<Person> iter = personer.iterator();
		
		String s = "";
		
		while (iter.hasNext())
			s += iter.next().toString() + "\n";
		
		return s;
	}
}
