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