/* Vindusklasse med felter. Her kan man registrere ny bolig eller oppdatere bolig.
 */

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Boligskjemavindu extends JFrame
{
	private JRadioButton enebolig, rekkehus, leilighet;
	private JTextField adresse, postnr, poststed, boareal, antrom, byggeaar, pris;
	private JTextArea beskrivelse;
	private CLytter clytter;
	private JPanel eneboligfelt, rekkehusfelt, leilighetfelt;
	private JButton lagre, slett;
	
	public Boligskjemavindu(Boligregister br)
	{
		super("Registrer ny bolig");
		lagVindu();
		slett.setText("Avbryt");
	}

	public Boligskjemavindu(Bolig b)
	{
		super("Oppdater bolig");
		lagVindu();
		
		adresse.setText(b.getAdresse());
		postnr.setText(Integer.toString(b.getPostnr()));
		poststed.setText(b.getPoststed());
		boareal.setText(Integer.toString(b.getBoareal()));
		antrom.setText(Integer.toString(b.getAntrom()));
		byggeaar.setText(Integer.toString(b.getByggeaar()));
		pris.setText(Integer.toString(b.getUtleiepris()));
		
		if (b instanceof Enebolig)
		{
			enebolig.doClick();
			//enebolig.setSelected(true);
		}
		else if (b instanceof Rekkehus)
		{
			enebolig.doClick();
			//rekkehus.setSelected(true);
		}
		else if (b instanceof Leilighet)
		{
			enebolig.doClick();
			//leilighet.setSelected(true);
		}
	}
	
	private void lagVindu()
	{
        clytter = new CLytter();
		adresse = new JTextField(10);
		postnr = new JTextField(10);
		poststed = new JTextField(10);
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
        slett = new JButton("Slett");
		
		Container c = getContentPane();
		c.setLayout(new GridBagLayout());
		
		JPanel toppvenstre = new JPanel(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.NORTHEAST;
		gc.insets.left = 5;
		gc.gridx = 0;
		gc.gridy = 0;
		toppvenstre.add(new JLabel("Adresse:"), gc);
		gc.gridx = 1;
		toppvenstre.add(adresse, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		toppvenstre.add(new JLabel("Postnr:"), gc);
		gc.gridx = 1;
		toppvenstre.add(postnr, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		toppvenstre.add(new JLabel("Poststed:"), gc);
		gc.gridx = 1;
		toppvenstre.add(poststed, gc);
		
		JPanel topphoyre = new JPanel(new GridBagLayout());
		gc.gridx = 0;
		gc.gridy = 0;
		topphoyre.add(new JLabel("Boareal (kvm)"), gc);
		gc.gridx = 1;
		topphoyre.add(boareal, gc);
		gc.gridx = 0;
		gc.gridy = 1;
		topphoyre.add(new JLabel("Antall rom:"), gc);
		gc.gridx = 1;
		topphoyre.add(antrom, gc);
		gc.gridx = 0;
		gc.gridy = 2;
		topphoyre.add(new JLabel("Byggeaar:"), gc);
		gc.gridx = 1;
		topphoyre.add(byggeaar, gc);
		gc.gridx = 0;
		gc.gridy = 3;
		topphoyre.add(new JLabel("Pris kr/mnd:"), gc);
		gc.gridx = 1;
		topphoyre.add(pris, gc);
		
		JPanel velgBoligtype = new JPanel();
		velgBoligtype.add(enebolig);
		velgBoligtype.add(rekkehus);
		velgBoligtype.add(leilighet);
		
		eneboligfelt = new JPanel();
		eneboligfelt.add(new JLabel("Enebolig er valgt"));
		rekkehusfelt = new JPanel();
		rekkehusfelt.add(new JLabel("Rekkehus er valgt"));
		leilighetfelt = new JPanel();
		leilighetfelt.add(new JLabel("Leilighet er valgt"));
		
    	eneboligfelt.setVisible(false);
    	rekkehusfelt.setVisible(false);
    	leilighetfelt.setVisible(false);
    	
    	JPanel knappefelt = new JPanel();
    	knappefelt.add(lagre);
    	knappefelt.add(slett);
		
		gc.gridx = 0;
		gc.gridy = 0;
		c.add(toppvenstre, gc);
		gc.gridx = 1;
		c.add(topphoyre, gc);
		gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.CENTER;
		c.add(velgBoligtype, gc);
		gc.gridy = 2;
		c.add(eneboligfelt, gc);
		c.add(rekkehusfelt, gc);
		c.add(leilighetfelt, gc);
		gc.gridy = 3;
		gc.gridwidth = 1;
		gc.anchor = GridBagConstraints.WEST;
		gc.gridx = 0;
		c.add(lagre, gc);
		gc.anchor = GridBagConstraints.EAST;
		gc.gridx = 1;
		c.add(slett, gc);

		setSize(500, 300);
        setLocationRelativeTo(null);
        setVisible( true );
	}
	
    private class CLytter implements ChangeListener
    {
        public void stateChanged(ChangeEvent e)
        {
            if (enebolig.isSelected())
            {
            	eneboligfelt.setVisible(true);
            	rekkehusfelt.setVisible(false);
            	leilighetfelt.setVisible(false);
            }
            else if (rekkehus.isSelected())
            {
            	eneboligfelt.setVisible(false);
            	rekkehusfelt.setVisible(true);
            	leilighetfelt.setVisible(false);
            }
            else if (leilighet.isSelected())
            {
            	eneboligfelt.setVisible(false);
            	rekkehusfelt.setVisible(false);
            	leilighetfelt.setVisible(true);
            }
        }
    }
}
