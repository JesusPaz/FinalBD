CREATE OR REPLACE PACKAGE pkTipoProducto IS 

    PROCEDURE pInsertarTipoProducto(LidTipoProducto IN NUMBER, LNombre  IN VARCHAR2);
    
    PROCEDURE pEliminarTipoProducto(LidTipoProducto IN NUMBER);
    
    PROCEDURE pActualizarTipoProducto(LidTipoProducto IN NUMBER, LNombre  IN VARCHAR2);
    
    FUNCTION fObtenerTipoProducto(LidTipoProducto in NUMBER) RETURN TIPOPRODUCTO%rowtype;

   

    
    
    END pkTipoProducto;
 /   
    CREATE OR REPLACE PACKAGE BODY pkTipoProducto IS 
-- Insertar
  PROCEDURE pInsertarTipoProducto
    (LidTipoProducto NUMBER, LNombre VARCHAR2)
  IS
    BEGIN
    INSERT INTO TIPOPRODUCTO
    VALUES (LidTipoProducto , LNombre);
    
        EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, este registro ya existe.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
  END pInsertarTipoProducto;
  
  --Eliminar
  
   PROCEDURE pEliminarTipoProducto(LidTipoProducto IN NUMBER) IS
    BEGIN
    DELETE FROM TIPOPRODUCTO S WHERE S.IDTIPOPRODUCTO = LidTipoProducto;
     EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe solicitud con ese id.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
  END pEliminarTipoProducto;
  
  -- Actualizar
  PROCEDURE pActualizarTipoProducto(LidTipoProducto NUMBER, LNombre VARCHAR2) IS
    BEGIN
    UPDATE TIPOPRODUCTO 
    SET  IDTIPOPRODUCTO=LidTipoProducto ,NOMBRE=LNombre
    WHERE IDTIPOPRODUCTO=LidTipoProducto;
    
    EXCEPTION
        WHEN NO_DATA_FOUND THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error, no existe solicitud con ese id.');
        WHEN OTHERS THEN 
        RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
        
  END pActualizarTipoProducto;
  
  
  --OBTENER
  FUNCTION fObtenerTipoProducto(LidTipoProducto IN NUMBER) RETURN TIPOPRODUCTO%rowtype 
    IS ovTipoProducto TIPOPRODUCTO%rowtype;
    BEGIN
        SELECT * into ovTipoProducto
        FROM TIPOPRODUCTO
        WHERE IDTIPOPRODUCTO=LidTipoProducto;
        
        EXCEPTION
            WHEN NO_DATA_FOUND THEN 
            RAISE_APPLICATION_ERROR(-20001,'Error, no existe solicitud con ese id.');
            WHEN OTHERS THEN 
            RAISE_APPLICATION_ERROR(-20001,'Error desconocido.'||SQLERRM||SQLCODE);
        
    END fObtenerTipoProducto;
   
  
  
  END pkTipoProducto;

   