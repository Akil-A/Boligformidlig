//Denne klassen tar seg av registrering og soking av bolig.

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Boligpanel extends JPanel
{

	private JTextField adr,fra,til,bfra,btil,boareal,antrom,byggeaar,utleiepris,dato,etasje,antetasje,tomt,tfra,ttil,postnr,poststed,beliggenhet;
	private JButton sok, vis, registrer;
	private ButtonGroup bgHus;
	public Boligregister br;
	private JLabel ladr,lpris,lfra,ltil,lttil,ltfra,lbfra,lbtil,lboareal,lpoststed,lpostnr,lantrom,lbyggeaar,tilegg,lutleiepris,ldato,ltype,lkjeller,lgarasje,lvask,lbalkong,lheis,letasje,lantetasje,ltomt,lbeliggenhet;
	private JCheckBox Enebolig,Rekkehus,Leilighet,Kjeller,Garasje,Balkong,Heis,Vask;
	private JPanel pAntetasje, pTomt, pBoareal;
	public Boligpanel(Boligregister br)
		{
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
			fra = new JTextField(6);
			ltil = new JLabel("Til: ");
			til = new JTextField(6);
			lbfra = new JLabel("Fra: ");
			bfra = new JTextField(3);
			lbtil = new JLabel("Til: ");
			btil = new JTextField(3);
			ltomt = new JLabel("TomtestÃ¸rrelse: (kvm)");
			ltfra = new JLabel("Fra: ");
			tfra = new JTextField(3);
			lttil = new JLabel("Til: ");
			ttil = new JTextField(3);
			tilegg = new JLabel("Tilegg: ");
			lboareal = new JLabel("Boareal: (kvm)");
			lantrom = new JLabel("Antall rom: ");
			antrom = new JTextField(20);
			lbyggeaar = new JLabel("ByggeÃ¥r: ");
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
			vis = new JButton("Vis alle");
			vis.addActionListener(lytter);
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
			
			
			JPanel pEtasje = new JPanel();
			pEtasje.add(letasje);
			pEtasje.add(etasje);
			pEtasje.add(pAntetasje);
			
			
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
			
			Balkong.addItemListener(c);
			Kjeller.addItemListener(c);
			Vask.addItemListener(c);
			Garasje.addItemListener(c);
			Heis.addItemListener(c);
			
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
			filterPanel.setPreferredSize(new Dimension(filterPanel.getWidth(), 300)); // (bredde, hÃƒÂ¸yde)
		
			registrer = new JButton("Registrer ny");
			registrer.addActionListener(lytter);
			
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
			Utleier p2 = new Utleier("Henrik", "Hansen", "Kirkegata 8", 3027, "Drammen", "", "");
			Rekkehus r = new Rekkehus("Borggata 12", 3027, "Drammen", 30 , 5 , 2006, "Hyggelig 3-roms med heis" ,6000);
			Enebolig e = new Enebolig("Parkveien 16", 3024, "Drammen", 30, 5, 2005, "Nyoppusset og sentral beliggenhet", 7000);
			p.settInnBolig(e);
			p2.settInnBolig(r);
			br.settInnPerson(p2);
			br.settInnPerson(p);
			/***** testdata slutt *****/
			
			JPanel innerListePanel = new JPanel(new GridBagLayout());
			GridBagConstraints gc3 = new GridBagConstraints();
			gc3.anchor = GridBagConstraints.NORTHWEST;
			gc3.gridy = 0;
			int i = 0;
			for (Bolig b : br.getBoliger())
			{
				
				JPanel Bolig = new JPanel(new GridBagLayout());
				
				JLabel Beskrivelse = new JLabel(b.getBeskrivelse());
				JLabel Kvadratmeter = new JLabel(String.valueOf(b.getBoareal()));
				JLabel Pris = new JLabel(String.valueOf(b.getUtleiepris()));

				GridBagConstraints gc4 = new GridBagConstraints();
				
				gc4.anchor = GridBagConstraints.NORTHWEST;
				
				gc4.gridx = 0;
				gc4.gridy = 0;
				gc4.gridwidth = 2;
				Bolig.add(Beskrivelse, gc4);
				gc4.gridy = 1;
				gc4.gridwidth = 1;
				Bolig.add(Kvadratmeter, gc4);
				gc4.gridx = 1;
				Bolig.add(Pris, gc4);
				
				JSeparator sep = new JSeparator();
				sep.setPreferredSize(new Dimension(500, 1));
				
				gc4.gridwidth = 2;
				gc4.gridy = 2;
				gc4.gridx = 0;
				Bolig.add(sep, gc4);

				gc3.gridy = i++;
				innerListePanel.add(Bolig, gc3);
				
			}
			JPanel Vest = new JPanel(new BorderLayout());
			Vest.add(innerListePanel, BorderLayout.WEST);
			JPanel Nord = new JPanel(new BorderLayout());
			Nord.add(Vest, BorderLayout.NORTH);
			JScrollPane listePanel = new JScrollPane(Nord);
			
			add(listePanel, BorderLayout.CENTER);
		
			
			
			
		
		}
	
	private void listBoliger()
	{
		
	}
	
	private class cLytter implements ItemListener
	{
		public void itemStateChanged(ItemEvent i)
		{
			if(Enebolig.isSelected())
				
			{
				Kjeller.setVisible(true);
				pAntetasje.setVisible(true);
				pTomt.setVisible(true);
				Garasje.setVisible(true);
			}
		}
	}
	
	private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == sok)
			{
				if(Enebolig.isSelected())
				{
					Kjeller.setVisible(true);
					pAntetasje.setVisible(true);
					pTomt.setVisible(true);
					Garasje.setVisible(true);
				}
			}
			else if (e.getSource() == registrer)
			{
				Boligskjemavindu bsv = new Boligskjemavindu(br);
			}
		}
	}
}	



