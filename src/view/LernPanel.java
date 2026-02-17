package view;

import javax.swing.*;
import java.awt.*;

public class LernPanel extends JPanel {

    private MainFrame mainFrame;

    private JLabel karteLabel;
    private JButton umdrehenButton;
    private JButton weiterButton;
    private JButton zurueckButton;

    private String aktuellesSet;
    private int index;
    private boolean deutschSeite; // merkt sich welche Seite angezeigt wird
    private final int MAX_KARTEN = 10; // maximale Karten pro Set

    public LernPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        // Karteikarte
        karteLabel = new JLabel("");
        karteLabel.setHorizontalAlignment(JLabel.CENTER);
        karteLabel.setFont(new Font("Arial", Font.BOLD, 26));

        // Buttons
        umdrehenButton = new JButton("Umdrehen");
        weiterButton = new JButton("Nächste Karte");
        zurueckButton = new JButton("Zurück zur Startseite");

        // Panel für Buttons
        JPanel unten = new JPanel();
        unten.add(umdrehenButton);
        unten.add(weiterButton);
        unten.add(zurueckButton);

        add(karteLabel, BorderLayout.CENTER);
        add(unten, BorderLayout.SOUTH);

        // Button Aktionen
        umdrehenButton.addActionListener(e -> umdrehen());
        weiterButton.addActionListener(e -> naechsteKarte());
        zurueckButton.addActionListener(e -> mainFrame.showPanel("START")); // Zur Startseite
    }

    // Wird vom MainFrame aufgerufen
    public void starteLernen(String setName) {
        this.aktuellesSet = setName;
        this.index = 0;
        this.deutschSeite = true;

        zeigeKarte();
    }

    private void zeigeKarte() {
        String wort;
        if (deutschSeite) {
            wort = mainFrame.getController().getDeutsch(aktuellesSet, index);
        } else {
            wort = mainFrame.getController().getEnglisch(aktuellesSet, index);
        }

        // Prüfen, ob Karte existiert
        if (wort.equals("Karte an diesem Index nicht gefunden") || wort.equals("Set nicht gefunden")) {
            // Automatisch zurück zur Startseite
            mainFrame.showPanel("START");
        } else {
            karteLabel.setText(wort);
        }
    }

    private void umdrehen() {
        deutschSeite = !deutschSeite;
        zeigeKarte();
    }

    private void naechsteKarte() {
        index++;
        deutschSeite = true;
        zeigeKarte();
    }
}
