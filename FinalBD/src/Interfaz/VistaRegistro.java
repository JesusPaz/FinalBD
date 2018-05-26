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
//    private JTextField txtCedulaCliente;
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
				
				String resultado =  controladorRegistro.registrarSolicitud(IdSolicitud,Observacion,Cedula,000,000,000,IdProducto);

				if (resultado.equals("Solicitud registrada correctamente.")) {
					JOptionPane.showMessageDialog(null, resultado);
					
				} else {
					// Mostrar Error
					JOptionPane.showMessageDialog(null, resultado);
					
				}


			} catch (Exception exception) {
				
			}
		}
		
		
	}
	
	

   
                         
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SOLICITUD");

        txtTipoP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Voz", "Datos", "Integrado" }));

        txtAnomalia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "anomalia1", "anomalia2", "anomalia3" }));

        txtTipoSolicitud.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Creación", "Modificación", "Cancelación", "Daño", "Reclamo" }));

        jLabel2.setText("Tipo producto : ");

        jLabel4.setText("Observación : ");

        jLabel5.setText("Id del producto : ");

        jLabel6.setText("Anomalia : ");

        jLabel7.setText("Tipo solicitud :");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(this);
        btnRegistrar.setActionCommand("REGISTRAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtObservacion)
                                .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTipoP, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTipoSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                            .addComponent(txtAnomalia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoP, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnomalia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }                    

                                          

    
   

    

}
