package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

import controladoras.ControladoraInicioSesion;

public class VistaInicioSesion extends JFrame implements ActionListener {
	
	  
		private static final long serialVersionUID = 1L;
	
		private JButton btnEntrar;
	    private JLabel lblContra;
	    private JLabel lblUsu;
	    private JPasswordField txtContrasena;
	    private JTextField txtUsuario;
	    
	    
	    private VistaAsignacion asignacion;
	    private VistaAtencion atencion;
	    private VistaConsultas consultas;
	    private VistaRegistro registro;
	    
	    
	    private VistaOpciones opciones;
	    
	    private ControladoraInicioSesion contInicioSesion;
	    
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("ENTRAR")) {
			
			try {
				
				String resultado =  ControladoraInicioSesion.getInstance().Acceder(txtUsuario.getText());

				if (resultado.equals("Exito")) {
					opciones=new VistaOpciones(this);
					opciones.setVisible(true);
					
				} else {
					// Mostrar Error
					JOptionPane.showMessageDialog(null, resultado);
				}

				
//				if(contInicioSesion.Acceder(txtUsuario.getText()).equals("Correcto")) {
				
//				}
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
							
		}
		
	}
		
	
    public VistaInicioSesion() {
        
    	initComponents();
    	contInicioSesion= new ControladoraInicioSesion();
        
    }
                     
    private void initComponents() {

        txtUsuario = new JTextField();
        btnEntrar = new JButton();
        txtContrasena = new JPasswordField();
        lblUsu = new JLabel();
        lblContra = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtUsuario.setText("txtUsuario");
        txtUsuario.setName("txtUsuario"); 
        btnEntrar.setText("Entrar");
        btnEntrar.setName("butEntrar"); 
        btnEntrar.addActionListener(this);
        btnEntrar.setActionCommand("ENTRAR");

        txtContrasena.setText("jPasswordField1");

        lblUsu.setText("Usuario : ");

        lblContra.setText("Contraseña : ");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(lblContra)
                    .addComponent(lblUsu, GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtUsuario)
                    .addComponent(txtContrasena, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnEntrar, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUsu))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContrasena, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContra))
                .addGap(18, 18, 18)
                .addComponent(btnEntrar,GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        pack();
    }                       

                                         

    /**
     * @param args the command line arguments
     * @throws Exception 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws ClassNotFoundException 
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, Exception {
       
   
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
       
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaInicioSesion().setVisible(true);
            }
        });
    }

                      
  
      

}


