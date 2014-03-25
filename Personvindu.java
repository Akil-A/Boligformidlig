import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

public class Personvindu extends JFrame
{

    private JLabel felttekst1;
    private JLabel felttekst2;
    private JList<String> list1, list2;
    private JTextArea tekstomraade;
    private JButton knapp;
    private Lytter lytter;
    private Listelytter listelytter;
    private int valgtPersonNr;
    private BorderLayout layout;
    private Container c;

    public Personvindu(Boligregister br)
    {
        super("Personvindu");
        
        String[] dyrenavn = { "Fugl", "Katt", "Hund", "Kanin", "Gris" };
        
        JList<String> list1 = new JList<>( dyrenavn );
        JList<String> list2 = new JList<>( dyrenavn );

        valgtPersonNr = -1;

        tekstomraade = new JTextArea("dette er tekstomraade");

        felttekst1 = new JLabel("Utleiere");
        felttekst2 = new JLabel("Boligsokere");

        lytter = new Lytter();
        listelytter = new Listelytter();

        //knapp.addActionListener(lytter);

        setSize( 500, 500 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);

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

        c = getContentPane();
        c.setLayout(new GridBagLayout());
        

        GridBagConstraints gc = new GridBagConstraints();
        
        gc.insets.left = 2;
		gc.insets.top = 2;
		
		gc.gridx = 0;
		gc.gridy = 0;
		c.add(felttekst1, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		c.add(list1, gc);
		
		gc.insets.top = 90;
		gc.gridx = 0;
		gc.gridy = 6;
		c.add(felttekst2, gc);

		gc.insets.top = 0;
		gc.gridx = 0;
		gc.gridy = 7;
		c.add(list2, gc);

		setLocationRelativeTo(null);
        setVisible( true );
    }

    private class Lytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if(e.getSource() == knapp)
            {
                if(valgtPersonNr != -1)
                {
                    //Personskjemavindu pv = new Personskjemavindu(valgtPersonNr);
                }
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
