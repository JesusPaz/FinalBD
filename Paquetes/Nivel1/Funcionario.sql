CREATE OR REPLACE PACKAGE pkFuncionarioNivel1 IS 

    PROCEDURE pInsertarFuncionario(cedulaFuncionario IN VARCHAR2, nombre IN VARCHAR2, fechaNacimiento IN DATE, direccion IN VARCHAR2,telefono IN VARCHAR2  );
   
    PROCEDURE pEliminarFuncionario(cedulaFuncionario IN VARCHAR2);
    
    PROCEDURE pActualizarFuncionario(cedulaFuncionario IN VARCHAR2, inombre IN VARCHAR2, fechaNacimiento IN DATE, direccion IN VARCHAR2,telefono IN VARCHAR2 );
   
    FUNCTION fObtenerFuncionario(cedulaFuncionario IN VARCHAR2) RETURN FUNCIONARIO%rowtype;
    
END pkFuncionarioNivel1;
/
CREATE OR REPLACE PACKAGE BODY pkFuncionarioNivel1 IS 
-- Insertar
  PROCEDURE pInsertarFuncionario
    (cedulaFuncionario IN VARCHAR2, nombre IN VARCHAR2, fechaNacimiento IN DATE, direccion IN VARCHAR2,telefono IN VARCHAR2)
  IS
    BEGIN
    INSERT INTO FUNCIONARIO
    VALUES (cedulaFuncionario, nombre , fechaNacimiento, direccion,telefono );
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, este registro ya existe.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
  END pInsertarFuncionario;
-- Eliminar
  PROCEDURE pEliminarFuncionario(cedulaFuncionario IN VARCHAR2) IS
    BEGIN
    DELETE FROM FUNCIONARIO T WHERE T.CEDULAFUNCIONARIO= cedulaFuncionario;
     EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe un funcionario con esa c�dula.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
  END pEliminarFuncionario;
-- Actualizar
  PROCEDURE pActualizarFuncionario(cedulaFuncionario IN VARCHAR2, inombre IN VARCHAR2, fechaNacimiento IN DATE, direccion IN VARCHAR2,telefono IN VARCHAR2)
  IS
    BEGIN
    UPDATE FUNCIONARIO 
    SET  NOMBRE=inombre 
    WHERE CEDULAFUNCIONARIO=cedulaFuncionario;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error,no existe un funcionario con esa c�dula.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
  END pActualizarFuncionario;
  
  FUNCTION fObtenerFuncionario(cedulaFuncionario IN VARCHAR2) RETURN FUNCIONARIO%rowtype 
    IS ovFuncionario FUNCIONARIO%rowtype;
    BEGIN
        SELECT * into ovFuncionario
        FROM FUNCIONARIO
        WHERE CEDULAFUNCIONARIO=cedulaFuncionario;
        EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error,no existe un funcionario con esa c�dula.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
    END fObtenerFuncionario;


END pkFuncionarioNivel1;


