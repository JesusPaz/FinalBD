CREATE OR REPLACE PACKAGE pkAtencionNivel3 IS 
    PROCEDURE pAtenderSolicitud(ivIdCedulaFuncionario VARCHAR2,ivIdSolicitud IN NUMBER, ivComentario IN VARCHAR2, ovRetorno out VARCHAR2);
    PROCEDURE pAtenderReclamoODano(ivIdCedulaFuncionario IN NUMBER,ivIdSolicitud IN VARCHAR2, ivEstado IN VARCHAR2,ivComentario IN VARCHAR2, ovRetorno our VARCHAR2);
    PROCEDURE pAtenderReclamoODanoAutomatico(ivIdSolicitud IN VARCHAR2);
   
END pkAtencionNivel3;
/
CREATE OR REPLACE PACKAGE BODY pkAtencionNivel3 IS 

   PROCEDURE pAtenderSolicitud(ivIdCedulaFuncionario VARCHAR2,ivIdSolicitud IN NUMBER, ivComentario IN VARCHAR2, ovRetorno out VARCHAR2)
   IS 
   BEGIN 
   
   PKASIGNACIONNIVEL2.pAtenderSolicitud(ivIdCedulaFuncionario,ivIdSolicitud, ivComentario);
   ovRetorno:='Se atendio la solicitud de manera exitosa.';
     EXCEPTION
        
        WHEN OTHERS THEN 
        ovRetorno:=SQLERRM; 
   
   END pAtenderSolicitud;
    
   PROCEDURE pAtenderReclamoODano(ivIdCedulaFuncionario IN NUMBER,ivIdSolicitud IN VARCHAR2, ivEstado IN VARCHAR2, ovRetorno out VARCHAR2)
   IS
   BEGIN
   
   
   PKASIGNACIONNIVEL2.pAtenderReclamoODano(ivIdCedulaFuncionario ,ivIdSolicitud, ivEstado,ivComentario);
   ovRetorno:='Se atendio el reclamo o el daño de manera exitosa.';
     EXCEPTION
        WHEN OTHERS THEN 
        ovRetorno:=SQLERRM; 
   END pAtenderReclamoODano;
   
   
   PROCEDURE pAtenderReclamoODanoAutomatico(ivIdSolicitud IN VARCHAR2)
   IS
   BEGIN
   
   
   PKASIGNACIONNIVEL2.pAtenderReclamoODanoAutomatico(ivIdSolicitud);
   ovRetorno:='Se realizo la atencion automatica de manera exitosa.';
     EXCEPTION
        WHEN OTHERS THEN 
        ovRetorno:=SQLERRM; 
   END pAtenderReclamoODanoAutomatico;
      


END pkAtencionNivel3;
