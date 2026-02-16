package view;

import javax.swing.*;
import java.awt.*;

public class LernUebersichtPanel extends JPanel {

    private JComboBox<String> dropdown;

    public LernUebersichtPanel(MainFrame mainFrame) {

        setLayout(new BorderLayout());

        JLabel title = new JLabel("Set auswählen");
        title.setHorizontalAlignment(JLabel.CENTER);

        dropdown = new JComboBox<>();

        // Sets vom Controller holen
        String[] sets = mainFrame.getController().getSetNamen();
        for(String s : sets)
            dropdown.addItem(s);

        JButton starten = new JButton("Lernen starten");

        add(title, BorderLayout.NORTH);
        add(dropdown, BorderLayout.CENTER);
        add(starten, BorderLayout.SOUTH);

        starten.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String set = (String) dropdown.getSelectedItem();
                mainFrame.starteLernen(set);
            }
        });
    }

    public String getSelectedSet() {
        return (String) dropdown.getSelectedItem();
    }
}
