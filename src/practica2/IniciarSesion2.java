package practica2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class IniciarSesion2 extends JFrame {


    private JPanel panel1;
    private JTextField usuario;
    private JPasswordField contraseña;
    private JButton iniciarSesionButton;
    private JLabel pista;

    public IniciarSesion2(){
        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(300,300,300,200);

        pista.setForeground(Color.red);

        iniciarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getText().equals("Angel") && contraseña.getText().equals("1234")){
                    MenuPrincipal ventanaPrincipal = new MenuPrincipal();
                    //ventanaPrincipal.setVisible(true);
                    setVisible(false);
                }
            }
        });
        pista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                pista.setText("Usuario: Angel, Contraseña: 1234");
            }
        });
    }


}


