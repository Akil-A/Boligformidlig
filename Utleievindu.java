
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;


public class Utleievindu extends JFrame
{
	private JList<Boligsoker> bList;
	private Lytter lytter;
	private JButton leiut, avbryt;
	private Boligregister register;
	private Resultatbolk resultatbolken;
	private DefaultListModel<Boligsoker> bModel;
	private JTextField startDato, sluttDato;
	private JLabel lstartDato, lsluttDato,ldato;
	private Bolig boligen;
	private Font IKKEFET = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
	
	private String tilStandardDatostreng(Calendar c)
	{
		return c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR);
	}
	    
	public Utleievindu(Boligregister br, Bolig blg, Resultatbolk rb)
	{
		super("Utleie");
		setSize(600,400);
		register = br;
		resultatbolken = rb;
		boligen = blg;
		 /********* DEFINERING AV KOMPONENTER START *********/
        lytter = new Lytter();
        leiut = new JButton("Lei ut");
        leiut.addActionListener(lytter);
        avbryt = new JButton("Avbryt");
        avbryt.addActionListener(lytter);
        lstartDato = new JLabel("Start dato: ");
        lsluttDato = new JLabel("Slutt dato: ");
        ldato = new JLabel("<html>Dato format: dd/MM/yyyy<br>eks: 21/06/2010</html>");
        startDato = new JTextField(9);
        startDato.setEditable(false);
        startDato.setText(tilStandardDatostreng(Calendar.getInstance()));
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
        
        
		/********* LAYOUT START *********/
		
        JScrollPane bScrollPane = new JScrollPane();
		bScrollPane.setBorder(BorderFactory.createTitledBorder("<html>BOLIGS&Oslash;KERE</html>"));
		bScrollPane.setViewportView(bList);
		bScrollPane.setPreferredSize(new Dimension(450, 200));   
		
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
		
		/********* LAYOUT SLUTT *********/
	}
	
	private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
            String feilmelding = "";

			if(e.getSource() == avbryt)
			{
    			dispose();
			}
			else if(e.getSource() == leiut)
			{
				if(bList.isSelectionEmpty())
				{
					feilmelding += "&bull; Du m&aring; velge en boligs&oslash;ker fra listen<br>";
					
				}
				
				if(sluttDato.getText().equals(""))
				{
					feilmelding += "&bull;Du m&aring; skrive inn en sluttdato<br>";
					
				}
					
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", java.util.Locale.getDefault());
			    
			    Date testSluttDato = null;
			    
			    Calendar sluttdato = Calendar.getInstance();
			    
			    try
			    {
			    	testSluttDato = sdf.parse(sluttDato.getText());
			    	
			    	sluttdato.setTime(testSluttDato);
			    }
			    catch(ParseException pe)
			    {
			    	feilmelding += "&bull; Datoformatet er feil<br>";
			    }
			    
			    
			    if( !sdf.format(testSluttDato).equals(sluttDato.getText()))			    
			    	feilmelding += "&bull; Datoformatet er feil<br>";

			    
			    
			    if(testSluttDato.before(new Date()))
					feilmelding += "&bull; Sluttdatoen kan ikke v&aelig;re f&oslash;r dagens dato!"; 
			    
			    if (!feilmelding.isEmpty())
                {
                        JOptionPane.showMessageDialog(null, "<html>" + feilmelding + "</html>", "Problem",
                                JOptionPane.PLAIN_MESSAGE);
                        return;
                }

				
				Kontrakt kontrakten = new Kontrakt(bList.getSelectedValue(), boligen, sluttdato);
				register.settInnKontrakt(kontrakten);
				JOptionPane.showMessageDialog(null,"<html>Registrering fullf&oslash;rt<br>Sluttdato: " + sluttdato.get(Calendar.DATE)+ "/"+ (sluttdato.get(Calendar.MONTH) + 1) + "/" + sluttdato.get(Calendar.YEAR) + "</html>");
				resultatbolken.oppdater();
				dispose();
			}
		}
	}
}


