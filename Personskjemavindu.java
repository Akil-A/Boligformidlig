

/* Vindu som tar seg av registrering av utleiere og boligsokere.
 * Laget av Akil og Joakim
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.*;


public class Personskjemavindu extends JFrame
{
    private JTextField fornavnfelt, etternavnfelt, emailfelt, adressefelt, telefonfelt, yrkefelt, poststedfelt,
            postnrfelt, antPersonerfelt, beliggenhetfelt, fraStorrelsefelt, tilStorrelsefelt, antRomfelt, utleieprisfelt,
            firmafelt, testfelt, byggeaarfelt;
    private JLabel forNavn, etterNavn, email, adresse, telefon, yrke, poststed, postnr, antPersoner, beliggenhet,
            fraStorrelse, tilStorrelse, antRom, utleiepris, firma, test, byggeaar;
    private JButton uSlett, bSlett, uRegBolig, uRegPerson, bRegPerson, uLagre, bLagre, avbryt;
    private JCheckBox utleier, boligsoker, husdyr, balkong, royker, hage, heis, parkering, enebolig, leilighet, rekkehus;
    private JComboBox <String> sivilstatus, arbeidsforhold;
    private SjekkboksLytter sjekkboksLytter;
    private GridBagConstraints gc;
    private Container c;
    private JPanel ulpKnapper, bspKnapper, bspKrav1, typepanel, bspKrav2, bspKrav3, testpanel, feltpanel,
            utleierpanel, boligsokerpanel;
    private Lytter lytter;
    private Random generator;//////////************************?????????????************************////////////
    private Boligregister register;
    private Personpanel pl;
    private Person personen;
    private Boligskjemavindu boligvinduet;
    
    
    public Personskjemavindu(Boligregister br, Boligskjemavindu bsv)
    {
    	super("Registrer utleier");
    	register = br;
    	boligvinduet = bsv;
    	lagVindu();
    	
    	uLagre.setVisible(false);
        bLagre.setVisible(false);
        uSlett.setVisible(false);
        bSlett.setVisible(false);
        uRegBolig.setVisible(false);
        
        utleier.setSelected(true);
        utleier.setEnabled(false);
        boligsoker.setEnabled(false);
    }


    public Personskjemavindu(Boligregister br, Personpanel pl)
    {
        super("Registrer person");
        register = br;
        this.pl = pl;
        lagVindu();
        
        uLagre.setVisible(false);
        bLagre.setVisible(false);
        uSlett.setVisible(false);
        bSlett.setVisible(false);
    }

    public Personskjemavindu(Boligregister br, Personpanel pl, Person p)
    {
        super("Oppdater person");
        register = br;
        this.pl = pl;
        lagVindu();
        
        personen = p;
        
        uRegPerson.setVisible(false);
        fornavnfelt.setText(p.getFornavn());
        etternavnfelt.setText(p.getEtternavn());
        emailfelt.setText(p.getEmail());
        adressefelt.setText(p.getAdresse());
        telefonfelt.setText(p.getTelefon());
        poststedfelt.setText(p.getPoststed());
        postnrfelt.setText(String.valueOf(p.getPostnr()));
        utleier.setEnabled(false);
        boligsoker.setEnabled(false);

        if(p instanceof Boligsoker)
        {
            Boligsoker bso = ((Boligsoker) p);

            String antallRom = (bso.getAntallRom() == 0) ? "" : bso.getAntallRom() + "";
            String antPersoner = (bso.getAntallPersoner() == 0) ? "" : bso.getAntallPersoner() + "";
            String fraStorrelse = (bso.getFraStorrelse() == 0) ? "" : bso.getFraStorrelse() + "";
            String tilStorrelse = (bso.getTilStorrelse() == 0) ? "" : bso.getTilStorrelse() + "";
            String utleiepris = (bso.getUtleiepris() == 0) ? "" : bso.getUtleiepris() + "";

            antRomfelt.setText(antallRom);
            antPersonerfelt.setText(antPersoner);
            fraStorrelsefelt.setText(fraStorrelse);
            tilStorrelsefelt.setText(tilStorrelse);
            yrkefelt.setText(bso.getYrke());
            utleieprisfelt.setText(utleiepris);

            royker.setSelected(bso.isRoyker());
            husdyr.setSelected(bso.isHusdyr());


            if (bso.getSivilstatus() != null && !bso.getSivilstatus().isEmpty())
                sivilstatus.setSelectedItem(bso.getSivilstatus());

            if (bso.getArbeidsforhold() != null && !bso.getArbeidsforhold().isEmpty())
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
        lytter = new Lytter();
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
        byggeaarfelt = new JTextField(10);

        forNavn = new JLabel("* Fornavn: ");
        etterNavn = new JLabel("* Etternavn: ");
        adresse = new JLabel("* Adresse: ");
        telefon = new JLabel("* Telefonnummer: ");
        yrke = new JLabel("Yrke: ");
        email = new JLabel("* Email: ");
        poststed = new JLabel("* Poststed: ");
        postnr = new JLabel("* Postnr: ");
        antPersoner = new JLabel("Antall personer: ");
        beliggenhet = new JLabel("Beliggenhet: ");
        fraStorrelse = new JLabel("Fra storrelse: ");
        tilStorrelse = new JLabel("Til storrelse: ");
        antRom = new JLabel("Antall rom: ");
        utleiepris = new JLabel("Utleiepris: ");
        firma = new JLabel("Firma: ");
        test = new JLabel("Hva er " + randNr1 + " + " + randNr2);
        byggeaar = new JLabel("Byggeaar");


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


        uRegPerson = new JButton("Registrer ny person");
        uRegPerson.addActionListener(lytter);
        uSlett = new JButton("Slett");
        uSlett.addActionListener(lytter);
        uRegBolig = new JButton("Registrer ny bolig paa meg");
        uRegBolig.addActionListener(lytter);
        bSlett = new JButton("Slett");
        bSlett.addActionListener(lytter);
        bRegPerson = new JButton("Registrer ny person");
        bRegPerson.addActionListener(lytter);
        uLagre = new JButton("Lagre");
        uLagre.addActionListener(lytter);
        bLagre = new JButton("Lagre");
        bLagre.addActionListener(lytter);
        avbryt = new JButton("Avbryt");
        avbryt.addActionListener(lytter);

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
        c.add(emailfelt, gc);

        gc.insets.left = 20;
        gc.gridx = 2;
        c.add(poststed, gc);
        gc.gridx = 3;
        c.add(poststedfelt, gc);

        gc.gridy = 3;

        gc.insets.left = 0;
        gc.gridx = 0;
        c.add(postnr, gc);
        gc.gridx = 1;
        c.add(postnrfelt, gc);



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

        ulpKnapper.add(uRegPerson);
        ulpKnapper.add(uRegBolig);
        ulpKnapper.add(uLagre);
        ulpKnapper.add(uSlett);

        bspKnapper.add(bRegPerson);
        bspKnapper.add(bLagre);
        bspKnapper.add(bSlett);

        gc.gridwidth = 4;
        gc.insets.left = -17;
        gc.insets.top = 15;
        gc.gridx = 0;
        gc.gridy = 15;
        c.add(typepanel, gc);

        /******* UTLEIERPANEL ********/
        utleierpanel = new JPanel(new GridBagLayout());
        GridBagConstraints gcUp = new GridBagConstraints();
        gcUp.anchor = GridBagConstraints.WEST;

        gcUp.gridy = 0;
        gcUp.gridx = 0;
        gcUp.insets.left = 15;
        utleierpanel.add(firma, gcUp);

        gcUp.gridx = 1;
        gcUp.gridwidth = 3;
        utleierpanel.add(firmafelt, gcUp);
        gcUp.gridwidth = 0;


        gcUp.gridy = 3;
        gcUp.insets.top = 10;
        utleierpanel.add(ulpKnapper, gcUp);




        /******* BOLIGSOKERPANEL ********/
        boligsokerpanel = new JPanel(new GridBagLayout());
        GridBagConstraints gcBsp = new GridBagConstraints();
        gcBsp.anchor = GridBagConstraints.WEST;


        gcBsp.gridy = 0;

        gcBsp.gridx = 0;
        boligsokerpanel.add(antPersoner, gcBsp);
        gcBsp.gridx = 1;
        boligsokerpanel.add(antPersonerfelt, gcBsp);
        gcBsp.insets.left = 20;
        gcBsp.gridx = 2;
        boligsokerpanel.add(beliggenhet, gcBsp);
        gcBsp.gridx = 3;
        boligsokerpanel.add(beliggenhetfelt, gcBsp);

        gcBsp.gridy = 1;

        gcBsp.insets.left = 0;
        gcBsp.gridx = 0;
        boligsokerpanel.add(fraStorrelse, gcBsp);
        gcBsp.gridx = 1;
        boligsokerpanel.add(fraStorrelsefelt, gcBsp);
        gcBsp.insets.left = 20;
        gcBsp.gridx = 2;
        boligsokerpanel.add(tilStorrelse, gcBsp);
        gcBsp.gridx = 3;
        boligsokerpanel.add(tilStorrelsefelt, gcBsp);

        gcBsp.gridy = 2;

        gcBsp.insets.left = 0;
        gcBsp.gridx = 0;
        boligsokerpanel.add(antRom, gcBsp);
        gcBsp.gridx = 1;
        boligsokerpanel.add(antRomfelt, gcBsp);
        gcBsp.insets.left = 20;
        gcBsp.gridx = 2;
        boligsokerpanel.add(utleiepris, gcBsp);
        gcBsp.gridx = 3;
        boligsokerpanel.add(utleieprisfelt, gcBsp);

        gcBsp.insets.left = 0;
        gcBsp.gridy = 3;
        gcBsp.gridx = 0;
        boligsokerpanel.add(byggeaar, gcBsp);
        gcBsp.gridx = 1;
        boligsokerpanel.add(byggeaarfelt, gcBsp);

        gcBsp.insets.left = 20;
        gcBsp.gridx = 2;
        boligsokerpanel.add(yrke, gcBsp);
        gcBsp.gridx = 3;
        boligsokerpanel.add(yrkefelt, gcBsp);

        gcBsp.insets.left = 0;
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

        gcUp.anchor = GridBagConstraints.CENTER;
        gcUp.gridwidth = 2;
        gcUp.gridy = 17;
        c.add(avbryt, gcUp);

        setSize(700, 600);
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

    public boolean erTom( String s )
    {
        return s.equals("");
    }

    public boolean erTall( String s )
    {
        if (erTom(s))
            return true;

        try
        {
            Integer.parseInt( s );
            return true;
        }
        catch( Exception e )
        {
            return false;
        }
    }
    
    public void visMelding(String meldingen, String tittel)
    {
    	JOptionPane.showMessageDialog(null,  meldingen, tittel, JOptionPane.PLAIN_MESSAGE);
    }

    private class Lytter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == avbryt)
            {
                dispose();
            }
            else if(e.getSource() == uRegBolig)
            {
                //Boligskjemavindu bsv = new Boligskjemavindu(register);
            }
            else if(e.getSource() == uSlett || e.getSource() == bSlett)
            {
            	if (e.getSource() == uSlett)
    			{
            		Utleier u = (Utleier)personen;
            	
            		if (u.getBoliger().size() > 0)
            		{
            			visMelding("Kan ikke slette, denne utleier har boliger.", "Problem");
            			return;
            		}
    			}
            	
            	
            	///////  kontrollsporsmaal
            	
            	
                int personNr = personen.getPersonNr();
                register.slettPerson(personNr);
                
                if (e.getSource() == uSlett)
                	pl.slettUtleier(personen);
                else
                	pl.slettBoligsoker(personen);
                
                dispose();
            }
            else
            {
                String feilmelding = "";
                String feilmelding1 = "";

                String fornavn = fornavnfelt.getText();
                String etternavn = etternavnfelt.getText();
                String email = emailfelt.getText();
                String adresse = adressefelt.getText();
                String postnr = postnrfelt.getText();
                String poststed = poststedfelt.getText();
                String telefon = telefonfelt.getText();
                String yrke = yrkefelt.getText();
                boolean butleier = utleier.isSelected();
                boolean bboligsoker = boligsoker.isSelected();
                String firma = firmafelt.getText();
                String togst = beliggenhet.getText(); // endre navn
                String antpersoner = antPersonerfelt.getText();
                String frastr = fraStorrelsefelt.getText();
                String tilstr = tilStorrelsefelt.getText();
                String antrom = antRomfelt.getText();
                String pris = utleieprisfelt.getText();
                String byggeaar = byggeaarfelt.getText();
                boolean bhusdyr = husdyr.isSelected();
                boolean bbalkong = balkong.isSelected();
                boolean broyker = royker.isSelected();
                boolean bhage = hage.isSelected();
                boolean bheis = heis.isSelected();
                boolean bparkering = parkering.isSelected();
                boolean benebolig = enebolig.isSelected();
                boolean brekkehus = rekkehus.isSelected();
                boolean bleilighet = leilighet.isSelected();


                if (erTom(fornavn) || erTom(etternavn) || erTom(adresse) || erTom(postnr) || erTom(poststed) || erTom(telefon))
                    feilmelding += "Du maa fylle inn alle felter som er merket med stjerne.\n\n\n";

                if (!erTall(postnr))
                {
                    feilmelding1 += "Postnr\n";
                }

                if (butleier)
                {
                    // validering for utleier hvis det trengs
                }
                else if (bboligsoker)
                {
                        if (!erTom(antpersoner) && !erTall(antpersoner))
                            feilmelding1 += "Antall personer\n";
                        if  (!erTom(frastr) && !erTall(frastr))
                            feilmelding1 += "Fra storrelse\n";
                        if (!erTom(tilstr) && !erTall(tilstr))
                            feilmelding1 += "Til storrelse\n";
                        if (!erTom(antrom) && !erTall(antrom))
                            feilmelding1 += "Antall rom\n";
                        if(!erTom(pris) && !erTall(pris))
                            feilmelding1 += "Utleiepris\n";
                        if(!erTom(byggeaar) && !erTall(byggeaar))
                            feilmelding1 += "Byggeaar\n.";
                }
                String s = "";
                if(!erTom(feilmelding1))
                {
                    s = "Feltene som er nevnt nedenfor maa inneholde tall, vennligst rett disse feltene:\n\n";
                    s+=feilmelding1;
                }

                if (!erTom(feilmelding) || !erTom(s))
                {
                        JOptionPane.showMessageDialog(null, feilmelding + s, "Problem",
                                JOptionPane.PLAIN_MESSAGE);
                        return;
                }




                if (bboligsoker)
                {
                    Boligsoker b;

                    if (e.getSource() == bRegPerson)
                        b = new Boligsoker(fornavn, etternavn, adresse, Integer.parseInt(postnr), poststed, email, telefon);
                    else
                    {
                        b = (Boligsoker)personen;
                        b.setFornavn(fornavn);
                        b.setEtternavn(etternavn);
                        b.setAdresse(adresse);
                        b.setPostnr(Integer.parseInt(postnr));
                        b.setPoststed(poststed);
                        b.setTelefon(telefon);
                        b.setEmail(email);
                    }


                    if (!erTom(antpersoner))
                        b.setAntallPersoner(Integer.parseInt(antpersoner));
                    if (!erTom(frastr))
                        b.setFraStorrelse(Integer.parseInt(frastr));
                    if (!erTom(tilstr))
                        b.setTilStorrelse(Integer.parseInt(tilstr));
                    if (!erTom(antrom))
                        b.setAntallRom(Integer.parseInt(antrom));
                    if (!erTom(pris))
                        b.setUtleiepris(Integer.parseInt(pris));


                    b.setTogst(togst); // endre navn
                    b.setHusdyr(bhusdyr);
                    b.setBalkong(bbalkong);
                    b.setRoyker(broyker);
                    b.setHage(bhage);
                    b.setHeis(bheis);
                    b.setParkering(bparkering);
                    b.setEnebolig(benebolig);
                    b.setRekkehus(brekkehus);
                    b.setLeilighet(bleilighet);
                    b.setYrke(yrke);

                    if (e.getSource() == bRegPerson)
                    {
                        register.settInnPerson(b);
                        
                        if (pl != null)
                        	pl.addBoligsoker(b);
                    }

                    if (pl != null)
                    	pl.oppdaterBoligsokerliste();
                    
                    
                    
                }
                else if (butleier)
                {
                    Utleier u;

                    if(e.getSource() == uRegPerson)
                        u = new Utleier(fornavn, etternavn, adresse, Integer.parseInt(postnr), poststed, email, telefon);
                    else
                    {
                        u = (Utleier)personen;
                        u.setFornavn(fornavn);
                        u.setEtternavn(etternavn);
                        u.setAdresse(adresse);
                        u.setPostnr(Integer.parseInt(postnr));
                        u.setPoststed(poststed);
                        u.setTelefon(telefon);
                        u.setEmail(email);
                    }

                    u.setFirma(firma);

                    if (e.getSource() == uRegPerson)
                    {
                        register.settInnPerson(u);
                        
                        if (pl != null)
                        	pl.addUtleier(u);
                    }
                                    

                    if (pl != null)
                    	pl.oppdaterUtleierliste();
                    
                    if (boligvinduet != null)
                    	boligvinduet.oppdaterUtleierliste();
                }
                
                dispose();
            }
        }
    }
}
    
   
