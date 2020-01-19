
package entidad;

public class Ent_Apoderado extends Ent_Persona{
    
    
    public Ent_Apoderado(String perCod, String perPat, String perMat, 
            String perNom, String fechNaci, String perDni,
            String perSex){
        super(perCod,perPat, perMat, perNom,fechNaci, perDni,perSex);}
   
    public Ent_Apoderado(String perCod,int anio,String perPat,String perMat,String perNom,
            String fechNaci,String perDni,String perTel,String perSex,String perDir){
        super(perCod,anio,perPat, perMat, perNom,fechNaci, perDni, perTel, 
                perSex, perDir);}

    public Ent_Apoderado(String perCod,String perDni){
        super(perCod, perDni);}  
      
    public Ent_Apoderado(){}
}


   
