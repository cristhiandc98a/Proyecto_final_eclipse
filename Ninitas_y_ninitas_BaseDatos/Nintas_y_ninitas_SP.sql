use Ninitas_y_ninitas
go
--****************************************************************************************
create procedure select_evaluaciones_trim_alumn
@alm char(4),
@trim char(2),
@cur char(4)
as
select cc.dtNot, cc.acNum, cc.ccCont
from Calificaciones_C as cc, Calificaciones_D as cd, Alumno as a, Evaluaciones as e, Actividades as ac, Curso as c,
	Profesor_Curso as pc, Curso_Aula as ca
where a.mtrCod = cd.mtrCod and cd.cdCod = cc.cdCod and cc.ccCont = e.ccCont and e.cdCod = cc.cdCod
	and ac.cuAuCont = cc.cuAuCont and ac.acNum = cc.acNum and ac.auCont = cc.auCont and c.curCod = pc.curCod
	and pc.porCuCod = ca.porCuCod and ca.auCont = ac.auCont and ca.cuAuCont = ca.cuAuCont
	and a.perCod = @alm and ac.trimCod = @trim and c.curCod = @cur 
go
create procedure select_tareas_trim_alumnos
@alm char(4),
@trim char(2),
@cur char(4)
as
select cc.dtNot, cc.acNum, cc.ccCont
from Calificaciones_C as cc, Calificaciones_D as cd, Alumno as a, Tareas as e, Actividades as ac, Curso as c,
	Profesor_Curso as pc, Curso_Aula as ca
where a.mtrCod = cd.mtrCod and cd.cdCod = cc.cdCod and cc.ccCont = e.ccCont and e.cdCod = cc.cdCod
	and ac.cuAuCont = cc.cuAuCont and ac.acNum = cc.acNum and ac.auCont = cc.auCont and c.curCod = pc.curCod
	and pc.porCuCod = ca.porCuCod and ca.auCont = ac.auCont and ca.cuAuCont = ca.cuAuCont
	and a.perCod = @alm and ac.trimCod = @trim and c.curCod = @cur
go
create procedure select_tareas_curso_alum
@alm char(4),
@cur char(4)
as
select a.perCod,c.curNom,c.curCod,ac.acNum,ac.acIni,ac.acEntr,ac.acConte
from Alumno as a, Actividades as ac, Curso as c,Profesor_Curso as pc,Curso_Aula as ca,Matriculas as m,
	Aula as au
where a.perCod = @alm and pc.curCod = c.curCod and c.curCod = @cur and a.mtrCod = m.mtrCod and m.auCont = au.auCont
	and ca.porCuCod = pc.porCuCod and ca.auCont = ac.auCont and ca.cuAuCont = ac.cuAuCont and au.auCont = ca.auCont
order by ac.acNum desc
go
create procedure select_notas_tare
@mtr char(4),
@cur char(4),
@trim char(4)
as
select cc.dtNot
from Calificaciones_C as cc,Calificaciones_D as cd, Alumno as a, Tareas as t, Actividades as ac,Curso as c,
	Curso_Aula as ca,Profesor_Curso as pc
where a.mtrCod = cd.mtrCod and cc.cdCod = cd.cdCod 
	and a.perCod = @mtr and t.ccCont = cc.ccCont and t.cdCod = cc.cdCod and ca.cuAuCont = ac.cuAuCont
	and ac.cuAuCont = cc.cuAuCont and ac.auCont = cc.auCont and ac.acNum = cc.acNum
	and ac.trimCod = @trim and pc.curCod = c.curCod and pc.porCuCod = ca.porCuCod and c.curCod = @cur
	and ca.auCont  = ac.auCont
go
create procedure select_notas_evaluacion
@mtr char(4),
@cur char(4),
@trim char(4)
as
select cc.dtNot,ac.acNum
from Calificaciones_C as cc,Calificaciones_D as cd, Alumno as a, Evaluaciones as t, Actividades as ac,Curso as c,
	Curso_Aula as ca,Profesor_Curso as pc
where a.mtrCod = cd.mtrCod and cc.cdCod = cd.cdCod 
	and a.perCod = @mtr and t.ccCont = cc.ccCont and t.cdCod = cc.cdCod and ca.cuAuCont = ac.cuAuCont
	and ac.cuAuCont = cc.cuAuCont and ac.auCont = cc.auCont and ac.acNum = cc.acNum
	and ac.trimCod = @trim and pc.curCod = c.curCod and pc.porCuCod = ca.porCuCod and c.curCod = @cur
	and ca.auCont  = ac.auCont 
go

create procedure select_tareas
@mtr char(4)
as
select cc.dtNot,cc.ccCont,cc.acNum
from Calificaciones_C as cc,Calificaciones_D as cd, Alumno as a, Tareas as t
where a.mtrCod = cd.mtrCod and cc.cdCod = cd.cdCod and t.ccCont = cc.ccCont and t.cdCod = cc.cdCod
	and a.mtrCod = @mtr
go

create procedure select_evaluacion
@cod char(4),
@pc char(4)
as
select cc.dtNot,cc.ccCont,cc.acNum
from Calificaciones_C as cc,Calificaciones_D as cd, Alumno as a, Evaluaciones as t
where a.mtrCod = cd.mtrCod and cc.cdCod = cd.cdCod and t.ccCont = cc.ccCont and t.cdCod = cc.cdCod
	and a.perCod = @cod
go
create procedure insert_citacion
@mtr char(4),
@citNum numeric(3),
@auCont char(4),
@cuAuCont numeric(3),
@acFech date,
@cont varchar(200)
as
insert into Citaciones values(@mtr,@citNum,@auCont,@cuAuCont,@acFech,@cont)
go
create procedure numero_citacion_alumnoo
@cod char(4)
as
select c.citNum
from Citaciones as c, Curso_Aula as ca, Alumno as a
where a.mtrCod = c.mtrCod and ca.auCont = c.auCont and ca.cuAuCont = c.cuAuCont
	and ca.auCont = @cod
go
create procedure insert_asistencia_curso
@mtr char(4),
@cuAuCont numeric(3),
@auCont char(4),
@acFech date,
@est char(1)
as
insert into Asistencias_Curso values (@mtr,@cuAuCont,@auCont,@acFech,@est)
go
--execute insert_asistencia_curso 'MT01',1,'L001','2020-11-11','asdas'
create procedure ultima_actividad_curso
@auCont char(4),
@cuAuCont numeric(3)
as
select ac.acNum
from  Actividades as ac, Curso_Aula as ca
where ac.auCont = ca.auCont and ac.cuAuCont = ca.cuAuCont and ca.auCont = @auCont and ca.cuAuCont = @cuAuCont
go

create procedure inser_nota
@libre char(4),
@libre_cont numeric(4),
@cuAuCont numeric(3),
@auCont char(4),
@acNum int,
@dtEstado varchar(20),
@nota char(2)
as
insert into Calificaciones_C values (@libre,@libre_cont,@cuAuCont,@auCont,@acNum,@dtEstado,@nota)
insert into Tareas values (@libre,@libre_cont)
go
create procedure ultimo_contador_libret
@libre char(4)
as
select cc.ccCont
from Calificaciones_C as cc, Calificaciones_D as cd
where cc.cdCod = cd.cdCod and cd.cdCod = @libre 
go
create procedure select_alumnos_aul
@aula char(4),
@pc char(4)
as
select p.perPat,p.perMat,p.perNom,cd.cdCod,a.mtrCod,a.perCod
from Aula as au, Curso_Aula as ca, Matriculas as m, Alumno as a, Persona as p, Profesor_Curso as pc,
	Calificaciones_D as cd
where m.mtrCod = a.mtrCod and m.auCont = au.auCont and a.perCod = p.perCod and ca.auCont = au.auCont
	and ca.porCuCod = pc.porCuCod and pc.porCuCod = @pc and au.auCont = @aula and m.mtrCod = cd.mtrCod
go
execute select_alumnos_aul 'L001','PC01'
go
create procedure insert_tareas
@aula char(4),
@acNum int,
@cuAuCont numeric(2),
@fini date,
@fentrega date,
@cont varchar(200),
@Trim char(2)
as
insert into Actividades values(@aula,@acNum,@cuAuCont,@fini,@fentrega,@cont,@Trim)
go
create procedure select_aulas_profesor
@cod char(4)
as
select ca.auCont, pc.porCuCod, c.curNom , a.gradCod,a.seccCod,a.nivCod,a.turnCod, ca.cuAuCont
from Profesor as pr, Profesor_Curso as pc, Curso_Aula as ca, Aula as a , Curso as c
where pr.perCod = pc.perCod and pc.porCuCod = ca.porCuCod and ca.auCont = a.auCont
	and pr.perCod = @cod and c.curCod = pc.curCod
go

create procedure select_todas_actividades_del_cur
@aula char(4),
@cod char(4)
as
select ac.acIni,ac.acEntr,ac.acConte, ac.acNum
from Actividades as ac, Curso as c, Profesor_Curso as pc,Curso_Aula as ca, Aula as au
where ca.cuAuCont = ac.cuAuCont and @aula = ca.auCont
	and ac.auCont = au.auCont and pc.porCuCod = @cod
	and c.curCod = pc.curCod and pc.porCuCod = ca.porCuCod and ca.auCont = ac.auCont
order by ac.acNum desc
go
--************************************ALLUMNO
create procedure select_verif_usuario
@usuUsu varchar(20),
@usuCla char(4)
as
select u.perCod,u.usuUsu,u.usuCla,p.perNom
from Persona as p, Usuario as u
where p.perCod = u.perCod 
and @usuCla = u.usuCla 
and u.usuUsu = @usuUsu 
go
create procedure select_ultimo_usuario_alumno
@prefijo char(1)
as
select usuUsu,SUBSTRING(usuUsu,7,3)
from Usuario
where SUBSTRING(usuUsu,1,1) = @prefijo
go
create procedure select_ultimo_cod_persona
@prefijo char(1)
as
select perCod,SUBSTRING(perCod,2,3)
from Persona
where SUBSTRING(perCod,1,1) = @prefijo
go
create procedure select_ultima_contrasenia
as
select usuCla,SUBSTRING(usuCla,2,3)
from Usuario
where SUBSTRING(usuCla,1,1) = 'U'
go
create procedure insert_new_alumno_apoderado
@matr char(4),
@codalm char(4),
@anio numeric(4),
@patalm varchar(20),
@matalm varchar(20),
@nomalm varchar(20),
@nacialm varchar(10),
@dnialm char(8),
@telef char(9),
@sexalm char(1),
@direcc varchar(100), 
@usuUsu varchar(20),
@usuCla char(4),
@codapo char(4),
@patapo varchar(20),
@matapo varchar(20),
@nomapo varchar(20),
@naciapo varchar(10),
@dniapo char(8),
@sexapo char(1),
@codCD char(4) 
as
insert into Persona values (@codalm,@anio,@patalm,@matalm,@nomalm,convert(date,@nacialm),@dnialm,@telef,@sexalm,@direcc)
insert into Persona values (@codapo,@anio,@patapo,@matapo,@nomapo,convert(date,@naciapo),@dniapo,@telef,@sexapo,@direcc)
insert into Apoderado values (@codapo)
insert into Alumno values (@matr,@codalm,@codapo)
insert into Usuario values (@codalm,@usuUsu,@usuCla)
insert into Calificaciones_D values (@codCD,@matr)
go
--***
create procedure insert_new_alumno_antiguo_apoderado
@matr char(4),
@codalm char(4),
@anio numeric(4),
@patalm varchar(20),
@matalm varchar(20),
@nomalm varchar(20),
@nacialm varchar(10),
@dnialm char(8),
@telef char(9),
@sexalm char(1),
@direcc varchar(100), 
@usuUsu varchar(20),
@usuCla char(4),
@codapo char(4),
@codCD char(4) 
as
insert into Persona values (@codalm,@anio,@patalm,@matalm,@nomalm,convert(date,@nacialm),@dnialm,@telef,@sexalm,@direcc)
update Persona set anio = @anio , perTel = @telef,perDir = @direcc
	where @codapo = perCod
insert into Apoderado values (@codapo)
insert into Alumno values (@matr,@codalm,@codapo)
insert into Usuario values (@codalm,@usuUsu,@usuCla)
insert into Calificaciones_D values (@codCD,@matr)
go
--***
create procedure select_alumno_Xdni
@dniapo char(8)
as
select p.perCod,p.anio,p.perPat,p.perMat,p.perNom,p.fechNaci,p.perDni,p.perTel,p.perSex,p.perDir,u.usuUsu,u.usuCla,m.mtrCod
from Persona as p, Usuario as u, Matriculas as m, Alumno as a
where perDni = @dniapo and p.perCod = u.perCod and a.perCod=p.perCod and m.mtrCod = a.mtrCod
go
create procedure select_alumno_Xcod
@cod char(4)
as
select p.perCod,p.anio,p.perPat,p.perMat,p.perNom,p.fechNaci,p.perDni,p.perTel,p.perSex,p.perDir,u.usuUsu,u.usuCla,m.mtrCod
from Persona as p, Usuario as u, Matriculas as m, Alumno as a
where p.perCod = @cod and p.perCod = u.perCod and a.perCod=p.perCod and m.mtrCod = a.mtrCod
go
create procedure select_tut_Xdni
@dniapo char(8)
as
select p.perCod,p.anio,p.perPat,p.perMat,p.perNom,p.fechNaci,p.perDni,p.perTel,p.perSex,p.perDir
from Persona as p, Apoderado as t
where perDni = @dniapo and p.perCod = t.perCod
go
create procedure select_curso_alumno
@cod char(4)
as
select c.curCod,c.curNom
from Curso as c, Profesor_Curso as pc, Curso_Aula as ca, Aula as a,Matriculas as m, Alumno as al
where c.curCod = pc.curCod and 
ca.porCuCod = pc.porCuCod and 
a.auCont = ca.auCont and
m.auCont = a.auCont and
al.mtrCod = m.mtrCod and
al.perCod = @cod
go
create procedure select_todas_tareas_alu
@cod char(4)
as
select c.curNom,ac.acIni,ac.acEntr,ac.acConte, cc.dtEst,ac.acNum
from Tareas as t, Calificaciones_D as cd, Calificaciones_C as cc, Matriculas as m, Alumno as a,Actividades as ac,
	Curso as c, Profesor_Curso as pc,Curso_Aula as ca
where t.ccCont = cc.ccCont and t.cdCod = cc.cdCod and cd.cdCod = cc.cdCod and ac.acNum = cc.acNum and ca.cuAuCont = ac.cuAuCont
and m.mtrCod = cd.mtrCod and a.mtrCod = m.mtrCod and a.perCod = @cod and ac.auCont = cc.auCont and ac.cuAuCont = cc.cuAuCont
and YEAR(ac.acIni) = year(getdate()) and c.curCod = pc.curCod and pc.porCuCod = ca.porCuCod and ca.auCont = ac.auCont
order by ac.acNum desc 
go
create procedure select_todas_actividade
@cod char(4)
as
select c.curNom,ac.acIni,ac.acEntr,ac.acConte,ac.acNum
from Alumno as a,Actividades as ac, Curso as c, Profesor_Curso as pc,Curso_Aula as ca, Aula as au, Matriculas as m
where a.perCod = @cod and a.mtrCod = m.mtrCod and m.auCont = au.auCont and c.curCod =pc.curCod and pc.porCuCod = ca.porCuCod
	and ac.auCont = ca.auCont and ac.cuAuCont = ca.cuAuCont and au.auCont = ca.auCont
order by ac.acNum desc 
go
create procedure select_comparar_si_tarea_fue_hech
@alm char(4),
@acnum int
as
select cc.dtEst, cc.dtNot
from Alumno as a, Actividades as ac, Calificaciones_D as cd, Calificaciones_C as cc, Aula as au, Curso_Aula as ca,
	Matriculas as m, Tareas as t
where a.perCod = @alm and m.mtrCod = a.mtrCod and m.auCont = au.auCont and au.auCont = ca.auCont and ac.auCont = ca.auCont
	and ac.cuAuCont = ca.cuAuCont and cd.mtrCod = m.mtrCod and cd.cdCod = cc.cdCod and t.cdCod = cc.cdCod 
	and t.ccCont = cc.ccCont and ac.acNum = cc.acNum and ac.acNum = @acnum
go
create procedure select_comparar_si_evalu_fue_hech
@alm char(4),
@acnum int
as
select cc.dtEst, cc.dtNot
from Alumno as a, Actividades as ac, Calificaciones_D as cd, Calificaciones_C as cc, Aula as au, Curso_Aula as ca,
	Matriculas as m, Evaluaciones as t
where a.perCod = @alm and m.mtrCod = a.mtrCod and m.auCont = au.auCont and au.auCont = ca.auCont and ac.auCont = ca.auCont
	and ac.cuAuCont = ca.cuAuCont and cd.mtrCod = m.mtrCod and cd.cdCod = cc.cdCod and t.cdCod = cc.cdCod 
	and t.ccCont = cc.ccCont and ac.acNum = cc.acNum and ac.acNum = @acnum
go


create procedure select_todas_evaluacione_alumno
@cod char(4)
as
select c.curNom,ac.acIni,ac.acEntr,ac.acConte, cc.dtEst,cc.dtNot
from Evaluaciones as v, Calificaciones_D as cd, Calificaciones_C as cc, Matriculas as m, Alumno as a,Actividades as ac,
	Curso as c, Profesor_Curso as pc,Curso_Aula as ca
where v.ccCont = cc.ccCont and v.cdCod = cc.cdCod and cd.cdCod = cc.cdCod and ac.acNum = cc.acNum and ca.cuAuCont = ac.cuAuCont
and m.mtrCod = cd.mtrCod and a.mtrCod = m.mtrCod and a.perCod = @cod and ac.auCont = cc.auCont and ac.cuAuCont = cc.cuAuCont
and YEAR(ac.acIni) = year(getdate()) and c.curCod = pc.curCod and pc.porCuCod = ca.porCuCod and ca.auCont = ac.auCont
go
create procedure select_todas_citacioness_alumn
@cod char(4)
as
select c.curNom,ps.perPat,ps.perMat,ps.perNom,ct.citFech,ct.citCont,ct.citNum
from Citaciones as ct, Matriculas as m, Alumno as a, Persona as ps, Profesor as p, Curso as c,Profesor_Curso as pc,
	Curso_Aula as ca
where a.perCod = @cod and m.mtrCod = a.mtrCod and ps.perCod = p.perCod and c.curCod = pc.curCod and p.perCod = pc.perCod 
	and pc.porCuCod = ca.porCuCod and ct.auCont = ca.auCont and ct.cuAuCont = ca.cuAuCont
	and ct.mtrCod = m.mtrCod
order by ct.citNum desc
go
create procedure select_todas_citaciones_cur_alumn
@cod char(4),
@cur char(4)
as
select c.curNom,ps.perPat,ps.perMat,ps.perNom,ct.citFech,ct.citCont,ct.citNum
from Citaciones as ct, Matriculas as m, Alumno as a, Persona as ps, Profesor as p, Curso as c,Profesor_Curso as pc,
	Curso_Aula as ca
where a.perCod = @cod and m.mtrCod = a.mtrCod and ps.perCod = p.perCod and c.curCod = pc.curCod and p.perCod = pc.perCod 
	and pc.porCuCod = ca.porCuCod and ct.auCont = ca.auCont and ct.cuAuCont = ca.cuAuCont and c.curCod = @cur
	and ct.mtrCod = m.mtrCod
order by ct.citNum desc
go
create procedure select_ingreso_del_mes_alumno
@cod char(4),
@mes numeric(2)
as
select YEAR(ig.asisHF), MONTH(ig.asisHF), DAY(ig.asisHF),SUBSTRING(CONVERT(varchar,ig.asisHF,120),12,8)
from Matriculas as m, Alumno as al, Asistencias as asi, Ingreso as ig
where ig.asisHF = asi.asisHf and asi.mtrCod = m.mtrCod and al.mtrCod = m.mtrCod 
	and al.perCod = @cod and MONTH(ig.asisHF) = @mes
go
create procedure select_hora__ingreso_dia_asistido_alumno
@cod char(4),
@mes numeric(2),
@dia numeric(2)
as
select SUBSTRING(CONVERT(varchar,ig.asisHF,120),12,8)
from Matriculas as m, Alumno as al, Asistencias as asi, Ingreso as ig
where ig.asisHF = asi.asisHf and asi.mtrCod = m.mtrCod and al.mtrCod = m.mtrCod 
	and al.perCod = @cod and MONTH(ig.asisHF) = @mes and DAY(ig.asisHF) = @dia
go

create procedure select_hora__salida_dia_asistido_alumno
@cod char(4),
@mes numeric(2),
@dia numeric(2)
as
select SUBSTRING(CONVERT(varchar,ig.asisHF,120),12,8)
from Matriculas as m, Alumno as al, Asistencias as asi, Salida as ig
where ig.asisHF = asi.asisHf and asi.mtrCod = m.mtrCod and al.mtrCod = m.mtrCod 
	and al.perCod = @cod and MONTH(ig.asisHF) = @mes and DAY(ig.asisHF) = @dia
go
create procedure select_si_asistio_clase_curs
@alm char(4),
@cuAuCont int
as
select ac.asCuFech
from Alumno as al, Asistencias_Curso as ac, Curso_Aula as ca
where al.mtrCod = ac.mtrCod and ca.auCont = ac.auCont and ca.cuAuCont = ac.cuAuCont and al.perCod = @alm and ca.cuAuCont = @cuAuCont
go

create procedure delete_si_asistio_clase_curso
@alm char(4),
@fech date
as
DELETE FROM Asistencias_Curso WHERE asCuFech = @fech
	and mtrCod in (select m.mtrCod
						from Alumno as al, Matriculas as m
						where m.mtrCod = al.mtrCod and al.perCod = @alm)
go

create procedure update_actividad
@auCont char(4),
@acNum int,
@cuAuCont int,
@acConte varchar(200),
@acEntr date
as
update Actividades set acEntr = @acEntr, acConte = @acConte 
	where auCont = @auCont and acNum = @acNum and cuAuCont = @cuAuCont
go
------------------------
create procedure select_actividad_especifi
@aula char(4),
@cuAuCont int
as
select ac.acNum
from Actividades as ac
where ac.auCont = @aula and ac.cuAuCont = @cuAuCont
go

create procedure delete_actividade
@aula char(4),
@cuAuCont int,
@acnum int
as
DELETE FROM Actividades WHERE acNum = @acnum and auCont = @aula and cuAuCont = @cuAuCont
go


create procedure insert_entradas
@mtr char(4),
@fech dateTime,
@est char(1),
@just char(1),
@trim char(2)
as
insert into Asistencias values(@fech,@mtr)
insert into Ingreso values(@fech,@est,@just,@trim)
go

create procedure insert_salida
@mtr char(4),
@fech dateTime
as
insert into Asistencias values(@fech,@mtr)
insert into Salida values(@fech)
go

create procedure mtrrr
@usu char(12),
@cla char(4)
as
select a.mtrCod
from Alumno as a,Matriculas as m, Usuario as u
where u.usuCla = @cla and u.usuUsu = @usu and u.perCod = a.perCod
	and a.mtrCod = m.mtrCod
go

create procedure verif_si_asiii
@mtr char(4),
@fech datetime
as
select CONVERT(date,i.asisHF)
from Ingreso as i, Asistencias as a
where a.mtrCod = @mtr and	CONVERT(date,i.asisHF) = CONVERT(date, @fech) and a.asisHF = i.asisHF
go

create procedure verif_si_sal
@mtr char(4),
@fech datetime
as
select CONVERT(date,i.asisHF)
from Salida as i, Asistencias as a
where a.mtrCod = @mtr and	CONVERT(date,i.asisHF) = CONVERT(date, @fech) and a.asisHF = i.asisHF
go

create procedure select_ult_cd
as
select cd.cdCod
from Calificaciones_D as cd
order by cd.cdCod desc
go


create procedure select_si_puedo_borrar_actividad
@aula char(4),
@aucont int,
@acnum int
as
select ac.acNum
from Calificaciones_C as cc, Calificaciones_D as cd, Matriculas as m, Aula as au, Curso_Aula as ca, Actividades as ac
where cc.cdCod = cd.cdCod and cd.mtrCod = m.mtrCod and m.auCont = au.auCont and au.auCont = ca.auCont
	and cc.acNum = ac.acNum and cc.auCont = ac.auCont and cc.cuAuCont = ac.cuAuCont and ca.auCont = ac.auCont
	and ca.cuAuCont = ac.cuAuCont and ca.auCont = @aula and ca.cuAuCont = @aucont 
	and ac.acNum = @acnum
go

create procedure select_tarea_especifica_alm
@lib char(4)
as
select cc.dtNot,cc.ccCont,cc.acNum 
from Calificaciones_D as cd, Calificaciones_C as cc
where cd.cdCod = cc.cdCod and cd.cdCod = @lib
go

create procedure count_cant_filas
@aula char(4),
@cuCont int,
@trim char(2)
as
select count(ac.trimCod)
from Calificaciones_C as cc, Calificaciones_D as cd, Actividades as ac
where cc.cdCod = cd.cdCod and cc.auCont = @aula and cc.cuAuCont = @cuCont and ac.auCont = cc.auCont
	and ac.cuAuCont = cc.cuAuCont and ac.acNum = cc.acNum and ac.trimCod = @trim
go

create procedure select_cur_de_pccursod
@pc char(4)
as
select c.curCod 
from Profesor_Curso as pc, Curso as c, Profesor as p
where pc.curCod = c.curCod and p.perCod = pc.perCod and pc.porCuCod = @pc
go

select * from Alumno
go