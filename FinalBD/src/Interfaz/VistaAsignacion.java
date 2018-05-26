package Interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controladoras.ControladoraInicioSesion;

public class VistaAsignacion extends JFrame implements ActionListener {

	public VistaAsignacion(VistaOpciones vistaOpciones) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("AUTOMATICA")) {
			
			try {
				
				String resultado ="";
				//String resultado =  ControladoraInicioSesion.getInstance().Acceder(txtUsuario.getText());

				if (resultado.equals("Exito")) {
					JOptionPane.showMessageDialog(null, resultado);
					
				} else {
					// Mostrar Error
					JOptionPane.showMessageDialog(null, resultado);
					
				}
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
							
		}else if(e.getActionCommand().equals("INDIVIDUAL")) {
			
			try {
				String resultado ="";

				//String resultado =  ControladoraInicioSesion.getInstance().Acceder(txtUsuario.getText());

				if (resultado.equals("Exito")) {
					JOptionPane.showMessageDialog(null, resultado);
					
				} else {
					// Mostrar Error
					JOptionPane.showMessageDialog(null, resultado);
					
				}
				
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
							
		}

		
	}

}
