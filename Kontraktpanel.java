/* Panel som viser liste over alle utgåtte og fungerende kontrakter.
 * Laget av Joakim
 */

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;


public class Kontraktpanel extends JPanel
{
	private JButton fungerendeKnapp, utgaatteKnapp;
	private JList<String> fungerendeListe, utgaatteListe;
	private Lytter lytter;
	
	String[] dyrenavn = { "Fugl", "Katt", "Hund", "Kanin", "Gris" };
	
	public Kontraktpanel(Boligregister br)
	{
		lytter = new Lytter();
		
		fungerendeListe = new JList<>();
		utgaatteListe = new JList<>();
		
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		Font font = new Font("System", Font.PLAIN, 12);
		
		// JList må bindes til en egen liste som skriver ut en passende toString
		
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
		
		
		fungerendeListe.setPreferredSize(new Dimension(450, (int) fungerendeListe.getPreferredSize().getHeight()));
		utgaatteListe.setPreferredSize(new Dimension(450, (int) fungerendeListe.getPreferredSize().getHeight()));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.NORTHWEST;
		
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(new JLabel("Fungerende kontrakter:"), gc);
		
		gc.gridy = 1;
		add(fungerendeListe, gc);
		
		gc.gridx = 1;
		gc.insets.left = 10;
		add(fungerendeKnapp, gc);
		
		gc.insets.top = 20;
		gc.gridx = 0;
		gc.gridy = 2;
		gc.insets.left = 0;
		add(new JLabel("Utgåtte kontrakter:"), gc);
		
		gc.gridy = 3;
		gc.insets.top = 0;
		add(utgaatteListe, gc);

		gc.gridx = 1;
		gc.insets.left = 10;
		add(utgaatteKnapp, gc);
	}
	
    private class Lytter implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		if (e.getSource() == fungerendeKnapp && fungerendeListe.getSelectedIndex() != -1)
    			JOptionPane.showMessageDialog(null, dyrenavn[fungerendeListe.getSelectedIndex()]);
    		else if (e.getSource() == utgaatteKnapp && utgaatteListe.getSelectedIndex() != -1)
    			JOptionPane.showMessageDialog(null, utgaatteListe.getSelectedValue());
    	}
    }
}
