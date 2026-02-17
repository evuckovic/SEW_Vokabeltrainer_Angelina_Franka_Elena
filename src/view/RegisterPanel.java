package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterPanel extends JPanel {
    private MainFrame mainFrame;

    public RegisterPanel(MainFrame mainFr) {

        mainFrame = mainFr;

        // Layout für die Seite
        setLayout(new BorderLayout());

        // Überschrift
        JLabel title = new JLabel("Registrieren");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setHorizontalAlignment(JLabel.CENTER);

        // Eingabefelder
        JTextField emailField = new JTextField();
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JPasswordField confirmPasswordField = new JPasswordField();

        // Panel für die Eingabefelder
        JPanel inputPanel = new JPanel(new GridLayout(8, 1, 5, 5));


        inputPanel.add(new JLabel("Benutzername:"));
        inputPanel.add(usernameField);

        inputPanel.add(new JLabel("Passwort:"));
        inputPanel.add(passwordField);

        inputPanel.add(new JLabel("Passwort bestätigen:"));
        inputPanel.add(confirmPasswordField);

        // Buttons
        JButton registerButton = new JButton("Registrieren");
        JButton backButton = new JButton("Zurück");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        buttonPanel.add(registerButton);
        buttonPanel.add(backButton);

        // Komponenten hinzufügen
        add(title, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Aktion: Registrieren
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Hier könnte man prüfen:
                // - Sind alle Felder ausgefüllt?
                // - Stimmen die Passwörter überein?

                // Nach erfolgreicher Registrierung zurück zum Login
                mainFrame.showPanel("LOGIN");
            }
        });

        // Aktion: Zurück zum Login
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.showPanel("LOGIN");
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText();
                String pw = new String(passwordField.getPassword());
                String confirm = new String(confirmPasswordField.getPassword());

                if (!pw.equals(confirm)) {
                    JOptionPane.showMessageDialog(null, "Passwörter stimmen nicht überein!");
                    return;
                }

                boolean ok = mainFrame.getController().registrieren(username, pw);

                if (ok) {
                    JOptionPane.showMessageDialog(null, "Registrierung erfolgreich!");
                    mainFrame.showPanel("START");
                } else {
                    JOptionPane.showMessageDialog(null, "Registrierung fehlgeschlagen!");
                }
            }
        });

    }
}
