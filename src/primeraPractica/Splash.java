package primeraPractica;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Splash {
    public static void main(String[] args) {
        SplashScreen  splashScreen = new SplashScreen ();
    }
}

class SplashScreen  extends JWindow {
    static JProgressBar progressBar = new JProgressBar();
    static int count = 1, TIMER_PAUSE = 25, PROGBAR_MAX = 100;
    static Timer progressBarTimer;
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            progressBar.setValue(count);
            if (PROGBAR_MAX == count) {
                progressBarTimer.stop();
                SplashScreen.this.setVisible(false);
                createAndShowFrame();
            }
            count++;
        }
    };

    public SplashScreen() {
        Container container = getContentPane();

        JPanel panel = new JPanel();
        panel.setBorder(new EtchedBorder());
        container.add(panel, BorderLayout.CENTER);

        JLabel label = new JLabel("Bienvenuti");
        label.setFont(new Font("Verdana", Font.BOLD, 14));
        panel.add(label);

        progressBar.setMaximum(PROGBAR_MAX);
        container.add(progressBar, BorderLayout.SOUTH);
        pack();
        setVisible(true);
        startProgressBar();
    }
    private void startProgressBar() {
        progressBarTimer = new Timer(TIMER_PAUSE, al);
        progressBarTimer.start();
    }

    private void createAndShowFrame() {
        IniciarSesion ventana = new IniciarSesion();
        ventana.setVisible(true);
    }
}


