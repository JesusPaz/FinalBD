CREATE OR REPLACE PACKAGE pkAtencionNivel2 IS 
   PROCEDURE pAtenderSolicitud(ivCedulaFuncionario VARCHAR2,ivIdSolicitud IN NUMBER, ivComentario IN VARCHAR2);
   PROCEDURE pAtenderReclamoODano(ivIdCedulaFuncionario IN NUMBER,ivIdSolicitud IN VARCHAR2, ivEstado IN VARCHAR2);
   
END pkAtencionNivel2;
/
CREATE OR REPLACE PACKAGE BODY pkAtencionNivel2 IS 

   PROCEDURE pAtenderSolicitud(ivCedulaFuncionario IN VARCHAR2,ivIdSolicitud IN NUMBER, ivComentario IN VARCHAR2)
   IS 
   fecha DATE;
   solicitud SOLICITUD%rowtype;
   BEGIN 
   solicitud :=pkSOLICITUD.OBTENERSOLICITUD(ivIdSolicitud);
   
   IF solicitud IS NULL THEN
   RAISE_APPLICATION_ERROR(-20001,'No existe una solicitud con el ID buscado.');
   END IF;
   
   IF solicitud.FUNCIONARIO_CEDULAFUNCIONARIO=ivIdCedulaFuncionario THEN     
    IF solicitud.TIPOSOLICITUD_IDTIPOSOLICITUD='001' THEN
    fecha:=ADDMONTHS(TRUNC(SYSDATE,'MM'),1);--El primer dia del proximo mes
    pkPRODUCTOSXCLIENTENIVEL1.PINSERTAR(solicitud.PRODUCTO_IDPRODUCTO,CLIENTE_CEDULACLIENTE,fecha,NULL);
    pkSOLICITUDNIVEL1.PMODIFICAR(solicitud.IDSOLICITUD, 'atendida',ivComentario,solicitud.FECHAINI,SYSDATE,solicitud.CLIENTE_CEDULACLIENTE,
    solicitud.TIPOSOLICITUD_IDTIPOSOLICITUD,solicitud.FUNCIONARIO_CEDULAFUNCIONARIO,solicitud.TIPOANOMALIA_IDANOMALIA,solicitud.TIPOPRODUCTO_IDTIPOPRODUCTO,
    solicitud.PRODUCTO_IDPRODUCTO);
    
    ELSIF solicitud.TIPOSOLICITUD_IDTIPOSOLICITUD='002' THEN
    fecha:=SYSDATE;
    pkPRODUCTOSXCLIENTENIVEL1.PINSERTAR(solicitud.PRODUCTO_IDPRODUCTO,CLIENTE_CEDULACLIENTE,fecha,NULL);  
    pkSOLICITUDNIVEL1.PMODIFICAR(solicitud.IDSOLICITUD, 'atendida',ivComentario,solicitud.FECHAINI,solicitud.FECHAFIN,solicitud.CLIENTE_CEDULACLIENTE,
    solicitud.TIPOSOLICITUD_IDTIPOSOLICITUD,solicitud.FUNCIONARIO_CEDULAFUNCIONARIO,solicitud.TIPOANOMALIA_IDANOMALIA,solicitud.TIPOPRODUCTO_IDTIPOPRODUCTO,
    solicitud.PRODUCTO_IDPRODUCTO);
    
    END IF;
   ELSE
   RAISE_APPLICATION_ERROR(-20001,'Esta solicitud no esta asociada al funcionario buscado.');
   END IF; 
   END pAsignacionAutomatica;
    
   PROCEDURE pAtenderReclamoODano(ivIdCedulaFuncionario IN NUMBER,ivIdSolicitud IN VARCHAR2, ivEstado IN VARCHAR2)
   IS
   solicitud SOLICITUD%rowtype;
   BEGIN 
   solicitud :=pkSOLICITUD.OBTENERSOLICITUD(ivIdSolicitud);
  
   IF solicitud IS NULL THEN
   RAISE_APPLICATION_ERROR(-20001,'No existe una solicitud con el ID buscado.');
   END IF;
   IF solicitud.FUNCIONARIO_CEDULAFUNCIONARIO=ivIdCedulaFuncionario THEN     
    IF solicitud.TIPOSOLICITUD_IDTIPOSOLICITUD='001' THEN
    pkSOLICITUDNIVEL1.PMODIFICAR(solicitud.IDSOLICITUD, ivEstado,ivComentario,solicitud.FECHAINI,solcitud.FECHAFIN,solicitud.CLIENTE_CEDULACLIENTE,
    solicitud.TIPOSOLICITUD_IDTIPOSOLICITUD,solicitud.FUNCIONARIO_CEDULAFUNCIONARIO,solicitud.TIPOANOMALIA_IDANOMALIA,solicitud.TIPOPRODUCTO_IDTIPOPRODUCTO,
    solicitud.PRODUCTO_IDPRODUCTO);
    END IF;
   END IF;
   END pAtencionIndividual;
      


END pkAtencionNivel2;