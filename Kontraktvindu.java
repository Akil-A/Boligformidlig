import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;


public class Kontraktvindu extends JFrame
{
	private JButton fungerendeKnapp, utgaatteKnapp;
	private JList<String> fungerendeListe, utgaatteListe;
	private Lytter lytter;
	
	public Kontraktvindu(Boligregister br)
	{
		super("Kontrakter");
		
		setSize( 500, 300 ); // bredde, høyde
		
		lytter = new Lytter();
		
		fungerendeListe = new JList<>();
		utgaatteListe = new JList<>();
		
		String[] dyrenavn = { "Fugl", "Katt", "Hund", "Kanin", "Gris" };
		
		fungerendeListe.setListData(dyrenavn);
		utgaatteListe.setListData(dyrenavn);

		fungerendeKnapp = new JButton("Detaljer");
		fungerendeKnapp.addActionListener(lytter);
		
		utgaatteKnapp = new JButton("Detaljer");
		utgaatteKnapp.addActionListener(lytter);
		
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		
		c.add(fungerendeListe);
		c.add(fungerendeKnapp);
		c.add(utgaatteListe);
		c.add(utgaatteKnapp);

		setVisible( true );
		setLocationRelativeTo( null ); // Vinduet åpnes på midten av skjermen.
	}
	
	public static void main(String[] args)
	{
		Kontraktvindu k = new Kontraktvindu(null);
	}
	
    private class Lytter implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		if (e.getSource() == fungerendeKnapp)
    			JOptionPane.showMessageDialog(null, fungerendeListe.getSelectedValue());
    		else if (e.getSource() == utgaatteKnapp)
    			JOptionPane.showMessageDialog(null, utgaatteListe.getSelectedValue());
    	}
    }
}
