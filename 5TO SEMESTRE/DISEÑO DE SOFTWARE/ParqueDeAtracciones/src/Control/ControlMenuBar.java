package Control;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import Modelo.Main.Main;
import Modelo.Personas.Usuario;
import Vista.PanelAdmin;
import Vista.VentanaInicio;

public class ControlMenuBar extends ControlEstandar{

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedOpc = e.getActionCommand();
		if(selectedOpc.equals("Usuario")) {
			JOptionPane.showMessageDialog(null, Main.usuario.toString());
		}
		else if(selectedOpc.equals("Salir")) {
			Usuario.signOut();
			Main.v.dispose();
			Main.v = new VentanaInicio();
			Main.v.arranca();
		}
		else if(selectedOpc.equals("Acerca de:")) {
			JOptionPane.showMessageDialog(null, "Realizado por:\nAndres Camilo Garcia Moreno\nLuis Javier Asprilla Galarcio\nJuan Pablo Herrera Herrera\nCristian Jaramillo Herrera");
		}
		
	}

}
