--INSERTS

--TIPOS_DNI

insert into Tipos_Dni
values ('DNI')

insert into Tipos_Dni
values ('LC')

insert into Tipos_Dni
values ('LE')

insert into Tipos_Dni
values ('Pasaporte')

--ESTADOS

insert into Estados
values ('Pre-Inscripto')

insert into Estados
values ('Inscripto')

insert into Estados
values ('Moroso')

insert into Estados
values ('Egresado')

--CURSOS

insert into Cursos
values ('Java Inicial', 'Este curso está especialmente diseñado para todos aquellos que desean migrar a la programación Orientada a Objetos y aprender a programar con lenguaje Java. Cubre todos los contenidos de la Certificación Sun-Oracle Certified Java Programmer', '2017-11-02', 
'*Objetos,
*Clases,
*Uso de Clases Java,
*Uso de Métodos Java,
*Interacción entre Objetos,
*Análisis y Diseño Orientado a Objetos,
*Construcciones del Lenguaje de Programación Java,
*Casos de Estudio,
*La programación Orientada a Objetos,
*Los Identificadores, Las Palabras Clave y los Tipos,
*Las expresiones y el control de flujo,
*Los arreglos,
*El Diseño de Clases,
*La construcción de GUI en Java,
*Los Hilos,
*Networking,
*Elementos de Programación Java Avanzada',
12, 6000, 30, 'A1', '2017-11-02 18:00',
48)

--DATOS GENERALES

insert into Datos_Generales
values ('Rodolfo', 'Martinez', 1, 38852452, '1994-10-25', '3516523655', 'rodomartinez@gmail.com')

insert into Datos_Generales
values ('Maria', 'Cordero', 1, 36525414, '1991-01-16', '3512214521', 'mariacordero25@hotmail.com')

insert into Datos_Generales
values ('Patricia', 'Alvarez', 2, 14524563, '1960-03-26', '351416652', 'pattoalvarez46@hotmail.com')



--MATRICULADOS

insert into Matriculados
values ('108853', 1, 'Ingeniero Electrónico')

insert into Matriculados
values ('108854', 2, 'Ingeniero en Computación')

--CURSANTES

insert into Cursantes
values (1, 0, 1)

insert into Cursantes
values (null, 0, 3)

--INSCRIPCIONES

insert into Inscripciones
values (1, 1, 1, '2017-10-21', 0, 6000)

insert into Inscripciones
values (2, 2, 2, '2017-10-21', 0, 6000)

--PAGOS

insert into Pagos
values (1, 3000, '2017-10-21 11:00')

insert into Pagos
values (2, 4500, '2017-10-10 12:00')

insert into Pagos
values (2, 1500, '2017-10-21 16:00')

--ASISTENCIAS

insert into Asistencias
values (2,'2017-11-02', 1)

insert into Asistencias
values (2,'2017-11-03', 0)

