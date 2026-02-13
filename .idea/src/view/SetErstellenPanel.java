package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Panel zum Erstellen eines neuen Karteikartensets
public class SetErstellenPanel extends JPanel {

    private MainFrame mainFrame;

    public SetErstellenPanel(MainFrame mainFr) {

        mainFrame = mainFr;

        setLayout(new BorderLayout());

        // Überschrift
        JLabel title = new JLabel("Neues Karteikartenset erstellen");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setHorizontalAlignment(JLabel.CENTER);

        // Eingabefeld für Set-Name
        JTextField setNameField = new JTextField();

        JPanel centerPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        centerPanel.add(new JLabel("Name des Sets:"));
        centerPanel.add(setNameField);

        // Buttons
        JButton speichernButton = new JButton("Speichern");
        JButton zurueckButton = new JButton("Zurück");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        buttonPanel.add(speichernButton);
        buttonPanel.add(zurueckButton);

        add(title, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Aktion: Speichern (noch ohne echte Speicherung)
        speichernButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Hier könnte man später das Set speichern

                // Zurück zur Set-Übersicht
                mainFrame.showPanel("LERNEN");
            }
        });

        // Aktion: Zurück
        zurueckButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showPanel("LERNEN");
            }
        });

        speichernButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String setName = setNameField.getText();

                if (!setName.equals("")) {

                    // Neues Set zum Dropdown hinzufügen
                    mainFrame.getLernPanel().addSet(setName);
                }

                // Zurück zur Lern-Übersicht
                mainFrame.showPanel("LERNEN");
            }
        });

    }
}
