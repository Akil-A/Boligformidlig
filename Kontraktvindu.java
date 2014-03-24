/* Vindu som viser liste over alle kontrakter.
 * Laget av Joakim
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.*;


public class Kontraktvindu extends JFrame
{
	private JButton fungerendeKnapp, utgaatteKnapp;
	private JList<String> fungerendeListe, utgaatteListe;
	private Lytter lytter;
	
	public Kontraktvindu(Boligregister br)
	{
		super("Kontrakter");
				
		lytter = new Lytter();
		
		fungerendeListe = new JList<>();
		utgaatteListe = new JList<>();
		
		String[] dyrenavn = { "Fugl", "Katt", "Hund", "Kanin", "Gris" };
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		Font font = new Font("System", Font.PLAIN, 12);
		
		fungerendeListe.setBorder(border);
		fungerendeListe.setFont(font);
		fungerendeListe.setListData(dyrenavn);
		utgaatteListe.setBorder(border);
		utgaatteListe.setFont(font);
		utgaatteListe.setListData(dyrenavn);

		fungerendeKnapp = new JButton("Detaljer");
		fungerendeKnapp.addActionListener(lytter);
		
		utgaatteKnapp = new JButton("Detaljer");
		utgaatteKnapp.addActionListener(lytter);
		
		Container c = getContentPane();
		c.setLayout( new GridBagLayout() );
		
		
		fungerendeListe.setPreferredSize(new Dimension(450, (int) fungerendeListe.getPreferredSize().getHeight()));
		utgaatteListe.setPreferredSize(new Dimension(450, (int) fungerendeListe.getPreferredSize().getHeight()));
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.NORTHWEST;
		
		
		gc.gridx = 0;
		gc.gridy = 0;
		c.add(new JLabel("Fungerende kontrakter:"), gc);
		
		gc.gridy = 1;
		c.add(fungerendeListe, gc);
		
		gc.gridx = 1;
		gc.insets.left = 10;
		c.add(fungerendeKnapp, gc);
		
		gc.insets.top = 20;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.insets.left = 0;
		c.add(new JLabel("Utgåtte kontrakter:"), gc);
		
		gc.gridy = 3;
		gc.insets.top = 0;
		c.add(utgaatteListe, gc);

		gc.gridx = 1;
		gc.insets.left = 10;
		c.add(utgaatteKnapp, gc);

		setVisible( true );
		setLocationRelativeTo( null ); // Vinduet åpnes på midten av skjermen.
		setSize( 600, 300 ); // bredde, høyde
	}
	
	public static void main(String[] args)
	{
		Kontraktvindu k = new Kontraktvindu(null);
	}
	
    private class Lytter implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		if (e.getSource() == fungerendeKnapp && fungerendeListe.getSelectedIndex() != -1)
    			JOptionPane.showMessageDialog(null, fungerendeListe.getSelectedValue());
    		else if (e.getSource() == utgaatteKnapp && utgaatteListe.getSelectedIndex() != -1)
    			JOptionPane.showMessageDialog(null, utgaatteListe.getSelectedValue());
    	}
    }
}
