/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author cristhiandc98
 */
public class Ent_Actividades {
    
    public String  acAula;
    public int cont_cuAu;
    public int acnum;
    public String  acIni;
    public String  acEntr;
    public String  acConte;
    public String  trim;
    
    public Ent_Actividades(String acAula,int cont_cuAu, String acIni,String acEntr, String acConte,String  trim){
        this.acAula = acAula;
        this.acConte = acConte;
        this.acEntr = acEntr;
        this.acIni =  acIni;
        this.cont_cuAu = cont_cuAu;
        this.trim = trim;}
    
    public Ent_Actividades(String acAula,int acnum,int cont_cuAu, String acConte, String acEntr){
        this.acAula = acAula;
        this.acConte = acConte;
        this.acEntr = acEntr;
        this.cont_cuAu = cont_cuAu;
        this.acnum = acnum;}
    
}
