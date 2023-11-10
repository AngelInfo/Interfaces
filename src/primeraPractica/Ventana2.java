package primeraPractica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana2 extends JDialog {
    private JButton boton1;
    private JPanel panel1;
    private JLabel label1;

    public Ventana2(Practica1 parent, boolean modal){

        super(parent,modal);
        setContentPane(panel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(false);
        setBounds(440,10,410,210);

        boton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == boton1){
                    setVisible(false);
                }
            }
        });
    }

}
