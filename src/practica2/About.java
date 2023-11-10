package practica2;

import javax.swing.*;

public class About extends JDialog {
    private JPanel panel1;
    public About(MenuPrincipal parent,boolean modal){
        super(parent,modal);

        setContentPane(panel1);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(500,500,500,500);
    }
}
