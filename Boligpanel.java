//Denne klassen tar seg av listing og soking av bolig.

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;

public class Boligpanel extends JPanel
{

	private JTextField adr,fra,til,bfra,btil,boareal,antrom,byggeaar,dato,etasje,antetasje,tfra,ttil,postnr,poststed,beliggenhet;
	private JButton sok, registrer;
	private ButtonGroup bgHus;
	private JLabel ladr,lpris,lfra,ltil,lttil,ltfra,lbfra,lbtil,lboareal,lpoststed,lpostnr,lantrom,lbyggeaar,ldato,ltype,letasje,lantetasje,ltomt,lbeliggenhet;
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
		lboareal = new JLabel("Boareal: (kvm)");
		lantrom = new JLabel("Antall rom: ");
		antrom = new JTextField(20);
		lbyggeaar = new JLabel("Byggeaar: ");
		byggeaar = new JTextField(4);
		beliggenhet = new JTextField(14);
		ldato = new JLabel("Annonsedato: ");
		dato = new JTextField(9);
		dato.setText("eks: 21/12/2013");
		dato.setForeground(Color.GRAY);
		dato.addFocusListener(new FocusListener()
		{
			public void focusGained(FocusEvent f)
			{
				if(dato.getText().equals("eks: 21/12/2013"))
				dato.setText("");
				dato.setForeground(Color.BLACK);
			}
			public void focusLost(FocusEvent f)
			{
				if(dato.getText().equals(""))
				{
					dato.setText("eks: 21/12/2013");
					dato.setForeground(Color.GRAY);
				}
			}
		});
		ltype = new JLabel("Type: ");
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
		
		JPanel pAdresse = new JPanel();
		pAdresse.add(ladr);
		pAdresse.add(adr);
		
		JPanel pBeliggenhet = new JPanel();
		pBeliggenhet.add(lbeliggenhet);
		pBeliggenhet.add(beliggenhet);
		
		JPanel pPost = new JPanel();
		pPost.add(lpostnr);
		pPost.add(postnr);
		pPost.add(lpoststed);
		pPost.add(poststed);
		
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
		
		Enebolig.addActionListener(c);
		Rekkehus.addActionListener(c);
		Leilighet.addActionListener(c);
		
		
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
        innerFilterPanel.add(pPrisen, gc);
        
        gc.gridy = 6;
        gc.gridx = 0;
        innerFilterPanel.add(pBoareal, gc);
        
        gc.gridy = 7;
        gc.gridx = 0;
        innerFilterPanel.add(pTomt, gc);
      
    
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
		
		listBoliger(false);
	}
	
	private class cLytter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        	if (e.getSource() == Enebolig && Enebolig.isSelected())
        	{
        		Leilighet.setSelected(false);
        		Rekkehus.setSelected(false);
        	}
        	else if (e.getSource() == Leilighet && Leilighet.isSelected())
        	{
        		Enebolig.setSelected(false);
        		Rekkehus.setSelected(false);
        	}
        	else if (e.getSource() == Rekkehus && Rekkehus.isSelected())
        	{
        		Enebolig.setSelected(false);
        		Leilighet.setSelected(false);
        	}
        	
        	if(Enebolig.isSelected())
			{
				Kjeller.setVisible(true);
				pAntetasje.setVisible(true);
				pTomt.setVisible(true);
				pEtasje.setVisible(false);
				Heis.setVisible(false);
				Garasje.setVisible(false);
				Balkong.setVisible(false);
				Vask.setVisible(false);
			}
			else if(Leilighet.isSelected())
			{
				Kjeller.setVisible(true);
				pAntetasje.setVisible(true);
				pTomt.setVisible(false);
				pEtasje.setVisible(true);
				Heis.setVisible(true);
				Garasje.setVisible(true);
				Balkong.setVisible(true);
				Vask.setVisible(true);
			}
			else if(Rekkehus.isSelected())
			{
				Kjeller.setVisible(true);
				pAntetasje.setVisible(true);
				pTomt.setVisible(false);
				pEtasje.setVisible(true);
				Heis.setVisible(true);
				Garasje.setVisible(true);
				Balkong.setVisible(true);
				Vask.setVisible(false);
			}
        	else if(Enebolig.isSelected() && Rekkehus.isSelected())
        	{
        		Kjeller.setVisible(true);
				pAntetasje.setVisible(true);
				pTomt.setVisible(false);
				pEtasje.setVisible(true);
				Heis.setVisible(true);
				Garasje.setVisible(true);
				Balkong.setVisible(true);
				Vask.setVisible(false);
        	}
        	else if(Enebolig.isSelected() && Leilighet.isSelected())
			{
				Kjeller.setVisible(true);
				pAntetasje.setVisible(true);
				pTomt.setVisible(true);
				Garasje.setVisible(true);
				pEtasje.setVisible(true);
				Heis.setVisible(true);
				Balkong.setVisible(true);
				Vask.setVisible(true);
			}
			else if(Leilighet.isSelected() && Rekkehus.isSelected())
			{
				Kjeller.setVisible(true);
				pAntetasje.setVisible(true);
				pTomt.setVisible(true);
				Garasje.setVisible(true);
				pEtasje.setVisible(true);
				Heis.setVisible(true);
				Garasje.setVisible(true);
				Balkong.setVisible(true);
				Vask.setVisible(true);
			}
			else if(Enebolig.isSelected() && Rekkehus.isSelected() && Leilighet.isSelected())
        	{
        		Kjeller.setVisible(true);
				pAntetasje.setVisible(true);
				pTomt.setVisible(true);
				Garasje.setVisible(true);
				pEtasje.setVisible(true);
				Heis.setVisible(true);
				Garasje.setVisible(true);
				Balkong.setVisible(true);
				Vask.setVisible(true);
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
				Vask.setVisible(false);
				Balkong.setVisible(false);
			}
		}
	}
	
	public void listBoliger(boolean medFilter)
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
					b.getAdresse().toLowerCase().contains(adr.getText().toLowerCase())
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
				bsv = new Boligskjemavindu(Boligpanel.this, register);
			}
			else if (e.getSource() == sok)
			{
				listBoliger(true);
			}
		}
	}
}



