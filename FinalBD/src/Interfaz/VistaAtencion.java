package Interfaz;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import controladoras.ControladorAtencion;

public class VistaAtencion extends JFrame implements ActionListener {
	
	private VistaOpciones vistaPrinci;
  
    private JButton btnAtender;
    private JButton btnReturn;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField txtIdFuncionario;
    private JTextField txtIdSolicitud;
        
    private JButton btnReclamoDano;
    private JButton btnReclamoDanoAutomatico;
    private JButton btnRetiro;
   
    private JButton btnSolicitud;
  
    private JLayeredPane jLayeredPane1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    
    private String idFuncionario;
    private int idSolicitud;
    private ControladorAtencion controladorAtencion;
    
	public VistaAtencion(VistaOpciones vistaOpciones) {
		vistaPrinci=vistaOpciones;
		 initComponents();
		 controladorAtencion= new ControladorAtencion();
		 centrar();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (e.getActionCommand()) {
		case "ATENDER":
			
				
				
				idFuncionario=txtIdFuncionario.getText();
				idSolicitud=Integer.parseInt(txtIdSolicitud.getText());
		/** String[] validar;
		try {
				validar = controladorAtencion.validarAtencion(idFuncionario, idSolicitud);
				
				if(validar[0].equals("1")){
					jPanel1.setVisible(false);
					jPanel2.setVisible(true);
					}
					else{
						JOptionPane.showMessageDialog(null, "La solicitud no puede ser atendida por este funcionario.");
					}
			} catch (Exception e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "El Id de la solicitud debe ser númerico.");
			}
				

			
       		*/	
			jPanel1.setVisible(false);
			jPanel2.setVisible(true);
			break;

		case "REGRESAR":
			vistaPrinci.setVisible(true);
			
			this.setVisible(false);
			break;
		
			//Opcion escogida de atencion
		case "SOLICITUD":
			try {
				VistaAtencionOpciones sol=new VistaAtencionOpciones(vistaPrinci, "SOLICITUD", idFuncionario, idSolicitud);
				sol.setVisible(true);
				this.setVisible(false);
				
			} catch (Exception e2) {
				
			}
			break;
			
			
		case "RECLAMO":
			try {
				VistaAtencionOpciones sol=new VistaAtencionOpciones(vistaPrinci, "RECLAMO",idFuncionario, idSolicitud);
				sol.setVisible(true);
				this.setVisible(false);
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error de la base de datos. No se ha podido atender el reclamo.");
			}
			break;
			
		case "RETIRO":
			try {
				VistaAtencionOpciones sol=new VistaAtencionOpciones(vistaPrinci, "RETIRO",idFuncionario, idSolicitud);
				sol.setVisible(true);
				this.setVisible(false);
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,"Error de la base de datos. No se ha podido atender el retiro.");
			}
			break;
		case "RECLAMO AUTOMATICO":
			
			try {
				controladorAtencion.atenderReclamoODanoAutomatico(idSolicitud);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null,"Error de la base de datos. No se ha podido atender automaticamente el reclamo.");
			}
			
		}
		
		
		
		
		
	}
	
	
	 @SuppressWarnings("unchecked")
	    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
	    private void initComponents() {

	        btnReturn = new JButton();
	        jLabel1 = new JLabel();
	        jLayeredPane1 = new JLayeredPane();
	        jPanel1 = new JPanel();
	        jLabel3 = new JLabel();
	        btnAtender = new JButton();
	        txtIdFuncionario = new JTextField();
	        txtIdSolicitud = new JTextField();
	        jLabel2 = new JLabel();
	        jPanel2 = new JPanel();
	        btnSolicitud = new JButton();
	        btnRetiro = new JButton();
	        btnReclamoDano = new JButton();
	        btnReclamoDanoAutomatico = new JButton();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        btnReturn.setIcon(new javax.swing.ImageIcon("C:\\Users\\diana\\git\\FinalBD\\FinalBD\\imagenes\\return.png")); // NOI18N
	        btnReturn.addActionListener(this);
	        btnReturn.setActionCommand("REGRESAR");

	        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
	        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        jLabel1.setText("ATENCIÓN");

	        jLabel3.setText("Id de la solicitud : ");

	        btnAtender.setText("Atender");
	        btnAtender.addActionListener(this);
	        btnAtender.setActionCommand("ATENDER");

	        jLabel2.setText("Cédula funcionario : ");

	        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	        jPanel1.setLayout(jPanel1Layout);
	        jPanel1Layout.setHorizontalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel1Layout.createSequentialGroup()
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addContainerGap()
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                            .addComponent(txtIdFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
	                            .addComponent(txtIdSolicitud)))
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addGap(112, 112, 112)
	                        .addComponent(btnAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(36, Short.MAX_VALUE))
	        );
	        jPanel1Layout.setVerticalGroup(
	            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	                .addContainerGap(19, Short.MAX_VALUE)
	                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addGroup(jPanel1Layout.createSequentialGroup()
	                        .addComponent(txtIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                            .addComponent(txtIdSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
	                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
	                .addGap(18, 18, 18)
	                .addComponent(btnAtender, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
	        );

	        btnSolicitud.setText("Atender Solicitud");
	        btnSolicitud.addActionListener(this);
	        btnSolicitud.setActionCommand("SOLICITUD");

	        btnRetiro.setText("Retiro Producto");
	        btnRetiro.addActionListener(this);
	        btnRetiro.setActionCommand("RETIRO");
	        

	        btnReclamoDano.setText("Reclamo / Daño");
	        btnReclamoDano.addActionListener(this);
	        btnReclamoDano.setActionCommand("RECLAMO");

	        btnReclamoDanoAutomatico.setText("Reclamo / Daño automatico");
	        btnReclamoDanoAutomatico.addActionListener(this);
	        btnReclamoDanoAutomatico.setActionCommand("RECLAMO AUTOMATICO");

	        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	        jPanel2.setLayout(jPanel2Layout);
	        jPanel2Layout.setHorizontalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addGap(78, 78, 78)
	                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(btnReclamoDanoAutomatico, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(btnReclamoDano, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(btnRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(btnSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
	                .addContainerGap(77, Short.MAX_VALUE))
	        );
	        jPanel2Layout.setVerticalGroup(
	            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jPanel2Layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(btnSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(btnRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(btnReclamoDano, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(btnReclamoDanoAutomatico, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	        );

	        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
	        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

	        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
	        jLayeredPane1.setLayout(jLayeredPane1Layout);
	        jLayeredPane1Layout.setHorizontalGroup(
	            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
	                .addContainerGap(34, Short.MAX_VALUE)
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(jLayeredPane1Layout.createSequentialGroup()
	                    .addGap(31, 31, 31)
	                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(23, Short.MAX_VALUE)))
	        );
	        jLayeredPane1Layout.setVerticalGroup(
	            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(jLayeredPane1Layout.createSequentialGroup()
	                .addGap(107, 107, 107)
	                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                .addGroup(jLayeredPane1Layout.createSequentialGroup()
	                    .addGap(101, 101, 101)
	                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	        );

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(0, 22, Short.MAX_VALUE)
	                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap())
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(106, 106, 106))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap(16, Short.MAX_VALUE)
	                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(1, 1, 1)
	                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
	        );

	        pack();
	        
	        jPanel1.setVisible(true);
	        jPanel2.setVisible(false);
	    }                     

	                                        

	 private void centrar() {
			Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
			int xEsquina = (screen.width - getWidth()) / 2;
			int yEsquina = (screen.height - getHeight()) / 2;
			setLocation(xEsquina, yEsquina);
		}
	 
	    
	  
	}                     

                                            

   

                   

