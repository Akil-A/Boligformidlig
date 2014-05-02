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
	private Kontrakt kontrakten;
	private Boligregister registret;
	private Utleier utleieren;
	private Boligsoker boligsokeren;
	private Kontraktpanel kontraktpanelet;
	
	public Kontraktvindu(Boligregister br, Kontraktpanel kp, Kontrakt k)
	{
		super("Kontrakt");
		setSize(750,450);

		registret = br;
		kontraktpanelet = kp;
		kontrakten = k;
		lytter = new Lytter();
		boligen = registret.finnBolig(kontrakten.getBoligNr());
		utleieren = (Utleier) registret.finnPerson(boligen.getUtleierId());
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
		lOppsigelsesdato = new JLabel("Oppsigelsesdato: ");
		oppsigelsesdato = new JTextField(10);
		lOppsigelsesgrunn = new JLabel("Oppsigelses grunn: ");
		oppsigelsesgrunn = new JTextField(30);
		
		adresse = new JTextField(10);
		adresse.setEditable(false);
		postnr = new JTextField(4);
		postnr.setEditable(false);
		poststed = new JTextField(10);
		poststed.setEditable(false);
		utleiepris = new JTextField(10);
		utleiepris.setEditable(false);
		utleier = new JTextField(10);
		utleier.setEditable(false);
		leietaker = new JTextField(10);
		leietaker.setEditable(false);
		email = new JTextField(10);
		email.setEditable(false);
		email1 = new JTextField(10);
		email1.setEditable(false);
		telefon = new JTextField(10);
		telefon.setEditable(false);
		telefon1 = new JTextField(10);
		telefon1.setEditable(false);
		startdato = new JTextField(15);
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");      
		String sStartdato = df.format(k.getStartdato());
		startdato.setEditable(false);
		startdato.setText(sStartdato);
		startdato.setEditable(false);
		sluttdato = new JTextField(15);
		String sSluttdato = df.format(k.getSluttdato());
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
        postnr.setText(Integer.toString(boligen.getPostnr()));
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
		
	    if(kontrakten.getOppsagtDato() != null)
	    {
	    	DateFormat f = new SimpleDateFormat("MM/dd/yyyy");
	    	String oppsagtdato = f.format(kontrakten.getOppsagtDato());
	    	oppsigelsesdato.setText(oppsagtdato);
	    	oppsigelsesdato.setEditable(false);
	    	oppsigelsesgrunn.setText(kontrakten.getOppsigelsesgrunn());
	    	oppsigelsesgrunn.setEditable(false);
	    	siopp.setVisible(false);
	    	endre.setVisible(true);
	    }
	    
	    if(kontrakten.getSluttdato().before(new Date()) ||
	    		(kontrakten.getOppsagtDato() != null && kontrakten.getOppsagtDato().before(new Date())))
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
		    Date testStartdato = null;
		    Date testSluttdato = null;
		    
			if(e.getSource() == siopp)
			{
			    try
		        {
		    
		    		testOppsigelsesdato = sdf.parse(oppsigelsesdato.getText());
		    		testStartdato = sdf.parse(startdato.getText());
		    		testSluttdato = sdf.parse(sluttdato.getText());
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
			    
			    if(testOppsigelsesdato.before(new Date()))
			    {
			    	JOptionPane.showMessageDialog(null, "<html>Oppsigelsedatoen kan ikke v&aelig;re f&oslash;r dagens dato!</html>");
			    }
			    
			    if(testOppsigelsesdato.before(testStartdato) || testOppsigelsesdato.after(testSluttdato) || testOppsigelsesdato.equals(testStartdato)
			    		|| testOppsigelsesdato.equals(testSluttdato))
				{	
					
					JOptionPane.showMessageDialog(null,"<html>Oppsigelsestiden m&aring; v&aelig;re mellom start og sluttdato, og ikke lik start eller sluttdato!</html>");
					return;
				}
				kontrakten.setOppsagtDato(testOppsigelsesdato);
				kontrakten.setOppsigelsesgrunn(oppsigelsesgrunn.getText());
				registret.oppdaterKontrakt(kontrakten.getKontraktNr(), kontrakten);
				kontraktpanelet.oppdaterFungerendeListe();
				kontraktpanelet.oppdaterUtgaattListe();
				JOptionPane.showMessageDialog(null,"Kontrakten er sagt opp!");
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
			else if(e.getSource() == lagre)
			{
				try
		        {
		    		testOppsigelsesdato = sdf.parse(oppsigelsesdato.getText());
		    		testStartdato = sdf.parse(startdato.getText());
		    		testSluttdato = sdf.parse(sluttdato.getText());
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
			    
			    if(testOppsigelsesdato.before(new Date()))
			    {
			    	JOptionPane.showMessageDialog(null, "<html>Oppsigelsedatoen kan ikke v&aelig;re f&oslash;r dagens dato!</html>");
			    	return;
			    }
			    
			    if(testOppsigelsesdato.before(testStartdato) || testOppsigelsesdato.after(testSluttdato) || testOppsigelsesdato.equals(testStartdato)
			    		|| testOppsigelsesdato.equals(testSluttdato))
				{	
					
					JOptionPane.showMessageDialog(null, "<html>Oppsigelsestiden m&aring; v&aelig;re mellom start og sluttdato, og ikke lik start eller sluttdato!</html>");
					return;
				}
			    
				kontrakten.setOppsagtDato(testOppsigelsesdato);
				kontrakten.setOppsigelsesgrunn(oppsigelsesgrunn.getText());
				registret.oppdaterKontrakt(kontrakten.getKontraktNr(), kontrakten);
				kontraktpanelet.oppdaterFungerendeListe();
				kontraktpanelet.oppdaterUtgaattListe();
				JOptionPane.showMessageDialog(null,"Oppsigelsesdetaljer er endret!");
				
				dispose();
			}
			else if(e.getSource() == avbryt)
			{
				dispose();
			}
		}
	}
}
