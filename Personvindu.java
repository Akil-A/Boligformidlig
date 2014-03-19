package prosjekttest;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;
	
public class Personvindu extends JFrame
{

	private JLabel felttekst1;
	private JLabel felttekst2;
	private JTextArea tekstomraade;
	private JButton knapp;

	public Personvindu(Boligregister br)
	{	
		super("Personvindu");
		
	    tekstomraade = new JTextArea();

		felttekst1 = new JLabel("Utleiere");
		felttekst2 = new JLabel("Boligsokere");
		
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		
		c.add( felttekst1);
		c.add( felttekst2);
		c.add(tekstomraade);
		c.add(knapp);
		
		setSize( 420, 800 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);   
		
		ArrayList<Person> personliste = br.getPersoner();

		JList<Person> list = new JList<>(  );
		list.setVisibleRowCount(10);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list));
		
		list.addListSelectionListener( new ListSelectionListener(){
			public void valueChanged( ListSelectionEvent e)
			{
		         if ( !e.getValueIsAdjusting() )
		         {
		        	 JList<Person> liste = (JList<Person>) e.getSource();
		        	 Person person = (Person) liste.getSelectedValue();
		        	 String info = person.toString();
		        	 tekstomraade.append(info);
		         }
			}
		});
	 }
	
	private class Lytter implements ActionListener
	{
        public void actionPerformed( ActionEvent e )
        {
        	if(e.getSource() == knapp)
        	{
        		Personskjemavindu pv = new Personskjemavindu(list.getSelectedValue().getPersonNr());
        	}
        }
	}	
}
