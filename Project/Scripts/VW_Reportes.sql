/*Consultar cursos próximos de inicio con respecto a la fecha actual 
(> getdate()), debe mostrar el nombre del curso, la fecha de inicio, 
la duración total en semanas, el costo, día y horario y la carga 
horaria del mismo*/
GO
CREATE VIEW vw_consultar_cursos_proximos
AS
SELECT c.nombre Curso, c.fecha_inicio Inicio, c.duracion_total_semanas [Cantidad de semanas], c.costo Costo, DATEPART(dw,c.dia_horario) Dia, RIGHT(CONVERT(VARCHAR, c.dia_horario, 100),7) Horario, c.carga_horaria [Carga horaria por dia]
FROM Cursos c

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
dar opinión*/
GO
CREATE VIEW vw_consultar_inscriptos_aptos_certificado
AS
SELECT dg.apellido + ', ' + dg.nombre Inscripto, c.nombre Curso, vw_80.Presentismo
FROM Cursos c join Inscripciones i on i.id_curso = c.id_curso join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales join vw_inscripciones_con_presentismo_minimo_80 vw_80 on vw_80.id_inscripcion = i.id_inscripcion
WHERE i.id_inscripcion in (SELECT vw.id_inscripcion FROM vw_inscripciones_con_presentismo_minimo_80 vw)
AND i.id_inscripcion in (SELECT vw.id_inscripcion FROM vw_inscripciones_con_pago_completo vw)

/*En este caso se trata de un procedimiento almacenado, debe permitir 
consultar todos los pagos individuales registrados de un solo inscripto 
por vez, la búsqueda debe poder realizarse por apellido y nombre, 
legajo (solo si se controla la diferencia entre familiar y matriculado) 
o dni, mostrando estos datos como retorno, el monto abonado y la fecha 
del pago (esto serviría por ejemplo por si el inscripto pierde un 
comprobante para poder buscarlo y re-imprimirlo)*/
-- Lo divido en dos partes
--Funcion para obtener id_inscripcion segun ciertos parametros
GO
CREATE FUNCTION fn_obtener_id_inscripcion_x_mail_x_curso (@mIdCurso int, @mMail varchar(100))
RETURNS int
AS
BEGIN
	DECLARE @mIdInscripcion int
	SELECT @mIdInscripcion = i.id_inscripcion
	FROM Inscripciones i join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales
	WHERE i.id_curso = @mIdCurso AND dg.mail like @mMail
	IF (@mIdInscripcion is null)
	BEGIN
		SET @mIdInscripcion = -1
	END
	RETURN @mIdInscripcion
END

-- SP para ver los pagos individuales segun el id_inscripcion
GO
CREATE PROCEDURE sp_consultar_pago_x_inscripto
@mIdInscripcion int
AS
BEGIN
	SELECT p.monto Monto, p.fecha_pago Fecha
	FROM Pagos p
	WHERE p.id_inscripcion = @mIdInscripcion
END

/*Debe permitir consultar todos los matriculados registrados en el 
colegio de Informática, mostrando el legajo, todos sus datos personales 
y la profesión*/
GO
CREATE VIEW vw_consultar_matriculados
AS
SELECT m.legajo_matriculado Legajo, dg.apellido + ', ' + dg.nombre Matriculado, td.tipo + ' ' + dg.dni Documento, dg.fecha_nacimiento [Fecha de nacimiento], dg.telefono Telefono, dg.mail Mail, m.profesion Profesion
FROM Matriculados m join Datos_Generales dg on dg.id_datos_generales = m.id_datos_generales join Tipos_Dni td on td.id_tipo_dni = dg.id_tipo_dni