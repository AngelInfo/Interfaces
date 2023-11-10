package practica2;


import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class Splash2 {
    public static void main(String[] args) {
        practica2.SplashScreen splashScreen = new practica2.SplashScreen();
    }
}

class SplashScreen  extends JWindow {
    static JProgressBar progressBar = new JProgressBar();
    static int count = 1, TIMER_PAUSE = 50, PROGBAR_MAX = 100;
    static Timer progressBarTimer;
    ActionListener al = new ActionListener() {
        @Override
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            progressBar.setValue(count);
            if (PROGBAR_MAX == count) {
                progressBarTimer.stop();
                practica2.SplashScreen.this.setVisible(false);
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
        setLocation(700,400);



        JLabel label = new JLabel(new ImageIcon("src/unnamed.gif"));
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
        IniciarSesion2 ventana = new IniciarSesion2();
        ventana.setVisible(true);
    }
}
