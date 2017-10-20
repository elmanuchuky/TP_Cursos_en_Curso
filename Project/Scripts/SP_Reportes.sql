--Listado de inscriptos por curso
GO
CREATE PROCEDURE sp_inscriptos_por_curso
@mIdCurso int
AS
BEGIN
	SELECT dg.apellido + ' ' + dg.nombre Inscriptio, td.tipo + ' ' + dg.dni Documento
	FROM Inscripciones i join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales join Tipos_Dni td on td.id_tipo_dni = dg.id_tipo_dni
	WHERE i.id_estado = 2 AND i.id_curso = @mIdCurso
END

--sp_ver_pagos_x_mail
GO
CREATE PROCEDURE sp_ver_pagos_x_mail
@mMail varchar(100)
AS
BEGIN
	SELECT c.nombre Curso, p.monto Pago, p.fecha_pago Fecha
	FROM Pagos p join Inscripciones i on p.id_inscripcion = i.id_inscripcion join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales =cu.id_datos_generales join Cursos c on c.id_curso = i.id_curso
	WHERE dg.mail like @mMail
END

--sp_ver_adeudado_x_mail
GO
CREATE PROCEDURE sp_ver_adeudado_x_mail
@mMail varchar(100)
AS
BEGIN
	SELECT c.nombre Curso, (c.costo - vm.[Monto pagado]) Pago
	FROM Inscripciones i join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales =cu.id_datos_generales join Cursos c on c.id_curso = i.id_curso join vw_listar_pagos_totales vm on vm.Id = i.id_inscripcion
	WHERE dg.mail like @mMail
END
--Asistencia de un curso por fecha
GO
CREATE PROCEDURE sp_consultar_asistencia_x_fecha_x_curso
@mFechaAsistencia date,
@mCurso int
AS
BEGIN
	SELECT dg.apellido + ', ' + dg.nombre Cursante, td.tipo + ' ' + dg.dni Documento, a.esta_presente Presente
	FROM Asistencias a join Inscripciones i on a.id_inscripcion =i.id_inscripcion join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales join Tipos_Dni td on td.id_tipo_dni = dg.id_tipo_dni
	WHERE a.fecha_asistencia = @mFechaAsistencia AND i.id_curso = @mCurso
	ORDER BY 1
END

--Asistencia por inscripcion (un cursante en un curso)
GO
CREATE PROCEDURE sp_consultar_asistencia_x_cursante_x_curso
@mIdCursante int,
@mCurso int
AS
BEGIN
	SELECT a.fecha_asistencia Fecha, a.esta_presente Presente
	FROM Asistencias a join Inscripciones i on a.id_inscripcion =i.id_inscripcion
	WHERE i.id_cursante = @mIdCursante AND i.id_curso = @mCurso
	ORDER BY a.fecha_asistencia
END

--sp_consultar_pagos_totales_x_inscripto_x_fecha
GO
CREATE PROCEDURE sp_consultar_pagos_totales_x_inscripto
@mIdInscripto int
AS
BEGIN
	SELECT p.fecha_pago Fecha, p.monto [Monto pagado]
	FROM Pagos p
	WHERE p.id_inscripcion = @mIdInscripto
	ORDER BY p.fecha_pago
END

--sp_consultar_monto_adeudado_x_inscripto
GO
CREATE PROCEDURE sp_consultar_monto_adeudado_x_inscripto
@mIdInscripto int
AS
BEGIN
	DECLARE @mPagado decimal(18,0)
	SELECT @mPagado = SUM(p.monto)
	FROM Pagos p
	WHERE p.id_inscripcion = @mIdInscripto
	SELECT i.precio_total - @mPagado Adeuda
	FROM Inscripciones i
	WHERE i.id_inscripcion = @mIdInscripto
END

--Trigger actualizar estado a inscripto
GO
CREATE TRIGGER tg_actualizar_a_inscripto ON Pagos
INSTEAD OF INSERT
AS
BEGIN
	DECLARE @mIdInscrip int
	SELECT @mIdInscrip = i.id_inscripcion
	FROM inserted i
	DECLARE @mMonto int
	SELECT @mMonto = i.monto
	FROM inserted i
	DECLARE @mCantidad int
	SELECT @mCantidad = COUNT(*)
	FROM Pagos p
	WHERE p.id_inscripcion = @mIdInscrip
	IF (@mCantidad is null)
	BEGIN
		UPDATE Inscripciones SET id_estado = 2
		WHERE id_inscripcion = @mIdInscrip
	END
	EXEC sp_insert_pago @mIdInscrip, @mMonto
END