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
		Font ikkefet = new Font(c.getFont().getFontName(), Font.PLAIN, c.getFont().getSize());
		
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
		JLabel ltogst = new JLabel("Naermeste togstasjon:");
		ltogst.setFont(ikkefet);
		toppanel.add(ltogst, gc);
		gc.gridx = 1;
		toppanel.add(togst, gc);
		gc.gridx = 2;
		toppanel.add(new JLabel("Pris kr/mnd:"), gc);
		gc.gridx = 3;
		toppanel.add(pris, gc);
		/***** toppanel slutt *****/
		
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridy = 0;
		
		c.add(toppanel, gc);
		
		JPanel velgBoligtype = new JPanel();
		velgBoligtype.add(enebolig);
		velgBoligtype.add(rekkehus);
		velgBoligtype.add(leilighet);
		
		
		
		
		/***** enebolig og rekkehusfelt start *****/
		eneboligrekkehusfelt = new JPanel(new GridBagLayout());
		GridBagConstraints erGc = new GridBagConstraints();

		erGc.gridx = 0;
		erGc.gridy = 0;

		JPanel elinje1 = new JPanel();
		
		tomtestr = new JTextField(3);
		JLabel ltomtestr = new JLabel("Tomtestorrelse (kvm):");
		ltomtestr.setFont(ikkefet);
		elinje1.add(ltomtestr);
		elinje1.add(tomtestr);

		antetasjer = new JTextField(3);
		JLabel lantetasjer = new JLabel("Antall etasjer:");
		lantetasjer.setFont(ikkefet);
		elinje1.add(lantetasjer);
		elinje1.add(antetasjer);

		JPanel elinje2 = new JPanel();
		
		harkjeller = new JCheckBox("Er det kjeller?");
		harkjeller.setFont(ikkefet);
		elinje2.add(harkjeller);

		eneboligrekkehusfelt.add(elinje1, erGc);
		erGc.gridy = 1;
		eneboligrekkehusfelt.add(elinje2, erGc);
		/***** enebolig og rekkehusfelt slutt *****/
		
		
		
		
		/***** leilighetfelt start *****/
		leilighetfelt = new JPanel(new GridBagLayout());
		GridBagConstraints lhGc = new GridBagConstraints();

		lhGc.gridx = 0;
		lhGc.gridy = 0;
		
		JPanel llinje1 = new JPanel();
		JLabel lliggerietasje = new JLabel("Hvilken etasje ligger leiligheten i?");
		lliggerietasje.setFont(ikkefet);
		llinje1.add(lliggerietasje);
		liggerietasje = new JTextField(3);
		llinje1.add(liggerietasje);

		leilighetfelt.add(llinje1, lhGc);

		JPanel llinje2 = new JPanel();

		hargarasje = new JCheckBox("Garasje");
		hargarasje.setFont(ikkefet);
		harvaskeri = new JCheckBox("Fellesvaskeri");
		harvaskeri.setFont(ikkefet);
		
		llinje2.add(hargarasje);
		llinje2.add(harvaskeri);

		lhGc.gridy = 1;
		leilighetfelt.add(llinje2, lhGc);
		/***** leilighetfelt slutt *****/
				
		
		
		
		eneboligrekkehusfelt.setVisible(false);
    	leilighetfelt.setVisible(false);
		
		gc.gridy = 1;

		c.add(velgBoligtype, gc);
		
		gc.gridy = 2;
		
		c.add(eneboligrekkehusfelt, gc);
		c.add(leilighetfelt, gc);
		
		gc.gridy = 3;
		gc.insets.top = 20;
		
		JPanel knappepanel = new JPanel(new BorderLayout());
		knappepanel.add(lagre, BorderLayout.WEST);
		knappepanel.add(new JLabel("                **Felter med fet tekst er obligatoriske**"), BorderLayout.CENTER);
		knappepanel.add(avbryt, BorderLayout.EAST);
		
		gc.fill = GridBagConstraints.HORIZONTAL;
		c.add(knappepanel, gc);
		
		/*gc.gridwidth = 1;
		gc.anchor = GridBagConstraints.WEST;
		gc.gridx = 0;
		c.add(lagre, gc);
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 1;
		c.add(new JLabel("**Felter med fet tekst er obligatoriske**"), gc);
		gc.anchor = GridBagConstraints.EAST;
		gc.gridx = 2;
		c.add(avbryt, gc);*/

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
    			String feilmelding = "";
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
