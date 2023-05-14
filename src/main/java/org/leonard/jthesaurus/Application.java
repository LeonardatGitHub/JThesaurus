package org.leonard.jthesaurus;

import org.leonard.jthesaurus.views.HomeView;

import javax.swing.*;
import java.awt.*;

public class Application extends JFrame {

    private static Application application;

    public static void main(String[] args) {
        new Application();
    }

    private Application() {
        application = this;
        Dimension fullscreen = Toolkit.getDefaultToolkit().getScreenSize();
        fullscreen.setSize(fullscreen.getWidth()  * 0.4, fullscreen.getHeight() * 0.75);
        setTitle("OMEGATITLE");
        setSize(fullscreen);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new HomeView(), BorderLayout.CENTER);

        setVisible(true);
    }

    public static int vw(double percentage) {
        return (int) (application.getWidth() * percentage);
    }

    public static int vh(double percentage) {
        return (int) (application.getHeight() * percentage);
    }
}
