package view;

import controller.TrainerController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    private TrainerController controller;

    // WICHTIG: Zwei verschiedene Variablen!
    private LernUebersichtPanel lernUebersichtPanel;
    private LernPanel lernPanel;

    public MainFrame() throws Exception {

        controller = new TrainerController();

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        LoginPanel loginPanel = new LoginPanel(this);
        StartseitePanel startseitePanel = new StartseitePanel(this);
        lernUebersichtPanel = new LernUebersichtPanel(this);
        lernPanel = new LernPanel(this);
        TestPanel testPanel = new TestPanel(this);
        MemoryPanel memoryPanel = new MemoryPanel(this);
        RegisterPanel registerPanel = new RegisterPanel(this);


        // JEDES Panel nur EINMAL hinzufügen
        mainPanel.add(loginPanel, "LOGIN");
        mainPanel.add(startseitePanel, "START");
        mainPanel.add(lernUebersichtPanel, "LERNEN");
        mainPanel.add(lernPanel, "LERNEN_START");
        mainPanel.add(testPanel, "TEST");
        mainPanel.add(memoryPanel, "SPIEL");
        mainPanel.add(registerPanel, "REGISTER");


        add(mainPanel);

        setTitle("Vokabeltrainer");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        cardLayout.show(mainPanel, "LOGIN");
    }

    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    public TrainerController getController() {
        return controller;
    }

    // WICHTIG: Diese Methode startet das Lernen richtig
    public void starteLernen(String setName) {
        lernPanel.starteLernen(setName);
        showPanel("LERNEN_START");
    }
    public LernUebersichtPanel getLernUebersichtPanel() {
        return lernUebersichtPanel;
    }

}
