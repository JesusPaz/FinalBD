package Interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.*;

import controladoras.ControladorRegistro;
import controladoras.ControladoraInicioSesion;
import mundo.Solicitud;

public class VistaRegistro extends JFrame implements ActionListener {
	
	//CONSTANTES
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public final static int VOZ=1;
	public final static int DATOS=2;
	public final static int INTEGRADO=4;
	
	
	public final static int CREACION=1;
	public final static int MODIFICACION=2;
	public final static int CANCELACION=3;
	public final static int DAÑO =4;
	public final static int RECLAMO = 5;
	
	public final static int SIN_ANOMALIA=4;
	public final static int BAJA_VELOCIDAD=5;
	public final static int MALA_CALIDAD=6;
	
	
	
	
	// Variables declaration - do not modify                     
    private JButton btnRegistrar;
    private  JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JComboBox<String> txtAnomalia;

    private JTextField txtIdProducto;
    private JTextField txtObservacion;
    private JComboBox<String> txtTipoP;
    private JComboBox<String> txtTipoSolicitud;

    private JTextField txtIdSolicitud;
    
    private ControladorRegistro controladorRegistro;
    // End of variables declaration 
	
	
	public VistaRegistro(VistaOpciones v) {
		initComponents();
		controladorRegistro=new ControladorRegistro();
		centrar();
	}
	
	private void centrar() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int xEsquina = (screen.width - getWidth()) / 2;
		int yEsquina = (screen.height - getHeight()) / 2;
		setLocation(xEsquina, yEsquina);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("REGISTRAR")) {

			try {
				
				String Cedula=ControladoraInicioSesion.getInstance().getUserActual().getCedula();
				String Observacion=txtObservacion.getText();
				//numero
				int IdSolicitud=Integer.parseInt(txtIdSolicitud.getText());
				// numero
				String TipoSolicitud=(String) txtTipoSolicitud.getSelectedItem();
				//numero
				String TipoAnomalia=(String) txtAnomalia.getSelectedItem() ;
				// numero
				int IdProducto=Integer.parseInt(txtIdProducto.getText());
				//numero
				String TipoProducto=(String) txtTipoP.getSelectedItem();
				
				//PROCEDURE pRegistarSolicitud(ivIdSolicitud IN NUMBER,ivObservacion IN VARCHAR2,ivIdCliente IN VARCHAR2,ivTipoSolicitud IN NUMBER
				//,ivTipoAnomalia NUMBER,ivIdTipoProducto IN NUMBER,ivIdProducto IN NUMBER, ovRetorno out VARCHAR2);
			
				int realTipoSoli=1;
				if (TipoSolicitud.equalsIgnoreCase("Creacion")) {
					realTipoSoli=CREACION;
				}else 		if (TipoSolicitud.equalsIgnoreCase("Modificacion")) {
					realTipoSoli=MODIFICACION;
				}else 		if (TipoSolicitud.equalsIgnoreCase("Cancelacion")) {
					realTipoSoli=CANCELACION;
				}else 		if (TipoSolicitud.equalsIgnoreCase("Daño")) {
					realTipoSoli=DAÑO;
				}else 		if (TipoSolicitud.equalsIgnoreCase("Reclamo")) {
					realTipoSoli=RECLAMO;
				}
				
				System. out. println(TipoAnomalia);
				int realTipoAnomalia=SIN_ANOMALIA;
//		 		if (TipoAnomalia.equalsIgnoreCase("Sin Anomalia")) {
//		 			realTipoAnomalia=SIN_ANOMALIA;
//				}else if (TipoAnomalia.equalsIgnoreCase("Baja Velocidad")) {
//					realTipoAnomalia=BAJA_VELOCIDAD;
//				}else if (TipoAnomalia.equalsIgnoreCase("Mala Calidad")) {
//					realTipoAnomalia=MALA_CALIDAD;
//				}
//		 		
		 		System. out. println(realTipoAnomalia);
		 		
		 		
		 		
		 		
		 		int realTipoProducto=1;
		 		if (TipoProducto.equalsIgnoreCase("Voz")) {
		 			realTipoAnomalia=VOZ;
				}else 		if (TipoProducto.equalsIgnoreCase("Datos")) {
					realTipoAnomalia=DATOS;
				}else 		if (TipoProducto.equalsIgnoreCase("Integrado")) {
					realTipoAnomalia=INTEGRADO;
				}
				
				
				String resultado =  controladorRegistro.registrarSolicitud(IdSolicitud,Observacion,Cedula,realTipoSoli,SIN_ANOMALIA
						,realTipoProducto,IdProducto);

				
					JOptionPane.showMessageDialog(null, resultado);
				
					
			} catch (NumberFormatException exe) {
				JOptionPane.showMessageDialog(null, "Ingrese Id numerico");
				
			}
			catch (Exception ex) {
				
			}
		}
		
		
	}
	
	

   
                         

                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTipoP = new javax.swing.JComboBox<>();
        txtObservacion = new javax.swing.JTextField();
        txtIdProducto = new javax.swing.JTextField();
        txtAnomalia = new javax.swing.JComboBox<>();
        txtTipoSolicitud = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtIdSolicitud = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SOLICITUD");

        txtTipoP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Voz", "Datos", "Integrado" }));

        txtAnomalia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin Anomalia", "Baja Velocidad", "Mala Calidad" }));

        txtTipoSolicitud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Creacion", "Modificacion", "Cancelacion", "Daño", "Reclamo" }));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel2.setText("Tipo producto : ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel4.setText("Observación : ");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel5.setText("Id del producto : ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel6.setText("Anomalia : ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel7.setText("Tipo solicitud :");

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 12)); 
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(this);
        btnRegistrar.setActionCommand("REGISTRAR");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); 
        jLabel3.setText("Id de la solicitud : ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTipoP, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtAnomalia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtIdProducto)
                                .addComponent(txtTipoSolicitud, 0, 180, Short.MAX_VALUE))
                            .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnomalia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        pack();
    }

                                          

    
   

    

}
