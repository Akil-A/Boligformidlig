import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Bildevindu extends JFrame
{
	public Bildevindu(BufferedImage original)
	{
		super("Stort bilde");
		setSize(800, 600);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		Container c = getContentPane();

		int origB = original.getWidth();
		int origH = original.getHeight();
		
		int nyB = origB;
		int nyH = origH;
		
		if (origB > 800)
		{
			nyB = 800;
			nyH = origH / (origB / nyB);
		}
		
		if (nyH > 600)
		{
			nyH = 600;
			nyB = nyB / (origH / nyH);
		}
		
		Image nyttBilde = original.getScaledInstance(nyB, nyH, BufferedImage.SCALE_SMOOTH);
		
		JLabel picLabel = new JLabel(new ImageIcon(nyttBilde));
		c.add(picLabel);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
