package view;
import javax.swing.*;          // Swing-Komponenten
import java.awt.*;             // Layouts (GridLayout, Font, Color)
import java.awt.event.*;

// Diese Klasse stellt die Startseite dar
public class StartseitePanel extends JPanel {

    // Referenz auf das Hauptfenster, um Seiten wechseln zu können
    private MainFrame mainFrame;

    // Konstruktor der Startseite
    public StartseitePanel(MainFrame mainFr) {

        // Speichern des MainFrames
        mainFrame = mainFr;

        // BorderLayout verwenden:
        // Oben = Überschrift
        // Mitte = Grid mit 3 Spalten
        setLayout(new BorderLayout());

        // =============================
        // Überschrift erstellen
        // =============================
        JLabel titleLabel = new JLabel("Startseite");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        add(titleLabel, BorderLayout.NORTH);

        // =============================
        // Mittlerer Bereich mit 3 Spalten
        // =============================
        JPanel centerPanel = new JPanel();

        // 1 Zeile, 3 Spalten
        centerPanel.setLayout(new GridLayout(1, 3, 20, 20));

        // Linke Spalte (leer für Abstand)
        centerPanel.add(new JPanel());

        // Mittlere Spalte mit Buttons
        centerPanel.add(createButtonPanel());

        // Rechte Spalte (leer für Abstand)
        centerPanel.add(new JPanel());

        add(centerPanel, BorderLayout.CENTER);
    }

    // Erstellt das Panel mit den drei Buttons
    private JPanel createButtonPanel() {

        JPanel panel = new JPanel();

        // Buttons untereinander anordnen
        panel.setLayout(new GridLayout(3, 1, 10, 10));

        // Button für Lernmodus
        JButton lernenButton = new JButton("Lernen");

        // Button für Testmodus
        JButton testenButton = new JButton("Testen");

        // Button für Spielmodus
        JButton spielenButton = new JButton("Spielen");

        // =============================
        // Aktionen bei Button-Klick
        // =============================

        lernenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Wechsel zur Lern-Übersicht
                mainFrame.showPanel("LERNEN");
            }
        });

        testenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Wechsel zur Test-Seite
                mainFrame.showPanel("TEST");
            }
        });

        spielenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Wechsel zur Spiel-Seite
                mainFrame.showPanel("SPIEL");
            }
        });

        // Buttons zum Panel hinzufügen
        panel.add(lernenButton);
        panel.add(testenButton);
        panel.add(spielenButton);

        return panel;
    }
}
