package dao;

public class Asistenciador {
    
    public static void main(String[] args) {
        Asistenciador a = new Asistenciador();
        Dao_Asistencias da = new Dao_Asistencias();
        
        int diasMes = 0;
        boolean asistencia_si_no = false;
        int sino = 0;
        String tipo = "";
        String est = "";
        int estt = 0;
        String trim = "";
        
        for(int i = 3; i <= 12; i++){
            diasMes = da.cantDiaszMes((byte) i);
            for(int o = 1; o <= diasMes; o++){
                sino = (int)(Math.random() * (12-1) + 1);
                if(sino != 3){
                    asistencia_si_no = da.diasSiClases(o,i);
                    if( asistencia_si_no == true ){
                        //HHORA ENTRADA
                        int hrE = (int)(Math.random() * (10-7) + 7);
                        String hrEstrineada = String.valueOf(hrE);
                        if(hrEstrineada.length()==1){hrEstrineada = "0"+hrEstrineada;}
                        //MIN  ENTRADA
                        int hrM = (int)(Math.random() * 60);
                        String hrMeadada = String.valueOf(hrM);
                        if(hrMeadada.length()==1){hrMeadada = "0"+hrMeadada;}
                        //SEG ENTRADA
                        int hrMM = (int)(Math.random() * 60);
                        String hrMMMMeada = String.valueOf(hrMM);
                        if(hrMMMMeada.length()==1){hrMMMMeada = "0"+hrMMMMeada;}
                        //HHORA ENTRADA_S
                        int hrEs = (int)(Math.random() * (15-13) + 13);
                        String hrEstrineadas = String.valueOf(hrEs);
                        if(hrEstrineadas.length()==1){hrEstrineadas = "0"+hrEstrineadas;}
                        //MIN  ENTRADA_S
                        int hrMs = (int)(Math.random() * 60);
                        String hrMeadadas = String.valueOf(hrMs);
                        if(hrMeadadas.length()==1){hrMeadadas = "0"+hrMeadadas;}
                        if(hrE >= 8 && hrM > 0){
                            tipo = "T";
                            estt = (int)(Math.random() * (4-1) + 1);
                            if(estt == 3){est = "J";}
                            else{est = "I";}}
                        else{tipo = "P";
                            est = "-";}
                        if( i >= 3 && i <= 5 ){trim = "T1";}
                        else{if( i >= 6 && i <= 8 ){trim = "T2";}
                            else{if( i >= 9 && i <= 11 ){trim = "T3";}}}
                        a.asistenciador(2019,i,o,hrEstrineada,hrMeadada,hrMMMMeada,"MT01",
                                hrEstrineadas,hrMeadadas,tipo,est,trim);}}}}}
    
    String asistencia = "insert into Asistencias values('";
    String finall = "";
    String ingreso = "insert into Ingreso values('";
    String salida = "insert into Salida values('";
    
    public void asistenciador (int anio,int mes,int dia, String hora, String min,String seg,
            String codAlm,String horas, String mins,String tipo, String estado, String trim){
        finall = asistencia + anio + "-" + mes + "-" + dia + " " + hora + ":" + min + ":" +seg + "','" 
            + codAlm +"')";
        System.out.println(finall);
        System.out.println("go");
        finall = "";
        finall = ingreso + anio + "-" + mes + "-" + dia + " " + hora + ":" + min + ":" + seg + "','"
                + tipo + "','" + estado + "','" + trim + "')";
        System.out.println(finall);
        System.out.println("go");
        
        finall = asistencia + anio + "-" + mes + "-" + dia + " " + horas + ":" + mins + ":" +seg + "','" 
            + codAlm +"')";
        System.out.println(finall);
        System.out.println("go");
        finall = "";
        finall = salida + anio + "-" + mes + "-" + dia + " " + horas + ":" + mins + ":" + seg + "')";
        System.out.println(finall);
        System.out.println("go");
    }
    
    
}
