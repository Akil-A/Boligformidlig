// Vindusklasse hvor man leier ut boligen til en person.

import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

import javax.swing.*;


public class Utleievindu extends JFrame
{
	private JList<Boligsoker> bList;
	private Lytter lytter;
	private JButton ny, detaljer, leiut, avbryt;
	private Boligregister register;
	private Resultatbolk resultatbolken;
	private DefaultListModel<Boligsoker> bModel;
	private JTextField startDato, sluttDato;
	private JLabel lstartDato, lsluttDato,ldato;
	private Bolig boligen;
	private Font IKKEFET = new Font(Font.SANS_SERIF, Font.PLAIN, 12);

	// formaterer input til streng på formen dd/MM/yyyy
	private String tilStandardDatostreng(Calendar c)
	{
		return c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR);
	}
	
	// PARAMETRE FOR KONSTRUKTØR:
	// ==========================
	// Boligergister br = registerklassen
	// Bolig blg = boligen som skal leies ut
	// Resultatbolk rb = resultatbolken i søkelista som man har klikket på for å åpne vinduet
	public Utleievindu(Boligregister br, Bolig blg, Resultatbolk rb)
	{
		super("Utleie");
		setSize(700,400);
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
        bModel = new DefaultListModel<Boligsoker>();
        bList = new JList<>(bModel);
        bList.setFont(IKKEFET);
        oppdaterJliste();
        /********* POPULERING AV LISTER SLUTT *********/
        
        
		/********* LAYOUT START *********/
		
        JScrollPane bScrollPane = new JScrollPane();
		bScrollPane.setBorder(BorderFactory.createTitledBorder("<html>BOLIGS&Oslash;KERE</html>"));
		bScrollPane.setViewportView(bList);
		bScrollPane.setPreferredSize(new Dimension(450, 200));   
		
		
		JPanel sokere = new JPanel(new BorderLayout());
		sokere.add(bScrollPane, BorderLayout.CENTER);
		JPanel sokerknapper = new JPanel(new BorderLayout());
		JPanel innerknappepanel = new JPanel(new GridBagLayout());
		GridBagConstraints gc666 = new GridBagConstraints();
		gc666.fill = GridBagConstraints.HORIZONTAL;
		gc666.gridy = 0;
		gc666.insets.bottom = 5;
		gc666.insets.left = 2;
		ny = new JButton("Ny...");
		ny.addActionListener(lytter);
		ny.setPreferredSize(new Dimension(ny.getWidth(), 18));
		detaljer = new JButton("Detaljer");
		detaljer.addActionListener(lytter);
		innerknappepanel.add(ny, gc666);
		gc666.gridy = 1;
		innerknappepanel.add(detaljer, gc666);
		sokerknapper.add(innerknappepanel, BorderLayout.NORTH);
		sokere.add(sokerknapper, BorderLayout.EAST);
		
        setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.NORTHWEST;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		gc.insets.left = 2;
		add(sokere, gc);
		
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
	
	// metode for å oppdatere lista over boligsøkere
	public void oppdaterJliste()
    {
		bModel.clear();
    	
    	Iterator<Boligsoker> iterator = register.getBoligsokere().iterator();
    	
        while(iterator.hasNext())
        	bModel.addElement(iterator.next());
    }
	
	// lytterklasse for alt som er klikkbart
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
					JOptionPane.showMessageDialog(null,"<html>Du m&aring; velge en boligs&oslash;ker fra listen!</html>");
					return;
				}
				
				if(sluttDato.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"<html>Du m&aring; skrive inn en sluttdato!</html>");
					return;
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
			    	JOptionPane.showMessageDialog(null, "Datoformatet er feil");
			    	return;
			    }
			    
			    if( !sdf.format(testSluttDato).equals(sluttDato.getText()))
			    {
			    	JOptionPane.showMessageDialog(null, "Datoformatet er feil");
			    	return;
			    }
			    
			    if(testSluttDato.before(new Date()))
			    {
					JOptionPane.showMessageDialog(null,"<html>Sluttdatoen m&aring; v&aelig;re etter dagens dato.</html>"); 
					return;
			    }
				
				Kontrakt kontrakten = new Kontrakt(bList.getSelectedValue(), boligen, sluttdato);
				register.settInnKontrakt(kontrakten);
				JOptionPane.showMessageDialog(null,"<html>Registrering fullf&oslash;rt</html>");
				resultatbolken.oppdater();
				dispose();
			}
			else if (e.getSource() == ny)
				new Personskjemavindu(register, Utleievindu.this);
			else if (e.getSource() == detaljer && bList.getSelectedIndex() != -1)
				new Personskjemavindu(register, Utleievindu.this, bList.getSelectedValue());
				
		}
	}
}


