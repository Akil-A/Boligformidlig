/*
 * Klassen som holder rede på lister av Personer, Boliger og Kontrakter. 
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Boligregister implements Serializable
{
	private ArrayList<Person> personer;
	private ArrayList<Bolig> boliger;
	private ArrayList<Kontrakt> kontrakter;
	private ArrayList<Interesse> interesser;
	
	public Boligregister(ArrayList<Person> p, ArrayList<Bolig> b, ArrayList<Kontrakt> k, ArrayList<Interesse> i)
	{
		personer = p;
		boliger = b;
		kontrakter = k;
		interesser = i;
	}
	
	
	
	// ###############################################################################################
	// PERSON-METODER
	// ###############################################################################################
	
	public Person finnPerson( int personNr )
	{
		for (Person p : personer)
			if (p.getPersonNr() == personNr)
				return p;
		
		return null;
	}
	
	public void settInnPerson(Person p)
	{
		personer.add(p);
	}
	
	public boolean utleierHarBoliger(int personNr)
	{
		for (Bolig b : boliger)
			if (b.getUtleierId() == personNr)
				return true;
		
		return false;
	}

	public Person slettPerson(int personNr)
	{
		Person pers = null;
		
		for (Person p : personer)
			if (p.getPersonNr() == personNr)
			{
				pers = p;
				break;
			}
		
		if (pers != null)
			personer.remove(pers);
		
		return pers;
	}
	
	public ArrayList<Person> getPersoner()
	{
		return personer;
	}
	
	public ArrayList<Boligsoker> getBoligsokere()
	{
		ArrayList<Boligsoker> pl = new ArrayList<>();
		
		for (Person p : personer)
			if (p instanceof Boligsoker)
				pl.add((Boligsoker) p);
		
		return pl;
	}
	
	public ArrayList<Utleier> getUtleiere()
	{
		ArrayList<Utleier> pl = new ArrayList<>();
		
		for (Person p : personer)
			if (p instanceof Utleier)
				pl.add((Utleier) p);
		
		return pl;
	}
	
	
	
	
	
	
	
	
	// ###############################################################################################
	// BOLIG-METODER
	// ###############################################################################################
	
	
	public Bolig finnBolig( int boligNr )
	{
		for (Bolig b : boliger)
			if (b.getBoligNr() == boligNr)
				return b;
		
		return null;
	}
	
	public ArrayList<Bolig> getBoliger()
	{
		return boliger;
	}
	
	
	public void settInnBolig(Bolig b)
	{
		boliger.add(b);
	}
	
	public void oppdaterBolig(int boligNr, Bolig nyBolig)
	{
		boliger.set(boliger.indexOf(finnBolig(boligNr)), nyBolig);
	}
	
	public Bolig slettBolig(int boligNr)
	{
		Bolig bol = null;
		
		for (Bolig b : boliger)
			if (b.getBoligNr() == boligNr)
			{
				bol = b;
				break;
			}
		
		if (bol != null)
			boliger.remove(bol);
		
		return bol;
	}
	
	
	
	
	
	// ###############################################################################################
	// KONTRAKT-METODER
	// ###############################################################################################

	
	public void settInnKontrakt(Kontrakt k)
	{
		kontrakter.add(k);
	}	
	
	public Kontrakt finnKontrakt( int kontraktNr )
	{
		for (Kontrakt k : kontrakter)
			if (k.getKontraktNr() == kontraktNr)
				return k;
		
		return null;
	}
	
	public ArrayList<Kontrakt> getKontrakter()
	{
		return kontrakter;
	}
	
	public ArrayList<Kontrakt> getFungerende()
	{
		ArrayList<Kontrakt> kl = new ArrayList<>();
		
		for (Kontrakt k : kontrakter)
			if (k.getSluttdato().after(new Date()))
				kl.add(k);
				
		return kl;			
	}
	
	public ArrayList<Kontrakt> getUtgaatte()
	{
		ArrayList<Kontrakt> kl = new ArrayList<>();
		
		for (Kontrakt k : kontrakter)
			if (k.getSluttdato().before(new Date()))
				kl.add(k);
				
		return kl;			
	}
	
	public Kontrakt slettKontrakt(int kontraktNr)
	{
		Kontrakt kontr = null;
		
		for (Kontrakt k : kontrakter)
			if (k.getKontraktNr() == kontraktNr)
			{
				kontr = k;
				kontrakter.remove(k);
			}
		
		return kontr;
	}
	
	

	
	
	
	
	
	// ###############################################################################################
	// INTERESSE-METODER
	// ###############################################################################################
		
	public void settInnInteresse(Interesse i)
	{
		interesser.add(i);
	}	
	
	public ArrayList<Interesse> getInteresser()
	{
		return interesser;
	}
	
	public Interesse slettInteresse(int interesseNr)
	{
		Interesse inter = null;
		
		for (Interesse i : interesser)
			if (i.getInteresseNr() == interesseNr)
			{
				inter = i;
				interesser.remove(i);
			}
		
		return inter;
	}
}
