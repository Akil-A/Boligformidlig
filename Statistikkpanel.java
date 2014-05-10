// Vinduskomponent som viser statistikk.

import java.awt.*;
import javax.swing.*;

public class Statistikkpanel extends JPanel
{	
	private Boligregister register;
	private JLabel statistikken;
	
	public Statistikkpanel(Boligregister br)
	{
		register = br;
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		
		statistikken = new JLabel();
		oppdaterStatistikk();
		
		add(statistikken, gc);
	}
	
	public void oppdaterStatistikk()
	{	
		String teksten = "<html>Det er " + register.getBoliger().size() + " bolig(er) registrert i systemet.<br>";
		teksten += register.getLedige().size() + " bolig(er) er ledige.<br>";
		teksten += register.getUtleide().size() + " bolig(er) er leid ut.<br>";
		teksten += "Det er formidlet " + register.getUtleideiAAr() + " leiekontrakt(er) hittil i &aring;r.</html>";
		
		statistikken.setText(teksten);
	}
}

