package connexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection getConnection() throws Exception
    {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/voiture?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC","root","password");
             return con;
    }
    
}
