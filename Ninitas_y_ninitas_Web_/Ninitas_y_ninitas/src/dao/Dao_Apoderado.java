package dao;

import dato.Dato_Conexion_SQL;
import entidad.Ent_Alumno;
import entidad.Ent_Apoderado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao_Apoderado {
    
    Dato_Conexion_SQL cn = new Dato_Conexion_SQL();
    int anio = 0;
    Ent_Apoderado apo = null;
    
    public Ent_Apoderado datosApoderado(String dni) throws Exception{
        
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_tut_Xdni ?");
            ps.setString(1, dni);

            ResultSet rs = ps.executeQuery();  
            if(rs.next()){
                if(anio <= rs.getInt(2)){
                 apo = new Ent_Apoderado(
                        rs.getString(1).toUpperCase(),
                        rs.getInt(2),
                        rs.getString(3).toUpperCase(),
                        rs.getString(4).toUpperCase(),
                        rs.getString(5).toUpperCase(),
                        rs.getString(6).toUpperCase(),
                        rs.getString(7).toUpperCase(),
                        rs.getString(8).toUpperCase(),
                        rs.getString(9).toUpperCase(),
                        rs.getString(10).toUpperCase());}
                anio = rs.getInt(2);}
            rs.close();
            ps.close();
            return apo;}
        catch(Exception e){return null;}}
    public static void main(String[] args) throws Exception {
        Dao_Apoderado da = new Dao_Apoderado();
        Ent_Apoderado rs  =  da.datosApoderado("12345675");
        System.out.println(rs.perCod);}
}
