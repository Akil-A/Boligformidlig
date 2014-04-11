import javax.swing.JFrame;

import java.awt.*;
import javax.swing.*;

public class Bildevindu extends JFrame
{
		public Bildevindu(Image skalert2)
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
