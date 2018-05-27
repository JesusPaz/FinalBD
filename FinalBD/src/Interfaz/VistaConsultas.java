package Interfaz;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.*;

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
    private JRadioButton btnTipoNuevoP;
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
    private JRadioButton jRadioButton1;
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
		initComponents();
		
		panelSolXFuncionario.setVisible(true);
		panelSolXEstado.setVisible(false);
		panelProductosXCliente.setVisible(false);
		panelSolXTipo.setVisible(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String evento= e.getActionCommand();
		
		switch (evento) {
		case "REGRESAR":
			vistaOpc.setVisible(true);
			this.setVisible(false);
			
			break;

		default:
			break;
		}
	}
	
	
	
 
                           
    private void initComponents() {

        btnReturn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSolicitudXFuncionario = new javax.swing.JToggleButton();
        btnSolicitudXEstado = new javax.swing.JToggleButton();
        btnSolicitudXTipo = new javax.swing.JToggleButton();
        btnProductosXClientes = new javax.swing.JToggleButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        panelSolXFuncionario = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCedFuncionario = new javax.swing.JTextField();
        btnVerSolicitudSolXFunc = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSolXFunc = new javax.swing.JTable();
        panelSolXEstado = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnAtendidas = new javax.swing.JRadioButton();
        btnAnuladas = new javax.swing.JRadioButton();
        btnPendientes = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        scrollPaneTablaXEstados = new javax.swing.JScrollPane();
        tablaSolXEstados = new javax.swing.JTable();
        panelSolXTipo = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        scrollPaneTablaXTipo = new javax.swing.JScrollPane();
        tablaSolXTipo = new javax.swing.JTable();
        btnTipoNuevoP = new javax.swing.JRadioButton();
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTAS");

        btnSolicitudXFuncionario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSolicitudXFuncionario.setText("Solicitudes por Funcionario");

        btnSolicitudXEstado.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSolicitudXEstado.setText("Solicitudes por Estado");

        btnSolicitudXTipo.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnSolicitudXTipo.setText("Solicitudes por Tipo");

        btnProductosXClientes.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnProductosXClientes.setText("Producto por Clientes");
        btnProductosXClientes.addActionListener(this);

        panelSolXFuncionario.setBorder(javax.swing.BorderFactory.createTitledBorder("Solicitudes Asignadas"));

        jLabel2.setText("C�dula del Funcionario : ");

        btnVerSolicitudSolXFunc.setText("Ver solicitudes");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablaSolXFunc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
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

        btnAnuladas.setText("Anulada");

        btnPendientes.setText("Pendientes");

        jRadioButton1.setText("Asignadas");

        tablaSolXEstados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
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
                        .addComponent(jRadioButton1))
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
                    .addComponent(jRadioButton1))
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
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollPaneTablaXTipo.setViewportView(tablaSolXTipo);

        btnTipoNuevoP.setText("Nuevo Producto");
        btnTipoNuevoP.setActionCommand("NuevoProducto");

        btnTipoRetiro.setText("Retiro");

        btnTipoReclamo.setText("Da�o y Reclamo");
        btnTipoReclamo.setActionCommand("DanoReclamo");

        btnTipoCreacion.setText("Creaci�n");
        btnTipoCreacion.setActionCommand("Creacion");

        btnTipoModificacion.setText("Modificacion");

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
                        .addComponent(btnTipoNuevoP))
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
                    .addComponent(btnTipoNuevoP)
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

        jLabel5.setText("C�dula del cliente : ");

        btnVerProductosXCliente.setText("Ver Productos");
        btnVerProductosXCliente.setActionCommand("VerProductos");

        tablaPXCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
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



