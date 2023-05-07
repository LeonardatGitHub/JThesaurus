package org.leonard.jthesaurus.views;

import javax.swing.*;
import java.awt.*;

public class HomeView extends JPanel {

    TextField textField;

    public HomeView() {
        this.setLayout(new BorderLayout());
        textField = new TextField();
        this.setPreferredSize(new Dimension(160, 32));
        this.setMaximumSize(new Dimension(160, 32));
        this.setMinimumSize(new Dimension(160, 32));
        this.add(textField, BorderLayout.CENTER);
        this.repaint();
    }

}
