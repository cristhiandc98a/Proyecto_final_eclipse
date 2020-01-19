<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous"/>
<meta charset="ISO-8859-1">
<title>Bienvenido a Maria Parado De Bellido</title>
</head>

<script type="text/javascript" src="jss/Js_index.js"></script>

<body style="background-image: url('img/222.jpg'); background-size: 100%;" onload="fc_alerta(${msg})">

	
	<div class="card bg-primary text-dark" 
             style="background-color: rgba(255, 255,255, 0.4) !important;">
	<h2>Portal "Maria Parado de Bellido" </h2></div>

		
 <form action="ingresar" method="get">    
	<div class="card text-dark bg-danger mb-3" style="background-color: rgba(255, 255,255, 0.4) !important;
                position: absolute; right: 100px; top: 250px">
		<table>
			<tr><td><h3>Iniciar sesion</h3></td></tr>
        	<tr><td><strong>Usuario:</strong></td>
            <td><input type="text" name="txtUsu" placeholder="Usuario"/></td></tr>
            <tr><td><strong>Contraseña:</strong></td>
            <td><input type="password" name="txtPas" placeholder="****"/></td></tr>
            <tr><td colspan="2" align="right"><input type="submit" name="btnAcc" value="ACCEDER"  
                    class="btn btn-warning btn-block"></td></tr>
            <tr><td colspan="2" class="text-dark text-right">¿No eres alumno? 
            <a href="Matricular.jsp">
            ¡matriculate aquí!</a><td></tr>
        </table>
</div>
</form>
</body>
</html>

