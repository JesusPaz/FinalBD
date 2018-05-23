CREATE OR REPLACE PACKAGE pkAtencionNivel2 IS 
   PROCEDURE pAtenderSolicitud(ivCedulaFuncionario VARCHAR2,ivIdSolicitud IN NUMBER, ivComentario IN VARCHAR2);
   PROCEDURE pAtenderReclamoODano(ivIdCedulaFuncionario IN NUMBER,ivIdSolicitud IN VARCHAR2, ivEstado IN VARCHAR2);
   PROCEDURE pAtenderReclamoODanoAutomatico(ivIdSolicitud IN VARCHAR2);
END pkAtencionNivel2;
/
CREATE OR REPLACE PACKAGE BODY pkAtencionNivel2 IS 

   PROCEDURE pAtenderSolicitud(ivCedulaFuncionario IN VARCHAR2,ivIdSolicitud IN NUMBER, ivComentario IN VARCHAR2)--p1
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
   END pAtenderSolicitud;
    
   PROCEDURE pAtenderReclamoODano(ivIdCedulaFuncionario IN NUMBER,ivIdSolicitud IN VARCHAR2, ivEstado IN VARCHAR2)--p2
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
   END pAtenderReclamoODano;
   
   PROCEDURE pAtenderReclamoODanoAutomatico(ivIdSolicitud IN VARCHAR2)--p3
    IS
   solicitud SOLICITUD%rowtype;
   tiempoLimite NUMBER;
   contador NUMBER;
   expiradas NUMBER;
   BEGIN 
   
   SELECT P.Valor into tiempoLimite
   FROM PARAMETROS P
   WHERE P.idParametros=0002;
   
   SELECT  S.IdSolicitud into expiradas
   FROM  SOLICITUD S 
   WHERE S.FECHAINI-S.FECHAFIN >= TO_DATE(tiempoLimite) 
   AND ROWNUM = 1
   AND S.ESTADO='asignado'
   AND (S.TIPOSOLICITUD_IDTIPOSOLICITUD='dano' OR S.TIPOSOLICITUD_IDTIPOSOLICITUD='reclamo');
   
   SELECT COUNT(idSolicitud) into contador
   FROM expiradas;
   
   
   solicitud :=pkSOLICITUD.OBTENERSOLICITUD(ivIdSolicitud);
   
   IF solicitud IS NULL THEN
   RAISE_APPLICATION_ERROR(-20001,'No existe una solicitud con el ID buscado.');
   END IF;
   
   IF solicitud.TIPOPRODUCTO_IDTIPOPRODUCTO!='dano' or solucitud.TIPOPRODUCTO_IDTIPOPRODUCTO!='reclamo' THEN
   RAISE_APPLICATION_ERROR(-20001,'La solicitud pasada por parametro no es de tipo daño o reclamo.');
   END IF;
   
    pkSOLICITUDNIVEL1.PMODIFICAR(solicitud.IDSOLICITUD, 'atendida','Atendida automaticamente por el sistema',solicitud.FECHAINI,solcitud.FECHAFIN,solicitud.CLIENTE_CEDULACLIENTE,
    solicitud.TIPOSOLICITUD_IDTIPOSOLICITUD,solicitud.FUNCIONARIO_CEDULAFUNCIONARIO,solicitud.TIPOANOMALIA_IDANOMALIA,solicitud.TIPOPRODUCTO_IDTIPOPRODUCTO,
    solicitud.PRODUCTO_IDPRODUCTO);
    
   
   END pAtenderREclamoODanoAutomatico;   


END pkAtencionNivel2;
