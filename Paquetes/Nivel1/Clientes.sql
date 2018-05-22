
CREATE OR REPLACE PACKAGE pkClientesNivel1 IS -- spec
    PROCEDURE pInsertar(ivNombre IN VARCHAR2, ivCedula IN VARCHAR2, ivFechaNacimiento IN DATE, ivDireccion IN VARCHAR2 ,ivTelefono IN VARCHAR2);
    
    PROCEDURE pEliminar(iCedulaCLiente IN NUMBER);
    
    FUNCTION fConsultar(ivCedula IN VARCHAR2) RETURN cliente%rowtype;
    
    PROCEDURE pModificar(ivCedulaBuscada IN VARCHAR2,ivNombre IN VARCHAR2, ivCedulaNueva IN VARCHAR2, ivFechaNacimiento IN DATE, ivDireccion IN VARCHAR2 ,ivTelefono IN VARCHAR2);

END pkClientesNivel1;
/
CREATE OR REPLACE PACKAGE BODY pkClientesNivel1 IS -- body
-- Insertar
    PROCEDURE pInsertar(ivNombre IN VARCHAR2, ivCedula IN VARCHAR2, ivFechaNacimiento IN DATE, ivDireccion IN VARCHAR2 ,ivTelefono IN VARCHAR2) IS
        BEGIN
        INSERT INTO cliente
        VALUES (ivNombre, ivCedula, ivFechaNacimiento, ivDirección, ivTeléfono);
        EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, este registro ya existe.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
    END pInsertar;
-- Eliminar
    PROCEDURE pEliminar(iCedulaCliente IN NUMBER) IS
        BEGIN
        DELETE FROM cliente 
        WHERE cedulacliente = iCedulaCliente;
        EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe solicitud con ese id.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
    END pEliminar;
-- Actualizar
    PROCEDURE pModificar(ivCedulaBuscada IN VARCHAR2,ivNombre IN VARCHAR2, ivCedulaNueva IN VARCHAR2, ivFechaNacimiento IN DATE, ivDireccion IN VARCHAR2 ,ivTelefono IN VARCHAR2) IS
        BEGIN
        UPDATE cliente 
        SET nombre=ivNombre, cedulacliente=ivCedulaNueva, fechaNacimiento=ivFechaNacimiento, direccion=ivDireccion, telefono=ivTelefono
        WHERE cedulacliente=ivCedulaBuscada;
        EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe solicitud con ese id.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);    
    END pModificar;
-- Obtener
    FUNCTION fConsultar(ivCedula IN VARCHAR2) RETURN cliente%rowtype 
    IS ovCliente cliente%rowtype;
        BEGIN
        SELECT * into ovCliente
        FROM cliente
        WHERE cedulacliente=ivCedula;
        EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe solicitud con ese id.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);    
    END fConsultar;
        
END pkClientesNivel1;

