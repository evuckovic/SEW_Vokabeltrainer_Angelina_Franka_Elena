package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

// Panel für das Memory-Spiel
public class MemoryPanel extends JPanel {

    private MainFrame mainFrame;

    // Liste mit allen Kartenbegriffen
    private ArrayList<String> kartenListe;

    // Buttons für die Karten
    private JButton[] buttons;

    // Speichert die ersten beiden Klicks
    private int ersterIndex = -1;
    private int zweiterIndex = -1;

    public MemoryPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Memory-Spiel");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        add(title, BorderLayout.NORTH);

        // =============================
        // Karten vorbereiten
        // =============================

        kartenListe = new ArrayList<String>();

        // 6 Paare (Deutsch - Englisch)
        kartenListe.add("Haus");
        kartenListe.add("house");

        kartenListe.add("Baum");
        kartenListe.add("tree");

        kartenListe.add("Hund");
        kartenListe.add("dog");

        kartenListe.add("Katze");
        kartenListe.add("cat");

        kartenListe.add("Buch");
        kartenListe.add("book");

        kartenListe.add("Wasser");
        kartenListe.add("water");

        // Karten mischen
        Collections.shuffle(kartenListe);

        // =============================
        // Spielfeld
        // =============================

        JPanel spielfeld = new JPanel();
        spielfeld.setLayout(new GridLayout(3, 4, 10, 10));

        buttons = new JButton[12];

        for (int i = 0; i < 12; i++) {

            buttons[i] = new JButton("?");
            buttons[i].setFont(new Font("Arial", Font.BOLD, 16));

            final int index = i;

            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    karteKlicken(index);
                }
            });

            spielfeld.add(buttons[i]);
        }

        add(spielfeld, BorderLayout.CENTER);
    }

    // =============================
    // Methode wenn eine Karte geklickt wird
    // =============================

    private void karteKlicken(int index) {

        // Wenn Karte schon sichtbar ist → nichts machen
        if (!buttons[index].getText().equals("?")) {
            return;
        }

        // Wort anzeigen
        buttons[index].setText(kartenListe.get(index));

        // Ersten Klick speichern
        if (ersterIndex == -1) {
            ersterIndex = index;
        }
        // Zweiten Klick speichern
        else if (zweiterIndex == -1) {
            zweiterIndex = index;

            // Vergleich starten
            vergleichen();
        }
    }

    // =============================
    // Vergleich der zwei Karten
    // =============================

    private void vergleichen() {

        String wort1 = kartenListe.get(ersterIndex);
        String wort2 = kartenListe.get(zweiterIndex);

        // Prüfen ob Paar zusammenpasst
        if (istPaar(wort1, wort2)) {

            // Karten deaktivieren
            buttons[ersterIndex].setEnabled(false);
            buttons[zweiterIndex].setEnabled(false);

            // Zurücksetzen
            ersterIndex = -1;
            zweiterIndex = -1;

            // Prüfen ob Spiel fertig
            pruefeSpielEnde();
        }
        else {

            // Kleine Pause simulieren mit Dialog
            JOptionPane.showMessageDialog(null, "Falsch!");

            // Karten wieder verdecken
            buttons[ersterIndex].setText("?");
            buttons[zweiterIndex].setText("?");

            ersterIndex = -1;
            zweiterIndex = -1;
        }
    }

    // =============================
    // Prüfen ob Wörter ein Paar sind
    // =============================

    private boolean istPaar(String w1, String w2) {

        if ((w1.equals("Haus") && w2.equals("house")) ||
                (w1.equals("house") && w2.equals("Haus"))) return true;

        if ((w1.equals("Baum") && w2.equals("tree")) ||
                (w1.equals("tree") && w2.equals("Baum"))) return true;

        if ((w1.equals("Hund") && w2.equals("dog")) ||
                (w1.equals("dog") && w2.equals("Hund"))) return true;

        if ((w1.equals("Katze") && w2.equals("cat")) ||
                (w1.equals("cat") && w2.equals("Katze"))) return true;

        if ((w1.equals("Buch") && w2.equals("book")) ||
                (w1.equals("book") && w2.equals("Buch"))) return true;

        if ((w1.equals("Wasser") && w2.equals("water")) ||
                (w1.equals("water") && w2.equals("Wasser"))) return true;

        return false;
    }

    // =============================
    // Prüfen ob alle Karten gefunden wurden
    // =============================

    private void pruefeSpielEnde() {

        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].isEnabled()) {
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Gratuliere! Alle Paare gefunden!");

        mainFrame.showPanel("START");
    }
}
