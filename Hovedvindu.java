import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class Hovedvindu extends JFrame
{
	private JButton personer, nyperson, boliger, nybolig, kontrakter;
	private Lytter lytter;
	public Boligsystem bs;
	
	public Hovedvindu()
	{
		super("Boligformidling");
		setSize(400, 250);
		
		// må hentes fra fil
		bs = new Boligsystem(new ArrayList<Person>(), new ArrayList<Kontrakt>());
		
		personer = new JButton("Personer");
		personer.addActionListener(lytter);
		personer.setPreferredSize(new Dimension(200, personer.getPreferredSize().height));
		
		nyperson = new JButton("Ny person");
		nyperson.addActionListener(lytter);
		nyperson.setPreferredSize(new Dimension(100, personer.getPreferredSize().height));
		
		boliger = new JButton("Boliger");
		boliger.addActionListener(lytter);
		boliger.setPreferredSize(new Dimension(200, personer.getPreferredSize().height));
		
		nybolig = new JButton("Ny bolig");
		nybolig.addActionListener(lytter);
		nybolig.setPreferredSize(new Dimension(100, personer.getPreferredSize().height));
		
		kontrakter = new JButton("Kontrakter");
		kontrakter.addActionListener(lytter);
		kontrakter.setPreferredSize(new Dimension(200, personer.getPreferredSize().height));
		
		JPanel p = new JPanel( new GridBagLayout() );
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.insets.left = 5;
		gc.insets.top = 5;
		
		gc.gridx = 0;
		gc.gridy = 0;
		p.add(personer, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		p.add(nyperson, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		p.add(boliger, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		p.add(nybolig, gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		p.add(kontrakter, gc);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		c.add(p, BorderLayout.NORTH);
		
		

		setVisible( true );
		setLocationRelativeTo( null ); // Vinduet starter på midten av skjermen.
	}
	
	private class Lytter implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			/*
			if (e.getSource() == personer)
				Personvindu p = new Personvindu(bs);
			else if (e.getSource() == nyperson)
				Nypersonvindu np = new Nypersonvindu(bs);
			else if (e.getSource() == boliger)
				Boligvindu b = new Boligvindu(bs);
			else if (e.getSource() == nybolig)
				Nyboligvindu nb = new Nyboligvindu(bs);
			else if (e.getSource() == kontrakter)
				Kontraktvindu k = new Kontraktvindu(bs);
			*/
		}
	}
}
