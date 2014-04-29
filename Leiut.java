
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.swing.*;


public class Leiut extends JFrame
{
	 private JList<Person> bList;
	    private JList<Person> uList;
	    private Lytter lytter;
	    private JButton leiut, avbryt;
	    private Boligregister register;
	    private DefaultListModel<Person> uModel, bModel;
	    private ArrayList<Boligsoker>boligsokerliste;
	    private JTextField startDato, sluttDato;
	    private JLabel lstartDato, lsluttDato,ldato;
	    private int boligNr;
	    private Date dStartDato, dSluttDato;
	    
	public Leiut(Boligregister br, int boligNr)
	{
		super("Utleie Vindu");
		setSize(600,400);
		register = br;
		this.boligNr = boligNr;
		 /********* DEFINERING AV KOMPONENTER START *********/
        lytter = new Lytter();
        leiut = new JButton("Lei ut");
        leiut.addActionListener(lytter);
        avbryt = new JButton("Avbryt");
        avbryt.addActionListener(lytter);
        lstartDato = new JLabel("Start dato: ");
        lsluttDato = new JLabel("Slutt dato: ");
        ldato = new JLabel("<html>Dato format: dd/MM/yyyy <br> eks: 21/12/2010</html>");
        startDato = new JTextField(9);
        sluttDato = new JTextField(9);
       
        /********* DEFINERING AV KOMPONENTER SLUTT *********/
        
        /********* POPULERING AV LISTER START *********/
        boligsokerliste = register.getBoligsokere();
        bModel = new DefaultListModel<Person>();
        Iterator<Boligsoker> iterator2 = boligsokerliste.iterator();
        while(iterator2.hasNext())
        {
            bModel.addElement(iterator2.next());
        }
        bList = new JList<Person>(bModel);
        /********* POPULERING AV LISTER SLUTT *********/
        
        JScrollPane bScrollPane = new JScrollPane();
		bScrollPane.setBorder(BorderFactory.createTitledBorder("Boligsokere:"));
		bScrollPane.setViewportView(bList);
		bScrollPane.setPreferredSize(new Dimension(450, 200));   
		 /********* LAYOUT START *********/
		
		
		
        setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.NORTHWEST;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		gc.insets.left = 2;
		add(bScrollPane, gc);
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridy = 1;
		add(ldato,gc);
		JPanel pDato = new JPanel();
		pDato.add(lstartDato);
		pDato.add(startDato);
		
		pDato.add(lsluttDato);
		pDato.add(sluttDato);
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridy = 2;
		add(pDato,gc);
		
		JPanel knappepanel = new JPanel();
		knappepanel.add(leiut);
		knappepanel.add(avbryt);
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets.top = 10;
		gc.gridy = 3;
		add(knappepanel, gc);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	

	
	private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			
		
			if(e.getSource() == avbryt)
			{
    			dispose();
			}
			else if(e.getSource() == leiut)
			{
				if(bList.isSelectionEmpty())
				{
					JOptionPane.showMessageDialog(null,"Du maa velge en fra listen!");
					return;
				}
				if(startDato.getText().equals("") || sluttDato.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Du maa skrive inn en start og slutt dato!");
					return;
				}
				
				else
				{		
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				    
				    Date testStartDato = null;
				    Date testSluttDato = null;
				    
				    try
				        {
				    
				    	testStartDato = sdf.parse(startDato.getText());
				    	testSluttDato = sdf.parse(sluttDato.getText());
				
				        }
				    catch(ParseException pe)
				    {
				    	JOptionPane.showMessageDialog(null, "Feil i parsing");
				    	return;
				    }
				    
				    if( !sdf.format(testStartDato).equals(startDato.getText()) || !sdf.format(testSluttDato).equals(sluttDato.getText()))
				    {
				    	JOptionPane.showMessageDialog(null, "Feil i format");
				    	return;
				    }
				    
				    if(testSluttDato.before(testStartDato) || testSluttDato.equals(testStartDato))
					{	
						
						JOptionPane.showMessageDialog(null,"Startdatoen maa vaere for sluttdatoen!");
						return;
					}
					
					
					
					
					Kontrakt kontrakten = new Kontrakt(bList.getSelectedValue().getPersonNr(), boligNr, dStartDato, dSluttDato);
					register.settInnKontrakt(kontrakten);
					JOptionPane.showMessageDialog(null,"Test fullført\nstartdato:" + testStartDato + "\nsluttdato:" + testSluttDato);
				}
			}
				
				
			
		}
	}
}
