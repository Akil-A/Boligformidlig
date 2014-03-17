import java.util.*;
public class Kontraktliste 
{
	
		List<Kontrakt> kontrakter = new ArrayList<>();
		
		public void settInnKontrakt(Kontrakt k)
		{
			kontrakter.add(k);
		}
		
		public void fjernKontrakt (int indeks)
		{
			kontrakter.remove(indeks);
		}
		
		public Kontrakt finnKontrakt(String navn, String adresse)
		{
			ListIterator<Kontrakt> iter = kontrakter.listIterator();
		
			while(iter.hasNext())
			{
				if (iter.next().getNavn().equals(navn) || iter.next().getAdresse().equals(adresse) )
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
			
			
		}
}

