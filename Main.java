package prosjekttest;

import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        //Kontrakt ko = new Kontrakt();
        //Kontraktliste klo = new Kontraktliste();
        //Personliste plo = new Personliste();
        ArrayList<Person> p = new ArrayList<>();
        ArrayList<Kontrakt> k = new ArrayList<>();
        ArrayList<Interesse> i = new ArrayList<>();
        Boligregister bso = new Boligregister(p, k, i);
       // Personvindu pvo = new Personvindu(bso);
       Personskjemavindu psvo = new Personskjemavindu();
     //   Hovedvindu hvo = new Hovedvindu();
    }
}
