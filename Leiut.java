
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;


public class Leiut extends JFrame
{
	private JList<Boligsoker> bList;
	private Lytter lytter;
	private JButton leiut, avbryt;
	private Boligregister register;
	private DefaultListModel<Boligsoker> bModel;
	private JTextField startDato, sluttDato;
	private JLabel lstartDato, lsluttDato,ldato;
	private int boligNr;
	private Font IKKEFET = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
	    
	public Leiut(Boligregister br, int bnr)
	{
		super("Utleie");
		setSize(600,400);
		register = br;
		boligNr = bnr;
		 /********* DEFINERING AV KOMPONENTER START *********/
        lytter = new Lytter();
        leiut = new JButton("Lei ut");
        leiut.addActionListener(lytter);
        avbryt = new JButton("Avbryt");
        avbryt.addActionListener(lytter);
        lstartDato = new JLabel("Start dato: ");
        lsluttDato = new JLabel("Slutt dato: ");
        ldato = new JLabel("<html>Dato format: dd/MM/yyyy<br>eks: 21/12/2010</html>");
        startDato = new JTextField(9);
        sluttDato = new JTextField(9);
       
        /********* DEFINERING AV KOMPONENTER SLUTT *********/
        
        /********* POPULERING AV LISTER START *********/
        ArrayList<Boligsoker> boligsokere = register.getBoligsokere();
        bModel = new DefaultListModel<Boligsoker>();
        Iterator<Boligsoker> iterator2 = boligsokere.iterator();
        while(iterator2.hasNext())
            bModel.addElement(iterator2.next());
        bList = new JList<>(bModel);
        bList.setFont(IKKEFET);
        /********* POPULERING AV LISTER SLUTT *********/
        
        JScrollPane bScrollPane = new JScrollPane();
		bScrollPane.setBorder(BorderFactory.createTitledBorder("<html>BOLIGS&Oslash;KERE</html>"));
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
					JOptionPane.showMessageDialog(null,"<html>Du m&aring; velge en fra listen!</html>");
					return;
				}
				
				if(startDato.getText().equals("") || sluttDato.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"<html>Du m&aring; skrive inn en start og slutt dato!</html>");
					return;
				}
					
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
					JOptionPane.showMessageDialog(null,"<html>Startdatoen m&aring; v&aelig;re f&oslash;r sluttdatoen!</html>");
					return;
				}
				
				Kontrakt kontrakten = new Kontrakt(bList.getSelectedValue(), boligNr, testStartDato, testSluttDato);
				register.settInnKontrakt(kontrakten);
				JOptionPane.showMessageDialog(null,"<html>Test fullf&oslash;rt<br>startdato:" + testStartDato + "<br>sluttdato:" + testSluttDato + "</html>");
				dispose();
			}
		}
	}
}
