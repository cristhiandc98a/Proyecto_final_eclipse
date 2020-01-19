package dato;

import java.sql.DriverManager;
import java.sql.Connection;

public class Dato_Conexion_SQL {
    
    public Connection conectorDB(){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection cn=DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;database=Ninitas_y_ninitas",
                    "sa","admin1998");
            return cn;
        }catch(Exception e){return null;}}
    
    public static void main(String[] args) {
        Dato_Conexion_SQL a = new Dato_Conexion_SQL();
        
        
    }
}