
package dao;

import dato.Dato_Conexion_SQL;
import entidad.Ent_Alumno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Dao_Alumno {
   
    public Dao_Alumno(){}
    
    Dato_Conexion_SQL cn = new Dato_Conexion_SQL();
    int anio = 0;
    Ent_Alumno alu = null;
    
    public Ent_Alumno datosAlumnoDni(String dni) throws Exception{
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_alumno_Xdni ?");
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(anio <= rs.getInt(2)){
                 alu = new Ent_Alumno(
                        rs.getString(1).toUpperCase(),
                        rs.getInt(2),
                        rs.getString(3).toUpperCase(),
                        rs.getString(4).toUpperCase(),
                        rs.getString(5).toUpperCase(),
                        rs.getString(6).toUpperCase(),
                        rs.getString(7).toUpperCase(),
                        rs.getString(8).toUpperCase(),
                        rs.getString(9).toUpperCase(),
                        rs.getString(10).toUpperCase(), 
                        rs.getString(11).toUpperCase(),
                        rs.getString(12).toUpperCase(),
                        rs.getString(13).toUpperCase());}
                anio = rs.getInt(2);}
            rs.close();
            ps.close();
            return alu;}
        catch(SQLException e){return null;}}

    public Ent_Alumno datosAlumnoCod(String cod) throws Exception{
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_alumno_Xcod ?");
            ps.setString(1, cod);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                if(anio <= rs.getInt(2)){
                     alu = new Ent_Alumno(
                            rs.getString(1).toUpperCase(),
                            rs.getInt(2),
                            rs.getString(3).toUpperCase(),
                            rs.getString(4).toUpperCase(),
                            rs.getString(5).toUpperCase(),
                            rs.getString(6).toUpperCase(),
                            rs.getString(7).toUpperCase(),
                            rs.getString(8).toUpperCase(),
                            rs.getString(9).toUpperCase(),
                            rs.getString(10).toUpperCase(), 
                            rs.getString(11).toUpperCase(),
                            rs.getString(12).toUpperCase(),
                            rs.getString(13).toUpperCase());}
                anio = rs.getInt(2);}
            rs.close();
            ps.close();
            return alu;}
        catch(SQLException e){return null;}}    
    
     public static void main(String[] args) throws Exception {
        
         Dao_Alumno a = new Dao_Alumno();
         Ent_Alumno rs = a.datosAlumnoCod("A001");
         System.out.println(rs.fechNaci.substring(0, 4));
         
    }
    
    
    
}
