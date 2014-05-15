// Vinduskomponent med opplisting av kontrakter.
// Laget av Ali, Akil og Joakim
// Sist oppdatert 10/5

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import javax.swing.*;


@SuppressWarnings("serial")
public class Kontraktpanel extends JPanel
{
    private ArrayList<Kontrakt> kontraktliste;
    private JLabel lBunntekst;
    private JButton detaljer;
    private JComboBox<String> sortering;
    private JList<Kontrakt> kontraktJliste;
    private DefaultListModel<Kontrakt> listemodell;
    private JCheckBox visFungerende, visUtgaatte;
    private Boligregister register;

    public Kontraktpanel(Boligregister br)
    {
        register = br;
        Lytter lytter = new Lytter();

        detaljer = new JButton("Detaljer");
        detaljer.addActionListener(lytter);

        lBunntekst = new JLabel();
        Font IKKEFET = new Font(Font.SANS_SERIF, Font.PLAIN, 12);
        lBunntekst.setFont(IKKEFET);

        /********* LAYOUT START *********/
        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.NORTHWEST;

        gc.gridx = 0;
        gc.gridy = 0;

        visFungerende = new JCheckBox("Vis fungerende");
        visFungerende.addActionListener(lytter);
        visFungerende.setFont(IKKEFET);
        visFungerende.setSelected(true);
        visUtgaatte = new JCheckBox("<html>Vis utg&aring;tte</html>");
        visUtgaatte.addActionListener(lytter);
        visUtgaatte.setFont(IKKEFET);

        JPanel toppanel = new JPanel(new GridBagLayout());
        toppanel.add(visFungerende);
        toppanel.add(visUtgaatte);

        String [] combovalg = { "<html>Dato inng&aring;tt</html>", "<html>Dato utg&aring;r/tt</html>", "Adresse" };
        sortering = new JComboBox<>(combovalg);
        sortering.addActionListener(lytter);
        sortering.setFont(IKKEFET);

        JLabel lSortering = new JLabel("           Sortering: ");
        lSortering.setFont(IKKEFET);
        toppanel.add(lSortering);
        toppanel.add(sortering);

        gc.fill = GridBagConstraints.HORIZONTAL;
        add(toppanel, gc);
        gc.fill = GridBagConstraints.NONE;

        gc.gridy = 1;

        /********* POPULERING AV LISTE START *********/
        listemodell = new DefaultListModel<>();
        kontraktJliste = new JList<>(listemodell);
        kontraktJliste.setFont(IKKEFET);
        kontraktJliste.setCellRenderer(new listeCellRenderer());
        kontraktliste = new ArrayList<>();
        utforsok();
        /********* POPULERING AV LISTE SLUTT *********/

        JScrollPane bScrollPane = new JScrollPane();
        bScrollPane.setViewportView(kontraktJliste);
        bScrollPane.setPreferredSize(new Dimension(500, 400));
        add(bScrollPane, gc);

        gc.gridx = 1;
        gc.insets.left = 10;
        add(detaljer, gc);
        gc.insets.left = 0;

        gc.gridx = 0;
        gc.gridy = 2;

        JPanel bunnpanel = new JPanel(new GridBagLayout());
        bunnpanel.add(lBunntekst);

        add(bunnpanel, gc);
        /********* LAYOUT SLUTT *********/
    }

    public void utforsok()
    {
        lagliste();
        oppdater();
    }

    public void oppdater()
    {
        listemodell.clear();

        Iterator<Kontrakt> iterator = kontraktliste.iterator();

        while(iterator.hasNext())
            listemodell.addElement(iterator.next());

        String bunntekst = "<html>Antall kontrakter totalt: " + register.getKontrakter().size() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "Fungerende: " + register.getFungerende().size() + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "Utg&aring;tte: " + register.getUtgaatte().size() + "</html>";

        lBunntekst.setText(bunntekst);
    }

    public void lagliste()
    {
        boolean bFungerende = visFungerende.isSelected();
        boolean bUtgtte = visUtgaatte.isSelected();

        kontraktliste.clear();

        if (bFungerende && !bUtgtte)
            kontraktliste.addAll(register.getFungerende());
        else if (!bFungerende && bUtgtte)
            kontraktliste.addAll(register.getUtgaatte());
        else
            kontraktliste.addAll(register.getKontrakter());

        switch (sortering.getSelectedIndex())
        {
            case 0:
                Collections.sort(kontraktliste, new Comparator<Kontrakt>() {
                    public int compare(Kontrakt k1, Kontrakt k2) {
                        return k2.getStartdato().compareTo(k1.getStartdato());
                    }
                });
                break;
            case 1:
                Collections.sort(kontraktliste, new Comparator<Kontrakt>() {
                    public int compare(Kontrakt k1, Kontrakt k2) {
                        Calendar k1dato;
                        Calendar k2dato;

                        if (k1.getOppsigelsesdato() == null)
                            k1dato = k1.getSluttdato();
                        else
                            k1dato = k1.getOppsigelsesdato();

                        if (k2.getOppsigelsesdato() == null)
                            k2dato = k2.getSluttdato();
                        else
                            k2dato = k2.getOppsigelsesdato();

                        return k2dato.compareTo(k1dato);

                    }
                });
                break;
            case 2:
                Collections.sort(kontraktliste, new Comparator<Kontrakt>() {
                    public int compare(Kontrakt k2, Kontrakt k1) {
                        return k2.getBolig().getAdresse().compareTo(k1.getBolig().getAdresse());
                    }
                });
                break;
        }
    }

    private class Lytter implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == detaljer && kontraktJliste.getSelectedIndex() != -1)
                new Kontraktvindu(register, Kontraktpanel.this, kontraktJliste.getSelectedValue());
            else if (e.getSource() == visFungerende || e.getSource() == visUtgaatte || e.getSource() == sortering)
                utforsok();
        }
    }

    private String tilStandardDatostreng(Calendar c)
    {
        return c.get(Calendar.DATE) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.YEAR);
    }

    private class listeCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList<?> fungerendeListe,
                                                      Object value,
                                                      int index,
                                                      boolean isSelected,
                                                      boolean cellHasFocus)
        {
            super.getListCellRendererComponent(fungerendeListe, value, index, isSelected, cellHasFocus);

            if (value instanceof Kontrakt)
            {
                Kontrakt kontrakten = (Kontrakt)value;

                String teksten = "<html>" + kontrakten.getBolig().getAdresse() +
                        "&nbsp;&nbsp;&nbsp;Fra: " + tilStandardDatostreng(kontrakten.getStartdato()) +
                        "&nbsp;&nbsp;&nbsp;Til: ";

                if (kontrakten.getOppsigelsesdato() != null)
                    teksten += tilStandardDatostreng(kontrakten.getOppsigelsesdato()) + " &ndash; OPPSAGT";
                else
                    teksten += tilStandardDatostreng(kontrakten.getSluttdato());

                if (!kontrakten.getFungerer())
                    teksten += " &ndash; UTG&Aring;TT";

                teksten += "</html>";

                setText(teksten);
            }

            return this;
        }
    }
}
