/* Panel som vcciser liste over alle utleiere og boligsokere.
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

        
        

        /********* DEFINERING AV KOMPONENTER START *********/
        utleierknapp = new JButton("Detaljer");
        boligsokerknapp = new JButton("Detaljer");
        personskjemavinduknapp = new JButton("Registrer ny person");
        lytter = new Lytter();
        personskjemavinduknapp.addActionListener(lytter);

        utleierknapp.addActionListener(lytter);
        boligsokerknapp.addActionListener(lytter);
        /********* DEFINERING AV KOMPONENTER SLUTT *********/

        
        
        
        

        /********* POPULERING AV LISTER START *********/
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
        /********* POPULERING AV LISTER SLUTT *********/
        

        
        
        
        
        /********* LAYOUT START *********/
        setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.NORTHWEST;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		JScrollPane bScrollPane = new JScrollPane();
		bScrollPane.setBorder(BorderFactory.createTitledBorder("Boligsokere:"));
		bScrollPane.setViewportView(bList);
		bScrollPane.setPreferredSize(new Dimension(450, 200));   
        add(bScrollPane, gc);
		
		gc.gridx = 1;
		gc.insets.left = 10;
		add(boligsokerknapp, gc);
	
		gc.insets.top = 20;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets.left = 0;
		
		JScrollPane uScrollPane = new JScrollPane();
		uScrollPane.setBorder(BorderFactory.createTitledBorder("Utleiere:"));
		uScrollPane.setViewportView(uList); 
		uScrollPane.setPreferredSize(new Dimension(450, 200));   
        add(uScrollPane, gc);

		gc.gridx = 1;
		gc.insets.left = 10;
		add(utleierknapp, gc);
        
		gc.gridy = 2;
        gc.insets.top = 20;
		gc.insets.left = 0;
        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.anchor = GridBagConstraints.CENTER;
        add(personskjemavinduknapp, gc);
        /********* LAYOUT SLUTT *********/
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
