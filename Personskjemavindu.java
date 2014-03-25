import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Personskjemavindu extends JFrame
{	
	private JTextField navnfelt;
	private JTextField adressefelt;
	private JTextField telefonfelt;
	private JTextField antPersoner;

	private JLabel navn;
	private JLabel adresse;
	private JLabel telefon;
	private JButton seBoligknapp;
	private JButton slettknapp1;
	private JButton slettknapp2;
	private JButton registrerknapp;
	private JButton finnBoligknapp;
	private JTextArea tekstomraade;
	private JCheckBox utleier;
	private JCheckBox boligsoker;
	private SjekkboksLytter sjekkboksLytter;
	GridBagConstraints gc;
    private Container c;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;

	public Personskjemavindu()
	{
		super("Personskjemavindu");
		
		sjekkboksLytter = new SjekkboksLytter();

		navnfelt = new JTextField(10);
		adressefelt = new JTextField(10);
		telefonfelt = new JTextField(10);
		
		navn = new JLabel("Navn: ");
		adresse = new JLabel("Adresse: ");
		telefon = new JLabel("Telefonnummer: ");
		
		tekstomraade = new JTextArea();

		seBoligknapp = new JButton("Se mine boliger");
		//addlistener
		slettknapp1 = new JButton("Slett");
		//addlisteer
		registrerknapp = new JButton("Registrer ny bolig paa meg");
		//addlistener
		slettknapp2 = new JButton("Slett");
		
		finnBoligknapp = new JButton("Finn bolig");
		
		utleier = new JCheckBox("Utleier");
		utleier.addChangeListener(sjekkboksLytter);
		boligsoker = new JCheckBox("Boligsoker");
		boligsoker.addChangeListener(sjekkboksLytter);

		ButtonGroup bg = new ButtonGroup();
		bg.add(utleier);
		bg.add(boligsoker);
		
		 c = getContentPane();
	     c.setLayout(new GridBagLayout());
	     
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        
        gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.WEST;
        gc.insets.left = 2;
		gc.insets.top = 2;
		
		gc.gridx = 0;
		gc.gridy = 1;
		c.add(navn, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		c.add(adresse, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		c.add(telefon, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		c.add(navnfelt, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		c.add(adressefelt, gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		c.add(telefonfelt, gc);
        
		gc.insets.top = 20;
		gc.gridx = 0;
		gc.gridy = 8;
		c.add(utleier, gc);
		
		gc.gridx = 1;
		gc.gridy = 8;
		c.add(boligsoker, gc);
		
		gc.insets.top = 20;
		gc.gridx = 0;
		gc.gridy = 12;
		p1.add(seBoligknapp, gc);
		
		gc.gridx = 1;
		gc.gridy = 12;
		p1.add(slettknapp1, gc);
		
		gc.gridx = 2;
		gc.gridy = 12;
		p1.add(registrerknapp, gc);
        
		gc.gridx = 0;
		gc.gridy = 12;
		p2.add(finnBoligknapp, gc);
		
		gc.gridx = 1;
		gc.gridy = 12;
		p2.add(slettknapp2, gc);
		
		p2.setVisible(false);
        
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 13;
        c.add(p1, gc);
        c.add(p2, gc);

        setSize( 500, 400 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
    	setLocationRelativeTo(null);
        setVisible( true );
	}
	
    private class SjekkboksLytter implements ChangeListener
    {
		public void stateChanged(ChangeEvent e)
		{
           if(utleier.isSelected())
           {	
        	   p1.setVisible(false);
        	   p2.setVisible(true);
        	  // p4.setVisible(true);
               //c.add(p4, gc);
           }
           if(boligsoker.isSelected())
           {
        	   p2.setVisible(false);
        	   p1.setVisible(true);		
           }
		}
    }
}
