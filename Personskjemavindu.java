
/* Vindu som tar seg av registrering av utleiere og boligsokere.
 * Laget av Akil
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Personskjemavindu extends JFrame
{
    private JTextField fornavn, etternavn, adresse, poststed, postnr, telefon, email, firma, yrke, 
            antPersoner, kravFraStr, kravTilStr, kravMinAntRom, kravMaksPris, kravMinByggeaar;
    private JButton lagre, slett, avbryt;
    private JCheckBox husdyr, royker, kravEnebolig, kravRekkehus, kravLeilighet;
    private JRadioButton utleier, boligsoker;
    private JComboBox <String> sivilstatus, arbeidsforhold;
    private SjekkboksLytter sjekkboksLytter;
    private JPanel utleierpanel, boligsokerpanel;
    private Lytter lytter;
    private Boligregister register;
    private Personpanel personpanelet;
    private Person personen;
    private Boligskjemavindu boligvinduet;
    private Boligpanel boligpanelet;
	private final Font LITENFONT = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
    
    public Personskjemavindu(Boligregister br, Boligskjemavindu bsv)
    {
    	super("Registrer utleier");
    	register = br;
    	boligvinduet = bsv;
    	lagVindu();
        
        utleier.setSelected(true);
        utleier.setEnabled(false);
        boligsoker.setEnabled(false);
    }
    
    public Personskjemavindu(Boligregister br, Boligskjemavindu bsv, Utleier u)
    {
    	super("Registrer utleier");
    	register = br;
    	boligvinduet = bsv;
    	lagVindu();
    	fyllutfelter(u);
        
        personen = u;
    }

    public Personskjemavindu(Boligregister br, Boligpanel bp)
    {
    	super("Registrer ny boligsoker");
    	register = br;
    	boligpanelet = bp;
    	lagVindu();
        
        boligsoker.setSelected(true);
        utleier.setEnabled(false);
        boligsoker.setEnabled(false);
    }
    

    public Personskjemavindu(Boligregister br, Boligpanel bp, Person p)
    {
    	super("Oppdater boligsoker");
    	register = br;
    	boligpanelet = bp;
    	lagVindu();
    	fyllutfelter(p);
        
        personen = p;
    }


    public Personskjemavindu(Boligregister br, Personpanel pl)
    {
        super("Registrer ny person");
        register = br;
        personpanelet = pl;
        lagVindu();
    }

    public Personskjemavindu(Boligregister br, Personpanel pl, Person p)
    {
        super("Oppdater person");
        register = br;
        personpanelet = pl;
        lagVindu();
    	fyllutfelter(p);
        
        personen = p;
    }
    
    
    public void fyllutfelter(Person p)
    {
    	fornavn.setText(p.getFornavn());
        etternavn.setText(p.getEtternavn());
        email.setText(p.getEmail());
        adresse.setText(p.getAdresse());
        telefon.setText(p.getTelefon());
        postnr.setText(String.valueOf(p.getPostnr()));
        poststed.setText(p.getPoststed());
        utleier.setEnabled(false);
        boligsoker.setEnabled(false);
    	slett.setVisible(true);

        if(p instanceof Boligsoker)
        {
            Boligsoker b = ((Boligsoker) p);
            boligsoker.setSelected(true);

            if (b.getAntallPersoner() != 0)
            	antPersoner.setText(b.getAntallPersoner() + "");
            
            yrke.setText(b.getYrke());
            husdyr.setSelected(b.getHusdyr());
            royker.setSelected(b.getRoyker());
            
            if (b.getSivilstatus() != null && !b.getSivilstatus().isEmpty())
                sivilstatus.setSelectedItem(b.getSivilstatus());

            if (b.getArbeidsforhold() != null && !b.getArbeidsforhold().isEmpty())
                arbeidsforhold.setSelectedItem(b.getArbeidsforhold());

            // kravfelter start
            kravEnebolig.setSelected(b.getKravEnebolig());
            kravRekkehus.setSelected(b.getKravRekkehus());
            kravLeilighet.setSelected(b.getKravLeilighet());
            
            if (b.getKravArealFra() != 0)
            	kravFraStr.setText(b.getKravArealFra() + "");
            if (b.getKravArealTil() != 0)
            	kravTilStr.setText(b.getKravArealTil() + "");
            if (b.getKravMaksUtleiepris() != 0)
            	kravMaksPris.setText(b.getKravMaksUtleiepris() + "");
            if (b.getKravMinAntRom() != 0)
            	kravMinAntRom.setText(b.getKravMinAntRom() + "");
            if (b.getKravMinByggeaar() != 0)
            	kravMinAntRom.setText(b.getKravMinByggeaar() + "");
            // kravfelter slutt
        }
        else
        {
            Utleier u = ((Utleier) p);
            utleier.setSelected(true);
            firma.setText(u.getFirma());
        }
    }

    public void lagVindu()
    {
        lytter = new Lytter();
        sjekkboksLytter = new SjekkboksLytter();
        
        Container c = getContentPane();
        c.setLayout(new GridBagLayout());

        fornavn = new JTextField(10);
        etternavn = new JTextField(10);
        adresse = new JTextField(10);
        postnr = new JTextField(10);
        poststed = new JTextField(10);
        telefon = new JTextField(10);
        email = new JTextField(10);

        firma = new JTextField(10);

        sivilstatus = new JComboBox<>();
        arbeidsforhold = new JComboBox<>();

        sivilstatus.addItem("<Velg sivilstatus>");
        sivilstatus.addItem("Gift");
        sivilstatus.addItem("Ugift");
        sivilstatus.addItem("Enke");
        sivilstatus.addItem("Enkemann");

        arbeidsforhold.addItem("<Velg arbeidsforhold>");
        arbeidsforhold.addItem("Arbeider");
        arbeidsforhold.addItem("Student");
        arbeidsforhold.addItem("<html>Arbeidsl&oslash;s</html>");
        arbeidsforhold.addItem("Pensjonist");

        lagre = new JButton("Lagre");
        lagre.addActionListener(lytter);
        slett = new JButton("Slett");
        slett.addActionListener(lytter);
        slett.setVisible(false);
        avbryt = new JButton("Avbryt");
        avbryt.addActionListener(lytter);


        // ##############################
        // FELLES FELTER START
        // ##############################
        JPanel personopplysninger = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.WEST;

        gc.gridy = 0;
        gc.gridx = 0;
        personopplysninger.add(new JLabel("* Fornavn: "), gc);
        gc.gridx = 1;
        gc.insets.right = 5;
        personopplysninger.add(fornavn, gc);
        gc.insets.right = 0;
        gc.gridx = 2;
        personopplysninger.add(new JLabel("* Etternavn: "), gc);
        gc.gridx = 3;
        personopplysninger.add(etternavn, gc);
        
        gc.gridy = 1;
        gc.gridx = 0;
        personopplysninger.add(new JLabel("* Adresse: "), gc);
        gc.gridx = 1;
        personopplysninger.add(adresse, gc);
        gc.gridx = 2;
        personopplysninger.add(new JLabel("* Poststed: "), gc);
        gc.gridx = 3;
        personopplysninger.add(poststed, gc);
        
        gc.gridy = 2;
        gc.gridx = 0;
        personopplysninger.add(new JLabel("* Postnummer: "), gc);
        gc.gridx = 1;
        personopplysninger.add(postnr, gc);
        gc.gridx = 2;
        personopplysninger.add(new JLabel("* Telefon: "), gc);
        gc.gridx = 3;
        personopplysninger.add(telefon, gc);
        
        gc.gridy = 3;
        gc.gridx = 0;
        personopplysninger.add(new JLabel("* Email: "), gc);
        gc.gridx = 1;
        personopplysninger.add(email, gc);
        
        gc.gridy = 4;
        gc.gridx = 0;
        gc.gridwidth = 4;
        gc.insets.left = 5;
        gc.insets.top = 5;
        JLabel notis = new JLabel("* felter markert med stjerne er obligatoriske");
        notis.setFont(LITENFONT);
        personopplysninger.add(notis, gc);
        
        GridBagConstraints gc0 = new GridBagConstraints();
        gc0.anchor = GridBagConstraints.WEST;
        gc0.gridy = 0;
        c.add(personopplysninger);
        
        utleier = new JRadioButton("Utleier");
        utleier.addChangeListener(sjekkboksLytter);
        boligsoker = new JRadioButton("Boligsoker");
        boligsoker.addChangeListener(sjekkboksLytter);
        ButtonGroup bg = new ButtonGroup();
        bg.add(utleier);
        bg.add(boligsoker);
        
        JPanel typepanel = new JPanel();
        typepanel.add(utleier);
        typepanel.add(boligsoker);

        gc0.gridy = 1;
        gc0.insets.top = 10;
        c.add(typepanel, gc0);        
        // ##############################
        // FELLES FELTER SLUTT
        // ##############################



        // ##############################
        // UTLEIERPANEL START
        // ##############################
        utleierpanel = new JPanel(new GridBagLayout());
        utleierpanel.setVisible(false);
        
        GridBagConstraints gcUp = new GridBagConstraints();
        gcUp.anchor = GridBagConstraints.WEST;

        gcUp.gridy = 0;
        gcUp.gridx = 0;
        utleierpanel.add(new JLabel("Firma: "), gcUp);

        gcUp.gridx = 1;
        gcUp.gridwidth = 3;
        utleierpanel.add(firma, gcUp);
        // ##############################
        // UTLEIERPANEL SLUTT
        // ##############################




        // ##############################
        // BOLIGSOKERPANEL START
        // ##############################

        antPersoner = new JTextField(4);
        yrke = new JTextField(10);
        husdyr = new JCheckBox("Husdyr");
        royker = new JCheckBox("<html>R&oslash;yker</html>");
        
        kravEnebolig = new JCheckBox("Enebolig");
        kravRekkehus = new JCheckBox("Rekkehus");
        kravLeilighet = new JCheckBox("Leilighet");
        kravFraStr = new JTextField(5);
        kravTilStr = new JTextField(5);
        kravMinAntRom = new JTextField(4);
        kravMaksPris = new JTextField(6);
        kravMinByggeaar = new JTextField(6);
        
        JPanel bsOpplysninger = new JPanel(new GridBagLayout());
        bsOpplysninger.setBorder(BorderFactory.createTitledBorder("OPPLYSNINGER"));
        GridBagConstraints gcOpplysninger = new GridBagConstraints();
        gcOpplysninger.gridy = 0;
        gcOpplysninger.anchor = GridBagConstraints.WEST;
        
        JPanel bsOpplLinje1 = new JPanel(new GridBagLayout());
        bsOpplLinje1.add(new JLabel("Antall personer: "));
        bsOpplLinje1.add(antPersoner);
        GridBagConstraints gcbso = new GridBagConstraints();
        gcbso.insets.left = 5;
        gcbso.insets.bottom = 5;
        bsOpplLinje1.add(new JLabel("Yrke: "), gcbso);
        bsOpplLinje1.add(yrke);
        bsOpplysninger.add(bsOpplLinje1, gcOpplysninger);
        
        gcOpplysninger.gridy = 1;
        JPanel bsOpplLinje2 = new JPanel(new GridBagLayout());
        bsOpplLinje2.add(husdyr);
        bsOpplLinje2.add(royker);
        bsOpplysninger.add(bsOpplLinje2, gcOpplysninger);
        
        gcOpplysninger.gridy = 2;
        gcOpplysninger.insets.top = 5;
        JPanel bsOpplLinje3 = new JPanel(new GridBagLayout());
        GridBagConstraints gcbsoL3 = new GridBagConstraints();
        gcbsoL3.insets.right = 10;
        bsOpplLinje3.add(sivilstatus, gcbsoL3);
        bsOpplLinje3.add(arbeidsforhold);
        bsOpplysninger.add(bsOpplLinje3, gcOpplysninger);
        
        JPanel bsKrav = new JPanel(new GridBagLayout());
        bsKrav.setBorder(BorderFactory.createTitledBorder("KRAV TIL BOLIG"));
        
        JPanel bsKravLinje1 = new JPanel();
        bsKravLinje1.add(kravEnebolig);
        bsKravLinje1.add(kravRekkehus);
        bsKravLinje1.add(kravLeilighet);
        
        JPanel bsKravLinje2 = new JPanel();
        bsKravLinje2.add(new JLabel("Boareal fra (kvm): "));
        bsKravLinje2.add(kravFraStr);
        bsKravLinje2.add(new JLabel("til: "));
        bsKravLinje2.add(kravTilStr);
        
        JPanel bsKravLinje3 = new JPanel();
        bsKravLinje3.add(new JLabel("Maks pris kr/mnd: "));
        bsKravLinje3.add(kravMaksPris);
        bsKravLinje3.add(new JLabel("Min.ant. rom: "));
        bsKravLinje3.add(kravMinAntRom);
        
        JPanel bsKravLinje4 = new JPanel();
        bsKravLinje4.add(new JLabel("<html>Minimum bygge&aring;r: </html>"));
        bsKravLinje4.add(kravMinByggeaar);

        GridBagConstraints gcKrav = new GridBagConstraints();
        gcKrav.anchor = GridBagConstraints.WEST;
        gcKrav.gridy = 0;
        bsKrav.add(bsKravLinje1, gcKrav);
        gcKrav.gridy = 1;
        bsKrav.add(bsKravLinje2, gcKrav);
        gcKrav.gridy = 2;
        bsKrav.add(bsKravLinje3, gcKrav);
        gcKrav.gridy = 3;
        bsKrav.add(bsKravLinje4, gcKrav);
        
        boligsokerpanel = new JPanel(new GridBagLayout());
        boligsokerpanel.setVisible(false);
        GridBagConstraints bsgc = new GridBagConstraints();
        bsgc.anchor = GridBagConstraints.WEST;
        bsgc.gridy = 0;
        boligsokerpanel.add(bsOpplysninger, bsgc);
        bsgc.gridy = 1;
        bsgc.insets.top = 15;
        boligsokerpanel.add(bsKrav, bsgc);
        // ##############################
        // BOLIGSOKERPANEL SLUTT
        // ##############################



        // ##############################
        // KNAPPEPANEL START
        // ##############################

        JPanel venstreknapper = new JPanel(new GridBagLayout());
        venstreknapper.add(lagre);
        GridBagConstraints gck = new GridBagConstraints();
        gck.insets.left = 5;
        venstreknapper.add(slett, gck);
        
        JPanel knappepanel = new JPanel(new BorderLayout());
        knappepanel.add(venstreknapper, BorderLayout.WEST);
        knappepanel.add(avbryt, BorderLayout.EAST);

        // ##############################
        // KNAPPEPANEL SLUTT
        // ##############################
        

        gc0.gridy = 2;
        c.add(utleierpanel, gc0);
        c.add(boligsokerpanel, gc0);
        gc0.gridy = 3;
        gc0.insets.top = 10;
        gc0.fill = GridBagConstraints.HORIZONTAL;
        c.add(knappepanel, gc0);

        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible( true);
    }

    private class SjekkboksLytter implements ChangeListener
    {
        public void stateChanged(ChangeEvent e)
        {
            if(utleier.isSelected())
            {
                setSize(600, 400);
                setLocationRelativeTo(null);
                utleierpanel.setVisible(true);
                boligsokerpanel.setVisible(false);
            }
            else if(boligsoker.isSelected())
            {
                setSize(600, 600);
                setLocationRelativeTo(null);
                utleierpanel.setVisible(false);
                boligsokerpanel.setVisible(true);
            }
        }
    }

    public boolean erTall( String s )
    {
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
                dispose();
            else
            {
            	boolean bUtleier = utleier.isSelected();
            	boolean bBoligsoker = boligsoker.isSelected();
            	
            	if(e.getSource() == slett)
	            {
	            	if (bUtleier)
	            		if (register.utleierHarBoliger((Utleier)personen))
	            		{
	            			visMelding("Kan ikke slette, denne utleier har boliger.", "");
	            			return;
	            		}
	            	
	            	
	            	if (JOptionPane.showConfirmDialog( null, "Er du sikker pï¿½ï¿½ at du vil slette personen? Dette kan ikke reverseres.",
	            			"Bekreft", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION)
	            	{
		            	register.slettPerson(personen);
		                
		                if (personpanelet != null)
			                if (bUtleier)
			                	personpanelet.oppdaterUtleierliste();
			                else
			                	personpanelet.oppdaterBoligsokerliste();
	                    
	                    if (boligvinduet != null)
	                    	boligvinduet.oppdaterUtleierliste(null);
		                
	                    if (boligpanelet != null)
	                    	boligpanelet.oppdaterBoligsokerliste(null);

	                    visMelding("Personen er slettet.", "");
	                    
		                dispose();
	            	}
	            }
            	else if(e.getSource() == lagre)
            	{
            		String sFornavn = fornavn.getText();
                    String sEtternavn = etternavn.getText();
                    String sAdresse = adresse.getText();
                    String sPostnr = postnr.getText();
                    String sPoststed = poststed.getText();
                    String sTelefon = telefon.getText();
                    String sEmail = email.getText();
                    String sFirma = firma.getText();
                    String sYrke = yrke.getText();
                    String sAntpersoner = antPersoner.getText();
                    boolean bHusdyr = husdyr.isSelected();
                    boolean bRoyker = royker.isSelected();
                    boolean bKravEnebolig = kravEnebolig.isSelected();
                    boolean bKravRekkehus = kravRekkehus.isSelected();
                    boolean bKravLeilighet = kravLeilighet.isSelected();
                    String sKravFraStr = kravFraStr.getText();
                    String sKravTilStr = kravTilStr.getText();
                    String sKravMinAntRom = kravMinAntRom.getText();
                    String sKravMaksPris = kravMaksPris.getText();
                    String sKravMinByggeaar = kravMinByggeaar.getText();
                    
                    String feilmelding = "";
                    
                    if (sFornavn.isEmpty() || sEtternavn.isEmpty() || sAdresse.isEmpty() || sPostnr.isEmpty() ||
                    		sPoststed.isEmpty() || sTelefon.isEmpty())
                        feilmelding += "&#8594; Du m&aring; fylle inn alle felter som er merket med stjerne.<br>";
                    
                    if (!erTall(sPostnr) || sPostnr.length() != 4)
                    	feilmelding += "&#8594; Postnummer m&aring; v&aelig;re et tall p&aring; 4 siffer.<br>";
                    
                    if (bBoligsoker)
                    {
                    	if ((!sAntpersoner.isEmpty() && !erTall(sAntpersoner)) ||
                    			(!sKravFraStr.isEmpty() && !erTall(sKravFraStr)) ||
                    			(!sKravTilStr.isEmpty() && !erTall(sKravTilStr)) ||
                    			(!sKravMinAntRom.isEmpty() && !erTall(sKravMinAntRom)) ||
                    			(!sKravMaksPris.isEmpty() && !erTall(sKravMaksPris)) ||
                    			(!sKravMinByggeaar.isEmpty() && !erTall(sKravMinByggeaar)))
                    		feilmelding += "&#8594; Feil i tallformat. Felter som skal v&aelig;re tall m&aring; v&aelig;re tall.<br>";
                    }
                    
                    if(!sKravFraStr.isEmpty() && erTall(sKravFraStr) && !sKravTilStr.isEmpty() && erTall(sKravTilStr))
                    {
                    	int tilStorrelse = Integer.parseInt(sKravTilStr);
                    	int fraStorrelse = Integer.parseInt(sKravFraStr);

                    	if(tilStorrelse < fraStorrelse)
                    		feilmelding += "&#8594; Til st&oslash;rrelse i boareal kan ikke v&aelig;e mindre enn fra st&oslash;rrelse.<br>";
                    }
                    
                    if (!feilmelding.isEmpty())
                    {
                            JOptionPane.showMessageDialog(null, "<html>" + feilmelding + "</html>", "Problem",
                                    JOptionPane.PLAIN_MESSAGE);
                            return;
                    }
                    
                    if (bUtleier)
                    {
                    	Utleier u;
                    	
                    	if (personen == null)
                    		u = new Utleier(sFornavn, sEtternavn, sAdresse, sPostnr, sPoststed, sEmail, sTelefon);
                    	else
                        {
                            u = (Utleier)personen;
                            u.setFornavn(sFornavn);
                            u.setEtternavn(sEtternavn);
                            u.setAdresse(sAdresse);
                            u.setPostnr(sPostnr);
                            u.setPoststed(sPoststed);
                            u.setTelefon(sTelefon);
                            u.setEmail(sEmail);
                        }
                    	
                        u.setFirma(sFirma);
                        
                        if (personen == null)
                        	register.settInnPerson(u);
                        
                        if (personpanelet != null)
                        	personpanelet.oppdaterUtleierliste();
                        
                        if (boligvinduet != null)
                        	boligvinduet.oppdaterUtleierliste(u);
                    }
                    else if (bBoligsoker)
                    {
                        Boligsoker b;

                        if (personen == null)
                            b = new Boligsoker(sFornavn, sEtternavn, sAdresse, sPostnr, sPoststed, sEmail, sTelefon);
                        else
                        {
                            b = (Boligsoker)personen;
                            b.setFornavn(sFornavn);
                            b.setEtternavn(sEtternavn);
                            b.setAdresse(sAdresse);
                            b.setPostnr(sPostnr);
                            b.setPoststed(sPoststed);
                            b.setTelefon(sTelefon);
                            b.setEmail(sEmail);
                        }
                        
                        b.setYrke(sYrke);
                        
                        if (sAntpersoner.isEmpty())
                            b.setAntallPersoner(0);
                        else
                            b.setAntallPersoner(Integer.parseInt(sAntpersoner));
                        
                        b.setHusdyr(bHusdyr);
                        b.setRoyker(bRoyker);
                        
                        if(sivilstatus.getSelectedIndex() == 0)
                            b.setSivilstatus(null);
                        else
                            b.setSivilstatus(sivilstatus.getSelectedItem().toString());
                        
                        if(arbeidsforhold.getSelectedIndex() == 0)
                            b.setArbeidsforhold(null);
                        else
                            b.setArbeidsforhold(arbeidsforhold.getSelectedItem().toString());
                        
                        b.setKravEnebolig(bKravEnebolig);
                        b.setKravRekkehus(bKravRekkehus);
                        b.setKravLeilighet(bKravLeilighet);
                        
                        if (sKravFraStr.isEmpty())
                        	b.setKravArealFra(0);
                        else
                        	b.setKravArealFra(Integer.parseInt(sKravFraStr));
                        
                        if (sKravTilStr.isEmpty())
                        	b.setKravArealTil(0);
                        else
                        	b.setKravArealTil(Integer.parseInt(sKravTilStr));
                        
                        if (sKravMaksPris.isEmpty())
                        	b.setKravMaksUtleiepris(0);
                        else
                        	b.setKravMaksUtleiepris(Integer.parseInt(sKravMaksPris));
                        
                        if (sKravMinAntRom.isEmpty())
                        	b.setKravMinAntRom(0);
                        else
                        	b.setKravMinAntRom(Integer.parseInt(sKravMinAntRom));
                        
                        if (sKravMinByggeaar.isEmpty())
                        	b.setKravMinByggeaar(0);
                        else
                        	b.setKravMinByggeaar(Integer.parseInt(sKravMinByggeaar));
                        
                        if (personen == null)
                        	register.settInnPerson(b);
                        
                        if (personpanelet != null)
                        	personpanelet.oppdaterBoligsokerliste();
                        
                        if (boligpanelet != null)
                        	boligpanelet.oppdaterBoligsokerliste(b);
                    }
                    
                    String personenEr;
                    
                    if (personen == null)
                    	personenEr = "registrert";
                    else
                    	personenEr = "oppdatert";
                    
                    visMelding("Personen er " + personenEr + ".", "");
                    
                    dispose();
            	}
            }
        }
    }
}
    
   
