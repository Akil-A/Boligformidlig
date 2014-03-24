package prosjekttest;

import java.awt.*;

import javax.swing.*;

public class Personskjemavindu extends JFrame
{	
	private JTextField navnfelt;
	private JTextField adressefelt;
	private JTextField telefonfelt;
	private JButton boligknapp;
	private JButton slettknapp;
	private JButton registrerknapp;
	private JCheckBox utleier;
	private JCheckBox boligsoker;

	public Personskjemavindu()
	{
		super("Personskjemavindu");
		
		navnfelt = new JTextField(10);
		adressefelt = new JTextField(10);
		telefonfelt = new JTextField(10);

		boligknapp = new JButton("Se mine boliger");
		//addlistener
		slettknapp = new JButton("Slett");
		//addlisteer
		registrerknapp = new JButton("Registrer ny bolig paa meg");
		
		utleier = new JCheckBox("Utleier");
		boligsoker = new JCheckBox("Boligsoker");
		
		JPanel panel = new JPanel( new GridBagLayout() );
		
		GridBagConstraints gc = new GridBagConstraints();
	
	}
}
