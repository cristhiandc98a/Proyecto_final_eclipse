/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dato.Dato_Conexion_SQL;
import javax.swing.JOptionPane;
/**
 *
 * @author cristhiandc98
 */
public class Dao_Aula {
    
    Dato_Conexion_SQL cn = new Dato_Conexion_SQL();
    ResultSet rs;
    String pintador = "";
    
    public static void main(String[] args) throws SQLException {
        Dao_Aula a = new Dao_Aula();
        a.rs = a.select_alumnos_aul("L001", "PC01");
        while(a.rs.next()){
            System.out.println(a.rs.getString(3) + "  ");
        }
            
    }
    
    public ResultSet select_alumnos_aul(String aula,String pc){
    try{
        PreparedStatement ps = cn.conectorDB().prepareStatement("select_alumnos_aul ?,?");
        ps.setString(1, aula);
        ps.setString(2, pc);
        return ps.executeQuery();}
    catch(SQLException e){return null;}} 
    
    public String select_alumnos_aulXNum(String aula,String pc, int num){
    try{
        int cont = 1;
        String cod = "";
        PreparedStatement ps = cn.conectorDB().prepareStatement("select_alumnos_aul ?,?");
        ps.setString(1, aula);
        ps.setString(2, pc);
        rs = ps.executeQuery();
        while(rs.next()){
            if(num == cont){
                cod = rs.getString(6);}
            cont++;}
        return cod;}
    catch(SQLException e){return "";}} 
    
    public String citacion_porNumero_alumnos_aula(String aula,String pc,int numa){
    try{
        int num = 1;
        String libreta = "";
        PreparedStatement ps = cn.conectorDB().prepareStatement("select_alumnos_aul ?,?");
        ps.setString(1, aula);
        ps.setString(2, pc);
        rs = ps.executeQuery();
        while(rs.next()){
            if(num == numa){
                libreta = rs.getString(5);}
                num ++;}
        return libreta;}
    catch(SQLException e){return "";}}
    
    public String libreta_porNumero_alumnos_aula(String aula,String pc,int numa){
    try{
        int num = 1;
        String libreta = "";
        PreparedStatement ps = cn.conectorDB().prepareStatement("select_alumnos_aul ?,?");
        ps.setString(1, aula);
        ps.setString(2, pc);
        rs = ps.executeQuery();
        while(rs.next()){
            if(num == numa){
                libreta = rs.getString(4);}
            num++;}
        return libreta;}
    catch(SQLException e){return "";}}
    
    public int numero_alumnos_aula(String aula,String pc){
    try{
        int num = 0;
        PreparedStatement ps = cn.conectorDB().prepareStatement("select_alumnos_aul ?,?");
        ps.setString(1, aula);
        ps.setString(2, pc);
        rs = ps.executeQuery();
        while(rs.next()){
            num++;}
        return num;}
    catch(SQLException e){return 0;}}
    
    public String pintadorAlumnos(String pat,String mat,String nom,String lib,int numa){
        pintador = "<tr><td>"+numa+"<td><td>"+pat+" "
                +mat+" "+nom+" "+"</td><td><input type=text name=txt_"+lib+">"
                + "</td><td><input type=submit name="+numa+" value=calificar></td></tr>";
        return pintador;}
    
    public String pintadorAlumnosMNP(String pat,String mat,String nom,String lib,int numa){
        pintador = "<tr><td>"+numa+"<td><td>"+pat+" "
                +mat+" "+nom+" "+"</td></tr>";
        return pintador;}
    
    public String pintador_citaciones_Alumnos(String pat,String mat,String nom,String lib,int numa){
        pintador = "<tr><td>"+numa+"<td><td>"+pat+" "
                +mat+" "+nom+" "+"</td><td><input type=text name=txt_"+lib+">"
                + "</td><td><input type=submit name="+numa+" value=Enviar></td></tr>";
        return pintador;}
    
    public String pintador_asistencia_Alumnos(String pat,String mat,String nom,int numa,String alm, int curso){
        Dao_Libreta dl = new Dao_Libreta();
        String classs = "secondary";
        if(dl.select_si_asistio_clase_curs(alm, curso) == true){
            classs = "success";}
        pintador = "<tr><td>"+numa+".<td><td>"+pat+" "
                +mat+" "+nom+" "
                +"</td><td><input type=submit name="+numa+" class=btn-"+classs+" navbar-brand value=A ></td></tr>";
        return pintador;}
    
    public String pintador_calificaciones_Alumnos(String cod){
        try{
            int o  = 0;
            String recibidor = "g";
            String[] eva = new String[4];
            byte cont = -1;
            
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_evaluaciones ?");
            ps.setString(1, cod);
            rs = ps.executeQuery();
            while(rs.next()){
                cont++;
                eva[cont] = rs.getString(1);}
            if(cont < 4){
                for(o = (cont + 1);o < 4; o++){
                    eva[o] = "00";}}
            o = 0;
            ps = cn.conectorDB().prepareStatement("select_tareas ?");
            ps.setString(1, cod);
            rs = ps.executeQuery();
            while(rs.next()){
                o++;
                for(int y = 0; y < 4; y++){
                    if(Integer.parseInt(eva[y]) != o){
                        recibidor = recibidor + "<td>"+rs.getString(1)+"</td>";}
                    else{
                        recibidor = recibidor + "<td>"+eva[y]+"</td>";}}}
            pintador = "<tr>" + recibidor + "</tr>";
        return pintador;
    }catch(SQLException e){return "";}}
    
    public ResultSet select_tarea_especifica_alm(String lib){
    try{
        PreparedStatement ps = cn.conectorDB().prepareStatement("select_tarea_especifica_alm ?");
        ps.setString(1, lib);
        return ps.executeQuery();}
    catch(SQLException e){return null;}} 
    
    public int count_cant_filas(String aula, int cont, String trim){
    try{
        int x = 0;
        PreparedStatement ps = cn.conectorDB().prepareStatement("count_cant_filas ?,?,?");
        ps.setString(1, aula);
        ps.setInt(2, cont);
        ps.setString(3, trim);
        rs = ps.executeQuery();
        if(rs.next()){
            x = rs.getInt(1);}
        return x;}
    catch(SQLException e){return 0;}}
            
    public String select_cur_de_pccursod(String cur){
    try{
        String hola= "";
        PreparedStatement ps = cn.conectorDB().prepareStatement("select_cur_de_pccursod ?");
        ps.setString(1, cur);
        rs =ps.executeQuery();
        if(rs.next()){
            hola = rs.getString(1);}
        return hola;}
    catch(SQLException e){return "";}} 
    
    public String pintador_libretas_Alumnos(int cantAc,String pat,String mat,String nom,String lib,
            String mtr,String alm,int cont,String cur){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_notas_evaluacion ?,?,?");
            int[][] ev = new int[3][3];
            for(int u = 1; u <= 3; u++){
                for(int i = 1; i <= 3; i++){
                    ps.setString(1, alm);
                    ps.setString(2, cur);
                    ps.setString(3, "T"+i);
                    rs= ps.executeQuery();
                    while(rs.next()){
                        ev[u - 1][i-1] = rs.getInt(2);}}}
            ps = cn.conectorDB().prepareStatement("select_tarea_especifica_alm ?");
            ps.setString(1, lib);
            rs = ps.executeQuery();
            pintador = "<tr><td>"+cont+". </td><td>"+pat + " " + mat + " " + nom + "</td>";
            while(rs.next()){
                for(int u = 1; u <= 3; u++){
               if(rs.getInt(3) == ev[u][0] || rs.getInt(3) == ev[u][1] || rs.getInt(3) == ev[u][2]){
                   pintador = pintador + "<td class=\"btn btn-warning text-dark\">" + rs.getString(1) + "</td>";}
               else{
                   pintador = pintador + "<td>" + rs.getString(1) + "</td>";}}}
        pintador = pintador + "</td><tr>";
        return pintador;
    }catch(Exception e){return "";}}
    
    public String pintador_cabecera_libretas_Alumnos(int cantAc, String aula, int contAul){
        try{
            int tedeador = 0;
            int[] trims = new int[3];
            pintador = "<tr><td rowspan=2 colspan=2>Alumna</td>";
            for(int o = 0; o <= 2; o++){
                trims[o] = count_cant_filas(aula,contAul, "T"+(o+1));}
            if(trims[0] > 0){ pintador = pintador + "<td colspan="+trims[0]+">TRIM 1</td>"; }
            if(trims[1] > 0){ pintador = pintador + "<td colspan="+trims[1]+">TRIM 2</td>"; }
            if(trims[2] > 0){ pintador = pintador + "<td colspan="+trims[2]+">TRIM 3</td>"; }
            pintador = pintador + "</tr>";
            for(int i = 1; i <= cantAc; i++){
                pintador = pintador + "<td>"+i+"</td>";}
            pintador = pintador + "</tr>";
        return pintador;
    }catch(Exception e){return "";}}
    
    
    
    
    
    
    
    
    
    
    
    
}
