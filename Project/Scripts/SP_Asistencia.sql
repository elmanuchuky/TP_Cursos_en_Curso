CREATE PROCEDURE sp_listado_cursantes_x_curso
@mIdCurso int
AS
BEGIN
	SELECT dg.apellido + ', ' + dg.nombre Cursante
	FROM Inscripciones i join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales
	WHERE i.id_curso = @mIdCurso
	ORDER BY dg.apellido, dg.nombre
END

GO
CREATE PROCEDURE sp_asistencia_x_curso_x_fecha
@mIdCurso int,
@mFecha Date
AS
BEGIN
	SELECT a.esta_presente Presente
	FROM Asistencias a join Inscripciones i on i.id_inscripcion = a.id_inscripcion join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales
	WHERE i.id_curso = @mIdCurso AND a.fecha_asistencia = @mFecha
	ORDER BY dg.apellido, dg.nombre
END

GO
CREATE PROCEDURE sp_fechas_x_curso
@mIdCurso int
AS
BEGIN
	SELECT a.fecha_asistencia Fecha
	FROM Asistencias a join Inscripciones i on i.id_inscripcion = a.id_inscripcion
	WHERE i.id_curso = @mIdCurso
	GROUP BY a.fecha_asistencia
	ORDER BY 1
END