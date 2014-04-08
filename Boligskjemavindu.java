/* Vindusklasse med felter. Her kan man registrere ny bolig eller oppdatere bolig.
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Boligskjemavindu extends JFrame
{
	private JRadioButton enebolig, rekkehus, leilighet;
	private JTextField tittel, adresse, postnr, poststed, togst, boareal, antrom, byggeaar, pris, antetasjer, tomtestr,
							liggerietasje;
	private JCheckBox harkjeller, hargarasje, harvaskeri;
	private CLytter clytter;
	private Lytter lytter;
	private JPanel eneboligrekkehusfelt, leilighetfelt;
	private JButton lagre, avbryt;
	private Boligpanel boligpanelet;
	
	public Boligskjemavindu(Boligregister br)
	{
		super("Registrer ny bolig");
		lagVindu();
	}
	
	public Boligskjemavindu(Boligpanel bp, Boligregister br)
	{
		super("Registrer ny bolig");
		boligpanelet = bp;
		lagVindu();
	}

	public Boligskjemavindu(Boligpanel bp, Bolig b)
	{
		super("Oppdater bolig");
		boligpanelet = bp;
		lagVindu();
		
		adresse.setText(b.getAdresse());
		postnr.setText(Integer.toString(b.getPostnr()));
		poststed.setText(b.getPoststed());
		togst.setText(b.getTogst());
		boareal.setText(Integer.toString(b.getBoareal()));
		antrom.setText(Integer.toString(b.getAntrom()));
		byggeaar.setText(Integer.toString(b.getByggeaar()));
		pris.setText(Integer.toString(b.getUtleiepris()));

		enebolig.setEnabled(false);
		rekkehus.setEnabled(false);
		leilighet.setEnabled(false);
		
		if (b instanceof Enebolig)
		{
			enebolig.setSelected(true);
		}
		else if (b instanceof Rekkehus)
		{
			rekkehus.setSelected(true);
		}
		else if (b instanceof Leilighet)
		{
			leilighet.setSelected(true);
		}
	}
	
	private void lagVindu()
	{
        clytter = new CLytter();
        lytter = new Lytter();
        tittel = new JTextField(25);
		adresse = new JTextField(10);
		postnr = new JTextField(10);
		poststed = new JTextField(10);
		togst = new JTextField(10);
		boareal = new JTextField(10);
		antrom = new JTextField(10);
		byggeaar = new JTextField(10);
		pris = new JTextField(10);
		enebolig = new JRadioButton("Enebolig");
		enebolig.addChangeListener(clytter);
		rekkehus = new JRadioButton("Rekkehus");
		rekkehus.addChangeListener(clytter);
		leilighet = new JRadioButton("Leilighet");
		leilighet.addChangeListener(clytter);
        ButtonGroup boligtype = new ButtonGroup();
        boligtype.add(enebolig);
        boligtype.add(rekkehus);
        boligtype.add(leilighet);
        lagre = new JButton("Lagre");
        lagre.addActionListener(lytter);
        avbryt = new JButton("Avbryt");
        avbryt.addActionListener(lytter);
		
        
        
        
        

		
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
        
        
        
		
		
        

		/***** toppanel start *****/
		JPanel toppanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.anchor = GridBagConstraints.EAST;
		gc.insets.left = 5;
		
		gc.gridy = 0;
		
		gc.insets.bottom = 20;
		gc.gridx = 0;
		toppanel.add(new JLabel("Annonsetittel:"), gc);
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.WEST;
		gc.gridwidth = 3;
		toppanel.add(tittel, gc);
		gc.anchor = GridBagConstraints.EAST;
		gc.gridwidth = 1;
		gc.insets.bottom = 0;
		
		gc.gridy = 1;
		
		gc.gridx = 0;
		toppanel.add(new JLabel("Adresse:"), gc);
		gc.gridx = 1;
		toppanel.add(adresse, gc);
		gc.gridx = 2;
		toppanel.add(new JLabel("Boareal (kvm):"), gc);
		gc.gridx = 3;
		toppanel.add(boareal, gc);
		
		gc.gridy = 2;
		
		gc.gridx = 0;
		toppanel.add(new JLabel("Postnr:"), gc);
		gc.gridx = 1;
		toppanel.add(postnr, gc);
		gc.gridx = 2;
		toppanel.add(new JLabel("Antall rom:"), gc);
		gc.gridx = 3;
		toppanel.add(antrom, gc);
		
		gc.gridy = 3;
		
		gc.gridx = 0;
		toppanel.add(new JLabel("Poststed:"), gc);
		gc.gridx = 1;
		toppanel.add(poststed, gc);
		gc.gridx = 2;
		toppanel.add(new JLabel("Byggeaar:"), gc);
		gc.gridx = 3;
		toppanel.add(byggeaar, gc);

		gc.gridy = 4;
		
		gc.gridx = 0;
		toppanel.add(new JLabel("Naermeste togstasjon:"), gc);
		gc.gridx = 1;
		toppanel.add(togst, gc);
		gc.gridx = 2;
		toppanel.add(new JLabel("Pris kr/mnd:"), gc);
		gc.gridx = 3;
		toppanel.add(pris, gc);
		/***** toppanel slutt *****/
		
		
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 0;
		
		c.add(toppanel, gc);
		
		
		
		
		JPanel velgBoligtype = new JPanel();
		velgBoligtype.add(enebolig);
		velgBoligtype.add(rekkehus);
		velgBoligtype.add(leilighet);
		
		
		// Felter for enebolig og rekkehus
		eneboligrekkehusfelt = new JPanel();
		
		tomtestr = new JTextField(3);
		eneboligrekkehusfelt.add(new JLabel("Tomtestorrelse (kvm):"));
		eneboligrekkehusfelt.add(tomtestr);
		

		antetasjer = new JTextField(3);
		eneboligrekkehusfelt.add(new JLabel("Antall etasjer:"));
		eneboligrekkehusfelt.add(antetasjer);
		
		
		harkjeller = new JCheckBox("Er det kjeller?");
		eneboligrekkehusfelt.add(harkjeller);
		
		
		
		
		// Felter for leilighet
		leilighetfelt = new JPanel(new GridBagLayout());
		GridBagConstraints lhGc = new GridBagConstraints();
		

		JPanel linje1 = new JPanel();
		linje1.add(new JLabel("Hvilken etasje ligger leiligheten i?"));
		liggerietasje = new JTextField(3);
		linje1.add(liggerietasje);

		lhGc.gridx = 0;
		lhGc.gridy = 0;
		leilighetfelt.add(linje1, lhGc);

		JPanel linje2 = new JPanel();

		hargarasje = new JCheckBox("Garasje");
		harvaskeri = new JCheckBox("Fellesvaskeri");
		
		linje2.add(hargarasje);
		linje2.add(harvaskeri);

		lhGc.gridy = 1;
		leilighetfelt.add(linje2, lhGc);
				
		
		
		
		eneboligrekkehusfelt.setVisible(false);
    	leilighetfelt.setVisible(false);
		
		gc.gridy = 1;

		gc.gridx = 0;
		c.add(velgBoligtype, gc);
		
		gc.gridy = 2;
		
		c.add(eneboligrekkehusfelt, gc);
		c.add(leilighetfelt, gc);
		
		gc.gridy = 3;
		
		gc.gridwidth = 1;
		gc.anchor = GridBagConstraints.WEST;
		gc.gridx = 0;
		c.add(lagre, gc);
		gc.anchor = GridBagConstraints.EAST;
		gc.gridx = 1;
		c.add(avbryt, gc);

		setSize(600, 400);
        setLocationRelativeTo(null);
        setVisible( true );
	}
	
    private class CLytter implements ChangeListener
    {
        public void stateChanged(ChangeEvent e)
        {
            if (enebolig.isSelected() || rekkehus.isSelected())
            {
            	eneboligrekkehusfelt.setVisible(true);
            	leilighetfelt.setVisible(false);
            }
            else if (leilighet.isSelected())
            {
            	eneboligrekkehusfelt.setVisible(false);
            	leilighetfelt.setVisible(true);
            }
        }
    }
    
    private class Lytter implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		if (e.getSource() == lagre)
    		{
    			// sjekk at feltene er fylt ut riktig, så legg til i boligregister
    			
    			if (boligpanelet != null)
    				boligpanelet.listBoliger(false);
    			//dispose();
    		}
    		else if(e.getSource() == avbryt)
    		{
    			dispose();
    		}
    	}
    }
}
