
CREATE OR REPLACE PACKAGE pkSolicitudNivel1 IS 

    PROCEDURE pInsertarSolicitud(ivIdSolicitud IN NUMBER, ivEstado IN VARCHAR2,ivObservacion IN VARCHAR2,ivIdCliente IN VARCHAR2,ivIdFuncionario IN VARCHAR2
    ,ivFechaIni IN DATE,ivFechaFin IN DATE,ivTipoSolicitud IN NUMBER,ivTipoAnomalia IN NUMBER,ivIdTipoProducto IN NUMBER,ivIdProducto IN NUMBER );
   
    PROCEDURE pEliminarSolicitud(ivIdSolicitud IN NUMBER);
    
    PROCEDURE pActualizarSolicitud(ivIdSolicitud IN NUMBER, ivEstado IN VARCHAR2,ivObservacion IN VARCHAR2,ivIdCliente IN VARCHAR2,ivIdFuncionario IN VARCHAR2
    ,ivFechaIni IN DATE,ivFechaFin IN DATE,ivTipoSolicitud IN NUMBER,ivTipoAnomalia IN NUMBER,ivIdTipoProducto IN NUMBER,ivIdProducto IN NUMBER );
   
    FUNCTION fObtenerSolicitud(ivIdSolicitud in NUMBER) RETURN SOLICITUD%rowtype;
    
END pkSolicitudNivel1;
/
CREATE OR REPLACE PACKAGE BODY pkSolicitudNivel1 IS 
-- Insertar
  PROCEDURE pInsertarSolicitud
    (ivIdSolicitud NUMBER, ivEstado VARCHAR2,ivObservacion VARCHAR2,ivIdCliente VARCHAR2,ivIdFuncionario VARCHAR2
    ,ivFechaIni DATE,ivFechaFin DATE,ivTipoSolicitud NUMBER,ivTipoAnomalia NUMBER,ivIdTipoProducto NUMBER,ivIdProducto NUMBER )
  IS
    BEGIN
    INSERT INTO SOLICITUD
    VALUES (ivIdSolicitud , ivEstado ,ivObservacion ,ivFechaIni,ivFechaFin,ivIdCliente 
    ,ivTipoSolicitud ,ivIdFuncionario,ivTipoAnomalia,ivIdTipoProducto ,ivIdProducto );
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, este registro ya existe.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
        
  END pInsertarSolicitud;
-- Eliminar
  PROCEDURE pEliminarSolicitud(ivIdSolicitud IN NUMBER) IS
    BEGIN
    DELETE FROM SOLICITUD S WHERE S.IDSOLICITUD = ivIdSolicitud;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe solicitud con ese id.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
           
    
  END pEliminarSolicitud;
-- Actualizar
  PROCEDURE pActualizarSolicitud(ivIdSolicitud NUMBER, ivEstado VARCHAR2,ivObservacion VARCHAR2,ivIdCliente VARCHAR2,ivIdFuncionario VARCHAR2
    ,ivFechaIni DATE,ivFechaFin DATE,ivTipoSolicitud NUMBER,ivTipoAnomalia NUMBER,ivIdTipoProducto NUMBER,ivIdProducto NUMBER ) IS
    BEGIN
    UPDATE SOLICITUD 
    SET  Estado=ivEstado ,Observacion=ivObservacion ,FechaIni=ivFechaIni,FechaFin=ivFechaFin,CLIENTE_CEDULACLIENTE=ivIdCliente 
    ,TIPOSOLICITUD_IDTIPOSOLICITUD=ivTipoSolicitud ,FUNCIONARIO_CEDULAFUNCIONARIO=ivIdFuncionario,TIPOANOMALIA_IDANOMALIA=ivTipoAnomalia
    ,TIPOPRODUCTO_IDTIPOPRODUCTO=ivIdTipoProducto ,PRODUCTO_IDPRODUCTO=ivIdProducto 
    WHERE IDSOLICITUD=ivIdSolicitud;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe solicitud con ese id.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
        
    
  END pActualizarSolicitud;
  FUNCTION fObtenerSolicitud(ivIdSolicitud IN NUMBER) RETURN SOLICITUD%rowtype 
    IS ovSolicitud SOLICITUD%rowtype;
    BEGIN
        SELECT * into ovSolicitud
        FROM Solicitud
        WHERE IDSOLICITUD=ivIdSolicitud;
        EXCEPTION
            WHEN NO_DATA_FOUND THEN 
            RAISE_APPLICATION_ERROR(-20001,'Error, no existe solicitud con ese id.');
            WHEN OTHERS THEN 
            RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
        
    END fObtenerSolicitud;
END pkSolicitudNivel1;
