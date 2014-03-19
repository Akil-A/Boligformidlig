import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
	
public class Personvindu extends JFrame
{

	private JLabel felttekst1;
	private JLabel felttekst2;
	private JTextArea tekstomraade;
	private JButton knapp;


	public Personvindu()//Boligsystem bs sette inn i her
	{	
		super("Personvindu");
		
	    tekstomraade = new JTextArea();

		felttekst1 = new JLabel("Utleiere");
		felttekst2 = new JLabel("Boligsokere");
		
		Container c = getContentPane();
		c.setLayout( new FlowLayout() );
		
		c.add( felttekst1);
		c.add( felttekst2);
		c.add(tekstomraade);
		c.add(knapp);
		
		setSize( 420, 800 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);   
		
		Personliste personer = bs.getPersoner();

		list = new JList(personer.toArray());
		list.setVisibleRowcount(10);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list));
		list.addListSelectionListener( new ListSelectionListener()
		
				
		public void valueChanged( ListSelectionEvent e)
		{
	         if ( !e.getValueIsAdjusting() )
	         {
	        	 JList<Person> liste = (JList) e.getSource();
	        	 Person person = liste.getSelectedValue();
	        	 String info = person.toString();
	        	 tekstomraade.append(info);
	         }
		}
		
		   private class lytter implements ActionListener
		   {
		        public void actionPerformed( ActionEvent e )
		        {
		        	if(e.getsource() == knapp)
		        	{
		        		Personskjemavindu pv = new Personskjemavindu(liste.getSelectedValue().getPersonNr());
		        	}
		        }
		        
		   }
				 
	 }
}
