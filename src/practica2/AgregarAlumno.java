package practica2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarAlumno extends JDialog {
    private JTextField nombreA;
    private JTextField dniA;
    private JTextField tlfA;
    private JTextField edadA;
    private JButton añadirAlumnoButton;
    private JPanel panel;
    private JTextField nota;
    private JComboBox comboBox1;

    public  AgregarAlumno(MenuPrincipal parent,boolean modal){

        super(parent,modal);

        setContentPane(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500,500,500,500);

        for (Curso c: parent.listaCursos.getListaCursos()){
            comboBox1.addItem(c);
        }
        añadirAlumnoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dniA.getText().matches("[0-9]{8}[A-Z]")){

                    boolean correcto = true;

                    for (Alumno a:parent.listaAlumnos.getListaAlumnos()){
                        if (a.getDNI().equals(dniA.getText())){
                            JOptionPane.showMessageDialog(null,"El DNI ya existe, introduzca uno nuevo","Error",JOptionPane.ERROR_MESSAGE);
                            correcto = false;
                        }
                    }
                    if (correcto == true){
                        if (tlfA.getText().matches("^[1-9]\\d{8}$")){
                            if (edadA.getText().matches("^[1-9]\\d*$")){
                                if (nota.getText().matches("^(10|\\d(\\.\\d{1,2})?)$")){
                                    Alumno a = null;
                                    try {
                                        a = new Alumno(nombreA.getText(),dniA.getText(),Integer.parseInt(tlfA.getText()),Integer.parseInt(edadA.getText()),(Curso)comboBox1.getSelectedItem());
                                    } catch (CursoNoEncontrado ex) {
                                        System.err.println("Se ha producido una excepción: " + ex.getMessage());
                                    }
                                    a.agregarNota(Double.parseDouble(nota.getText()));
                                    parent.agregarAlumno(a);
                                    setVisible(false);
                                }else {

                                    JOptionPane.showMessageDialog(null,"Formato de nota no válido, tiene que ser un número positivo entre 0 y 10 y puede tener como máximo 2 decimales(ejemplo:5.55)","Error",JOptionPane.ERROR_MESSAGE);

                                }
                            }  else {
                                JOptionPane.showMessageDialog(null,"La edad no es válida, tiene que ser un número entero positivo","Error",JOptionPane.ERROR_MESSAGE);

                            }
                        }else {
                            JOptionPane.showMessageDialog(null,"El teléfono no es válido, tiene que tener 9 dígtos que sean números enteros positivos","Error",JOptionPane.ERROR_MESSAGE);

                        }
                    }

                }else {
                    JOptionPane.showMessageDialog(null,"El DNI no es válido, tiene que cumplir el formato DNI(ejemplo:12345678M)","Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }
}
