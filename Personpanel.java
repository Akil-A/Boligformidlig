package prosjekttest;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

public class Personpanel extends JPanel
{

    private JLabel felttekst1;
    private JLabel felttekst2;
    private JList<String> list1, list2;
    private JTextArea tekstomraade;
    private JButton knapp;
    private Lytter lytter;
   // private Listelytter listelytter;
    private int valgtPersonNr;
    private JPanel utleierpanel1, utleierpanel2, boligsokerpanel1, boligsokerpanel2;
    private JButton utleierknapp, boligsokerknapp, personskjemavinduknapp;
    private BorderLayout bLayout;
    private Container c;
    private GridBagConstraints gc;
    private Boligregister br;
    
    public Personpanel(Boligregister br)
    {
    	setLayout(new BorderLayout());
        
        String[] dyrenavn = { "Fugl", "Katt", "Hund", "Kanin", "Gris" };
        
        JList<String> list1 = new JList<>( dyrenavn );
        JList<String> list2 = new JList<>( dyrenavn );

        valgtPersonNr = -1;

        tekstomraade = new JTextArea("dette er tekstomraade");

        felttekst1 = new JLabel("Utleiere");
        felttekst2 = new JLabel("Boligsokere");
        
        utleierknapp = new JButton("Utleier");
        boligsokerknapp = new JButton("Bolig");
        personskjemavinduknapp = new JButton("Personskjemavindu");
        

        lytter = new Lytter();
  //      listelytter = new Listelytter();

        //knapp.addActionListener(lytter);


        ArrayList<Boligsoker> boligsokerliste = br.getBoligsokere();
        ArrayList<Utleier> utleierliste = br.getUtleiere();

        /*list1 = new JList<>( boligsokerliste.toArray() );
        list1.addListSelectionListener(listelytter);
        list2 = new JList<>( utleierliste.toArray() );
        list2.addListSelectionListener(listelytter);

        list1.setVisibleRowCount(10);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list1));

        list2.setVisibleRowCount(10);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list2));*/

        JPanel panel1 = new JPanel(new GridBagLayout());
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel panel2 = new JPanel(new GridBagLayout());
        JPanel panel3 = new JPanel(new BorderLayout());
        
        JPanel panel4 = new JPanel(new GridBagLayout());
        JPanel panel5 = new JPanel(new BorderLayout());
        
        gc = new GridBagConstraints();
        
        
     /* gc.insets.left = 2;
		gc.insets.top = 2;
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(felttekst1, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(list1, gc);
		
		gc.gridx = 0;
		gc.gridy = 20;
		add(felttekst2, gc);

		gc.gridx = 0;
		gc.gridy = 21;
		add(list2, gc);*/
		
		utleierpanel1 = new JPanel(new GridBagLayout());
		boligsokerpanel1 = new JPanel(new GridBagLayout());
		
		gc.gridx = 0;
		gc.gridy = 0;
		utleierpanel1.add(felttekst1, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		utleierpanel1.add(list1, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		utleierpanel1.add(utleierknapp, gc);
		
		gc.gridx = 20;
		gc.gridy = 0;
		boligsokerpanel1.add(felttekst2, gc);
		gc.gridx = 20;
		gc.gridy = 1;
		boligsokerpanel1.add(list2, gc);
		gc.gridx = 20;
		gc.gridy = 2;
		boligsokerpanel1.add(boligsokerknapp, gc);
		
	    gc.gridx = 0;
	    gc.gridy = 0;
	    panel1.add(utleierpanel1, gc);
	    
	    gc.gridx = 20;
	    gc.gridy = 0;
	    panel2.add(boligsokerpanel1, gc);
		
	    panel.add(panel1, BorderLayout.NORTH);
	    add(panel, BorderLayout.WEST);
	    
	    panel3.add(panel2, BorderLayout.NORTH);
	    add(panel3, BorderLayout.EAST);
	    add(personskjemavinduknapp, BorderLayout.CENTER);
		
    }

    private class Lytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if(e.getSource() == knapp)
            {
                if(valgtPersonNr != -1)
                {
                    Personskjemavindu pv = new Personskjemavindu(); //br.finnPerson(valgtPersonNr
                }
            }
        }
    }

   /* private class Listelytter implements ListSelectionListener
    {
        public void valueChanged( ListSelectionEvent e)
        {
            if (e.getSource() == list1)
            {
                list2.clearSelection();
                valgtPersonNr = ((Utleier)list1.getSelectedValue()).getPersonNr();
            }
            else if (e.getSource() == list2)
            {
                list1.clearSelection();
                valgtPersonNr = ((Boligsoker)list2.getSelectedValue()).getPersonNr();
            }
        }
    }*/
}