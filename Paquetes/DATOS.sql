--Clientes
INSERT INTO CLIENTE VALUES ('1.090.427.627','Sofia','10-ENE-1996','Clle 5 #12-321','12');
INSERT INTO CLIENTE VALUES ('1.090.450.726','Karen','10-FEB-1997','Cra 1 #21-432','13');
INSERT INTO CLIENTE VALUES ('13.490.889','Valentina','10-MAR-1995','Cra 19 #45-253','14');
INSERT INTO CLIENTE VALUES ('1.090.423.115','Daniela','10-ABR-1993','Clle 2 #76-345','15');
INSERT INTO CLIENTE VALUES ('1.093.885.333','Carla','10-MAY-1990','Cra 2 #34-123','15');

INSERT INTO CLIENTE VALUES ('000','Diana','10-MAY-1990','Cra 2 #34-123','15');
INSERT INTO CLIENTE VALUES ('001','Jesus','10-MAY-1990','Cra 2 #34-123','15');

--funcionario
INSERT INTO FUNCIONARIO VALUES ('37.279.508','Carlos','23-JUN-1991','Carrera 56A No. 51 - 81','22');
INSERT INTO FUNCIONARIO VALUES ('1.090.441.17','Felipe','21-JUL-1994','Carrera 22 No. 17-31','23');
INSERT INTO FUNCIONARIO VALUES ('1.090.395.808','Alejandro','29-AGO-1986','Carrera 54 No. 68 - 80 ','24');
INSERT INTO FUNCIONARIO VALUES ('91.530.780','Sebastian','12-OCT-1979','Calle 59 No. 27 - 35 ','25');
INSERT INTO FUNCIONARIO VALUES ('1.036.627.286','Nicolas','06-NOV-1990','Carrera 8  No. 20 - 59','26');

INSERT INTO FUNCIONARIO VALUES ('000','Jesus','06-NOV-1997','Carrera 8  No. 20 - 59','26');


--Telefonia: Voz
--Internet: Datos
--Integrado: Voz y Datos

--tipoProducto
INSERT INTO TIPOPRODUCTO VALUES (1,'Voz');
INSERT INTO TIPOPRODUCTO VALUES (2,'Datos');
INSERT INTO TIPOPRODUCTO VALUES (3,'Voz');
INSERT INTO TIPOPRODUCTO VALUES (4,'Integrado');
INSERT INTO TIPOPRODUCTO VALUES (5,'Datos');


--producto
INSERT INTO PRODUCTO VALUES (1,'06-ENE-2011',1);
INSERT INTO PRODUCTO VALUES (2,'07-FEB-2012',2);
INSERT INTO PRODUCTO VALUES (3,'08-MAR-2013',3);
INSERT INTO PRODUCTO VALUES (4,'09-ABR-2014',4);
INSERT INTO PRODUCTO VALUES (5,'10-MAY-2015',5);


-- TIPO DE ANOMALIA PUEDEN SER MAS
--tipoAnomalia

INSERT INTO TIPOANOMALIA VALUES (4,'Sin Anomalia');
INSERT INTO TIPOANOMALIA VALUES (5,'Baja Velocidad');
INSERT INTO TIPOANOMALIA VALUES (6,'Mala calidad del servicio');
INSERT INTO TIPOANOMALIA VALUES (7,'Baja Velocidad');
INSERT INTO TIPOANOMALIA VALUES (8,'Mala calidad del servicio');
INSERT INTO TIPOANOMALIA VALUES (9,'Baja Velocidad');

--tipoSolicitud
--1-5 registro
--5-10 asignacion

--registro: tiene estado de No asignada: creacion o modificacion
--Asignacion: tiene estados de asignada y dentro puede estar: solicitud, retiro,daño y reclamo
 
--Registro
INSERT INTO TIPOSOLICITUD VALUES (001,'Creacion');

--Asignacion
INSERT INTO TIPOSOLICITUD VALUES (002,'Retiro');
INSERT INTO TIPOSOLICITUD VALUES (003,'Reclamo');
INSERT INTO TIPOSOLICITUD VALUES (004, 'Dano');
INSERT INTO TIPOSOLICITUD VALUES (005,'Cancelacion');
INSERT INTO TIPOSOLICITUD VALUES (006,'Modificacion');


--solicitud
--Una solicitud de registro

INSERT INTO SOLICITUD VALUES (1,'Creacion','esta solicitud no ha sido asignada','01-ENE-2018','01-FEB-2018','1.090.427.627',1,'37.279.508',5,1,1);

--solicitud de asignacion


INSERT INTO SOLICITUD VALUES (5,'NuevoProducto','Pidiendo un nuevo producto','01-FEB-2018','01-MAR-2018','1.090.450.726',5,'1.090.441.17',6,2,2);



--
--Relacion de clientes x producto
--Solo se crea esta relación para una solicitud de TipoSolicitud
--Falta revisar lo de la fecha de ini.

INSERT INTO PRODUCTOSXCLIENTE VALUES (2, '1.090.450.726', '01-FEB-2018','01-MAR-2018');

