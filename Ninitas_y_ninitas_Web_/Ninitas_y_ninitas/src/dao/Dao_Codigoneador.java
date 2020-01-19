package dao;

public class Dao_Codigoneador {
    
    public String autoincrementador(String codigo, int prefCod){
        byte longitudCadena = (byte)(codigo.length());
        String prefijoCodigo =  codigo.substring(0,prefCod);
        byte rellenadorCeros = (byte)(longitudCadena - prefCod);
        String cadenaIncrementador = codigo.substring(prefCod);
        int incrementador = Integer.parseInt(cadenaIncrementador) + 1;
        cadenaIncrementador = String.valueOf(incrementador);
        rellenadorCeros = (byte)(rellenadorCeros - cadenaIncrementador.length());
        codigo = prefijoCodigo;
        for (int i=0; i<rellenadorCeros;i++){codigo = codigo + "0";}
        codigo = codigo + cadenaIncrementador;
        return codigo;}
    
    public static void main(String[] args) {
        Dao_Codigoneador dc = new Dao_Codigoneador();
        System.out.println(dc.autoincrementador("A003", 1));
    }
    
}
