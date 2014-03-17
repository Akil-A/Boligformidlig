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
		Boligliste bl = new Boligliste();
		
		ListIterator<Bolig> iter = boliger.listIterator();
		
		while (iter.hasNext())
		{
			if (iter.next().getAdresse().equals(adresse) || iter.next().getBoareal() == boareal || iter.next().getAntrom() == antrom ||
					iter.next().getByggeaar().equals(byggeaar) || iter.next().getUtleiepris() == utleiepris ||
					((iter instanceof Enebolig || iter instanceof Rekkehus) && (((Enebolig)iter.next()).getAntetasjer() == antetasjer || ((Enebolig)iter.next()).getKjeller() == kjeller || ((Enebolig)iter.next()).getTomtestr() == tomtestr)) ||
					(iter instanceof Leilighet && (((Leilighet)iter.next()).getEtasje() == etasje || ((Leilighet)iter.next()).isHeis() == heis || ((Leilighet)iter.next()).isBalkong() == balkong)))
				bl.settInnBolig(iter.next());
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
