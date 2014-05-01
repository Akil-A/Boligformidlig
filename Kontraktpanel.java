/* Panel som viser liste over alle utgaatte og fungerende kontrakter.
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
		
		
		
		/********* POPULERING AV LISTER START *********/
        fungerendemodell = new DefaultListModel<Kontrakt>();
        fungerendeListe = new JList<Kontrakt>(fungerendemodell);
        oppdaterFungerendeListe();

        utgaattmodell = new DefaultListModel<Kontrakt>();
        utgaatteListe = new JList<Kontrakt>(utgaattmodell);
        oppdaterUtgaattListe();
        /********* POPULERING AV LISTER SLUTT *********/

		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
		fungerendeListe.setFont(font);
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
		bScrollPane.setBorder(BorderFactory.createTitledBorder("FUNGERENDE KONTRAKTER"));
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
		uScrollPane.setBorder(BorderFactory.createTitledBorder("<html>UTG&Aring;TTE KONTRAKTER</html>"));
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
