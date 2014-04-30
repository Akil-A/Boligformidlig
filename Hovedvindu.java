import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.ArrayList;
import java.util.Date;
import java.io.*;

public class Hovedvindu extends JFrame
{
	public Boligregister br;
	private String DATAFIL = "register.dta";
	
	public Hovedvindu()
	{
		super("Boligformidling AS");
		
		//tomtRegister();
		
		lesFil();
		
		final JTabbedPane tabbedPane = new JTabbedPane();
		
		JComponent boligpanel = new Boligpanel(br);
		tabbedPane.addTab("Boliger", boligpanel);
		final JComponent personpanel = new Personpanel(br);
		personpanel.setName("personpanelet");
		tabbedPane.addTab("Personer", personpanel);
		JComponent kontraktpanel = new Kontraktpanel(br);
		tabbedPane.addTab("Kontrakter", kontraktpanel);
		JComponent statistikkpanel = new Statistikkpanel(br);
		tabbedPane.addTab("Statistikk", statistikkpanel);
		
		tabbedPane.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{	
				if (tabbedPane.getSelectedComponent().getName() == "personpanelet")
				{
					((Personpanel)personpanel).oppdaterBoligsokerliste();
					((Personpanel)personpanel).oppdaterUtleierliste();
				}
			}
		});
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(tabbedPane, BorderLayout.CENTER);
		
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
		JLabel lDatafil = new JLabel("Gjeldende datafil: " + DATAFIL);
		lDatafil.setFont(font);
		
		c.add(lDatafil, BorderLayout.SOUTH);
	}
	
	private boolean erLong(String s)
	{
		try
		{
			Long.parseLong(s);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		
		return true;
	}
	
	private String datafil(boolean ny)
	{
		long timestamp = 0;
		
		if (ny)
			timestamp = new Date().getTime();
		else
		{
			File mappen = new File(".");
			
			for (String s : mappen.list())
			{
				// for hver fil i mappen
				// sjekk at filnavnet
				// begynner paa "register_"
				// slutter paa ".dta"
				// og inneholder en long-verdi imellom
				if (s.length() > 14 &&
						s.substring(0, 9).equals("register_") &&
						s.substring(s.length() - 4).equals(".dta") &&
						erLong(s.substring(9, s.length() - 4)))
				{
					long j = Long.parseLong(s.substring(9, s.length() - 4));
					
					if (j > timestamp)
						timestamp = j;
				}
			}

			if (timestamp == 0)
				timestamp = new Date().getTime();
		}
		
		return "register_" + timestamp + ".dta";
	}

	private void lesFil()
	{
		DATAFIL = datafil(false);
		
		try ( ObjectInputStream innfil = new ObjectInputStream( new FileInputStream( DATAFIL ) ) )
		{
			br = (Boligregister) innfil.readObject();
			visMelding( "Data er hentet fra fil." );
		}
		catch(ClassNotFoundException cnfe)
		{
			visMelding( "Feil:\n\n" + cnfe.getMessage() + "\n\nOppretter tom datafil. Tar vare paa gammel datafil." );
			tomtRegister();
			DATAFIL = datafil(true);
			skrivTilFil(false);
		}
		catch(FileNotFoundException fne)
		{
			visMelding( "Finner ikke datafil. Oppretter tom datafil." );
			tomtRegister();
			skrivTilFil(false);
		}
		catch(IOException ioe)
		{
			visMelding( "Innlesingsfeil. Oppretter tom datafil. Tar vare paa gammel datafil." );
			tomtRegister();
			DATAFIL = datafil(true);
			skrivTilFil(false);
		}
	}
	
	private void tomtRegister()
	{
		br = new Boligregister(new ArrayList<Person>(), new ArrayList<Bolig>(), new ArrayList<Kontrakt>(), new ArrayList<Interesse>());
	}

	
	private void skrivTilFil(boolean visMelding)
	{
		try ( ObjectOutputStream utfil = new ObjectOutputStream( new FileOutputStream( DATAFIL ) ) )
		{
			utfil.writeObject( br );
			
			if (visMelding)
				visMelding("Data er skrevet til fil.");
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
				hv.setSize(700, 700);
				hv.setVisible(true);
				hv.setLocationRelativeTo( null ); // Vinduet starter paa midten av skjermen.
				
				hv.addWindowListener(new WindowAdapter()
				{
					public void windowClosing( WindowEvent e )
					{
						hv.skrivTilFil(true);
						System.exit( 0 );
					}
				} );
			}
		});
	}
}
