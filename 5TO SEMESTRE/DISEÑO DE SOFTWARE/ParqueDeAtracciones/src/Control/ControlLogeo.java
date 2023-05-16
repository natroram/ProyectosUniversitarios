package Control;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import Modelo.ErroresAplicacion.Exception_Contraseña_Invalida;
import Modelo.ErroresAplicacion.Exception_Informacion_Administrador;
import Modelo.ErroresAplicacion.Exception_Informacion_Usuario;
import Modelo.ErroresAplicacion.Exception_Usuario_Invalido;
import Vista.*;
import Vista.VentanaInicio;
import Modelo.Main.Main;
import Modelo.Personas.*;
import Modelo.baseDatos.Datos;

public class ControlLogeo extends ControlEstandar {

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedOpc = e.getActionCommand();
		if (selectedOpc.equals("Administrador")) {
			VentanaInicio.b2.setText("Administrador Complete y Nuevamente Clic");
			VentanaInicio.b3.setText("UsuarioComun");
			VentanaInicio.t1.setEnabled(true);
			VentanaInicio.t2.setEnabled(true);
			VentanaInicio.t1.setVisible(true);
			VentanaInicio.t2.setVisible(true);
			VentanaInicio.l3.setVisible(true);
			VentanaInicio.l4.setVisible(true);
			VentanaInicio.l2.setVisible(true);
		} else if (selectedOpc.equals("Salir")) {
			Datos.guardarDatos();
			Main.v.dispose();
			System.exit(0);
		} else if (selectedOpc.equals("UsuarioComun")) {
			VentanaInicio.b2.setText("Administrador");
			VentanaInicio.b3.setText("Usuario Complete y Nuevamente Clic");
			VentanaInicio.t1.setEnabled(true);
			VentanaInicio.t2.setEnabled(true);
			VentanaInicio.t1.setVisible(true);
			VentanaInicio.t2.setVisible(true);
			VentanaInicio.l3.setVisible(true);
			VentanaInicio.l4.setVisible(true);
			VentanaInicio.l2.setVisible(true);
		} else if (selectedOpc.equals("Administrador Complete y Nuevamente Clic")) {
			String username = Main.v.t1.getText();
			String passw = Main.v.t2.getText();
			try {
				Administrador.verificarloginadmin(username, passw);
			} catch (Exception_Informacion_Administrador R) {
				JOptionPane.showMessageDialog(null,
						"                 Informacion no ingresada "
								+ "\n Por favor llene todos los campos para continuar ",
						"Error faltan datos ", JOptionPane.WARNING_MESSAGE);
			}
			 try {
					Administrador.verificarusuarioadmin(username);			
				} catch (Exception_Usuario_Invalido R) {
					JOptionPane.showMessageDialog(null,
							"               Usuario no encontrado "
									+ "\n Ingrese usuario valido para continuar ",
							"Error Usename Invalido ", JOptionPane.WARNING_MESSAGE);
				}
			 try {
				 Administrador.verificarcontrasenaadmin(username, passw);
					}
					catch (Exception_Contraseña_Invalida R) {
						JOptionPane.showMessageDialog(null,
								"                 Contraseña Invalida "
										+ "\n La contraseña no coincide con el nombre de usuario  ",
								"Error Contraseña Invalida ", JOptionPane.WARNING_MESSAGE);
					}
			if (Usuario.login(username, passw)) {			
				Main.v.cont.removeAll();
				Main.v.cont.add(new PanelAdmin());
				Main.v.pack();
				
			}
		}

		else if (selectedOpc.equals("Usuario Complete y Nuevamente Clic")) {
			String username = Main.v.t1.getText();
			String passw = Main.v.t2.getText();
			try {
				Usuario.verificarlogin(username, passw);
			} catch (Exception_Informacion_Usuario R) {
				JOptionPane.showMessageDialog(null,
						"                 Informacion no ingresada "
								+ "\n Por favor llene todos los campos para continuar ",
						"Error faltan datos ", JOptionPane.WARNING_MESSAGE);
			}
			try {
				Usuario.verificarusuario(username);			
			} catch (Exception_Usuario_Invalido R) {
				JOptionPane.showMessageDialog(null,
						"              Usuario no encontrado "
								+ "\n Ingrese usuario valido para continuar ",
						"Error Usename Invalido ", JOptionPane.WARNING_MESSAGE);
			}
			try {
			Usuario.verificarcontrasena(username, passw);
			}
			catch (Exception_Contraseña_Invalida R) {
				JOptionPane.showMessageDialog(null,
						"                 Contraseña Invalida "
								+ "\n La contraseña no coincide con el nombre de usuario  ",
						"Error Contraseña Invalida ", JOptionPane.WARNING_MESSAGE);
			}			
			if (Usuario.login(username, passw)) {
				Main.v.cont.removeAll();
				Main.v.cont.add(new PanelVendedor());
				Main.v.pack();	
			}				
			// Si se le da click por segunda vez se debe comprobar que los datos se
			// encuentren ingresados de
			// manera correcta con manejo de errores para el usuario comun
		}

	
	}

}
