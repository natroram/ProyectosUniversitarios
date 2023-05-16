package Control;

import java.awt.event.ActionEvent;

import javax.swing.*;

import Modelo.Main.Main;
import Vista.*;
public class ControlPanelAdmin extends ControlEstandar{

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedOpc = e.getActionCommand();
		if(selectedOpc.equals("Crear nuevo Usuario")) {
			JMenuItem crea = (JMenuItem)e.getSource();
//			String[] c = {"Nombre: ","Cedula: ","Telefono: ","Usuario: ","Email: ","Contraseña: ",
//					"Sueldo: ","Lugar: "};
//			FieldPanel fp = new FieldPanel("Dictamen",c,"Ingrese aqui",null);
			PanelAdmin panel =new PanelAdmin();
			panel.add(new PanelIngresarUsuario());
			Main.v.cont.removeAll();
			Main.v.cont.add(panel);
			Main.v.pack();
		}else if(selectedOpc.equals("Crear Atracciones")) {
			JMenuItem crea = (JMenuItem)e.getSource();
			PanelAdmin panel =new PanelAdmin();
			panel.add(new PanelCrearInfraestructura());
			Main.v.cont.removeAll();
			Main.v.cont.add(panel);
			Main.v.pack();
		}
		
	}

}
