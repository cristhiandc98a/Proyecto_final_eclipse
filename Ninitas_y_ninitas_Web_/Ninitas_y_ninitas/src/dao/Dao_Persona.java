/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dato.Dato_Conexion_SQL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author cristhiandc98
 */
public class Dao_Persona {
    
    Dato_Conexion_SQL cn = new Dato_Conexion_SQL();
    ResultSet rs ;
    String ultimo;
    int posi = 0;
    
    public String ultimoCodigoPersona(String pref){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_ultimo_cod_persona ?");
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
    public static void main(String[] args) {
        Dao_Persona u = new Dao_Persona();
        System.out.println(u.ultimoCodigoPersona("T"));
    }
}
