-- Generado por Oracle SQL Developer Data Modeler 17.4.0.355.2131
--   en:        2018-05-20 08:40:02 GMT-05:00
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



DROP TABLE cliente CASCADE CONSTRAINTS;

DROP TABLE funcionario CASCADE CONSTRAINTS;

DROP TABLE parametros CASCADE CONSTRAINTS;

DROP TABLE producto CASCADE CONSTRAINTS;

DROP TABLE productosxcliente CASCADE CONSTRAINTS;

DROP TABLE solicitud CASCADE CONSTRAINTS;

DROP TABLE tipoanomalia CASCADE CONSTRAINTS;

DROP TABLE tipoproducto CASCADE CONSTRAINTS;

DROP TABLE tiposolicitud CASCADE CONSTRAINTS;

CREATE TABLE cliente (
    cedulacliente     VARCHAR2(20 CHAR) NOT NULL,
    nombre            VARCHAR2(40 CHAR),
    fechanacimiento   DATE,
    direccion         VARCHAR2 
--  ERROR: VARCHAR2 size not specified 
   ,
    telefono          VARCHAR2(20 CHAR)
);

COMMENT ON TABLE cliente IS
    'Tabla del cliente';

COMMENT ON COLUMN cliente.cedulacliente IS
    'Cedula del cliente';

COMMENT ON COLUMN cliente.nombre IS
    'Nombre del cliente';

COMMENT ON COLUMN cliente.fechanacimiento IS
    'fecha nacimiento';

COMMENT ON COLUMN cliente.direccion IS
    'direccion del cliente';

COMMENT ON COLUMN cliente.telefono IS
    'telefono cliente';

ALTER TABLE cliente ADD CONSTRAINT cliente_pk PRIMARY KEY ( cedulacliente );

CREATE TABLE funcionario (
    cedulafuncionario   VARCHAR2(20 CHAR) NOT NULL,
    nombre              VARCHAR2(40 CHAR),
    fechanacimiento     DATE,
    direccion           VARCHAR2(40 CHAR),
    telefono            VARCHAR2(20 CHAR)
);

COMMENT ON TABLE funcionario IS
    'Tabla del funcionario';

COMMENT ON COLUMN funcionario.cedulafuncionario IS
    'Cedula del funcionario';

COMMENT ON COLUMN funcionario.nombre IS
    'Nombre del funcionario';

COMMENT ON COLUMN funcionario.fechanacimiento IS
    'fecha nacimiento funcionario';

COMMENT ON COLUMN funcionario.direccion IS
    'direccion del funcionario';

COMMENT ON COLUMN funcionario.telefono IS
    'telefono del funcionario';

ALTER TABLE funcionario ADD CONSTRAINT funcionario_pk PRIMARY KEY ( cedulafuncionario );

CREATE TABLE parametros (
    idparametros   NUMBER(4) NOT NULL,
    nombre         VARCHAR2(40 CHAR),
    valor          VARCHAR2(40 CHAR)
);

COMMENT ON TABLE parametros IS
    'Tabla de parametros';

COMMENT ON COLUMN parametros.idparametros IS
    'id del parametro';

COMMENT ON COLUMN parametros.nombre IS
    'Nombre del parametro';

COMMENT ON COLUMN parametros.valor IS
    'Valor del parametro';

ALTER TABLE parametros ADD CONSTRAINT parametros_pk PRIMARY KEY ( idparametros );

CREATE TABLE producto (
    idproducto                    NUMBER(4) NOT NULL,
    fechaini                      DATE,
    tipoproducto_idtipoproducto   NUMBER(4) NOT NULL
);

COMMENT ON TABLE producto IS
    'Tabla del producto';

COMMENT ON COLUMN producto.idproducto IS
    'id del producto';

COMMENT ON COLUMN producto.fechaini IS
    'Fecha inicio del producto';

ALTER TABLE producto ADD CONSTRAINT producto_pk PRIMARY KEY ( idproducto );

CREATE TABLE productosxcliente (
    producto_idproducto     NUMBER(4) NOT NULL,
    cliente_cedulacliente   VARCHAR2(20 CHAR) NOT NULL,
    fechainicio             DATE,
    fechafin                DATE
);

COMMENT ON COLUMN productosxcliente.fechainicio IS
    'fecha inicio del producto';

COMMENT ON COLUMN productosxcliente.fechafin IS
    'fecha fin del producto';

ALTER TABLE productosxcliente ADD CONSTRAINT productosxcliente_pk PRIMARY KEY ( producto_idproducto,
cliente_cedulacliente );

CREATE TABLE solicitud (
    idsolicitud                     NUMBER(4) NOT NULL,
    estado                          VARCHAR2(40 CHAR),
    observacion                     VARCHAR2(40 CHAR),
    fechaini                        DATE,
    fechafin                        DATE,
    cliente_cedulacliente           VARCHAR2(20 CHAR) NOT NULL,
    tiposolicitud_idtiposolicitud   NUMBER(4) NOT NULL,
    funcionario_cedulafuncionario   VARCHAR2(20 CHAR) NOT NULL,
    tipoanomalia_idanomalia         NUMBER(4) NOT NULL,
    tipoproducto_idtipoproducto     NUMBER(4) NOT NULL,
    producto_idproducto             NUMBER(4) NOT NULL
);

COMMENT ON TABLE solicitud IS
    'Tabla de Solicitudes';

COMMENT ON COLUMN solicitud.idsolicitud IS
    'id de la solicitud';

COMMENT ON COLUMN solicitud.estado IS
    'Estado de la Solicitud';

COMMENT ON COLUMN solicitud.observacion IS
    'Observacion de la solicitud';

COMMENT ON COLUMN solicitud.fechaini IS
    'Fecha Inicial  de la solicitud';

COMMENT ON COLUMN solicitud.fechafin IS
    'Fecha Final de la solicutud';

ALTER TABLE solicitud ADD CONSTRAINT solicitud_pk PRIMARY KEY ( idsolicitud );

CREATE TABLE tipoanomalia (
    idanomalia   NUMBER(4) NOT NULL,
    nombre       VARCHAR2(40 CHAR)
);

COMMENT ON TABLE tipoanomalia IS
    'Tabla del tipo de anomalia';

COMMENT ON COLUMN tipoanomalia.idanomalia IS
    'id del tipo de anomalia';

COMMENT ON COLUMN tipoanomalia.nombre IS
    'Nombre del tipo de anomalia';

ALTER TABLE tipoanomalia ADD CONSTRAINT tipoanomalia_pk PRIMARY KEY ( idanomalia );

CREATE TABLE tipoproducto (
    idtipoproducto   NUMBER(4) NOT NULL,
    nombre           VARCHAR2(40 CHAR)
);

COMMENT ON TABLE tipoproducto IS
    'Tabla del tipo de producto';

COMMENT ON COLUMN tipoproducto.idtipoproducto IS
    'id del tipo de producto';

COMMENT ON COLUMN tipoproducto.nombre IS
    'Nombre del tipo de producto';

ALTER TABLE tipoproducto ADD CONSTRAINT tipoproducto_pk PRIMARY KEY ( idtipoproducto );

CREATE TABLE tiposolicitud (
    idtiposolicitud   NUMBER(4) NOT NULL,
    nombre            VARCHAR2(40 CHAR)
);

COMMENT ON TABLE tiposolicitud IS
    'Tabla del tipo de Solicitud';

COMMENT ON COLUMN tiposolicitud.idtiposolicitud IS
    'Id de el tipo de solicitud';

COMMENT ON COLUMN tiposolicitud.nombre IS
    'Nombre del tipo de solicitud';

ALTER TABLE tiposolicitud ADD CONSTRAINT tiposolicitud_pk PRIMARY KEY ( idtiposolicitud );

ALTER TABLE producto
    ADD CONSTRAINT producto_tipoproducto_fk FOREIGN KEY ( tipoproducto_idtipoproducto )
        REFERENCES tipoproducto ( idtipoproducto );

ALTER TABLE productosxcliente
    ADD CONSTRAINT productosxcliente_cliente_fk FOREIGN KEY ( cliente_cedulacliente )
        REFERENCES cliente ( cedulacliente );

ALTER TABLE productosxcliente
    ADD CONSTRAINT productosxcliente_producto_fk FOREIGN KEY ( producto_idproducto )
        REFERENCES producto ( idproducto );

ALTER TABLE solicitud
    ADD CONSTRAINT solicitud_cliente_fk FOREIGN KEY ( cliente_cedulacliente )
        REFERENCES cliente ( cedulacliente );

ALTER TABLE solicitud
    ADD CONSTRAINT solicitud_funcionario_fk FOREIGN KEY ( funcionario_cedulafuncionario )
        REFERENCES funcionario ( cedulafuncionario );

ALTER TABLE solicitud
    ADD CONSTRAINT solicitud_producto_fk FOREIGN KEY ( producto_idproducto )
        REFERENCES producto ( idproducto );

ALTER TABLE solicitud
    ADD CONSTRAINT solicitud_tipoanomalia_fk FOREIGN KEY ( tipoanomalia_idanomalia )
        REFERENCES tipoanomalia ( idanomalia );

ALTER TABLE solicitud
    ADD CONSTRAINT solicitud_tipoproducto_fk FOREIGN KEY ( tipoproducto_idtipoproducto )
        REFERENCES tipoproducto ( idtipoproducto );

ALTER TABLE solicitud
    ADD CONSTRAINT solicitud_tiposolicitud_fk FOREIGN KEY ( tiposolicitud_idtiposolicitud )
        REFERENCES tiposolicitud ( idtiposolicitud );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             9
-- CREATE INDEX                             0
-- ALTER TABLE                             18
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   1
-- WARNINGS                                 0
