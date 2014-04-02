import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;


public class Personskjemavindu extends JFrame
{
    private JTextField fornavnfelt, etternavnfelt, emailfelt, adressefelt, telefonfelt, yrkefelt, poststedfelt, postnrfelt, antPersonerfelt, beliggenhetfelt, fraStorrelsefelt, tilStorrelsefelt, antRomfelt, utleieprisfelt, firmafelt;
    private JLabel forNavn, etterNavn, email, adresse, telefon, yrke, poststed, postnr, antPersoner, beliggenhet, fraStorrelse, tilStorrelse, antRom, utleiepris, firma;
    private JButton slettknapp1, slettknapp2, utleierregistrerknapp, finnBoligknapp, seBoligknapp, boligsokerknapp;
    private JCheckBox utleier, boligsoker, husdyr, balkong, royker, hage, heis, parkering, enebolig, leilighet, rekkehus;
    private JComboBox <String> sivilstatus, arbeidsforhold;
    private SjekkboksLytter sjekkboksLytter;
    private GridBagConstraints gc;
    private Container c;
    private JPanel ulpKnapper, bspKnapper, bspKrav1, typepanel, bspKrav2, bspKrav3;
    private Lytter lytter;

    public Personskjemavindu()
    {
        super("Personskjemavindu");
        lagVindu();
    }

    public Personskjemavindu(Person p)
    {
        super("Personskjemavindu");
        
        lagVindu();
        lytter = new Lytter();
        fornavnfelt.setText(p.getFornavn());
        etternavnfelt.setText(p.getEtternavn());
        emailfelt.setText(p.getEmail());
        adressefelt.setText(p.getAdresse());
        telefonfelt.setText(p.getTelefon());
        yrkefelt.setText(p.getYrke());
        poststed.setText(p.getPoststed());
        postnrfelt.setText(String.valueOf(p.getPostnr()));

        if(p instanceof Boligsoker)
        {
            Boligsoker bso = ((Boligsoker) p);

            antPersonerfelt.setText(String.valueOf(bso.getAntallPersoner()));
            fraStorrelsefelt.setText(String.valueOf(bso.getFraStorrelse()));
            tilStorrelse.setText(String.valueOf(bso.getTilStorrelse()));
            antRomfelt.setText(String.valueOf(bso.getAntallRom()));
            firmafelt.setText(bso.getFirma());
            yrkefelt.setText(bso.getYrke());
            utleieprisfelt.setText(bso.getUtleiepris());

            royker.setSelected(bso.isRoyker());
            husdyr.setSelected(bso.isHusdyr());
            sivilstatus.setSelectedItem(bso.getSivilstatus());
            arbeidsforhold.setSelectedItem(bso.getArbeidsforhold());
        }
      /*  else
        {
            Utleier ulo = ((Utleier) p);
            
            fornavnfelt.setText(p.getFornavn());
            etternavnfelt.setText(p.getEtternavn());
            emailfelt.setText(p.getEmail());
            adressefelt.setText(p.getAdresse());
            telefonfelt.setText(p.getTelefon());
            yrkefelt.setText(p.getYrke());
            poststed.setText(p.getPoststed());
            postnrfelt.setText(String.valueOf(p.getPostnr()));
            
        }*/

    }
    
    public void lagVindu()
    {
    	
        sjekkboksLytter = new SjekkboksLytter();

        fornavnfelt = new JTextField(10);
        etternavnfelt = new JTextField(10);
        adressefelt = new JTextField(10);
        telefonfelt = new JTextField(10);
        yrkefelt = new JTextField(10);
        emailfelt = new JTextField(10);
        poststedfelt = new JTextField(10);
        postnrfelt = new JTextField(10);
        antPersonerfelt = new JTextField(10);
        beliggenhetfelt = new JTextField(10);
        fraStorrelsefelt = new JTextField(10);
        tilStorrelsefelt = new JTextField(10);
        antRomfelt = new JTextField(10);
        utleieprisfelt = new JTextField(10);
        firmafelt = new JTextField(10);

        forNavn = new JLabel("Fornavn: ");
        etterNavn = new JLabel("Etternavn: ");
        adresse = new JLabel("Adresse: ");
        telefon = new JLabel("Telefonnummer: ");
        yrke = new JLabel("Yrke: ");
        email = new JLabel("Email: ");
        poststed = new JLabel("Poststed: ");
        postnr = new JLabel("Postnr: ");
        antPersoner = new JLabel("Antall personer: ");
        beliggenhet = new JLabel("Beliggenhet: ");
        fraStorrelse = new JLabel("Fra storrelse: ");
        tilStorrelse = new JLabel("Til storrelse: ");
        antRom = new JLabel("Antall rom: ");
        utleiepris = new JLabel("Utleiepris: ");
        firma = new JLabel("Firma: ");

        sivilstatus = new JComboBox<>();
        arbeidsforhold = new JComboBox<>();
        
        sivilstatus.addItem("<Velg Sivilstatus>");
        sivilstatus.addItem("Gift");
        sivilstatus.addItem("Ugift");
        sivilstatus.addItem("Enke");

        arbeidsforhold.addItem("<Velg Arbeidsforhold>");
        arbeidsforhold.addItem("Arbeider");
        arbeidsforhold.addItem("Arbeidslos");
        arbeidsforhold.addItem("Pensjonist");

        utleier = new JCheckBox("Utleier");
        utleier.addChangeListener(sjekkboksLytter);
        boligsoker = new JCheckBox("Boligsoker");
        boligsoker.addChangeListener(sjekkboksLytter);
        husdyr = new JCheckBox("Husdyr");
        balkong = new JCheckBox("Balkong");
        royker = new JCheckBox("Royker");
        hage = new JCheckBox("Hage");
        heis = new JCheckBox("Heis");
        parkering = new JCheckBox("Parkering");
        enebolig = new JCheckBox("Enebolig");
        leilighet = new JCheckBox("Leilighet");
        rekkehus = new JCheckBox("Rekkehus");

        seBoligknapp = new JButton("Se mine boliger");
        seBoligknapp.addActionListener(lytter);
        slettknapp1 = new JButton("Slett");
        slettknapp1.addActionListener(lytter);
        utleierregistrerknapp = new JButton("Registrer ny bolig paa meg");
        utleierregistrerknapp.addActionListener(lytter);
        slettknapp2 = new JButton("Slett");
        slettknapp2.addActionListener(lytter);
        finnBoligknapp = new JButton("Finn bolig");
        finnBoligknapp.addActionListener(lytter);
        boligsokerknapp = new JButton("Registrer bolig");
        boligsokerknapp.addActionListener(lytter);

        ButtonGroup bg = new ButtonGroup();
        bg.add(utleier);
        bg.add(boligsoker);

        c = getContentPane();
        c.setLayout(new GridBagLayout());

        gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.WEST;

        gc.gridy = 0;

        gc.gridx = 0;
        c.add(forNavn, gc);

        gc.insets.left = 0;
        gc.gridx = 1;
        c.add(fornavnfelt, gc);

        gc.insets.left = 20;
        gc.gridx = 2;
        c.add(etterNavn, gc);
        gc.gridx = 3;
        c.add(etternavnfelt, gc);

        gc.insets.left = 0;
        gc.gridy = 1;
        gc.gridx = 0;
        c.add(adresse, gc);
        gc.insets.left = 0;
        gc.gridx = 1;
        c.add(adressefelt, gc);

        gc.insets.left = 20;
        gc.gridx = 2;
        c.add(telefon, gc);
        gc.gridx = 3;
        c.add(telefonfelt, gc);

        gc.gridy = 2;

        gc.insets.left = 0;
        gc.gridx = 0;
        c.add(email, gc);
        gc.gridx = 1;
        gc.insets.left = 0;
        c.add(emailfelt, gc);

        gc.insets.left = 20;
        gc.gridx = 2;
        c.add(yrke, gc);
        gc.insets.left = 20;
        gc.gridx = 3;
        c.add(yrkefelt, gc);

        gc.gridy = 3;

        gc.insets.left = 0;
        gc.gridx = 0;
        c.add(postnr, gc);
        gc.insets.left = 0;
        gc.gridx = 1;
        c.add(postnrfelt, gc);
        gc.insets.left = 20;
        gc.gridx = 2;
        c.add(poststed, gc);
        gc.gridx = 3;
        c.add(poststedfelt, gc);

        gc.gridy = 4;

        gc.insets.left = 0;
        gc.gridx = 0;
        c.add(antPersoner, gc);
        gc.gridx = 1;
        c.add(antPersonerfelt, gc);
        gc.insets.left = 20;
        gc.gridx = 2;
        c.add(beliggenhet, gc);
        gc.gridx = 3;
        c.add(beliggenhetfelt, gc);

        gc.gridy = 5;

        gc.insets.left = 0;
        gc.gridx = 0;
        c.add(fraStorrelse, gc);
        gc.gridx = 1;
        c.add(fraStorrelsefelt, gc);
        gc.insets.left = 20;
        gc.gridx = 2;
        c.add(tilStorrelse, gc);
        gc.gridx = 3;
        c.add(tilStorrelsefelt, gc);

        gc.gridy = 6;

        gc.insets.left = 0;
        gc.gridx = 0;
        c.add(antRom, gc);
        gc.gridx = 1;
        c.add(antRomfelt, gc);

        gc.insets.left = 20;
        gc.gridx = 2;
        c.add(utleiepris, gc);
        gc.gridx = 3;
        c.add(utleieprisfelt, gc);

        gc.gridy = 7;

        gc.insets.left = 0;
        gc.gridx = 0;
        c.add(firma, gc);
        gc.gridx = 1;
        c.add(firmafelt, gc);

        //ulp = utleierpanel, bsp = boligsokerpanel
        ulpKnapper = new JPanel();
        bspKnapper = new JPanel();
        bspKrav1 = new JPanel();
        typepanel = new JPanel();
        bspKrav2 = new JPanel();
        bspKrav3 = new JPanel();

        typepanel.add(utleier);
        typepanel.add(boligsoker);

        bspKrav1.add(husdyr);
        bspKrav1.add(balkong);
        bspKrav1.add(royker);
        bspKrav1.add(hage);
        bspKrav1.add(heis);
        bspKrav1.add(parkering);
        bspKrav3.add(enebolig);
        bspKrav3.add(leilighet);
        bspKrav3.add(rekkehus);

        bspKrav2.add(sivilstatus);
        bspKrav2.add(arbeidsforhold);

        ulpKnapper.add(seBoligknapp);
        ulpKnapper.add(utleierregistrerknapp);
        ulpKnapper.add(slettknapp1);

        bspKnapper.add(finnBoligknapp);
        bspKnapper.add(slettknapp2);
        bspKnapper.add(boligsokerknapp);

        gc.gridwidth = 4;
        gc.insets.left = -17;
        gc.insets.top = 15;
        gc.gridx = 0;
        gc.gridy = 15;
        c.add(typepanel, gc);

        gc.gridy = 20;
        c.add(bspKrav1, gc);
        gc.insets.top = 0;
        gc.gridy = 21;
        c.add(bspKrav3, gc);

        gc.insets.top = 15;
        gc.gridy = 25;
        c.add(bspKnapper, gc);

        gc.gridy = 23;
        gc.insets.top = 5;
        c.add(bspKrav2, gc);

        gc.gridy = 27;
        c.add(ulpKnapper, gc);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        bspKnapper.setVisible(false);
        ulpKnapper.setVisible(false);
        bspKrav1.setVisible(false);
        bspKrav2.setVisible(false);
        bspKrav3.setVisible(false);
        setVisible( true );
    }

    private class SjekkboksLytter implements ChangeListener
    {
        public void stateChanged(ChangeEvent e)
        {
            if(utleier.isSelected())
            {
                bspKnapper.setVisible(false);
                ulpKnapper.setVisible(true);
                bspKrav1.setVisible(false);
                bspKrav3.setVisible(false);
                bspKrav2.setVisible(false);
            }
            if(boligsoker.isSelected())
            {
                ulpKnapper.setVisible(false);
                bspKnapper.setVisible(true);
                bspKrav1.setVisible(true);
                bspKrav3.setVisible(true);
                bspKrav2.setVisible(true);
            }
        }
    }
    
    private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
		}
	}
		
}
