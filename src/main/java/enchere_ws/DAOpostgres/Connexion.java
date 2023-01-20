package enchere_ws.DAOpostgres;
import java.sql.*;
import java.lang.*;

public class Connexion{
    Connection con;

    public Connection SeConnecter(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/enchere","enchere","enchere");
        } catch(Exception e){ 
            System.out.println(e); 
        }
        return con;
    }

    public void fermer() throws SQLException{
        con.close();
    }

    public Connection getCon(){
        return con;
    }

}