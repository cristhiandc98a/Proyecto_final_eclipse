package dao;

import dato.Dato_Conexion_SQL;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Dao_Alm_Asistecia_General {
    
    Dato_Conexion_SQL cn = new Dato_Conexion_SQL();
    
    public int ultimoDiaMesAsistido(String codAlm,int anio,int mes){
        try{PreparedStatement ps = cn.conectorDB().prepareStatement("select_asistecia_completa_mes ?,?,?");
        ps.setString(1, codAlm);
        ps.setInt(2, anio);
        ps.setInt(3, mes);
        int ultimodiaAsistido = 0;
        ResultSet rs = ps.executeQuery();
        while (rs.next()) { 
            ultimodiaAsistido = rs.getInt(1);}
        return ultimodiaAsistido;}
        catch(SQLException e){return 0;}}
    
    public String codd(String usu,String cla){
        try{
            String cod = "";
            PreparedStatement ps = cn.conectorDB().prepareStatement("mtrrr ?,?");
            ps.setString(1, usu);
            ps.setString(2, cla);
            ResultSet rs =  ps.executeQuery();
            if(rs.next()){
                cod = rs.getString(1);}
        return cod;}
        catch(SQLException e){return "";}}
    
    public int istAsistencia(String usu,String cla,String fech){
        try{
            int ist = 0;
            String est = "-", just = "-" , trim = "T1";
            PreparedStatement ps = cn.conectorDB().prepareStatement("insert_entradas ?,?,?,?,?");
            ps.setString(1, codd(usu, cla));
            ps.setString(2, fech.substring(0,19));
            ps.setString(3, est);
            ps.setString(4, just);
            ps.setString(5, trim);
            ist = ps.executeUpdate();
            return ist;}
        catch(SQLException e){
            return 0;}}
    
    public int istSali(String usu,String cla,String fech){
        try{
            int ist = 0;
            PreparedStatement ps = cn.conectorDB().prepareStatement("insert_salida ?,?");
            ps.setString(1, codd(usu, cla));
            ps.setString(2, fech.substring(0,19));
            ist = ps.executeUpdate();
            return ist;}
        catch(SQLException e){
            return 0;}}
   
    public boolean verif_si_asiii(String mtr,String fech){
        try{
            boolean vf = false;
            PreparedStatement ps = cn.conectorDB().prepareStatement(" verif_si_asiii ?,?");
            ps.setString(1, mtr);
            ps.setString(2, fech);
            ResultSet rs =  ps.executeQuery();
            if(rs.next()){
                vf = true;}
        return vf;}
        catch(SQLException e){return false;}}
    
    public boolean verif_si_sal(String mtr,String fech){
        try{
            boolean vf = false;
            PreparedStatement ps = cn.conectorDB().prepareStatement("verif_si_sal ?,?");
            ps.setString(1, mtr);
            ps.setString(2, fech);
            ResultSet rs =  ps.executeQuery();
            if(rs.next()){
                vf = true;}
        return vf;}
        catch(SQLException e){return false;}}
    /*public int cantDiaszMes(String mes){
        int a =0;
        switch(mes){
            case "m4":a = 30;break;
            case "m6":a = 30;break;
            case "m9":a = 30;break;
            case "m11":a = 30;break;
            
            case "m1":a = 31;break;
            case "m3":a = 31;break;
            case "m5":a = 31;break;
            case "m7":a = 31;break;
            case "m8":a = 31;break;
            case "m10":a = 31;break;
            case "m12":a = 31;break;
            case "m2": a = 28;}
        return a;}
     public String mesLetras(String mes){
        String nombreMes ="";
        switch (mes){
           case "m1": nombreMes = "Enero";break;
           case "m2": nombreMes = "Febrero";break;
           case "m3": nombreMes = "Marzo";break;
           case "m4": nombreMes = "Abril";break;
           case "m5": nombreMes = "Mayo";break;
           case "m6": nombreMes = "Junio";break;
           case "m7": nombreMes = "Julio";break;
           case "m8": nombreMes = "Agosto";break;
           case "m9": nombreMes = "Septiembre";break;
           case "m10": nombreMes = "Octubre";break;
           case "m11": nombreMes = "Noviembre";break;
           case "m12": nombreMes = "Diciembre";break;
           default:nombreMes="Error";}
        return nombreMes;}
     public int inicioDiaMes(int numMes){
         switch(numMes){
             case 3:numMes = 4 ;break;
             case 4:numMes = 0 ;break;
             case 5:numMes = 2 ;break;
             case 6:numMes = 5 ;break;
             case 7:numMes = 0 ;break;
             case 8:numMes = 3 ;break;
             case 9:numMes = 6 ;break;
             case 10:numMes = 1 ;break;
             case 11:numMes = 4 ;break;}
         return numMes;}

         public boolean diasSiClases (int mes, int i){
        boolean pintaDanger = true;
        //***
        switch(mes){
            //enoro
            case 1:if(i==1 || i==5 || i ==6 || i ==12 || i==13 || i==12 || i==13 ||
                i==19 || i==20 || i==26 || i==27){
            pintaDanger = false;}break;
            //febrero
            case 2:if(i==2 || i ==3 || i ==9 || i==10 || i==16 || i==17 ||
                i==23 || i==24){
            pintaDanger = false;}break;
            //marzo
            case 3: if(i==2 || i ==3 || i ==9 || i==10 || i==16 || i==17 ||
                i==23 || i==24 || i==30 || i==31){    
            pintaDanger = false;}break;
            //abril
            case 4: if(i==6 || i ==7 || i ==13 || i==14 || i==18 || i==19 || i==20 || i==21 ||
                i==27 || i==28){    
            pintaDanger = false;}break;
            //mayo
            case 5: if(i==1 || i==4 || i ==5 || i ==11 || i==12 || i==18 || i==19 ||
                i==25 || i==26){    
            pintaDanger = false;}break;
            //junio
            case 6: if(i==1 || i ==2 || i ==8 || i==9 || i==15 || i==16 ||
                i==22 || i==23 || i==29 || i==30){    
            pintaDanger = false;}break;
          //julio
            case 7: if(i==6 || i ==7 || i ==13 || i==14 || i==20 || i==21 ||
                i==26 || i==27 || i==28 || i==29 || i==30){    
            pintaDanger = false;}break;
          //agosto
            case 8: if(i==3 || i ==4 || i ==10 || i==11 || i==17 || i==18 ||
                i==24 || i==25 || i==29 || i==30 || i==31){    
            pintaDanger = false;}break;
            //setiembre
            case 9: if(i==3 || i ==4 || i ==10 || i==11 || i==17 || i==18 ||
                i==24 || i==25 || i==29 || i==30 || i==31){    
            pintaDanger = false;}break;
             //octrubre
            case 10: if(i==5 || i ==6 || i ==8 || i==12 || i==13 || i==19 ||
                i==20 || i==26 || i==27 || i==27 || i==30){    
            pintaDanger = false;}break;
             //nobiembre
            case 11: if(i==1 || i ==2 || i ==3 || i==9 || i==10 || i==16 ||
                i==17 || i==23 || i==24 || i==30){    
            pintaDanger = false;}break;
            //nobiembre
            case 12: if(i==1 || i ==7 || i ==8 || i==14 || i==15 || i==21 ||
               i==22 || i==25 || i==28 || i==29){    
            pintaDanger = false;}break;
        }
     return pintaDanger;}*/


}
