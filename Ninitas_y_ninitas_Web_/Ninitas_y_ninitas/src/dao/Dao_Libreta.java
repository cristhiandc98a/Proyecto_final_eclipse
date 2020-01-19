/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dato.Dato_Conexion_SQL;
import entidad.Ent_Actividades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 * @author cristhiandc98
 */

public class Dao_Libreta {
    
    public String libreta;
    public int num_curso_aula;
    public String aula;
    public int num_activ;
    public String estado;
    public String nota;
    public String fecha;
    public String contenido;
    
    public Dao_Libreta(){
        
    }
    public static void main(String[] args) {
        Dao_Libreta a = new Dao_Libreta("MT01","L001", 1,  "2020-11-10", "Sssssss");
        JOptionPane
                .showMessageDialog(null, a.insert_asistencia_curso(a));
    }
    public Dao_Libreta(String libreta,int num_curso_aula,
            String aula, int num_activ, String estado, String nota){
        this.libreta = libreta;
        this.num_curso_aula = num_curso_aula;
        this.aula = aula;
        this.num_activ = num_activ;
        this.estado = estado;
        this.nota = nota;}
    
    public Dao_Libreta(String libreta, String aula,
            int num_curso_aula,String fecha,String contenido){
        this.libreta = libreta;
        this.num_curso_aula = num_curso_aula;
        this.aula = aula;
        this.contenido=contenido;
        this.fecha = fecha;}
    
    public Dao_Libreta(String libreta, int ac,
            int num_curso_aula,String fecha,String contenido){
        this.libreta = libreta;
        this.num_curso_aula = num_curso_aula;
        this.num_activ = ac;
        this.contenido=contenido;
        this.fecha = fecha;}
    
    Dato_Conexion_SQL cn = new Dato_Conexion_SQL();
    ResultSet rs;
    
    public String pintador_notas_final(String curso,int n1,int n2,int n3){
        try{
            int n4 = (int) (n1 + n2 + n3) / 3;
        return "<tr><td>"+curso+"</td><td>"+n1+"</td><td>"+n2+"</td><td>"+n3+"</td><td>"+n4+"</td></tr>";
        }
        catch(Exception e){
            return "";}}
    
    public ResultSet select_tareas_trim_alum(String alu, int ntrim,String cur){
        try{
            String trim = "T"+ntrim;
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_notas_tare ?,?,?");
            ps.setString(1, alu);
            ps.setString(2, cur);
            ps.setString(3, trim);
            return ps.executeQuery();}
        catch(SQLException e){
            return null;}}
    
    public ResultSet select_evaluaciones_trim_alum(String alu, int ntrim,String cur){
        try{
            String trim = "T"+ntrim;
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_notas_evaluacion ?,?,?");
            ps.setString(1, alu);
            ps.setString(2, cur);
            ps.setString(3, trim);
            return ps.executeQuery();}
        catch(SQLException e){
            return null;}}
    
    public String pintador_notas_tr(String mtr,String curso,String trim,String nomCurso){
        try{
            int nota_tarea = 0;
            int[] tresnotas = new int[4];
            byte numtdeador_eva = 1;
            String cadena  = "";
            
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_notas_tare ?,?,?");
            ps.setString(1, mtr);
            ps.setString(2,  curso);
            ps.setString(3, trim);
            rs = ps.executeQuery();
            byte dividir = 0;
            while(rs.next()){
                dividir ++;
                nota_tarea = nota_tarea + Integer.parseInt(rs.getString(1));}
            if(nota_tarea > 0){
                nota_tarea =(int) nota_tarea / dividir;}
            
            ps = cn.conectorDB().prepareStatement("select_notas_evaluacion ?,?,?");
            ps.setString(1, mtr);
            ps.setString(2,  curso);
            ps.setString(3, trim);
            rs = ps.executeQuery();
            while(rs.next()){
                numtdeador_eva++;
                tresnotas[(numtdeador_eva-2)] = Integer.parseInt(rs.getString(1));
                cadena = cadena + "<td>"+"<input type=text size=1 class="+ claseador(Integer.parseInt(rs.getString(1)))
                        +" value="+rs.getString(1)+" disabled>"+"</td>";}
            String tdeador = "";
            if(numtdeador_eva < 4){
                for (int i = numtdeador_eva; i <= 3; i++) {
                    tdeador = tdeador + "<td></td>";}
                if(dividir != 0){
                cadena = "<tr><td>"+nomCurso+"</td>" + cadena + tdeador +"<td><input type=text size=1 class="
                        + claseador(nota_tarea)+" value="+nota_tarea+" disabled></td><td></td></tr>";}
                else{
                    cadena = "<tr><td>"+nomCurso+"</td>" + cadena + tdeador +"<td></td><td></td></tr>";}}
            else{
                tresnotas[3] = (int) ((tresnotas[0] + tresnotas[1] + tresnotas[2] + nota_tarea) / 4);
                if(dividir != 0){
                    cadena = "<tr><td>"+nomCurso+"</td>" + cadena + tdeador +"<td><input type=text size=1 class="
                            + claseador(nota_tarea)+" value="+nota_tarea+" disabled></td><td>"
                            +"<input type=text size=1 class="+ claseador(tresnotas[3]) +" value="+tresnotas[3]
                            +" disabled></td></tr>";}
                else{
                    cadena = "<tr><td>"+nomCurso+"</td>" + cadena + tdeador +"<td></td><td>"
                            +"<input type=text size=1 class="+ claseador(tresnotas[3]) +" value="+tresnotas[3]
                            +" disabled></td></tr>";}}
             return cadena;}
        catch(SQLException e){JOptionPane.showMessageDialog(null, "Asdsasdasdasdas"); return "";}}
    
    public String claseador(int num){
        String coloreador = "";
        if(num < 11){
                    coloreador = "btn-danger";}
                else{
                    if(num > 10 && num < 14){
                    coloreador = "btn-warning";}
                    else{
                        coloreador = "btn-success";}}
        return coloreador;}    
    
    public int inser_nota(Dao_Libreta dl){
        try{
            int num_libreta = 0;
            PreparedStatement ps = cn.conectorDB().prepareStatement("ultimo_contador_libret ?");
            ps.setString(1, dl.libreta);
            rs = ps.executeQuery();
            while(rs.next()){
                num_libreta = rs.getInt(1);}
            num_libreta = num_libreta + 1;
                    
            ps = cn.conectorDB().prepareStatement("inser_nota ?,?,?,?,?,?,?");
            ps.setString(1, dl.libreta);    
            ps.setInt(2, num_libreta);
            ps.setInt(3, dl.num_curso_aula);
            ps.setString(4, dl.aula);
            ps.setInt(5, dl.num_activ);
            ps.setString(6, dl.estado);
            ps.setString(7, dl.nota);
            return ps.executeUpdate();}
        catch(SQLException e){return 0;}}
    
    public int inser_citacion(Dao_Libreta dl){
        try{
            int num_libreta = 0;
            PreparedStatement ps = cn.conectorDB().prepareStatement("numero_citacion_alumnoo ?");
            ps.setString(1, dl.aula);
            rs = ps.executeQuery();
            while(rs.next()){
                num_libreta = rs.getInt(1);}
            num_libreta = num_libreta + 1;
                 
            ps = cn.conectorDB().prepareStatement("insert_citacion ?,?,?,?,?,?");
            ps.setString(1, dl.libreta);
            ps.setInt(2, num_libreta);
            ps.setString(3, dl.aula);
            ps.setInt(4, dl.num_curso_aula);
            ps.setString(5, dl.fecha);
            ps.setString(6, dl.contenido);
            return ps.executeUpdate();}
        catch(SQLException e){return 0;}}
    
    public int insert_asistencia_curso(Dao_Libreta dl){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("insert_asistencia_curso ?,?,?,?,?");
            ps.setString(1, dl.libreta);
            ps.setInt(2, dl.num_curso_aula);
            ps.setString(3, dl.aula);
            ps.setString(4, dl.fecha);
            ps.setString(5, dl.contenido);
            return ps.executeUpdate();}
        catch(SQLException e){return 0;}}
    
    public String fechaActual(){
        Calendar cal= Calendar.getInstance();
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes= cal.get(Calendar.MONTH) + 1;
        int anio = cal.get(Calendar.YEAR);
        String dias = ""+dia,mess  = ""+mes, anios = ""+anio;
        if(dia < 10){
            dias = "0"+dia;}
        if(mes < 10){
            mess = "0"+mes;}
        String fechaStriniada = anios + "-" + mess + "-" + dias;
        return fechaStriniada;}
    
    public boolean select_si_asistio_clase_curs(String alu, int cur){
        try{
            boolean vf = false;
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_si_asistio_clase_curs ?,?");
            ps.setString(1, alu);
            ps.setInt(2, cur);
            rs = ps.executeQuery();
            while(rs.next()){
                if(fechaActual().equals(rs.getString(1))){
                    vf = true;}}
            return vf;}
        catch(SQLException e){
            return false;}}
    
     public int delete_si_asistio_clase_curso(String alu, String fech){
        try{
            boolean vf = false;
            PreparedStatement ps = cn.conectorDB().prepareStatement("delete_si_asistio_clase_curso ?,?");
            ps.setString(1, alu);
            ps.setString(2, fech);
            return ps.executeUpdate();}
        catch(SQLException e){
            return 0;}}
    
    
    
    
}
