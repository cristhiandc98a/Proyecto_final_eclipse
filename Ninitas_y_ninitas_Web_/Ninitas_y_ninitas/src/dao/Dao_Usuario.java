
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dato.Dato_Conexion_SQL;

public class Dao_Usuario {
    
    Dato_Conexion_SQL cn = new Dato_Conexion_SQL();
    ResultSet rs ;
    String ultimo;
    int posi = 0;
    
    public String ultimoUsuario(String pref){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_ultimo_usuario_alumno ?");
            ps.setString(1, pref);
            rs = ps.executeQuery();
            while(rs.next()){
                int ultPosi = Integer.parseInt(rs.getString(2));
                if(posi<= ultPosi){
                    posi = ultPosi;
                    ultimo = rs.getString(1);}}
            posi = 0;
            return ultimo;}
        catch(SQLException e){return "";}}
    
    public String ultimaContrasenia(){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_ultima_contrasenia");
            rs = ps.executeQuery();
            while(rs.next()){
                int ultPosi = Integer.parseInt(rs.getString(2));
                if(posi<= ultPosi){
                    posi = ultPosi;
                    ultimo = rs.getString(1);}}
            return ultimo;}
        catch(SQLException e){return "";}}
    
    public ResultSet select_verif_usuario(String usu,String pass){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_verif_usuario ?,?");
            ps.setString(1, usu);
            ps.setString(2, pass);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}
            
            
    
    public static void main(String[] args) {
        Dao_Usuario u = new Dao_Usuario();
    }
    
    
}
