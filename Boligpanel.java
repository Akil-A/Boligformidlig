//Denne klassen tar seg av registrering og soking av bolig.

import javax.swing.*;
import java.awt.*;

public class Boligpanel extends JPanel
{
	public Boligpanel(Boligregister br)
	{
		setLayout(new BorderLayout());
		
		/* FILTERPANEL og KNAPPEPANEL
		 =========================================================================== */
		JPanel nordPanel = new JPanel(new GridBagLayout());
		
		JComponent innerFilterPanel = new JPanel(new FlowLayout());
		innerFilterPanel.add(new JLabel("Dette er en scrollpane."));
		innerFilterPanel.add(new JLabel("Skriv noe her:"));
		innerFilterPanel.add(new JTextField(10));
		innerFilterPanel.add(new JTextField(10));
		innerFilterPanel.add(new JTextField(10));
		innerFilterPanel.add(new JTextField(10));
		
		JScrollPane filterPanel = new JScrollPane(innerFilterPanel);
		filterPanel.setBorder(BorderFactory.createTitledBorder("Filter"));
		filterPanel.setPreferredSize(new Dimension(450, 110)); // (bredde, høyde)
		filterPanel.setSize(new Dimension(450, 110)); // (bredde, høyde)
		filterPanel.setMaximumSize(new Dimension(450, 110)); // (bredde, høyde)
		filterPanel.setMinimumSize(new Dimension(450, 110)); // (bredde, høyde)
		
		JPanel knappePanel = new JPanel(new BorderLayout());
		knappePanel.add(new JButton("Søk"), BorderLayout.WEST);
		knappePanel.add(new JButton("Registrer ny"), BorderLayout.EAST);
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.weightx = 1.0;
		nordPanel.add(filterPanel, gc);
		gc.gridy = 1;
		nordPanel.add(knappePanel, gc);
		
		add(nordPanel, BorderLayout.NORTH);
		
		/* LISTEPANEL 
		 =========================================================================== */

		/***** testdata *****/
		Utleier p = new Utleier("Per", "Hansen", "Kirkegata 6", 3024, "Drammen", "", "");
		Enebolig e = new Enebolig("Parkveien 16", 3024, "Drammen", 30, 5, 2005, "", 7000);
		p.settInnBolig(e);
		br.settInnPerson(p);
		/***** testdata slutt *****/
		
		JPanel innerListePanel = new JPanel();
		
		for (Bolig b : br.getBoliger())
		{
			innerListePanel.add(new JLabel(b.toString()));
		}
		
		JScrollPane listePanel = new JScrollPane(innerListePanel);
		
		add(listePanel, BorderLayout.CENTER);
	}
}

