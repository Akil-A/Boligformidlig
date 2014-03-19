import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
public class Personvindu extends JFrame
{

	private JLabel felttekst1;
	private JLabel felttekst2;

	public Personvindu()
	{	
		super("Personvindu");
		
		felttekst1 = new JLabel("Utleiere");
		felttekst2 = new JLabel("Boligsokere");
		
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		
		c.add( felttekst1);
		c.add( felttekst2);
		
		setSize( 420, 800 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);   
	 }
}
