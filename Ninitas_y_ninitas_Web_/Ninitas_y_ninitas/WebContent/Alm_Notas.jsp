<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mi notas</title>
    </head>
    
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
        rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	
    <%@page session="true"%>
    <%HttpSession ss = request.getSession();
        if(ss.getAttribute("cod") == null){%>
    <jsp:forward page="index.jsp">
        <jsp:param name="msg" value="0"/>
    </jsp:forward><%}%>

    <script type="text/javascript" src="jss/CargarHoras_EntrSal.js"></script>    
        
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
        
        <center><h1 style="position: absolute; left: 150px; top: 70px">Libreta de notas</h1>
            
            <div style="position: absolute; top: 140px; left: 80px">
            <table>
                <tr><td><a href="notas?tr=T1" class="btn btn-warning text-dark">
                            <strong>Trimestre 1</strong></a></td>
                   <td><a href="notas?tr=T2" class="btn btn-warning text-dark">
                        <strong>Trimestre 2</strong></a></td> 
                   <td><a href="notas?tr=T3" class="btn btn-warning text-dark">
                        <strong>Trimestre 3</strong></a></td>
                   <td><a href="notas?tr=T4" class="btn btn-warning text-dark">
                        <strong>Promedio final</strong></a></td> 
                </tr>
            </table>
        </div>
            
            <form name="Libreta_Notas" method="post">
                <div class="card text-dark" style="background-color: rgba(255, 255,255, 0.4) !important;
                     position: absolute; left: 50px; top: 200px">
                    <strong>
                        <table border="1">
                            ${tr1}
                            ${todo}
                        </table>
                    </strong>
                </div>
            </form>
        </center>
    </body>
</html>
