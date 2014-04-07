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
		
		// boligregister må hentes fra fil
		br = new Boligregister(new ArrayList<Person>(), new ArrayList<Kontrakt>(), new ArrayList<Interesse>());

		/***** testdata *****/
		Utleier p = new Utleier("Per", "Hansen", "Kirkegata 6", 3024, "Drammen", "", "");
		Utleier p2 = new Utleier("Henrik", "Pettersen", "Avisveien 8", 3027, "Drammen", "", "");
		
		Rekkehus r = new Rekkehus("Borggata 12", 3027, "Drammen", 6000);
		r.setBoareal(30);
		r.setAntrom(5);
		r.setByggeaar(2006);
		r.setBeskrivelse("Hyggelig 3-roms med heis");
		
		Enebolig e = new Enebolig("Parkveien 16", 3024, "Drammen", 7000);
		e.setBoareal(30);
		e.setAntrom(5);
		e.setByggeaar(2005);
		e.setBeskrivelse("Nyoppusset og sentral beliggenhet");
		
		p.settInnBolig(e);
		p2.settInnBolig(r);
		br.settInnPerson(p2);
		br.settInnPerson(p);
		/***** testdata slutt *****/
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JComponent boligpanel = new Boligpanel(br);
		tabbedPane.addTab("Boliger", boligpanel);
		JComponent personpanel = new Personpanel(br);
		tabbedPane.addTab("Personer", personpanel);
		JComponent kontraktpanel = new Kontraktpanel(br);
		tabbedPane.addTab("Kontrakter", kontraktpanel);
		
		Container c = getContentPane();
		c.add(tabbedPane);
	}
	
	
	
	public static void main( String[] args )
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				final Hovedvindu hv = new Hovedvindu();
				hv.setSize(700, 600);
				hv.setVisible(true);
				hv.setLocationRelativeTo( null ); // Vinduet starter på midten av skjermen.
				
				hv.addWindowListener(new WindowAdapter()
				{
					public void windowClosing( WindowEvent e )
					{
						//hv.skrivTilFil();
						System.exit( 0 );
					}
				} );
			}
		});
	}
}
