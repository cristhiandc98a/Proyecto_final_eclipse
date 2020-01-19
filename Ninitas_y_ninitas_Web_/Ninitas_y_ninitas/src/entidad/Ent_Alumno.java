
package entidad;

public class Ent_Alumno extends Ent_Usuario{
    
    public String codMtr;
    
    public Ent_Alumno(String perCod,int anio, String perPat, String perMat, 
            String perNom, String fechNaci, String perDni, String perTel, 
            String perSex,String perDir,String usuUsu,String usuCla,String codMtr){
        super(perCod,anio,perPat, perMat, perNom,fechNaci, perDni, perTel, 
                perSex, perDir,usuUsu,usuCla);
        this.codMtr = codMtr;}
    
    
    public Ent_Alumno(){}
    
    
}
