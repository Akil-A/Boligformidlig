import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class Personskjemavindu extends JFrame
{
    private JTextField forNavnfelt;
    private JTextField etterNavnfelt;
    private JTextField emailfelt;
    private JTextField adressefelt;
    private JTextField telefonfelt;
    private JTextField yrkefelt;
    private JTextField poststedfelt;
    private JTextField postnrfelt;
    private JTextField antPersonerfelt;
    private JTextField beliggenhetfelt;
    private JTextField fraStorrelsefelt;
    private JTextField tilStorrelsefelt;
    private JTextField antRomfelt;
    private JLabel forNavn;
    private JLabel etterNavn;
    private JLabel email;
    private JLabel adresse;
    private JLabel telefon;
    private JLabel yrke;
    private JLabel poststed;
    private JLabel postnr;
    private JLabel antPersoner;
    private JLabel beliggenhet;
    private JLabel fraStorrelse;
    private JLabel tilStorrelse;
    private JLabel antRom;
    private JButton seBoligknapp;
    private JButton slettknapp1;
    private JButton slettknapp2;
    private JButton registrerknapp;
    private JButton finnBoligknapp;
    private JTextArea tekstomraade;
    private JCheckBox utleier;
    private JCheckBox boligsoker;
    private JCheckBox husdyr;
    private JCheckBox balkong;
    private JCheckBox royker;
    private JCheckBox hage;
    private JCheckBox heis;
    private JCheckBox parkering;
    private JCheckBox enebolig;
    private JCheckBox leilighet;
    private JCheckBox rekkehus;
    private JComboBox <String> sivilstatus;
    private JComboBox <String> arbeidsforhold;
    private SjekkboksLytter sjekkboksLytter;
    private GridBagConstraints gc;
    private Container c;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JPanel p5;


    public Personskjemavindu()
    {
        super("Personskjemavindu");

        sjekkboksLytter = new SjekkboksLytter();

        forNavnfelt = new JTextField(10);
        etterNavnfelt = new JTextField(10);
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
        
        sivilstatus = new JComboBox<>();
        arbeidsforhold = new JComboBox<>();

        sivilstatus.addItem("Gift");
        sivilstatus.addItem("Ugift");
        sivilstatus.addItem("Enke");

        arbeidsforhold.addItem("");
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

        tekstomraade = new JTextArea();

        seBoligknapp = new JButton("Se mine boliger");
        //addlistener
        slettknapp1 = new JButton("Slett");
        //addlisteer
        registrerknapp = new JButton("Registrer ny bolig paa meg");
        //addlistener
        slettknapp2 = new JButton("Slett");

        finnBoligknapp = new JButton("Finn bolig");

        ButtonGroup bg = new ButtonGroup();
        bg.add(utleier);
        bg.add(boligsoker);

        c = getContentPane();
        c.setLayout(new GridBagLayout());


        gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.WEST;
        gc.insets.left = 2;
        gc.insets.top = 2;

        gc.gridy = 0;
        
        gc.gridx = 0;
        c.add(forNavn, gc);
        gc.gridx = 1;
        c.add(forNavnfelt, gc);
        gc.gridx = 2;
        c.add(etterNavn, gc);
        gc.gridx = 3;
        c.add(etterNavnfelt, gc);

        gc.gridy = 1;
        
        gc.gridx = 0;
        c.add(adresse, gc);
        gc.gridx = 1;
        c.add(adressefelt, gc);
        gc.gridx = 2;
        c.add(telefon, gc);
        gc.gridx = 3;
        c.add(telefonfelt, gc);

        gc.gridy = 2;
        
        gc.gridx = 0;
        c.add(email, gc);
        gc.gridx = 1;
        c.add(emailfelt, gc);
        gc.gridx = 2;
        c.add(yrke, gc);
        gc.gridx = 3;
        c.add(yrkefelt, gc);

        gc.gridy = 3;
        
        gc.gridx = 0;
        c.add(postnr, gc);
        gc.gridx = 1;
        c.add(postnrfelt, gc);
        gc.gridx = 2;
        c.add(poststed, gc);
        gc.gridx = 3;
        c.add(poststedfelt, gc);

        gc.gridy = 4;
        
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
        
        gc.gridx = 0;
        c.add(fraStorrelse, gc);
        gc.gridx = 1;
        c.add(fraStorrelsefelt, gc);
        gc.gridx = 2;
        c.add(tilStorrelse, gc);
        gc.gridx = 3;
        c.add(tilStorrelsefelt, gc);

        gc.gridy = 6;
        
        gc.gridx = 0;
        c.add(antRom, gc);
        gc.gridx = 1;
        c.add(antRomfelt, gc);

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();

        p4.add(utleier);

        p4.add(boligsoker);

        p3.add(husdyr);

        p3.add(balkong);

        p3.add(royker);

        p3.add(hage);

        p3.add(heis);

        p3.add(parkering);

        p5.add(sivilstatus);

      /*  gc.gridx = 3;
        gc.gridy = 15;
        p5.add(boligtype);*/

        p5.add(arbeidsforhold);

        p1.add(seBoligknapp);

        p1.add(slettknapp1);

        p1.add(registrerknapp);

        p2.add(finnBoligknapp);

        p2.add(slettknapp2);
        
        gc.gridwidth = 4;
        gc.gridx = 0;
        gc.gridy = 15;
        c.add(p4, gc);

        gc.gridy = 17;
        c.add(p3, gc);

        gc.gridy = 23;
        c.add(p2, gc);

        gc.gridy = 20;
        c.add(p5, gc);

        gc.gridy = 23;
        c.add(p1, gc);

        setSize( 700, 700 );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        p2.setVisible(false);
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
