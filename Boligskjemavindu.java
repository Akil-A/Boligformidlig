/* Vindusklasse med felter. Her kan man registrere ny bolig eller oppdatere bolig.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Boligskjemavindu extends JFrame
{
	final private String BILDEMAPPE = "bilder" + File.separator;
	private JComboBox<String> harKjeller, harGarasje, harVaskeri;
	private String[] combovalg = { "Ikke oppgitt", "Ja", "Nei" };
	private JComboBox<Utleier> utleiere;
	private JRadioButton enebolig, rekkehus, leilighet;
	private JTextField tittel, adresse, postnr, poststed, togst, boareal, antrom, byggeaar, pris, antetasjer, tomtestr,
							liggerietasje, bildeSti;
	private CLytter clytter;
	private Lytter lytter;
	private JPanel eneboligrekkehusfelt, leilighetfelt;
	private JButton lagre, avbryt, velgBilde, fjernBilde;
	private Boligpanel boligpanelet;
	private Boligregister registret;
	private Bolig boligen;
	private File bildet;
	
	public Boligskjemavindu(Boligregister br)
	{
		super("Registrer ny bolig");
		registret = br;
		lagVindu();
	}
	
	public Boligskjemavindu(Boligregister br, Boligpanel bp)
	{
		super("Registrer ny bolig");
		registret = br;
		boligpanelet = bp;
		lagVindu();
	}

	public Boligskjemavindu(Boligregister br, Boligpanel bp, Bolig b)
	{
		super("Oppdater bolig");
		registret = br;
		boligpanelet = bp;
		boligen = b;
		lagVindu();
		
		tittel.setText(b.getTittel());
		utleiere.setSelectedItem(registret.finnPerson(b.getUtleierId()));
		
		if (b.getBildefilnavn() != null && !b.getBildefilnavn().isEmpty())
		{
			bildet = new File(BILDEMAPPE + b.getBildefilnavn());
			bildeSti.setText(b.getBildefilnavn());
		}
		
		adresse.setText(b.getAdresse());
		postnr.setText(Integer.toString(b.getPostnr()));
		poststed.setText(b.getPoststed());
		togst.setText(b.getTogst());
		boareal.setText(Integer.toString(b.getBoareal()));
		antrom.setText(Integer.toString(b.getAntrom()));
		byggeaar.setText(Integer.toString(b.getByggeaar()));
		pris.setText(Integer.toString(b.getUtleiepris()));

		enebolig.setEnabled(false);
		rekkehus.setEnabled(false);
		leilighet.setEnabled(false);
		
		if (b instanceof Enebolig)
		{
			enebolig.setSelected(true);
			
			Enebolig c = (Enebolig)b;
			
			if (c.getTomtestr() != null)
				tomtestr.setText(c.getTomtestr() + "");

			if (c.getAntetasjer() != null)
				antetasjer.setText(c.getAntetasjer() + "");
			
			if (c.isKjeller() == null)
				harKjeller.setSelectedIndex(0);
			else if (c.isKjeller())
				harKjeller.setSelectedIndex(1);
			else if (!c.isKjeller())
				harKjeller.setSelectedIndex(2);
		}
		else if (b instanceof Rekkehus)
		{
			rekkehus.setSelected(true);
			
			Rekkehus c = (Rekkehus)b;
			
			if (c.getTomtestr() != null)
				tomtestr.setText(c.getTomtestr() + "");

			if (c.getAntetasjer() != null)
				antetasjer.setText(c.getAntetasjer() + "");
			
			if (c.isKjeller() == null)
				harKjeller.setSelectedIndex(0);
			else if (c.isKjeller())
				harKjeller.setSelectedIndex(1);
			else if (!c.isKjeller())
				harKjeller.setSelectedIndex(2);
		}
		else if (b instanceof Leilighet)
		{
			leilighet.setSelected(true);
			
			Leilighet c = (Leilighet)b;
			
			if (c.getEtasje() != null)
				liggerietasje.setText(c.getEtasje() + "");
			
			if (c.getGarasje() == null)
				harGarasje.setSelectedIndex(0);
			else if (c.getGarasje())
				harGarasje.setSelectedIndex(1);
			else if (!c.getGarasje())
				harGarasje.setSelectedIndex(2);
			
			
			if (c.getVaskeri() == null)
				harVaskeri.setSelectedIndex(0);
			else if (c.getVaskeri())
				harVaskeri.setSelectedIndex(1);
			else if (!c.getVaskeri())
				harVaskeri.setSelectedIndex(2);
		}
	}
	
	private void lagVindu()
	{
		/********* DEFINISJON AV KOMPONENTER START *********/
        clytter = new CLytter();
        lytter = new Lytter();
        tittel = new JTextField(25);
		adresse = new JTextField(10);
		postnr = new JTextField(10);
		poststed = new JTextField(10);
		togst = new JTextField(10);
		boareal = new JTextField(10);
		antrom = new JTextField(10);
		byggeaar = new JTextField(10);
		pris = new JTextField(10);
		enebolig = new JRadioButton("Enebolig");
		enebolig.addChangeListener(clytter);
		rekkehus = new JRadioButton("Rekkehus");
		rekkehus.addChangeListener(clytter);
		leilighet = new JRadioButton("Leilighet");
		leilighet.addChangeListener(clytter);
        ButtonGroup boligtype = new ButtonGroup();
        boligtype.add(enebolig);
        boligtype.add(rekkehus);
        boligtype.add(leilighet);
        lagre = new JButton("Lagre");
        lagre.addActionListener(lytter);
        avbryt = new JButton("Avbryt");
        avbryt.addActionListener(lytter);
        velgBilde = new JButton("Velg bilde");
        velgBilde.addActionListener(lytter);
        bildeSti = new JTextField(15);
        bildeSti.setEditable(false);
        fjernBilde = new JButton("Fjern bilde");
        fjernBilde.addActionListener(lytter);
		/********* DEFINISJON AV KOMPONENTER SLUTT *********/
        
		JPanel velgBildePanel = new JPanel();
		velgBildePanel.add(velgBilde);
		velgBildePanel.add(bildeSti);
		velgBildePanel.add(fjernBilde);
        
		
		
		
		/***** UTFYLLING AV UTLEIERBOKS START *****/
		utleiere = new JComboBox<>();
		utleiere.addActionListener(lytter);
		oppdaterUtleierliste(null);
		/***** UTFYLLING AV UTLEIERBOKS SLUTT *****/
		
        
        
        
		
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
        
		

		/********* TOPPANEL START *********/
		JPanel toppanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.insets.left = 5;
		gc.gridy = 0;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		toppanel.add(new JLabel("* Annonsetittel"), gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.WEST;
		gc.gridwidth = 3;
		toppanel.add(tittel, gc);
		gc.gridwidth = 1;
		
		gc.gridy = 1;
		
		gc.gridx = 0;
		gc.anchor = GridBagConstraints.EAST;
		toppanel.add(new JLabel("* Utleier"), gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.WEST;
		gc.gridwidth = 3;
		toppanel.add(utleiere, gc);
		gc.gridwidth = 1;
		
		gc.gridy = 2;

		gc.gridx = 0;
		gc.insets.bottom = 20;
		gc.anchor = GridBagConstraints.EAST;
		toppanel.add(new JLabel("Bilde"), gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.WEST;
		gc.gridwidth = 3;
		toppanel.add(velgBildePanel, gc);
		gc.anchor = GridBagConstraints.EAST;
		gc.gridwidth = 1;
		gc.insets.bottom = 0;
		
		gc.gridy = 3;
		
		gc.gridx = 0;
		toppanel.add(new JLabel("* Adresse"), gc);
		gc.gridx = 1;
		toppanel.add(adresse, gc);
		gc.gridx = 2;
		toppanel.add(new JLabel("* Boareal (kvm)"), gc);
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.WEST;
		toppanel.add(boareal, gc);
		gc.anchor = GridBagConstraints.EAST;
		
		gc.gridy = 4;
		
		gc.gridx = 0;
		toppanel.add(new JLabel("* Postnr"), gc);
		gc.gridx = 1;
		toppanel.add(postnr, gc);
		gc.gridx = 2;
		toppanel.add(new JLabel("* Antall rom"), gc);
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.WEST;
		toppanel.add(antrom, gc);
		gc.anchor = GridBagConstraints.EAST;
		
		gc.gridy = 5;
		
		gc.gridx = 0;
		toppanel.add(new JLabel("* Poststed"), gc);
		gc.gridx = 1;
		toppanel.add(poststed, gc);
		gc.gridx = 2;
		toppanel.add(new JLabel("* Byggeaar"), gc);
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.WEST;
		toppanel.add(byggeaar, gc);
		gc.anchor = GridBagConstraints.EAST;

		gc.gridy = 6;
		
		gc.gridx = 0;
		toppanel.add(new JLabel("Naermeste togstasjon"), gc);
		gc.gridx = 1;
		toppanel.add(togst, gc);
		gc.gridx = 2;
		toppanel.add(new JLabel("* Pris kr/mnd"), gc);
		gc.gridx = 3;
		gc.anchor = GridBagConstraints.WEST;
		toppanel.add(pris, gc);
		gc.anchor = GridBagConstraints.EAST;
		/********* TOPPANEL SLUTT *********/
		
		
		
		
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridy = 0;
		
		c.add(toppanel, gc);
		
		JPanel velgBoligtype = new JPanel();
		velgBoligtype.add(enebolig);
		velgBoligtype.add(rekkehus);
		velgBoligtype.add(leilighet);
		
		
		
		
		

		/********* ENEBOLIG OG REKKEHUSFELT START *********/
		eneboligrekkehusfelt = new JPanel(new GridBagLayout());
		GridBagConstraints erGc = new GridBagConstraints();

		erGc.gridx = 0;
		erGc.gridy = 0;

		JPanel elinje1 = new JPanel();
		
		tomtestr = new JTextField(3);
		elinje1.add(new JLabel("Tomtestorrelse (kvm):"));
		elinje1.add(tomtestr);

		antetasjer = new JTextField(3);
		elinje1.add(new JLabel("Antall etasjer:"));
		elinje1.add(antetasjer);

		JPanel elinje2 = new JPanel();
		
		harKjeller = new JComboBox<>(combovalg);
		
		elinje2.add(new JLabel("Kjeller: "));
		elinje2.add(harKjeller);

		eneboligrekkehusfelt.add(elinje1, erGc);
		erGc.gridy = 1;
		eneboligrekkehusfelt.add(elinje2, erGc);
		/********* ENEBOLIG OG REKKEHUSFELT SLUTT *********/
		
		
		

		/********* LEILIGHETFELT START *********/
		leilighetfelt = new JPanel(new GridBagLayout());
		GridBagConstraints lhGc = new GridBagConstraints();

		lhGc.gridx = 0;
		lhGc.gridy = 0;
		
		JPanel llinje1 = new JPanel();
		llinje1.add(new JLabel("Hvilken etasje ligger leiligheten i?"));
		liggerietasje = new JTextField(3);
		llinje1.add(liggerietasje);

		leilighetfelt.add(llinje1, lhGc);

		JPanel llinje2 = new JPanel();
		
		harGarasje = new JComboBox<>(combovalg);
		harVaskeri = new JComboBox<>(combovalg);

		llinje2.add(new JLabel("Garasje: "));
		llinje2.add(harGarasje);
		llinje2.add(new JLabel("Vaskeri: "));
		llinje2.add(harVaskeri);

		lhGc.gridy = 1;
		leilighetfelt.add(llinje2, lhGc);
		/********* LEILIGHETFELT SLUTT *********/
				
		
		
		
		eneboligrekkehusfelt.setVisible(false);
    	leilighetfelt.setVisible(false);
		
		gc.gridy = 1;

		c.add(velgBoligtype, gc);
		
		gc.gridy = 2;
		
		c.add(eneboligrekkehusfelt, gc);
		c.add(leilighetfelt, gc);
		
		gc.gridy = 3;
		gc.insets.top = 20;
		
		JPanel knappepanel = new JPanel(new BorderLayout());
		knappepanel.add(lagre, BorderLayout.WEST);
		knappepanel.add(new JLabel("     **Felter markert med stjerne er obligatoriske**"), BorderLayout.CENTER);
		knappepanel.add(avbryt, BorderLayout.EAST);
		
		gc.fill = GridBagConstraints.HORIZONTAL;
		c.add(knappepanel, gc);

		setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible( true );
	}


	// FYLLER UT UTLEIERBOKSEN
	public void oppdaterUtleierliste(Object valgtUtleier)
	{
		utleiere.removeAllItems();
		for (Utleier u : registret.getUtleiere())
		{
			utleiere.addItem(u);
		}
        utleiere.insertItemAt(new Utleier("<Velg utleier>", "", "", 0, "", "", ""), 0);
        utleiere.insertItemAt(new Utleier("<Ny utleier ...>", "", "", 0, "", "", ""), 1);
        
        if (valgtUtleier == null)
        	utleiere.setSelectedIndex(0);
        else
        	utleiere.setSelectedItem(valgtUtleier);
	}
	
	public boolean erTall( String s )
	{
		if (s.isEmpty())
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
	
	private void visMelding(String meldingen, String tittel)
	{
		JOptionPane.showMessageDialog( null, meldingen, tittel, JOptionPane.PLAIN_MESSAGE);
	}
    
    private class CLytter implements ChangeListener
	{
	    public void stateChanged(ChangeEvent e)
	    {
	    	if (enebolig.isSelected() || rekkehus.isSelected())
	        {
	        	eneboligrekkehusfelt.setVisible(true);
	        	leilighetfelt.setVisible(false);
	    		setSize(600, 450);
	        }
	        else if (leilighet.isSelected())
	        {
	        	eneboligrekkehusfelt.setVisible(false);
	        	leilighetfelt.setVisible(true);
	    		setSize(600, 450);
	        }
	    }
	}

	private class Lytter implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		if (e.getSource() == lagre)
    		{
    			String feilmelding = "";
    			
    			String stittel = tittel.getText();
    			String sadresse = adresse.getText();
    			String spostnr = postnr.getText();
    			String spoststed = poststed.getText();
    			String stogst = togst.getText();
    			String sboareal = boareal.getText();
    			String santrom = antrom.getText();
    			String sbyggeaar = byggeaar.getText();
    			String spris = pris.getText();
    			boolean benebolig = enebolig.isSelected();
    			boolean brekkehus = rekkehus.isSelected();
    			boolean bleilighet = leilighet.isSelected();
    			String stomtestr = tomtestr.getText();
    			String santetasjer = antetasjer.getText();
    			String sliggerietasje = liggerietasje.getText();
    			
    			if (utleiere.getSelectedIndex() == 0 || utleiere.getSelectedIndex() == 1 || stittel.isEmpty() ||
    					sadresse.isEmpty() || spoststed.isEmpty() || sboareal.isEmpty() ||
    					sbyggeaar.isEmpty() || spris.isEmpty())
    				feilmelding += "- Du maa fylle inn alle paakrevde felter.\n";
    			
    			if (!erTall(spostnr) || spostnr.length() != 4 || !erTall(sboareal) || 
    					!erTall(santrom) || !erTall(sbyggeaar) || !erTall(spris) || 
    					(
    							(benebolig || brekkehus) &&
    							(!erTall(stomtestr) || !erTall(santetasjer))
    					)
    					||
    					(
    							bleilighet &&
    							!erTall(sliggerietasje)
    					)
    				)
    				feilmelding += "- Feil i tallformat.\n";
    			
    			if (!benebolig && !brekkehus && !bleilighet)
    				feilmelding += "- Du maa velge en boligtype (enebolig, rekkehus, leilighet)\n";
    			
	            if (!feilmelding.isEmpty())
	            {	            	
	            	JOptionPane.showMessageDialog( null, "Vennligst rett folgende feil for du gaar videre:\n\n" + feilmelding, "Problem",
	            			JOptionPane.PLAIN_MESSAGE);
	            	return;
	            }
	            
	            if (benebolig)
	            {
	            	Enebolig b = new Enebolig(sadresse, Integer.parseInt(spostnr), spoststed, Integer.parseInt(spris));
	            	
	            	b.setTittel(stittel);
	            	b.setUtleierId(((Utleier) utleiere.getSelectedItem()).getPersonNr());
	            	b.setAntrom(Integer.parseInt(santrom));
	            	b.setBoareal(Integer.parseInt(sboareal));
	            	b.setByggeaar(Integer.parseInt(sbyggeaar));
	            	b.setTogst(stogst);
	            	
	            	// Under: enebolig-spesifikke felt
	            	
	            	if (stomtestr.isEmpty())
	            		b.setTomtestr(null);
	            	else
	            		b.setTomtestr(Integer.parseInt(stomtestr));
	            	
	            	if (santetasjer.isEmpty())
	            		b.setAntetasjer(null);
	            	else
	            		b.setAntetasjer(Integer.parseInt(santetasjer));
	            	
	            	
	            	if (harKjeller.getSelectedIndex() == 0)
	            		b.setKjeller(null);
	            	else if (harKjeller.getSelectedIndex() == 1)
	            		b.setKjeller(true);
	            	else if (harKjeller.getSelectedIndex() == 2)
	            		b.setKjeller(false);
	            	
	            	
	            	if (bildet != null)
	            	{
	            		if (bildeSti.getText().isEmpty())
	            			bildet.delete();
	            		else
	            		{
		            		try
							{
								BufferedImage utbilde = ImageIO.read(bildet);
								
								File utfil = new File(BILDEMAPPE + bildet.getName());
								
								String filnavn = bildet.getName();
								String format = filnavn.substring(filnavn.lastIndexOf(".") + 1);
								
								ImageIO.write(utbilde, format, utfil);
								b.setBildefilnavn(filnavn);
							}
							catch (IOException e1)
							{
								visMelding(e1.getMessage(), "Feil");
							}
	            		}
	            	}
	            	
	            	if (boligen != null)
	            		registret.oppdaterBolig(boligen.getBoligNr(), b);
	            	else
	            		registret.settInnBolig(b);
	            }
	            else if (brekkehus)
	            {
	            	Rekkehus b = new Rekkehus(sadresse, Integer.parseInt(spostnr), spoststed, Integer.parseInt(spris));
	            	
	            	b.setTittel(stittel);
	            	b.setUtleierId(((Utleier) utleiere.getSelectedItem()).getPersonNr());
	            	b.setAntrom(Integer.parseInt(santrom));
	            	b.setBoareal(Integer.parseInt(sboareal));
	            	b.setByggeaar(Integer.parseInt(sbyggeaar));
	            	b.setTogst(stogst);
	            	
	            	// Under: enebolig-spesifikke felt
	            	
	            	if (stomtestr.isEmpty())
	            		b.setTomtestr(null);
	            	else
	            		b.setTomtestr(Integer.parseInt(stomtestr));
	            	
	            	if (santetasjer.isEmpty())
	            		b.setAntetasjer(null);
	            	else
	            		b.setAntetasjer(Integer.parseInt(santetasjer));
	            	
	            	
	            	if (harKjeller.getSelectedIndex() == 0)
	            		b.setKjeller(null);
	            	else if (harKjeller.getSelectedIndex() == 1)
	            		b.setKjeller(true);
	            	else if (harKjeller.getSelectedIndex() == 2)
	            		b.setKjeller(false);
	            	
	            	
	            	if (bildet != null)
	            	{
	            		if (bildeSti.getText().isEmpty())
	            			bildet.delete();
	            		else
	            		{
		            		try
							{
								BufferedImage utbilde = ImageIO.read(bildet);
								
								File utfil = new File(BILDEMAPPE + bildet.getName());
								
								String filnavn = bildet.getName();
								String format = filnavn.substring(filnavn.lastIndexOf(".") + 1);
								
								ImageIO.write(utbilde, format, utfil);
								b.setBildefilnavn(filnavn);
							}
							catch (IOException e1)
							{
								visMelding(e1.getMessage(), "Feil");
							}
	            		}
	            	}
	            	
	            	if (boligen != null)
	            		registret.oppdaterBolig(boligen.getBoligNr(), b);
	            	else
	            		registret.settInnBolig(b);
	            }
	            else if (bleilighet)
	            {
	            	Leilighet b = new Leilighet(sadresse, Integer.parseInt(spostnr), spoststed, Integer.parseInt(spris));
	            	
	            	b.setTittel(stittel);
	            	b.setUtleierId(((Utleier) utleiere.getSelectedItem()).getPersonNr());
	            	b.setAntrom(Integer.parseInt(santrom));
	            	b.setBoareal(Integer.parseInt(sboareal));
	            	b.setByggeaar(Integer.parseInt(sbyggeaar));
	            	b.setTogst(stogst);
	            	
	            	// Under: leilighet-spesifikke felt
	            	
	            	if (sliggerietasje.isEmpty())
	            		b.setEtasje(null);
	            	else
	            		b.setEtasje(Integer.parseInt(sliggerietasje));
	            	
	            	
	            	if (harGarasje.getSelectedIndex() == 0)
	            		b.setGarasje(null);
	            	else if (harGarasje.getSelectedIndex() == 1)
	            		b.setGarasje(true);
	            	else if (harGarasje.getSelectedIndex() == 2)
	            		b.setGarasje(false);
	            	
	            	
	            	if (harVaskeri.getSelectedIndex() == 0)
	            		b.setVaskeri(null);
	            	else if (harVaskeri.getSelectedIndex() == 1)
	            		b.setVaskeri(true);
	            	else if (harVaskeri.getSelectedIndex() == 2)
	            		b.setVaskeri(false);
	            	
	            	
	            	if (bildet != null)
	            	{
	            		if (bildeSti.getText().isEmpty())
	            			bildet.delete();
	            		else
	            		{
		            		try
							{
								BufferedImage utbilde = ImageIO.read(bildet);
								
								File utfil = new File(BILDEMAPPE + bildet.getName());
								
								String filnavn = bildet.getName();
								String format = filnavn.substring(filnavn.lastIndexOf(".") + 1);
								
								ImageIO.write(utbilde, format, utfil);
								b.setBildefilnavn(filnavn);
							}
							catch (IOException e1)
							{
								visMelding(e1.getMessage(), "Feil");
							}
	            		}
	            	}
	            	
	            	if (boligen != null)
	            		registret.oppdaterBolig(boligen.getBoligNr(), b);
	            	else
	            		registret.settInnBolig(b);
	            }
	            
	            String lagremelding;
	            
	            if (boligen == null)
	            	lagremelding = "Boligen er registrert.";
	            else
	            	lagremelding = "Boligen er oppdatert.";
	            	
	            JOptionPane.showMessageDialog( null, lagremelding, "Melding",
            			JOptionPane.PLAIN_MESSAGE);
	            
    			if (boligpanelet != null)
    				boligpanelet.listBoliger(false);
    			
    			dispose();
    		}
    		else if(e.getSource() == velgBilde)
    		{
    			JFileChooser filvelger = new JFileChooser();
    			filvelger.setAcceptAllFileFilterUsed(false);
    			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG, GIF og PNG-filer", "jpg", "jpeg", "gif", "png");
    			filvelger.setFileFilter(filter);
    			
    			int resultat = filvelger.showOpenDialog(null);
    			
    			if (resultat == JFileChooser.APPROVE_OPTION)
    			{
    				bildet = filvelger.getSelectedFile();
    				bildeSti.setText(bildet.getName());
    			}
    		}
    		else if(e.getSource() == fjernBilde)
    		{
    			bildeSti.setText("");
    		}
    		else if(e.getSource() == utleiere && ((JComboBox)e.getSource()).getSelectedIndex() == 1)
    			new Personskjemavindu(registret, Boligskjemavindu.this);
    		else if(e.getSource() == avbryt)
    			dispose();
    	}
    }
}
