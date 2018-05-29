package Interfaz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.*;

import controladoras.ControladoraConsultas;
import mundo.Solicitud;

public class VistaConsultas extends JFrame implements ActionListener{

	
	// Variables declaration - do not modify                     
    private JRadioButton btnAnuladas;
    private JRadioButton btnAtendidas;
    private JRadioButton btnPendientes;
    private JToggleButton btnProductosXClientes;
    private JButton btnReturn;
    private JToggleButton btnSolicitudXEstado;
    private JToggleButton btnSolicitudXFuncionario;
    private JToggleButton btnSolicitudXTipo;
    private JRadioButton btnTipoCreacion;
    private JRadioButton btnTipoModificacion;
    private JRadioButton btnDano;
    private JRadioButton btnTipoReclamo;
    private JRadioButton btnTipoRetiro;
    private JButton btnVerProductosXCliente;
    private JButton btnVerSolicitudSolXFunc;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLayeredPane jLayeredPane1;
    private JPanel jPanel2;
    private JRadioButton btnAsignadas;
    private JScrollPane jScrollPane1;
    private JPanel panelProductosXCliente;
    private JPanel panelSolXEstado;
    private JPanel panelSolXFuncionario;
    private JPanel panelSolXTipo;
    private JScrollPane scrollPaneTablaPXClientes;
    private JScrollPane scrollPaneTablaXEstados;
    private JScrollPane scrollPaneTablaXTipo;
    private JTable tablaPXCliente;
    private JTable tablaSolXEstados;
    private JTable tablaSolXFunc;
    private JTable tablaSolXTipo;
    private JTextField txtCedCliente;
    private JTextField txtCedFuncionario;
    
    private VistaOpciones vistaOpc;
    // End of variables declaration 
	public VistaConsultas(VistaOpciones vistaOpciones) {
		vistaOpc=vistaOpciones;
		controladora= new ControladoraConsultas();
		initComponents();
		
		panelSolXFuncionario.setVisible(true);
		panelSolXEstado.setVisible(false);
		panelProductosXCliente.setVisible(false);
		panelSolXTipo.setVisible(false);
		
	}
	
	private ControladoraConsultas controladora;

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String evento= e.getActionCommand();
		
		switch (evento) {
		case "REGRESAR":
			vistaOpc.setVisible(true);
			this.setVisible(false);
			
			break;

			////SOLICITUDESXFUNCIONARIO
		case "SXF":
			
			if(!txtCedFuncionario.getText().equals("") && txtCedFuncionario.getText()!=null){
				try {
					
					ArrayList<Solicitud> solicitudes=new ArrayList<Solicitud>();
					solicitudes= controladora.solicitudesAsignadasXFunc(txtCedFuncionario.getText());
					
					System.out.println("paso");
					if(solicitudes!=null)
					tablaSolXFunc = new JTable(pasarAMAtrizSolicitudes(solicitudes),new String [] {
		            		"Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio",
		            		"Fecha Fin"
		            });
					
					 jScrollPane1.setViewportView(tablaSolXFunc);
				
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}else {
				JOptionPane.showMessageDialog(this, "Ingrese la cédula del Funcionario");
			}
			
			break;
			
			//////SOLICITUDESXESTADO
		case "Asignada":
			
			try {
					btnAnuladas.setSelected(false);
					btnAtendidas.setSelected(false);
					btnPendientes.setSelected(false);
					btnAsignadas.setSelected(true);
					
					ArrayList<Solicitud> solicitudes=new ArrayList<Solicitud>();
					solicitudes= controladora.solicitudesXestado("Asignada");
					
					if(solicitudes!=null)
					 tablaSolXEstados = new JTable(pasarAMAtrizSolicitudes(solicitudes),new String [] {
							 "Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio",
			            		"Fecha Fin"
		            });
					
					scrollPaneTablaXEstados.setViewportView(tablaSolXEstados);
				
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
					
			break;
			
			
		case "Pendiente":
			
			try {
				btnAnuladas.setSelected(false);
				btnAtendidas.setSelected(false);
				btnPendientes.setSelected(true);
				btnAsignadas.setSelected(false);
					
					ArrayList<Solicitud> solicitudes=new ArrayList<Solicitud>();
					solicitudes= controladora.solicitudesXestado("Pendiente");
					
					if(solicitudes!=null)
					 tablaSolXEstados = new JTable(pasarAMAtrizSolicitudes(solicitudes),new String [] {
							 "Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio",
			            		"Fecha Fin"
		            });
					
					scrollPaneTablaXEstados.setViewportView(tablaSolXEstados);
				
				
				} catch (Exception e1) {
					e1.printStackTrace();
				}
					
			break;
		
		
	case "Anulada":
		
		try {
			btnAnuladas.setSelected(true);
			btnAtendidas.setSelected(false);
			btnPendientes.setSelected(false);
			btnAsignadas.setSelected(false);
			
				ArrayList<Solicitud> solicitudes=new ArrayList<Solicitud>();
				solicitudes= controladora.solicitudesXestado("Anulada");
				
				if(solicitudes!=null)
				 tablaSolXEstados = new JTable(pasarAMAtrizSolicitudes(solicitudes),new String [] {
						 "Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio",
		            		"Fecha Fin"
	            });
				
				scrollPaneTablaXEstados.setViewportView(tablaSolXEstados);
			
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				
		break;
	case "Atendida":
		
		try {
			btnAnuladas.setSelected(false);
			btnAtendidas.setSelected(true);
			btnPendientes.setSelected(false);
			btnAsignadas.setSelected(false);
			
				ArrayList<Solicitud> solicitudes=new ArrayList<Solicitud>();
				solicitudes= controladora.solicitudesXestado("Atendida");
				
				if(solicitudes!=null)
				 tablaSolXEstados = new JTable(pasarAMAtrizSolicitudes(solicitudes),new String [] {
						 "Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio",
		            		"Fecha Fin"
	            });
				
				scrollPaneTablaXEstados.setViewportView(tablaSolXEstados);
			
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				
		break;
		
		
		//////////PRODUCTOSXCLIENTE
		
	case "PXC":
		
		if(!txtCedCliente.getText().equals("") && txtCedCliente.getText()!=null){
			try {
				
				ArrayList<String[]> productos=new ArrayList<String[]>();
				productos= controladora.productosXclientes(txtCedCliente.getText());
				
				if(productos!=null)
					tablaPXCliente = new JTable(pasarAMAtrizPXC(productos),new String [] {
	            		"Id producto","Cliente","Fecha de inicio","Fecha de fin"
	            });
				
				scrollPaneTablaPXClientes.setViewportView(tablaPXCliente);
			
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else {
			JOptionPane.showMessageDialog(this, "Ingrese la cédula del Cliente");
		}
		
		break;
		
		//////////////SolXTIPO
		
	case "Creacion":
		
		try {
			btnTipoRetiro.setSelected(false);
			btnTipoCreacion.setSelected(true);
			btnTipoModificacion.setSelected(false);
			btnTipoReclamo.setSelected(false);
			btnDano.setSelected(false);
			
				ArrayList<Solicitud> solicitudes=new ArrayList<Solicitud>();
				solicitudes= controladora.solicitudesXtipo("001");
				
				if(solicitudes!=null)
				 tablaSolXTipo = new JTable(pasarAMAtrizSolicitudes(solicitudes),new String [] {
						 "Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio",
		            		"Fecha Fin"
	            });
				
				scrollPaneTablaXTipo.setViewportView(tablaSolXTipo);
			
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				
		break;
		
	case "Retiro":
		
		try {
			btnTipoRetiro.setSelected(true);
			btnTipoCreacion.setSelected(false);
			btnTipoModificacion.setSelected(false);
			btnTipoReclamo.setSelected(false);
			btnDano.setSelected(false);
			
				ArrayList<Solicitud> solicitudes=new ArrayList<Solicitud>();
				solicitudes= controladora.solicitudesXtipo("002");
				
				if(solicitudes!=null)
				 tablaSolXTipo = new JTable(pasarAMAtrizSolicitudes(solicitudes),new String [] {
						 "Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio",
		            		"Fecha Fin"
	            });
				
				scrollPaneTablaXTipo.setViewportView(tablaSolXTipo);
			
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				
		break;
		
	case "Reclamo":
		
		try {
			btnTipoRetiro.setSelected(false);
			btnTipoCreacion.setSelected(false);
			btnTipoModificacion.setSelected(false);
			btnTipoReclamo.setSelected(true);
			btnDano.setSelected(false);
			
				ArrayList<Solicitud> solicitudes=new ArrayList<Solicitud>();
				solicitudes= controladora.solicitudesXtipo("003");
				
				if(solicitudes!=null)
				 tablaSolXTipo = new JTable(pasarAMAtrizSolicitudes(solicitudes),new String [] {
						 "Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio",
		            		"Fecha Fin"
	            });
				
				scrollPaneTablaXTipo.setViewportView(tablaSolXTipo);
			
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				
		break;
		
	case "Dano":
		
		try {
			btnTipoRetiro.setSelected(false);
			btnTipoCreacion.setSelected(false);
			btnTipoModificacion.setSelected(false);
			btnTipoReclamo.setSelected(false);
			btnDano.setSelected(true);
			
				ArrayList<Solicitud> solicitudes=new ArrayList<Solicitud>();
				solicitudes= controladora.solicitudesXtipo("004");
				
				if(solicitudes!=null)
				 tablaSolXTipo = new JTable(pasarAMAtrizSolicitudes(solicitudes),new String [] {
						 "Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio",
		            		"Fecha Fin"
	            });
				
				scrollPaneTablaXTipo.setViewportView(tablaSolXTipo);
			
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				
		break;
		
	case "Modificacion":
		
		try {
			btnTipoRetiro.setSelected(false);
			btnTipoCreacion.setSelected(false);
			btnTipoModificacion.setSelected(true);
			btnTipoReclamo.setSelected(false);
			btnDano.setSelected(false);
			
				ArrayList<Solicitud> solicitudes=new ArrayList<Solicitud>();
				solicitudes= controladora.solicitudesXtipo("005");
				
				if(solicitudes!=null)
				 tablaSolXTipo = new JTable(pasarAMAtrizSolicitudes(solicitudes),new String [] {
						 "Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio",
		            		"Fecha Fin"
	            });
				
				scrollPaneTablaXTipo.setViewportView(tablaSolXTipo);
			
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				
		break;
		
		
		
		
		
		
		
	
	}
		
	}

	
public String[][] pasarAMAtrizSolicitudes(ArrayList<Solicitud> ma) {
		
		String[][] matriz= new String[ma.size()][9];
		int i=0;
		
		for (Solicitud sActual : ma) {
			
		
			matriz[i][0]=sActual.getId()+"";
			matriz[i][1]=sActual.getEstado()+"";
			matriz[i][2]=sActual.getCedulaCliente()+"";
			
			
			switch (sActual.getTipoSolicitud()) {
			case 001:
				matriz[i][3]="Creación";
				break;
			case 002:
				matriz[i][3]="Retiro";
				break;
			case 003:
				matriz[i][3]="Reclamo";
				break;
			case 004:
				matriz[i][3]="Dano";
				break;
			case 005:
				matriz[i][3]="Modificacion";
				break;
			}
					
			matriz[i][4]=sActual.getCedulaFuncionaario()+"";
			
			if(sActual.getFechaFin()!=null && sActual.getFechaIni()!=null) {
			matriz[i][5]=sActual.getFechaIni()+"";
		
			matriz[i][6]=sActual.getFechaFin()+"";
			}else {
				matriz[i][5]="No definida";
				matriz[i][6]="No definida";
			}
			
			
			
			i++;
			
		}
		
		return matriz;
	}
	


	public String[][] pasarAMAtrizPXC(ArrayList<String[]> ma) {
	
	String[][] matriz= new String[ma.size()][4];
	int i=0;
	
	for (String[] sActual:ma) {
		
		matriz[i][0]=sActual[0]+"";
		matriz[i][1]=sActual[1]+"";
		matriz[i][2]=sActual[2]+"";
		matriz[i][3]=sActual[3]+"";
	
		i++;
		
	}
	
	return matriz;
}

	
	public void mostrarPanelRespectivo(String string) {
		switch (string) {
		case "SXF":
			panelSolXFuncionario.setVisible(true);
			panelSolXEstado.setVisible(false);
			panelProductosXCliente.setVisible(false);
			panelSolXTipo.setVisible(false);
			break;
		case "SXT":
			panelSolXFuncionario.setVisible(false);
			panelSolXEstado.setVisible(false);
			panelProductosXCliente.setVisible(false);
			panelSolXTipo.setVisible(true);
			break;
		case "SXE":
			panelSolXFuncionario.setVisible(false);
			panelSolXEstado.setVisible(true);
			panelProductosXCliente.setVisible(false);
			panelSolXTipo.setVisible(false);
			break;
		case "PXC":
			panelSolXFuncionario.setVisible(false);
			panelSolXEstado.setVisible(false);
			panelProductosXCliente.setVisible(true);
			panelSolXTipo.setVisible(false);
			break;
		
		}
		
	}
 
                           
    private void initComponents() {

        btnReturn = new JButton();
        jLabel1 = new JLabel();
        btnSolicitudXFuncionario = new JToggleButton();
        btnSolicitudXEstado = new JToggleButton();
        btnSolicitudXTipo = new JToggleButton();
        btnProductosXClientes = new JToggleButton();
        jLayeredPane1 = new JLayeredPane();
        panelSolXFuncionario = new JPanel();
        jLabel2 = new JLabel();
        txtCedFuncionario = new JTextField();
        btnVerSolicitudSolXFunc = new JButton();
        jPanel2 = new JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSolXFunc = new javax.swing.JTable();
        panelSolXEstado = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnAtendidas = new javax.swing.JRadioButton();
        btnAnuladas = new javax.swing.JRadioButton();
        btnPendientes = new javax.swing.JRadioButton();
        btnAsignadas = new javax.swing.JRadioButton();
        scrollPaneTablaXEstados = new javax.swing.JScrollPane();
        tablaSolXEstados = new javax.swing.JTable();
        panelSolXTipo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        scrollPaneTablaXTipo = new javax.swing.JScrollPane();
        tablaSolXTipo = new javax.swing.JTable();
        btnDano = new javax.swing.JRadioButton();
        btnTipoRetiro = new javax.swing.JRadioButton();
        btnTipoReclamo = new javax.swing.JRadioButton();
        btnTipoCreacion = new javax.swing.JRadioButton();
        btnTipoModificacion = new javax.swing.JRadioButton();
        panelProductosXCliente = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtCedCliente = new javax.swing.JTextField();
        btnVerProductosXCliente = new javax.swing.JButton();
        scrollPaneTablaPXClientes = new javax.swing.JScrollPane();
        tablaPXCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnReturn.setIcon(new javax.swing.ImageIcon("C:\\Users\\diana\\git\\FinalBD\\FinalBD\\imagenes\\return.png")); // NOI18N
        btnReturn.addActionListener(this);
        btnReturn.setActionCommand("REGRESAR");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTAS");

        btnSolicitudXFuncionario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSolicitudXFuncionario.setText("Solicitudes por Funcionario");
        btnSolicitudXFuncionario.addItemListener(new ItemListener() {
        	@Override
     	   public void itemStateChanged(ItemEvent ev) {
     		      if(ev.getStateChange()==ItemEvent.SELECTED){
     		        
     		        btnSolicitudXTipo.setSelected(false);
     		        btnProductosXClientes.setSelected(false);
     		        btnSolicitudXEstado.setSelected(false);
     		        btnSolicitudXFuncionario.setSelected(true);
     		        mostrarPanelRespectivo("SXF");
     		      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
     		        
     		       btnSolicitudXFuncionario.setSelected(false);
     		      }
     		   }

			});
        
        btnSolicitudXEstado.setFont(new java.awt.Font("Tahoma", 0, 10)); 
        btnSolicitudXEstado.setText("Solicitudes por Estado");
        btnSolicitudXEstado.addItemListener(new ItemListener() {
        	@Override
        	   public void itemStateChanged(ItemEvent ev) {
        		      if(ev.getStateChange()==ItemEvent.SELECTED){
        		        
        		        btnSolicitudXTipo.setSelected(false);
        		        btnProductosXClientes.setSelected(false);
        		        btnSolicitudXEstado.setSelected(true);
        		        btnSolicitudXFuncionario.setSelected(false);
        		        
        		        mostrarPanelRespectivo("SXE");
        		      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
        		        
        		        btnSolicitudXEstado.setSelected(false);
        		      }
        		   }});

        btnSolicitudXTipo.setFont(new java.awt.Font("Tahoma", 0, 10)); 
        btnSolicitudXTipo.setText("Solicitudes por Tipo");
        btnSolicitudXTipo.addItemListener(new ItemListener() {
        	@Override
        	   public void itemStateChanged(ItemEvent ev) {
        		      if(ev.getStateChange()==ItemEvent.SELECTED){
        		       
        		        btnSolicitudXTipo.setSelected(true);
        		        btnProductosXClientes.setSelected(false);
        		        btnSolicitudXEstado.setSelected(false);
        		        btnSolicitudXFuncionario.setSelected(false);
        		        
        		        mostrarPanelRespectivo("SXT");
        		      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
        		       
        		        btnSolicitudXTipo.setSelected(false);
        		      }
        		   }});

			
			

        btnProductosXClientes.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnProductosXClientes.setText("Producto por Clientes");
        btnProductosXClientes.addItemListener(new ItemListener() {
        	@Override
     	   public void itemStateChanged(ItemEvent ev) {
     		      if(ev.getStateChange()==ItemEvent.SELECTED){
     		       
     		        btnSolicitudXTipo.setSelected(false);
     		        btnProductosXClientes.setSelected(true);
     		        btnSolicitudXEstado.setSelected(false);
     		        btnSolicitudXFuncionario.setSelected(false);
     		        
     		       mostrarPanelRespectivo("PXC");
     		      } else if(ev.getStateChange()==ItemEvent.DESELECTED){
     		       
     		    	 btnProductosXClientes.setSelected(false);
     		      }
     		   }});

        panelSolXFuncionario.setBorder(BorderFactory.createTitledBorder("Solicitudes Asignadas"));

        jLabel2.setText("Cédula del Funcionario : ");

        btnVerSolicitudSolXFunc.setText("Ver solicitudes");
        btnVerSolicitudSolXFunc.addActionListener(this);
        btnVerSolicitudSolXFunc.setActionCommand("SXF");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaSolXFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
            		"Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio", 
            		"Fecha Fin" }
        ));
        jScrollPane1.setViewportView(tablaSolXFunc);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelSolXFuncionarioLayout = new javax.swing.GroupLayout(panelSolXFuncionario);
        panelSolXFuncionario.setLayout(panelSolXFuncionarioLayout);
        panelSolXFuncionarioLayout.setHorizontalGroup(
            panelSolXFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSolXFuncionarioLayout.createSequentialGroup()
                .addGroup(panelSolXFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSolXFuncionarioLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSolXFuncionarioLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(panelSolXFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVerSolicitudSolXFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelSolXFuncionarioLayout.setVerticalGroup(
            panelSolXFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSolXFuncionarioLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelSolXFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCedFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerSolicitudSolXFunc)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelSolXEstado.setBorder(javax.swing.BorderFactory.createTitledBorder("Solicitudes por estado"));

        jLabel3.setText("Estados :");

        btnAtendidas.setText("Atendida");
        btnAtendidas.addActionListener(this);
        btnAtendidas.setActionCommand("Atendida");
        
        btnAnuladas.setText("Anulada");
        btnAnuladas.addActionListener(this);
        btnAnuladas.setActionCommand("Anulada");

        btnPendientes.setText("Pendiente");
        btnPendientes.addActionListener(this);
        btnPendientes.setActionCommand("Pendiente");

        btnAsignadas.setText("Asignada");
        btnAsignadas.addActionListener(this);
        btnAsignadas.setActionCommand("Asignada");
        

        tablaSolXEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
            		"Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio", 
            		"Fecha Fin"}
        ));
        scrollPaneTablaXEstados.setViewportView(tablaSolXEstados);

        javax.swing.GroupLayout panelSolXEstadoLayout = new javax.swing.GroupLayout(panelSolXEstado);
        panelSolXEstado.setLayout(panelSolXEstadoLayout);
        panelSolXEstadoLayout.setHorizontalGroup(
            panelSolXEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSolXEstadoLayout.createSequentialGroup()
                .addGroup(panelSolXEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSolXEstadoLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(btnAtendidas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnuladas)
                        .addGap(10, 10, 10)
                        .addComponent(btnPendientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAsignadas))
                    .addGroup(panelSolXEstadoLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSolXEstadoLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(scrollPaneTablaXEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        panelSolXEstadoLayout.setVerticalGroup(
            panelSolXEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSolXEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSolXEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtendidas)
                    .addComponent(btnAnuladas)
                    .addComponent(btnPendientes)
                    .addComponent(btnAsignadas))
                .addGap(18, 18, 18)
                .addComponent(scrollPaneTablaXEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        panelSolXTipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tipos : ");

        tablaSolXTipo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {"Id","Estado","Cliente","Tipo","Funcionario", "Fecha Inicio", 
            		"Fecha Fin" }
        ));
        scrollPaneTablaXTipo.setViewportView(tablaSolXTipo);

        btnDano.setText("Dano");
        btnDano.setActionCommand("Dano");
        btnDano.addActionListener(this);

        btnTipoRetiro.setText("Retiro");
        btnTipoRetiro.setActionCommand("Retiro");
        btnTipoRetiro.addActionListener(this);

        btnTipoReclamo.setText("Reclamo");
        btnTipoReclamo.setActionCommand("Reclamo");
        btnTipoReclamo.addActionListener(this);

        btnTipoCreacion.setText("Creación");
        btnTipoCreacion.setActionCommand("Creacion");
        btnTipoCreacion.addActionListener(this);

        btnTipoModificacion.setText("Modificacion");
        btnTipoModificacion.setActionCommand("Modificacion");
        btnTipoModificacion.addActionListener(this);

        javax.swing.GroupLayout panelSolXTipoLayout = new javax.swing.GroupLayout(panelSolXTipo);
        panelSolXTipo.setLayout(panelSolXTipoLayout);
        panelSolXTipoLayout.setHorizontalGroup(
            panelSolXTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSolXTipoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSolXTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSolXTipoLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnDano))
                    .addComponent(btnTipoCreacion, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(35, 35, 35)
                .addGroup(panelSolXTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSolXTipoLayout.createSequentialGroup()
                        .addComponent(btnTipoRetiro)
                        .addGap(39, 39, 39)
                        .addComponent(btnTipoReclamo))
                    .addComponent(btnTipoModificacion))
                .addGap(61, 61, 61))
            .addGroup(panelSolXTipoLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(scrollPaneTablaXTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        panelSolXTipoLayout.setVerticalGroup(
            panelSolXTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSolXTipoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelSolXTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDano)
                    .addComponent(btnTipoRetiro)
                    .addComponent(btnTipoReclamo)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSolXTipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTipoCreacion)
                    .addComponent(btnTipoModificacion))
                .addGap(18, 18, 18)
                .addComponent(scrollPaneTablaXTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jLabel5.setText("Cédula del cliente : ");

        btnVerProductosXCliente.setText("Ver Productos");
        btnVerProductosXCliente.setActionCommand("PXC");
        btnVerProductosXCliente.addActionListener(this);

        tablaPXCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
            		"Id producto","Cliente","Fecha de inicio","Fecha de fin"
            }
        ));
        scrollPaneTablaPXClientes.setViewportView(tablaPXCliente);

        javax.swing.GroupLayout panelProductosXClienteLayout = new javax.swing.GroupLayout(panelProductosXCliente);
        panelProductosXCliente.setLayout(panelProductosXClienteLayout);
        panelProductosXClienteLayout.setHorizontalGroup(
            panelProductosXClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosXClienteLayout.createSequentialGroup()
                .addGroup(panelProductosXClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelProductosXClienteLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelProductosXClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCedCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerProductosXCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelProductosXClienteLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(scrollPaneTablaPXClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        panelProductosXClienteLayout.setVerticalGroup(
            panelProductosXClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProductosXClienteLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelProductosXClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCedCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVerProductosXCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPaneTablaPXClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(panelSolXFuncionario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelSolXEstado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelSolXTipo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(panelProductosXCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(panelSolXFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelSolXEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelSolXTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(80, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelProductosXCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(39, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSolXFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelSolXEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(29, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelSolXTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelProductosXCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(66, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSolicitudXFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSolicitudXEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSolicitudXTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProductosXClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(327, 327, 327))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addComponent(btnSolicitudXFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSolicitudXEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSolicitudXTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProductosXClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReturn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }                      

    

                      
}



