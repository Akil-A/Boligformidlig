package prosjekttest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.*;


public class Personskjemavindu extends JFrame
{
    private JTextField fornavnfelt, etternavnfelt, emailfelt, adressefelt, telefonfelt, yrkefelt, poststedfelt, postnrfelt, antPersonerfelt, beliggenhetfelt, fraStorrelsefelt, tilStorrelsefelt, antRomfelt, utleieprisfelt, firmafelt, testfelt;
    private JLabel forNavn, etterNavn, email, adresse, telefon, yrke, poststed, postnr, antPersoner, beliggenhet, fraStorrelse, tilStorrelse, antRom, utleiepris, firma, test;
    private JButton slettknapp1, slettknapp2, utleierregistrerknapp, seBoligknapp, boligregistrerknapp, lagre1, lagre2;
    private JCheckBox utleier, boligsoker, husdyr, balkong, royker, hage, heis, parkering, enebolig, leilighet, rekkehus;
    private JComboBox <String> sivilstatus, arbeidsforhold;
    private SjekkboksLytter sjekkboksLytter;
    private GridBagConstraints gc;
    private Container c;
    private JPanel ulpKnapper, bspKnapper, bspKrav1, typepanel, bspKrav2, bspKrav3, testpanel, feltpanel, utleierpanel, boligsokerpanel;
    private Lytter lytter;
    private Random generator;
    private Boligregister register;

    public Personskjemavindu(Boligregister br)
    {
        super("Personskjemavindu");
        lagVindu();
        register = br;
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
        utleier.setEnabled(false);
        boligsoker.setEnabled(false);


        if(p instanceof Boligsoker)
        {
            Boligsoker bso = ((Boligsoker) p);

            antPersonerfelt.setText(String.valueOf(bso.getAntallPersoner()));
            fraStorrelsefelt.setText(String.valueOf(bso.getFraStorrelse()));
            tilStorrelse.setText(String.valueOf(bso.getTilStorrelse()));
            antRomfelt.setText(String.valueOf(bso.getAntallRom()));
            yrkefelt.setText(bso.getYrke());
            utleieprisfelt.setText(bso.getUtleiepris());

            royker.setSelected(bso.isRoyker());
            husdyr.setSelected(bso.isHusdyr());
            sivilstatus.setSelectedItem(bso.getSivilstatus());
            arbeidsforhold.setSelectedItem(bso.getArbeidsforhold());
            boligsoker.setSelected(true);
        }
        else
        {
            Utleier ulo = ((Utleier) p);
            firmafelt.setText(ulo.getFirma());
       
            utleier.setSelected(true);     
        }

    }
    
    public void lagVindu()
    {
    	generator = new Random();
    	int randNr1 = generator.nextInt(10);
    	int randNr2 = generator.nextInt(10);
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
        testfelt = new JTextField(4);

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
        test = new JLabel("Hva er " + randNr1 + " + " + randNr2);

        sivilstatus = new JComboBox<>();
        arbeidsforhold = new JComboBox<>();
        
        sivilstatus.addItem("<Velg Sivilstatus>");
        sivilstatus.addItem("Gift");
        sivilstatus.addItem("Ugift");
        sivilstatus.addItem("Enke");
        sivilstatus.addItem("Enkemann");

        arbeidsforhold.addItem("<Velg Arbeidsforhold>");
        arbeidsforhold.addItem("Arbeider");
        arbeidsforhold.addItem("Student");
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

        seBoligknapp = new JButton("Registrer ny person");
        seBoligknapp.addActionListener(lytter);
        slettknapp1 = new JButton("Slett");
        slettknapp1.addActionListener(lytter);
        utleierregistrerknapp = new JButton("Registrer ny bolig paa meg");
        utleierregistrerknapp.addActionListener(lytter);
        slettknapp2 = new JButton("Slett");
        slettknapp2.addActionListener(lytter);
        boligregistrerknapp = new JButton("Registrer ny person");
        boligregistrerknapp.addActionListener(lytter);
        lagre1 = new JButton("Lagre");
        lagre1.addActionListener(lytter);
        lagre2 = new JButton("Lagre");
        lagre2.addActionListener(lytter);

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

        //ulp = utleierpanel, bsp = boligsokerpanel
        ulpKnapper = new JPanel();
        bspKnapper = new JPanel();
        bspKrav1 = new JPanel();
        typepanel = new JPanel();
        bspKrav2 = new JPanel();
        bspKrav3 = new JPanel();
        testpanel = new JPanel();

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
        ulpKnapper.add(lagre1);
        ulpKnapper.add(slettknapp1);

        bspKnapper.add(boligregistrerknapp);
        bspKnapper.add(lagre2);
        bspKnapper.add(slettknapp2);

        gc.gridwidth = 4;
        gc.insets.left = -17;
        gc.insets.top = 15;
        gc.gridx = 0;
        gc.gridy = 15;
        c.add(typepanel, gc);
        
        /******* UTLEIERPANEL ********/
        utleierpanel = new JPanel(new GridBagLayout());
        GridBagConstraints gcUp = new GridBagConstraints();
       
        gcUp.gridy = 0;
        gcUp.gridx = 0;
        gcUp.insets.left = 15;
        utleierpanel.add(firma, gcUp);
        
        gcUp.gridx = 1;
        gcUp.insets.left = -250;
        utleierpanel.add(firmafelt, gcUp);
        
        gcUp.gridy = 3;
        gcUp.insets.left = -55;
        gcUp.insets.top = 10;
        utleierpanel.add(ulpKnapper, gcUp);
        

        /******* BOLIGSOKERPANEL ********/
        boligsokerpanel = new JPanel(new GridBagLayout());
        GridBagConstraints gcBsp = new GridBagConstraints();


        gcBsp.gridy = 0;

        gcBsp.gridx = 0;
        boligsokerpanel.add(antPersoner, gcBsp);
        gcBsp.gridx = 1;
        boligsokerpanel.add(antPersonerfelt, gcBsp);
        gcBsp.gridx = 2;
        boligsokerpanel.add(beliggenhet, gcBsp);
        gcBsp.gridx = 3;
        boligsokerpanel.add(beliggenhetfelt, gcBsp);

        gcBsp.gridy = 1;

        gcBsp.gridx = 0;
        boligsokerpanel.add(fraStorrelse, gcBsp);
        gcBsp.gridx = 1;
        boligsokerpanel.add(fraStorrelsefelt, gcBsp);
        gcBsp.gridx = 2;
        boligsokerpanel.add(tilStorrelse, gcBsp);
        gcBsp.gridx = 3;
        boligsokerpanel.add(tilStorrelsefelt, gcBsp);

        gcBsp.gridy = 2;

        gcBsp.gridx = 0;
        boligsokerpanel.add(antRom, gcBsp);
        gcBsp.gridx = 1;
        boligsokerpanel.add(antRomfelt, gcBsp);
        gcBsp.gridx = 2;
        boligsokerpanel.add(utleiepris, gcBsp);
        gcBsp.gridx = 3;
        boligsokerpanel.add(utleieprisfelt, gcBsp);

        gcBsp.gridx = 0;
        gcBsp.gridwidth = 4;
        gcBsp.gridy = 4;
        gcBsp.insets.top = 5;
        boligsokerpanel.add(bspKrav1, gcBsp);
        
        gcBsp.gridy = 5;
        boligsokerpanel.add(bspKrav3, gcBsp);
        
        gcBsp.gridy = 6;
        gcBsp.insets.top = 5;
        boligsokerpanel.add(bspKrav2, gcBsp);
        
        gcBsp.insets.top = 15;
        gcBsp.gridy = 7;
        boligsokerpanel.add(bspKnapper, gcBsp);
        
        utleierpanel.setVisible(false);
        boligsokerpanel.setVisible(false);
        
        gc.gridx = 0;
        gc.gridy = 16;
        gc.gridwidth = 4;
        c.add(utleierpanel, gc);
        c.add(boligsokerpanel, gc);
        
        setSize(600, 500);
        setLocationRelativeTo(null);
        setVisible( true);
    }

    private class SjekkboksLytter implements ChangeListener
    {
        public void stateChanged(ChangeEvent e)
        {
            if(utleier.isSelected())
            {
                utleierpanel.setVisible(true);
                boligsokerpanel.setVisible(false);
            }
            else if(boligsoker.isSelected())
            {
                utleierpanel.setVisible(false);
                boligsokerpanel.setVisible(true);
            }
        }
    }
    
    private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{   
		       String fornavn = fornavnfelt.getText();
		       String etternavn = etternavnfelt.getText();
		       String email = emailfelt.getText();
		       String adresse = adressefelt.getText();
		       String telefon = telefonfelt.getText();
		       String yrke = yrkefelt.getText();
		       String poststed = poststedfelt.getText();
		       int postnr = Integer.parseInt(postnrfelt.getText());
		       
			if(e.getSource() == boligregistrerknapp)
			{
				Person person = new Boligsoker(fornavn, etternavn, adresse, postnr, poststed, email, telefon);
			    register.settInnPerson(person);
			}
			else if(e.getSource() == utleierregistrerknapp)
			{
				Person person = new Utleier(fornavn, etternavn, adresse, postnr, poststed, email, telefon);
			    register.settInnPerson(person);
			}
		}
	}		
}
    
   
