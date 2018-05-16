



CREATE OR REPLACE PACKAGE pkClientes1 AS -- spec
    PROCEDURE pInsertarCliente
        (ivNombre VARCHAR2, ivCedula VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2 ,ivTelefono VARCHAR2);
    PROCEDURE pEliminarCliente(iCedulaCLiente VARCHAR2);
    PROCEDURE pActualizarCliente
        (ivCedulaBuscada VARCHAR2,ivNombre VARCHAR2, ivCedulaNueva VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2 ,ivTelefono VARCHAR2);
END pkClientes;
/
CREATE OR REPLACE PACKAGE BODY pkClientes1 AS -- body
-- Insertar
  PROCEDURE pInsertarCliente
    (ivNombre VARCHAR2, ivCedula VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2 ,ivTeléfono VARCHAR2)
  IS
    BEGIN
    INSERT INTO cliente
    VALUES (ivNombre, ivCedula, ivFechaNacimiento, ivDirección, ivTeléfono);
  END pInsertarCliente;
-- Eliminar
  PROCEDURE pEliminarCliente(iCedulaCliente IN NUMBER) IS
    BEGIN
    DELETE FROM cliente WHERE cedula = iCedulaCliente;
  END pEliminarCliente;
-- Actualizar
  PROCEDURE pActualizarCliente(ivCedulaBuscada VARCHAR2,ivNombre VARCHAR2, ivCedulaNueva VARCHAR2, ivFechaNacimiento DATE, ivDireccion VARCHAR2 ,ivTelefono VARCHAR2) IS
    BEGIN
    UPDATE cliente 
    SET nombre=ivNombre, cedula=ivCedula, fechaNacimiento=ivFechaNacimiento, direccion=ivDireccion, telefono=ivTelefono
    WHERE cedula=ivCedulaBuscada;
  END pActualizarCliente;
END pkClientes;
