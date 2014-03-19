import java.util.*;

public class Kontraktliste

{
	List<Kontrakt> kontrakter = new ArrayList<>();
	
	public void settInnKontrakt(Kontrakt k)
	{
		kontrakter.add(k);
	}
	
	// parametren må byttes til kontraktNr
	public void slettKontrakt(int indeks)
	{
		kontrakter.remove(indeks);
	}
	
	public Kontrakt finnKontrakt(int kontraktNr)
	{
		ListIterator<Kontrakt> iter = kontrakter.listIterator();
		
		while(iter.hasNext())
			if(iter.next().getKontraktNr() == kontraktNr)
				return iter.next();
		
		return null;
	}
	
	public String visKontrakt()
	{
		ListIterator<Kontrakt> iter = kontrakter.listIterator();
		String s = "";
		s += iter.next().toString();
		return s;
	}
}
