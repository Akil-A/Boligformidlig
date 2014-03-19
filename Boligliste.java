import java.util.*;

public class Boligliste
{
	List<Bolig> boliger;
	
	public Boligliste()
	{
		boliger = new ArrayList<>();
	}
	
	public void settInnBolig(Bolig b)
	{
		boliger.add(b);
	}
	
	public void slettBolig(int indeks)
	{
		boliger.remove(indeks);
	}
	
	public Bolig finnBolig(int boligNr)
	{
		ListIterator<Bolig> iter = boliger.listIterator();
		
		while(iter.hasNext())
			if(iter.next().getBoligNr() == boligNr)
				return iter.next();
		
		return null;
	}
	
	/* SØKEFUNKSJON -- denne er lang og kronglete, hva kan vi gjøre?
	 =============================================================================================================== */
	public Boligliste sokBolig(String adresse, int boareal, int antrom, String byggeaar, int utleiepris,
			int antetasjer, boolean kjeller, int tomtestr,
			int etasje, boolean heis, boolean balkong)
	{
		Boligliste bl = new Boligliste();
		
		ListIterator<Bolig> iter = boliger.listIterator();
		
		while (iter.hasNext())
		{
			if (iter.next().getAdresse().equals(adresse) || iter.next().getBoareal() == boareal || iter.next().getAntrom() == antrom ||
					iter.next().getByggeaar().equals(byggeaar) || iter.next().getUtleiepris() == utleiepris ||
					((iter instanceof Enebolig || iter instanceof Rekkehus) && (((Enebolig)iter.next()).getAntetasjer() == antetasjer || ((Enebolig)iter.next()).isKjeller() == kjeller || ((Enebolig)iter.next()).getTomtestr() == tomtestr)) ||
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
			s += iter.next().toString() + "\n";
		
		return s;
	}
}
