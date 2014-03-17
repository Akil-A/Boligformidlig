import java.util.*;

public class Boligliste
{
	List<Bolig> boliger = new ArrayList<>();
	
	public void settInnBolig(Bolig b)
	{
		boliger.add(b);
	}
	
	public void fjernBolig(int indeks)
	{
		boliger.remove(indeks);
	}
	
	public Boligliste finnBolig(String adresse, int boareal, int antrom, String byggeaar, int utleiepris,
			int antetasjer, boolean kjeller, int tomtestr,
			int etasje, boolean heis, boolean balkong)
	{
		List<Bolig> bl = new ArrayList<>();
		
		Iterator<Bolig> iter = boliger.iterator();
		
		while (iter.hasNext())
		{
			if (iter.getAdresse().equals(adresse) || iter.getBoareal() == boareal || iter.getAntrom() == antrom ||
					iter.getByggeaar().equals(byggeaar) || iter.getUtleiepris() == utleiepris ||
					((iter instanceof Enebolig || iter instanceof Rekkehus) && (iter.getAntetasjer() == antetasjer || iter.getKjeller() == kjeller || iter.getTomtestr() == tomtestr)) ||
					(iter instanceof Leilighet && (iter.getEtasje() == etasje || iter.isHeis() == heis || iter.isBalkong() == balkong)))
				bl.add(iter.next());
			else
				iter.next();
		}
		
		return bl;
	}
	
	public String visListe()
	{
		Iterator<Bolig> iter = boliger.iterator();
		
		String s = "";
		
		while (iter.hasNext())
		{
			s += iter.next().toString() + "\n";
		}
		
		return s;
	}
}
