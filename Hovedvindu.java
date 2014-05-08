import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.util.*;
import java.util.Timer;
import java.io.*;

public class Hovedvindu extends JFrame
{
	public Boligregister br;
	private String DATAFIL = "register.dta";
	private JButton lagre;
	private Timer timer;
	private Color standardKnappebakgrunn;
	
	public Hovedvindu()
	{
		super("Boligformidling AS");
		
		//tomtRegister();
		
		lesFil();
		
		final JTabbedPane tabbedPane = new JTabbedPane();
		
		final JComponent boligpanel = new Boligpanel(br);
		boligpanel.setName("boligpanelet");
		tabbedPane.addTab("Boliger", boligpanel);
		final JComponent personpanel = new Personpanel(br);
		personpanel.setName("personpanelet");
		tabbedPane.addTab("Personer", personpanel);
		final JComponent kontraktpanel = new Kontraktpanel(br);
		kontraktpanel.setName("kontraktpanelet");
		tabbedPane.addTab("Kontrakter", kontraktpanel);
		final JComponent statistikkpanel = new Statistikkpanel(br);
		statistikkpanel.setName("statistikkpanelet");
		tabbedPane.addTab("Statistikk", statistikkpanel);
		
		tabbedPane.addChangeListener(new ChangeListener()
		{
			public void stateChanged(ChangeEvent e)
			{
				if (tabbedPane.getSelectedComponent().getName() == "boligpanelet")
				{
					((Boligpanel)boligpanel).oppdaterBoligsokerliste(null);
				}
				else if (tabbedPane.getSelectedComponent().getName() == "personpanelet")
				{
					((Personpanel)personpanel).oppdaterBoligsokerliste();
					((Personpanel)personpanel).oppdaterUtleierliste();
				}
				else if (tabbedPane.getSelectedComponent().getName() == "kontraktpanelet")
				{
					((Kontraktpanel)kontraktpanel).oppdaterFungerendeListe();
					((Kontraktpanel)kontraktpanel).oppdaterUtgaattListe();
				}
				else if (tabbedPane.getSelectedComponent().getName() == "statistikkpanelet")
				{
					((Statistikkpanel)statistikkpanel).oppdaterStatistikk();
				}
			}
		});
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		c.add(tabbedPane, BorderLayout.CENTER);
		
		Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
		
		JLabel lDatafil = new JLabel("Gjeldende datafil: " + DATAFIL);
		lDatafil.setFont(font);
		
		lagre = new JButton("LAGRE");
		lagre.addActionListener(new Lytter());
		lagre.setFont(font);
		lagre.setFocusPainted(false);
		
		standardKnappebakgrunn = lagre.getBackground();
		
		JPanel bunnlinje = new JPanel(new BorderLayout());
		bunnlinje.add(lDatafil, BorderLayout.WEST);
		bunnlinje.add(lagre, BorderLayout.EAST);
		
		c.add(bunnlinje, BorderLayout.SOUTH);
	}
	
	private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if (e.getSource() == lagre)
			{
				if (skrivTilFil(false))
				{
					lagre.setBackground(Color.YELLOW);
					lagre.setText("LAGRET");
					
					Calendar c = Calendar.getInstance();
					c.add(Calendar.SECOND, 2);
					
					timer = new Timer();
					timer.schedule(new TimerTask() {
							public void run()
							{
								lagre.setBackground(standardKnappebakgrunn);
								lagre.setText("LAGRE");
							}
						}, c.getTime());
				}
			}
		}
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
			visMelding( "<html>Feil:<br><br>" + cnfe.getMessage() + "<br><br>Oppretter tom datafil. Tar vare p&aring; gammel datafil.</html>" );
			tomtRegister();
			DATAFIL = datafil(true);
			skrivTilFil(false);
		}
		catch(FileNotFoundException fne)
		{
			visMelding( "Ingen datafil funnet. Oppretter tom datafil." );
			tomtRegister();
			skrivTilFil(false);
		}
		catch(IOException ioe)
		{
			visMelding( "<html>Innlesingsfeil. Oppretter tom datafil. Tar vare p&aring; gammel datafil.</html>" );
			tomtRegister();
			DATAFIL = datafil(true);
			skrivTilFil(false);
		}
	}
	
	private void tomtRegister()
	{
		br = new Boligregister(new ArrayList<Person>(), new ArrayList<Bolig>(), new ArrayList<Kontrakt>());
	}

	
	private boolean skrivTilFil(boolean visMelding)
	{
		try ( ObjectOutputStream utfil = new ObjectOutputStream( new FileOutputStream( DATAFIL ) ) )
		{
			utfil.writeObject( br );
			
			if (visMelding)
				visMelding("<html>Data er lagret.</html>");
			
			return true;
		}
		catch( NotSerializableException nse )
		{
			visMelding("Objektet er ikke serialisert!");
			
			return false;
		}
		catch( IOException ioe )
		{
			visMelding("<html>Problem med &aring; skrive til fil.</html>");
			
			return false;
		}
	}

	private void visMelding(String melding)
	{
		JOptionPane.showMessageDialog( this, melding, "", JOptionPane.PLAIN_MESSAGE );
	}
	
	
	public static void main( String[] args )
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				final Hovedvindu hv = new Hovedvindu();
				hv.setSize(900, 700);
				hv.setVisible(true);
				hv.setLocationRelativeTo( null ); // Vinduet starter paa midten av skjermen.
				hv.setExtendedState(Frame.MAXIMIZED_BOTH);
				
				hv.addWindowListener(new WindowAdapter()
				{
					public void windowClosing( WindowEvent e )
					{
						if (hv.skrivTilFil(true))
							System.exit( 0 );
						else
						{
							int i = JOptionPane.showConfirmDialog(null, "<html>Data kan ikke lagres p&aring; fil. Vil du avslutte?</html>",
									"Bekreft", JOptionPane.YES_NO_OPTION);
							
							if (i == JOptionPane.YES_OPTION)
								System.exit(0);
						}
					}
				} );
			}
		});
	}
}

