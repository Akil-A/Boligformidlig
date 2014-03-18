import java.util.*;

public class Kontraktliste

{
	List<Kontrakt> kontrakter = new ArrayList<>();
	
public void settInnKontrakt(Kontrakt k)

{
	kontrakter.add(k);
}

public void slettKontrakt(int indeks)

{
	kontrakter.remove(indeks);
}

public Kontrakt finnKontrakt(Utleier utleier, Boligsoker leietaker, String adresse, String telefon)

{
	ListIterator<Kontrakt> iter = kontrakter.listIterator();

	while(iter.hasNext())
	{
		if(iter.next().getUtleier().equals(utleier) && iter.next().getLeietaker().equals(leietaker))
		{
			iter.add(iter.next());
		}
		else
			iter.next();
	}
	return iter.next();
}

public String visKontrakt()

{
	ListIterator<Kontrakt> iter = kontrakter.listIterator();
	String s = "";
	s += iter.next().toString();
	return s;
}

	
}
