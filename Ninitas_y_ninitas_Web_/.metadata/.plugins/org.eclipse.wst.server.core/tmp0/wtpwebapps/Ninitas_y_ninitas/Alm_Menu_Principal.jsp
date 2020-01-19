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
                        Asistencia General</a></li>
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
        
        <form method="post">
            <div style="position: absolute; right: 50px;">
                <h1>Bienvenida ${v_nom}</h1>
            </div>
            <div style="position: relative; top:80px;">
                <center>
                    <h1 class="text-dark"> MIS CURSOS </h1>
                    <table>
                        <tr>
                            <td>
                                <div class="card" style="background-color: rgba(255, 255,255, 0.7) !important; 
                                     height: 5rem;  width: 12rem; justify-content: center;">
                                        <center>
                                            <a href="alm_cursos_t?cu=${c1}"  class="text-dark">
                                            <strong><h6>${n1}</h6></strong></a>
                                        </center>
                                </div>
                            </td>
                            <td>
                                <div class="card" style="background-color: rgba(255, 255,255, 0.7) !important; 
                                     height: 5rem;  width: 12rem; justify-content: center;">
                                        <center>
                                            <a href="alm_cursos_t?cu=${c2}" class="text-dark">
                                            <strong><h6>${n2}</h6></strong></a>
                                        </center>
                                </div>
                            </td>
                            <td>
                                <div class="card" style="background-color: rgba(255, 255,255, 0.7) !important; 
                                     height: 5rem;  width: 12rem; justify-content: center;">
                                        <center>
                                        <a href="alm_cursos_t?cu=${c3}" class="text-dark">
                                            <strong><h6>${n3}</h6></strong></a>
                                        </center>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="card" style="background-color: rgba(255, 255,255, 0.7) !important; 
                                     height: 5rem;  width: 12rem; justify-content: center;">
                                        <center>
                                            <a href="alm_cursos_t?cu=${c4}" class="text-dark">
                                            <strong><h6>${n4}</h6></strong></a>
                                        </center>
                                </div>
                            </td>
                            <td>
                                <div class="card" style="background-color: rgba(255, 255,255, 0.7) !important; 
                                     height: 5rem;  width: 12rem; justify-content: center;">
                                        <center>
                                            <a href="alm_cursos_t?cu=${c5}" class="text-dark">
                                            <strong><h6>${n5}</h6></strong></a>
                                        </center>
                                </div>
                            </td>
                            <td>
                                <div class="card" style="background-color: rgba(255, 255,255, 0.7) !important; 
                                     height: 5rem;  width: 12rem; justify-content: center;">
                                        <center>
                                        <a href="alm_cursos_t?cu=${c6} class="text-dark"" class="text-dark">
                                            <strong><h6>${n6}</h6></strong></a>
                                        </center>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="card" style="background-color: rgba(255, 255,255, 0.7) !important; 
                                     height: 5rem;  width: 12rem; justify-content: center;">
                                        <center>
                                            <a href="alm_cursos_t?cu=${c7}" class="text-dark">
                                            <strong><h6>${n7}</h6></strong></a>
                                        </center>
                                </div>
                            </td>
                            <td>
                                <div class="card" style="background-color: rgba(255, 255,255, 0.7) !important; 
                                     height: 5rem;  width: 12rem; justify-content: center;">
                                        <center>
                                            <a href="alm_cursos_t?cu=${c8}" class="text-dark">
                                            <strong><h6>${n8}</h6></strong></a>
                                        </center>
                                </div>
                            </td>
                            <td>
                                <div class="card" style="background-color: rgba(255, 255,255, 0.7) !important; 
                                     height: 5rem;  width: 12rem; justify-content: center;">
                                        <center>
                                        <a href="alm_cursos_t?cu=${c9}" class="text-dark">
                                            <strong><h6>${n9}</h6></strong></a>
                                        </center>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <div class="card" style="background-color: rgba(255, 255,255, 0.7) !important; 
                                     height: 5rem;  width: 12rem; justify-content: center;">
                                        <center>
                                            <a href="alm_cursos_t?cu=${c10}" class="text-dark">
                                            <strong><h6>${n10}</h6></strong></a>
                                        </center>
                                </div>
                            </td>
                            <td>
                                <div class="card" style="background-color: rgba(255, 255,255, 0.7) !important; 
                                     height: 5rem;  width: 12rem; justify-content: center;">
                                        <center>
                                            <a href="alm_cursos_t?cu=${c11}" class="text-dark">
                                            <strong><h6>${n11}</h6></strong></a>
                                        </center>
                                </div>
                            </td>
                            <td>
                                <div class="card" style="background-color: rgba(255, 255,255, 0.7) !important; 
                                     height: 5rem;  width: 12rem; justify-content: center;">
                                        <center>
                                        <a href="alm_cursos_t?cu=${c12}" class="text-dark">
                                            <strong><h6>${n12}</h6></strong></a>
                                        </center>
                                </div>
                            </td>
                        </tr>
                    </table>
                </center>
            </div>
        </form>
    </body>
</html>