//Denne klassen tar seg av registrering og soking av bolig.

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class Boligpanel extends JPanel
{

	private JTextField adr,fra,til,bfra,btil,boareal,antrom,byggeaar,utleiepris,dato,etasje,antetasje,tomt,tfra,ttil,postnr,poststed,beliggenhet;
	private JButton sok, registrer;
	private ButtonGroup bgHus;
	private JLabel ladr,lpris,lfra,ltil,lttil,ltfra,lbfra,lbtil,lboareal,lpoststed,lpostnr,lantrom,lbyggeaar,tilegg,lutleiepris,ldato,ltype,lkjeller,lgarasje,lvask,lbalkong,lheis,letasje,lantetasje,ltomt,lbeliggenhet;
	private JCheckBox Enebolig,Rekkehus,Leilighet,Kjeller,Garasje,Balkong,Heis,Vask;
	private JPanel pAntetasje, pTomt, pBoareal, pEtasje;
	private Boligregister register;
	private JScrollPane boligListe;
	
	public Boligpanel(Boligregister br)
	{
		register = br;
		
		setLayout(new BorderLayout());
		
		Lytter lytter = new Lytter();
		cLytter c = new cLytter();
		ladr = new JLabel("Adresse: ");
		adr = new JTextField(20);
		lpoststed = new JLabel("PostSted: ");
		lpostnr = new JLabel("PostNr: ");
		poststed = new JTextField(10);
		postnr = new JTextField(4);
		lpris = new JLabel("Utleiepris: ");
		lfra = new JLabel("Fra: ");
		fra = new JTextField(7);
		ltil = new JLabel("Til: ");
		til = new JTextField(7);
		lbfra = new JLabel("Fra: ");
		bfra = new JTextField(5);
		lbtil = new JLabel("Til: ");
		btil = new JTextField(7);
		ltomt = new JLabel("Tomtestørrelse: (kvm)");
		ltfra = new JLabel("Fra: ");
		tfra = new JTextField(7);
		lttil = new JLabel("Til: ");
		ttil = new JTextField(7);
		tilegg = new JLabel("Tilegg: ");
		lboareal = new JLabel("Boareal: (kvm)");
		lantrom = new JLabel("Antall rom: ");
		antrom = new JTextField(20);
		lbyggeaar = new JLabel("Byggeår: ");
		byggeaar = new JTextField(6);
		beliggenhet = new JTextField(14);
		ldato = new JLabel("Dato: ");
		dato = new JTextField(10);
		dato.setText("eks: 21/12/1989");
		dato.setForeground(Color.GRAY);
		dato.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent f)
			{
				if(dato.getText().equals("eks: 21/12/1989"))
				dato.setText("");
				dato.setForeground(Color.BLACK);
			}

			@Override
			public void focusLost(FocusEvent arg0)
			{
				if(dato.getText().equals(""))
					{
						dato.setText("eks: 21/12/1989");
						dato.setForeground(Color.GRAY);
					}
			}
		});
		ltype = new JLabel("Type: ");
		lkjeller = new JLabel("Kjeller: ");
		lbalkong = new JLabel("Balkong: ");
		lgarasje = new JLabel("Garasje: ");
		lvask = new JLabel("Felles vask: ");
		lheis = new JLabel("Heis: ");
		letasje = new JLabel("Etasje: ");
		etasje = new JTextField(5);
		lantetasje = new JLabel("Antall etasjer: ");
		antetasje = new JTextField(5);
		sok = new JButton("Sok bolig");
		sok.addActionListener(lytter);
		registrer = new JButton("Registrer ny");
		registrer.addActionListener(lytter);
		Enebolig = new JCheckBox("Enebolig");
		Rekkehus = new JCheckBox("Rekkehus");
		Leilighet = new JCheckBox("Leilighet");
		Vask = new JCheckBox("Vask");
		Garasje = new JCheckBox("Garasje");
		Heis = new JCheckBox("Heis");
		Balkong = new JCheckBox("Balkong");
		Kjeller = new JCheckBox("Kjeller");
		lbeliggenhet = new JLabel("Nermeste togstasjon: ");
		
		JPanel pBeliggenhet = new JPanel();
		pBeliggenhet.add(lbeliggenhet);
		pBeliggenhet.add(beliggenhet);
		
		JPanel pAdresse = new JPanel();
		pAdresse.add(ladr);
		pAdresse.add(adr);
		
		JPanel pPost = new JPanel();
		pPost.add(lpostnr);
		pPost.add(postnr);
		pPost.add(lpoststed);
		pPost.add(poststed);
		JPanel utforfelt = new JPanel();
		
		JPanel SjekkboksHus = new JPanel();
		JPanel SjekkboksTilegg = new JPanel();
		
		SjekkboksTilegg.add(Balkong);
		SjekkboksTilegg.add(Heis);
		SjekkboksTilegg.add(Garasje);
		SjekkboksTilegg.add(Kjeller);
		SjekkboksTilegg.add(Vask);
	 
	    pTomt = new JPanel();
	    pTomt.add(ltomt);
	    pTomt.add(ltfra);
	    pTomt.add(tfra);
	    pTomt.add(lttil);
	    pTomt.add(ttil);
	   
	    pBoareal = new JPanel();
	    pBoareal.add(lboareal);
	    pBoareal.add(lbfra);
	    pBoareal.add(bfra);
	    pBoareal.add(lbtil);
	    pBoareal.add(btil);
	    
		JPanel pPrisen = new JPanel();
		pPrisen.add(lpris);
		pPrisen.add(lfra);
		pPrisen.add(fra);
		pPrisen.add(ltil);
		pPrisen.add(til);
		
		pAntetasje = new JPanel();
		pAntetasje.add(lantetasje);
		pAntetasje.add(antetasje);
		
		pEtasje = new JPanel();
		pEtasje.add(letasje);
		pEtasje.add(etasje);
		
		JPanel pantRom = new JPanel();
		pantRom.add(lantrom);
		pantRom.add(antrom);
	
		JPanel pDato = new JPanel();
		pDato.add(ldato);
		pDato.add(dato);
		pDato.add(lbyggeaar);
		pDato.add(byggeaar);

		SjekkboksHus.add(Rekkehus);
		SjekkboksHus.add(Enebolig);
		SjekkboksHus.add(Leilighet);
		
		JPanel pType = new JPanel();
		pType.add(ltype);
		pType.add(SjekkboksHus);
		
		Balkong.setVisible(false);
		Kjeller.setVisible(false);
		Vask.setVisible(false);
		Garasje.setVisible(false);
		Heis.setVisible(false);
		pAntetasje.setVisible(false);
		pTomt.setVisible(false);
		
		Enebolig.addChangeListener(c);
		Rekkehus.addChangeListener(c);
		Leilighet.addChangeListener(c);
		
		bgHus = new ButtonGroup();
		bgHus.add(Enebolig);
		bgHus.add(Rekkehus);
		bgHus.add(Leilighet);
		
		JPanel nordPanel = new JPanel(new GridBagLayout());
		JComponent innerFilterPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
       
        gc.gridy = 0;
        gc.gridx = 0;
        innerFilterPanel.add(pType, gc);
        
        gc.gridy = 1;
        gc.gridx = 0;
        innerFilterPanel.add(pAdresse, gc);
        
        gc.gridy = 2;
        gc.gridx = 0;
        innerFilterPanel.add(pBeliggenhet, gc);
        
        gc.gridy = 3;
        gc.gridx = 0;
        innerFilterPanel.add(pPost, gc);
     
      
        gc.gridy = 4;
        gc.gridx = 0;
        innerFilterPanel.add(pDato,gc);
        
        
        gc.gridy = 5;
        gc.gridx = 0;
        innerFilterPanel.add(pBoareal, gc);
        
        gc.gridy = 7;
        gc.gridx = 0;
        innerFilterPanel.add(pTomt, gc);
        
        gc.gridy = 8;
        gc.gridx = 0;
        innerFilterPanel.add(pPrisen, gc);
      
    
        gc.gridy = 9;
        gc.gridx = 0;
        innerFilterPanel.add(SjekkboksTilegg, gc);
        
		
		JScrollPane filterPanel = new JScrollPane(innerFilterPanel);
		filterPanel.setBorder(BorderFactory.createTitledBorder("Filter"));
		filterPanel.setPreferredSize(new Dimension(filterPanel.getWidth(), 300)); // (bredde, hÃ¸yde)
	
		
		JPanel knappePanel = new JPanel(new BorderLayout());
		knappePanel.add(sok, BorderLayout.WEST);
		knappePanel.add(registrer, BorderLayout.EAST);
		
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
		
		/* LISTEPANEL 
		 =========================================================================== */

		/***** testdata *****/
		Utleier p = new Utleier("Per", "Hansen", "Kirkegata 6", 3024, "Drammen", "", "");
		Utleier p2 = new Utleier("Henrik", "Pettersen", "Avisveien 8", 3027, "Drammen", "", "");
		Rekkehus r = new Rekkehus("Borggata 12", 3027, "Drammen", 30 , 5 , 2006, "Hyggelig 3-roms med heis" ,6000);
		Enebolig e = new Enebolig("Parkveien 16", 3024, "Drammen", 30, 5, 2005, "Nyoppusset og sentral beliggenhet", 7000);
		p.settInnBolig(e);
		p2.settInnBolig(r);
		br.settInnPerson(p2);
		br.settInnPerson(p);
		/***** testdata slutt *****/
		
		listBoliger(false);
	}
	
	private class cLytter implements ChangeListener
    {
        public void stateChanged(ChangeEvent e)
        {		
			if(Enebolig.isSelected())
			{
				Kjeller.setVisible(true);
				pAntetasje.setVisible(true);
				pTomt.setVisible(true);
				Garasje.setVisible(true);
				pEtasje.setVisible(false);
				Heis.setVisible(false);
				Garasje.setVisible(true);
			}
			
			else if(Rekkehus.isSelected())
			{
				Kjeller.setVisible(true);
				pAntetasje.setVisible(true);
				pTomt.setVisible(true);
				Garasje.setVisible(true);
				pEtasje.setVisible(false);
				Heis.setVisible(false);
				Garasje.setVisible(true);
			}
			else if(Leilighet.isSelected())
			{
				Kjeller.setVisible(false);
				pAntetasje.setVisible(false);
				pTomt.setVisible(false);
				Garasje.setVisible(false);
				pEtasje.setVisible(true);
				Heis.setVisible(true);
				Garasje.setVisible(true);
			}
			else
			{
				Kjeller.setVisible(false);
				pAntetasje.setVisible(false);
				pTomt.setVisible(false);
				Garasje.setVisible(false);
				pEtasje.setVisible(false);
				Heis.setVisible(false);
				Garasje.setVisible(false);
			}
		}
	}
	
	private void listBoliger(boolean medFilter)
	{
		JPanel innerListePanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc3 = new GridBagConstraints();
		gc3.anchor = GridBagConstraints.NORTHWEST;
		gc3.gridy = 0;
		int i = 0;
		
		for (Bolig b : register.getBoliger())
		{
			if
			(
				!medFilter ||
				(
					medFilter &&
					b.getAdresse().contains(adr.getText())
				)
			)
			{
				JPanel Bolig = new JPanel(new GridBagLayout());
				
				JLabel beskrivelse = new JLabel(b.getBeskrivelse());
				JLabel boareal = new JLabel(String.valueOf(b.getBoareal()) + "kvm");
				JLabel pris = new JLabel(String.valueOf(b.getUtleiepris()) + ",- pr mnd");
				JLabel adresse = new JLabel(b.getAdresse());

				GridBagConstraints gc4 = new GridBagConstraints();
				
				gc4.anchor = GridBagConstraints.NORTHWEST;
				
				gc4.gridx = 0;
				gc4.gridy = 0;
				gc4.gridwidth = 2;
				Bolig.add(beskrivelse, gc4);
				gc4.gridy = 1;
				gc4.gridwidth = 1;
				Bolig.add(boareal, gc4);
				gc4.gridy = 2;
				Bolig.add(pris, gc4);
				gc4.gridx = 0;
				gc4.gridy = 3;
				gc4.gridwidth = 2;
				Bolig.add(adresse, gc4);
				
				JSeparator sep = new JSeparator();
				sep.setPreferredSize(new Dimension(500, 1));
				
				gc4.gridwidth = 2;
				gc4.gridy = 4;
				gc4.gridx = 0;
				Bolig.add(sep, gc4);
	
				gc3.gridy = i++;
				innerListePanel.add(Bolig, gc3);
			}
		}
		
		JPanel Vest = new JPanel(new BorderLayout());
		Vest.add(innerListePanel, BorderLayout.WEST);
		JPanel Nord = new JPanel(new BorderLayout());
		Nord.add(Vest, BorderLayout.NORTH);
		JScrollPane listePanel = new JScrollPane(Nord);
		
		if (boligListe != null)
			remove(boligListe);
		
		boligListe = listePanel;
		
		add(boligListe, BorderLayout.CENTER);
		
		revalidate();
	}
	
	private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Boligskjemavindu bsv;
			
			if (e.getSource() == registrer)
			{
				bsv = new Boligskjemavindu(register);
			}
			else if (e.getSource() == sok)
			{
				listBoliger(true);
			}
		}
	}
}



