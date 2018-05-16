
CREATE OR REPLACE PACKAGE pkTipoSolicitud1 AS -- spec
    PROCEDURE pInsertarTipoSolicitud(iIdTipoSolicitud NUMBER, iNombre VARCHAR2);
    PROCEDURE pEliminarTipoSolicitud(iIdTipoSolicitud NUMBER);
    PROCEDURE pActualizarTipoSolicitud
        (ivCedulaBuscada VARCHAR2,ivNombre VARCHAR2, ivCedulaNueva VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2 ,ivTelefono VARCHAR2);
END pkTipoSolicitud;
/
CREATE OR REPLACE PACKAGE BODY pkTipoSolicitud1 AS -- body
-- Insertar
  PROCEDURE pInsertarTipoSolicitud
    (ivNombre VARCHAR2, ivCedula VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2 ,ivTeléfono VARCHAR2)
  IS
    BEGIN
    INSERT INTO cliente
    VALUES (ivNombre, ivCedula, ivFechaNacimiento, ivDirección, ivTeléfono);
  END pInsertarCliente;
-- Eliminar
  PROCEDURE pEliminarTipoSolicitud(iCedulaCliente IN NUMBER) IS
    BEGIN
    DELETE FROM cliente WHERE cedula = iCedulaCliente;
  END pEliminarCliente;
-- Actualizar
  PROCEDURE pActualizarTipoSolicitud(ivCedulaBuscada VARCHAR2,ivNombre VARCHAR2, ivCedulaNueva VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2 ,ivTelefono VARCHAR2) IS
    BEGIN
    UPDATE cliente 
    SET nombre=ivNombre, cedula=ivCedula, fechaNacimiento=ivFechaNacimiento, direccion=ivDireccion, telefono=ivTelefono
    WHERE cedula=ivCedulaBuscada;
  END pActualizarCliente;
END pkClientes;
