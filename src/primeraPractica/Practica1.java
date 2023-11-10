package primeraPractica;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Practica1 extends JFrame {


    private JPanel panel1;
    private JButton norte1Button;
    private JButton norte2Button;
    private JButton norte3Button;
    private JButton centro1Button;
    private JButton centro2Button;
    private JButton centro3Button;
    private JLabel res;
    private JButton limipiarLabelButton;
    private JCheckBox borrarCheckBox;
    private JRadioButton salirRadioButton;
    private JRadioButton borrarRadioButton;
    private JComboBox comboBox1;
    private JLabel textoCombo;

    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem menuItem1, menuItem2, menuItem3;

    public Practica1(){

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu = new JMenu("Opciones");
        menuBar.add(menu);

        menuItem1=new JMenuItem("Borrar");
        menu.add(menuItem1);
        menuItem2=new JMenuItem("Volver");
        menu.add(menuItem2);
        menuItem3=new JMenuItem("Salir");
        menu.add(menuItem3);



        setContentPane(panel1);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(300,300,500,250);

        norte1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Has pulsado el norte. Cuidado, mira detrás","PELIGRO",JOptionPane.WARNING_MESSAGE);
                panel1.requestFocus();
            }
        });
        norte2Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                norte2Button.setText("Central");
                panel1.requestFocus();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                norte2Button.setText("Norte 2");
                panel1.requestFocus();

            }
        });
        norte3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Has pulsado Opción 3","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        });
        centro1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                res.setText("1");
                panel1.requestFocus();
            }
        });
        centro2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                res.setText("2");
                panel1.requestFocus();
            }
        });
        centro3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                res.setText("3");
                panel1.requestFocus();
            }
        });

//        res.setFocusable(true);
//        res.requestFocusInWindow();

        panel1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (String.valueOf(e.getKeyChar()).equals("1")||String.valueOf(e.getKeyChar()).equals("2")||String.valueOf(e.getKeyChar()).equals("3")){
                    res.setText(String.valueOf(e.getKeyChar()));
                } else if (String.valueOf(e.getKeyChar()).equals("c")){
                    res.setText(" ");
                }
            }
        });
        centro1Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                centro1Button.setBackground(Color.blue);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                centro1Button.setBackground(Color.white);            }
        });


        centro2Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                centro2Button.setBackground(Color.red);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                centro2Button.setBackground(Color.white);
            }
        });
        centro3Button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                super.mouseEntered(e);centro3Button.setBackground(Color.yellow);


            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                super.mouseEntered(e);centro3Button.setBackground(Color.white);

            }
        });
        limipiarLabelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                res.setText(" ");
                panel1.requestFocus();
            }
        });
        norte2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == norte2Button){
                    Ventana2 ventanaSecundaria = new Ventana2(Practica1.this,true);
                    ventanaSecundaria.setVisible(true);

                }
            }
        });

        comboBox1.addItem("Saludo");
        comboBox1.addItem("Despedida");
        comboBox1.addItem("Tarde");

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getSource() == comboBox1){
                    String seleccionado = (String) comboBox1.getSelectedItem();
                    if (seleccionado == "Saludo"){
                        textoCombo.setText("Hola");
                    } else if (seleccionado == "Despedida") {
                        textoCombo.setText("Adios");
                    } else if (seleccionado == "Tarde") {
                        textoCombo.setText("Buenas tardes");
                    }

                }
            }
        });

        norte3Button.setBorder(new RoundedBorder(10));
    }

    public class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius){this.radius = radius;}

        public Insets getBorderInsets(Component c){
            return new Insets(this.radius+1,this.radius+1,this.radius+2,this.radius);
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }

        public boolean inBorderOpaque(){return true;}

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
            g.drawRoundRect(x,y,width-1,height-1,radius,radius);
        }
    }




}
