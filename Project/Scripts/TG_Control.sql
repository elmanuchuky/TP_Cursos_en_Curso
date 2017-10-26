-- Trigger para acutalizar el cupo cada nuevo inscripto
GO
CREATE TRIGGER tg_actualizar_cupo
ON Inscripciones
INSTEAD OF INSERT
AS
BEGIN
	DECLARE @mIdCurso int
	DECLARE @mIdCursante int
	SELECT @mIdCurso = i.id_curso, @mIdCursante = i.id_cursante
	FROM inserted i
	DECLARE @mCupo int
	SELECT @mCupo = c.cupo
	FROM Cursos c
	WHERE c.id_curso = @mIdCurso
	IF (@mCupo = 0)
		BEGIN
			PRINT 'Error, el curso esta lleno!'
		END
	ELSE
		BEGIN
			EXEC sp_insert_inscripcion @mIdCurso, @mIdCursante
			UPDATE Cursos SET cupo = (@mCupo - 1)
			WHERE id_curso = @mIdCurso
		END
END
-- Trigger para realizar los updates correctos de cursos
GO
CREATE TRIGGER tg_update_cursos
ON Cursos
INSTEAD OF UPDATE
AS
BEGIN
	DECLARE @mIdCurso int
	DECLARE @mNombre varchar(100)
	DECLARE @mDescripcion varchar(2000)
	DECLARE @mFechaInicio date
	DECLARE @mTemas varchar(2000)
	DECLARE @mDuracionSemanas int
	DECLARE @mCosto decimal(18,0)
	DECLARE @mCupo int
	DECLARE @mAula varchar(10)
	DECLARE @mDiaHorario datetime
	DECLARE @mCargaHoraria int
	SELECT @mIdCurso = i.id_curso, @mNombre = i.nombre, @mDescripcion = i.descripcion, @mFechaInicio = i.fecha_inicio, @mTemas = i.temas, @mDuracionSemanas = i.duracion_total_semanas, @mCosto = i.costo, @mCupo = i.cupo, @mAula = i.aula, @mDiaHorario = i.dia_horario, @mCargaHoraria = i.carga_horaria
	FROM inserted i
	DECLARE @mHayInscripto int
	SELECT @mHayInscripto = count(i.id_curso)
	FROM Inscripciones i
	WHERE i.id_curso = @mIdCurso
	IF (@mHayInscripto IS NULL)
		BEGIN
			EXEC sp_update_curso_largo @mIdCurso, @mNombre, @mDescripcion, @mFechaInicio, @mTemas, @mDuracionSemanas, @mCosto, @mCupo, @mAula, @mDiaHorario, @mCargaHoraria
		END
	ELSE
		BEGIN
			EXEC sp_update_curso_corto @mIdCurso, @mNombre, @mDescripcion, @mTemas, @mAula
		END
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
	DECLARE @mMaximo int
	SELECT @mMaximo = c.costo
	FROM Cursos c join Inscripciones i on i.id_curso = c.id_curso
	WHERE i.id_inscripcion = @mIdInscrip
	DECLARE @mCantidad int
	SELECT @mCantidad = SUM(p.monto)
	FROM Pagos p
	WHERE p.id_inscripcion = @mIdInscrip
	IF (@mCantidad is null)
	BEGIN
		SET @mCantidad = 0
	END
	DECLARE @mPagar int
	IF ((@mMonto + @mCantidad) > @mMaximo)
	BEGIN
		SET @mPagar = (@mMaximo - @mCantidad)
		EXEC sp_insert_pago @mIdInscrip, @mPagar
	END
	ELSE
	BEGIN
		EXEC sp_insert_pago @mIdInscrip, @mMonto
	END
	IF ((@mMonto + @mCantidad) >= (@mMaximo / 2))
	BEGIN
		UPDATE Inscripciones SET id_estado = 2
		WHERE id_inscripcion = @mIdInscrip
	END
END

--Trigger tg_generar_legajo
GO
CREATE TRIGGER tg_generar_legajo ON Matriculados
INSTEAD OF INSERT
AS
BEGIN
	DECLARE @mBase int
	SET @mBase = ((10 + (YEAR(GETDATE()) - 2016)) * 10000)
	SELECT @mBase += MAX(m.id_matriculado)
	FROM Matriculados m
	DECLARE @mIdDatosGenerales int
	SELECT @mIdDatosGenerales = i.id_datos_generales
	FROM inserted i
	DECLARE @mProfesion varchar(50)
	SELECT @mProfesion = i.profesion
	FROM inserted i
	EXEC sp_insert_matriculado_interno @mBase, @mIdDatosGenerales, @mProfesion
END