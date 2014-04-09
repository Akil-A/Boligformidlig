package prosjekttest;


import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;

public class Personpanel extends JPanel
{

    private JLabel felttekst1;
    private JLabel felttekst2;
    private JList<Person> list1;
    private JList<Person> list2;
    private JTextArea tekstomraade;
    private JButton knapp;
    private Lytter lytter;
    private JPanel utleierpanel1, utleierpanel2, boligsokerpanel1, boligsokerpanel2;
    private JButton utleierknapp, boligsokerknapp, personskjemavinduknapp;
    private BorderLayout bLayout;
    private Container c;
    private GridBagConstraints gc;
    private Boligregister register;
    private DefaultListModel<Person> model1, model2;
    private ArrayList<Utleier> utleierliste;

    public Personpanel(Boligregister br)
    {	
    	

        register = br;

        felttekst1 = new JLabel("Boligsokere");
        felttekst2 = new JLabel("Utleiere");

        utleierknapp = new JButton("Utleier");
        boligsokerknapp = new JButton("Bolig");
        personskjemavinduknapp = new JButton("Registrer ny person");
        lytter = new Lytter();
        personskjemavinduknapp.addActionListener(lytter);

        utleierknapp.addActionListener(lytter);


        ArrayList<Boligsoker> boligsokerliste = register.getBoligsokere();
        utleierliste = register.getUtleiere();

        model1 = new DefaultListModel<Person>();
        model2 = new DefaultListModel<Person>();


        Iterator<Utleier> iterator = utleierliste.iterator();

        while(iterator.hasNext())
        {
            model1.addElement(iterator.next());
        }
        list2 = new JList<Person>(model1);
        
        Iterator<Boligsoker> iterator2 = boligsokerliste.iterator();

        while(iterator2.hasNext())
        {
            model2.addElement(iterator2.next());
        }
        list2 = new JList<Person>(model1);
        list1 = new JList<Person>(model2);
        
    	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		Font font = new Font("System", Font.PLAIN, 12);
		
		// JList må bindes til en egen liste som skriver ut en passende toString
		
		list1.setBorder(border);
		list1.setFont(font);
		list2.setBorder(border);
		list2.setFont(font);
        
        list1.setPreferredSize(new Dimension(450, (int) list1.getPreferredSize().getHeight()));
		list2.setPreferredSize(new Dimension(450, (int) list2.getPreferredSize().getHeight()));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(list2);
        add(scrollPane);
        
		list1.setVisibleRowCount(5);
		list2.setVisibleRowCount(5);

        setLayout(new GridBagLayout());
        
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.NORTHWEST;
		
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(new JLabel("Boligsokerliste:"), gc);
		
		gc.gridy = 1;
		add(list1, gc);
		
		gc.gridx = 1;
		gc.insets.left = 10;
		add(boligsokerknapp, gc);
		
		gc.insets.top = 20;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.insets.left = 0;
		add(new JLabel("Utleierliste:"), gc);
		
		gc.gridy = 3;
		gc.insets.top = 0;
		add(list2, gc);

		gc.gridx = 1;
		gc.insets.left = 10;
		add(utleierknapp, gc);
		
        GridBagConstraints gc2 = new GridBagConstraints();
        
        gc2.insets.top = 20;
        gc2.gridx = gc.gridwidth /2;
        add(personskjemavinduknapp, gc2);

    }

    public void addUtleier(Person p) {
        model1.addElement(p);
    }
    
    public void addBoligsoker(Person p) {
        model2.addElement(p);
    }
    
    public void oppdaterUtleierliste()
    {
       list2.repaint();    
    }
    
    public void oppdaterBoligsokerliste()
    {
       list1.repaint();    
    }
    
    public void slettPerson(Person p)
    {
    	model1.removeElement(p);
    }

    private class Lytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if(e.getSource() == utleierknapp)
            {
                if( list2.getSelectedIndex() != -1)
                {
                    Personskjemavindu pv = new Personskjemavindu(Personpanel.this, register.finnPerson(((Utleier) list2.getSelectedValue()).getPersonNr()), register);
                }
            }
            else if(e.getSource() == personskjemavinduknapp)
            {
                Personskjemavindu pv = new Personskjemavindu(Personpanel.this, register);
            }
        }
    }
}
