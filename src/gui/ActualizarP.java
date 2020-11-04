package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarP {
    public static void main(String[] args) {
        Update p = new Update();
        p.setVisible(true);
        p.setLocationRelativeTo(null);
    }
}

class Update extends JFrame implements ActionListener {

    private JLabel lbTitle, lb1,lb2, lb3;
    private JTextField tf1, tf2, tf3;
    private JButton bt1;

    public Update(){
        this.setSize(370,300);
        initComponents();
    }

    public void initComponents(){
        JPanel pnl = new JPanel();
        pnl.setLayout(null);
        this.getContentPane().add(pnl);

        lbTitle = new JLabel("Actualizar Registro",SwingConstants.CENTER);
        lbTitle.setBounds(100,25,180,25);
        pnl.add(lbTitle);

        lb1 = new JLabel("Nombre de la columna:");
        lb1.setBounds(20,80,150,20);
        pnl.add(lb1);

        lb2 = new JLabel("Numero de fila");
        lb2.setBounds(20,110,150,20);
        pnl.add(lb2);

        lb3 = new JLabel("Nuevo valor:");
        lb3.setBounds(20,140,150,20);
        pnl.add(lb3);

        tf1 = new JTextField();
        tf1.setBounds(180,80,150,20);
        pnl.add(tf1);

        tf2 = new JTextField();
        tf2.setBounds(180,110,150,20);
        pnl.add(tf2);

        tf3 = new JTextField();
        tf3.setBounds(180,140,150,20);
        pnl.add(tf3);

        bt1 = new JButton("Enviar");
        bt1.setBounds(130,190,70,25);
        pnl.add(bt1);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt1){
            setNameColumna(tf1.getText());
        }
    }
    private String nameColumna;
    private String nuevoValor;
    private int id;

    public String getNameColumna() {
        return nameColumna;
    }

    public void setNameColumna(String nameColumna) {
        this.nameColumna = nameColumna;
    }

    public String getNuevoValor() {
        return nuevoValor;
    }

    public void setNuevoValor(String nuevoValor) {
        this.nuevoValor = nuevoValor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
