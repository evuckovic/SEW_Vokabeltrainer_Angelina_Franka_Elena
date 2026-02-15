package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Panel für den Testmodus
public class TestPanel extends JPanel {

    private MainFrame mainFrame;

    // Beispiel-Wörter (Deutsch → Englisch)
    private String[] deutsch = {"Haus", "Baum", "Auto", "Hund", "Katze",
            "Buch", "Tisch", "Stuhl", "Wasser", "Brot"};

    private String[] englisch = {"house", "tree", "car", "dog", "cat",
            "book", "table", "chair", "water", "bread"};

    private int aktuelleFrage = 0;   // Welche Frage gerade ist
    private int punkte = 0;          // Richtige Antworten zählen

    private JLabel wortLabel;        // Zeigt das Wort an
    private JTextField eingabeFeld;  // Textfeld für Antwort
    private JButton pruefenButton;

    public TestPanel(MainFrame mainFr) {

        mainFrame = mainFr;

        setLayout(new BorderLayout());

        // Überschrift
        JLabel title = new JLabel("Testmodus");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        add(title, BorderLayout.NORTH);

        // =============================
        // Wort-Anzeige (wie Karte)
        // =============================

        wortLabel = new JLabel(deutsch[aktuelleFrage]);
        wortLabel.setHorizontalAlignment(JLabel.CENTER);
        wortLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel wortPanel = new JPanel();
        wortPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        wortPanel.setLayout(new BorderLayout());
        wortPanel.add(wortLabel, BorderLayout.CENTER);

        // =============================
        // Eingabebereich
        // =============================

        eingabeFeld = new JTextField();
        pruefenButton = new JButton("Überprüfen");

        JPanel untenPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        untenPanel.add(eingabeFeld);
        untenPanel.add(pruefenButton);

        add(wortPanel, BorderLayout.CENTER);
        add(untenPanel, BorderLayout.SOUTH);

        // =============================
        // Button-Aktion
        // =============================

        pruefenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String eingabe = eingabeFeld.getText();

                // Vergleich (Groß-/Kleinschreibung ignorieren)
                if (eingabe.equalsIgnoreCase(englisch[aktuelleFrage])) {
                    punkte++;
                }

                aktuelleFrage++;
                eingabeFeld.setText("");

                // Wenn noch Fragen übrig sind
                if (aktuelleFrage < 10) {
                    wortLabel.setText(deutsch[aktuelleFrage]);
                }
                else {
                    // Test beendet
                    JOptionPane.showMessageDialog(null,
                            "Test beendet!\nPunkte: " + punkte + " von 10");

                    // Zurück zur Startseite
                    aktuelleFrage = 0;
                    punkte = 0;
                    wortLabel.setText(deutsch[aktuelleFrage]);

                    mainFrame.showPanel("START");
                }
            }
        });
    }
}
