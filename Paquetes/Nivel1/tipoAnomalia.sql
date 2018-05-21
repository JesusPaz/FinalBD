create or replace PACKAGE pkTipoAnomalia IS 

    PROCEDURE pInsertarAnomalia(LidAnomalia IN NUMBER, LNombre  IN VARCHAR2);
    
 PROCEDURE pEliminarTipoAnomalia(LidAnomalia IN NUMBER);
    
    PROCEDURE pActualizarTipoAnomalia(LidAnomalia IN NUMBER, LNombre  IN VARCHAR2);
    
    FUNCTION fObtenerTipoAnomalia(LidAnomalia in NUMBER) RETURN TIPOANOMALIA%rowtype;

 END pkTipoAnomalia;

/

create or replace PACKAGE BODY pkTipoAnomalia IS 
-- Insertar
  PROCEDURE pInsertarAnomalia
    (LidAnomalia NUMBER, LNombre VARCHAR2)
  IS
    BEGIN
    INSERT INTO TIPOANOMALIA
    VALUES (LidAnomalia , LNombre);
    
        EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, este registro ya existe.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
  END pInsertarAnomalia;

     
  --Eliminar
  
   PROCEDURE pEliminarTipoAnomalia(LidAnomalia IN NUMBER) IS
    BEGIN
    DELETE FROM TIPOANOMALIA S WHERE S.IDANOMALIA = LidAnomalia;
     EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe solicitud con ese id.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
  END pEliminarTipoAnomalia;

    
  -- Actualizar
  PROCEDURE pActualizarTipoAnomalia(LidAnomalia NUMBER, LNombre VARCHAR2) IS
    BEGIN
    UPDATE TIPOANOMALIA 
    SET  IDANOMALIA=LidAnomalia ,NOMBRE=LNombre
    WHERE IDANOMALIA=LidAnomalia;
    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe solicitud con ese id.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
        
  END pActualizarTipoAnomalia;
  

  
  
  
    
  --OBTENER
  FUNCTION fObtenerTipoAnomalia(LidAnomalia IN NUMBER) RETURN TIPOANOMALIA%rowtype 
    IS ovTipoAnomalia TIPOANOMALIA%rowtype;
    BEGIN
        SELECT * into ovTipoAnomalia
        FROM TIPOANOMALIA
        WHERE IDANOMALIA=LidAnomalia;
        
        EXCEPTION
            WHEN NO_DATA_FOUND THEN 
            RAISE_APPLICATION_ERROR(-20001,'Error, no existe solicitud con ese id.');
            WHEN OTHERS THEN 
            RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
        
    END fObtenerTipoAnomalia;
  
  
  
  END pkTipoAnomalia;