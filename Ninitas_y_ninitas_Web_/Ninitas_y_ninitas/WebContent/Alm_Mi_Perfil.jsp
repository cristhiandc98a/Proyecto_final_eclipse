<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi perfil</title>
    </head>
    
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
        rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
    <%@page session="true"%>
    <%HttpSession ss = request.getSession();
        if(ss.getAttribute("cod") == null){%>
    <jsp:forward page="index.jsp">
        <jsp:param name="msg" value="0"/>
    </jsp:forward><%}%>

    <script type="text/javascript" src="jss/Js_Sesionador.js"></script>    
        
    <body style="background-image: url('img/11.jpg'); background-size: 100%;" onload="${msgg}">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="menu_Principal">Menu Principal</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active"><a class="nav-link" href="tareas">
                        Tareas</a></li>
                    <li class="nav-item active"><a class="nav-link" href="citaciones">
                        Citaciones</a></li>
                    <li class="nav-item active"><a class="nav-link" href="notas?tr=T1">
                        Notas</a></li>
                    <li class="nav-item active"><a class="nav-link" href="carga_mes">
                        Asistencias General</a></li>
                   <div style="position: absolute; right: 30px" class="text-dark navbar">
                       <select id="cboOpciones" name="cboOpciones" onchange="commbo_superior()">
                            <option>Bienvenida</option>
                            <option value="1">Mi perfil</option>
                            <option value="2">Cerrar sesion</option>  
                        </select>
                   </div>
                </ul>
            </div>
        </nav>
        
        <form action="menu_Principal" method="post">
            <center>
                <table class="text-primary">
                    <tr><td colspan="2"><h1>DATOS PERSONALES</h1></td></tr>
                        <tr><td>Apellido paterno :</td><td>${pat}</td></tr>
                        <tr><td>Apellido materno :</td><td>${mat}</td></tr>
                        <tr><td>Nombre :</td><td>${nom}</td></tr>
                        <tr><td>Usuario :</td><td>${usu}</td></tr>
                        <tr><td>Edad :</td><td>${edd}</td></tr>
                        <tr><td>Sexo :</td><td>${sex}</td></tr>
                        <tr><td>Dni :</td><td>${dni}</td></tr>
                        <tr><td>Telefono :</td><td>${tel}</td></tr>
                        <tr><td>Direccion :</td><td>${dir}</td></tr>
                        <tr><td colspan="2" class="text-dark text-right">
                                <input type="submit" value="Retornar" class="btn-secondary"></td></tr>
                </table>
            </center>
            ${primer_inicio_sesion}
        </form>
    </body>
</html>
