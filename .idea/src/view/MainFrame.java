package view;
import javax.swing.*;
import java.awt.*;
// Ist das hauptfenster des Programms
public class MainFrame extends JFrame {
    //------------Attribute-------------
    //Cardlayout damit wir mehrere seiten verwalten können
    private CardLayout cardLayout;
    // enthält alle Seiten(=Panels)
    private JPanel mainPanel;
    private LernUebersichtPanel lernPanel;

    //------------Konstruktor-------------
    public MainFrame() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        //Die einzelnen Seiten erstellen
        LoginPanel loginPanel= new LoginPanel(this);
        StartseitePanel startseitePanel=new StartseitePanel(this);
        RegisterPanel registerPanel = new RegisterPanel(this);
        LernUebersichtPanel lernPanel = new LernUebersichtPanel(this);
        SetErstellenPanel setErstellenPanel = new SetErstellenPanel(this);
        lernPanel = new LernUebersichtPanel(this);
        SetErstellenPanel setPanel = new SetErstellenPanel(this);

        // Seiten zum mainPanel hinzufügen
        mainPanel.add(loginPanel, "LOGIN");
        mainPanel.add(registerPanel, "REGISTER");
        mainPanel.add(startseitePanel, "START");
        mainPanel.add(lernPanel, "LERNEN");
        mainPanel.add(setErstellenPanel, "SET_ERSTELLEN");
        mainPanel.add(lernPanel, "LERNEN");
        mainPanel.add(setPanel, "SET_ERSTELLEN");

        // mainPanel dem Fenster hinzufügen
        add(mainPanel);

        // Fenstereinstellungen
        setTitle("Vokabeltrainer");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Fenster zentrieren
        setVisible(true);

        // Startseite beim Programmstart anzeigen
        cardLayout.show(mainPanel, "LOGIN");
    }
    // Methode zum Wechseln der Seiten
    public void showPanel(String name) {
        cardLayout.show(mainPanel, name);
    }

    public LernUebersichtPanel getLernPanel() {
        return lernPanel;
    }

}
