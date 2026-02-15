package view;
import javax.swing.*;
import java.awt.*;
import controller.VokabelTrainer;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private LernUebersichtPanel lernPanel;
    private VokabelTrainer controller;

    public MainFrame(VokabelTrainer controller) {
        this.controller = controller;
        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(cardLayout);

        // Die Panels erstellen und den Controller übergeben
        LoginPanel loginPanel = new LoginPanel(this, controller);
        StartseitePanel startseitePanel = new StartseitePanel(this, controller);
        RegisterPanel registerPanel = new RegisterPanel(this, controller);
        this.lernPanel = new LernUebersichtPanel(this, controller);
        SetErstellenPanel setPanel = new SetErstellenPanel(this, controller);

        mainPanel.add(loginPanel, "LOGIN");
        mainPanel.add(registerPanel, "REGISTER");
        mainPanel.add(startseitePanel, "START");
        mainPanel.add(lernPanel, "LERNEN");
        mainPanel.add(setPanel, "SET_ERSTELLEN");

        add(mainPanel);

        setTitle("Vokabeltrainer");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        cardLayout.show(mainPanel, "LOGIN");
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    public LernUebersichtPanel getLernPanel() {
        return lernPanel;
    }
}