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
	private Font IKKEFET = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
		
	public Kontraktpanel(Boligregister br)
	{	
		register = br;
		
		lytter = new Lytter();
		
		fungerendeListe = new JList<>();
		utgaatteListe = new JList<>();
		
		
		
		/********* POPULERING AV LISTER START *********/
        fungerendemodell = new DefaultListModel<Kontrakt>();
        fungerendeListe = new JList<Kontrakt>(fungerendemodell);
		fungerendeListe.setFont(IKKEFET);
		fungerendeListe.setCellRenderer(new fungerendeListeCellRenderer());
        oppdaterFungerendeListe();

        utgaattmodell = new DefaultListModel<Kontrakt>();
        utgaatteListe = new JList<Kontrakt>(utgaattmodell);
		utgaatteListe.setFont(IKKEFET);
		utgaatteListe.setCellRenderer(new utgaattListeCellRenderer());
        oppdaterUtgaattListe();
        /********* POPULERING AV LISTER SLUTT *********/

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
    			new Kontraktvindu(register, Kontraktpanel.this, fungerendeListe.getSelectedValue());
    		else if (e.getSource() == utgaatteKnapp && utgaatteListe.getSelectedIndex() != -1)
    			new Kontraktvindu(register, Kontraktpanel.this, utgaatteListe.getSelectedValue());
    	}
    }
    
    private class fungerendeListeCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList<?> fungerendeListe,
                                     Object value,
                                     int index,
                                     boolean isSelected,
                                     boolean cellHasFocus) {
            super.getListCellRendererComponent(fungerendeListe, value, index, isSelected, cellHasFocus);
            if (value instanceof Kontrakt) {
                Kontrakt kontrakt = (Kontrakt)value;
                setText(kontrakt.getBolig().getAdresse() + "   Fra: " + kontrakt.getStartdato().get(kontrakt.getStartdato().DAY_OF_MONTH) + "/" + (kontrakt.getStartdato().get(kontrakt.getStartdato().MONTH) + 1) + "/" + kontrakt.getStartdato().get(kontrakt.getStartdato().YEAR) + "   Til:   " + kontrakt.getSluttdato().get(kontrakt.getSluttdato().DAY_OF_MONTH) + "/" + (kontrakt.getSluttdato().get(kontrakt.getSluttdato().MONTH) + 1) + "/" + kontrakt.getSluttdato().get(kontrakt.getSluttdato().YEAR));
            }
            return this;
        }
    }
    
    private class utgaattListeCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList<?> utgaattListe,
                                     Object value,
                                     int index,
                                     boolean isSelected,
                                     boolean cellHasFocus) {
            super.getListCellRendererComponent(utgaattListe, value, index, isSelected, cellHasFocus);
            if (value instanceof Kontrakt) {
                Kontrakt kontrakt = (Kontrakt)value;
                setText(kontrakt.getBolig().getAdresse() + "   Fra: " + kontrakt.getStartdato().get(kontrakt.getStartdato().DAY_OF_MONTH) + "/" + (kontrakt.getStartdato().get(kontrakt.getStartdato().MONTH) + 1) + "/" + kontrakt.getStartdato().get(kontrakt.getStartdato().YEAR) + "   Til:   " + kontrakt.getSluttdato().get(kontrakt.getSluttdato().DAY_OF_MONTH) + "/" + (kontrakt.getSluttdato().get(kontrakt.getSluttdato().MONTH) + 1) + "/" + kontrakt.getSluttdato().get(kontrakt.getSluttdato().YEAR));
            }
            return this;
        }
    }
}
