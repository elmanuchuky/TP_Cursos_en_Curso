--Cursantes
GO
CREATE PROCEDURE sp_update_cursante
@mId int,
@mIdMatriculado int,
@mEsFamilia bit,
@mIdDatosGenerales int
AS
BEGIN
	UPDATE Cursantes SET id_matriculado = @mIdMatriculado, es_familia = @mEsFamilia, id_datos_generales = @mIdDatosGenerales
	WHERE @mId = id_cursante
END
--Matriculados
GO
CREATE PROCEDURE sp_update_matriculado
@mId int,
@mIdDatosGenerales int,
@mProfesion varchar(50)
AS
BEGIN
	UPDATE Matriculados SET id_datos_generales = @mIdDatosGenerales, profesion = @mProfesion
	WHERE @mId = id_matriculado
END
--Inscripciones
GO
CREATE PROCEDURE sp_update_inscripcion
@mId int,
@mIdCurso int,
@mIdCursante int
AS
BEGIN
	UPDATE Inscripciones SET id_curso = @mIdCurso, id_cursante = @mIdCursante
	WHERE @mId = id_inscripcion
END
--Cursos largo
GO
CREATE PROCEDURE sp_update_curso_largo
@mId int,
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
	UPDATE Cursos SET nombre = @mNombre, descripcion = @mDescripcion, fecha_inicio = @mFechaInicio, temas = @mTemas, duracion_total_semanas = @mDuracionSemanas, costo = @mCosto, cupo = @mCupo, aula = @mAula, dia_horario = @mDiaHorario, carga_horaria = @mCargaHoraria
	WHERE @mId = id_curso
END
--Cursos corto
GO
CREATE PROCEDURE sp_update_curso_corto
@mId int,
@mNombre varchar(100),
@mDescripcion varchar(2000),
@mTemas varchar(2000),
@mAula varchar(10)
AS
BEGIN
	UPDATE Cursos SET nombre = @mNombre, descripcion = @mDescripcion, temas = @mTemas, aula = @mAula
	WHERE @mId = id_curso
END
--Asistencias
GO
CREATE PROCEDURE sp_update_asistencia
@mIdInscripcion int,
@mIdFecha datetime,
@mEstaPresente bit
AS
BEGIN
	UPDATE Asistencias SET esta_presente = @mEstaPresente
	WHERE @mIdFecha = fecha_asistencia AND @mIdInscripcion = id_inscripcion
END
--Datos Generales
GO
CREATE PROCEDURE sp_update_datos_generales
@mId int,
@mNombre varchar(50),
@mApelldio varchar(50),
@mIdTipoDni int,
@mDni int,
@mFechaNacimiento date,
@mTelefono varchar(11),
@mMail varchar(100)
AS
BEGIN
	UPDATE Datos_Generales SET nombre = @mNombre, apellido = @mApelldio, id_tipo_dni = @mIdTipoDni, dni = @mDni, fecha_nacimiento = @mFechaNacimiento, telefono = @mTelefono, mail = @mMail
	WHERE @mId = id_datos_generales
END