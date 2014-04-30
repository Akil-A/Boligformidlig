/* Panel som viser liste over alle utg��tte og fungerende kontrakter.
 * Laget av Joakim
 */

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;

import javax.swing.*;
import javax.swing.border.Border;


public class Kontraktpanel extends JPanel
{
	private JButton fungerendeKnapp, utgaatteKnapp;
	private JList<Kontrakt> fungerendeListe, utgaatteListe;
    private DefaultListModel<Kontrakt> fungerendemodell, utgaattmodell;
	private Lytter lytter;
    private Boligregister register;
		
	public Kontraktpanel(Boligregister br)
	{	
		register = br;
		
		lytter = new Lytter();
		
		fungerendeListe = new JList<>();
		utgaatteListe = new JList<>();
		
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		Font font = new Font("System", Font.PLAIN, 12);
		
		// JList m�� bindes til en egen liste som skriver ut en passende toString
		
		/********* POPULERING AV LISTER START *********/
        fungerendemodell = new DefaultListModel<Kontrakt>();
        fungerendeListe = new JList<Kontrakt>(fungerendemodell);
        oppdaterFungerendeListe();

        utgaattmodell = new DefaultListModel<Kontrakt>();
        utgaatteListe = new JList<Kontrakt>(utgaattmodell);
        oppdaterUtgaattListe();
        /********* POPULERING AV LISTER SLUTT *********/
		
		fungerendeListe.setBorder(border);
		fungerendeListe.setFont(font);
		utgaatteListe.setBorder(border);
		utgaatteListe.setFont(font);

		fungerendeKnapp = new JButton("Detaljer");
		fungerendeKnapp.addActionListener(lytter);
		
		utgaatteKnapp = new JButton("Detaljer");
		utgaatteKnapp.addActionListener(lytter);
		
		
		 /********* LAYOUT START *********/
        setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.NORTHWEST;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		JScrollPane bScrollPane = new JScrollPane();
		bScrollPane.setBorder(BorderFactory.createTitledBorder("Fungerendeliste:"));
		bScrollPane.setViewportView(fungerendeListe);
		bScrollPane.setPreferredSize(new Dimension(450, 200));   
        add(bScrollPane, gc);
		
		gc.gridx = 1;
		gc.insets.left = 10;
		add(fungerendeKnapp, gc);
	
		gc.insets.top = 20;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.insets.left = 0;
		
		JScrollPane uScrollPane = new JScrollPane();
		uScrollPane.setBorder(BorderFactory.createTitledBorder("Utgaattekontrakter:"));
		uScrollPane.setViewportView(utgaatteListe); 
		uScrollPane.setPreferredSize(new Dimension(450, 200));   
        add(uScrollPane, gc);

		gc.gridx = 1;
		gc.insets.left = 10;
		add(utgaatteKnapp, gc);
        /********* LAYOUT SLUTT *********/
	}
	
	public void oppdaterFungerendeListe()
    {
    	fungerendemodell.clear();
    	
    	Iterator<Kontrakt> iterator = register.getFungerende().iterator();
    	
        while(iterator.hasNext())
        	fungerendemodell.addElement(iterator.next());
    }
	
	public void oppdaterUtgaattListe()
	{
		utgaattmodell.clear();
    	
    	Iterator<Kontrakt> iterator = register.getUtgaatte().iterator();
    	
        while(iterator.hasNext())
        	utgaattmodell.addElement(iterator.next());
	 }
	
    private class Lytter implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		if (e.getSource() == fungerendeKnapp && fungerendeListe.getSelectedIndex() != -1)  		
    			new Kontraktvindu(register, fungerendeListe.getSelectedValue(), Kontraktpanel.this);
    		
    		else if (e.getSource() == utgaatteKnapp && utgaatteListe.getSelectedIndex() != -1)
    			new Kontraktvindu(register, utgaatteListe.getSelectedValue(), Kontraktpanel.this);

    	}
    }
}
