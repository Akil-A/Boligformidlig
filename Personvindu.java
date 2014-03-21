import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

public class Personvindu extends JFrame
{

    private JLabel felttekst1;
    private JLabel felttekst2;
    private JList<Object> list1;
    private JList<Object> list2;
    private JTextArea tekstomraade;
    private JButton knapp;
    private Lytter lytter;
    private Listelytter listelytter;
    private int valgtPersonNr;

    public Personvindu(Boligregister br)
    {
        super("Personvindu");
        
        valgtPersonNr = -1;

        tekstomraade = new JTextArea();

        felttekst1 = new JLabel("Utleiere");
        felttekst2 = new JLabel("Boligsokere");
        
        lytter = new Lytter();
        listelytter = new Listelytter();
        
        knapp.addActionListener(lytter);

        Container c = getContentPane();
        c.setLayout( new FlowLayout() );
        
        c.add( felttekst1);
        c.add( felttekst2);
        c.add(tekstomraade);
        c.add(knapp);

        setSize( 420, 800 );
        setVisible( true );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

        ArrayList<Boligsoker> boligsokerliste = br.getBoligsokere();
        ArrayList<Utleier> utleierliste = br.getUtleiere();

        list1 = new JList<>( boligsokerliste.toArray() );
        list1.addListSelectionListener(listelytter);
        list2 = new JList<>( utleierliste.toArray() );
        list2.addListSelectionListener(listelytter);

        list1.setVisibleRowCount(10);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list1));

        list2.setVisibleRowCount(10);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list2));

    }

    private class Lytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if(e.getSource() == knapp)
            {
            	if(valgtPersonNr != .1)
                //Personskjemavindu pv = new Personskjemavindu(valgtPersonNr);
            }
        }
    }
    
    private class Listelytter implements ListSelectionListener
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
    }
}
