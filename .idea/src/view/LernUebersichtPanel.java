package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Panel zur Auswahl der Karteikartensets
public class LernUebersichtPanel extends JPanel {

    private MainFrame mainFrame;

    // Modell für das Dropdown
    private DefaultComboBoxModel<String> comboModel;

    // Dropdown-Menü
    private JComboBox<String> setDropdown;

    public LernUebersichtPanel(MainFrame mainFr) {

        mainFrame = mainFr;

        setLayout(new BorderLayout());

        // Überschrift
        JLabel title = new JLabel("Karteikartenset auswählen");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setHorizontalAlignment(JLabel.CENTER);

        add(title, BorderLayout.NORTH);

        // =============================
        // Dropdown erstellen
        // =============================

        comboModel = new DefaultComboBoxModel<String>();

        // Beispiel-Sets
        comboModel.addElement("Food");
        comboModel.addElement("Economics");
        comboModel.addElement("Leisure");

        setDropdown = new JComboBox<String>(comboModel);

        // =============================
        // Buttons
        // =============================

        JButton startenButton = new JButton("Lernen starten");
        JButton neuesSetButton = new JButton("Neues Set erstellen");

        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));

        centerPanel.add(setDropdown);
        centerPanel.add(startenButton);
        centerPanel.add(neuesSetButton);

        add(centerPanel, BorderLayout.CENTER);

        // Aktion: Lernen starten
        startenButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String gewaehltesSet = (String) setDropdown.getSelectedItem();

                // Hier könnte man später das Set übergeben
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

    // =============================
    // Methode um neues Set hinzuzufügen
    // =============================
    public void addSet(String setName) {
        comboModel.addElement(setName);
    }
}
