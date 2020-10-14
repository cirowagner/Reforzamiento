package maintenance;

import entities.Person;
import connection.ConnectionSQLite;
import utils.BufferedZ;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
    
public class MPerson extends ConnectionSQLite{

    BufferedZ keyboard = new BufferedZ();
    ResultSet rs = null;
    Statement stmt = null;
    Connection conn = null;

    public void registryPerson (Person p) {
        String query = "INSERT INTO people(id, name, fatherln, motherln, sex, mail, direction, dni)" +
                " VALUES ('"+p.getS_id()+"', '"+p.getS_name()+"', '"+p.getS_FatherLN()+"', '"+p.getS_MotherLN()+""+
                "', '"+p.getS_sex()+"','"+p.getS_mail()+"','"+p.getS_direction()+"','"+p.getS_dni()+"')";
        try {
            stmt = connect().createStatement();
            stmt.executeUpdate(query);
            System.out.println("This is the query: "+query);
            System.out.println("|> Successfully registered 100%");
            System.out.println();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public ResultSet toList (String nameTable){
        String consult = "SELECT * FROM "+nameTable+"";
         try{
             stmt = connect().createStatement();
             rs = stmt.executeQuery(consult);
             System.out.println("ID \t NAME \t FATHERLN \t MOTHERLN \t SEX \t MAIL \t DIRECTION \t DNI");
            while (rs.next()){
                System.out.println(rs.getInt("ID")+"\t"+rs.getString("NAME")+"\t"+rs.getString("FATHERLN")+
                        "\t"+rs.getString("MOTHERLN")+"\t"+rs.getString("SEX")+"\t"+rs.getString("MAIL")+
                        "\t"+rs.getString("DIRECTION")+"\t"+rs.getInt("DNI"));
            }
            rs.close();
            stmt.close();

         }catch (Exception e){
             System.out.println("Error"+e.getMessage());
         }
         return rs;
    }

    public void updatePerson (String nameTableUp, int id)throws SQLException {
        stmt = connect().createStatement();
        String consult = "SELECT * FROM "+nameTableUp+" WHERE ID = "+id+"";
        char finish = ' ';
        do {
            rs = stmt.executeQuery(consult);
                rs.next();
                String nameColumn = keyboard.read("", "Ingrese el nombre de la columna");
                String newValue = keyboard.read("", "Ingrese el nuevo valor");
                String updateP = "UPDATE " + nameTableUp + " SET " + nameColumn + " = '" + newValue + "' WHERE ID ='" + id + "'";
                try {
                    stmt.executeUpdate(updateP);
                    conn.commit();
                } catch (Exception e) {
                    System.out.println("Error <> :" + e.getMessage());
                }
            System.out.println("N : no || S: si");
            finish = keyboard.read(" ","¿Quieres terminar el proceso?").toUpperCase().charAt(0);
        }while (finish == 'N');
        stmt.close();
    }
    public void deleteP (String nameTableR, int idr)throws SQLException{
        String consult = "DELETE FROM "+nameTableR+" WHERE ID = "+idr+"";
        try {
            stmt = connect().createStatement();
            stmt.executeUpdate(consult);
        }catch (SQLException e){
            System.out.println("Error :"+e.getMessage());
        }
        stmt.close();
    }
}
