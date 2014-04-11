import javax.swing.*;

public class Statistikkpanel extends JPanel
{
	public Statistikkpanel(Boligregister br)
	{
		add(new JLabel("Her kommer statistikk:"));
		add(new JLabel("Det er " + br.getBoliger().size() + " boliger for utleie for øyeblikket."));
		add(new JLabel("Hvor mange leiekontrakter firmaet har formidlet hittil i år."));
	}
}
