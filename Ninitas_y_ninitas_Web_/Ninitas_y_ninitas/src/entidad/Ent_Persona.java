package entidad;

public abstract class Ent_Persona {
    public String perCod;
    public int anio;
    public String perPat;
    public String perMat;
    public String perNom;
    public String fechNaci;
    public String perDni;
    public String perTel;
    public String perSex;
    public String perDir;
    
    public Ent_Persona(String perCod,int anio,String perPat,String perMat,String perNom,
            String fechNaci,String perDni,String perTel,String perSex,String perDir){
        this.perCod =perCod;this.perPat = perPat;this.perMat = perMat;
        this.perNom = perNom;this.fechNaci=fechNaci;this.perDni = perDni;
        this.perTel = perTel;this.perSex = perSex;this.perDir=perDir;this.anio=anio;}
    
    //CONSTRUCTOR SIN DATOS REPIPTENTES COMO DDIRECCION, AÑO, TELEFFONNO
    public Ent_Persona(String perCod,String perPat,String perMat,String perNom,
            String fechNaci,String perDni,String perSex){
        this.perCod =perCod;this.perPat = perPat;this.perMat = perMat;
        this.perNom = perNom;this.fechNaci=fechNaci;this.perDni = perDni;
        this.perTel = perTel;this.perSex = perSex;this.perDir=perDir;this.anio=anio;}
    
    public Ent_Persona(String perCod, String perDni){
        this.perCod = perCod;
        this.perDni = perDni;}
    
    public Ent_Persona (){}
    
}
