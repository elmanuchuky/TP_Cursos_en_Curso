--Cursantes
GO
CREATE PROCEDURE sp_insert_cursante
@mIdMatriculado int,
@mEsFamilia bit,
@mIdDatosGenerales int
AS
BEGIN
	INSERT INTO Cursantes (id_matriculado, es_familia, id_datos_generales)
	VALUES (@mIdMatriculado, @mEsFamilia, @mIdDatosGenerales)
END
--Matriculados
GO
CREATE PROCEDURE sp_insert_matriculado
@mLegajoMatriculado int,
@mIdDatosGenerales int,
@mProfesion varchar(50)
AS
BEGIN
	INSERT INTO Matriculados (legajo_matriculado, id_datos_generales, profesion)
	VALUES (@mLegajoMatriculado, @mIdDatosGenerales, @mProfesion)
END
--Inscripciones
GO
CREATE PROCEDURE sp_insert_inscripcion
@mIdCurso int,
@mIdCursante int,
@mIdEstado int,
@mAprobado bit
AS
BEGIN
	DECLARE @mPrecioTotal decimal(18,0)
	SELECT @mPrecioTotal = c.costo
	FROM Cursos c WHERE c.id_curso = @mIdCurso
	INSERT INTO Inscripciones (id_curso, id_cursante, id_estado, fecha_realizada, approbado)
	VALUES (@mIdCurso, @mIdCursante, @mIdEstado, convert(date, getdate()), @mAprobado)
END
--Cursos
GO
CREATE PROCEDURE sp_insert_curso
@mNombre varchar(100),
@mDescripcion varchar(2000),
@mFechaInicio date,
@mTemas varchar(2000),
@mDuracionSemanas int,
@mCosto decimal(18,0),
@mCupo int,
@mAula varchar(10),
@mDiaHorario datetime,
@mCargaHoraria int
AS
BEGIN
	INSERT INTO Cursos (nombre, descripcion, fecha_inicio, temas, duracion_total_semanas, costo, cupo, aula, dia_horario, carga_horaria)
	VALUES (@mNombre, @mDescripcion, @mFechaInicio, @mTemas, @mDuracionSemanas, @mCosto, @mCupo, @mAula, @mDiaHorario, @mCargaHoraria)
END
--Asistencias
GO
CREATE PROCEDURE sp_insert_asistencia
@mIdInscripcion int,
@mFechaAsistencia date,
@mEstaPresente bit
AS
BEGIN
	INSERT INTO Asistencias(id_inscripcion, fecha_asistencia, esta_presente)
	VALUES (@mIdInscripcion, @mFechaAsistencia, @mEstaPresente)
END
--Pagos
GO
CREATE PROCEDURE sp_insert_pago
@mIdInscripcion int,
@mMonto decimal(18,0)
AS
BEGIN
	INSERT INTO Pagos(id_inscripcion, monto, fecha_pago)
	VALUES (@mIdInscripcion, @mMonto, getdate())
END
--Datos Generales
GO
CREATE PROCEDURE sp_insert_datos_generales
@mNombre varchar(50),
@mApelldio varchar(50),
@mIdTipoDni int,
@mDni int,
@mFechaNacimiento date,
@mTelefono varchar(11),
@mMail varchar(100)
AS
BEGIN
	INSERT INTO Datos_Generales(nombre, apellido, id_tipo_dni, dni, fecha_nacimiento, telefono, mail)
	VALUES (@mNombre, @mApelldio, @mIdTipoDni, @mDni, @mFechaNacimiento, @mTelefono, @mMail)
END