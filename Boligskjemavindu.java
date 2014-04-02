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
	
	public Boligskjemavindu()
	{
		super("Registrer ny bolig");
		lagVindu();
	}

	public Boligskjemavindu(Bolig b)
	{
		super("Oppdater bolig");
		lagVindu();
		
		adresse.setText(b.getAdresse());
	}
	
	private void lagVindu()
	{
		adresse = new JTextField(10);
		postnr = new JTextField(10);
		poststed = new JTextField(10);
		boareal = new JTextField(10);
		antrom = new JTextField(10);
		byggeaar = new JTextField(10);
		pris = new JTextField(10);
		enebolig = new JRadioButton("Enebolig");
		rekkehus = new JRadioButton("Rekkehus");
		leilighet = new JRadioButton("Leilighet");
        ButtonGroup boligtype = new ButtonGroup();
        boligtype.add(enebolig);
        boligtype.add(rekkehus);
        boligtype.add(leilighet);
        clytter = new CLytter();
		
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

		setSize(700, 600);
        setLocationRelativeTo(null);
        setVisible( true );
	}
	
    private class CLytter implements ChangeListener
    {
        public void stateChanged(ChangeEvent e)
        {
            if (enebolig.isSelected())
            {
            	
            }
            else if (rekkehus.isSelected())
            {
            	
            }
            else if (leilighet.isSelected())
            {
            	
            }
        }
    }
}
