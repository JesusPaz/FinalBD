

CREATE OR REPLACE PACKAGE pkClientes AS -- spec
PROCEDURE pInsertarCliente
(ivNombre VARCHAR2, ivCedula VARCHAR2, ivFechaNacimiento VARCHAR2, ivDirección VARCHAR2 ,ivTeléfono VARCHAR2);
PROCEDURE pEliminarCliente(iCedulaCLiente VARCHAR2);
END pkClientes;
/
CREATE OR REPLACE PACKAGE BODY pkClientes AS -- body
-- Implementación Procedimiento 1
PROCEDURE pInsertarCliente
(ivNombre VARCHAR2, ivCedula VARCHAR2, ivFechaNacimiento VARCHAR2, ivDirección VARCHAR2 ,ivTeléfono VARCHAR2)
IS
BEGIN
INSERT INTO cliente
VALUES (ivNombre, ivCedula, ivFechaNacimiento, ivDirección, ivTeléfono);
END pInsertarCliente;
-- Implementación Procedimiento 2
PROCEDURE pEliminarCliente(iCedulaCliente IN NUMBER) IS
BEGIN
DELETE FROM cliente WHERE cedula = iCedulaCliente;
END pEliminarCliente;
END pkClientes;