<%@ page language="java" 
         contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta charset="ISO-8859-1">
        <title>Menu Principal</title>
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

    <body style="background-image: url('img/222.jpg'); background-size: 100%;">
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
        
        <center><h1>Mis Tareas</h1>
            <table>
                ${v_pintador_tareas}
            </table>
        </center>
    </body>
</html>