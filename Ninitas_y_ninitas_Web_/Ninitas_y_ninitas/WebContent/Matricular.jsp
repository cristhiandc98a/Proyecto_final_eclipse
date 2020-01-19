<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Matricular</title>
</head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous"/>
<script type="text/javascript" src="jss/Js_Matriculas.js"> </script>

<body style="background-image: url('img/00.jpg'); background-size: 100%;" onload="fc_combo1(${msg})">

	<form name="matricula_form" action="nueva_matricula" method="post">
		<div style="position: relative;  top: 50px;">
		<div class="text-light"><h3><strong><center>MATRICULAR ALUMNA</center></strong></h3></div>
		
		
		<div style="position: relative; left: 70px;" class="text-warning"><h4>Datos de la alumna:</h4></div>
		
                <div style="position: relative; left: 100px;" class="text-light">
		<table>
			<tr><td>N° matricula:</td><td><input type="text" name="txtMatricula" size="12" value="${v_mtr}" maxlength="4"></td></tr>
                        <tr><td><b>DNI:</b></td><td>
                                <b><input type="text" name="txtDniAlu" size="8" value="${v_dniA}" maxlength="8">
                                <input type="submit" name="btnDniA" value="Verificar" class="btn-secondary"></b></td></tr>
                        <tr><td>Apellido paterno</td><td><input type="text" name="txtPatAlu" size="12" value="${v_patA}" ${v_crgA}></td></tr>
			<tr><td>Apellido materno</td><td><input type="text" name="txtMatAlu" size="12" value="${v_matA}" ${v_crgA}></td></tr>
			<tr><td>Nombres:</td><td><input type="text" name="txtNomAlu" size="20" value="${v_nomA}" ${v_crgA}></td></tr>
                        <tr><td>F. nacimiento:</td><td>
                             <select id="cboFechNaciAA" name="cboFechNaciAA"><option>año</option></select>
                             <select id="cboFechNaciAM" name="cboFechNaciAM"><option>mes</option></select>
                             <select id="cboFechNaciAD" name="cboFechNaciAD"><option>dia</option></select></td></tr>
                        <tr><td>Sexo:</td><td><input type="radio" name="rdSexAlu" value="F" disabled>Femenino</td></tr>
                </table></div>
                
                
		<div style="position: absolute; left: 450px; top: 45px" class="text-warning"><h4>Datos del apoderado:</h4></div>
		<div style="position: absolute; left: 480px; top: 75px" class="text-light">
		<table>
                        <tr><td><b>DNI:</b></td><td>
                                <b><input type="text" name="txtDniApo" size="8" value="${v_dniT}" maxlength="8">
                                <input type="submit" name="btnDniT" value="Verificar" class="btn-secondary"></b></td></tr>
			<tr><td>Apellido paterno</td><td><input type="text" name="txtPatApo" size="12" value="${v_patT}" ${v_crgT}></td></tr>
			<tr><td>Apellido materno</td><td><input type="text" name="txtMatApo" size="12" value="${v_matT}" ${v_crgT}></td></tr>
			<tr><td>Nombres:</td><td><input type="text" name="txtNomApo" size="20" value="${v_nomT}" ${v_crgT}></td></tr>
                        <tr><td>F. nacimiento:</td><td>
                             <select id="cboFechNaciTA" name="cboFechNaciTA"><option>año</option></select>
                             <select id="cboFechNaciTM" name="cboFechNaciTM"><option>mes</option></select>
                             <select id="cboFechNaciTD" name="cboFechNaciTD"><option>dia</option></select></td></tr>
                        <tr><td>Sexo:</td><td>
                                <input type="radio" name="rdSexApo" Value="F">Femenino 
                                <input type="radio" name="rdSexApo" Value="M">Masculino</td></tr>
		</table></div>
		
		<div style="position: relative; left: 70px;" class="text-warning"><h4>Datos generales:</h4></div>
		<div style="position: relative; left: 100px;" class="text-light">
		<table>
		<tr><td>N° telefono:</td><td><input type="text" name="txtTelApo" size="9" value="${v_telA}" maxlength="9"></td></tr>
		<tr><td>Dirección:</td><td><input type="text" name="txtDirAlu" size="40" value="${v_dirA}"></td></tr>
		</table>
		</div>
		</div>
            <div style="position: relative; left: 550px; top: 80px">
                    <input type="submit" name="btnRegistrar" value="Registrar" class="btn-warning">
                    <input type="submit" name="btnLimpiar" value="Limpiar"  class="btn-warning">
                    <input type="submit" name="btnRetornar" value="Retornar" class="btn-warning"></div>
	</form>
</body>
</html>