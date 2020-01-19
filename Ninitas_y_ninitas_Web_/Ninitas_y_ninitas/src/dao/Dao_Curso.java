package dao;

import dato.Dato_Conexion_SQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao_Curso {

    public static void main(String[] args) throws SQLException {
        Dao_Curso a = new Dao_Curso();
            System.out.println(a.select_aulas_profesor("P001"));
        }
        
    
    Dato_Conexion_SQL cn = new Dato_Conexion_SQL();
    ResultSet rs ;
    String ultimo;
    int posi = 1;
    
    public String select_aulas_profesor(String cod){
        try{
            String cadena  = "";
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_aulas_profesor ?");
            ps.setString(1, cod);
            rs = ps.executeQuery();
            while(rs.next()){
                cadena = cadena + "<option value="+rs.getString(1)+rs.getString(2)+rs.getString(8)+">"
                        +rs.getString(3)+" " 
                        +rs.getString(4)+" - "  
                        +rs.getString(5)+" - "  
                        +rs.getString(6)+" - "  
                        +rs.getString(7) +"</a></option>";}
             return cadena;}
        catch(SQLException e){return "";}}
    
    public ResultSet selec_listar_Curso(String cod){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_curso_alumno ?");
            ps.setString(1, cod);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}

    public ResultSet selec_evaluaciones_alumno(String cod){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_evaluacion ?");
            ps.setString(1, cod);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}
    
}
