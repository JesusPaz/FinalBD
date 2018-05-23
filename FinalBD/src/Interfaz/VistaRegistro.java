package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.*;

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
    private JTextField txtCedulaCliente;
    private JTextField txtIdProducto;
    private JTextField txtObservacion;
    private JComboBox<String> txtTipoP;
    private JComboBox<String> txtTipoSolicitud;
    
    private JTextField txtIdSolicitud;
    // End of variables declaration 
	
	
	public VistaRegistro(VistaOpciones v) {
		initComponents();
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("REGISTRAR")) {

			try {

			} catch (Exception exception) {
				
			}
		}
		
		
	}
	
	

   
                         
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTipoP = new javax.swing.JComboBox<>();
        txtCedulaCliente = new JTextField();
        txtObservacion = new JTextField();
        txtIdProducto = new JTextField();
        txtAnomalia = new JComboBox<>();
        txtIdSolicitud = new JTextField();
        txtTipoSolicitud = new JComboBox<>();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        btnRegistrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("SOLICITUD");

        txtTipoP.setModel(new DefaultComboBoxModel<>(new String[] { "Voz", "Datos", "Integrado" }));

        txtAnomalia.setModel(new DefaultComboBoxModel<>(new String[] { "anomalia1", "anomalia2", "anomalia3" }));

        txtTipoSolicitud.setModel(new DefaultComboBoxModel<>(new String[] { "Creación", "Modificación", "Cancelación", "Daño", "Reclamo" }));

        jLabel2.setText("Tipo producto : ");

        jLabel3.setText("Cédula del cliente : ");

        jLabel4.setText("Observación : ");

        jLabel5.setText("Id del producto : ");

        jLabel6.setText("Anomalia : ");

        jLabel7.setText("Tipo solicitud :");
        
        jLabel8.setText("Id de la solicitud :");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(this);
        btnRegistrar.setActionCommand("REGISTRAR");

       GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCedulaCliente)
                    .addComponent(txtObservacion)
                    .addComponent(txtIdProducto)
                    .addComponent(txtIdSolicitud)
                    .addComponent(txtTipoP, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTipoSolicitud, 0, 133, Short.MAX_VALUE)
                    .addComponent(txtAnomalia, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                	
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoP,GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedulaCliente, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtObservacion, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdProducto, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtAnomalia, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTipoSolicitud, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(txtIdSolicitud, GroupLayout.PREFERRED_SIZE, 30,GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrar, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }                       

                                              

    
   

    

}
