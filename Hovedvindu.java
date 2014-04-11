import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

public class Hovedvindu extends JFrame
{
	public Boligregister br;
	private final String DATAFIL = "register.dta";
	
	public Hovedvindu()
	{
		super("Boligformidling AS");
		
		//tomtRegister();
		//settInnTestData();
		
		lesFil();

		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JComponent boligpanel = new Boligpanel(br);
		tabbedPane.addTab("Boliger", boligpanel);
		JComponent personpanel = new Personpanel(br);
		tabbedPane.addTab("Personer", personpanel);
		JComponent kontraktpanel = new Kontraktpanel(br);
		tabbedPane.addTab("Kontrakter", kontraktpanel);
		
		JPanel statistikkpanel = new JPanel();
		statistikkpanel.add(new JLabel("Her kommer statistikk:"));
		statistikkpanel.add(new JLabel("Hvor mange boliger firmaet har for utleie for øyeblikket."));
		statistikkpanel.add(new JLabel("Hvor mange leiekontrakter firmaet har formidlet hittil i år."));
		
		tabbedPane.addTab("Statistikk", statistikkpanel);
		
		Container c = getContentPane();
		c.add(tabbedPane);
	}
	
	
	private void settInnTestData()
	{
		Utleier p = new Utleier("Per", "Hansen", "Kirkegata 6", 3024, "Drammen", "", "12345678");
		Utleier p2 = new Utleier("Henrik", "Pettersen", "Avisveien 8", 3027, "Drammen", "", "98765432");
		Boligsoker bo = new Boligsoker("Nils", "Vogt", "Drammensveien 76", 1337, "Sandvika", "", "45678123");
		
		Rekkehus r = new Rekkehus("Borggata 12", 3027, "Drammen", 6000);
		r.setTittel("Hyggelig 3-roms med heis");
		r.setBoareal(30);
		r.setAntrom(5);
		r.setByggeaar(2006);
		
		Enebolig e = new Enebolig("Parkveien 16", 3024, "Drammen", 7000);
		e.setTittel("Nyoppusset og sentral beliggenhet");
		e.setBoareal(30);
		e.setAntrom(5);
		e.setByggeaar(2005);
		
		p.settInnBolig(e);
		p2.settInnBolig(r);
		br.settInnPerson(p2);
		br.settInnPerson(p);
		br.settInnPerson(bo);
	}
	

	private void lesFil()
	{
		try ( ObjectInputStream innfil = new ObjectInputStream( new FileInputStream( DATAFIL ) ) )
		{
			br = (Boligregister) innfil.readObject();
			visMelding( "Register er hentet fra " + DATAFIL );
		}
		catch(ClassNotFoundException cnfe)
		{
			visMelding( cnfe.getMessage() + "\n\nOppretter tomt register." );
			tomtRegister();
		}
		catch(FileNotFoundException fne)
		{
			visMelding( "Finner ikke datafil. Oppretter tomt register." );
			tomtRegister();
		}
		catch(IOException ioe)
		{
			visMelding( "Innlesingsfeil. Oppretter tomt register." );
			tomtRegister();
		}
	}
	
	private void tomtRegister()
	{
		br = new Boligregister(new ArrayList<Person>(), new ArrayList<Kontrakt>(), new ArrayList<Interesse>());
	}

	
	private void skrivTilFil()
	{
		try ( ObjectOutputStream utfil = new ObjectOutputStream( new FileOutputStream( DATAFIL ) ) )
		{
			utfil.writeObject( br );
			visMelding("Registret er lagret i " + DATAFIL);
		}
		catch( NotSerializableException nse )
		{
			visMelding("Objektet er ikke serialisert!");
		}
		catch( IOException ioe )
		{
			visMelding("Problem med utskrift til fil.");
		}
	}

	private void visMelding(String melding)
	{
		JOptionPane.showMessageDialog( this, melding, "Melding", JOptionPane.PLAIN_MESSAGE );
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
						hv.skrivTilFil();
						System.exit( 0 );
					}
				} );
			}
		});
	}
}
