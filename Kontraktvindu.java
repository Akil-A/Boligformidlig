import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class Kontraktvindu extends JFrame
{
	
		private Kontraktpanel kontraktpanelet;
		private Bolig boligen;
		private JTextField adresse, postnr, poststed,utleiepris,utleier,email,email1,telefon,telefon1,leietaker;
		private JLabel lAdresse,lPostNr,lPoststed,lUtleiepris,lUtleier,lLeietaker,lEmail,lEmail1,lTelefon,lTelefon1;
		private JPanel pAdresse,pUtleiepris,pUtleier,pLeietaker;
		private Kontrakt kontrakten;
		private Boligregister registret;
		private Utleier utleieren;
		private Boligsoker boligsokeren;
		public Kontraktvindu(Boligregister b, Kontrakt k,Kontraktpanel kp)
		{
			super("Kontraktvindu");
			setSize(800,600);
			 /********* LAYOUT START *********/
			
			registret = b;
			kontraktpanelet = kp;
			kontrakten = k;
			
			boligen = registret.finnBolig(kontrakten.getBoligNr());
			utleieren = (Utleier) registret.finnPerson(boligen.getUtleierId());
			boligsokeren = (Boligsoker) registret.finnPerson(kontrakten.getLeietakerNr());
			
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


			adresse = new JTextField();
			adresse.setEditable(false);
			postnr = new JTextField();
			postnr.setEditable(false);
			poststed = new JTextField();
			poststed.setEditable(false);
			utleiepris = new JTextField();
			utleiepris.setEditable(false);
			utleier = new JTextField();
			utleier.setEditable(false);
			leietaker = new JTextField();
			leietaker.setEditable(false);
			email = new JTextField();
			email.setEditable(false);
			email1 = new JTextField();
			email1.setEditable(false);
			telefon = new JTextField();
			telefon.setEditable(false);
			telefon1 = new JTextField();
			telefon1.setEditable(false);
	        setLayout(new GridBagLayout());
			
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
	        pLeietaker.add(telefon);
	        
	        

	        
	        
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
			gc.gridy = 2;
			add(pLeietaker, gc);
			setLocationRelativeTo(null);
			setVisible(true);
		}
		 /********* LAYOUT SLUTT *********/

		}