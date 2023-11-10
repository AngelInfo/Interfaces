package practica2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarAlumno extends  JDialog {
    private JPanel panel1;
    private JButton eliminarButton;
    private JTextField dni;

    public EliminarAlumno(MenuPrincipal parent,boolean modal){
        super(parent,modal);

        setContentPane(panel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500,500,500,500);


        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.eliminarAlumno(dni.getText());

                setVisible(false);
            }
        });
    }
}
