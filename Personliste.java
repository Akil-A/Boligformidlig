import java.util.*;

public class Personliste

{
	List<Person> personer = new ArrayList<>();


	public void settInnPerson(Person p)
	{
		personer.add(p);
	}
	
	public void fjernPerson(int indeks)
	{
		personer.remove(indeks);
	}
	
	public Person finnPerson(String fornavn, String etternavn, String telefon)
	{
		ListIterator<Person> iter = personer.listIterator();
		
	while(iter.hasNext())
		{
			if(iter.next().getFornavn().equals(fornavn) && iter.next().getEtternavn().equals(etternavn) && iter.next().getTelefon().equals(telefon))
			{
				iter.add(iter.next());
			}
			else
				iter.next();
		}
		return iter.next();
	}
	
	public String visPerson()
	{
		ListIterator<Person> iter = personer.listIterator();
		String s = "";
		s += iter.next().toString();
		return s;
	}

}
