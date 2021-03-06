// Vinduskomponent som viser liste over alle personer.
// Laget av Akil
// Sist oppdatert slutten av april

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class Personpanel extends JPanel
{
    private JList<Person> boligsokerliste, utleierliste;
    private DefaultListModel<Person> boligsokermodell, utleiermodell;
    private JButton utleierknapp, boligsokerknapp, nypersonknapp;
    private Boligregister register;

    public Personpanel(Boligregister br)
    {
        register = br;


        /********* DEFINERING AV KOMPONENTER START *********/
        Lytter lytter = new Lytter();
        utleierknapp = new JButton("Detaljer");
        utleierknapp.addActionListener(lytter);
        boligsokerknapp = new JButton("Detaljer");
        boligsokerknapp.addActionListener(lytter);
        nypersonknapp = new JButton("Registrer ny person");
        nypersonknapp.addActionListener(lytter);
        /********* DEFINERING AV KOMPONENTER SLUTT *********/


        /********* POPULERING AV LISTER START *********/
        utleiermodell = new DefaultListModel<>();
        utleierliste = new JList<>(utleiermodell);
        Font IKKEFET = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
        utleierliste.setFont(IKKEFET);
        oppdaterUtleierliste();

        boligsokermodell = new DefaultListModel<>();
        boligsokerliste = new JList<>(boligsokermodell);
        boligsokerliste.setFont(IKKEFET);
        oppdaterBoligsokerliste();
        /********* POPULERING AV LISTER SLUTT *********/


        /********* LAYOUT START *********/
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.NORTHWEST;

        gc.gridx = 0;
        gc.gridy = 0;

        JScrollPane bScrollPane = new JScrollPane();
        bScrollPane.setBorder(BorderFactory.createTitledBorder("<html>BOLIGS&Oslash;KERE</html>"));
        bScrollPane.setViewportView(boligsokerliste);
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
        uScrollPane.setBorder(BorderFactory.createTitledBorder("UTLEIERE"));
        uScrollPane.setViewportView(utleierliste);
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
        add(nypersonknapp, gc);
        /********* LAYOUT SLUTT *********/
    }

    // Oppdater listen over utleiere. 
    public void oppdaterUtleierliste()
    {
        utleiermodell.clear();

        Iterator<Utleier> iterator = register.getUtleiere().iterator();

        while(iterator.hasNext())
            utleiermodell.addElement(iterator.next());
    }

    // Oppdater listen over boligsOkere.
    public void oppdaterBoligsokerliste()
    {
        boligsokermodell.clear();

        Iterator<Boligsoker> iterator = register.getBoligsokere().iterator();

        while(iterator.hasNext())
            boligsokermodell.addElement(iterator.next());
    }

    private class Lytter implements ActionListener
    {
        public void actionPerformed( ActionEvent e )
        {
            if(e.getSource() == utleierknapp)
            {
                if( utleierliste.getSelectedIndex() != -1)
                {
                    Person valgtperson = utleierliste.getSelectedValue();
                    new Personskjemavindu(register, Personpanel.this, valgtperson);
                }
            }
            else if(e.getSource() == boligsokerknapp)
            {
                if( boligsokerliste.getSelectedIndex() != -1)
                {
                    Person valgtperson = boligsokerliste.getSelectedValue();
                    new Personskjemavindu(register, Personpanel.this, valgtperson);
                }
            }
            else if(e.getSource() == nypersonknapp)
                new Personskjemavindu(register, Personpanel.this);
        }
    }
}
