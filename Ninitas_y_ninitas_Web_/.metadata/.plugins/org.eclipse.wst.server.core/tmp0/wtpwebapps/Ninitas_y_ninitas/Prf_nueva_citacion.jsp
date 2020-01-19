<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
                rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    	
    <body style="background-image: url('img/222.jpg'); background-size: 100%;">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="p_menu_principal">Menu Principal</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active"><a class="nav-link" href="p_registrar_asistencia">
                       Registrar asistencia</a></li>
                    <li class="nav-item active"><a class="nav-link" href="p_tarea">
                       Nueva tarea</a></li>
                    <li class="nav-item active"><a class="nav-link" href="p_citaciones">
                        Citaciones</a></li>
                    <li class="nav-item active"><a class="nav-link" href="p_libreta">
                        Notas</a></li>
                   <div style="position: absolute; right: 30px" class="text-dark navbar">
                       <select id="cboOpciones" name="cboOpciones" onchange="redirect()">
                            <option>Bienvenida</option>
                            <option value="1">Mi perfil</option>
                            <option value="2">Cerrar sesion</option>  
                        </select></div>
                </ul>
            </div>
        </nav>
        <form name="xx" action="inser_citacion">
            <center><h1>CITACIONES</h1></center>
            <div class="card text-dark bg-danger mb-3" style="background-color: rgba(255, 255,255, 0.7) !important;
                border : solid 1px greenyellow; position: absolute; left: 450px; top: 150px">
                <h5>
                    <table>
                        ${v_pintador_citaciones}
                    </table>
                </h5>
            </div>
        </form>
        
        
        
    </body>
</html>
