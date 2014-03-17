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
	
	public Boligliste finnBolig(String adresse, int boareal, int antrom, String byggeaar, int utleiepris)
	{
		List<Bolig> bl = new ArrayList<>();
		
		Iterator<Bolig> iter = boliger.iterator();
		
		while (iter.hasNext())
		{
			if (iter.getAdresse() == adresse || iter.getBoareal() == boareal || iter.getAntrom() == antrom ||
					iter.getByggeaar() == byggeaar || iter.getUtleiepris() == utleiepris)
				bl.add(iter.next());
			else
				iter.next();
		}
		
		return bl;
	}
}
