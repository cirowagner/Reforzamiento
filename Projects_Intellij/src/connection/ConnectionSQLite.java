package connection;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;   

public class ConnectionSQLite {

    public Connection connect(){
        Connection conn = null;

        try{
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:D:\\PruebaSQLite\\database\\MyThirdDB.db";
            if (conn == null){
                conn = DriverManager.getConnection(url);
                System.out.println("Imprinted conn: "+conn);
                System.out.println("Connection to SQLite has been established.");
            }else{
                System.out.println("There is still a connection ");
            }

        }catch (SQLException | ClassNotFoundException e){
            System.out.println("Error : "+e.getMessage());
        }

        return conn;
    }

}
