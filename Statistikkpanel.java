import java.awt.*;
import javax.swing.*;

public class Statistikkpanel extends JPanel
{
	public Statistikkpanel(Boligregister br)
	{
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		
		add(new JLabel("Her kommer statistikk:"), gc);
		
		gc.gridy = 1;
		
		int antBoligerTotalt = br.getBoliger().size();
		int antUtleide = br.getKontrakter().size();
		
		add(new JLabel("Det er " + antBoligerTotalt + " ledige boliger for utleie. " + antUtleide + " boliger er leid ut."), gc);
		
		gc.gridy = 2;
		
		add(new JLabel("Hvor mange leiekontrakter har firmaet formidlet hittil i aar?"), gc);
	}
}
