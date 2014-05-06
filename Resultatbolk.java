import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Resultatbolk extends JPanel
{
	private final Font IKKEFET = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
	private final Font FET = new Font(Font.SANS_SERIF, Font.BOLD, 12);
	private final Font STOR = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
	private final Font LITEN = new Font(Font.SANS_SERIF, Font.PLAIN, 11);
	private Bolig boligen;
	private Boligregister registret;
	
	public Resultatbolk(Boligregister br, Bolig b)
	{
		setLayout(new GridBagLayout());
		
		boligen = b;
		registret = br;
		
		oppdater();
	}
	
	public void oppdater()
	{
		removeAll();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		
		
		JLabel tittel = new JLabel(boligen.getTittel() + "   ");
		tittel.setFont(STOR);
		JLabel dato = new JLabel(sdf.format(boligen.getAnnonsedato()));
		dato.setFont(IKKEFET);
		dato.setForeground(Color.GRAY);
		
		JPanel tittelfelt = new JPanel(new GridBagLayout());
		GridBagConstraints gc77 = new GridBagConstraints();
		gc77.anchor = GridBagConstraints.SOUTH;
		tittelfelt.add(tittel, gc77);
		tittelfelt.add(dato, gc77);
		tittelfelt.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		
		JLabel boareal = new JLabel("<html>" + String.valueOf(boligen.getBoareal()) + " m&sup2;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html>");
		boareal.setFont(FET);
		JLabel pris = new JLabel(String.valueOf(boligen.getUtleiepris()) + ",- /mnd");
		pris.setFont(FET);
		
		JPanel tallfelt = new JPanel(new GridBagLayout());
		tallfelt.add(boareal);
		tallfelt.add(pris);
		
		JLabel adresse = new JLabel(boligen.getAdresse() + ", " + boligen.getPostnr() + " " + boligen.getPoststed().toUpperCase());
		adresse.setFont(LITEN);

		GridBagConstraints gc4 = new GridBagConstraints();
		gc4.anchor = GridBagConstraints.NORTHWEST;
		gc4.insets.bottom = 5;
		gc4.gridx = 1;
		gc4.gridy = 0;
		add(tittelfelt, gc4);
		gc4.gridy = 1;
		add(tallfelt, gc4);
		gc4.gridy = 2;
		add(adresse, gc4);
		gc4.gridy = 3;
		
		JButton detaljer = new JButton("Detaljer");
		detaljer.setFont(IKKEFET);
		detaljer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new Boligskjemavindu(registret, Resultatbolk.this, boligen);
			}
		});
		
		
		boolean erleidut = false;

		for (Kontrakt k : registret.getFungerende())
			if (k.getBolig() == boligen)
			{
				erleidut = true;
				break;
			}
		
		
		JPanel boligknapper = new JPanel(new GridBagLayout());
		GridBagConstraints gc66 = new GridBagConstraints();
		gc66.insets.right = 5;
		gc66.insets.top = 2;
		boligknapper.add(detaljer, gc66);
		
		if (!erleidut)
		{
			JButton leiut = new JButton("Utleie");
			leiut.setFont(IKKEFET);
			leiut.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					new Leiutvindu(registret, boligen, Resultatbolk.this);
				}
			});
			boligknapper.add(leiut, gc66);
		}
		
		add(boligknapper, gc4);
		
		JButton bildeknapp = new JButton();
		bildeknapp.setPreferredSize(new Dimension(130, 110));
		bildeknapp.setEnabled(false);
		bildeknapp.setText("<html><center>-mangler<br>bilde-</center></html>");
		bildeknapp.setFont(IKKEFET);
		
		if (boligen.getBildefilnavn() != null && !boligen.getBildefilnavn().isEmpty())
		{
			try
			{
				final BufferedImage mittBilde1 = ImageIO.read(new File("bilder" + File.separatorChar + boligen.getBildefilnavn()));
				Image skalert = mittBilde1.getScaledInstance(130, 110, BufferedImage.SCALE_FAST);
				
				bildeknapp.setText(null);
				bildeknapp.setEnabled(true);
				bildeknapp.setIcon(new ImageIcon(skalert));
				bildeknapp.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						new Bildevindu(mittBilde1);
					}
				});
			}
			catch(IOException ex)
			{
			}
		}

		gc4.gridheight = 4;
		gc4.gridx = 0;
		gc4.gridy = 0;
		gc4.insets.right = 10;
 	   	add(bildeknapp, gc4);
	}
}
