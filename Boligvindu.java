//Denne klassen tar seg av registrering og soking av bolig.

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Boligvindu extends JFrame
{

	private JTextField adr,pris,boareal,antrom,byggeaar,utleiepris,dato;
	private JButton sok;
	private JButton vis;
	private ButtonGroup bg;
	public Boligregister br;
	private JLabel ladr,lpris,lboareal,lantrom,lbyggeaar,lutleiepris,ldato,ltype;
	private JCheckBox Enebolig,Rekkehus,Leilighet;
	public Boligvindu()
		{
			super("Bolig");
			setSize(700,300);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Lytter lytter = new Lytter();
			ladr = new JLabel("Adresse: ");
			adr = new JTextField(20);
			lpris = new JLabel("Pris: ");
			pris = new JTextField(20);
			lboareal = new JLabel("Boareal: ");
			boareal = new JTextField(20);
			lantrom = new JLabel("Antall rom: ");
			antrom = new JTextField(20);
			lbyggeaar = new JLabel("Byggeår: ");
			byggeaar = new JTextField(20);
			lutleiepris = new JLabel("Utleierpris: ");
			utleiepris = new JTextField(20);
			ldato = new JLabel("Dato: ");
			dato = new JTextField(20);
			adr.setPreferredSize(new Dimension(200, adr.getPreferredSize().height));
			ltype = new JLabel("Type: ");
			sok = new JButton("Sok bolig");
			sok.addActionListener(lytter);
			sok.setPreferredSize(new Dimension(200, sok.getPreferredSize().height));
			vis = new JButton("Vis alle");
			vis.addActionListener(lytter);
			Enebolig = new JCheckBox("Enebolig");
			Rekkehus = new JCheckBox("Rekkehus");
			Leilighet = new JCheckBox("Leilighet");
			JPanel sokefelt = new JPanel( new GridBagLayout() );
			JPanel utforfelt = new JPanel();
			JPanel Sjekkboks = new JPanel();
			bg = new ButtonGroup();
			bg.add(Enebolig);
			bg.add(Rekkehus);
			bg.add(Leilighet);
			
			GridBagConstraints gc = new GridBagConstraints();
			
			gc.insets.left = 10;
			gc.insets.top = 10;
			
			gc.gridx = 0;
			gc.gridy = 0;
			sokefelt.add(ladr, gc);
			
			gc.gridx = 1;
			gc.gridy = 0;
			sokefelt.add(adr, gc);
			
			gc.gridx = 0;
			gc.gridy = 1;
			sokefelt.add(lpris, gc);
			
			gc.gridx = 1;
			gc.gridy = 1;
			sokefelt.add(pris, gc);
			
			gc.gridx = 0;
			gc.gridy = 2;
			sokefelt.add(lboareal, gc);
			
			gc.gridx = 1;
			gc.gridy = 2;
			sokefelt.add(boareal, gc);
			
			gc.gridx = 0;
			gc.gridy = 3;
			sokefelt.add(lpris, gc);
			
			gc.gridx = 1;
			gc.gridy = 3;
			sokefelt.add(pris, gc);
			
			gc.gridx = 0;
			gc.gridy = 4;
			sokefelt.add(lpris, gc);
			
			gc.gridx = 1;
			gc.gridy = 4;
			sokefelt.add(pris, gc);
			
			gc.gridx = 1;
			gc.gridy = 5;
			sokefelt.add(ltype, gc);
			
			Sjekkboks.add(Rekkehus);
			Sjekkboks.add(Enebolig);
			Sjekkboks.add(Leilighet);
			
			gc.gridx = 1;
			gc.gridy = 2;
			sokefelt.add(Sjekkboks,gc);
			
			
			utforfelt.add(sok);
			utforfelt.add(vis);
			
			Container c = getContentPane();
			c.setLayout(new GridLayout(2,1));
			c.add(sokefelt, BorderLayout.NORTH);
			c.add(utforfelt);
			setVisible( true );
			setLocationRelativeTo( null );
		}
	
	private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == sok)
			
				{
					if(Enebolig.isSelected() && Rekkehus.isSelected() && Leilighet.isSelected())
					{
						
					}
					else if(Enebolig.isSelected())
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

