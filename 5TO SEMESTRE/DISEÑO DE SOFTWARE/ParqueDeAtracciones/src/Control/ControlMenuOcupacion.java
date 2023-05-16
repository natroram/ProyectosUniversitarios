package Control;

import java.awt.event.ActionEvent;

import Vista.PanelIngresarUsuario;

public class ControlMenuOcupacion extends ControlEstandar{

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedOpc = e.getActionCommand();
		if(selectedOpc.equals("Operario")) {
			System.out.println("Entro");
			PanelIngresarUsuario.ocupacion="Operario";
		}
		else if(selectedOpc.equals("Vendedor")) {
			PanelIngresarUsuario.ocupacion="Vendedor";
		}
		else if(selectedOpc.equals("Cliente")) {
			PanelIngresarUsuario.ocupacion="Cliente";
		}
		else if(selectedOpc.equals("Administrador")) {
			PanelIngresarUsuario.ocupacion="Administrador";
		}
	}

}
