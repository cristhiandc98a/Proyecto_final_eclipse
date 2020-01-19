<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Calendario</title>
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
        
    <body style="background-image: url('img/222.jpg'); background-size: 100%;" onload="xxxx()">
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
        
        <div style="position: absolute; top: 100px; left: 150px">
            <table>
                <tr><td><a href="asistencias?cod=1" class="btn btn-warning text-dark">
                            <strong>Enero</strong></a></td>
                    <td><a href="asistencias?cod=2" class="btn btn-warning text-dark">
                            <strong>Febrero</strong></a></td>
                    <td><a href="asistencias?cod=3" class="btn btn-warning text-dark">
                            <strong>Marzo</strong></a></td>
                    <td><a href="asistencias?cod=4" class="btn btn-warning text-dark">
                            <strong>Abril</strong></a></td>
                    <td><a href="asistencias?cod=5" class="btn btn-warning text-dark">
                            <strong>Mayo</strong></a></td>
                    <td><a href="asistencias?cod=6" class="btn btn-warning text-dark">
                            <strong>Junio</strong></a></td>
                    <td><a href="asistencias?cod=7" class="btn btn-warning text-dark">
                            <strong>Julio</strong></a></td>
                    <td><a href="asistencias?cod=8" class="btn btn-warning text-dark">
                            <strong>Agosto</strong></a></td>
                    <td><a href="asistencias?cod=9" class="btn btn-warning text-dark">
                            <strong>Setiembre</strong></a></td>
                    <td><a href="asistencias?cod=10" class="btn btn-warning text-dark">
                            <strong>Octubre</strong></a></td>
                    <td><a href="asistencias?cod=11" class="btn btn-warning text-dark">
                            <strong>Noviembre</strong></a></td>
                    <td><a href="asistencias?cod=12" class="btn btn-warning text-dark">
                            <strong>Diciembre</strong></a></td>
            </table>
        </div>
        
        <form name="Calendario" method="post">
            <center><br><br><br><br>
                <div class="card-body"> 
                    <table>
                        <tr>
                            <td><input type="text" id="z0" value="Lun" class="navbar-brand" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="z1" value="Mar" class="navbar-brand" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="z2" value="Mie" class="navbar-brand" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="z3" value="Jue" class="navbar-brand" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="z4" value="Vie" class="navbar-brand" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="z5" value="Sab" class="navbar-brand" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="z6" value="Dom" class="navbar-brand" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            </tr>
                        <tr>
                            <td><input type="text" id="t0" name="${f1}" value="${d1}" class="${color1}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t1" name="${f2}" value="${d2}" class="${color2}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t2" name="${f3}" value="${d3}" class="${color3}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t3" name="${f4}" value="${d4}" class="${color4}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t4" name="${f5}" value="${d5}" class="${color5}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t5" name="${f6}" value="${d6}" class="${color6}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t6" name="${f7}" value="${d7}" class="${color7}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                        </tr>
                        <tr>
                            <td><input type="text" id="t7" name="${f8}" value="${d8}" class="${color8}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t8" name="${f9}" value="${d9}" class="${color9}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t9" name="${f10}" value="${d10}" class="${color10}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t10" name="${f11}" value="${d11}" class="${color11}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t11" name="${f12}" value="${d12}" class="${color12}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t12" name="${f13}" value="${d13}" class="${color13}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t13" name="${f14}" value="${d14}" class="${color14}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                        </tr>
                        <tr>
                            <td><input type="text" id="t14" name="${f15}" value="${d15}" class="${color15}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t15" name="${f16}" value="${d16}" class="${color16}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t16" name="${f17}" value="${d17}" class="${color17}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t17" name="${f18}" value="${d18}" class="${color18}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t18" name="${f19}" value="${d19}" class="${color19}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t19" name="${f20}" value="${d20}" class="${color20}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t20" name="${f21}" value="${d21}" class="${color21}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>  
                        </tr>
                        <tr>
                            <td><input type="text" id="t21" name="${f22}" value="${d22}" class="${color22}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t22" name="${f23}" value="${d23}" class="${color23}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t23" name="${f24}" value="${d24}" class="${color24}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t24" name="${f25}" value="${d25}" class="${color25}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t25" name="${f26}" value="${d26}" class="${color26}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t26" name="${f27}" value="${d27}" class="${color27}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t27" name="${f28}" value="${d28}" class="${color28}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>  
                        </tr>
                        <tr>
                            <td><input type="text" id="t28" name="${f29}" value="${d29}" class="${color29}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t29" name="${f30}" value="${d30}" class="${color30}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t30" name="${f31}" value="${d31}" class="${color31}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t31" name="${f32}" value="${d32}" class="${color32}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t32" name="${f33}" value="${d33}" class="${color33}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t33" name="${f34}" value="${d34}" class="${color34}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t34" name="${f35}" value="${d35}" class="${color35}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>  
                        </tr>
                        <tr>
                            <td><input type="text" id="t35" name="${f36}" value="${d36}" class="${color36}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t36" name="${f37}" value="${d37}" class="${color37}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t37" name="${f38}" value="${d38}" class="${color38}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t38" name="${f39}" value="${d39}" class="${color39}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t39" name="${f40}" value="${d40}" class="${color40}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t40" name="${f41}" value="${d41}" class="${color41}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>
                            <td><input type="text" id="t41" name="${f42}" value="${d42}" class="${color42}" style="text-align:center" size="1" onmousemove="xxxx()" disabled></td>  
                        </tr>
                        <tr><td colspan="7" class="text-dark text-center"><a href="menu_Principal" class="btn btn-secondary">Retornar</a></td></tr>
                    </table>
                </div>
            </center>
            <div class="card" style="background-color: rgba(255, 255,255, 0.4) !important; 
                    border : solid 1px aqua; overflow : auto; padding : 4px;
                    position: absolute; right: 10px; top: 200px; width: 10rem; height: 12rem">
                <div class="card-body">
                    <table>
                        <tr><td><input type="text" class="btn-danger" size="1" disabled></td><td>Inasistencia</td></tr>
                        <tr><td><input type="text" class="btn-warning" size="1" disabled></td><td>Tardanza</td></tr>
                        <tr><td><input type="text" class="btn-success" size="1" disabled></td><td>Puntual</td></tr> 
                        <tr><td><input type="text" size="1" disabled></td><td>Dia libre</td></tr> 
                    </table>
                </div>
            </div>
        </form>
    </body>
</html>
