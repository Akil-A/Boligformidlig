import java.awt.*;
import javax.swing.*;

public class Statistikkpanel extends JPanel
{
	private Boligregister register;
	private int antallUtleide, antBoligerTotalt, antUtleide;
	
	public Statistikkpanel(Boligregister br)
	{	
		register = br;
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		
		add(new JLabel("Her kommer statistikk:"), gc);
		
		gc.gridy = 1;
		
		antBoligerTotalt = br.getBoliger().size();
		antUtleide = br.getUtleide().size();
		
		add(new JLabel("Det er " + antBoligerTotalt + " ledige boliger for utleie. " + antUtleide + " boliger er leid ut."), gc);
		
		gc.gridy = 2;
		
		antallUtleide = br.getUtleideiAAr();
		
		add(new JLabel("Det er " + antallUtleide + " leiekontrakter formidlet hittil i aar"), gc);
		
	}
	
	public void oppdaterStatistikk()
	{
		antBoligerTotalt = register.getBoliger().size();
		antUtleide = register.getUtleide().size();
		antallUtleide = register.getUtleideiAAr();
	}
}
