package practica2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    static ListaAlumnos listaAlumnos = new ListaAlumnos();
    static ListaProfesores listaProfesores = new ListaProfesores();
    static ListaCursos listaCursos = new ListaCursos();
    private JPanel panel1;
    private JTabbedPane tabbedPane1;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JButton buscarAButton;
    private JButton eliminarAButton;
    private JButton mostrarAButton;
    private JButton agregarAButton;
    private JButton agregarPButton;
    private JButton buscarPButton;
    private JButton eliminarPButton;
    private JButton mostrarPButton;
    private JButton agregarCButton;
    private JButton buscarCButton;
    private JButton eliminarCButton;
    private JButton mostrarCButton;
    private JPanel Inicio;
    private JLabel imagen;
    private JCheckBox alfabeticamenteACheckBox;
    private JCheckBox aprobadosCheckBox;
    private JCheckBox suspensosCheckBox;
    private JCheckBox alfabeticamentePCheckBox;
    private JCheckBox tutoresCheckBox;
    private JCheckBox noTutoresCheckBox;
    private JCheckBox alfabeticamenteCCheckBox;
    private JMenuBar menuBar;
    private JMenu menuA;
    private JMenu menuP;
    private JMenu menuC;
    private JMenu menuAbout;
    private JMenuItem menuItemA1, menuItemA2, menuItemA3,menuItemA4, menuItemC1, menuItemC2, menuItemC3,menuItemC4, menuItemP1, menuItemP2, menuItemP3,menuItemP4,menuItemAbout;

    static DefaultTableModel modeloA = new DefaultTableModel();
    static DefaultTableModel modeloP = new DefaultTableModel();
    static DefaultTableModel modeloC = new DefaultTableModel();

    JScrollPane panel;

    public MenuPrincipal(){
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menuA = new JMenu("Alumnos");
        menuBar.add(menuA);
        menuP = new JMenu("Profesores");
        menuBar.add(menuP);
        menuC = new JMenu("Cursos");
        menuBar.add(menuC);
        menuAbout = new JMenu("About");
        menuBar.add(menuAbout);

        menuItemA1=new JMenuItem("Agregar");
        menuA.add(menuItemA1);
        menuItemA2=new JMenuItem("Buscar");
        menuA.add(menuItemA2);
        menuItemA3=new JMenuItem("Eliminar");
        menuA.add(menuItemA3);
        menuItemA4=new JMenuItem("Mostrar");
        menuA.add(menuItemA4);

        menuItemP1=new JMenuItem("Agregar");
        menuP.add(menuItemP1);
        menuItemP2=new JMenuItem("Buscar");
        menuP.add(menuItemP2);
        menuItemP3=new JMenuItem("Eliminar");
        menuP.add(menuItemP3);
        menuItemP4=new JMenuItem("Mostrar");
        menuP.add(menuItemP4);

        menuItemC1=new JMenuItem("Agregar");
        menuC.add(menuItemC1);
        menuItemC2=new JMenuItem("Buscar");
        menuC.add(menuItemC2);
        menuItemC3=new JMenuItem("Eliminar");
        menuC.add(menuItemC3);
        menuItemC4=new JMenuItem("Mostrar");
        menuC.add(menuItemC4);

        menuItemAbout =new JMenuItem("Información");
        menuAbout.add(menuItemAbout);

        ImageIcon imageIcon = new ImageIcon("src/cool-guy-emoticon (1).gif");
        imagen.setIcon(imageIcon);

        configurarTablaAlumnos();
        configurarTablaProfesores();
        configurarTablaCursos();


        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(300,300,500,350);


        menuItemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                About a = new About(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });

        menuItemA1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaCursos.getListaCursos().size() == 0){
                    JOptionPane.showMessageDialog(null,"Primero crea un curso","Error",JOptionPane.ERROR_MESSAGE);
                }else {
                    AgregarAlumno a = new AgregarAlumno(MenuPrincipal.this,true);
                    a.setVisible(true);
                }
            }
        });
        menuItemA2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarAlumno a = new EliminarAlumno(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });
        menuItemA3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAlumnos();
                BuscarAlumno a = new BuscarAlumno(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });
        menuItemA4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAlumnos();
            }
        });

        menuItemP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarProfesor a = new AgregarProfesor(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });
        menuItemP2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarProfesor a = new EliminarProfesor(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });
        menuItemP3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProfesores();
                BuscarProfesor a = new BuscarProfesor(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });
        menuItemP4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProfesores();
            }
        });

        menuItemC1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarCurso a = new AgregarCurso(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });
        menuItemC2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarCurso c = new EliminarCurso(MenuPrincipal.this,true);
                c.setVisible(true);
            }
        });
        menuItemC3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCursos();
                BuscarCurso c = new BuscarCurso(MenuPrincipal.this,true);
                c.setVisible(true);
            }
        });
        menuItemC4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCursos();
            }
        });


        agregarAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (listaCursos.getListaCursos().size() == 0){
                    JOptionPane.showMessageDialog(null,"Primero crea un curso","Error",JOptionPane.ERROR_MESSAGE);
                }else {
                    AgregarAlumno a = new AgregarAlumno(MenuPrincipal.this,true);
                    a.setVisible(true);
                }


            }
        });

        eliminarAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EliminarAlumno a = new EliminarAlumno(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });
        buscarAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAlumnos();
                BuscarAlumno a = new BuscarAlumno(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });
        mostrarAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAlumnos();
            }
        });

        agregarPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarProfesor a = new AgregarProfesor(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });
        eliminarPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EliminarProfesor a = new EliminarProfesor(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });
        buscarPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProfesores();
                BuscarProfesor a = new BuscarProfesor(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });
        mostrarPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProfesores();
            }
        });


        agregarCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarCurso a = new AgregarCurso(MenuPrincipal.this,true);
                a.setVisible(true);
            }
        });
        eliminarCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EliminarCurso c = new EliminarCurso(MenuPrincipal.this,true);
                c.setVisible(true);
            }
        });
        buscarCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCursos();
                BuscarCurso c = new BuscarCurso(MenuPrincipal.this,true);
               c.setVisible(true);
            }
        });
        mostrarCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCursos();

            }
        });
        alfabeticamenteACheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaAlumnos.ordenarAlfabeticamente();
                mostrarAlumnos();
            }
        });
        aprobadosCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAlumnos();

                for (int i = modeloA.getRowCount() - 1; i >= 0; i--){
                    if ((double)modeloA.getValueAt(i,5) < 5){
                        modeloA.removeRow(i);
                    }
                }
            }
        });
        suspensosCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarAlumnos();
                for (int i = modeloA.getRowCount() - 1; i >= 0; i--){
                    if ((double)modeloA.getValueAt(i,5) >= 5){
                        modeloA.removeRow(i);
                    }
                }
            }
        });
        alfabeticamentePCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaProfesores.ordenarAlfabeticamente();
                mostrarProfesores();
            }
        });
        tutoresCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProfesores();
                for (int i = modeloP.getRowCount() - 1; i >= 0; i--){
                    if (modeloP.getValueAt(i,5).equals("No")){
                        modeloP.removeRow(i);
                    }
                }
            }
        });
        noTutoresCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarProfesores();
                for (int i = modeloP.getRowCount() - 1; i >= 0; i--){
                    if (modeloP.getValueAt(i,5).equals("Sí")){
                        modeloP.removeRow(i);
                    }
                }
            }
        });
        alfabeticamenteCCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaCursos.ordenarAlfabeticamente();
                mostrarCursos();
            }
        });
    }

    public void configurarTablaAlumnos(){
        //columnasAlumnos();
        modeloA.setColumnIdentifiers(new Object[]{"DNI","Nombre","Tlf","Edad","Curso","Nota"});
        //filasAlumnos();
        table1.setModel(modeloA);

    }

    public void configurarTablaProfesores(){
        modeloP.setColumnIdentifiers(new Object[]{"DNI","Nombre","Tlf","Edad","Curso","Tutor"});
        table2.setModel(modeloP);
    }

    public void configurarTablaCursos(){
        //columnasAlumnos();
        modeloC.setColumnIdentifiers(new Object[]{"Código","Nombre"});
        //filasAlumnos();
        table3.setModel(modeloC);

    }

    public void agregarAlumno(Alumno a){
        listaAlumnos.agregar(a);
        mostrarAlumnos();
    }

    public void eliminarAlumno(String dni){
        if (listaAlumnos.buscar(dni) == null){
            JOptionPane.showMessageDialog(null,"El dni del alumno no ha sido encontrado","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            for (int i = 0;i<modeloA.getRowCount();i++){
                if (modeloA.getValueAt(i,0).equals(dni)){
                    modeloA.removeRow(i);
                }
            }
            listaAlumnos.eliminar(listaAlumnos.buscar(dni));
        }

    }

    public void buscarAlumno(String dni){
        if (listaAlumnos.buscar(dni) == null){
            JOptionPane.showMessageDialog(null,"El dni del alumno no ha sido encontrado","Error",JOptionPane.ERROR_MESSAGE);
        }else {
            for (int i = modeloA.getRowCount() - 1; i >= 0; i--){
                if (!modeloA.getValueAt(i,0).equals(dni)){
                    modeloA.removeRow(i);
                }
            }
        }
    }

    public void mostrarAlumnos(){
        modeloA.setNumRows(0);
        for (Alumno a:listaAlumnos.getListaAlumnos()){
            modeloA.addRow(new Object[]{a.getDNI(),a.getNombre(),a.getTlf(),a.getEdad(),a.getCurso().getNombre(),a.getListaNotas().get(0)});
        }

    }

    public void agregarProfesor(Profesor p){
        listaProfesores.agregar(p);
        mostrarProfesores();
    }

    public  void eliminarProfesor(String dni){
        if (listaProfesores.buscar(dni) == null){
            JOptionPane.showMessageDialog(null,"El dni del profesor no ha sido encontrado","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            for (int i = 0;i<modeloP.getRowCount();i++){
                if (modeloP.getValueAt(i,0).equals(dni)){
                    modeloP.removeRow(i);
                }
            }
            listaProfesores.eliminar(listaProfesores.buscar(dni));
        }
    }

    public void buscarProfesor(String dni){
        if (listaProfesores.buscar(dni) == null){
            JOptionPane.showMessageDialog(null,"El dni del profesor no ha sido encontrado","Error",JOptionPane.ERROR_MESSAGE);
        }else {
            for (int i = modeloP.getRowCount() - 1; i >= 0; i--){
                if (!modeloP.getValueAt(i,0).equals(dni)){
                    modeloP.removeRow(i);
                }
            }
        }
    }
    public void mostrarProfesores(){
        modeloP.setNumRows(0);
        for (Profesor p:listaProfesores.getListaProfesores()){
            if (p.getCurso() == null){
                modeloP.addRow(new Object[]{p.getDNI(),p.getNombre(),p.getTlf(),p.getEdad(),"Sin curso", "No"});
            }else {
                modeloP.addRow(new Object[]{p.getDNI(),p.getNombre(),p.getTlf(),p.getEdad(),p.getCurso().getNombre(), "Sí"});
            }
        }
    }

    public void agregarCurso(Curso c){
        listaCursos.agregar(c);
        mostrarCursos();
    }
    public void eliminarCurso(String codigo){
        if (listaCursos.buscar(codigo) == null){
            JOptionPane.showMessageDialog(null,"El código del curso no ha sido encontrado","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            for (int i = 0;i<modeloC.getRowCount();i++){
                if (modeloC.getValueAt(i,0).equals(codigo)){
                    modeloC.removeRow(i);
                }
            }
            listaCursos.eliminar(listaCursos.buscar(codigo));
        }

    }

    public void buscarCurso(String codigo){
        if (listaCursos.buscar(codigo) == null){
            JOptionPane.showMessageDialog(null,"El código del curso no ha sido encontrado","Error",JOptionPane.ERROR_MESSAGE);
        }else {
            for (int i = modeloC.getRowCount() - 1; i >= 0; i--){
                if (!modeloC.getValueAt(i,0).equals(codigo)){
                    modeloC.removeRow(i);
                }
            }
        }
    }

    public void mostrarCursos(){
        modeloC.setNumRows(0);
        for (Curso curso:listaCursos.getListaCursos()){
            modeloC.addRow(new Object[]{curso.getCodigo(),curso.getNombre()});
        }
    }

    public static void main(String[] args) {
        MenuPrincipal M=new MenuPrincipal();
    }
}
