package view;

import javax.swing.*;
import java.awt.*;

public class StartseitePanel extends JPanel {

    public StartseitePanel(MainFrame mainFrame) {

        setLayout(new GridLayout(3,1,10,10));

        JButton lernen = new JButton("Lernen");
        JButton testen = new JButton("Testen");
        JButton spielen = new JButton("Spielen");

        add(lernen);
        add(testen);
        add(spielen);

        lernen.addActionListener(e -> mainFrame.showPanel("LERNEN"));
        testen.addActionListener(e -> mainFrame.showPanel("TEST"));
        spielen.addActionListener(e -> mainFrame.showPanel("SPIEL"));
    }
}
