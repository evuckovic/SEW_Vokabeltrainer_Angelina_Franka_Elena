package view;

import javax.swing.*;
import java.awt.*;

public class TestPanel extends JPanel {

    private MainFrame mainFrame;

    private JLabel wortLabel;
    private JTextField eingabe;

    private int index = 0;
    private String aktuellesSet = "Economics";

    public TestPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        setLayout(new BorderLayout());

        wortLabel = new JLabel();
        wortLabel.setHorizontalAlignment(JLabel.CENTER);
        wortLabel.setFont(new Font("Arial", Font.BOLD, 24));

        eingabe = new JTextField();
        JButton pruefen = new JButton("Prüfen");

        add(wortLabel, BorderLayout.CENTER);

        JPanel unten = new JPanel(new GridLayout(2,1));
        unten.add(eingabe);
        unten.add(pruefen);

        add(unten, BorderLayout.SOUTH);

        neuesWort();

        pruefen.addActionListener(e -> pruefen());
    }

    private void neuesWort() {

        String wort = mainFrame.getController()
                .getDeutsch(aktuellesSet, index);

        wortLabel.setText(wort);
    }

    private void pruefen() {

        String eingabeText = eingabe.getText();

        boolean richtig = mainFrame.getController()
                .pruefeAntwort(aktuellesSet,
                        mainFrame.getController()
                                .getDeutsch(aktuellesSet, index),
                        eingabeText);

        index++;
        eingabe.setText("");

        if(index < 10)
            neuesWort();
        else {
            index = 0;
            mainFrame.showPanel("START");
        }
    }
}
