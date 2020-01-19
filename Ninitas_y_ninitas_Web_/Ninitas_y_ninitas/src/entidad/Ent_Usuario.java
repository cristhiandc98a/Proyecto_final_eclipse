package entidad;

public class Ent_Usuario extends Ent_Persona{
    
    public String usuUsu;
    public String usuCla;
    
    
    public Ent_Usuario(String perCod,int anio, String perPat, String perMat, String perNom, 
            String fechNaci,String perDni, String perTel, String perSex, String perDir,
            String usuUsu,String usuCla) {
        super(perCod,anio,perPat, perMat, perNom,fechNaci, perDni, perTel, perSex, perDir);
        this.usuUsu = usuUsu;
        this.usuCla = usuCla;}
    

    public Ent_Usuario(){}
    
    
    
}
