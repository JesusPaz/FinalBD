package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class VistaOpciones extends JFrame implements ActionListener{
	
	  private VistaAsignacion asignacion;
	    private VistaAtencion atencion;
	    private VistaConsultas consultas;
	    private VistaRegistro registrar;
	    private VistaInicioSesion iSesion;
	    
	    
	                   
	    private JButton btnAsignar;
	    private JButton btnAtender;
	    private JButton btnConsultar;
	    private JButton btnRegistrar;
	    
	
	public VistaOpciones(VistaInicioSesion inicio) {
		iSesion=inicio;
		asignacion= new VistaAsignacion(this);
		atencion= new VistaAtencion(this);
		consultas= new VistaConsultas(this);
		registrar= new VistaRegistro(this);
		
		initComponents();
	}
	
    @SuppressWarnings("unchecked")                         
    private void initComponents() {

        btnConsultar = new JButton();
        btnRegistrar = new JButton();
        btnAtender = new JButton();
        btnAsignar = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnConsultar.setText("Consultar");
        btnConsultar.addActionListener(this);
        btnConsultar.setActionCommand("CONSULTAR");
        

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(this);
        btnRegistrar.setActionCommand("REGISTRAR");

        btnAtender.setText("Atender");
        btnAtender.addActionListener(this);
        btnAtender.setActionCommand("ATENDER");
        
        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(this);
        btnAsignar.setActionCommand("ASIGNAR");

        
       GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnConsultar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAtender, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAsignar, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtender, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAsignar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>                        

  
    

	@Override
	public void actionPerformed(ActionEvent arg0) {
		switch (arg0.getActionCommand()) {
		case "CONSULTAR":
			consultas=new VistaConsultas(this);
			consultas.setVisible(true);
			
			break;
		case "REGISTRAR":
			registrar=new VistaRegistro(this);
			registrar.setVisible(true);
			break;
		case "ASIGNAR":
			asignacion=new VistaAsignacion(this);
			asignacion.setVisible(true);
			break;
		case "ATENDER":
			atencion=new VistaAtencion(this);
			atencion.setVisible(true);
			break;
		}
		
		this.setVisible(false);
		
	}

      

}
