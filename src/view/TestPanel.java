package view;

import javax.swing.*;
import java.awt.*;

public class TestPanel extends JPanel {

    private MainFrame mainFrame;

    private JLabel wortLabel;
    private JLabel infoLabel;
    private JTextField eingabe;

    private int index = 0;
    private int punkte = 0;

    private String aktuellesSet = "Economics";
    private final int MAX_KARTEN = 10;

    public TestPanel(MainFrame mainFrame) {

        this.mainFrame = mainFrame;

        setLayout(new BorderLayout(10,10));

        // Info Label (Frage X von 10)
        infoLabel = new JLabel();
        infoLabel.setHorizontalAlignment(JLabel.CENTER);

        // Wort Anzeige
        wortLabel = new JLabel();
        wortLabel.setHorizontalAlignment(JLabel.CENTER);
        wortLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel oben = new JPanel(new GridLayout(2,1));
        oben.add(infoLabel);
        oben.add(wortLabel);

        add(oben, BorderLayout.NORTH);

        // Eingabe
        eingabe = new JTextField();

        JButton pruefen = new JButton("Prüfen");

        JPanel unten = new JPanel(new GridLayout(2,1,5,5));
        unten.add(eingabe);
        unten.add(pruefen);

        add(unten, BorderLayout.SOUTH);

        neuesWort();

        pruefen.addActionListener(e -> pruefen());
    }

    private void neuesWort() {

        if (index < MAX_KARTEN) {

            String wort = mainFrame.getController()
                    .getDeutsch(aktuellesSet, index);

            wortLabel.setText(wort);
            infoLabel.setText("Frage " + (index + 1) + " von " + MAX_KARTEN);
        }
    }

    private void pruefen() {

        String eingabeText = eingabe.getText();

        boolean richtig = mainFrame.getController()
                .pruefeAntwort(aktuellesSet, index, eingabeText);

        if (richtig) {
            punkte++;
        }

        index++;
        eingabe.setText("");

        if (index >= MAX_KARTEN) {

            JOptionPane.showMessageDialog(this,
                    "Test beendet!\n\nDu hast "
                            + punkte + " von "
                            + MAX_KARTEN + " Punkten erreicht.");

            // Reset
            punkte = 0;
            index = 0;

            mainFrame.showPanel("START");

        } else {
            neuesWort();
        }
    }
}
