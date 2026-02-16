package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LernPanel extends JPanel {

    private MainFrame mainFrame;

    private JLabel karteLabel;
    private JButton umdrehenButton;
    private JButton weiterButton;

    private String aktuellesSet;
    private int index;
    private boolean deutschSeite; // merkt sich welche Seite angezeigt wird

    public LernPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        karteLabel = new JLabel("");
        karteLabel.setHorizontalAlignment(JLabel.CENTER);
        karteLabel.setFont(new Font("Arial", Font.BOLD, 26));

        umdrehenButton = new JButton("Umdrehen");
        weiterButton = new JButton("Nächste Karte");

        JPanel unten = new JPanel();
        unten.add(umdrehenButton);
        unten.add(weiterButton);

        add(karteLabel, BorderLayout.CENTER);
        add(unten, BorderLayout.SOUTH);

        // Button Aktionen
        umdrehenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                umdrehen();
            }
        });

        weiterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                naechsteKarte();
            }
        });
    }

    // Wird vom MainFrame aufgerufen
    public void starteLernen(String setName) {

        this.aktuellesSet = setName;
        this.index = 0;
        this.deutschSeite = true;

        zeigeKarte();
    }

    private void zeigeKarte() {

        if (deutschSeite) {
            String deutsch = mainFrame.getController()
                    .getDeutsch(aktuellesSet, index);
            karteLabel.setText(deutsch);
        } else {
            // Englisch holen (über Controller erweitern falls nötig)
            String englisch = mainFrame.getController()
                    .getDeutsch(aktuellesSet, index);
            karteLabel.setText(englisch);
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
