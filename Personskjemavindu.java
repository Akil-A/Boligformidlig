package prosjekttest;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;


public class Personskjemavindu extends JFrame
{
    private JTextField navnfelt;
    private JTextField adressefelt;
    private JTextField telefonfelt;
    private JTextField yrke;
    private JTextField antPersoner;
    private JTextField beliggenhet;
    private JTextField fraStorrelse;
    private JTextField tilStorrelse;
    private JTextField antRom;
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
    private JCheckBox husdyr;
    private JCheckBox balkong;
    private JCheckBox royker;
    private JCheckBox hage;
    private JCheckBox heis;
    private JCheckBox parkering;
    private JComboBox <String> sivilstatus;
    private JComboBox <String> boligtype;
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

        navnfelt = new JTextField(10);
        adressefelt = new JTextField(10);
        telefonfelt = new JTextField(10);
        yrke = new JTextField(10);
        antPersoner = new JTextField(10);
        beliggenhet = new JTextField(10);
        fraStorrelse = new JTextField(10);
        tilStorrelse = new JTextField(10);
        antRom = new JTextField(10);

        navn = new JLabel("Navn: ");
        adresse = new JLabel("Adresse: ");
        telefon = new JLabel("Telefonnummer: ");

        sivilstatus = new JComboBox<>();
        boligtype = new JComboBox<>();
        arbeidsforhold = new JComboBox<>();

        sivilstatus.addItem("Gift");
        sivilstatus.addItem("Ugift");
        sivilstatus.addItem("Enke");

        boligtype.addItem("Enebolig");
        boligtype.addItem("Leilighet");
        boligtype.addItem("Rekkehus");

        arbeidsforhold.addItem("Arbeider");
        arbeidsforhold.addItem("Arbeidslos");
        arbeidsforhold.addItem("Pensjonist");

        utleier = new JCheckBox("Utleier");
        boligsoker = new JCheckBox("Boligsoker");
        husdyr = new JCheckBox("Husdyr");
        balkong = new JCheckBox("Balkong");
        royker = new JCheckBox("Royker");
        hage = new JCheckBox("Hage");
        heis = new JCheckBox("Heis");
        parkering = new JCheckBox("Parkering");

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

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();
        p5 = new JPanel();

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
        p4.add(utleier);

        gc.gridx = 1;
        gc.gridy = 8;
        p4.add(boligsoker);

        gc.insets.top = 10;
        gc.gridx = 0;
        gc.gridy = 12;
        p3.add(husdyr);

        gc.insets.top = 10;
        gc.gridx = 1;
        gc.gridy = 12;
        p3.add(balkong);

        gc.insets.top = 10;
        gc.gridx = 2;
        gc.gridy = 12;
        p3.add(royker);

        gc.insets.top = 10;
        gc.gridx = 3;
        gc.gridy = 12;
        p3.add(hage);

        gc.insets.top = 10;
        gc.gridx = 4;
        gc.gridy = 12;
        p3.add(heis);

        gc.insets.top = 10;
        gc.gridx = 5;
        gc.gridy = 12;
        p3.add(parkering);

        gc.gridx = 0;
        gc.gridy = 15;
        p5.add(sivilstatus);

        gc.gridx = 3;
        gc.gridy = 15;
        p5.add(boligtype);

        gc.gridx = 6;
        gc.gridy = 15;
        p5.add(arbeidsforhold);

        gc.insets.top = 20;
        gc.gridx = 0;
        gc.gridy = 18;
        p1.add(seBoligknapp);

        gc.gridx = 0;
        gc.gridy = 19;
        p1.add(slettknapp1);

        gc.gridx = 0;
        gc.gridy = 20;
        p1.add(registrerknapp);

        gc.gridx = 0;
        gc.gridy = 12;
        p2.add(finnBoligknapp);

        gc.gridx = 1;
        gc.gridy = 12;
        p2.add(slettknapp2);

        p2.setVisible(false);

        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 15;
        c.add(p4, gc);

        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 17;
        c.add(p3, gc);

        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 19;
        c.add(p2, gc);

        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 20;
        c.add(p5, gc);

        gc.gridwidth = 2;
        gc.gridx = 0;
        gc.gridy = 23;
        c.add(p1, gc);

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
