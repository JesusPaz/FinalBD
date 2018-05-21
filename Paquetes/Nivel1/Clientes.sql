





CREATE OR REPLACE PACKAGE pkClientesNivel1 AS -- spec
    PROCEDURE pInsertar
        (ivNombre VARCHAR2, ivCedula VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2 ,ivTelefono VARCHAR2);
    PROCEDURE pEliminar(iCedulaCLiente VARCHAR2);
    PROCEDURE pModificar
        (ivCedulaBuscada VARCHAR2,ivNombre VARCHAR2, ivCedulaNueva VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2 ,ivTelefono VARCHAR2);
    FUNCTION fConsultar(ivCedula);
END pkClientesNivel1;
/
CREATE OR REPLACE PACKAGE BODY pkClientesNivel1 AS -- body
-- Insertar
PROCEDURE pInsertar
        (ivNombre VARCHAR2, ivCedula VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2 ,ivTeléfono VARCHAR2)
    IS
    BEGIN
        INSERT INTO cliente
        VALUES (ivNombre, ivCedula, ivFechaNacimiento, ivDirección, ivTeléfono);
    END pInsertar;
-- Eliminar
    PROCEDURE pEliminar(iCedulaCliente IN NUMBER) IS
    BEGIN
        DELETE FROM cliente WHERE cedula = iCedulaCliente;
    END pEliminar;
-- Actualizar
    PROCEDURE pModificar(ivCedulaBuscada VARCHAR2,ivNombre VARCHAR2, ivCedulaNueva VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2 ,ivTelefono VARCHAR2) IS
    BEGIN
        UPDATE cliente 
        SET nombre=ivNombre, cedula=ivCedula, fechaNacimiento=ivFechaNacimiento, direccion=ivDireccion, telefono=ivTelefono
        WHERE cedula=ivCedulaBuscada;
    END pModificar;
-- Obtener
    FUNCTION fConsultar(ivCedula VARCHAR2) RETURN cliente%rowtype 
    IS ovCliente cliente%rowtype;
    BEGIN
        SELECT * into ovCliente
        FROM cliente
        WHERE cedula=ivCedula;
    END fConsultar;
        
END pkClientesNivel1;
