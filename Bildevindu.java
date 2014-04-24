import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Bildevindu extends JFrame
{
	public Bildevindu(BufferedImage original)
	{
		super("Stort bilde");
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Container c = getContentPane();

		final int MAKS_B = getWidth();
		final int MAKS_H = getHeight();

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
