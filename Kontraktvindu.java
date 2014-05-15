// Vindu som viser detaljer for enkelt kontrakt.
// Laget av Ali og Akil
// Sist oppdatert 15/5

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

@SuppressWarnings("serial")
public class Kontraktvindu extends JFrame
{
	private Bolig boligen;
	private Lytter lytter;
	private JButton siopp,avbryt,endre,lagre;
	private JTextField adresse, postnr, poststed,utleiepris,utleier,email,email1,telefon,telefon1,leietaker,startdato,sluttdato,
	oppsigelsesdato,oppsigelsesgrunn;
	private JLabel lAdresse,lPostNr,lPoststed,lUtleiepris,lUtleier,lLeietaker,lEmail,lEmail1,lTelefon,lTelefon1,lStartdato,lSluttdato,
	lOppsigelsesdato,lOppsigelsesgrunn;
	private JPanel pAdresse,pUtleiepris,pUtleier,pLeietaker,pDato,pKnapp,pOppsigelse;
	private Kontrakt gammelkontrakt;
	private Kontrakt kontrakten;
	private Boligregister registret;
	private Utleier utleieren;
	private Boligsoker boligsokeren;
	private Kontraktpanel kontraktpanelet;
	private Resultatbolk resultatbolken;
	
	public Kontraktvindu(Boligregister br, Resultatbolk rb, Kontrakt k)
	{
		super("Kontrakt");
		registret = br;
		resultatbolken = rb;
		kontrakten = k;
		gammelkontrakt = k;
		lagvindu();
	}
	
	public Kontraktvindu(Boligregister br, Kontraktpanel kp, Kontrakt k)
	{
		super("Kontrakt");
		registret = br;
		kontraktpanelet = kp;
		kontrakten = k;
		gammelkontrakt = k;
		lagvindu();
	}
	
	private String tilStandardDatostreng(Calendar c)
	{
		return c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR);
	}
	
	private void lagvindu()
	{
		setSize(950,450);
		
		lytter = new Lytter();
		boligen = kontrakten.getBolig();
		utleieren = boligen.getUtleier();
		boligsokeren = kontrakten.getLeietaker();
		
		/********* LAYOUT START *********/
        setLayout(new GridBagLayout());
		
		lAdresse = new JLabel("Adresse: ");
		lPostNr = new JLabel("PostNr: ");
		lPoststed = new JLabel("PostSted: ");
		lUtleiepris = new JLabel("Utleiepris(per mnd): ");
		lLeietaker = new JLabel("Leietaker: ");
		lUtleier = new JLabel("Utleier: ");
		lEmail = new JLabel("email: ");
		lEmail1 = new JLabel("email: ");
		lTelefon = new JLabel("Tlf: ");
		lTelefon1 = new JLabel("Tlf: ");
		lStartdato = new JLabel("Startdato: ");
		lSluttdato = new JLabel("Sluttdato: ");
		lOppsigelsesdato = new JLabel("Oppsigelses dato: ");
		oppsigelsesdato = new JTextField(10);
		lOppsigelsesgrunn = new JLabel("Oppsigelses grunn: ");
		oppsigelsesgrunn = new JTextField(30);
		
		adresse = new JTextField(20);
		adresse.setEditable(false);
		postnr = new JTextField(4);
		postnr.setEditable(false);
		poststed = new JTextField(10);
		poststed.setEditable(false);
		utleiepris = new JTextField(10);
		utleiepris.setEditable(false);
		utleier = new JTextField(20);
		utleier.setEditable(false);
		leietaker = new JTextField(20);
		leietaker.setEditable(false);
		email = new JTextField(20);
		email.setEditable(false);
		email1 = new JTextField(20);
		email1.setEditable(false);
		telefon = new JTextField(20);
		telefon.setEditable(false);
		telefon1 = new JTextField(20);
		telefon1.setEditable(false);
		startdato = new JTextField(20);
		String sStartdato = tilStandardDatostreng(kontrakten.getStartdato());
		startdato.setEditable(false);
		startdato.setText(sStartdato);
		startdato.setEditable(false);
		sluttdato = new JTextField(15);
		String sSluttdato = tilStandardDatostreng(kontrakten.getSluttdato());
		sluttdato.setText(sSluttdato);
		sluttdato.setEditable(false);
		
		siopp = new JButton("Si opp");
		siopp.addActionListener(lytter);
		avbryt= new JButton("Avbryt");
		avbryt.addActionListener(lytter);
		endre = new JButton("Endre Oppsigelsesdato");
		endre.addActionListener(lytter);
		endre.setVisible(false);
		lagre = new JButton("Lagre");
		lagre.addActionListener(lytter);
		lagre.setVisible(false);
		pOppsigelse = new JPanel();
		pOppsigelse.add(lOppsigelsesdato);
		pOppsigelse.add(oppsigelsesdato);
		pOppsigelse.add(lOppsigelsesgrunn);
		pOppsigelse.add(oppsigelsesgrunn);
		
		pKnapp = new JPanel();
		pKnapp.add(lagre);
		pKnapp.add(siopp);
		pKnapp.add(endre);
		pKnapp.add(avbryt);
		
        adresse.setText(boligen.getAdresse());
        postnr.setText(boligen.getPostnr());
        poststed.setText(boligen.getPoststed());
        utleiepris.setText(Integer.toString(boligen.getUtleiepris()));
        utleier.setText(utleieren.getFornavn() + " " + utleieren.getEtternavn());
        email.setText(utleieren.getEmail());
        telefon.setText(utleieren.getTelefon());
        leietaker.setText(boligsokeren.getFornavn() + " " + boligsokeren.getEtternavn());
        email1.setText(boligsokeren.getEmail());
        telefon1.setText(boligsokeren.getTelefon());
        
        pAdresse = new JPanel();
        pAdresse.add(lAdresse);
        pAdresse.add(adresse);
        pAdresse.add(lPostNr);
        pAdresse.add(postnr);
        pAdresse.add(lPoststed);
        pAdresse.add(poststed);
        
        pUtleiepris = new JPanel();
        pUtleiepris.add(lUtleiepris);
        pUtleiepris.add(utleiepris);
        
        pUtleier = new JPanel();
        pUtleier.add(lUtleier);
        pUtleier.add(utleier);
        pUtleier.add(lEmail);
        pUtleier.add(email);
        pUtleier.add(lTelefon);
        pUtleier.add(telefon);
        
        pLeietaker = new JPanel();
        pLeietaker.add(lLeietaker);
        pLeietaker.add(leietaker);
        pLeietaker.add(lEmail1);
        pLeietaker.add(email1);
        pLeietaker.add(lTelefon1);
        pLeietaker.add(telefon1);
        
        pDato = new JPanel();
        pDato.add(lStartdato);
        pDato.add(startdato);
        pDato.add(lSluttdato);
        pDato.add(sluttdato);    		
        
		GridBagConstraints gc = new GridBagConstraints();
		gc.anchor = GridBagConstraints.CENTER;
		
		gc.gridx = 0;
		gc.gridy = 0;
		
		gc.insets.left = 2;
		add(pAdresse, gc);
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridy = 1;
		add(pUtleiepris,gc);
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets.top = 10;
		gc.gridy = 2;
		add(pUtleier, gc);
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets.top = 10;
		gc.gridy = 3;
		add(pLeietaker, gc);
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets.top = 10;
		gc.gridy = 4;
		add(pDato, gc);
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets.top = 10;
		gc.gridy = 5;
		add(pOppsigelse, gc);
		
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets.top = 10;
		gc.gridy = 6;
		add(pKnapp, gc);
		/********* LAYOUT SLUTT *********/
		
	    if(kontrakten.getOppsigelsesdato() != null)
	    {
	    	DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	    	String oppsagtdato = f.format(kontrakten.getOppsigelsesdato().getTime());
	    	oppsigelsesdato.setText(oppsagtdato);
	    	oppsigelsesdato.setEditable(false);
	    	oppsigelsesgrunn.setText(kontrakten.getOppsigelsesgrunn());
	    	oppsigelsesgrunn.setEditable(false);
	    	siopp.setVisible(false);
	    	endre.setVisible(true);
	    }
	    
	    if(kontrakten.getSluttdato().getTime().before(new Date()) ||
	    		(kontrakten.getOppsigelsesdato() != null && kontrakten.getOppsigelsesdato().getTime().before(new Date())))
		{
			oppsigelsesdato.setEditable(false);
			oppsigelsesgrunn.setEditable(false);
			siopp.setVisible(false);
	    	endre.setVisible(false);
		}
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private class Lytter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    
		    Date testOppsigelsesdato = null;
		    
			if(e.getSource() == siopp || e.getSource() == lagre)
			{
				if (oppsigelsesgrunn.getText().isEmpty())
				{
			    	JOptionPane.showMessageDialog(null, "Du maa skrive en oppsigelsesgrunn.");
			    	return;
				}
				
			    try
		        {
		    		testOppsigelsesdato = sdf.parse(oppsigelsesdato.getText());
		        }
			    catch(ParseException pe)
			    {
			    	JOptionPane.showMessageDialog(null, "Feil i datoformat!");
			    	return;
			    }
			    
			    if( !sdf.format(testOppsigelsesdato).equals(oppsigelsesdato.getText()))
			    {
			    	JOptionPane.showMessageDialog(null, "Feil i datoformat!");
			    	return;
			    }
			    
			    Calendar oppsigelsesdato = Calendar.getInstance();
			    oppsigelsesdato.setTime(testOppsigelsesdato);
			    kontrakten.setOppsigelsesdato(oppsigelsesdato);
				kontrakten.setOppsigelsesgrunn(oppsigelsesgrunn.getText());
				
				String melding = "";
				
				if (e.getSource() == siopp)
					melding = "Kontrakten er sagt opp!";
				else
					melding = "Oppsigelsesdetaljer er endret!";
				
				JOptionPane.showMessageDialog(null,melding);
				
				registret.oppdaterKontrakt(gammelkontrakt, kontrakten);
				
				if (resultatbolken != null)
					resultatbolken.oppdater();
				
				if (kontraktpanelet != null)
					kontraktpanelet.utforsok();
				
				dispose();
			}
			else if(e.getSource() == endre)
			{
				oppsigelsesdato.setEditable(true);
				oppsigelsesgrunn.setEditable(true);
				endre.setVisible(false);
				siopp.setVisible(false);
				lagre.setVisible(true);			
			}
			else if(e.getSource() == avbryt)
			{
				dispose();
			}
		}
	}
}
