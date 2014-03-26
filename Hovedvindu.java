import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;

public class Hovedvindu extends JFrame
{
	
	public Boligregister br;
	
	public Hovedvindu()
	{
		super("Boligformidling AS");
		setSize(700, 600);
		
		// boligregister må hentes fra fil
		br = new Boligregister(new ArrayList<Person>(), new ArrayList<Kontrakt>(), new ArrayList<Interesse>());
		

		JTabbedPane tabbedPane = new JTabbedPane();
		
		JComponent boligpanel = new Boligpanel();
		tabbedPane.addTab("Boliger", boligpanel);
		JComponent panel2 = new JPanel();
		tabbedPane.addTab("Personer", panel2);
		JComponent panel3 = new JPanel();
		tabbedPane.addTab("Kontrakter", panel3);
		
		
		Container c = getContentPane();
		c.add(tabbedPane);

		setVisible( true );
		setLocationRelativeTo( null ); // Vinduet starter på midten av skjermen.
	}
	
	public static void main( String[] args )
	{
		final Hovedvindu hv = new Hovedvindu();

		hv.addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing( WindowEvent e )
				{
					//hv.skrivTilFil();
					System.exit( 0 );
				}
			} );
	}
}
