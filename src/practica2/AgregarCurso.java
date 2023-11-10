package practica2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarCurso extends  JDialog {
    private JPanel panel1;
    private JTextField codigo;
    private JTextField nombreC;
    private JButton añadirCursoButton;

    public AgregarCurso(MenuPrincipal parent, boolean modal){
        super(parent,modal);

        setContentPane(panel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500,500,500,500);


        añadirCursoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (codigo.getText().matches("^[1-9]\\d*$")){

                    boolean correcto = true;

                    for (Curso c:parent.listaCursos.getListaCursos()){
                        if (c.getCodigo().equals(codigo.getText())){
                            JOptionPane.showMessageDialog(null,"El código ya existe, introduzca uno nuevo","Error",JOptionPane.ERROR_MESSAGE);
                            correcto = false;
                        }
                    }
                    if (correcto == true){
                        Curso curso = new Curso(codigo.getText(), nombreC.getText());
                        parent.agregarCurso(curso);
                        setVisible(false);
                    }

                }
                else {

                    JOptionPane.showMessageDialog(null,"El código no es válido, tiene que ser un número entero positivo","Error",JOptionPane.ERROR_MESSAGE);

                }


            }
        });

    }

}
