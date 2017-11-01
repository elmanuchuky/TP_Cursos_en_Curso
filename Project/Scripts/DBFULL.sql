USE [master]
GO
/****** Object:  Database [Colegio_Informatica_Metodologia]    Script Date: 11/1/2017 1:40:51 PM ******/
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'Colegio_Informatica_Metodologia')
BEGIN
CREATE DATABASE [Colegio_Informatica_Metodologia] ON  PRIMARY 
( NAME = N'Colegio_Informatica_Metodologia', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Colegio_Informatica_Metodologia.mdf' , SIZE = 3264KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Colegio_Informatica_Metodologia_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\Colegio_Informatica_Metodologia_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
END

GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Colegio_Informatica_Metodologia].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET ARITHABORT OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET  MULTI_USER 
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET DB_CHAINING OFF 
GO
USE [Colegio_Informatica_Metodologia]
GO
/****** Object:  UserDefinedFunction [dbo].[fn_obtener_id_inscripcion_x_apellido_y_mail]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[fn_obtener_id_inscripcion_x_apellido_y_mail]') AND type in (N'FN', N'IF', N'TF', N'FS', N'FT'))
BEGIN
execute dbo.sp_executesql @statement = N'CREATE FUNCTION [dbo].[fn_obtener_id_inscripcion_x_apellido_y_mail] (@mIdCurso int, @mMail varchar(100))
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
END' 
END

GO
/****** Object:  UserDefinedFunction [dbo].[fn_obtener_id_inscripcion_x_mail_x_curso]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[fn_obtener_id_inscripcion_x_mail_x_curso]') AND type in (N'FN', N'IF', N'TF', N'FS', N'FT'))
BEGIN
execute dbo.sp_executesql @statement = N'CREATE FUNCTION [dbo].[fn_obtener_id_inscripcion_x_mail_x_curso] (@mIdCurso int, @mMail varchar(100))
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
END' 
END

GO
/****** Object:  Table [dbo].[Asistencias]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Asistencias]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Asistencias](
	[id_inscripcion] [int] NOT NULL,
	[fecha_asistencia] [date] NOT NULL,
	[esta_presente] [bit] NULL,
 CONSTRAINT [pk_asistencia_fecha] PRIMARY KEY CLUSTERED 
(
	[id_inscripcion] ASC,
	[fecha_asistencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Cursantes]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Cursantes]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Cursantes](
	[id_cursante] [int] IDENTITY(1,1) NOT NULL,
	[id_matriculado] [int] NULL,
	[es_familia] [bit] NOT NULL,
	[id_datos_generales] [int] NULL,
 CONSTRAINT [pk_cursante] PRIMARY KEY CLUSTERED 
(
	[id_cursante] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Cursos]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Cursos]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Cursos](
	[id_curso] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](100) NULL,
	[descripcion] [varchar](2000) NULL,
	[fecha_inicio] [date] NULL,
	[temas] [varchar](2000) NULL,
	[duracion_total_semanas] [int] NULL,
	[costo] [decimal](18, 0) NULL,
	[cupo] [int] NULL,
	[aula] [varchar](10) NULL,
	[dia_horario] [datetime] NULL,
	[carga_horaria] [int] NULL,
 CONSTRAINT [pk_Cursos] PRIMARY KEY CLUSTERED 
(
	[id_curso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Datos_Generales]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Datos_Generales]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Datos_Generales](
	[id_datos_generales] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NULL,
	[apellido] [varchar](50) NULL,
	[id_tipo_dni] [int] NULL,
	[dni] [int] NOT NULL,
	[fecha_nacimiento] [date] NULL,
	[telefono] [varchar](11) NULL,
	[mail] [varchar](100) NULL,
 CONSTRAINT [pk_datos_generales] PRIMARY KEY CLUSTERED 
(
	[id_datos_generales] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Estados]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Estados]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Estados](
	[id_estado] [int] IDENTITY(1,1) NOT NULL,
	[estado] [varchar](50) NULL,
 CONSTRAINT [pk_estado] PRIMARY KEY CLUSTERED 
(
	[id_estado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Inscripciones]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Inscripciones]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Inscripciones](
	[id_inscripcion] [int] IDENTITY(1,1) NOT NULL,
	[id_curso] [int] NOT NULL,
	[id_cursante] [int] NOT NULL,
	[id_estado] [int] NOT NULL,
	[fecha_realizada] [date] NULL,
	[aprobado] [bit] NULL,
	[precio_total] [decimal](18, 0) NULL,
 CONSTRAINT [pk_inscripcion] PRIMARY KEY CLUSTERED 
(
	[id_inscripcion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Matriculados]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Matriculados]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Matriculados](
	[id_matriculado] [int] IDENTITY(1,1) NOT NULL,
	[legajo_matriculado] [int] NULL,
	[id_datos_generales] [int] NOT NULL,
	[profesion] [varchar](50) NULL,
 CONSTRAINT [pk_matriculado] PRIMARY KEY CLUSTERED 
(
	[id_matriculado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Pagos]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Pagos]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Pagos](
	[id_pago] [int] IDENTITY(1,1) NOT NULL,
	[id_inscripcion] [int] NOT NULL,
	[monto] [decimal](18, 0) NOT NULL,
	[fecha_pago] [datetime] NOT NULL,
 CONSTRAINT [PK_Pagos] PRIMARY KEY CLUSTERED 
(
	[id_pago] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Table_1]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Table_1]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Table_1](
	[num] [int] NULL
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Testing]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Testing]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Testing](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[booleano] [bit] NULL,
	[referencia] [int] NULL
) ON [PRIMARY]
END
GO
/****** Object:  Table [dbo].[Tipos_Dni]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Tipos_Dni]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Tipos_Dni](
	[id_tipo_dni] [int] IDENTITY(1,1) NOT NULL,
	[tipo] [varchar](50) NULL,
 CONSTRAINT [pk_tipo_dni] PRIMARY KEY CLUSTERED 
(
	[id_tipo_dni] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_PADDING OFF
GO
/****** Object:  View [dbo].[vw_listar_pagos_totales]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_listar_pagos_totales]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_listar_pagos_totales]
AS
SELECT p.id_inscripcion Id, SUM(p.monto) [Monto pagado]
FROM Pagos p
GROUP BY p.id_inscripcion' 
GO
/****** Object:  View [dbo].[vw_preinscriptos_cursos_x_comenzar_o_en_curso]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_preinscriptos_cursos_x_comenzar_o_en_curso]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_preinscriptos_cursos_x_comenzar_o_en_curso]
AS
SELECT c.nombre Curso, dg.apellido + '' '' + dg.nombre Cursante, td.tipo + '' '' + CONVERT(varchar(50), dg.dni) Documento, c.fecha_inicio [Fecha de inicio], vm.[Monto pagado] [Monto pagado], c.costo [Total del curso]
FROM Inscripciones i join Cursos c on c.id_curso = i.id_curso join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales join Tipos_Dni td on td.id_tipo_dni = dg.id_tipo_dni join vw_listar_pagos_totales vm on vm.Id = i.id_inscripcion
WHERE i.id_estado = 1 AND GETDATE() < c.fecha_inicio' 
GO
/****** Object:  View [dbo].[vw_inscripciones_con_pago_completo]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_inscripciones_con_pago_completo]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_inscripciones_con_pago_completo]
AS
SELECT i.id_inscripcion
FROM Inscripciones i
WHERE i.id_estado = 2' 
GO
/****** Object:  View [dbo].[vw_inscripciones_con_presentismo_minimo_80]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_inscripciones_con_presentismo_minimo_80]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_inscripciones_con_presentismo_minimo_80]
AS
SELECT a.id_inscripcion id_inscripcion, 100 * (SUM(CAST(a.esta_presente AS INT)) / (1.0 * COUNT(*))) Presentismo
FROM Asistencias a
GROUP BY a.id_inscripcion
HAVING SUM(CAST(a.esta_presente AS INT)) >= .8 * COUNT(*)

/*Lista de Inscripciones con el monto abonado actualmente*/
' 
GO
/****** Object:  View [dbo].[vw_consultar_inscriptos_aptos_certificado]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_consultar_inscriptos_aptos_certificado]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_consultar_inscriptos_aptos_certificado]
AS
SELECT dg.apellido + '', '' + dg.nombre Inscripto, c.nombre Curso, vw_80.Presentismo
FROM Cursos c join Inscripciones i on i.id_curso = c.id_curso join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales join vw_inscripciones_con_presentismo_minimo_80 vw_80 on vw_80.id_inscripcion = i.id_inscripcion
WHERE i.id_inscripcion in (SELECT vw.id_inscripcion FROM vw_inscripciones_con_presentismo_minimo_80 vw)
AND i.id_inscripcion in (SELECT vw.id_inscripcion FROM vw_inscripciones_con_pago_completo vw)

/*Debe permitir consultar todos los matriculados registrados en el 
colegio de Informática, mostrando el legajo, todos sus datos personales 
y la profesión*/
' 
GO
/****** Object:  View [dbo].[vw_consultar_cursos_en_curso]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_consultar_cursos_en_curso]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_consultar_cursos_en_curso]
AS
SELECT c.id_curso Id, c.nombre Curso, c.aula Aula, c.temas Temas, c.descripcion Descripcion, c.fecha_inicio Inicio, c.duracion_total_semanas [Cantidad de semanas], c.costo Costo, DATEPART(dw,c.dia_horario) Dia, RIGHT(CONVERT(VARCHAR, c.dia_horario, 100),7) Horario, c.carga_horaria [Carga horaria por dia]
FROM Cursos c
WHERE GETDATE() BETWEEN c.fecha_inicio AND DATEADD(WEEK,c.duracion_total_semanas, c.fecha_inicio)
--Proximos
' 
GO
/****** Object:  View [dbo].[vw_consultar_cursos_en_curso_y_proximos]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_consultar_cursos_en_curso_y_proximos]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_consultar_cursos_en_curso_y_proximos]
AS
SELECT c.id_curso Id, c.nombre Curso, c.aula Aula, c.temas Temas, c.descripcion Descripcion, c.fecha_inicio Inicio, c.duracion_total_semanas [Cantidad de semanas], c.costo Costo, DATEPART(dw,c.dia_horario) Dia, RIGHT(CONVERT(VARCHAR, c.dia_horario, 100),7) Horario, c.carga_horaria [Carga horaria por dia]
FROM Cursos c
WHERE DATEADD(WEEK,c.duracion_total_semanas, c.fecha_inicio)  > GETDATE()
--En curso
' 
GO
/****** Object:  View [dbo].[vw_consultar_cursos_proximos]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_consultar_cursos_proximos]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_consultar_cursos_proximos]
AS
SELECT c.id_curso Id, c.nombre Curso, c.aula Aula, c.cupo Cupo, c.temas Temas, c.descripcion Descripcion, c.fecha_inicio Inicio, c.duracion_total_semanas [Cantidad de semanas], c.costo Costo, DATEPART(dw,c.dia_horario) Dia, RIGHT(CONVERT(VARCHAR, c.dia_horario, 100),7) Horario, c.carga_horaria [Carga horaria por dia]
FROM Cursos c
WHERE GETDATE() < c.fecha_inicio
--vw_listar_pagos_totales
--Se usa internamente para la siguiente consulta
' 
GO
/****** Object:  View [dbo].[vw_consultar_cursos_todos]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_consultar_cursos_todos]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_consultar_cursos_todos]
AS
SELECT c.id_curso Id, c.nombre Curso, c.aula Aula, c.temas Temas, c.descripcion Descripcion, c.fecha_inicio Inicio, c.duracion_total_semanas [Cantidad de semanas], c.costo Costo, DATEPART(dw,c.dia_horario) Dia, RIGHT(CONVERT(VARCHAR, c.dia_horario, 100),7) Horario, c.carga_horaria [Carga horaria por dia]
FROM Cursos c
--En curso y proximos
' 
GO
/****** Object:  View [dbo].[vw_consultar_matriculados]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_consultar_matriculados]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_consultar_matriculados]
AS
SELECT m.legajo_matriculado Legajo, dg.apellido + '', '' + dg.nombre Matriculado, td.tipo + '' '' + dg.dni Documento, dg.fecha_nacimiento [Fecha de nacimiento], dg.telefono Telefono, dg.mail Mail, m.profesion Profesion
FROM Matriculados m join Datos_Generales dg on dg.id_datos_generales = m.id_datos_generales join Tipos_Dni td on td.id_tipo_dni = dg.id_tipo_dni

-- vw_cursos_actuales_combo   id, curso
' 
GO
/****** Object:  View [dbo].[vw_cursos_actuales_combo]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_cursos_actuales_combo]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_cursos_actuales_combo]
AS
SELECT c.id_curso id, c.nombre curso, *
FROM Cursos c
WHERE GETDATE() BETWEEN c.fecha_inicio AND DATEADD(WEEK,c.duracion_total_semanas, c.fecha_inicio)
-- vw_cursos_proximos_combo   id, curso, fecha
' 
GO
/****** Object:  View [dbo].[vw_cursos_proximos_combo]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_cursos_proximos_combo]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_cursos_proximos_combo]
AS
SELECT c.id_curso id, c.nombre curso, c.fecha_inicio fecha
FROM Cursos c
WHERE c.fecha_inicio > GETDATE()' 
GO
/****** Object:  View [dbo].[vw_inscripciones_con_monto_actual]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.views WHERE object_id = OBJECT_ID(N'[dbo].[vw_inscripciones_con_monto_actual]'))
EXEC dbo.sp_executesql @statement = N'CREATE VIEW [dbo].[vw_inscripciones_con_monto_actual]
AS
SELECT p.id_inscripcion id_inscripcion, SUM(p.monto) Abonado
FROM Pagos p join Inscripciones i on p.id_inscripcion = i.id_inscripcion
GROUP BY p.id_inscripcion

' 
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_asistencia_inscripcion]') AND parent_object_id = OBJECT_ID(N'[dbo].[Asistencias]'))
ALTER TABLE [dbo].[Asistencias]  WITH CHECK ADD  CONSTRAINT [fk_asistencia_inscripcion] FOREIGN KEY([id_inscripcion])
REFERENCES [dbo].[Inscripciones] ([id_inscripcion])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_asistencia_inscripcion]') AND parent_object_id = OBJECT_ID(N'[dbo].[Asistencias]'))
ALTER TABLE [dbo].[Asistencias] CHECK CONSTRAINT [fk_asistencia_inscripcion]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_datos_generales_cursante]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cursantes]'))
ALTER TABLE [dbo].[Cursantes]  WITH CHECK ADD  CONSTRAINT [fk_datos_generales_cursante] FOREIGN KEY([id_datos_generales])
REFERENCES [dbo].[Datos_Generales] ([id_datos_generales])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_datos_generales_cursante]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cursantes]'))
ALTER TABLE [dbo].[Cursantes] CHECK CONSTRAINT [fk_datos_generales_cursante]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_matriculado]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cursantes]'))
ALTER TABLE [dbo].[Cursantes]  WITH CHECK ADD  CONSTRAINT [fk_matriculado] FOREIGN KEY([id_matriculado])
REFERENCES [dbo].[Matriculados] ([id_matriculado])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_matriculado]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cursantes]'))
ALTER TABLE [dbo].[Cursantes] CHECK CONSTRAINT [fk_matriculado]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_tipo_dni]') AND parent_object_id = OBJECT_ID(N'[dbo].[Datos_Generales]'))
ALTER TABLE [dbo].[Datos_Generales]  WITH CHECK ADD  CONSTRAINT [fk_tipo_dni] FOREIGN KEY([id_tipo_dni])
REFERENCES [dbo].[Tipos_Dni] ([id_tipo_dni])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_tipo_dni]') AND parent_object_id = OBJECT_ID(N'[dbo].[Datos_Generales]'))
ALTER TABLE [dbo].[Datos_Generales] CHECK CONSTRAINT [fk_tipo_dni]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_Cursante]') AND parent_object_id = OBJECT_ID(N'[dbo].[Inscripciones]'))
ALTER TABLE [dbo].[Inscripciones]  WITH CHECK ADD  CONSTRAINT [fk_Cursante] FOREIGN KEY([id_cursante])
REFERENCES [dbo].[Cursantes] ([id_cursante])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_Cursante]') AND parent_object_id = OBJECT_ID(N'[dbo].[Inscripciones]'))
ALTER TABLE [dbo].[Inscripciones] CHECK CONSTRAINT [fk_Cursante]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_Curso]') AND parent_object_id = OBJECT_ID(N'[dbo].[Inscripciones]'))
ALTER TABLE [dbo].[Inscripciones]  WITH CHECK ADD  CONSTRAINT [fk_Curso] FOREIGN KEY([id_curso])
REFERENCES [dbo].[Cursos] ([id_curso])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_Curso]') AND parent_object_id = OBJECT_ID(N'[dbo].[Inscripciones]'))
ALTER TABLE [dbo].[Inscripciones] CHECK CONSTRAINT [fk_Curso]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_estado]') AND parent_object_id = OBJECT_ID(N'[dbo].[Inscripciones]'))
ALTER TABLE [dbo].[Inscripciones]  WITH CHECK ADD  CONSTRAINT [fk_estado] FOREIGN KEY([id_estado])
REFERENCES [dbo].[Estados] ([id_estado])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_estado]') AND parent_object_id = OBJECT_ID(N'[dbo].[Inscripciones]'))
ALTER TABLE [dbo].[Inscripciones] CHECK CONSTRAINT [fk_estado]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_datos_generales]') AND parent_object_id = OBJECT_ID(N'[dbo].[Matriculados]'))
ALTER TABLE [dbo].[Matriculados]  WITH CHECK ADD  CONSTRAINT [fk_datos_generales] FOREIGN KEY([id_datos_generales])
REFERENCES [dbo].[Datos_Generales] ([id_datos_generales])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_datos_generales]') AND parent_object_id = OBJECT_ID(N'[dbo].[Matriculados]'))
ALTER TABLE [dbo].[Matriculados] CHECK CONSTRAINT [fk_datos_generales]
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_inscripcion]') AND parent_object_id = OBJECT_ID(N'[dbo].[Pagos]'))
ALTER TABLE [dbo].[Pagos]  WITH CHECK ADD  CONSTRAINT [fk_inscripcion] FOREIGN KEY([id_inscripcion])
REFERENCES [dbo].[Inscripciones] ([id_inscripcion])
GO
IF  EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[fk_inscripcion]') AND parent_object_id = OBJECT_ID(N'[dbo].[Pagos]'))
ALTER TABLE [dbo].[Pagos] CHECK CONSTRAINT [fk_inscripcion]
GO
/****** Object:  StoredProcedure [dbo].[sp_asistencia_x_curso_x_fecha]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_asistencia_x_curso_x_fecha]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_asistencia_x_curso_x_fecha] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_asistencia_x_curso_x_fecha]
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
/****** Object:  StoredProcedure [dbo].[sp_consultar_asistencia_x_cursante_x_curso]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_consultar_asistencia_x_cursante_x_curso]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_consultar_asistencia_x_cursante_x_curso] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_consultar_asistencia_x_cursante_x_curso]
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
/****** Object:  StoredProcedure [dbo].[sp_consultar_asistencia_x_fecha_x_curso]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_consultar_asistencia_x_fecha_x_curso]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_consultar_asistencia_x_fecha_x_curso] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_consultar_asistencia_x_fecha_x_curso]
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
/****** Object:  StoredProcedure [dbo].[sp_consultar_monto_adeudado_x_inscripto]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_consultar_monto_adeudado_x_inscripto]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_consultar_monto_adeudado_x_inscripto] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_consultar_monto_adeudado_x_inscripto]
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

-- SP para ver los pagos individuales segun el id_inscripcion

GO
/****** Object:  StoredProcedure [dbo].[sp_consultar_pago_x_inscripto]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_consultar_pago_x_inscripto]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_consultar_pago_x_inscripto] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_consultar_pago_x_inscripto]
@mIdInscripcion int
AS
BEGIN
	SELECT p.monto Monto, p.fecha_pago Fecha
	FROM Pagos p
	WHERE p.id_inscripcion = @mIdInscripcion
END


GO
/****** Object:  StoredProcedure [dbo].[sp_consultar_pagos_totales_x_inscripto]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_consultar_pagos_totales_x_inscripto]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_consultar_pagos_totales_x_inscripto] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_consultar_pagos_totales_x_inscripto]
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
/****** Object:  StoredProcedure [dbo].[sp_fechas_x_curso]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_fechas_x_curso]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_fechas_x_curso] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_fechas_x_curso]
@mIdCurso int
AS
BEGIN
	SELECT a.fecha_asistencia Fecha
	FROM Asistencias a join Inscripciones i on i.id_inscripcion = a.id_inscripcion
	WHERE i.id_curso = @mIdCurso
	GROUP BY a.fecha_asistencia
	ORDER BY 1
END
GO
/****** Object:  StoredProcedure [dbo].[sp_inscriptos_por_curso]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_inscriptos_por_curso]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_inscriptos_por_curso] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_inscriptos_por_curso]
@mIdCurso int
AS
BEGIN
	SELECT dg.apellido + ', ' + dg.nombre Inscriptio, td.tipo + ' ' + CONVERT(varchar(10), dg.dni) Documento
	FROM Inscripciones i join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales join Tipos_Dni td on td.id_tipo_dni = dg.id_tipo_dni
	WHERE i.id_estado = 2 AND i.id_curso = @mIdCurso
END

--sp_ver_pagos_x_mail

GO
/****** Object:  StoredProcedure [dbo].[sp_insert_asistencia]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_insert_asistencia]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_insert_asistencia] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_insert_asistencia]
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
/****** Object:  StoredProcedure [dbo].[sp_insert_cursante]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_insert_cursante]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_insert_cursante] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_insert_cursante]
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
/****** Object:  StoredProcedure [dbo].[sp_insert_curso]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_insert_curso]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_insert_curso] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_insert_curso]
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
/****** Object:  StoredProcedure [dbo].[sp_insert_datos_generales]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_insert_datos_generales]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_insert_datos_generales] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_insert_datos_generales]
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
GO
/****** Object:  StoredProcedure [dbo].[sp_insert_inscripcion]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_insert_inscripcion]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_insert_inscripcion] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_insert_inscripcion]
@mIdCurso int,
@mIdCursante int
AS
BEGIN
	DECLARE @mPrecioTotal decimal(18,0)
	SELECT @mPrecioTotal = c.costo
	FROM Cursos c WHERE c.id_curso = @mIdCurso
	INSERT INTO Inscripciones (id_curso, id_cursante, id_estado, fecha_realizada, aprobado)
	VALUES (@mIdCurso, @mIdCursante, 1, convert(date, getdate()), @mPrecioTotal)
END
GO
/****** Object:  StoredProcedure [dbo].[sp_insert_matriculado]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_insert_matriculado]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_insert_matriculado] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_insert_matriculado]
@mIdDatosGenerales int,
@mProfesion varchar(50)
AS
BEGIN
	INSERT INTO Matriculados (id_datos_generales, profesion)
	VALUES (@mIdDatosGenerales, @mProfesion)
END
--Inscripciones

GO
/****** Object:  StoredProcedure [dbo].[sp_insert_matriculado_interno]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_insert_matriculado_interno]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_insert_matriculado_interno] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_insert_matriculado_interno]
@mLegajoMatriculado int,
@mIdDatosGenerales int,
@mProfesion varchar(50)
AS
BEGIN
	INSERT INTO Matriculados (legajo_matriculado, id_datos_generales, profesion)
	VALUES (@mLegajoMatriculado, @mIdDatosGenerales, @mProfesion)
END
GO
/****** Object:  StoredProcedure [dbo].[sp_insert_pago]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_insert_pago]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_insert_pago] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_insert_pago]
@mIdInscripcion int,
@mMonto decimal(18,0)
AS
BEGIN
	INSERT INTO Pagos(id_inscripcion, monto, fecha_pago)
	VALUES (@mIdInscripcion, @mMonto, GETDATE())
END
--Datos Generales

GO
/****** Object:  StoredProcedure [dbo].[sp_listado_cursantes_x_curso]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_listado_cursantes_x_curso]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_listado_cursantes_x_curso] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_listado_cursantes_x_curso]
@mIdCurso int
AS
BEGIN
	SELECT dg.apellido + ', ' + dg.nombre Cursante
	FROM Asistencias a join Inscripciones i on i.id_inscripcion = a.id_inscripcion join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales
	WHERE i.id_curso = @mIdCurso
	ORDER BY dg.apellido, dg.nombre
END


GO
/****** Object:  StoredProcedure [dbo].[sp_listado_cursantes_x_curso_nuevo]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_listado_cursantes_x_curso_nuevo]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_listado_cursantes_x_curso_nuevo] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_listado_cursantes_x_curso_nuevo]
@mIdCurso int
AS
BEGIN
	SELECT dg.apellido + ', ' + dg.nombre Cursante
	FROM Inscripciones i join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales = cu.id_datos_generales
	WHERE i.id_curso = @mIdCurso
	ORDER BY dg.apellido, dg.nombre
END
GO
/****** Object:  StoredProcedure [dbo].[sp_obtener_fecha_fin]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_obtener_fecha_fin]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_obtener_fecha_fin] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_obtener_fecha_fin]
@mFechaInicio date,
@mCantidadSemanas int
AS
BEGIN
	DECLARE @mFechaFin date
	SET @mFechaFin = (DATEADD(WEEK, @mCantidadSemanas, @mFechaInicio))
	SELECT @mFechaFin
END
GO
/****** Object:  StoredProcedure [dbo].[sp_update_asistencia]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_update_asistencia]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_update_asistencia] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_update_asistencia]
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
/****** Object:  StoredProcedure [dbo].[sp_update_cursante]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_update_cursante]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_update_cursante] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_update_cursante]
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
/****** Object:  StoredProcedure [dbo].[sp_update_curso_corto]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_update_curso_corto]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_update_curso_corto] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_update_curso_corto]
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
GO
/****** Object:  StoredProcedure [dbo].[sp_update_curso_largo]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_update_curso_largo]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_update_curso_largo] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_update_curso_largo]
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
GO
/****** Object:  StoredProcedure [dbo].[sp_update_datos_generales]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_update_datos_generales]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_update_datos_generales] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_update_datos_generales]
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
GO
/****** Object:  StoredProcedure [dbo].[sp_update_inscripcion]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_update_inscripcion]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_update_inscripcion] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_update_inscripcion]
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
/****** Object:  StoredProcedure [dbo].[sp_update_matriculado]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_update_matriculado]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_update_matriculado] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_update_matriculado]
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
/****** Object:  StoredProcedure [dbo].[sp_ver_adeudado_x_mail]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_ver_adeudado_x_mail]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_ver_adeudado_x_mail] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_ver_adeudado_x_mail]
@mMail varchar(100)
AS
BEGIN
	SELECT c.nombre Curso, (c.costo - vm.[Monto pagado]) Pago
	FROM Inscripciones i join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales =cu.id_datos_generales join Cursos c on c.id_curso = i.id_curso join vw_listar_pagos_totales vm on vm.Id = i.id_inscripcion
	WHERE dg.mail like @mMail
END
--Asistencia de un curso por fecha

GO
/****** Object:  StoredProcedure [dbo].[sp_ver_pagos_x_mail]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[sp_ver_pagos_x_mail]') AND type in (N'P', N'PC'))
BEGIN
EXEC dbo.sp_executesql @statement = N'CREATE PROCEDURE [dbo].[sp_ver_pagos_x_mail] AS' 
END
GO
ALTER PROCEDURE [dbo].[sp_ver_pagos_x_mail]
@mMail varchar(100)
AS
BEGIN
	SELECT c.nombre Curso, p.monto Pago, p.fecha_pago Fecha
	FROM Pagos p join Inscripciones i on p.id_inscripcion = i.id_inscripcion join Cursantes cu on cu.id_cursante = i.id_cursante join Datos_Generales dg on dg.id_datos_generales =cu.id_datos_generales join Cursos c on c.id_curso = i.id_curso
	WHERE dg.mail like @mMail
END

--sp_ver_adeudado_x_mail

GO
/****** Object:  Trigger [dbo].[tg_update_cursos]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.triggers WHERE object_id = OBJECT_ID(N'[dbo].[tg_update_cursos]'))
EXEC dbo.sp_executesql @statement = N'CREATE TRIGGER [dbo].[tg_update_cursos]
ON [dbo].[Cursos]
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
			SET @mHayInscripto = 0
		END
	IF (@mHayInscripto = 0)
		BEGIN
			UPDATE Cursos SET nombre = @mNombre, descripcion = @mDescripcion, fecha_inicio = @mFechaInicio, temas = @mTemas, duracion_total_semanas = @mDuracionSemanas, costo = @mCosto, cupo = @mCupo, aula = @mAula, dia_horario = @mDiaHorario, carga_horaria = @mCargaHoraria
			WHERE @mIdCurso = id_curso
		END
	ELSE
		BEGIN
			UPDATE Cursos SET nombre = @mNombre, descripcion = @mDescripcion, temas = @mTemas, aula = @mAula, cupo = @mCupo
			WHERE @mIdCurso = id_curso
		END
END

--Trigger actualizar estado a inscripto
' 
GO
/****** Object:  Trigger [dbo].[tg_actualizar_cupo]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.triggers WHERE object_id = OBJECT_ID(N'[dbo].[tg_actualizar_cupo]'))
EXEC dbo.sp_executesql @statement = N'CREATE TRIGGER [dbo].[tg_actualizar_cupo]
ON [dbo].[Inscripciones]
INSTEAD OF INSERT
AS
BEGIN
	DECLARE @mIdCurso int
	DECLARE @mIdCursante int
	SELECT @mIdCurso = i.id_curso, @mIdCursante = i.id_cursante
	FROM inserted i
	DECLARE @mCupo int
	SELECT @mCupo = (c.cupo - 1)
	FROM Cursos c
	WHERE c.id_curso = @mIdCurso
	DECLARE @mInscripcion int
	IF (@mCupo = -1)
		BEGIN
			PRINT ''Error, el curso esta lleno!''
		END
	ELSE
		BEGIN
			DECLARE @mPrecioTotal decimal(18,0)
			SELECT @mPrecioTotal = c.costo
			FROM Cursos c WHERE c.id_curso = @mIdCurso
			INSERT INTO Inscripciones (id_curso, id_cursante, id_estado, fecha_realizada, aprobado)
			VALUES (@mIdCurso, @mIdCursante, 1, convert(date, getdate()), null)
			UPDATE Cursos SET cupo = @mCupo
			WHERE id_curso = @mIdCurso
		END
	SELECT @mInscripcion = MAX(i.id_inscripcion)
	FROM Inscripciones i
	PRINT (@mInscripcion)
	INSERT INTO Pagos(id_inscripcion, monto, fecha_pago)
	VALUES (@mInscripcion, 0.0, GETDATE())
END
-- Trigger para realizar los updates correctos de cursos
' 
GO
/****** Object:  Trigger [dbo].[tg_generar_legajo]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.triggers WHERE object_id = OBJECT_ID(N'[dbo].[tg_generar_legajo]'))
EXEC dbo.sp_executesql @statement = N'CREATE TRIGGER [dbo].[tg_generar_legajo] ON [dbo].[Matriculados]
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
	INSERT INTO Matriculados (id_datos_generales, profesion, legajo_matriculado)
	VALUES (@mIdDatosGenerales, @mProfesion, @mBase)
END
' 
GO
/****** Object:  Trigger [dbo].[tg_actualizar_a_inscripto]    Script Date: 11/1/2017 1:40:51 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.triggers WHERE object_id = OBJECT_ID(N'[dbo].[tg_actualizar_a_inscripto]'))
EXEC dbo.sp_executesql @statement = N'CREATE TRIGGER [dbo].[tg_actualizar_a_inscripto] ON [dbo].[Pagos]
INSTEAD OF INSERT
AS
BEGIN
	DECLARE @mIdInscrip int
	SELECT @mIdInscrip = i.id_inscripcion
	FROM inserted i
	DECLARE @mMonto decimal(18,0)
	SELECT @mMonto = i.monto
	FROM inserted i
	DECLARE @mMaximo decimal(18,0)
	SELECT @mMaximo = c.costo
	FROM Cursos c join Inscripciones i on i.id_curso = c.id_curso
	WHERE i.id_inscripcion = @mIdInscrip
	DECLARE @mCantidad decimal(18,0)
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
		INSERT INTO Pagos (id_inscripcion, monto, fecha_pago)
		VALUES (@mIdInscrip, @mPagar, GETDATE())
	END
	ELSE
	BEGIN
		INSERT INTO Pagos (id_inscripcion, monto, fecha_pago)
		VALUES (@mIdInscrip, @mMonto, GETDATE())
	END
	IF ((@mMonto + @mCantidad) >= (@mMaximo / 2))
	BEGIN
		UPDATE Inscripciones SET id_estado = 2
		WHERE id_inscripcion = @mIdInscrip
	END
END

--Trigger tg_generar_legajo
' 
GO
USE [master]
GO
ALTER DATABASE [Colegio_Informatica_Metodologia] SET  READ_WRITE 
GO
