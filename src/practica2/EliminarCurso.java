package practica2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EliminarCurso extends JDialog{
    private JPanel panel1;
    private JButton eliminarButton;
    private JTextField codigoCE;

    public EliminarCurso(MenuPrincipal parent, boolean modal){
        super(parent,modal);

        setContentPane(panel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500,500,500,500);


        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean correcto = true;

                for (Alumno a: parent.listaAlumnos.getListaAlumnos()){
                    if (a.getCurso().getCodigo().equals(codigoCE.getText())){
                        JOptionPane.showMessageDialog(null,"Primero elimina los alumnos de este curso, para poder eliminarlo","Error",JOptionPane.ERROR_MESSAGE);
                        correcto = false;
                    }
                }
                if (correcto){
                    parent.eliminarCurso(codigoCE.getText());
                }

                setVisible(false);
            }
        });
    }
}
