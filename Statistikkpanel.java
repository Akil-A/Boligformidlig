import java.awt.*;
import javax.swing.*;

public class Statistikkpanel extends JPanel
{	
	private Boligregister register;
	private JLabel lantallBoliger, lantallUtleide;
	
	public Statistikkpanel(Boligregister br)
	{
		register = br;
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		
		add(new JLabel("Her kommer statistikk:"), gc);
		
		gc.gridy = 1;
		
		
		lantallBoliger = new JLabel();
		add(lantallBoliger, gc);
		
		
		
		gc.gridy = 2;
		
		lantallUtleide = new JLabel();
		add(lantallUtleide, gc);		
	}
	
	public void oppdaterStatistikk()
	{	
		lantallBoliger.setText("Det er " + register.getBoliger().size() + " ledige boliger for utleie. " + register.getUtleideiAAr() + " boliger er leid ut.");
		lantallUtleide.setText("Det er " + register.getUtleide().size() + " leiekontrakter formidlet hittil i aar.");
		repaint();
	}
}
