package view;

import controller.TrainerController;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private LernPanel lernPanel;

    private TrainerController controller;

    private LernUebersichtPanel lernPanel;

    public MainFrame() throws Exception {

        controller = new TrainerController();

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        LoginPanel loginPanel = new LoginPanel(this);
        StartseitePanel startseitePanel = new StartseitePanel(this);
        lernPanel = new LernUebersichtPanel(this);
        TestPanel testPanel = new TestPanel(this);
        MemoryPanel memoryPanel = new MemoryPanel(this);
        lernPanel = new LernPanel(this);

        mainPanel.add(lernPanel, "LERNEN_START");
        mainPanel.add(loginPanel, "LOGIN");
        mainPanel.add(startseitePanel, "START");
        mainPanel.add(lernPanel, "LERNEN");
        mainPanel.add(testPanel, "TEST");
        mainPanel.add(memoryPanel, "SPIEL");

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

    public LernUebersichtPanel getLernPanel() {
        return lernPanel;
    }

    public void starteLernen(String setName) {
        lernPanel.starteLernen(setName);
        showPanel("LERNEN_START");
    }

}
