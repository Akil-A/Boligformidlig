import java.util.*;
public class Kontraktliste 
{
	
		List<Kontrakt> kontrakter = new ArrayList<>();
		
		public void setInnKontrakt(Kontrakt k)
		{
			kontrakter.add(k);
		}
		
		public void fjernKontrakt (int indeks)
		{
			kontrakter.remove(indeks);
		}
		
		public Kontraktliste finnKontrakt(String navn, String adresse)
		{
			List<Kontrakt> kl = new ArrayList<>();
			Iterator<Kontrakt> iter = kontrakter.iterator();
		
			while(iter.hasNext())
			{
				if (iter.getNavn().equals(navn) || iter.getAdresse().equals(adresse) )
			}
		
		}
}
