function fc_combo1(msg){
    
    var fecha = new Date();
    var ano = fecha.getFullYear();
    var cont = 1;
    var ano1 = document.getElementById("cboFechNaciAA");
    for(var i=ano;i>=(ano-17);i--){ 
    ano1.options[cont] = new Option(i);
    cont++;}

    cont = 1;
    var mes1 = document.getElementById("cboFechNaciAM");
    for(var i=1;i<=12;i++){ 
    mes1.options[cont] = new Option(i);
    cont++;}
    
    cont = 1;
    var dia1 = document.getElementById("cboFechNaciAD");
    for(var i=1;i<=31;i++){ 
    dia1.options[cont] = new Option(i);
    cont++;}

    cont = 1;
    var ano2 = document.getElementById("cboFechNaciTA");
    for(var i=(ano-17);i>=(ano-100);i--){ 
    ano2.options[cont] = new Option(i);
    cont++;}

    cont = 1;
    var mes2 = document.getElementById("cboFechNaciTM");
    for(var i=1;i<=12;i++){ 
    mes2.options[cont] = new Option(i);
    cont++;}
    
    cont = 1;
    var dia2 = document.getElementById("cboFechNaciTD");
    for(var i=1;i<=31;i++){ 
    dia2.options[cont] = new Option(i);
    cont++;}

    if("1" == msg){
        alert(" ¡Datos registrados exitosamente!");}
    if("0" == msg){
        alert(" ¡Error al insertar datos!");}
}