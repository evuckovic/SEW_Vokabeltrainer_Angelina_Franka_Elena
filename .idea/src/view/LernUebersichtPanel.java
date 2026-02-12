package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Panel zur Auswahl von Karteikartensets
public class LernUebersichtPanel extends JPanel {

    private MainFrame mainFrame;

    public LernUebersichtPanel(MainFrame mainFr) {

        mainFrame = mainFr;

        // Layout: BorderLayout für einfache Struktur
        setLayout(new BorderLayout());

        // Überschrift
        JLabel title = new JLabel("Karteikartensets auswählen");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setHorizontalAlignment(JLabel.CENTER);

        // Panel für die vorhandenen Sets
        JPanel setPanel = new JPanel();
        setPanel.setLayout(new GridLayout(3, 1, 10, 10));

        // Beispiel-Sets (fix eingetragen)
        JButton set1 = new JButton("Englisch Vokabeln");
        JButton set2 = new JButton("Deutsch Grammatik");

        // Button zum neuen Set erstellen
        JButton neuesSetButton = new JButton("Neues Set erstellen");

        // Sets hinzufügen
        setPanel.add(set1);
        setPanel.add(set2);
        setPanel.add(neuesSetButton);

        add(title, BorderLayout.NORTH);
        add(setPanel, BorderLayout.CENTER);

        // Aktion: Set auswählen → zum Lernmodus
        set1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showPanel("LERNMODUS");
            }
        });

        set2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showPanel("LERNMODUS");
            }
        });

        // Aktion: Neues Set erstellen
        neuesSetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showPanel("SET_ERSTELLEN");
            }
        });
    }
}
