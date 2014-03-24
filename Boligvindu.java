//Denne klassen tar seg av registrering og soking av bolig.

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Boligvindu extends JFrame
{

	private JTextField adr,fra,til,bfra,btil,boareal,antrom,byggeaar,utleiepris,dato,etasje,antetasje,tomtestorrelse,tfra,ttil;
	private JButton sok;
	private JButton vis;
	private ButtonGroup bgHus,bgKjeller,bgGarasje,bgVask,bgHeis,bgBalkong;
	public Boligregister br;
	private JLabel ladr,lpris,lfra,ltil,lttil,ltfra,lbfra,lbtil,lboareal,lantrom,lbyggeaar,ltomtestorrelse,lutleiepris,ldato,ltype,lkjeller,lgarasje,lvask,lbalkong,lheis,letasje,lantetasje,ltomt;
	private JCheckBox Enebolig,Rekkehus,Leilighet,KJa,KNei,GJa,GNei,VJa,VNei,HJa,HNei,BJa,BNei;
	public Boligvindu()
		{
			super("Bolig");
			setSize(550,550);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			KJa = new JCheckBox("Ja");
			KNei = new JCheckBox("Nei");
			GJa = new JCheckBox("Ja");
			GNei = new JCheckBox("Nei");
			VJa = new JCheckBox("Ja");
			VNei = new JCheckBox("Nei");
			HJa = new JCheckBox("Ja");
			HNei = new JCheckBox("Nei");
			BJa = new JCheckBox("Ja");
			BNei = new JCheckBox("Nei");
			JPanel utforfelt = new JPanel();
			JPanel SjekkboksHus = new JPanel();
			JPanel SjekkboksKjeller = new JPanel();
		    JPanel SjekkboksHeis = new JPanel();
		    JPanel SjekkboksBalkong = new JPanel();
		    JPanel SjekkboksVask = new JPanel();
		    JPanel SjekkboksGarasje = new JPanel();
		    JPanel boareal = new JPanel();
		    JPanel tomt = new JPanel();
		    tomt.add(ltfra);
		    tomt.add(tfra);
		    tomt.add(lttil);
		    tomt.add(ttil);
		    boareal.add(lbfra);
		    boareal.add(bfra);
		    boareal.add(lbtil);
		    boareal.add(btil);
		    
			JPanel prisen = new JPanel();
			prisen.add(lfra);
			prisen.add(fra);
			prisen.add(ltil);
			prisen.add(til);
			bgHus = new ButtonGroup();
			bgHus.add(Enebolig);
			bgHus.add(Rekkehus);
			bgHus.add(Leilighet);
			
			bgKjeller = new ButtonGroup();
			bgKjeller.add(KJa);
			bgKjeller.add(KNei);
			
			bgGarasje = new ButtonGroup();
			bgGarasje.add(GJa);
			bgGarasje.add(GNei);
			
			bgVask = new ButtonGroup();
			bgVask.add(VJa);
			bgVask.add(VNei);
			
			bgHeis = new ButtonGroup();
			bgHeis.add(HJa);
			bgHeis.add(HNei);
			
			bgBalkong = new ButtonGroup();
			bgBalkong.add(BJa);
			bgBalkong.add(BNei);
			
			
			GridBagConstraints gc = new GridBagConstraints();

			gc.anchor = GridBagConstraints.WEST;
			Container c = getContentPane();
			c.setLayout(new GridBagLayout());
			
			
			
			gc.insets.bottom = 3;
			gc.insets.left = 3;
			
			gc.gridx = 0;
			gc.gridy = 0;
			c.add(ladr, gc);
			
			gc.gridx = 1;
			gc.gridy = 0;
			c.add(adr, gc);
			
			gc.gridx = 0;
			gc.gridy = 1;
			c.add(lpris,gc);
			
			gc.gridx = 1;
			gc.gridy = 1;
			c.add(prisen,gc);
			
			gc.gridx = 0;
			gc.gridy = 2;
			c.add(lboareal, gc);
			
			gc.gridx = 1;
			gc.gridy = 2;
			c.add(boareal, gc);
			
			gc.gridx = 0;
			gc.gridy = 3;
			c.add(ltomt, gc);
			
			gc.gridx = 1;
			gc.gridy = 3;
			c.add(tomt, gc);
			
			gc.gridx = 0;
			gc.gridy = 4;
			c.add(letasje, gc);
			
			gc.gridx = 1;
			gc.gridy = 4;
			c.add(etasje, gc);
			
			gc.gridx = 0;
			gc.gridy = 5;
			c.add(lantetasje, gc);
			
			gc.gridx = 1;
			gc.gridy = 5;
			c.add(antetasje, gc);
			
			gc.gridx = 0;
			gc.gridy = 6;
			c.add(lantrom, gc);
			
			gc.gridx = 1;
			gc.gridy = 6;
			c.add(antrom, gc);
			
			gc.gridx = 0;
			gc.gridy = 7;
			c.add(lbyggeaar, gc);
			
			gc.gridx = 1;
			gc.gridy = 7;
			c.add(byggeaar, gc);
			
			gc.gridx = 0;
			gc.gridy = 8;
			c.add(ldato, gc);
			
			gc.gridx = 1;
			gc.gridy = 8;
			c.add(dato, gc);
			
			
			gc.gridx = 0;
			gc.gridy = 9;
			c.add(ltype, gc);
			
			SjekkboksHus.add(Rekkehus);
			SjekkboksHus.add(Enebolig);
			SjekkboksHus.add(Leilighet);
			
			gc.gridx = 1;
			gc.gridy = 9;
			c.add(SjekkboksHus,gc);
			
			gc.gridx = 0;
			gc.gridy = 10;
			c.add(lkjeller,gc);
			
			SjekkboksKjeller.add(KJa);
			SjekkboksKjeller.add(KNei);
			gc.gridx = 1;
			gc.gridy = 10;
			c.add(SjekkboksKjeller,gc);
			
			gc.gridx = 0;
			gc.gridy = 11;
			c.add(lgarasje,gc);
			
			SjekkboksGarasje.add(GJa);
			SjekkboksGarasje.add(GNei);
			gc.gridx = 1;
			gc.gridy = 11;
			c.add(SjekkboksGarasje,gc);
			
			gc.gridx = 0;
			gc.gridy = 12;
			c.add(lheis,gc);
			
			SjekkboksHeis.add(HJa);
			SjekkboksHeis.add(HNei);
			gc.gridx = 1;
			gc.gridy = 12;
			c.add(SjekkboksHeis,gc);
			
			gc.gridx = 0;
			gc.gridy = 13;
			c.add(lvask, gc);
			
			SjekkboksVask.add(VJa);
			SjekkboksVask.add(VNei);
			gc.gridx = 1;
			gc.gridy = 13;
			c.add(SjekkboksVask,gc);
			
			
			gc.gridx = 0;
			gc.gridy = 14;
			c.add(lbalkong, gc);
			
			SjekkboksBalkong.add(BJa);
			SjekkboksBalkong.add(BNei);
			gc.gridx = 1;
			gc.gridy = 14;
			c.add(SjekkboksBalkong, gc);
			
			utforfelt.add(sok);
			utforfelt.add(vis);
			gc.gridx = 0;
			gc.gridy = 15;
			gc.anchor = GridBagConstraints.CENTER;
			gc.gridwidth = 2;
			c.add(utforfelt, gc);
			
			
			setVisible( true );
			setLocationRelativeTo( null );
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
						JOptionPane.showMessageDialog(null,"Du ma velge minst en checkbox for a soke, eller trykk pa vis alle");
					}
				}   
			else if(e.getSource() == vis)
			{
				
			}
			}
		}
	
}	

