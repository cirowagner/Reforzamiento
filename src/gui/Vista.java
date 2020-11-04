package gui;

import entidades.Persona;
import dao.DAOPersonaImpl;
import interfaces.DAOPersona;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.awt.*;

import java.util.List;

public class Vista {
    public static void main(String[] args) {
        Vistas go = new Vistas();
        go.setVisible(true);
        new Controlador(go);

    }
}

class Vistas extends JFrame {

    JTable tabla;
    JButton btn;
    JPanel pl2, pltable;
    JScrollPane scroll;

    public Vistas() {
        setSize(950, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tabla = new JTable();
        scroll = new JScrollPane(tabla);
        //pltable = new JPanel();
        //pltable.setBorder(BorderFactory.createTitledBorder("Tabla"));
        //pltable.add(scroll);
        scroll.invalidate();
        scroll.validate();
        scroll.repaint();
        add(scroll,BorderLayout.CENTER);
        tabla.setModel(new DefaultTableModel(new Object [][] {
        },
        new String [] {
                "ID", "NOMBRE", "ApPATERNO", "ApMATERNO", "FECHA NACIMIENTO", "SEX0", "DIRECCIÓN", "TELÉFONO", "CORREO", "DNI"
        }
        ));
        validate();

        pl2 = new JPanel();
        pl2.setBorder(BorderFactory.createTitledBorder("Componentes"));

        btn = new JButton("Listar");
        pl2.add(btn);
        add(pl2, BorderLayout.NORTH);
    }
}
    class Controlador implements ActionListener{

        Vistas vistas ;
        DAOPersona daoP = new DAOPersonaImpl();
        DefaultTableModel modelo = new DefaultTableModel();

        public Controlador (Vistas v){
            this.vistas = v;
            this.vistas.btn.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == vistas.btn){
                listar(vistas.tabla);
                vistas.btn.setText("Actualizar");
            }
        }

        public void listar (JTable tabla){
            modelo  = (DefaultTableModel)tabla.getModel();
            try {
                List<Persona> lista = daoP.listar();
                Object[] objects = new Object[10];
                for (int i = 0; i < lista.size(); i++) {
                    objects[0] = lista.get(i).getId();
                    objects[1] = lista.get(i).getNombre();
                    objects[2] = lista.get(i).getAp_Paterno();
                    objects[3] = lista.get(i).getAp_Materno();
                    objects[4] = lista.get(i).getF_Nacimiento();
                    objects[5] = lista.get(i).getSexo();
                    objects[6] = lista.get(i).getDirection();
                    objects[7] = lista.get(i).getTelefono();
                    objects[8] = lista.get(i).getCorreo();
                    objects[9] = lista.get(i).getDni();
                    modelo.addRow(objects);
                }
                vistas.tabla.setModel(modelo);
            }catch (Exception er){
            }
        }
    }