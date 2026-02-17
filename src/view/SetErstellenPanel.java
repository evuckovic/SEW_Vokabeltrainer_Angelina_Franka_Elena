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



        JTextField feld1 = new JTextField();
        JTextField feld2 = new JTextField();
        JTextField feld3 = new JTextField();
        JTextField feld4 = new JTextField();
        JTextField feld5 = new JTextField();
        JTextField feld6 = new JTextField();
        JTextField feld7 = new JTextField();
        JTextField feld8 = new JTextField();
        JTextField feld9 = new JTextField();
        JTextField feld10 = new JTextField();
        JTextField feld11 = new JTextField();
        JTextField feld12 = new JTextField();
        JTextField feld13 = new JTextField();
        JTextField feld14 = new JTextField();
        JTextField feld15 = new JTextField();
        JTextField feld16 = new JTextField();
        JTextField feld17 = new JTextField();
        JTextField feld18 = new JTextField();
        JTextField feld19 = new JTextField();
        JTextField feld20 = new JTextField();

        JPanel inputPanel = new JPanel(new GridLayout(20, 1, 5, 5));


        inputPanel.add(new JLabel("Deutsch1:"));
        inputPanel.add(feld1);

        inputPanel.add(new JLabel("Englisch1:"));
        inputPanel.add(feld2);

        inputPanel.add(new JLabel("Deutsch2:"));
        inputPanel.add(feld3);

        inputPanel.add(new JLabel("Englisch2:"));
        inputPanel.add(feld4);

        inputPanel.add(new JLabel("Deutsch3:"));
        inputPanel.add(feld5);

        inputPanel.add(new JLabel("Englisch3:"));
        inputPanel.add(feld6);

        inputPanel.add(new JLabel("Deutsch4:"));
        inputPanel.add(feld7);

        inputPanel.add(new JLabel("Englisch4:"));
        inputPanel.add(feld8);

        inputPanel.add(new JLabel("Deutsch5:"));
        inputPanel.add(feld9);

        inputPanel.add(new JLabel("Englisch5:"));
        inputPanel.add(feld10);

        inputPanel.add(new JLabel("Deutsch6:"));
        inputPanel.add(feld11);

        inputPanel.add(new JLabel("Englisch6:"));
        inputPanel.add(feld12);

        inputPanel.add(new JLabel("Deutsch7:"));
        inputPanel.add(feld13);

        inputPanel.add(new JLabel("Englisch7:"));
        inputPanel.add(feld14);

        inputPanel.add(new JLabel("Deutsch8:"));
        inputPanel.add(feld15);

        inputPanel.add(new JLabel("Englisch8:"));
        inputPanel.add(feld16);

        inputPanel.add(new JLabel("Deutsch9:"));
        inputPanel.add(feld17);

        inputPanel.add(new JLabel("Englisch9:"));
        inputPanel.add(feld18);

        inputPanel.add(new JLabel("Deutsch10:"));
        inputPanel.add(feld19);

        inputPanel.add(new JLabel("Englisch10:"));
        inputPanel.add(feld20);

        // Buttons
        JButton registerButton = new JButton("Registrieren");
        JButton backButton = new JButton("Zurück");




        // Buttons
        JButton speichernButton = new JButton("Speichern");
        JButton zurueckButton = new JButton("Zurück");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        buttonPanel.add(speichernButton);
        buttonPanel.add(zurueckButton);

        add(title, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
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
                    mainFrame.getLernUebersichtPanel().addSet(setName);

                }

                // Zurück zur Lern-Übersicht
                mainFrame.showPanel("LERNEN");
            }
        });




    }
}
