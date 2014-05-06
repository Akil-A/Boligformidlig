/*
 * Klassen som holder rede paa lister av Personer, Boliger og Kontrakter. 
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

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
	
	public void settInnPerson(Person p)
	{
		personer.add(p);
	}
	
	public boolean utleierHarBoliger(Utleier utleier)
	{
		for (Bolig b : boliger)
			if (b.getUtleier() == utleier)
				return true;
		
		return false;
	}

	public boolean slettPerson(Person personen)
	{
		for (Person p : personer)
			if (p == personen)
			{
				personer.remove(personen);
				return true;
			}
		
		return false;
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
	
	
	public ArrayList<Bolig> getBoliger()
	{
		return boliger;
	}
	
	
	public void settInnBolig(Bolig b)
	{
		boliger.add(b);
	}
	
	public boolean slettBolig(Bolig boligen)
	{
		for (Bolig b : boliger)
			if (b == boligen)
			{
				boliger.remove(boligen);
				return true;
			}
		
		return false;
	}
	
	public ArrayList<Bolig> getUtleide()
	{
		ArrayList<Bolig> u = new ArrayList<>();
		
		for (Kontrakt k : kontrakter)
			if (k.getFungerer())
				u.add(k.getBolig());
		
		return u;
	}
	
	public ArrayList<Bolig> getLedige()
	{
		ArrayList<Bolig> l = getBoliger();
		l.removeAll(getUtleide());
		
		return l;
	}
	
	
	
	
	
	// ###############################################################################################
	// KONTRAKT-METODER
	// ###############################################################################################

	
	public void settInnKontrakt(Kontrakt k)
	{
		kontrakter.add(k);
	}	
	
	public boolean oppdaterKontrakt(Kontrakt gammelkontrakt, Kontrakt nykontrakt)
	{
		for (Kontrakt k : kontrakter)
			if (k == gammelkontrakt)
			{
				k = nykontrakt;
				return true;
			}
		
		return false;
	}
	
	public ArrayList<Kontrakt> getKontrakter()
	{
		return kontrakter;
	}
	
	public ArrayList<Kontrakt> getFungerende()
	{
		ArrayList<Kontrakt> kl = new ArrayList<>();
		
		for (Kontrakt k : kontrakter)
			if (k.getFungerer())
				kl.add(k);
				
		return kl;			
	}
	
	public ArrayList<Kontrakt> getUtgaatte()
	{
		ArrayList<Kontrakt> kl = new ArrayList<>();
		
		for (Kontrakt k : kontrakter)
			if (!k.getFungerer())
				kl.add(k);
				
		return kl;	
	}
	
	public int getUtleideiAAr()
	{	
		int counter = 0;
		
		for (Kontrakt k : kontrakter)
			if ( (k.getStartdato().getYear()) + 1900 == Calendar.getInstance().get(Calendar.YEAR) )
				counter++;
		
		return counter;
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
	
	public boolean slettInteresse(Interesse interessen)
	{
		for (Interesse i : interesser)
			if (i == interessen)
			{
				interesser.remove(interessen);
				return true;
			}
		
		return false;
	}
}

