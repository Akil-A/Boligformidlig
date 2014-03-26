//Denne klassen tar seg av registrering og soking av bolig.

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Boligvindu extends JPanel
{

	private JTextField adr,fra,til,bfra,btil,boareal,antrom,byggeaar,utleiepris,dato,etasje,antetasje,tomtestorrelse,tfra,ttil;
	private JButton sok;
	private JButton vis;
	private ButtonGroup bgHus,bgKjeller,bgGarasje,bgVask,bgHeis,bgBalkong;
	public Boligregister br;
	private JLabel ladr,lpris,lfra,ltil,lttil,ltfra,lbfra,lbtil,lboareal,lantrom,lbyggeaar,ltomtestorrelse,lutleiepris,ldato,ltype,lkjeller,lgarasje,lvask,lbalkong,lheis,letasje,lantetasje,ltomt;
	private JCheckBox Enebolig,Rekkehus,Leilighet,Kjeller,Garasje,Balkong,Heis,Vask;
	private JScrollPane Skroller;
	public Boligvindu()
		{
		
			
			
			add(Skroller);
			setSize(600,600);
			Lytter lytter = new Lytter();
			ladr = new JLabel("Adresse: ");
			adr = new JTextField(20);
			lpris = new JLabel("Utleiepris: ");
			lfra = new JLabel("Fra: ");
			fra = new JTextField(10);
			ltil = new JLabel("Til: ");
			til = new JTextField(10);
			lbfra = new JLabel("Fra: ");
			bfra = new JTextField(10);
			lbtil = new JLabel("Til: ");
			btil = new JTextField(10);
			ltomt = new JLabel("Tomtestørrelse: ");
			ltfra = new JLabel("Fra: ");
			tfra = new JTextField(10);
			lttil = new JLabel("Til: ");
			ttil = new JTextField(10);
			lboareal = new JLabel("Boareal: ");
			lantrom = new JLabel("Antall rom: ");
			antrom = new JTextField(20);
			lbyggeaar = new JLabel("Byggeår: ");
			byggeaar = new JTextField(20);
			ldato = new JLabel("Dato: ");
			dato = new JTextField(20);
			ltype = new JLabel("Type: ");
			lkjeller = new JLabel("Kjeller: ");
			lbalkong = new JLabel("Balkong: ");
			lgarasje = new JLabel("Garasje: ");
			lvask = new JLabel("Felles vask: ");
			lheis = new JLabel("Heis: ");
			letasje = new JLabel("Etasje: ");
			etasje = new JTextField(20);
			lantetasje = new JLabel("Antall etasjer: ");
			antetasje = new JTextField(20);
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
			
			JPanel pantEtasje = new JPanel();
			pantEtasje.add(lantetasje);
			pantEtasje.add(antetasje);
			
			JPanel pantRom = new JPanel();
			pantRom.add(lantrom);
			pantRom.add(antrom);
			
			JPanel pByggeaar = new JPanel();
			pByggeaar.add(lbyggeaar);
			pByggeaar.add(byggeaar);
			
			JPanel pDato = new JPanel();
			pDato.add(ldato);
			pDato.add(dato);
			

			SjekkboksHus.add(Rekkehus);
			SjekkboksHus.add(Enebolig);
			SjekkboksHus.add(Leilighet);
			
			JPanel pType = new JPanel();
			pType.add(ltype);
			pType.add(SjekkboksHus);
			
			bgHus = new ButtonGroup();
			bgHus.add(Enebolig);
			bgHus.add(Rekkehus);
			bgHus.add(Leilighet);
			
			
			GridBagConstraints gc = new GridBagConstraints();

			gc.anchor = GridBagConstraints.WEST;
			setLayout(new GridBagLayout());
			
			
			
			gc.insets.bottom = 3;
			gc.insets.left = 3;
			
			gc.gridx = 0;
			gc.gridy = 0;
			add(pAdresse, gc);
			
			
			gc.gridx = 0;
			gc.gridy = 2;
			add(pPrisen,gc);
			
			gc.gridx = 0;
			gc.gridy = 3;
			add(pBoareal, gc);
			
		
			gc.gridx = 0;
			gc.gridy = 4;
			add(pTomt, gc);
			
			gc.gridx = 0;
			gc.gridy = 5;
			add(pEtasje, gc);
			
			
			gc.gridx = 0;
			gc.gridy = 6;
			add(pantEtasje, gc);
			
			
			gc.gridx = 0;
			gc.gridy = 7;
			add(pantRom, gc);
			
			
			gc.gridx = 0;
			gc.gridy = 8;
			add(pByggeaar, gc);
			
			gc.gridx = 0;
			gc.gridy = 9;
			add(pDato, gc);
			
			
			gc.gridx = 0;
			gc.gridy = 10;
			add(pType, gc);
		
			gc.gridx = 0;
			gc.gridy = 11;
			add(pKjeller,gc);
			
	
			
			gc.gridx = 0;
			gc.gridy = 12;
			add(pGarasje,gc);
			
			gc.gridx = 0;
			gc.gridy = 13;
			add(pHeis,gc);
			
			gc.gridx = 0;
			gc.gridy = 14;
			add(pVask, gc);
	
			
			gc.gridx = 0;
			gc.gridy = 15;
			add(pBalkong, gc);
			
			utforfelt.add(sok);
			utforfelt.add(vis);
			gc.gridx = 0;
			gc.gridy = 16;
			gc.anchor = GridBagConstraints.CENTER;
			gc.gridwidth = 2;
			add(utforfelt, gc);
			
			
			
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
						
					}
					else if(Kjeller.isSelected() && Heis.isSelected() && Vask.isSelected() && Garasje.isSelected() )
					{
						
					}
					else if(Kjeller.isSelected() && Heis.isSelected() && Vask.isSelected())
					{
						
					}
					else if(Kjeller.isSelected())
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

