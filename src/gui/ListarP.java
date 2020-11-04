package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.*;
import entidades.Persona;
import interfaces.DAOPersona;

public class ListarP {
    public static void main(String[] args) {
        RegistrarPersona rp = new RegistrarPersona();
        rp.setVisible(true);
        rp.setLocationRelativeTo(null);
        rp.setResizable(false);
    }
}

class RegistrarPersona extends JFrame {

    private JLabel lbT;
    public JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;
    private JButton bt1;

    public RegistrarPersona(){
        setSize(400, 600);
        initComponent();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void initComponent(){
        JPanel panel = new JPanel(new GridLayout(9,2));
        lbT = new JLabel("REGISTRAR PERSONA");

        tf1 = new JTextField();
        tf2 = new JTextField();
        tf3 = new JTextField();
        tf4 = new JTextField();
        tf5 = new JTextField();
        tf6 = new JTextField();
        tf7 = new JTextField();
        tf8 = new JTextField();
        tf9 = new JTextField();

        panel.add(new JLabel("Nombre"));
        panel.add(tf1);
        panel.add(new JLabel("ApPaterno"));
        panel.add(tf2);
        panel.add(new JLabel("ApMaterno"));
        panel.add(tf3);
        panel.add(new JLabel("Fecha"));
        panel.add(tf4);
        panel.add(new JLabel("Sexo"));
        panel.add(tf5);
        panel.add(new JLabel("Dirección"));
        panel.add(tf6);
        panel.add(new JLabel("Teléfono"));
        panel.add(tf7);
        panel.add(new JLabel("Correo"));
        panel.add(tf8);
        panel.add(new JLabel("DNI"));
        panel.add(tf9);
        add(panel);

        JPanel panelBtn = new JPanel();
        bt1 = new JButton("Enviar");
        panelBtn.add(bt1);
        add(panelBtn,BorderLayout.NORTH);

        JPanel pnD = new JPanel();
        add(pnD, BorderLayout.EAST);

        JPanel pnI = new JPanel();
        add(pnI, BorderLayout.WEST);

        JPanel pnA = new JPanel();
        add(pnA, BorderLayout.SOUTH);

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Persona p = new Persona();
                DAOPersona dao = new DAOPersonaImpl();
                try {
                    p.setNombre(tf1.getText());
                    p.setAp_Paterno(tf2.getText());
                    p.setAp_Materno(tf3.getText());
                    p.setF_Nacimiento(tf4.getText());
                    p.setSexo(tf5.getText());
                    p.setDirection(tf6.getText());
                    p.setTelefono(Integer.parseInt(tf7.getText()));
                    p.setCorreo(tf8.getText());
                    p.setDni(tf9.getText());
                    dao.registrar(p);
                }catch (Exception er){
                }
            }
        });
    }
}
