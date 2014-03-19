public class Boligsystem
{
	private Personliste personer;
	private Kontraktliste kontrakter;
	
	public Boligsystem(Personliste p, Kontraktliste k)
	{
		personer = p;
		kontrakter = k;
	}
	
	public Person finnPerson( int personNr )
	{
		return personer.finnPerson( personNr );
	}
	
	public Bolig finnBolig( int boligNr )
	{
		return personer.finnBolig( boligNr );
	}
	
	public Boligliste sokBoliger( String kriterier )
	{
		return personer.sokBoliger( kriterier );
	}
	
	public Kontrakt finnKontrakt( int kontraktNr )
	{
		return kontrakter.finnKontrakt( kontraktNr );
	}
	
	public void settInnPerson(Person p)
	{
		personer.settInnPerson(p);
	}

	// indeks-parametern må gjøres om til personNr i Personliste-klassen
	public void slettPerson(int indeks)
	{
		personer.slettPerson(indeks);
	}
	
	
	/* Metodene nedenfor, trengs de? Når man lagrer til og henter fra fil?
	 ===================================== */
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
	
	public void setKontrakter(Kontraktliste k)
	{
		kontrakter = k;
	}
}
