use master 
go
--*******************************
if exists(
select * 
from sys.databases 
where name='Ninitas_y_ninitas')
drop database Ninitas_y_ninitas
go
create database Ninitas_y_ninitas
go
use Ninitas_y_ninitas
go
--*******************************
create table Anio_Sc(
anio numeric(4) not null,
fechInsc date not null,
constraint pk_anio_sc primary key (anio))
go
--***
create table Grado(
gradCod char(1) not null,
constraint pk_grado primary key (gradCod))
go
--***
create table Trimestre(
trimCod char(2) not null,
constraint pk_Trimestre primary key (trimCod))
go
--***
create table Seccion(
seccCod char(1) not null,
constraint pk_seccion primary key (seccCod))
go
--***
create table Turno(
turnCod char(1) not null,
constraint pk_turno primary key (turnCod))
go
--***
create table Nivel(
nivCod char(1) not null,
constraint pk_nivel primary key (nivCod))
go
--***
create table Aula(
auCont char(4) not null,
anio numeric(4) not null,
gradCod char(1) not null,
seccCod char(1) not null,
turnCod char(1) not null,
nivCod char(1) not null,
constraint fk_aul_3 foreign key (gradCod) references Grado (gradCod),
constraint fk_aul_4 foreign key (seccCod) references Seccion (seccCod),
constraint fk_aul_5 foreign key (turnCod) references Turno (turnCod),
constraint fk_aul_6 foreign key (nivCod) references Nivel (nivCod),
constraint fk_aul_2 foreign key (anio) references Anio_Sc (anio),
constraint pk_aula primary key(auCont))
go
--***
create table Matriculas(
mtrCod char(4) not null,
anio numeric(4) not null,
auCont char(4) not null,
constraint fk_mtr2  foreign key(anio) references Anio_Sc(anio),
constraint fk_mtr3  foreign key(auCont) references Aula(auCont),
constraint pk_matricula primary key(mtrCod))
go
--***
create table Persona(
perCod char(4) not null, 
anio numeric(4) not null,
perPat varchar(20) not null,
perMat varchar(20) not null,
perNom varchar(20) not null,
fechNaci date not null,
perDni char(8) not null, 
perTel char(9) not null,
perSex char(1) not null,
perDir varchar(100) not null,
constraint fk_per_2 foreign key (anio) references Anio_Sc (anio),
constraint uk_persona unique(perDni,anio),
constraint pk_persona primary key (perCod))
go 
--***
create table Usuario(
perCod char(4) not null,
usuUsu varchar(20) not null,
usuCla char(4) not null,
constraint fk_usu_1 foreign key (perCod) references Persona (perCod),
constraint pk_usuario primary key (perCod))
go
--***
create table Apoderado(
perCod char(4) not null,
constraint fk_Apo foreign key (perCod) references Persona (perCod),
constraint pk_apo primary key (perCod))
go
--***
create table Alumno(
mtrCod char(4) not null,
perCod char(4) not null,
apoCod char(4) not null,
constraint fk_alu_4 foreign key (apoCod) references Apoderado (perCod),
constraint fk_alu_3 foreign key (mtrCod) references Matriculas (mtrCod),
constraint fk_alu_1 foreign key (perCod) references Persona (perCod),
constraint pk_alumna primary key (mtrCod))
go
--***
create table Asistencias(
asisHF dateTime not null,
mtrCod char(4) not null,
constraint fk_asi_1 foreign key (mtrCod) references Alumno (mtrCod),
constraint pk_asistencia_ing_sal primary key(asisHF))
go
--***
create table Ingreso(
asisHF dateTime not null,
tipo char(1) not null,
justi char(1) not null,
trimCod char(2) not null,
constraint fk_ing_5 foreign key (trimCod) references Trimestre (trimCod),
constraint fk_ing_12 foreign key (asisHF) references Asistencias (asisHF),
constraint pk_ing primary key(asisHF))
go
--***
create table Salida(
asisHF dateTime not null,
constraint fk_sal_12 foreign key (asisHF) references Asistencias (asisHF),
constraint pk_sal primary key(asisHF))
go
--***
create table Profesor(
perCod char(4) not null,
constraint fk_pro_1 foreign key (perCod) references Persona (perCod),
constraint pk_profesor primary key (perCod))
go
--***
create table Curso(
curCod char(4) not null,
curNom varchar(40) not null,
constraint pk_curso primary key (curCod))
go
--***
create table Profesor_Curso(
porCuCod char(4) not null,
perCod char(4) not null,
curCod char(4) not null,
constraint fk_pc_1 foreign key (perCod) references Profesor (perCod),
constraint fk_pc_2 foreign key (curCod) references Curso (curCod),
constraint pk_pc primary key (porCuCod))
go
--***
create table Curso_Aula(
auCont char(4) not null,
cuAuCont numeric(3) not null,
porCuCod char(4) not null,
constraint fk_ca_12 foreign key (auCont) references Aula (auCont),
constraint fk_ca_78 foreign key(porCuCod) references Profesor_Curso (porCuCod),
constraint pk_ca primary key (cuAuCont,auCont))
go
--***
create table Citaciones(
mtrCod char(4) not null,
citNum numeric(3) not null,
auCont char(4) not null,
cuAuCont numeric(3) not null,
citFech date not null,
citCont varchar(250) not null,
constraint fk_cit_145 foreign key(cuAuCont,auCont) references Curso_Aula (cuAuCont,auCont),
constraint fk_cit_12 foreign key (mtrCod) references Alumno (mtrCod),
constraint pk_citaciones primary key(citNum))
go
--***
create table Actividades(
auCont char(4) not null,
acNum int NOT NULL,
cuAuCont numeric(3) not null,
acIni date not null,
acEntr date not null,
acConte varchar(200) not null,
trimCod char(2) not null,
constraint fk_dtald_8 foreign key (trimCod) references Trimestre (trimCod),
constraint fk_ac_123 foreign key (cuAuCont,auCont) references Curso_Aula (cuAuCont,auCont),
constraint ac_123 primary key (acNum,cuAuCont,auCont))
go
--***
create table Calificaciones_D(
cdCod char(4) not null,
mtrCod char(4) not null,
constraint fk_dtalc_12 foreign key (mtrCod) references Alumno (mtrCod),
constraint al_13 primary key (cdCod))
go
--***
create table Calificaciones_C(
cdCod char(4) not null,
ccCont numeric(4) not null,
cuAuCont numeric(3) not null,
auCont char(4) not null,
acNum int NOT NULL,
dtEst varchar(20) not null,
dtNot char(2) not null,
constraint fk_dtald_12 foreign key (cdCod) references Calificaciones_D (cdCod),
constraint fk_dtald_456 foreign key (acNum,cuAuCont,auCont) references Actividades (acNum,cuAuCont,auCont),
constraint dtad_123 primary key (ccCont,cdCod))
go
--***
create table Tareas(
cdCod char(4) not null,
ccCont numeric(4) not null,
constraint fk_ta_123 foreign key (ccCont,cdCod) references Calificaciones_C (ccCont,cdCod),
constraint ta_123 primary key (ccCont,cdCod))
go
--***
create table Evaluaciones(
cdCod char(4) not null,
ccCont numeric(4) not null,
constraint fk_ev_12 foreign key (ccCont,cdCod) references Calificaciones_C (ccCont,cdCod),
constraint fk_ev primary key (ccCont,cdCod))
go
--***
create table Asistencias_Curso(
mtrCod char(4) not null,
cuAuCont numeric(3) not null,
auCont char(4) not null,
asCuFech date not null,
asCuEsta char(1) not null,
constraint fk_ac_12 foreign key (mtrCod) references Alumno (mtrCod),
constraint fk_asi_243 foreign key (cuAuCont,auCont) references Curso_Aula (cuAuCont,auCont),
constraint pk_asiC primary key (mtrCod,asCuFech))
go 


select * From Usuario