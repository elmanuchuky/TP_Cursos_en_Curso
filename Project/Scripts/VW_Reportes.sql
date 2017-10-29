/*Consultar cursos pr�ximos de inicio con respecto a la fecha actual 
(> getdate()), debe mostrar el nombre del curso, la fecha de inicio, 
la duraci�n total en semanas, el costo, d�a y horario y la carga 
horaria del mismo*/
--Todos
GO
CREATE VIEW vw_consultar_cursos_todos
AS
SELECT c.id_curso Id, c.nombre Curso, c.aula Aula, c.temas Temas, c.descripcion Descripcion, c.fecha_inicio Inicio, c.duracion_total_semanas [Cantidad de semanas], c.costo Costo, DATEPART(dw,c.dia_horario) Dia, RIGHT(CONVERT(VARCHAR, c.dia_horario, 100),7) Horario, c.carga_horaria [Carga horaria por dia]
FROM Cursos c
--En curso y proximos
GO
CREATE VIEW vw_consultar_cursos_en_curso_y_proximos
AS
SELECT c.id_curso Id, c.nombre Curso, c.aula Aula, c.temas Temas, c.descripcion Descripcion, c.fecha_inicio Inicio, c.duracion_total_semanas [Cantidad de semanas], c.costo Costo, DATEPART(dw,c.dia_horario) Dia, RIGHT(CONVERT(VARCHAR, c.dia_horario, 100),7) Horario, c.carga_horaria [Carga horaria por dia]
FROM Cursos c
WHERE DATEADD(WEEK,c.duracion_total_semanas, c.fecha_inicio)  > GETDATE()
--En curso
GO
CREATE VIEW vw_consultar_cursos_en_curso
AS
SELECT c.id_curso Id, c.nombre Curso, c.aula Aula, c.temas Temas, c.descripcion Descripcion, c.fecha_inicio Inicio, c.duracion_total_semanas [Cantidad de semanas], c.costo Costo, DATEPART(dw,c.dia_horario) Dia, RIGHT(CONVERT(VARCHAR, c.dia_horario, 100),7) Horario, c.carga_horaria [Carga horaria por dia]
FROM Cursos c
WHERE GETDATE() BETWEEN c.fecha_inicio AND DATEADD(WEEK,c.duracion_total_semanas, c.fecha_inicio)
--Proximos
GO
CREATE VIEW vw_consultar_cursos_proximos
AS
SELECT c.id_curso Id, c.nombre Curso, c.aula Aula, c.cupo Cupo, c.temas Temas, c.descripcion Descripcion, c.fecha_inicio Inicio, c.duracion_total_semanas [Cantidad de semanas], c.costo Costo, DATEPART(dw,c.dia_horario) Dia, RIGHT(CONVERT(VARCHAR, c.dia_horario, 100),7) Horario, c.carga_horaria [Carga horaria por dia]
FROM Cursos c
WHERE GETDATE() < c.fecha_inicio
--vw_listar_pagos_totales
--Se usa internamente para la siguiente consulta
GO
CREATE VIEW vw_listar_pagos_totales
AS
SELECT p.id_inscripcion Id, SUM(p.monto) [Monto pagado]
FROM Pagos p
GROUP BY p.id_inscripcion
--Listado de inscriptos por cursos por comenzar
GO
CREATE VIEW vw_preinscriptos_cursos_x_comenzar_o_en_curso
AS
SELECT c.nombre Curso, dg.apellido + ' ' + dg.nombre Cursante, td.tipo + ' ' + CONVERT(varchar(50), dg.dni) Documento, c.fecha_inicio [Fecha de inicio], vm.[Monto pagado] [Monto pagado], c.costo [Total del curso]
FROM Inscripciones i join Cursos c on c.id_curso = i.id_curso join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales join Tipos_Dni td on td.id_tipo_dni = dg.id_tipo_dni join vw_listar_pagos_totales vm on vm.Id = i.id_inscripcion
WHERE i.id_estado = 1 AND GETDATE() < c.fecha_inicio
ORDER BY 4, 1, 2
/*Lista de Inscripciones con porcentaje de presentismo que superan o igualan el 80%*/
GO
CREATE VIEW vw_inscripciones_con_presentismo_minimo_80
AS
SELECT a.id_inscripcion id_inscripcion, 100 * (SUM(CAST(a.esta_presente AS INT)) / (1.0 * COUNT(*))) Presentismo
FROM Asistencias a
GROUP BY a.id_inscripcion
HAVING SUM(CAST(a.esta_presente AS INT)) >= .8 * COUNT(*)

/*Lista de Inscripciones con el monto abonado actualmente*/
GO
CREATE VIEW vw_inscripciones_con_monto_actual
AS
SELECT p.id_inscripcion id_inscripcion, SUM(p.monto) Abonado
FROM Pagos p join Inscripciones i on p.id_inscripcion = i.id_inscripcion
GROUP BY p.id_inscripcion

/*Lista de Inscripciones con el monto abonado actualmente*/
GO
CREATE VIEW vw_inscripciones_con_pago_completo
AS
SELECT i.id_inscripcion
FROM Inscripciones i join vw_inscripciones_con_monto_actual vw on i.id_inscripcion = vw.id_inscripcion
WHERE i.precio_total = vw.Abonado

/*Debe permitir consultar todos los inscriptos con el 100% del curso 
pago y el 80% de asistencia (validar que este aprobado, 
precio_total - monto adeudado = 0 y porcentaje de asistencia ok) 
mostrando apellido y nombre del inscripto, curso al que pertenece y 
porcentaje de asistencia al mismo //esto ultimo puede ser opcional 
dar opini�n*/
GO
CREATE VIEW vw_consultar_inscriptos_aptos_certificado
AS
SELECT dg.apellido + ', ' + dg.nombre Inscripto, c.nombre Curso, vw_80.Presentismo
FROM Cursos c join Inscripciones i on i.id_curso = c.id_curso join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales join vw_inscripciones_con_presentismo_minimo_80 vw_80 on vw_80.id_inscripcion = i.id_inscripcion
WHERE i.id_inscripcion in (SELECT vw.id_inscripcion FROM vw_inscripciones_con_presentismo_minimo_80 vw)
AND i.id_inscripcion in (SELECT vw.id_inscripcion FROM vw_inscripciones_con_pago_completo vw)

/*Debe permitir consultar todos los matriculados registrados en el 
colegio de Inform�tica, mostrando el legajo, todos sus datos personales 
y la profesi�n*/
GO
CREATE VIEW vw_consultar_matriculados
AS
SELECT m.legajo_matriculado Legajo, dg.apellido + ', ' + dg.nombre Matriculado, td.tipo + ' ' + dg.dni Documento, dg.fecha_nacimiento [Fecha de nacimiento], dg.telefono Telefono, dg.mail Mail, m.profesion Profesion
FROM Matriculados m join Datos_Generales dg on dg.id_datos_generales = m.id_datos_generales join Tipos_Dni td on td.id_tipo_dni = dg.id_tipo_dni

-- vw_cursos_actuales_combo   id, curso
GO
CREATE VIEW vw_cursos_actuales_combo
AS
SELECT c.id_curso id, c.nombre curso, *
FROM Cursos c
WHERE GETDATE() BETWEEN c.fecha_inicio AND DATEADD(WEEK,c.duracion_total_semanas, c.fecha_inicio)
-- vw_cursos_proximos_combo   id, curso, fecha
GO
CREATE VIEW vw_cursos_proximos_combo
AS
SELECT c.id_curso id, c.nombre curso, c.fecha_inicio fecha
FROM Cursos c
WHERE c.fecha_inicio > GETDATE()