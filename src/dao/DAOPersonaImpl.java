package dao;

import java.sql.*;
import java.util.*;
import entidades.Persona;
import interfaces.DAOPersona;

public class DAOPersonaImpl extends Conexion implements DAOPersona{

    @Override
    public void registrar(Persona p) throws Exception {
        try{
            PreparedStatement pstmt = connect().prepareStatement("INSERT INTO persona (NOMBRE, ApPATERNO, ApMATERNO, FECHAN, SEXO, DIRECCION, TELEFONO, CORREO, DNI) VALUES " +
                    "(?,?,?,?,?,?,?,?,?)");
            pstmt.setString(1, p.getNombre());
            pstmt.setString(2, p.getAp_Paterno());
            pstmt.setString(3, p.getAp_Materno());
            pstmt.setString(4, p.getF_Nacimiento());
            pstmt.setString(5, p.getSexo());
            pstmt.setString(6, p.getDirection());
            pstmt.setInt(7, p.getTelefono());
            pstmt.setString(8, p.getCorreo());
            pstmt.setString(9, p.getDni());
            pstmt.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Persona> listar() throws Exception {
        List<Persona> lista;
        try{
            PreparedStatement pstmt = connect().prepareStatement("SELECT * FROM persona");
            lista = new ArrayList<>();
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                Persona p = new Persona();
                p.setId(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setAp_Paterno(rs.getString(3));
                p.setAp_Materno(rs.getString(4));
                p.setF_Nacimiento(rs.getString(5));
                p.setSexo(rs.getString(6));
                p.setDirection(rs.getString(7));
                p.setTelefono(rs.getInt(8));
                p.setCorreo(rs.getString(9));
                p.setDni(rs.getString(10));
                lista.add(p);
            }
        }catch (Exception e){
            throw e;
        }
        return lista;
    }

    @Override
    public void actualizar(Persona p) throws Exception {
        try{
            PreparedStatement pstmt = connect().prepareStatement("UPDATE persona SET ? = ? WHERE ID = ?");
            //...
            pstmt.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void eliminar(Persona prod) throws Exception {
        try{
            PreparedStatement pstmt = connect().prepareStatement("DELETE FROM persona WHERE ID = ?");
            //...
            pstmt.executeUpdate();
        }catch (Exception e){
            throw e;
        }
    }
}