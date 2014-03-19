import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class Boligvindu extends JFrame
{

	private JTextField adr;
	private JButton sok;
	private JButton vis;
	public Boligsystem bs;
	private JLabel label;
	private JLabel label2;
	private JCheckBox Enebolig;
	private JCheckBox Rekkehus;
	private JLabel enebolig;
	private JLabel rekkehus;
	public Boligvindu()
		{
			super("Bolig");
			setSize(500,120);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			Lytter lytter = new Lytter();
			label = new JLabel("Adresse: ");
			adr = new JTextField(15);
			adr.setPreferredSize(new Dimension(200, adr.getPreferredSize().height));
			label2 = new JLabel("Type: ");
			sok = new JButton("Søk bolig");
			sok.addActionListener(lytter);
			sok.setPreferredSize(new Dimension(200, sok.getPreferredSize().height));
			vis = new JButton("Vis alle");
			vis.addActionListener(lytter);
			Enebolig = new JCheckBox("Enebolig");
			Rekkehus = new JCheckBox("Rekkehus");
			JPanel p = new JPanel( new GridBagLayout() );
			
			GridBagConstraints gc = new GridBagConstraints();
			
			gc.insets.left = 5;
			gc.insets.top = 5;
			
			gc.gridx = 0;
			gc.gridy = 0;
			p.add(label, gc);
			
			gc.gridx = 1;
			gc.gridy = 0;
			p.add(adr, gc);
			
			gc.gridx = 0;
			gc.gridy = 1;
			p.add(label2, gc);
			
			gc.gridx = 1;
			gc.gridy = 1;
			p.add(Enebolig, gc);
			
			gc.gridx = 2;
			gc.gridy = 1;
			p.add(Rekkehus,gc);
			
			gc.gridx = 0;
			gc.gridy = 2;
			p.add(sok,gc);
			
			gc.gridx = 1;
			gc.gridy = 2;
			p.add(vis,gc);
			
			Container c = getContentPane();
			c.setLayout(new BorderLayout());
			c.add(p, BorderLayout.NORTH);
			setVisible( true );
			setLocationRelativeTo( null );
		}
	
	private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getSource() == sok)
			
				{
					if(Enebolig.isSelected() && Rekkehus.isSelected())
					{
						
					}
					else if(Enebolig.isSelected())
					{
						
					}
					else if(Rekkehus.isSelected())
					{
						
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Du må velge minst en checkbox for å søke, eller trykk på vis alle");
					}
				}   
			else if(e.getSource() == vis)
			{
				
			}
			}
		}
	
}	

