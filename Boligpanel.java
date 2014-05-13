// Vinduskomponent hvor man søker og lister opp boliger.

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class Boligpanel extends JPanel
{
	private JTextField adr, postnr, poststed, beliggenhet, prisfra, pristil, boarealfra, boarealtil, byggeaar, annonsedato,
							tomtfra, tomttil, antetgfra, antetgtil;
	private JCheckBox visledige, visutleide, enebolig, rekkehus, leilighet, kjeller, garasje, vask, maaliggeiforste,
							vismatch, visinteresser;
	private JComboBox<Boligsoker> boligsokere;
	private JComboBox<Utleier> utleiere; ///////////////////////////////////////////////////////!!!!!!!!!!!!!###########¤¤¤¤¤¤
	private JComboBox<String> sortering;
	private JPanel pEneRekke, pLeilighet, hoyreFilterPanel;
	private JScrollPane venstreFilterPanel, listePanel;
	private JButton boligsokerdetaljer = new JButton("Detaljer"), sok, nullstill, registrer;
	private JLabel antallresultater;
	private Boligregister register;
	private final String ANNONSEDATO_EKS_TEKST = "eks: 21/06/2013";
	private final Font LITENKURSIVFONT = new Font(Font.SANS_SERIF, Font.ITALIC, 11);
	private final Font LITENFONT = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
	private boolean genereltSok;
	
	private ArrayList<Bolig> sokeliste; // denne listen inneholder søkeresultatet
	
	public Boligpanel(Boligregister br)
	{
		register = br;
		
		setLayout(new BorderLayout());
 	   	Lytter lytter = new Lytter();

		
		// #####################################################
		// VENSTRE TOPP FILTERPANEL START
		// #####################################################
		adr = new JTextField(20);
		postnr = new JTextField(4);
		poststed = new JTextField(10);
		prisfra = new JTextField(7);
		pristil = new JTextField(7);
		boarealfra = new JTextField(3);
		boarealtil = new JTextField(3);
		byggeaar = new JTextField(4);
		beliggenhet = new JTextField(14);
		annonsedato = new JTextField(9);
		annonsedato.setText("eks: 21/12/2013");
		annonsedato.setForeground(Color.GRAY);
		annonsedato.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent f)
			{
				if(annonsedato.getText().equals(ANNONSEDATO_EKS_TEKST))
				{
					annonsedato.setText("");
					annonsedato.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent f)
			{
				if(annonsedato.getText().isEmpty())
				{
					annonsedato.setText(ANNONSEDATO_EKS_TEKST);
					annonsedato.setForeground(Color.GRAY);
				}
			}
		});
		visledige = new JCheckBox("Vis ledige");
		visledige.setSelected(true);
		visutleide = new JCheckBox("Vis utleide");
		visutleide.setSelected(true);
		enebolig = new JCheckBox("Enebolig");
		enebolig.addActionListener(lytter);
		rekkehus = new JCheckBox("Rekkehus");
		rekkehus.addActionListener(lytter);
		leilighet = new JCheckBox("Leilighet");
		leilighet.addActionListener(lytter);
		tomtfra = new JTextField(3);
		tomttil = new JTextField(3);
		antetgfra = new JTextField(3);
		antetgtil = new JTextField(3);
		kjeller = new JCheckBox("Kjeller");
		garasje = new JCheckBox("Garasje");
		vask = new JCheckBox("Felles vaskeri");
		maaliggeiforste = new JCheckBox("<html>M&aring; ligge i f&oslash;rste etasje</html>");
		
		JPanel pAdresse = new JPanel();
		pAdresse.add(new JLabel("Adresse: "));
		pAdresse.add(adr);
		
		JPanel pBeliggenhet = new JPanel();
		pBeliggenhet.add(new JLabel("<html>N&aelig;rmeste togstasjon: </html>"));
		pBeliggenhet.add(beliggenhet);
		
		JPanel pPost = new JPanel();
		pPost.add(new JLabel("Postnummer: "));
		pPost.add(postnr);
		pPost.add(new JLabel("Poststed: "));
		pPost.add(poststed);
	
		JPanel pAnnonsedato = new JPanel();
		pAnnonsedato.add(new JLabel("Annonsedato fra: "));
		pAnnonsedato.add(annonsedato);
		pAnnonsedato.add(new JLabel("<html>Bygge&aring;r fra: </html>"));
		pAnnonsedato.add(byggeaar);
	    
		JPanel pPrisen = new JPanel();
		pPrisen.add(new JLabel("Pris/mnd"));
		pPrisen.add(new JLabel("fra: "));
		pPrisen.add(prisfra);
		pPrisen.add(new JLabel("til: "));
		pPrisen.add(pristil);
	   
	    JPanel pBoareal = new JPanel();
	    pBoareal.add(new JLabel("Boareal (kvm)"));
	    pBoareal.add(new JLabel("fra: "));
	    pBoareal.add(boarealfra);
	    pBoareal.add(new JLabel("til: "));
	    pBoareal.add(boarealtil);
	    pBoareal.add(visledige);
	    pBoareal.add(visutleide);
		
		JPanel pType = new JPanel();
		pType.add(new JLabel("Type: "));
		pType.add(enebolig);
		pType.add(rekkehus);
		pType.add(leilighet);

	    JPanel pTomt = new JPanel();
	    pTomt.add(new JLabel("<html>Tomtest&oslash;rrelse (kvm)</html>"));
	    pTomt.add(new JLabel("fra:"));
	    pTomt.add(tomtfra);
	    pTomt.add(new JLabel("til: "));
	    pTomt.add(tomttil);

	    JPanel pAntEtg = new JPanel();
	    pAntEtg.add(new JLabel("Antall etasjer"));
	    pAntEtg.add(new JLabel("fra:"));
	    pAntEtg.add(antetgfra);
	    pAntEtg.add(new JLabel("til: "));
	    pAntEtg.add(antetgtil);
	    
		pEneRekke = new JPanel(new GridBagLayout());
		GridBagConstraints enerekkeGC = new GridBagConstraints();
	    
	    enerekkeGC.anchor = GridBagConstraints.CENTER;
	    pEneRekke.add(pTomt, enerekkeGC);
	    enerekkeGC.gridy = 1;
	    pEneRekke.add(pAntEtg, enerekkeGC);
	    enerekkeGC.gridy = 2;
	    pEneRekke.add(kjeller, enerekkeGC);
	    
	    pLeilighet = new JPanel(new GridBagLayout());
	    GridBagConstraints plgc = new GridBagConstraints();

	    plgc.anchor = GridBagConstraints.CENTER;
	    plgc.gridx = 0;
		plgc.gridy = 0;
		JPanel plLinje1 = new JPanel();
		plLinje1.add(garasje);
		plLinje1.add(vask);
		pLeilighet.add(plLinje1, plgc);
		plgc.gridy = 1;
		JPanel plLinje2 = new JPanel();
		plLinje2.add(maaliggeiforste);
		pLeilighet.add(plLinje2, plgc);
		
		pEneRekke.setVisible(false);
		pLeilighet.setVisible(false);
		
		
		final JPanel venstreIndreFilterPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
        

        gc.gridy = 0;
        JLabel tips = new JLabel("<html><center>Skriv hele eller deler av teksten du vil soke p&aring; og trykk S&Oslash;K.<br>" +
        						 "La feltene st&aring; tomme for &aring; vise alle.</center></html>");
        tips.setFont(LITENKURSIVFONT);
        gc.insets.bottom = 5;
        venstreIndreFilterPanel.add(tips, gc);
        gc.insets.bottom = 0;
        
        gc.gridy = 1;
        venstreIndreFilterPanel.add(pAdresse, gc);
        
        gc.gridy = 2;
        venstreIndreFilterPanel.add(pBeliggenhet, gc);
        
        gc.gridy = 3;
        venstreIndreFilterPanel.add(pPost, gc);
      
        gc.gridy = 4;
        venstreIndreFilterPanel.add(pAnnonsedato,gc);
        
        gc.gridy = 5;
        venstreIndreFilterPanel.add(pPrisen, gc);
        
        gc.gridy = 6;
        venstreIndreFilterPanel.add(pBoareal, gc);
       
        gc.gridy = 7;
        venstreIndreFilterPanel.add(pType, gc);
       
        gc.gridy = 8;
        venstreIndreFilterPanel.add(pEneRekke, gc);
        venstreIndreFilterPanel.add(pLeilighet, gc);
        venstreIndreFilterPanel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e)
			{
			}
			public void mouseEntered(MouseEvent e)
			{
			}
			public void mouseExited(MouseEvent e)
			{
			}
			public void mousePressed(MouseEvent e)
			{
				velgVenstreFilterPanel();
				venstreIndreFilterPanel.requestFocus();
			}
			public void mouseReleased(MouseEvent e)
			{
			}
        });
        
        venstreFilterPanel = new JScrollPane(venstreIndreFilterPanel);
		
		// #####################################################
		// VENSTRE TOPP FILTERPANEL SLUTT
		// #####################################################
        

		// #####################################################
		// HOYRE TOPP FILTERPANEL START
		// #####################################################

        boligsokere = new JComboBox<>();
        boligsokere.addActionListener(lytter);
		oppdaterBoligsokerliste(null);
		
		vismatch = new JCheckBox("Vis boliger som matcher krav");
		vismatch.setSelected(true);
		visinteresser = new JCheckBox("<html>Vis boliger som denne boligs&oslash;ker er interessert i<br>(ikke implementert)</html>");
		visinteresser.setSelected(true);
		visinteresser.setEnabled(false);
		
		GridBagConstraints hfGc = new GridBagConstraints();
		hoyreFilterPanel = new JPanel(new GridBagLayout());
		hfGc.insets.bottom = 6;
		hfGc.anchor = GridBagConstraints.NORTH;
		hfGc.gridy = 0;
		JLabel hfTips = new JLabel("<html><center>Velg en boligs&oslash;ker for &aring; finne boliger som matcher<br>vedkommendes &oslash;nsker</center></html>");
		hfTips.setFont(LITENKURSIVFONT);
		hoyreFilterPanel.add(hfTips, hfGc);
		hfGc.gridy = 1;
		JPanel boligsokerpanel = new JPanel();
		boligsokerpanel.add(boligsokere);
		boligsokerdetaljer.addActionListener(lytter);
		boligsokerpanel.add(boligsokerdetaljer);
		boligsokerdetaljer.setEnabled(false);
		hoyreFilterPanel.add(boligsokerpanel, hfGc);
		hfGc.gridy = 2;
		hoyreFilterPanel.add(vismatch, hfGc);
		hfGc.gridy = 3;
		hoyreFilterPanel.add(visinteresser, hfGc);
		hoyreFilterPanel.setPreferredSize(new Dimension(400, hoyreFilterPanel.getHeight()));
		hoyreFilterPanel.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e)
			{
			}
			public void mouseEntered(MouseEvent e)
			{
			}
			public void mouseExited(MouseEvent e)
			{
			}
			public void mousePressed(MouseEvent e)
			{
				velgHoyreFilterPanel();
				hoyreFilterPanel.requestFocus();
			}
			public void mouseReleased(MouseEvent e)
			{
			}
        });

		// #####################################################
		// HOYRE TOPP FILTERPANEL SLUTT
		// #####################################################
        
        
        JPanel filterPanel = new JPanel(new GridBagLayout());
		filterPanel.setBorder(BorderFactory.createTitledBorder("<html>S&oslash;kefilter</html>"));
		filterPanel.setPreferredSize(new Dimension(filterPanel.getWidth(), 320));
        GridBagConstraints gc1 = new GridBagConstraints();
        gc1.anchor = GridBagConstraints.NORTH;
        gc1.gridx = 1;
        filterPanel.add(new JLabel(" -eller- "), gc1);
        gc1.weightx = 1.0;
        gc1.weighty = 1.0;
        gc1.fill = GridBagConstraints.BOTH;
        gc1.gridx = 0;
        filterPanel.add(venstreFilterPanel, gc1);
        gc1.gridx = 2;
        filterPanel.add(hoyreFilterPanel, gc1);

		
		// #####################################################
		// KNAPPEPANEL START
		// #####################################################

		sok = new JButton("<html>S&Oslash;K BOLIGER</html>");
		sok.addActionListener(lytter);
		nullstill = new JButton("NULLSTILL");
		nullstill.addActionListener(lytter);
		antallresultater = new JLabel();
		antallresultater.setFont(LITENFONT);
		String [] combovalg = { "Publisert", "<html>Pris lav-h&oslash;y</html>", "<html>Pris h&oslash;y-lav</html>",
								"<html>Boareal lav-h&oslash;y</html>", "<html>Boareal h&oslash;y-lav</html>"};
		utleiere = new JComboBox<>();
		utleiere.addActionListener(lytter);
		oppdaterUtleierliste(null); // populere comboboxen
		sortering = new JComboBox<>(combovalg);
		sortering.addActionListener(lytter);
		registrer = new JButton("REGISTRER NY");
		registrer.addActionListener(lytter);
		
		JPanel venstreknapper = new JPanel(new GridBagLayout());
		GridBagConstraints gcsk = new GridBagConstraints();
		gcsk.insets.left = 5;
		venstreknapper.add(new JLabel("Utleier:"));
		venstreknapper.add(utleiere, gcsk);
		venstreknapper.add(new JLabel("    "));
		venstreknapper.add(sok);
		venstreknapper.add(nullstill, gcsk);
		venstreknapper.add(antallresultater, gcsk);
		
		JPanel hoyreknapper = new JPanel(new GridBagLayout());
		hoyreknapper.add(new JLabel("Sortering:"));
		hoyreknapper.add(sortering, gcsk);
		gcsk.insets.left = 10;
		hoyreknapper.add(registrer, gcsk);
		
		JPanel knappePanel = new JPanel(new BorderLayout());
		knappePanel.add(venstreknapper, BorderLayout.WEST);
		knappePanel.add(hoyreknapper, BorderLayout.EAST);
		knappePanel.setBorder(BorderFactory.createEmptyBorder(3, 2, 5, 2));
		
		// #####################################################
		// KNAPPEPANEL SLUTT
		// #####################################################

		JPanel nordPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc2 = new GridBagConstraints();
		gc2.anchor = GridBagConstraints.CENTER;
		gc2.gridx = 0;
		gc2.gridy = 0;
		gc2.fill = GridBagConstraints.HORIZONTAL;
		gc2.weightx = 1.0;
		nordPanel.add(filterPanel, gc2);
		gc2.gridy = 1;
		nordPanel.add(knappePanel, gc2);
		
		add(nordPanel, BorderLayout.NORTH);


        leggtilFokuslyttere(venstreIndreFilterPanel, new VenstreFilterFokuslytter());
        leggtilFokuslyttere(hoyreFilterPanel, new HoyreFilterFokuslytter());
        
        utforBlanktSok();
	}
	
	// metode som legger til angitt fokuslytter til alle komponenter i angitt panel
	private void leggtilFokuslyttere(JPanel panelet, FocusListener lytteren)
	{
		for (Component c : panelet.getComponents())
			if (c instanceof JPanel)
				leggtilFokuslyttere((JPanel)c, lytteren);
			else
				c.addFocusListener(lytteren);
	}
	
	// fokuslytter for venstre topp filterpanel
	private class VenstreFilterFokuslytter implements FocusListener
	{
		public void focusGained(FocusEvent e)
		{
			velgVenstreFilterPanel();
		}
		public void focusLost(FocusEvent e)
		{
		}
	}

	// fokuslytter for høyre topp filterpanel
	private class HoyreFilterFokuslytter implements FocusListener
	{
		public void focusGained(FocusEvent e)
		{
			velgHoyreFilterPanel();
		}
		public void focusLost(FocusEvent e)
		{
		}
	}
	
	// marker venstre topp filter
	private void velgVenstreFilterPanel()
	{
		genereltSok = true;
		venstreFilterPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		hoyreFilterPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
	}

	// marker høyre topp filter
	private void velgHoyreFilterPanel()
	{
		genereltSok = false;
		hoyreFilterPanel.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		venstreFilterPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2));
	}
	
	// POPULERER UTLEIER ComboBox
	public void oppdaterUtleierliste(Object valgtUtleier)
	{
		utleiere.removeAllItems();
		for (Utleier b : register.getUtleiereMedBolig())
			utleiere.addItem(b);
		utleiere.insertItemAt(new Utleier("<Vis alle>", "", "", "", "", "", ""), 0);
        
        if (valgtUtleier == null)
        	utleiere.setSelectedIndex(0);
        else
        	utleiere.setSelectedItem(valgtUtleier);
	}
	
	// POPULERER BOLIGSØKER ComboBox
	public void oppdaterBoligsokerliste(Object valgtBoligsoker)
	{
		boligsokere.removeAllItems();
		for (Boligsoker b : register.getBoligsokere())
			boligsokere.addItem(b);
		boligsokere.insertItemAt(new Boligsoker("<html>&lt;Velg boligs&oslash;ker&gt;</html>", "", "", "", "", "", ""), 0);
		boligsokere.insertItemAt(new Boligsoker("<html>&lt;Ny boligs&oslash;ker ...&gt;</html>", "", "", "", "", "", ""), 1);
        
        if (valgtBoligsoker == null)
        	boligsokere.setSelectedIndex(0);
        else
        {
        	boligsokere.setSelectedItem(valgtBoligsoker);
        	boligsokerdetaljer.setEnabled(true);
        }
	}
	
	// sjekk om input-streng kan parses som int
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
	
	// nullstill alle felter og utfør et blankt søk. typisk når man starter programmet for første gang.
	private void utforBlanktSok()
	{
		nullstill();
		sokeliste = new ArrayList<>();
		sokeliste.addAll(register.getBoliger());
		listBoliger();
	}
	
	// utfør et søk utfra hva man har søkt på.
	public void utforSok()
	{
		lagSok();
		listBoliger();
	}
	
	// oppretter en liste med boliger som matcher det man har søkt på.
	private void lagSok()
	{
		sokeliste = new ArrayList<>();
		
		if (genereltSok || boligsokere.getSelectedIndex() == 0 || boligsokere.getSelectedIndex() == 1)
		{
			boolean bVisledige = visledige.isSelected();
			boolean bVisutleide = visutleide.isSelected();
			
			if (bVisledige && !bVisutleide)
				sokeliste.addAll(register.getLedige());
			else if (!bVisledige && bVisutleide)
				sokeliste.addAll(register.getUtleide());
			else
				sokeliste.addAll(register.getBoliger());
			
			String sAdresse = adr.getText();
			String sTogst = beliggenhet.getText();
			String sPostnr = postnr.getText();
			String sPoststed = poststed.getText();
			String sAnnonsedato = annonsedato.getText();
			boolean annonsedatoErDato = sAnnonsedato.matches("^[\\d]{1,2}/[\\d]{1,2}/[\\d]{4}$");
			String sByggeaar = byggeaar.getText();
			String sPrisfra = prisfra.getText();
			String sPristil = pristil.getText();
			String sBoarealfra = boarealfra.getText();
			String sBoarealtil = boarealtil.getText();
			boolean bEnebolig = enebolig.isSelected();
			boolean bRekkehus = rekkehus.isSelected();
			boolean bLeilighet = leilighet.isSelected();
			String sTomtfra = tomtfra.getText();
			String sTomttil = tomttil.getText();
			String sAntetgfra = antetgfra.getText();
			String sAntetgtil = antetgtil.getText();
			boolean bKjeller = kjeller.isSelected();
			boolean bGarasje = garasje.isSelected();
			boolean bVaskeri = vask.isSelected();
			boolean bMaaliggeiforste = maaliggeiforste.isSelected();
			
			ArrayList<Bolig> sokeliste1 = new ArrayList<>();
			
			for (Bolig b : sokeliste)
				if ((utleiere.getSelectedIndex() == 0 || b.getUtleier() == utleiere.getSelectedItem()) &&
							(b.getAdresse().toLowerCase().contains(sAdresse.toLowerCase())) &&
							(b.getTogst().toLowerCase().contains(sTogst.toLowerCase())) &&
							(!erTall(sPostnr) || b.getPostnr().toLowerCase().contains(sPostnr.toLowerCase())) &&
							(b.getPoststed().toLowerCase().contains(sPoststed.toLowerCase())) &&
							(sAnnonsedato.equals(ANNONSEDATO_EKS_TEKST) ||
									sAnnonsedato.isEmpty() || !annonsedatoErDato ||
									new Date(sAnnonsedato).before(b.getAnnonsedato())) &&
							(sByggeaar.isEmpty() || !erTall(sByggeaar) || Integer.parseInt(sByggeaar) <= b.getByggeaar()) &&
							(sPrisfra.isEmpty() || !erTall(sPrisfra) || Integer.parseInt(sPrisfra) <= b.getUtleiepris()) &&
							(sPristil.isEmpty() || !erTall(sPristil) || Integer.parseInt(sPristil) >= b.getUtleiepris()) &&
							(sBoarealfra.isEmpty() || !erTall(sBoarealfra) || Integer.parseInt(sBoarealfra) <= b.getBoareal()) &&
							(sBoarealtil.isEmpty() || !erTall(sBoarealtil) || Integer.parseInt(sBoarealtil) >= b.getBoareal()) &&
							(
									(!bEnebolig && !bRekkehus && !bLeilighet) ||
									(bEnebolig && b instanceof Enebolig &&
											(
													(sTomtfra.isEmpty() || !erTall(sTomtfra) || Integer.parseInt(sTomtfra) <= ((Enebolig)b).getTomtestr()) &&
													(sTomttil.isEmpty() || !erTall(sTomttil) || Integer.parseInt(sTomttil) >= ((Enebolig)b).getTomtestr()) &&
													(sAntetgfra.isEmpty() || !erTall(sAntetgfra) || Integer.parseInt(sAntetgfra) <= ((Enebolig)b).getAntetasjer()) &&
													(sAntetgtil.isEmpty() || !erTall(sAntetgtil) || Integer.parseInt(sAntetgtil) >= ((Enebolig)b).getAntetasjer()) &&
													(!bKjeller || (bKjeller && ((Enebolig)b).isKjeller())
											)) ||
									(bRekkehus && b instanceof Rekkehus &&
											(
													(sTomtfra.isEmpty() || !erTall(sTomtfra) || Integer.parseInt(sTomtfra) <= ((Rekkehus)b).getTomtestr()) &&
													(sTomttil.isEmpty() || !erTall(sTomttil) || Integer.parseInt(sTomttil) >= ((Rekkehus)b).getTomtestr()) &&
													(sAntetgfra.isEmpty() || !erTall(sAntetgfra) || Integer.parseInt(sAntetgfra) <= ((Rekkehus)b).getAntetasjer()) &&
													(sAntetgtil.isEmpty() || !erTall(sAntetgtil) || Integer.parseInt(sAntetgtil) >= ((Rekkehus)b).getAntetasjer()) &&
													(!bKjeller || (bKjeller && ((Enebolig)b).isKjeller())
											)) ||
									(bLeilighet && b instanceof Leilighet &&
											(
													(!bGarasje || (bGarasje && ((Leilighet)b).getGarasje())) &&
													(!bVaskeri || (bVaskeri && ((Leilighet)b).getVaskeri())) &&
													(!bMaaliggeiforste || (bMaaliggeiforste && ((Leilighet)b).getEtasje() == 1))
											))
							))))
					sokeliste1.add(b);
			
			sokeliste = sokeliste1;
		}
		else
		{
			Boligsoker personen = (Boligsoker) boligsokere.getSelectedItem();
			
			if (vismatch.isSelected())
			{
				boolean bKravEnebolig = personen.getKravEnebolig();
				boolean bKravRekkehus = personen.getKravRekkehus();
				boolean bKravLeilighet = personen.getKravLeilighet();
				int iKravArealFra = personen.getKravArealFra();
				int iKravArealTil = personen.getKravArealTil();
				int iKravMaksPris = personen.getKravMaksUtleiepris();
				int iMinAntRom = personen.getKravMinAntRom();
				int iMinByggeaar = personen.getKravMinByggeaar();
				
				// finner boliger som matcher kravene til valgt boligsøker
				for (Bolig b : register.getBoliger())
				{
					if
					(
							((utleiere.getSelectedIndex() == 0 || b.getUtleier() == utleiere.getSelectedItem()) &&
							bKravEnebolig && b instanceof Enebolig ||
							bKravRekkehus && b instanceof Rekkehus ||
							bKravLeilighet && b instanceof Leilighet ||
							(!bKravEnebolig && !bKravRekkehus && !bKravRekkehus))
							&&
							(iKravArealFra == 0 || iKravArealFra <= b.getBoareal())
							&&
							(iKravArealTil == 0 || iKravArealTil >= b.getBoareal())
							&&
							(iKravMaksPris == 0 || iKravMaksPris >= b.getUtleiepris())
							&&
							(iMinAntRom == 0 || iMinAntRom <= b.getAntrom())
							&&
							(iMinByggeaar == 0 || iMinByggeaar <= b.getByggeaar())
					)
						sokeliste.add(b);
				}
			}
			
			if (visinteresser.isSelected())
			{
				// finner boliger som valgt boligsøker er interessert i
				for (Bolig b : register.getBoliger())
					if
					(
							(utleiere.getSelectedIndex() == 0 || b.getUtleier() == utleiere.getSelectedItem())
							&&
							!sokeliste.contains(b)
					)
						for (Boligsoker bs : b.getInteresserte())
							if (bs == personen)
								sokeliste.add(b);
			}
		}
		
		if (utleiere.getSelectedIndex() != 0) // hvis man har valgt å vise kun en viss utleier så skal alle andre boliger fjernes
			for (Bolig b : sokeliste)
				if (b.getUtleier() != utleiere.getSelectedItem())
					sokeliste.remove(b);
	} // slutt på metoden lagSok()
	
	// definer vinduskomponenter og list opp alle boliger som ligger i arraylisten sokeliste.
	private void listBoliger()
	{
		switch (sortering.getSelectedIndex())
		{
			case 0:
				Collections.sort(sokeliste, new Comparator<Bolig>() {
				    public int compare(Bolig b1, Bolig b2) {
						return b2.getAnnonsedato().compareTo(b1.getAnnonsedato());
				    }
				});
				break;
			case 1:
				Collections.sort(sokeliste, new Comparator<Bolig>() {
				    public int compare(Bolig b1, Bolig b2) {
						return b1.getUtleiepris() - b2.getUtleiepris();
				    }
				});
				break;
			case 2:
				Collections.sort(sokeliste, new Comparator<Bolig>() {
				    public int compare(Bolig b1, Bolig b2) {
						return b2.getUtleiepris() - b1.getUtleiepris();
				    }
				});
				break;
			case 3:
				Collections.sort(sokeliste, new Comparator<Bolig>() {
				    public int compare(Bolig b1, Bolig b2) {
						return b1.getBoareal() - b2.getBoareal();
				    }
				});
				break;
			case 4:
				Collections.sort(sokeliste, new Comparator<Bolig>() {
				    public int compare(Bolig b1, Bolig b2) {
						return b2.getBoareal() - b1.getBoareal();
				    }
				});
				break;
		}
		
		int antAnnonser = sokeliste.size();
		
		switch (antAnnonser)
		{
			case 0:
				antallresultater.setText("Ingen annonser funnet.");
				break;
			case 1:
				antallresultater.setText("<html>&Eacute;n annonse funnet.</html>");
				break;
			case 2:
				antallresultater.setText("To annonser funnet.");
				break;
			case 3:
				antallresultater.setText("Tre annonser funnet.");
				break;
			case 4:
				antallresultater.setText("Fire annonser funnet.");
				break;
			case 5:
				antallresultater.setText("Fem annonser funnet.");
				break;
			case 6:
				antallresultater.setText("Seks annonser funnet.");
				break;
			case 7:
				antallresultater.setText("Sju annonser funnet.");
				break;
			case 8:
				antallresultater.setText("<html>&Aring;tte annonser funnet.</html>");
				break;
			case 9:
				antallresultater.setText("Ni annonser funnet.");
				break;
			case 10:
				antallresultater.setText("Ti annonser funnet.");
				break;
			case 11:
				antallresultater.setText("Elleve annonser funnet.");
				break;
			case 12:
				antallresultater.setText("Tolv annonser funnet.");
				break;
			default:
				antallresultater.setText(antAnnonser + " annonser funnet.");
				break;
		}
		
		JPanel indreListePanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc3 = new GridBagConstraints();
		gc3.anchor = GridBagConstraints.NORTHWEST;
		gc3.gridy = 0;
		int i = 0;

		for (final Bolig b : sokeliste)
		{
			Resultatbolk rb = new Resultatbolk(register, Boligpanel.this, b);
			
			if (i != antAnnonser - 1)
				rb.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));

			gc3.gridy = i++;
			indreListePanel.add(rb, gc3);
		}
		
		JPanel Vest = new JPanel(new BorderLayout());
		Vest.add(indreListePanel, BorderLayout.WEST);
		JPanel Nord = new JPanel(new BorderLayout());
		Nord.add(Vest, BorderLayout.NORTH);
		Nord.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
		
		
		if (listePanel != null)
			remove(listePanel);

		listePanel = new JScrollPane(Nord);
		
		add(listePanel, BorderLayout.CENTER);
		
		revalidate();
	}
	
	// velg Enebolig i søkefilter
	public void velgEnebolig()
	{
		enebolig.setSelected(true);
		rekkehus.setSelected(false);
		leilighet.setSelected(false);
		
		pEneRekke.setVisible(true);
		pLeilighet.setVisible(false);
	}
	
	public void velgRekkehus()
	{
		enebolig.setSelected(false);
		rekkehus.setSelected(true);
		leilighet.setSelected(false);
		
		pEneRekke.setVisible(true);
		pLeilighet.setVisible(false);
	}
	
	public void velgLeilighet()
	{
		enebolig.setSelected(false);
		rekkehus.setSelected(false);
		leilighet.setSelected(true);
		
		pEneRekke.setVisible(false);
		pLeilighet.setVisible(true);
	}
	
	public void velgIngentype()
	{
		enebolig.setSelected(false);
		rekkehus.setSelected(false);
		leilighet.setSelected(false);
		
		pEneRekke.setVisible(false);
		pLeilighet.setVisible(false);
	}
	
	// lytteklasse for alt som kan klikkes på
	private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == enebolig || e.getSource() == leilighet || e.getSource() == rekkehus)
			{
	        	if (e.getSource() == enebolig && enebolig.isSelected())
	        		velgEnebolig();
	        	else if (e.getSource() == rekkehus && rekkehus.isSelected())
	        		velgRekkehus();
	        	else if (e.getSource() == leilighet && leilighet.isSelected())
	        		velgLeilighet();
	        	else
	        		velgIngentype();
			}
			else if (e.getSource() == registrer)
				new Boligskjemavindu(register, Boligpanel.this);
			else if (e.getSource() == sok)
			{
				lagSok();
				listBoliger();
			}
			else if(e.getSource() == boligsokere)
			{
				if (boligsokere.getSelectedIndex() == 0 || boligsokere.getSelectedIndex() == 1)
				{
					boligsokerdetaljer.setEnabled(false);
					
					if (boligsokere.getSelectedIndex() == 1)
					{
						new Personskjemavindu(register, Boligpanel.this);
						boligsokere.setSelectedIndex(0);
					}
				}
				else
					boligsokerdetaljer.setEnabled(true);
			}
			else if (e.getSource() == boligsokerdetaljer && boligsokere.getSelectedIndex() != 0 && boligsokere.getSelectedIndex() != 1)
				new Personskjemavindu(register, Boligpanel.this, (Person)boligsokere.getSelectedItem());
			else if (e.getSource() == nullstill) // når man trykker på nullstill, tøm alle felter og gjør et blankt søk 
			{
				sortering.setSelectedIndex(0);
				utforBlanktSok();
			}
			else if (e.getSource() == sortering)
				listBoliger();
		}
	}

	// nullstill alle felter
	public void nullstill()
	{
		adr.setText("");
		beliggenhet.setText("");
		postnr.setText("");
		poststed.setText("");
		annonsedato.setForeground(Color.GRAY);
		annonsedato.setText(ANNONSEDATO_EKS_TEKST);
		byggeaar.setText("");
		prisfra.setText("");
		pristil.setText("");
		boarealfra.setText("");
		boarealtil.setText("");
		visledige.setSelected(true);
		visutleide.setSelected(true);
		enebolig.setSelected(false);
		rekkehus.setSelected(false);
		leilighet.setSelected(false);
		tomtfra.setText("");
		tomttil.setText("");
		antetgfra.setText("");
		antetgtil.setText("");
		kjeller.setSelected(false);
		garasje.setSelected(false);
		vask.setSelected(false);
		maaliggeiforste.setSelected(false);
		velgVenstreFilterPanel();
		velgIngentype();
		utleiere.setSelectedIndex(0);
	}
	
}



