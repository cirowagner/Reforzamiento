package gui;

import dao.DAOPersonaImpl;
import entidades.Persona;
import interfaces.DAOPersona;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegistroP extends JFrame implements ActionListener{

    private JLabel lbT, lb1, lb2, lb3, lb4, lb5, lb6, lb7, lb8, lb9;
    public JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9;
    private JButton bt1;

    public JPanel pl;

    public RegistroP (){
        this.setSize(450,620);
        setTitle("Registro de Persona");
        initComponent();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void initComponent(){
        insertarPanel();
        labels();
        textFields();
        buttons();
    }

    private void insertarPanel (){
        pl = new JPanel();
        pl.setLayout(null);
        labels();
        this.getContentPane().add(pl);
    }

    Font fuenteText = new Font("",Font.ITALIC,12);
    private void labels(){
        lbT = new JLabel("Registro de Persona", SwingConstants.CENTER);
        lbT.setFont(new Font("arial",Font.ITALIC,20));
        lbT.setBounds(110,30,200,25);
        pl.add(lbT);

        lb1 = new JLabel("Nombre :");
        lb1.setFont(fuenteText);
        lb1.setBounds(50,85,130,25);
        lb1.setOpaque(true);
        lb1.setBackground(Color.pink);
        pl.add(lb1);

        lb2 = new JLabel("Apellido Paterno :");
        lb2.setFont(fuenteText);
        lb2.setBounds(50,135,130,25);
        pl.add(lb2);

        lb3 = new JLabel("Apellido Materno :");
        lb3.setFont(fuenteText);
        lb3.setBounds(50,185,130,25);
        pl.add(lb3);

        lb4 = new JLabel("Fecha de Nacimiento :");
        lb4.setFont(fuenteText);
        lb4.setBounds(50,235,130,25);
        pl.add(lb4);

        lb5 = new JLabel("Sexo :");
        lb5.setFont(fuenteText);
        lb5.setBounds(50,285,130,25);
        pl.add(lb5);

        lb6 = new JLabel("Dirección :");
        lb6.setFont(fuenteText);
        lb6.setBounds(50,335,130,25);
        pl.add(lb6);

        lb7 = new JLabel("Teléfono :");
        lb7.setFont(fuenteText);
        lb7.setBounds(50,385,130,25);
        pl.add(lb7);

        lb8 = new JLabel("Correo :");
        lb8.setFont(fuenteText);
        lb8.setBounds(50,435,130,25);
        pl.add(lb8);

        lb9 = new JLabel("Doc.Identidad :");
        lb9.setFont(fuenteText);
        lb9.setBounds(50,485,130,25);
        pl.add(lb9);

    }
    public void textFields(){
        tf1 = new JTextField("Ziro Wagner");
        tf1.setBounds(190,85,170,25);
        pl.add(tf1);

        tf2 = new JTextField("Mamani");
        tf2.setBounds(190,135,170,25);
        pl.add(tf2);

        tf3 = new JTextField("Mamani");
        tf3.setBounds(190,185,170,25);
        pl.add(tf3);

        tf4 = new JTextField("18-03-2001");
        tf4.setBounds(190,235,170,25);
        pl.add(tf4);

        tf5 = new JTextField("M");
        tf5.setBounds(190,285,170,25);
        pl.add(tf5);

        tf6 = new JTextField("Jr.Manuel Z");
        tf6.setBounds(190,335,170,25);
        pl.add(tf6);

        tf7 = new JTextField("71984028");
        tf7.setBounds(190,385,170,25);
        pl.add(tf7);

        tf8 = new JTextField("cirot1813@gmail.com");
        tf8.setBounds(190,435,170,25);
        pl.add(tf8);

        tf9 = new JTextField("71984028");
        tf9.setBounds(190,485,170,25);
        pl.add(tf9);
    }
    private void buttons(){
        bt1 = new JButton("Enviar");
        bt1.setFont(fuenteText);
        bt1.setBounds(160,535,110,25);
        pl.add(bt1);
        bt1.addActionListener(this);
    }

    DAOPersona dao = new DAOPersonaImpl();
    Persona p = new Persona();
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == bt1){
           /* try {
                for (Persona l : dao.listar()) {
                    System.out.println(l.getNombre());
                }
            }catch (Exception er){
                System.out.println(er.getMessage());
            }*/

            /*try {
                p.setNombre(tf1.getText());
                p.setAp_Paterno(tf2.getText());
                p.setAp_Materno(tf3.getText());
                p.setF_Nacimiento(tf4.getText());
                p.setSexo(tf5.getText());
                p.setDirection(tf6.getText());
                p.setTelefono(Integer.parseInt(tf7.getText()));
                p.setCorreo(tf8.getText());
                p.setDni(Integer.parseInt(tf9.getText()));
                dao.registrar(p);
            }catch (Exception er){
                System.out.println(er.getMessage());
            }*/
        }
    }
}
