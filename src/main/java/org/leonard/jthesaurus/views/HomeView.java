package org.leonard.jthesaurus.views;

import javax.swing.*;
import java.awt.*;

import static javax.swing.SpringLayout.*;
import static org.leonard.jthesaurus.Application.vh;
import static org.leonard.jthesaurus.Application.vw;

public class HomeView extends JPanel {

    TextField textField;

    double inlineMargin = 0.3;

    int componentHeight = 32;
    int componentWidth = 160;

    SpringLayout springLayout;

    public HomeView() {
        springLayout = new SpringLayout();
        setLayout(springLayout);


        textField = new TextField();
        this.setPreferredSize(new Dimension(componentWidth, componentHeight));
        this.setMaximumSize(new Dimension(componentWidth, componentHeight));
        this.springLayout.putConstraint(WEST, textField, vw(inlineMargin), WEST, this);
        this.springLayout.putConstraint(EAST, textField, -vw(inlineMargin), EAST, this);
        this.springLayout.putConstraint(SOUTH, textField, -vh(0.465), SOUTH, this);
        this.springLayout.putConstraint(NORTH, textField, vh(0.465), NORTH, this);
        this.add(textField);
        this.repaint();
    }

}
