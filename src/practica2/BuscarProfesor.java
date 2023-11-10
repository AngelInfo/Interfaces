package practica2;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuscarProfesor extends JDialog {
    private JPanel panel1;
    private JButton buscarButton;
    private JTextField DNI;

    public BuscarProfesor(MenuPrincipal parent,boolean modal){
        super(parent,modal);

        setContentPane(panel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500,500,500,500);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parent.buscarProfesor(DNI.getText());
                setVisible(false);
            }
        });
    }
}
