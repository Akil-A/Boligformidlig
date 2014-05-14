// Vindu som viser stort bilde.
// Laget av Ali
// Sist oppdatert april

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

@SuppressWarnings("serial")
public class Bildevindu extends JFrame
{
	// parameteren er bildet som skal vises.
	public Bildevindu(BufferedImage original) 
	{
		super("Stort bilde");
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Container c = getContentPane();	

		final int MAKS_B = Toolkit.getDefaultToolkit().getScreenSize().width;
		final int MAKS_H = Toolkit.getDefaultToolkit().getScreenSize().height;

		int origB = original.getWidth();
		int origH = original.getHeight();
		
		int nyB = origB;
		int nyH = origH;
		
		if (nyB > MAKS_B)
		{
			nyB = MAKS_B;
			nyH = nyH / (origB / MAKS_B);
		}
		
		if (nyH > MAKS_H)
		{
			nyH = MAKS_H;
			nyB = nyB / (nyH / MAKS_H);
		}
		
		Image nyttBilde = original.getScaledInstance(nyB, nyH, BufferedImage.SCALE_FAST);

		JLabel picLabel = new JLabel(new ImageIcon(nyttBilde));
		c.add(picLabel);
	}
}
