package primeraPractica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IniciarSesion extends JFrame {


    private JPanel panel1;
    private JTextField usuario;
    private JPasswordField contraseña;
    private JButton iniciarSesionButton;

    public IniciarSesion(){
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(300,300,300,160);

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (usuario.getText().equals("Angel") && contraseña.getText().equals("1234")){
                Practica1 ventanaPrincipal = new Practica1();
                ventanaPrincipal.setVisible(true);
                setVisible(false);
                }
            }
        });
    }


}


