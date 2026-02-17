package view;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    private MainFrame mainFrame;

    public LoginPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        setLayout(new BorderLayout(10,10));

        // Titel
        JLabel title = new JLabel("Login");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title, BorderLayout.NORTH);

        // Eingabefelder
        JTextField username = new JTextField();
        JPasswordField pw = new JPasswordField();

        JPanel center = new JPanel(new GridLayout(4,1,5,5));
        center.add(new JLabel("Benutzername:"));
        center.add(username);
        center.add(new JLabel("Passwort:"));
        center.add(pw);

        add(center, BorderLayout.CENTER);

        // Buttons unten
        JButton login = new JButton("Anmelden");
        JButton registerButton = new JButton("Registrieren");

        JPanel buttonPanel = new JPanel(new GridLayout(1,2,10,0));
        buttonPanel.add(login);
        buttonPanel.add(registerButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Login-Logik
        login.addActionListener(e -> {

            String name = username.getText();
            String passwort = new String(pw.getPassword());

            boolean ok = mainFrame.getController().login(name, passwort);

            if (ok) {
                mainFrame.showPanel("START");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Falscher Benutzername oder Passwort!",
                        "Login fehlgeschlagen",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Wechsel zu RegisterPanel
        registerButton.addActionListener(e ->
                mainFrame.showPanel("REGISTER"));
    }
}
