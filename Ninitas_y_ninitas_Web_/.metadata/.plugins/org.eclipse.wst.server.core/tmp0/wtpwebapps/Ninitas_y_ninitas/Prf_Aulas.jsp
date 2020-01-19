<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image: url('img/222.jpg'); background-size: 100%;">
        
        <div style="position: absolute; right: 50px;" class="text-light"><h1>Bienvenida ${v_nom}</h1></div>
        
        <div style="position: relative; top:80px;">
            <center><h1> MIS CURSOS </h1>
                <form action="aula">
                <select name="cbop">
                    ${v_listado_cursos}
                    <input type="submit" value="ir">
                </select>
                </form>
            </center>
        </div>
    </body>
</html>
