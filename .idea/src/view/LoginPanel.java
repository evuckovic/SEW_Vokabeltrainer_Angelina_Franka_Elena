package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPanel extends JPanel {

    private MainFrame mainFrame;

    public LoginPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Login");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 20));

        JTextField username = new JTextField();
        JPasswordField pw = new JPasswordField();
        JButton login = new JButton("Anmelden");

        JPanel center = new JPanel(new GridLayout(4,1,5,5));
        center.add(new JLabel("Benutzername:"));
        center.add(username);
        center.add(new JLabel("Passwort:"));
        center.add(pw);

        add(title, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(login, BorderLayout.SOUTH);

        login.addActionListener(e -> mainFrame.showPanel("START"));
    }
}
