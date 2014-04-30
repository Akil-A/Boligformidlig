//Denne klassen tar seg av opplisting og soking av bolig.

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class Boligpanel extends JPanel
{
	private JTextField adr, postnr, poststed, beliggenhet, prisfra, pristil, boarealfra, boarealtil, byggeaar, annonsedato,
							tomtfra, tomttil, antetgfra, antetgtil;
	private JCheckBox visledige, visutleide, enebolig, rekkehus, leilighet, kjeller, garasje, vask;
	private JPanel pEneRekke, pLeilighet;
	private JScrollPane filterPanel;
	private JButton sok, registrer;
	private JScrollPane boligListe;
	private Boligregister register;
	private final String ANNONSEDATO_EKS_TEKST = "eks: 21/12/2013";
	
	public Boligpanel(Boligregister br)
	{
		register = br;
		
		setLayout(new BorderLayout());
 	   	Lytter lytter = new Lytter();

	    /******** DEFINERING AV FILTERFELTER START ********/
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
		vask = new JCheckBox("Vask");
		garasje = new JCheckBox("Garasje");
		sok = new JButton("Sok bolig");
		sok.addActionListener(lytter);
		registrer = new JButton("Registrer ny");
		registrer.addActionListener(lytter);
		
		JPanel pAdresse = new JPanel();
		pAdresse.add(new JLabel("Adresse: "));
		pAdresse.add(adr);
		
		JPanel pBeliggenhet = new JPanel();
		pBeliggenhet.add(new JLabel("Naermeste togstasjon: "));
		pBeliggenhet.add(beliggenhet);
		
		JPanel pPost = new JPanel();
		pPost.add(new JLabel("PostNr: "));
		pPost.add(postnr);
		pPost.add(new JLabel("Poststed: "));
		pPost.add(poststed);
	
		JPanel pAnnonsedato = new JPanel();
		pAnnonsedato.add(new JLabel("Annonsedato fra: "));
		pAnnonsedato.add(annonsedato);
		pAnnonsedato.add(new JLabel("Byggeaar fra: "));
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
	    pTomt.add(new JLabel("Tomtestorrelse (kvm)"));
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
	    
	    pLeilighet = new JPanel();
		
		pLeilighet.add(garasje);
		pLeilighet.add(vask);
		
		pEneRekke.setVisible(false);
		pLeilighet.setVisible(false);
	    /******** DEFINERING AV FILTERFELTER SLUTT ********/
		

	    /******** SETTE FILTERFELTER INN I VINDU START ********/
		JComponent innerFilterPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.CENTER;
        

        gc.gridy = 0;
        JLabel tips = new JLabel("Skriv hele eller deler av teksten du vil soke paa og trykk Sok.");
        tips.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, this.getFont().getSize() - 1));
        innerFilterPanel.add(tips, gc);
        
        gc.gridy = 1;
        JLabel tips2 = new JLabel("La feltene staa tomme for aa vise alle.");
        tips2.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, this.getFont().getSize() - 1));
        gc.insets.bottom = 5;
        innerFilterPanel.add(tips2, gc);
        gc.insets.bottom = 0;
        
        gc.gridy = 2;
        innerFilterPanel.add(pAdresse, gc);
        
        gc.gridy = 3;
        innerFilterPanel.add(pBeliggenhet, gc);
        
        gc.gridy = 4;
        innerFilterPanel.add(pPost, gc);
      
        gc.gridy = 5;
        innerFilterPanel.add(pAnnonsedato,gc);
        
        gc.gridy = 6;
        innerFilterPanel.add(pPrisen, gc);
        
        gc.gridy = 7;
        innerFilterPanel.add(pBoareal, gc);
       
        gc.gridy = 8;
        innerFilterPanel.add(pType, gc);
       
        gc.gridy = 9;
        innerFilterPanel.add(pEneRekke, gc);
        innerFilterPanel.add(pLeilighet, gc);
        
		filterPanel = new JScrollPane(innerFilterPanel);
        filterPanel.setBorder(BorderFactory.createTitledBorder("Sokefilter"));
		filterPanel.setPreferredSize(new Dimension(filterPanel.getWidth(), 300)); // (bredde, hoyde)
		
		JPanel knappePanel = new JPanel(new BorderLayout());
		knappePanel.add(sok, BorderLayout.WEST);
		knappePanel.add(registrer, BorderLayout.EAST);

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
	    /******** SETTE FILTERFELTER INN I VINDU SLUTT ********/
		
		
		listBoliger(false);
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
	
	public void listBoliger(boolean medFilter)
	{
		JPanel innerListePanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc3 = new GridBagConstraints();
		gc3.anchor = GridBagConstraints.NORTHWEST;
		gc3.gridy = 0;
		int i = 0;
		
		boolean bVisledige = visledige.isSelected();
		boolean bVisutleide = visutleide.isSelected();
		
		ArrayList<Bolig> sokeliste = register.getBoliger();
		
		if (medFilter)
		{
			if (bVisledige && !bVisutleide)
				sokeliste.removeAll(register.getUtleide());
			else if (bVisutleide && !bVisledige)
				sokeliste.removeAll(register.getLedige());
			
			ArrayList<Bolig> sokeliste1 = new ArrayList<>();
			
			String sAnnonsedato = annonsedato.getText();
			boolean annonsedatoErDato = sAnnonsedato.matches("^[\\d]{1,2}/[\\d]{1,2}/[\\d]{4}$");
			
			for (Bolig b : sokeliste)
				if ((b.getAdresse().toLowerCase().contains(adr.getText().toLowerCase())) &&
							(b.getTogst().toLowerCase().contains(beliggenhet.getText().toLowerCase())) &&
							(!erTall(postnr.getText()) || Integer.toString(b.getPostnr()).toLowerCase().contains(postnr.getText().toLowerCase())) &&
							(b.getPoststed().toLowerCase().contains(poststed.getText().toLowerCase())) &&
							(sAnnonsedato.equals(ANNONSEDATO_EKS_TEKST) ||
									sAnnonsedato.isEmpty() || !annonsedatoErDato ||
									new Date(annonsedato.getText()).before(b.getAnnonsedato())) &&
							(byggeaar.getText().isEmpty() || !erTall(byggeaar.getText()) || Integer.parseInt(byggeaar.getText()) <= b.getByggeaar()) &&
							(prisfra.getText().isEmpty() || !erTall(prisfra.getText()) || Integer.parseInt(prisfra.getText()) <= b.getUtleiepris()) &&
							(pristil.getText().isEmpty() || !erTall(pristil.getText()) || Integer.parseInt(pristil.getText()) >= b.getUtleiepris()) &&
							(boarealfra.getText().isEmpty() || !erTall(boarealfra.getText()) || Integer.parseInt(boarealfra.getText()) <= b.getBoareal()) &&
							(boarealtil.getText().isEmpty() || !erTall(boarealtil.getText()) || Integer.parseInt(boarealtil.getText()) >= b.getBoareal()))
					sokeliste1.add(b);
			
			sokeliste = sokeliste1;
		}
		
		for (final Bolig b : sokeliste)
		{
			JPanel Bolig = new JPanel(new GridBagLayout());
			
			Font f = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
			
			JLabel beskrivelse = new JLabel(b.getBeskrivelse());
			beskrivelse.setFont(f);
			JLabel boareal = new JLabel(String.valueOf(b.getBoareal()) + "kvm");
			boareal.setFont(f);
			JLabel pris = new JLabel(String.valueOf(b.getUtleiepris()) + ",- pr mnd");
			pris.setFont(f);
			JLabel adresse = new JLabel(b.getAdresse() + ", " + b.getPostnr() + " " + b.getPoststed());
			adresse.setFont(f);

			GridBagConstraints gc4 = new GridBagConstraints();
			
			gc4.anchor = GridBagConstraints.NORTHWEST;
			
			gc4.gridx = 1;
			gc4.gridy = 0;
			Bolig.add(beskrivelse, gc4);
			gc4.gridy = 1;
			Bolig.add(boareal, gc4);
			gc4.gridy = 2;
			Bolig.add(pris, gc4);
			gc4.gridy = 3;
			Bolig.add(adresse, gc4);
			gc4.gridy = 4;
			
			JButton detaljer = new JButton("Detaljer");
			detaljer.setFont(f);
			detaljer.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Boligskjemavindu bsv = new Boligskjemavindu(register, Boligpanel.this, b);
				}
			});
			
			JButton leiut = new JButton("Lei ut");
			leiut.setFont(f);
			leiut.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					Leiut utleievindu = new Leiut(register, b.getBoligNr());
				}
			});
			
			JPanel boligknapper = new JPanel();
			boligknapper.add(detaljer);
			boligknapper.add(leiut);
			boligknapper.setBorder(null);
			
			Bolig.add(boligknapper, gc4);
			
			JButton bildeknapp = new JButton();
			bildeknapp.setPreferredSize(new Dimension(130, 110));
			bildeknapp.setEnabled(false);
			bildeknapp.setText("<html><center>-mangler<br>bilde-</center></html>");
			bildeknapp.setFont(f);
			
			if (b.getBildefilnavn() != null && !b.getBildefilnavn().isEmpty())
			{
				try
				{
					final BufferedImage mittBilde1 = ImageIO.read(new File("bilder" + File.separatorChar + b.getBildefilnavn()));
					Image skalert = mittBilde1.getScaledInstance(130, 110, BufferedImage.SCALE_FAST);
					
					bildeknapp.setText(null);
					bildeknapp.setEnabled(true);
					bildeknapp.setIcon(new ImageIcon(skalert));
					bildeknapp.addActionListener(new ActionListener()
					{
						public void actionPerformed(ActionEvent e)
						{
							Bildevindu bv = new Bildevindu(mittBilde1);
						}
					});
				}
				catch(IOException ex)
				{
				}
			}

			gc4.gridheight = 5;
			gc4.gridx = 0;
			gc4.gridy = 0;
			gc4.insets.right = 10;
	 	   	Bolig.add(bildeknapp, gc4);
			

			gc3.gridy = i++;
			innerListePanel.add(Bolig, gc3);
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
        	if (e.getSource() == enebolig && enebolig.isSelected())
        	{
        		leilighet.setSelected(false);
        		rekkehus.setSelected(false);
        	}
        	else if (e.getSource() == leilighet && leilighet.isSelected())
        	{
        		enebolig.setSelected(false);
        		rekkehus.setSelected(false);
        	}
        	else if (e.getSource() == rekkehus && rekkehus.isSelected())
        	{
        		enebolig.setSelected(false);
        		leilighet.setSelected(false);
        	}
        	
        	if (enebolig.isSelected() || rekkehus.isSelected())
        	{
        		pEneRekke.setVisible(true);
        		pLeilighet.setVisible(false);
        	}
        	else if (leilighet.isSelected())
        	{
        		pEneRekke.setVisible(false);
        		pLeilighet.setVisible(true);
        	}
        	else
        	{
        		pEneRekke.setVisible(false);
        		pLeilighet.setVisible(false);
        	}
			
			Boligskjemavindu bsv;
			
			if (e.getSource() == registrer)
			{
				bsv = new Boligskjemavindu(register, Boligpanel.this);
			}
			else if (e.getSource() == sok)
			{
				listBoliger(true);
			}
		}
	}
	
}



