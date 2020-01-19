use Ninitas_y_ninitas
go
--*******************************
insert into Anio_Sc values (2019,'2019-02-15')
insert into Anio_Sc values (2020,'2020-02-15')
go

insert into Trimestre values('T1')
insert into Trimestre values('T2')
insert into Trimestre values('T3')
go

insert into Seccion values ('A')
insert into Seccion values ('B')
insert into Seccion values ('C')
insert into Seccion values ('D')
insert into Seccion values ('E')
insert into Seccion values ('F')
insert into Seccion values ('G')
insert into Seccion values ('H')
insert into Seccion values ('I')
go

insert into Grado values ('1')
insert into Grado values ('2')
insert into Grado values ('3')
insert into Grado values ('4')
insert into Grado values ('5')
insert into Grado values ('6')
go

insert into turno values ('M')
insert into turno values ('T')
go

insert into nivel values ('P')
insert into nivel values ('S')
go

insert into Aula values ('L001',2020,'5','A','M','S')
insert into Aula values ('L002',2020,'5','B','M','S')
insert into Aula values ('L003',2020,'5','C','M','S')
insert into Aula values ('L004',2020,'5','D','M','S')
insert into Aula values ('L005',2020,'5','E','M','S')
insert into Aula values ('L006',2020,'4','A','M','S')
insert into Aula values ('L007',2020,'4','B','M','S')
insert into Aula values ('L008',2020,'4','C','M','S')
insert into Aula values ('L009',2020,'4','D','M','S')
insert into Aula values ('L010',2020,'4','E','M','S')
insert into Aula values ('L011',2020,'3','A','M','S')
insert into Aula values ('L012',2020,'3','B','M','S')
insert into Aula values ('L013',2020,'3','C','M','S')
insert into Aula values ('L014',2020,'3','D','M','S')
insert into Aula values ('L015',2020,'3','E','M','S')
insert into Aula values ('L016',2020,'2','A','M','S')
insert into Aula values ('L017',2020,'2','B','M','S')
insert into Aula values ('L018',2020,'2','C','M','S')
insert into Aula values ('L019',2020,'2','D','M','S')
insert into Aula values ('L020',2020,'2','E','M','S')
go 

insert into Matriculas values ('MT01',2020,'L001')
insert into Matriculas values ('MT02',2020,'L001')
insert into Matriculas values ('MT03',2020,'L001')
insert into Matriculas values ('MT04',2020,'L001')
insert into Matriculas values ('MT05',2020,'L001')
insert into Matriculas values ('MT06',2020,'L001')
insert into Matriculas values ('MT07',2020,'L001')
insert into Matriculas values ('MT08',2020,'L001')
insert into Matriculas values ('MT09',2020,'L001')
insert into Matriculas values ('MT10',2020,'L001')
insert into Matriculas values ('MT11',2020,'L001')
insert into Matriculas values ('MT12',2020,'L001')
insert into Matriculas values ('MT13',2020,'L001')
insert into Matriculas values ('MT14',2020,'L002')
go

insert into Persona values('A001',2020,'Sotacuro','Reymundo','Senaida','1998-12-01','12345671','987654321','F','Mi casa 123')
insert into Persona values('A002',2020,'Chauca','Chavez','Yolanda','1998-12-01','12345670','987654321','F','Mi casa 123')
insert into Persona values('A003',2020,'Rocha','Chicana','Giannina','2000-01-01','12345674','987654321','F','Mi casa 12346')
insert into Persona values('T001',2020,'Rocha','Del Arce','Leonardo','1960-01-01','12345675','987654321','M','Mi casa 123')
insert into Persona values('P001',2020,'Peres','Acharte','Gabriela','1998-12-01','12345673','987654322','F','Mi casa 1235')
insert into Persona values('P002',2020,'LLanos','Bazan','Geraldine','1998-12-01','12345672','987654320','F','Mi casa 123')
--insert into Persona values('A008',2020,'Rocha','Chicana','Micaela','2000-01-01','12345679','987654323','F','Mi casa 12346')
go
insert into Apoderado values ('T001')
go
insert into Alumno values('MT01','A001','T001')
insert into Alumno values('MT02','A002','T001')
insert into Alumno values('MT03','A003','T001')
go
insert into Curso values('C001','MATEMATICAS')
insert into Curso values('C002','INGLES')
insert into Curso values('C003','CIENCIAS NATURALES')
insert into Curso values('C004','EDUCACION FISICA')
insert into Curso values('C005','ARTE')
insert into Curso values('C006','COMUNICACION')
insert into Curso values('C007','EDUCACION CIUDADANA Y CIVICA')
insert into Curso values('C008','COMPUTACION')
insert into Curso values('C009','PERSONA FAMILIA Y RELACIONES HUMANAS')
insert into Curso values('C010','RAZONAMIENTO VERBAL')
insert into Curso values('C011','RAZONAMIENTO MATEMATICO')
insert into Curso values('C012','RELIGION')
insert into Curso values('C013','---')
go
insert into Usuario values('A001','Alumna001','U001')
insert into Usuario values('A002','Alumna002','U004')
insert into Usuario values('A003','Alumna003','U005')
insert into Usuario values('P001','Profesora001','U002')
insert into Usuario values('P002','Profesora002','U003')
go
insert into Profesor values('P001')
insert into Profesor values('P002')
go
insert into Profesor_Curso values('PC01','P001','C001')
insert into Profesor_Curso values('PC02','P001','C002')
insert into Profesor_Curso values('PC03','P001','C003')
insert into Profesor_Curso values('PC04','P001','C004')
insert into Profesor_Curso values('PC05','P001','C005')
insert into Profesor_Curso values('PC06','P001','C006')
insert into Profesor_Curso values('PC07','P002','C007')
insert into Profesor_Curso values('PC08','P002','C008')
insert into Profesor_Curso values('PC09','P002','C009')
insert into Profesor_Curso values('PC10','P002','C010')
insert into Profesor_Curso values('PC11','P002','C011')
insert into Profesor_Curso values('PC12','P002','C012')
insert into Profesor_Curso values('PC13','P002','C013')
go
insert into Curso_Aula values('L001',1,'PC01')
insert into Curso_Aula values('L001',2,'PC02')
insert into Curso_Aula values('L001',3,'PC03')
insert into Curso_Aula values('L001',4,'PC04')
insert into Curso_Aula values('L001',5,'PC05')
insert into Curso_Aula values('L001',6,'PC06')
insert into Curso_Aula values('L001',7,'PC07')
insert into Curso_Aula values('L001',8,'PC08')
insert into Curso_Aula values('L001',9,'PC09')
insert into Curso_Aula values('L001',10,'PC10')
insert into Curso_Aula values('L001',11,'PC11')
insert into Curso_Aula values('L001',12,'PC12')

insert into Curso_Aula values('L002',1,'PC01')
insert into Curso_Aula values('L003',1,'PC01')
insert into Curso_Aula values('L004',1,'PC01')
insert into Curso_Aula values('L005',1,'PC01')
insert into Curso_Aula values('L006',1,'PC01')
insert into Curso_Aula values('L007',1,'PC01')
insert into Curso_Aula values('L008',1,'PC01')
insert into Curso_Aula values('L009',1,'PC01')
insert into Curso_Aula values('L010',1,'PC01')
insert into Curso_Aula values('L011',1,'PC01')
insert into Curso_Aula values('L012',1,'PC01')
insert into Curso_Aula values('L013',1,'PC01')
insert into Curso_Aula values('L014',1,'PC01')
insert into Curso_Aula values('L015',1,'PC01')
insert into Curso_Aula values('L016',1,'PC01')
go
insert into Citaciones values('MT01',1,'L001',1,'2019-12-10','la niña golpeo a su compañera')
insert into Citaciones values('MT01',2,'L001',1,'2019-12-10','la niña golpeo a su compañera otra vez')
insert into Citaciones values('MT01',3,'L001',1,'2019-12-26','la niña golpeo a su compañera otra vez y otra vez mas')
go

insert into Actividades values('L001',1,1,'2019-12-10','2019-12-11','Desarrollo de la pagina 440','T1')
insert into Actividades values('L001',2,1,'2019-12-12','2019-12-18','Desarrollo de la pagina 441','T1')
insert into Actividades values('L001',3,1,'2019-12-12','2019-12-12','Evaluacion continua 1','T1')
insert into Actividades values('L001',4,1,'2019-12-12','2019-12-18','Desarrollo de la pagina 122','T2')
insert into Actividades values('L001',5,1,'2019-12-12','2019-12-18','Desarrollo de la pagina 125','T2')
insert into Actividades values('L001',6,1,'2019-12-12','2019-12-12','Evaluacion continua 2','T2')
insert into Actividades values('L001',7,1,'2019-12-12','2019-12-18','Desarrollo de la pagina 123','T3')
insert into Actividades values('L001',8,1,'2019-12-12','2019-12-18','Desarrollo de la pagina 124','T3')
insert into Actividades values('L001',9,1,'2019-12-12','2019-12-12','Evaluacion continua 3','T3')
insert into Actividades values('L001',10,1,'2019-12-12','2019-12-12','Evaluacion continua 3','T1')
insert into Actividades values('L001',11,1,'2019-12-12','2019-12-12','Evaluacion continua 3','T1')
insert into Actividades values('L001',12,1,'2019-12-12','2019-12-12','tarea, tarea','T3')
insert into Actividades values('L001',13,1,'2019-12-12','2019-12-12','Evaluacion continua 3','T2')
insert into Actividades values('L001',14,1,'2019-12-12','2019-12-12','Evaluacion continua 3','T2')
insert into Actividades values('L001',15,1,'2019-12-12','2019-12-12','Evaluacion continua 3','T3')
insert into Actividades values('L001',16,1,'2019-12-12','2019-12-12','Evaluacion continua 3','T3')
insert into Actividades values('L001',17,1,'2020-01-01','2020-01-03','Tarea, tareita','T1')--T3
insert into Actividades values('L001',18,1,'2020-01-01','2020-01-08','Tarea, tareitadosssss','T1')
go
insert into Calificaciones_D values('B001','MT01')
insert into Calificaciones_D values('B002','MT02')
insert into Calificaciones_D values('B003','MT03')
go
insert into Calificaciones_C values('B001',1,1,'L001',1,'presentado','11')
insert into Calificaciones_C values('B001',2,1,'L001',2,'presentado','10')
insert into Calificaciones_C values('B001',3,1,'L001',3,'presentado','15')
insert into Calificaciones_C values('B001',4,1,'L001',4,'presentado','18')
insert into Calificaciones_C values('B001',5,1,'L001',5,'presentado','19')
insert into Calificaciones_C values('B001',6,1,'L001',6,'presentado','17')
insert into Calificaciones_C values('B001',7,1,'L001',7,'presentado','14')
insert into Calificaciones_C values('B001',8,1,'L001',8,'presentado','11')
insert into Calificaciones_C values('B001',9,1,'L001',9,'presentado','10')
insert into Calificaciones_C values('B001',12,1,'L001',10,'presentado','10')
insert into Calificaciones_C values('B001',13,1,'L001',11,'presentado','16')
insert into Calificaciones_C values('B001',14,1,'L001',12,'sin presentar','00')
insert into Calificaciones_C values('B001',15,1,'L001',13,'presentado','13')
insert into Calificaciones_C values('B001',16,1,'L001',14,'presentado','20')
insert into Calificaciones_C values('B001',17,1,'L001',15,'presentado','09')
insert into Calificaciones_C values('B001',18,1,'L001',16,'presentado','18')
go

insert into Tareas values('B001',1)
insert into Tareas values('B001',2)
insert into Tareas values('B001',4)
insert into Tareas values('B001',5)
insert into Tareas values('B001',7)
insert into Tareas values('B001',8)
go

insert into Evaluaciones values('B001',3)
insert into Evaluaciones values('B001',6)
insert into Evaluaciones values('B001',9)
insert into Evaluaciones values('B001',12)
insert into Evaluaciones values('B001',13)
insert into Evaluaciones values('B001',14)
insert into Evaluaciones values('B001',15)
insert into Evaluaciones values('B001',16)
insert into Evaluaciones values('B001',17)
go

insert into Asistencias values('2019-12-12 07:58:32','MT01')
insert into Asistencias values('2019-12-11 08:58:32','MT01')

insert into Asistencias values('2019-12-12 14:10:32','MT01')
insert into Asistencias values('2019-12-12 14:00:32','MT01')
go
insert into Ingreso values('2019-12-12 07:58:32','P','-','T3')
insert into Ingreso values('2019-12-11 08:58:32','P','-','T3')
go
insert into Salida values('2019-12-12 14:10:32')
insert into Salida values('2019-12-12 14:00:32')
go
insert into Asistencias_Curso values ('MT01',1,'L001','2019-01-01','A')
go










