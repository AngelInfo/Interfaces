package practica2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarProfesor extends JDialog {
    private JPanel panel1;
    private JButton añadirButton;
    private JTextField nombre;
    private JTextField DNI;
    private JTextField tlf;
    private JTextField edad;
    private JComboBox comboBox1;
    private JRadioButton síRadioButton;
    private JRadioButton noRadioButton;

    public AgregarProfesor(MenuPrincipal parent,boolean modal){
        super(parent,modal);

        setContentPane(panel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500,500,500,500);

        comboBox1.addItem("Sin curso");
        for (Curso c: parent.listaCursos.getListaCursos()){
            comboBox1.addItem(c);
        }
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (DNI.getText().matches("[0-9]{8}[A-Z]")) {

                    boolean correcto = true;

                    for (Profesor p : parent.listaProfesores.getListaProfesores()) {
                        if (p.getDNI().equals(DNI.getText())) {
                            JOptionPane.showMessageDialog(null, "El DNI ya existe, introduzca uno nuevo", "Error", JOptionPane.ERROR_MESSAGE);
                            correcto = false;
                        }
                    }
                    if (correcto == true) {
                        if (tlf.getText().matches("^[1-9]\\d{8}$")) {
                            if (edad.getText().matches("^[1-9]\\d*$")) {
                                Profesor p;
                                try {
                                    if (comboBox1.getSelectedItem().equals("Sin curso") && noRadioButton.isSelected()) {
                                        p = new Profesor(nombre.getText(), DNI.getText(), Integer.parseInt(tlf.getText()), Integer.parseInt(edad.getText()));
                                        parent.agregarProfesor(p);
                                        setVisible(false);
                                    } else if (!comboBox1.getSelectedItem().equals("Sin curso") && síRadioButton.isSelected()){;
                                        p = new Profesor(nombre.getText(), DNI.getText(), Integer.parseInt(tlf.getText()), Integer.parseInt(edad.getText()), (Curso) comboBox1.getSelectedItem());
                                        parent.agregarProfesor(p);
                                        setVisible(false);
                                    }else {
                                        if (comboBox1.getSelectedItem().equals("Sin curso") && síRadioButton.isSelected()) {
                                            JOptionPane.showMessageDialog(null,"El profesor no puede ser tutor y no tener curso","Error",JOptionPane.ERROR_MESSAGE);
                                        }else if (!comboBox1.getSelectedItem().equals("Sin curso") && noRadioButton.isSelected()){
                                            JOptionPane.showMessageDialog(null,"El profesor no puede no ser tutor y tener curso","Error",JOptionPane.ERROR_MESSAGE);
                                        }
                                    }
                                } catch (CursoNoEncontrado ex) {
                                    System.err.println("Se ha producido una excepción: " + ex.getMessage());
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "La edad no es válida, tiene que ser un número entero positivo", "Error", JOptionPane.ERROR_MESSAGE);

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El teléfono no es válido, tiene que tener 9 dígtos que sean números enteros positivos", "Error", JOptionPane.ERROR_MESSAGE);

                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El DNI no es válido, tiene que cumplir el formato DNI(ejemplo:12345678M)", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}
