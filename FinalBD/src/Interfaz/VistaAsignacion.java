package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JOptionPane;

import controladoras.ControladorAsignacion;
import controladoras.ControladoraInicioSesion;

public class VistaAsignacion extends JFrame implements ActionListener {

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("AUTOMATICA")) {
			
			try {
				
				String resultado ="";
				
				int solicitud = Integer.parseInt(txtIdSolicitud.getText());
				
				resultado = controladorAsignacion.asignacionAutomatica(solicitud);

					JOptionPane.showMessageDialog(null, resultado);
					
				
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
							
		}else if(e.getActionCommand().equals("INDIVIDUAL")) {
			
			try {
				String resultado ="";

				int solicitud = Integer.parseInt(txtIdSolicitud.getText());
				String funcionario = txtIdFuncionario.getText();
				
				resultado = controladorAsignacion.asignacionIndividual(solicitud, funcionario);
					
					JOptionPane.showMessageDialog(null, resultado);
					
				
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
							
		}

		
	}
	
	
	
	// Variables declaration - do not modify                     
    private javax.swing.JButton btnAutomatica;
    private javax.swing.JButton btnIndividual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txtIdFuncionario;
    private javax.swing.JTextField txtIdSolicitud;
    private ControladorAsignacion controladorAsignacion;
    // End of variables declaration
    
    
	public VistaAsignacion(VistaOpciones vistaOpciones) {
		 initComponents();
		 controladorAsignacion = new ControladorAsignacion();
	}

	



    
    @SuppressWarnings("unchecked")
                             
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtIdSolicitud = new javax.swing.JTextField();
        txtIdFuncionario = new JTextField();
        btnIndividual = new javax.swing.JButton();
        btnAutomatica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ASIGNACIÓN");
        txtIdSolicitud.setText("000");;
        txtIdFuncionario.setText("000");
        jLabel2.setText("Id de la solicitud : ");

        jLabel3.setText("Id del funcionario : ");

        btnIndividual.setText("Individual");
        btnIndividual.addActionListener(this);
        btnIndividual.setActionCommand("INDIVIDUAL");

        btnAutomatica.setText("Automatica");
        btnAutomatica.addActionListener(this);
        btnAutomatica.setActionCommand("AUTOMATICA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnIndividual, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btnAutomatica, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIdSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAutomatica, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addComponent(btnIndividual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }                        

                                               

    
    

}
