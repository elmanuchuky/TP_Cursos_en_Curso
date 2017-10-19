--Cursantes
GO
CREATE PROCEDURE sp_update_cursante
@mIdMatriculado int,
@mEsFamilia bit,
@mIdDatosGenerales int
AS
BEGIN
	UPDATE Cursantes SET id_matriculado = @mIdMatriculado, es_familia = @mEsFamilia, id_datos_generales = @mIdDatosGenerales
END
--Matriculados
GO
CREATE PROCEDURE sp_update_matriculado
@mIdDatosGenerales int,
@mProfesion varchar(50)
AS
BEGIN
	UPDATE Matriculados SET id_datos_generales = @mIdDatosGenerales, profesion = @mProfesion
END
--Inscripciones
GO
CREATE PROCEDURE sp_update_inscripcion
@mIdCurso int,
@mIdCursante int
AS
BEGIN
	UPDATE Inscripciones SET id_curso = @mIdCurso, id_cursante = @mIdCursante
END
--Cursos
GO
CREATE PROCEDURE sp_update_curso
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
END
--Asistencias
GO
CREATE PROCEDURE sp_update_asistencia
@mEstaPresente bit
AS
BEGIN
	UPDATE Asistencias SET esta_presente = @mEstaPresente
END
--Datos Generales
GO
CREATE PROCEDURE sp_update_datos_generales
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
END