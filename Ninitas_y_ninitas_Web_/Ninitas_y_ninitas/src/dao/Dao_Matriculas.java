package dao;

import dato.Dato_Conexion_SQL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import entidad.Ent_Alumno;
import entidad.Ent_Apoderado;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Dao_Matriculas {
    
    Dao_Codigoneador cd = new Dao_Codigoneador();
    Dato_Conexion_SQL cn = new Dato_Conexion_SQL();     
    
    public String select_ult_cd(){
        try{
            String cod="";
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_ult_cd");
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                cod = rs.getString(1);}
            return cod;}
        catch(SQLException e){
            return  "";}}
    
    
    public int insert_new_alumno_apoderado(Ent_Alumno a,Ent_Apoderado t){
        try{
            PreparedStatement ps = 
                    cn.conectorDB().prepareStatement(
                            "insert_new_alumno_apoderado ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
                ps.setString(1, a.codMtr);ps.setString(11, a.perDir);
                ps.setString(2, a.perCod);ps.setString(12, a.usuUsu);
                ps.setInt(3, a.anio);     ps.setString(13, a.usuCla);
                ps.setString(4, a.perPat);ps.setString(14, t.perCod);
                ps.setString(5, a.perMat);ps.setString(15, t.perPat);
                ps.setString(6, a.perNom);ps.setString(16, t.perMat);
                ps.setString(7, a.fechNaci);ps.setString(17, t.perNom);
                ps.setString(8, a.perDni);ps.setString(18, t.fechNaci);
                ps.setString(9, a.perTel);ps.setString(19, t.perDni);
                ps.setString(10, a.perSex);ps.setString(20, t.perSex);
                ps.setString(21, cd.autoincrementador(select_ult_cd(), 1));
            return ps.executeUpdate();}
        catch(Exception e){return 0;}}
    
        public int insert_new_alumno_antiguo_apoderado(Ent_Alumno a,Ent_Apoderado t){
        try{
            PreparedStatement ps = 
                    cn.conectorDB().prepareStatement(
                            "insert_new_alumno_antiguo_apoderado ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?");
                ps.setString(1, a.codMtr);ps.setString(11, a.perDir);
                ps.setString(2, a.perCod);ps.setString(12, a.usuUsu);
                ps.setInt(3, a.anio);     ps.setString(13, a.usuCla);
                ps.setString(4, a.perPat);ps.setString(14, t.perCod);
                ps.setString(5, a.perMat);ps.setString(10, a.perSex); 
                ps.setString(6, a.perNom);ps.setString(9, a.perTel);
                ps.setString(7, a.fechNaci);ps.setString(8, a.perDni);
                ps.setString(15, cd.autoincrementador(select_ult_cd(), 1));
            return ps.executeUpdate();}
        catch(Exception e){return 0;}}
    
    public static void main(String[] args) {
        Dao_Matriculas m = new Dao_Matriculas();
        Ent_Alumno a = new Ent_Alumno("A021", 2020, "chauca", "casoa", "Yolanda", 
                "1990-02-03", "12345678", "123456789", "F", "Siempre viva 123",
                "Alumna11", "U700", "MT05");
        Ent_Apoderado t = new Ent_Apoderado("T003","fg");
        System.out.println(m.insert_new_alumno_antiguo_apoderado(a,t));} 
}
