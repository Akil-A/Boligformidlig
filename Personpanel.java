
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Personpanel extends JPanel
{

    private JLabel felttekst1;
    private JLabel felttekst2;
    private JList<Object> list1;
    private JList<Object> list2;
    private JTextArea tekstomraade;
    private JButton knapp;
    private Lytter lytter;
    private JPanel utleierpanel1, utleierpanel2, boligsokerpanel1, boligsokerpanel2;
    private JButton utleierknapp, boligsokerknapp, personskjemavinduknapp;
    private BorderLayout bLayout;
    private Container c;
    private GridBagConstraints gc;
    private Boligregister register;
    private DefaultListModel model;
    private ArrayList<Utleier> utleierliste;

    public Personpanel(Boligregister br)
    {
        setLayout(new BorderLayout());

        register = br;


        tekstomraade = new JTextArea("dette er tekstomraade");

        felttekst1 = new JLabel("Boligsokere");
        felttekst2 = new JLabel("Utleiere");

        utleierknapp = new JButton("Utleier");
        boligsokerknapp = new JButton("Bolig");
        personskjemavinduknapp = new JButton("Personskjemavindu");
        lytter = new Lytter();
        personskjemavinduknapp.addActionListener(lytter);

        utleierknapp.addActionListener(lytter);


        ArrayList<Boligsoker> boligsokerliste = register.getBoligsokere();
       utleierliste = register.getUtleiere();

        list1 = new JList<>( boligsokerliste.toArray() );

        model = new DefaultListModel();

        Iterator<Utleier> iterator = utleierliste.iterator();

        while(iterator.hasNext())
        {
            model.addElement(iterator.next());
        }
        list2 = new JList<>(model);



        list1.setVisibleRowCount(10);
        list1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list1));

        list2.setVisibleRowCount(10);
        list2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        add(new JScrollPane(list2));

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
        utleierpanel1.add(boligsokerknapp, gc);

        gc.gridx = 20;
        gc.gridy = 0;
        boligsokerpanel1.add(felttekst2, gc);
        gc.gridx = 20;
        gc.gridy = 1;
        boligsokerpanel1.add(list2, gc);
        gc.gridx = 20;
        gc.gridy = 2;
        boligsokerpanel1.add(utleierknapp, gc);

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
        add(personskjemavinduknapp, BorderLayout.SOUTH);

    }

    /* public class Test extends AbstractListModel {
        public int getSize() {
            return utleierliste.size();
        }

        public Object getElementAt(int index) {
            int a = 0;
            return a;
        }

        public void addPerson(Person p) {
            model.addElement(p);
            fireIntervalAdded(p, 0, getSize());
        }
    }*/

    public void addPerson(Person p) {
        model.addElement(p);
    }

    private class Lytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if(e.getSource() == utleierknapp)
            {
                if( list2.getSelectedIndex() != -1)
                {
                    Personskjemavindu pv = new Personskjemavindu(register.finnPerson(((Utleier) list2.getSelectedValue()).getPersonNr()));
                }
            }
            else if(e.getSource() == personskjemavinduknapp)
            {
                Personskjemavindu pv = new Personskjemavindu(register);
            }
        }
    }
}
