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

        ArrayList<Boligsoker> boligsokerliste = br.getBoligsokere();
        ArrayList<Utleier> utleierliste = br.getUtleiere();

        JList<Object> list1 = (JList<Object>) new JList<>( boligsokerliste.toArray() );
        JList<Object> list2 = (JList<Object>) new JList<>( utleierliste.toArray() );

        list1.setVisibleRowCount(10);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list1));

        list2.setVisibleRowCount(10);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list2));


        list1.addListSelectionListener( new ListSelectionListener(){
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
