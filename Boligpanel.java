//Denne klassen tar seg av registrering og soking av bolig.

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Boligpanel extends JPanel
{

	private JTextField adr,fra,til,bfra,btil,boareal,antrom,byggeaar,utleiepris,dato,etasje,antetasje,tomt,tfra,ttil,postnr,poststed;
	private JButton sok;
	private JButton vis;
	private ButtonGroup bgHus;
	public Boligregister br;
	private JLabel ladr,lpris,lfra,ltil,lttil,ltfra,lbfra,lbtil,lboareal,lpoststed,lpostnr,lantrom,lbyggeaar,tilegg,lutleiepris,ldato,ltype,lkjeller,lgarasje,lvask,lbalkong,lheis,letasje,lantetasje,ltomt;
	private JCheckBox Enebolig,Rekkehus,Leilighet,Kjeller,Garasje,Balkong,Heis,Vask;
	public Boligpanel()
		{
		
			
		
			Lytter lytter = new Lytter();
			ladr = new JLabel("Adresse: ");
			adr = new JTextField(10);
			lpoststed = new JLabel("PostSted: ");
			lpostnr = new JLabel("PostNr: ");
			poststed = new JTextField(5);
			postnr = new JTextField(5);
			lpris = new JLabel("Utleiepris: ");
			lfra = new JLabel("Fra: ");
			fra = new JTextField(6);
			ltil = new JLabel("Til: ");
			til = new JTextField(6);
			lbfra = new JLabel("Fra: ");
			bfra = new JTextField(6);
			lbtil = new JLabel("Til: ");
			btil = new JTextField(6);
			ltomt = new JLabel("Tomtestørrelse: ");
			ltfra = new JLabel("Fra: ");
			tfra = new JTextField(6);
			lttil = new JLabel("Til: ");
			ttil = new JTextField(6);
			tilegg = new JLabel("Tilegg: ");
			lboareal = new JLabel("Boareal: ");
			lantrom = new JLabel("Antall rom: ");
			antrom = new JTextField(20);
			lbyggeaar = new JLabel("Byggeår: ");
			byggeaar = new JTextField(6);
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
			Vask = new JCheckBox();
			Garasje = new JCheckBox();
			Heis = new JCheckBox();
			Balkong = new JCheckBox();
			Kjeller = new JCheckBox();
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
		 
		    JPanel pTomt = new JPanel();
		    pTomt.add(ltomt);
		    pTomt.add(ltfra);
		    pTomt.add(tfra);
		    pTomt.add(lttil);
		    pTomt.add(ttil);
		   
		    JPanel pBoareal = new JPanel();
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
			
			JPanel pKjeller = new JPanel();
			pKjeller.add(lkjeller);
			pKjeller.add(Kjeller);
			
			JPanel pBalkong = new JPanel();
			pBalkong.add(lbalkong);
			pBalkong.add(Balkong);
			
			JPanel pGarasje = new JPanel();
			pGarasje.add(lgarasje);
			pGarasje.add(Garasje);
			
			JPanel pVask = new JPanel();
			pVask.add(lvask);
			pVask.add(Vask);
			
			JPanel pHeis = new JPanel();
			pHeis.add(lheis);
			pHeis.add(Heis);
			
			JPanel pEtasje = new JPanel();
			pEtasje.add(letasje);
			pEtasje.add(etasje);
			pEtasje.add(lantetasje);
			pEtasje.add(antetasje);
			
			
			JPanel pantRom = new JPanel();
			pantRom.add(lantrom);
			pantRom.add(antrom);
			
		
			JPanel pDato = new JPanel();
			pDato.add(ldato);
			pDato.add(dato);
			pDato.add(lbyggeaar);
			pDato.add(byggeaar);
			
			JPanel pTilegg = new JPanel();
			pTilegg.add(tilegg);
			pTilegg.add(pHeis);
			pTilegg.add(pGarasje);
			pTilegg.add(pKjeller);
			pTilegg.add(pBalkong);
			pTilegg.add(pVask);
			

			SjekkboksHus.add(Rekkehus);
			SjekkboksHus.add(Enebolig);
			SjekkboksHus.add(Leilighet);
			
			JPanel pType = new JPanel();
			pType.add(ltype);
			pType.add(SjekkboksHus);
			
			
			JComponent innerPanel = new JPanel();
            innerPanel.setLayout(new GridBagLayout());
            
            
            GridBagConstraints gc = new GridBagConstraints();
            gc.anchor = GridBagConstraints.WEST;
            
            gc.gridy = 0;
            
            gc.gridx = 0;
            innerPanel.add(pAdresse, gc);
            
            gc.gridy = 1;
            
            gc.gridx = 0;
            innerPanel.add(pPost, gc);
         
            
            gc.gridy = 2;
            
            gc.gridx = 0;
            innerPanel.add(pBoareal, gc);
            
          
            gc.gridy = 3;
            
            gc.gridx = 0;
            innerPanel.add(pTomt, gc);
            
            gc.gridy = 4;
            gc.gridx = 0;
            innerPanel.add(pPrisen, gc);
          
            gc.gridy = 5;
            gc.gridx = 0;
            innerPanel.add(pType, gc);
            
            gc.gridy = 6;
            gc.gridx = 0;
            innerPanel.add(pTilegg, gc);
            
            
           
            JScrollPane rullePanel = new JScrollPane(innerPanel);
            rullePanel.setPreferredSize(new Dimension(500, 360)); // (bredde, høyde)
            add(rullePanel);
             
			bgHus = new ButtonGroup();
			bgHus.add(Enebolig);
			bgHus.add(Rekkehus);
			bgHus.add(Leilighet);
			
			
			
			
			utforfelt.add(sok);
		
		}
	
	private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == sok)
			
				{
					if(Enebolig.isSelected())
						{
						
						}
						else if(Rekkehus.isSelected())
						{
							
						}
						else if(Leilighet.isSelected())
						{
							
						}
						else
						{
							JOptionPane.showMessageDialog(null,"Du maa velge minst en checkbox for aa soke!");
						}
					
					if(Kjeller.isSelected() && Heis.isSelected() && Vask.isSelected() && Garasje.isSelected() && Balkong.isSelected())
					{
						JOptionPane.showMessageDialog(null,"Lol..");
					}
					else if(Kjeller.isSelected() && Heis.isSelected() && Vask.isSelected() && Garasje.isSelected() )
					{
						
					}
					else if(Kjeller.isSelected() && Heis.isSelected() && Vask.isSelected() && Balkong.isSelected() )
					{
						
					}
					else if(Kjeller.isSelected() && Heis.isSelected() && Balkong.isSelected())
					{
						
					}
					else if(Kjeller.isSelected() && Heis.isSelected() && Vask.isSelected())
					{
						
					}
					else if(Kjeller.isSelected() && Heis.isSelected())
					{
						
					}
					else if(Kjeller.isSelected())
					{
						
					}
					
				}   
			}
		}
	
}	

