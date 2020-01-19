<%-- 
    Document   : Alm_Registro_Asistencia
    Created on : 15/10/2019, 08:21:23 AM
    Author     : cristhiandc98
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>REGISTRO ASISTENCIAS </title>
        <script language="JavaScript">
            function mueveReloj(ml){
                momentoActual = new Date()
                hora = momentoActual.getHours()
                minuto = momentoActual.getMinutes()
                segundo = momentoActual.getSeconds()
                horaImprimible = hora + " : " + minuto + " : " + segundo
                document.form_reloj.reloj.value = horaImprimible
                setTimeout("mueveReloj()",1000)
                var a = ml;
                if(a == 1){
                    alert("¡ Bienvenida !");}
                else{
                    if(a == 2){
                        alert("¡ Directo a tu casa !");}
                    else{
                        if(a == 3){
                            alert("¡ Erro ! ya se registro la salida anteriormente");}}}
                a = 0;}       
        </script>
    </head>
    
    
    <body style="background-image: url('img/222.jpg'); background-size: 100%;" onload="mueveReloj(${ml})">
        <form name="form_reloj" action="Srvl_Alm_Registro_Asistencia" method="post">
        <div class="card text-dark" style="background-color: rgba(255, 255,255, 0.7) !important;
                     position: absolute; left: 10px; top: 10px">
            <h4><%Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat ("EEEE dd MMMM YYYY");
            String currentDate = ft.format(dNow);
            out.println(currentDate);%></h4>
            <h4><input type="text" style="border: 0" name="reloj" size="10" ></h4>
        </div>
         <div class="card text-dark" style="background-color: rgba(255, 255,255, 0.4) !important;
                     position: absolute; left: 500px; top: 100px">   
            <center><strong><br><br>
                <h1 class="text-primary">Bienvenido</h1>
                <h2 class="text-primary">"Maria Parado de Bellido"</h2></strong><br><br>    
                <h3><table>
                        <tr><td><strong>Usuario:</strong></td><td><input type="text" name="txtUsu" size="12" placeholder="Usuario"/></td></tr>
                        <tr><td><strong>Contraseña:<strong></td><td><input type="password" name="txtPas" size="12" placeholder="****"/></td></tr>
                        <tr><td colspan="2" align="right"><input type="submit" name="btnAcc" value="REGISTRAR ASISTENCIA"  class="btn btn-warning btn-block"></td></tr>
                    </table>
                </h3>
            </center>
         </div>
        </form>
    </body>
</html>

