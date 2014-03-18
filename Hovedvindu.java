import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Hovedvindu extends JFrame
{
	private JButton personer, nyperson, boliger, nybolig, kontrakter;
	private Lytter lytter;
	public Boligsystem bs;
	
	public Hovedvindu()
	{
		super("Boligformidling");
		
		// må hentes fra fil
		bs = new Boligsystem();
		
		personer = new JButton("Personer");
		personer.addActionListener(lytter);
		
		nyperson = new JButton("Ny");
		nyperson.addActionListener(lytter);
		
		boliger = new JButton("Boliger");
		boliger.addActionListener(lytter);
		
		nybolig = new JButton("Ny");
		nybolig.addActionListener(lytter);
		
		kontrakter = new JButton("Kontrakter");
		kontrakter.addActionListener(lytter);
		
	}
	
	private class Lytter implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
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
		}
	}
}
