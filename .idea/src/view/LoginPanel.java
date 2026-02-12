package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel {
    //Referenz zum Hauptfenster
    private MainFrame mainFrame;

    //Konstruktor
    public LoginPanel(MainFrame mainframe) {
        //Mainframe speichern
        mainFrame = mainframe;

        //Layout für das Panel festlegen
        setLayout(new BorderLayout());


        // Überschrift
        JLabel title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setHorizontalAlignment(JLabel.CENTER);

        // Eingabefeld für Benutzername oder Email
        //JTextField usernameField = new JTextField();

        //Eingabefeld für  passwort
        //JTextField pwField = new JTextField();
        // Button zum Anmelden
        JButton loginButton = new JButton("Anmelden");

        // Button zum Registrieren
        JButton registerButton = new JButton("Registrieren");

        // Panel für Eingabe
        JPanel inputPanel = new JPanel(new GridLayout(8, 1, 5, 5));

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        inputPanel.add(new JLabel("Benutzername:"));
        inputPanel.add(usernameField);

        inputPanel.add(new JLabel("Passwort:"));
        inputPanel.add(passwordField);


        // Panel für die Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        // Komponenten hinzufügen
        add(title, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Aktion: Anmelden
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Später Login prüfen
                mainFrame.showPanel("START");
            }
        });

        // Aktion: Zur Registrieren-Seite wechseln
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showPanel("REGISTER");
            }
        });

    }
}
