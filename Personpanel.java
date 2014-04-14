/* Panel som viser liste over alle utleiere og boligsokere.
 */


import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;

public class Personpanel extends JPanel
{
    private JList<Person> bList;
    private JList<Person> uList;
    private Lytter lytter;
    private JButton utleierknapp, boligsokerknapp, personskjemavinduknapp;
    private Boligregister register;
    private DefaultListModel<Person> uModel, bModel;
    private ArrayList<Utleier> utleierliste; 
    private ArrayList<Boligsoker>boligsokerliste;

    public Personpanel(Boligregister br)
    {	
    	
        register = br;

        utleierknapp = new JButton("Utleier");
        boligsokerknapp = new JButton("Bolig");
        personskjemavinduknapp = new JButton("Registrer ny person");
        lytter = new Lytter();
        personskjemavinduknapp.addActionListener(lytter);

        utleierknapp.addActionListener(lytter);
        boligsokerknapp.addActionListener(lytter);


        boligsokerliste = register.getBoligsokere();
        utleierliste = register.getUtleiere();

        uModel = new DefaultListModel<Person>();
        bModel = new DefaultListModel<Person>();


        Iterator<Utleier> iterator = utleierliste.iterator();

        while(iterator.hasNext())
        {
            uModel.addElement(iterator.next());
        }
        uList = new JList<Person>(uModel);
        
        Iterator<Boligsoker> iterator2 = boligsokerliste.iterator();

        while(iterator2.hasNext())
        {
            bModel.addElement(iterator2.next());
        }
        uList = new JList<Person>(uModel);
        bList = new JList<Person>(bModel);
        
    	Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		Font font = new Font("System", Font.PLAIN, 12);
		
		// JList må bindes til en egen liste som skriver ut en passende toString
		
		bList.setBorder(border);
		bList.setFont(font);
		uList.setBorder(border);
		uList.setFont(font);
        
        bList.setPreferredSize(new Dimension(450, 200));
		uList.setPreferredSize(new Dimension(450, 200));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(uList);
        add(scrollPane);
        

        setLayout(new GridBagLayout());
        
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.NORTHWEST;
		
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(new JLabel("Boligsokerliste:"), gc);
		
		gc.gridy = 1;
		add(bList, gc);
		
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
		add(uList, gc);

		gc.gridx = 1;
		gc.insets.left = 10;
		add(utleierknapp, gc);
		
        GridBagConstraints gc2 = new GridBagConstraints();
        
        gc2.insets.top = 20;
        gc2.gridx = gc.gridwidth /2;
        add(personskjemavinduknapp, gc2);

    }

    public void addUtleier(Person p) {
        uModel.addElement(p);
    }
    
    public void addBoligsoker(Person p) {
        bModel.addElement(p);
    }
    
    public void oppdaterUtleierliste()
    {
       uList.repaint();    
    }
    
    public void oppdaterBoligsokerliste()
    {
       bList.repaint();    
    }
    
    public void slettUtleier(Person p)
    {
    	uModel.removeElement(p);
    }
    
    public void slettBoligsoker(Person p)
    {
    	bModel.removeElement(p);
    }
    
    public void visMelding(String meldingen, String tittel)
    {
    	JOptionPane.showMessageDialog(null,  meldingen, tittel, JOptionPane.PLAIN_MESSAGE);
    }

    private class Lytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if(e.getSource() == utleierknapp)
            {
                if( uList.getSelectedIndex() != -1)
                {
                	Person valgtperson = uList.getSelectedValue();
                	Person p = register.finnPerson(valgtperson.getPersonNr());
                	
                    new Personskjemavindu(register, Personpanel.this, p);
                }
            }
            else if(e.getSource() == boligsokerknapp)
            {
                if( bList.getSelectedIndex() != -1)
                {
                	Person valgtperson = bList.getSelectedValue();
                	Person p = register.finnPerson(valgtperson.getPersonNr());
                	
                	new Personskjemavindu(register, Personpanel.this, p);
                }
            }
            else if(e.getSource() == personskjemavinduknapp)
            {
                new Personskjemavindu(register, Personpanel.this);
            }
        }
    }
}
