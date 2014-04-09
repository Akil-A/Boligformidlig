import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

public class Vindu extends JFrame
{
		public Vindu(Image skalert2)
		{
			super("Stor vindu");
			setSize(800,600);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			Container c = getContentPane();
			JLabel picLabel = new JLabel(new ImageIcon(skalert2));
			c.add(picLabel);
	        setLocationRelativeTo(null);
			setVisible(true);
		}
}
