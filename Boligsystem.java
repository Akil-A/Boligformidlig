public class Boligsystem
{
	private Personliste personer;
	private Kontraktliste kontrakter;
	
	public Boligsystem(p, k)
	{
		personer = p;
		kontrakter = k;
	}
	
	public Person finnPerson( personNr )
	{
		return personer.finnPerson( personNr );
	}
	
	public Bolig finnBolig( ... )
	{
		return personer.finnBolig( ... );
	}
	
	public Boligliste sokBoliger( ... )
	{
		return personliste.sokBoliger( ... );
	}
	
	public Kontrakt finnKontrakt( ... )
	{
		return kontrakter.finnKontrakt( ... );
	}
	
	public void nyPerson(Person p)
	{
		personer.nyPerson(p);
	}
	
	public void slettPerson(int personNr)
	{
		personer.slettPerson(personNr);
	}
	
	public Personliste getPersoner()
	{
		return personer;
	}
	
	public void setPersoner(Personliste p)
	{
		personer = p;
	}
	
	public Kontraktliste getKontrakter()
	{
		return kontrakter;
	}
	
	public void setPersoner(Kontraktliste k)
	{
		kontrakter = k;
	}
}
