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
public class Dao_Asistencias {
    
    Dato_Conexion_SQL cn = new Dato_Conexion_SQL();
    ResultSet rs ;
    
    public ResultSet select_ingreso_alumno(String cod, int mes){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_ingreso_del_mes_alumno ?,?");
            ps.setString(1, cod);
            ps.setInt(2, mes);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}
    
    public ResultSet select_hora__ingreso_dia_asistido_alumno(String cod, int mes, int dia){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement(
                    "select_hora__ingreso_dia_asistido_alumno ?,?,?");
            ps.setString(1, cod);
            ps.setInt(2, mes);
            ps.setInt(3, dia);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}
    
    public ResultSet select_hora__salida_dia_asistido_alumno(String cod, int mes, int dia){
        try{
            PreparedStatement ps = cn.conectorDB().prepareStatement(
                    "select_hora__salida_dia_asistido_alumno ?,?,?");
            ps.setString(1, cod);
            ps.setInt(2, mes);
            ps.setInt(3, dia);
            return ps.executeQuery();}
        catch(SQLException e){return null;}}
    
    public int ultimo_Dia_mes_asistido(String cod, int mes){
        try{
            int diaciador = 0;
            PreparedStatement ps = cn.conectorDB().prepareStatement("select_ingreso_del_mes_alumno ?,?");
            ps.setString(1, cod);
            ps.setInt(2, mes);
            rs = ps.executeQuery();
            while(rs.next()){
                if(diaciador < rs.getInt(3)){
                    diaciador = rs.getInt(3);}}
            return diaciador;}
        catch(SQLException e){return 0;}}
    
    public byte cantDiaszMes(byte mes){
        byte a = 1;
        switch(mes){
            case 4:
                a = 30;
                break;
            case 6:
                a = 30;
                break;
            case 9:
                a = 30;
                break;
            case 11:
                a = 30;
                break;
            case 1:
                a = 31;
                break;
            case 3:
                a = 31;
                break;
            case 5:
                a = 31;
                break;
            case 7:
                a = 31;
                break;
            case 8:
                a = 31;
                break;
            case 10:
                a = 31;
                break;
            case 12:
                a = 31;
                break;
            case 2: 
                a = 28;
                break;}
        return a;}
    
    public boolean diasSiClases (int i,int mes){
        boolean pintaDanger = true;
       
        switch(mes){
            case 1:
                if(i==1 || i==5 || i ==6 || i ==12 || i==13 || i==12 || i==13 ||
                        i==19 || i==20 || i==26 || i==27){
                    pintaDanger = false;}
                break;
            case 2:
                if(i==2 || i ==3 || i ==9 || i==10 || i==16 || i==17 ||
                        i==23 || i==24){
                    pintaDanger = false;}
                break;
            case 3: 
                if(i==2 || i ==3 || i ==9 || i==10 || i==16 || i==17 ||
                        i==23 || i==24 || i==30 || i==31){    
                    pintaDanger = false;}
                break;
            case 4: 
                if(i==6 || i ==7 || i ==13 || i==14 || i==18 || i==19 || i==20 || i==21 ||
                        i==27 || i==28){    
                    pintaDanger = false;}
                break;
            case 5: 
                if(i==1 || i==4 || i ==5 || i ==11 || i==12 || i==18 || i==19 ||
                        i==25 || i==26){    
                    pintaDanger = false;}
                break;
            case 6: 
                if(i==1 || i ==2 || i ==8 || i==9 || i==15 || i==16 ||
                        i==22 || i==23 || i==29 || i==30){    
                    pintaDanger = false;}
                break;
            case 7: 
                if(i==6 || i ==7 || i ==13 || i==14 || i==20 || i==21 ||
                i==26 || i==27 || i==28 || i==29 || i==30){    
                    pintaDanger = false;}
                break;
            case 8: 
                if(i==3 || i ==4 || i ==10 || i==11 || i==17 || i==18 ||
                        i==24 || i==25 || i==29 || i==30 || i==31){    
                    pintaDanger = false;}
                break;
            case 9: 
                if(i==3 || i ==4 || i ==10 || i==11 || i==17 || i==18 ||
                        i==24 || i==25 || i==29 || i==30 || i==31){    
                    pintaDanger = false;}
                break;
            case 10: 
                if(i==5 || i ==6 || i ==8 || i==12 || i==13 || i==19 ||
                        i==20 || i==26 || i==27 || i==27 || i==30){    
                    pintaDanger = false;}
                break;
            case 11: 
                if(i==1 || i ==2 || i ==3 || i==9 || i==10 || i==16 ||
                        i==17 || i==23 || i==24 || i==30){    
                    pintaDanger = false;}
                break;
            //nobiembre
            case 12: 
                if(i==1 || i ==7 || i ==8 || i==14 || i==15 || i==21 ||
                        i==22 || i==25 || i==28 || i==29){    
                    pintaDanger = false;}
                break;}
    return pintaDanger;}
    
    public byte inicio_Mes(int mes){
        byte dia = 0;
        switch(mes){
            case 1:
                dia = 1;
                break;
            case 2:
                dia = 4;
                break;
            case 3:
                dia = 4;
                break;
            case 4:
                dia = 0;
                break;
            case 5:
                dia = 2;
                break;
            case 6:
                dia = 5;
                break;
            case 7:
                dia = 0;
                break;
            case 8:
                dia = 3;
                break;
            case 9:
                dia = 3;
                break;
            case 10:
                dia = 1;
                break;
            case 11:
                dia = 4;
                break;
            case 12:
                dia = 6;
                break;}
        return dia;}
    
   /* public void fecheador (String codAlm, int anio){
        String insertInto = "insert into Asistencia_Ing_Sal values('";
        
        for (int mes = 3; mes<=11; mes++){
            byte dias = cantDiaszMes(mes);

            for(int i = 1;i<=dias;i++){
                if(diasSiClases(mes, i)==true){
                //******
                int hrE = (int)(Math.random() * (9-7) + 7);
                int hrS = (int)(Math.random() * (15-13) + 13);
                int hrM = (int)(Math.random() * 60);
                int hrMM = (int)(Math.random() * 60);

                String mesStrineado = String.valueOf(mes);
                String hrEstrineada = String.valueOf(hrE);
                String hrSstrineada = String.valueOf(hrS);
                String hrMeadada = String.valueOf(hrM);
                String hrMMMMeada = String.valueOf(hrMM);
                String diaStrineado = "";

                if(mesStrineado.length()==1){mesStrineado = "0"+mesStrineado;}
                if(hrEstrineada.length()==1){hrEstrineada = "0"+hrEstrineada;}
                if(hrSstrineada.length()==1){hrSstrineada = "0"+hrSstrineada;}
                if(hrMeadada.length()==1){hrMeadada = "0"+hrMeadada;}
                if(hrMMMMeada.length()==1){hrMMMMeada = "0"+hrMMMMeada;}
                //******
                diaStrineado = String.valueOf(i);
                if(diaStrineado.length()==1){diaStrineado = "0"+diaStrineado;}
                System.out.println(insertInto+codAlm+"',"+anio+",'"+anio+"-"+mesStrineado+"-"
                        +diaStrineado+" "+hrEstrineada+":"+hrMeadada+":"+hrMMMMeada+"',1)");

                System.out.println(insertInto+codAlm+"',"+anio+",'"+anio+"-"+mesStrineado+"-"
                            +diaStrineado+" "+hrSstrineada+":"+hrMeadada+":"+hrMMMMeada+"',2)");}}}}*/
    //***
    
}
