CREATE OR REPLACE PACKAGE pkAtencionNivel2 IS 
   PROCEDURE pAtenderSolicitud(ivCedulaFuncionario IN VARCHAR2,ivIdSolicitud IN NUMBER, ivComentario IN VARCHAR2);
   PROCEDURE pAtenderReclamoODano(ivIdCedulaFuncionario IN NUMBER,ivIdSolicitud IN VARCHAR2, ivEstado IN VARCHAR2,ivComentario IN VARCHAR2);
   PROCEDURE pAtenderReclamoODanoAutomatico(ivIdSolicitud IN VARCHAR2);
END pkAtencionNivel2;
/
CREATE OR REPLACE PACKAGE BODY pkAtencionNivel2 IS 

   PROCEDURE pAtenderSolicitud(ivCedulaFuncionario IN VARCHAR2,ivIdSolicitud IN NUMBER, ivComentario IN VARCHAR2)
   IS 
   fecha DATE;
   solicitudAct SOLICITUD%rowtype;

 
   BEGIN 
   solicitudAct :=pkSOLICITUDNIVEL1.fCONSULTAR(ivIdSolicitud);
 

    
   IF solicitudAct.IDSOLICITUD IS NULL THEN
   RAISE_APPLICATION_ERROR(-20001,'No existe una solicitud con el ID buscado.');
   END IF;
   
   IF solicitudAct.FUNCIONARIO_CEDULAFUNCIONARIO=ivCedulaFuncionario THEN     
    IF solicitudAct.TIPOSOLICITUD_IDTIPOSOLICITUD='001' THEN
    fecha:=ADD_MONTHS(TRUNC(SYSDATE,'MM'),1);--El primer dia del proximo mes
    pkPRODUCTOSXCLIENTENIVEL1.PINSERTAR(solicitudAct.PRODUCTO_IDPRODUCTO,solicitudAct.CLIENTE_CEDULACLIENTE,fecha,NULL);
    pkSOLICITUDNIVEL1.PMODIFICAR(solicitudAct.IDSOLICITUD, 'atendida',ivComentario,solicitudAct.CLIENTE_CEDULACLIENTE,solicitudAct.FUNCIONARIO_CEDULAFUNCIONARIO,
    solicitudAct.FECHAINI,SYSDATE, solicitudAct.TIPOSOLICITUD_IDTIPOSOLICITUD,solicitudAct.TIPOANOMALIA_IDANOMALIA,solicitudAct.TIPOPRODUCTO_IDTIPOPRODUCTO,
    solicitudAct.PRODUCTO_IDPRODUCTO);
    
    ELSIF solicitudAct.TIPOSOLICITUD_IDTIPOSOLICITUD='002' THEN
    fecha:=SYSDATE;
    pkPRODUCTOSXCLIENTENIVEL1.PINSERTAR(solicitudAct.PRODUCTO_IDPRODUCTO,solicitudAct.CLIENTE_CEDULACLIENTE,fecha,NULL);  
    pkSOLICITUDNIVEL1.PMODIFICAR(solicitudAct.IDSOLICITUD, 'Atendida',ivComentario,solicitudAct.CLIENTE_CEDULACLIENTE,solicitudAct.FUNCIONARIO_CEDULAFUNCIONARIO,
    solicitudAct.FECHAINI,solicitudAct.FECHAFIN,solicitudAct.TIPOSOLICITUD_IDTIPOSOLICITUD,solicitudAct.TIPOANOMALIA_IDANOMALIA,solicitudAct.TIPOPRODUCTO_IDTIPOPRODUCTO,
    solicitudAct.PRODUCTO_IDPRODUCTO);
    
    END IF;
   ELSE
   RAISE_APPLICATION_ERROR(-20001,'Esta solicitud no esta asociada al funcionario buscado.');
   END IF; 
   
   END pAtenderSolicitud;
      
PROCEDURE pAtenderReclamoODano(ivIdCedulaFuncionario IN NUMBER,ivIdSolicitud IN VARCHAR2, ivEstado IN VARCHAR2,ivComentario IN VARCHAR2)--p2
   IS
   solicitudAct SOLICITUD%rowtype;
   BEGIN 
   solicitudAct :=pkSOLICITUDNIVEL1.fCONSULTAR(ivIdSolicitud);
  
   IF solicitudAct.IDSOLICITUD IS NULL THEN
   RAISE_APPLICATION_ERROR(-20001,'No existe una solicitud con el ID buscado.');
   END IF;
   IF solicitudAct.FUNCIONARIO_CEDULAFUNCIONARIO=ivIdCedulaFuncionario THEN     
    IF solicitudAct.TIPOSOLICITUD_IDTIPOSOLICITUD='001' THEN
    pkSOLICITUDNIVEL1.PMODIFICAR(solicitudAct.IDSOLICITUD, ivEstado,ivComentario,solicitudAct.CLIENTE_CEDULACLIENTE,solicitudAct.FUNCIONARIO_CEDULAFUNCIONARIO,solicitudAct.FECHAINI,solicitudAct.FECHAFIN,
    solicitudAct.TIPOSOLICITUD_IDTIPOSOLICITUD,solicitudAct.TIPOANOMALIA_IDANOMALIA,solicitudAct.TIPOPRODUCTO_IDTIPOPRODUCTO,
    solicitudAct.PRODUCTO_IDPRODUCTO);
    END IF;
   END IF;
   END pAtenderReclamoODano;


   PROCEDURE pAtenderReclamoODanoAutomatico(ivIdSolicitud IN VARCHAR2)--p3
    IS
   solicitud SOLICITUD%rowtype;
   tiempoLimite NUMBER;
   expiradas SOLICITUD.IDSOLICITUD%rowtype;
   cur1 sys_refcursor;
   BEGIN 
   
   SELECT P.Valor into tiempoLimite
   FROM PARAMETROS P
   WHERE P.idParametros=0002;
   
   SELECT  S.IdSolicitud into expiradas
   FROM  SOLICITUD S 
   WHERE S.FECHAINI-S.FECHAFIN >= TO_DATE(tiempoLimite) 
   AND ROWNUM = 1
   AND S.ESTADO='Asignado'
   AND (S.TIPOSOLICITUD_IDTIPOSOLICITUD=003 OR S.TIPOSOLICITUD_IDTIPOSOLICITUD=004);
   
   
   solicitud :=pkSOLICITUD.OBTENERSOLICITUD(ivIdSolicitud);
   
   IF solicitud IS NULL THEN
   RAISE_APPLICATION_ERROR(-20001,'No existe una solicitud con el ID buscado.');
   END IF;
   
   IF solicitud.TIPOSOLICITUD_IDTIPOSOLICITUD!=003 or solucitud.TIPOSOLICITUD_IDTIPOSOLICITUD!=004 THEN
   RAISE_APPLICATION_ERROR(-20001,'La solicitud pasada por parametro no es de tipo daño o reclamo.');
   ELSE
   --Inicio del loop
   loop
   fetch cur1 into expiradas;
   exit when cur1%notfound;
    pkSOLICITUDNIVEL1.PMODIFICAR(expiradas, 'Atendida','Atendida automaticamente por el sistema',solicitud.FECHAINI,solcitud.FECHAFIN,solicitud.CLIENTE_CEDULACLIENTE,
    solicitud.TIPOSOLICITUD_IDTIPOSOLICITUD,solicitud.FUNCIONARIO_CEDULAFUNCIONARIO,solicitud.TIPOANOMALIA_IDANOMALIA,solicitud.TIPOPRODUCTO_IDTIPOPRODUCTO,
    solicitud.PRODUCTO_IDPRODUCTO);
   END loop; 
   END IF;
   
   END pAtenderReclamoODanoAutomatico;   


END pkAtencionNivel2;
