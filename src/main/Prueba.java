package main;

import dao.Conexion;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;

public class Prueba extends JFrame{

    private Conexion cn = new Conexion();
    private ResultSet rs;
    private DatabaseMetaData datosMdt;
    private Statement stmt;


    private JComboBox nameTable;

    public Prueba(){
        setSize(650,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel superior = new JPanel();
        superior.setBorder(BorderFactory.createTitledBorder("Layout North"));

        nameTable = new JComboBox();

        try {
            datosMdt = cn.connect().getMetaData();
            rs = datosMdt.getTables(null, null, null, null);

            while (rs.next()) {
                nameTable.addItem(rs.getString("TABLE_NAME"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        nameTable.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tablaSelect = (String) nameTable.getSelectedItem();
                try {
                    stmt = cn.connect().createStatement();
                    rs = stmt.executeQuery("SELECT * FROM "+tablaSelect);

                    ConstruirTabla modelo = new ConstruirTabla(rs);
                    JTable tablaF = new JTable(modelo);
                    JScrollPane scroll = new JScrollPane(tablaF);
                    add(scroll, BorderLayout.CENTER);
                    validate();
                }catch (Exception er){
                    er.printStackTrace();
                }
            }
        });
        superior.add(nameTable);
        add(superior, BorderLayout.NORTH);
    }
}

class ConstruirTabla extends AbstractTableModel {
    private ResultSet rsRegistro;
    private ResultSetMetaData rsmtds;

    public ConstruirTabla(ResultSet unResultSet){
        this.rsRegistro = unResultSet;
        try{
            rsmtds = rsRegistro.getMetaData();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public int getColumnCount() {
        try {
            return rsmtds.getColumnCount();
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
    @Override
    public int getRowCount() {
        try {
            rsRegistro.last();
            return rsRegistro.getRow();
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            rsRegistro.absolute(rowIndex + 1);
            return rsRegistro.getObject(columnIndex + 1);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public String getColumnName(int c){
        try {
            return rsmtds.getColumnName(c+1);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
