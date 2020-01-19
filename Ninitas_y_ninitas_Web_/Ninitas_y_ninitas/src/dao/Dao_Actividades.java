package dao;

import dato.Dato_Conexion_SQL;
import entidad.Ent_Actividades;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Dao_Actividades {
    
    Calendar cal= Calendar.getInstance();
    Dato_Conexion_SQL cn = new Dato_Conexion_SQL();
    ResultSet rs ;
    String ultimo;
    int posi = 0;
    
    public static void main(String[] args) throws SQLException {
        
        Dao_Actividades a = new Dao_Actividades();
        
        System.out.println(a.delete_actividades("L001", 1, 17));
    }
    
    public int select_ultima_actividad_curso(String aula,int contCu){
        try{
            int s = 0;
            PreparedStatement ps = cn.conectorDB().prepareStatement("ultima_actividad_curso ?,?");
            ps.setString(1, aula);
            ps.setInt(2, contCu);
            rs =ps.executeQuery();
            while (rs.next()){
                s = rs.getInt(1);}
            return s;}
        catch(SQLException e){return 0;}}
    public ResultSet select_tareas_curso_alum(String codAlm,String codCu){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_tareas_curso_alum ?,?");
            ps.setString(1, codAlm);
            ps.setString(2, codCu);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}
    
    public String pintadorTareas_curso_alum(String ini,String sal,String cont,int top){
        String pintador  = "<div class=\"card\" style=\"background-color: rgba(255, 255,255, 0.7) !important; \n" +
"                border : solid 1px aqua;overflow : auto;\n" + //padding : 4px;
"                position: absolute; left: 30px; top: "+top+"px; width: 70rem;\">\n" +
"            <h6 class=\"card-title\" align=left>fecha inicio:"+ini+", fecha revision: "+ sal +"</h6>\n" +
"            <div class=\"card-body\" align=left>\n" +cont+"\n" +"</div></div>";
        return pintador;}
    
    
    public String coloreador(String fecha){
        String color = "k";
        int anio = Integer.parseInt(fecha.substring(0,4));
        int mes = Integer.parseInt(fecha.substring(5,7));
        int dia = Integer.parseInt(fecha.substring(8,10));
        int anioa = Integer.parseInt(fechaActual().substring(0,4));
        int mesa = Integer.parseInt(fechaActual().substring(5,7));
        int diaa = Integer.parseInt(fechaActual().substring(8,10));
        JOptionPane.showMessageDialog(null, diaa);
        int mm = mesa - mes;
        int dd = diaa - dia;
            if( anio < anioa ||  mm > 1 || anio == anioa && mm == 1 && diaa > 7 
                    || anio == anioa && mm == 0 && dd >= 7 ){
                color = "secondary";}
            else{
                if( anio == anioa && mm == 0 && dd <= 7 ){
                    color = "success";}}
        return color;}
    
    public String fechaActual(){
        int dia = cal.get(Calendar.DAY_OF_MONTH);
        int mes= cal.get(Calendar.MONTH);
        int anio = cal.get(Calendar.YEAR);
        String fechaStriniada = anio + "-" + mes + "-" + dia;
        return fechaStriniada;}
    
    public int insert_tareas(Ent_Actividades ea){
        try{
            int num__ac = 0;
            PreparedStatement ps = cn.conectorDB().prepareStatement("ultima_actividad_curso ?,?");
            ps.setString(1, ea.acAula);
            ps.setInt(2, ea.cont_cuAu);
            rs = ps.executeQuery();
            while(rs.next()){
                num__ac = rs.getInt(1);}
            num__ac = num__ac + 1;
            ps = cn.conectorDB().prepareStatement("insert_tareas ?,?,?,?,?,?,?");
            ps.setString(1, ea.acAula);
            ps.setInt(2, num__ac);
            ps.setInt(3, ea.cont_cuAu);
            ps.setString(4, ea.acIni);
            ps.setString(5, ea.acEntr);
            ps.setString(6, ea.acConte);
            ps.setString(7, ea.trim);
            return ps.executeUpdate();}
        catch(SQLException e){return 0;}}
    
    public ResultSet select_todas_actividades_del_curso(String aula,String prof){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_todas_actividades_del_cur ?,?");
            ps.setString(1, aula);
            ps.setString(2, prof);
            return ps.executeQuery();}
        catch(Exception e){return null;}}
    
    
    public ResultSet select_todas_tareas_alumno(String cod){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_todas_tareas_alu ?");
            ps.setString(1, cod);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}
    
    public ResultSet select_todas_ac(String cod){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_todas_actividade ?");
            ps.setString(1, cod);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}
    
    public ResultSet select_comparar_si_tarea_fue_hech(String cod, int ac){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_comparar_si_tarea_fue_hech ?,?");
            ps.setString(1, cod);
            ps.setInt(2, ac);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}
    
    public ResultSet select_comparar_si_evalu_fue_hech(String cod, int ac){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_comparar_si_evalu_fue_hech ?,?");
            ps.setString(1, cod);
            ps.setInt(2, ac);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}
    
    public ResultSet select_todas_citacioness_alumn(String cod){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_todas_citacioness_alumn ?");
            ps.setString(1, cod);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}    
    
    public ResultSet select_todas_citaciones_cur_alumn(String cod,String cur){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_todas_citaciones_cur_alumn ?,?");
            ps.setString(1, cod);
            ps.setString(2, cur);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}            
   
    public ResultSet select_actividad_especifi(String cur,int contCur){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_actividad_especifi ?,?");
            ps.setString(1, cur);
            ps.setInt(2, contCur);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}  
    
        public String pintadorCitaciones(String curso,String pat,String mat,String nom,String fech,String cont,int top){
            String pintador  = "<div class=\"card\" style=\"background-color: rgba(255, 255,255, 0.7) !important; \n" 
                    +"border : solid 1px aqua;overflow : auto;\n" //padding : 4px;
                    +"position: absolute; left: 30px; top: "+top+"px; width: 76rem;\">\n" 
                    +"<h6 class=\"card-title\" align=left>Profesor: "
                    +pat+" "+mat+" "+nom+", curso: "+curso+", fecha revision: "+ fech +"</h6>\n" 
                    +"<div class=\"card-body\" align=left>\n" +cont+"\n" +"</div></div>";
        return pintador;}            
    
    public String pintadorTareas(String curso,String fechaIni,String fechaFin,
            String contenido,int top,String cod, int ac) throws SQLException{
        String estado = "";
        String not = "";
        int uno = 255,dos = 255, tres = 255;
        rs = select_comparar_si_tarea_fue_hech(cod, ac);
        if(rs.next()){
            estado = rs.getString(1);
            not = rs.getString(2);}
        else{
            rs = select_comparar_si_evalu_fue_hech(cod, ac);
            if(rs.next()){
                estado = rs.getString(1);
                not = rs.getString(2);}
            else{
                not = "--";
                estado = "proceso";}}
        if(not.equals("--")){}
        else{if(Integer.parseInt(not) < 11){
                uno = 194; dos = 5; tres = 10;}
            else{if(Integer.parseInt(not) > 10 && Integer.parseInt(not) < 15 ){
                    uno = 166; dos = 193; tres = 6;}
                else{uno = 6; dos = 193; tres = 11;}}}
        String pintador  = "<div class=\"card\" style=\"background-color: rgba("+uno+", "+dos+","+tres+", 0.7) !important; \n" +
"                border : solid 1px aqua;overflow : auto;\n" + //padding : 4px;
"                position: absolute; left: 30px; top: "+top+"px; width: 16rem;height: 6rem;\">"//76 
                +"<h6 class=\"card-body\" align=left>"
                +"Curso: "+curso
                +"<p> fecha inicio: "+fechaIni
                +" fecha revision: "+ fechaFin +"</h6></div>"
                
                +"<div class=\"card\" style=\"background-color: rgba("+uno+", "+dos+","+tres+", 0.7) !important; \n" +
"                border : solid 1px aqua;overflow : auto;\n" + //padding : 4px;
"                position: absolute; right: 35px; top: "+top+"px; width: 13rem;height: 6rem;\">"
                +"<h6 class=\"card-body\" align=left>"
                +"estado: '"+estado+"'"
                +"<p>puntuacion: "+not+"</h6></div>" 
                
                +"<div class=\"card\" style=\"background-color: rgba("+uno+", "+dos+","+tres+", 0.7) !important; \n" +
"                border : solid 1px aqua;overflow : auto;\n" + //padding : 4px;
"                position: absolute; left: 300px; top: "+top+"px; width: 54rem; height: 6rem;\">"
                +"<h6 class=\"card-body\" align=left>"
                +contenido+"\n" +"</div></div>";
        return pintador;}
        
    public boolean select_si_puedo_borrar_actividad(String cur,int contCur, int ac){
        try{
            boolean vf = false;
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_si_puedo_borrar_actividad ?,?,?");
            ps.setString(1, cur);
            ps.setInt(2, contCur);
            ps.setInt(3, ac);
            rs = ps.executeQuery();
            if(rs.next()){
                vf = true;}
            return vf;}
        catch(SQLException e){return false;}}  
    
    public String pintadorTareasProf(String fechaIni,String fechaFin,String contenido,int ac,int top,String aula, int contCur){
        String pintador = "";
        if(select_si_puedo_borrar_actividad(aula, contCur, ac) == false){
        pintador  = "<div class=\"card\" style=\"background-color: rgba(255, 255,255, 0.7) !important; \n" 
                    +"border : solid 1px aqua;overflow : auto;\n" //padding : 4px;
                    +"position: absolute; left: 30px; top: "+top+"px; width: 76rem;\">\n" 
                    +"<h6 align=\"left\">f.inicio: "+fechaIni+
                     " - f.entrega "+fechaFin+"</h6>\n" +
"                    <h6 align=\"right\">"
                    +"<a href=b_tarea?ac="+ac+" class=\"btn btn-danger text-dark\">eliminar</a> - "
                    +"<input type=submit name=ac_"+ac+" class=\"btn btn-warning text-dark\"value=editar> - "
                    + "<a href=puntuar_tarea?ac="+ac+" class=\"btn btn-success text-dark\">calificar</a></h6>\n" +
"               	    <h6 align=\"left\"><p class=\"mb-0\">"+contenido+"</p></h6></div>";}
        else{
            pintador  = "<div class=\"card\" style=\"background-color: rgba(255, 255,255, 0.7) !important; \n" 
                    +"border : solid 1px aqua;overflow : auto;\n" //padding : 4px;
                    +"position: absolute; left: 30px; top: "+top+"px; width: 76rem;\">\n" 
                    +"<h6 align=\"left\">f.inicio: "+fechaIni+
                     " - f.entrega "+fechaFin+"</h6>\n" +
"                    <h6 align=\"right\">"
                    + "<a href=puntuar_tarea?ac="+ac+" class=\"btn btn-success text-dark\">calificar</a></h6>\n" +
"               	    <h6 align=\"left\"><p class=\"mb-0\">"+contenido+"</p></h6></div>";}
        return pintador;}
    
    public int update_actividad(entidad.Ent_Actividades dl){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("update_actividad ?,?,?,?,?");
            ps.setString(1, dl.acAula);
            ps.setInt(2, dl.acnum);
            ps.setInt(3, dl.cont_cuAu);
            ps.setString(4, dl.acConte);
            ps.setString(5, dl.acEntr);
            return ps.executeUpdate();}
        catch(SQLException e){
            return 0;}}
    
    public int delete_actividades(String aula, int codAula, int acnum){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("delete_actividade ?,?,?");
            ps.setString(1, aula);
            ps.setInt(2, codAula);
            ps.setInt(3, acnum);
            return ps.executeUpdate();}
        catch(SQLException e){
            return 0;}}
    
}
