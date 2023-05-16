package Control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import Modelo.Main.*;
import Modelo.Personas.*;
import Modelo.baseDatos.Datos;
import Vista.FieldPanel;
import Vista.PanelAdmin;
import Vista.PanelIngresarUsuario;

public class ControlPanIngresarUsuario extends ControlEstandar{

	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedOpc = e.getActionCommand();
		if(selectedOpc.equals("Aceptar")) {
			PanelAdmin x = (PanelAdmin) Main.v.cont.getComponent(0);
			PanelIngresarUsuario p1 = (PanelIngresarUsuario)x.getComponent(2);
			ArrayList<String> mio = p1.getFPTexts();
			if(PanelIngresarUsuario.ocupacion.equals("Operario")) {
				Operario o = new Operario(mio.get(0),mio.get(1),mio.get(2),mio.get(3),mio.get(4),mio.get(5),Integer.parseInt(mio.get(6)),mio.get(7));
			}
			else if(PanelIngresarUsuario.ocupacion.equals("Vendedor")) {
				Vendedor o = new Vendedor(mio.get(0),mio.get(1),mio.get(2),mio.get(3),mio.get(4),mio.get(5),Integer.parseInt(mio.get(6)),mio.get(7));
			}
			else if(PanelIngresarUsuario.ocupacion.equals("Cliente")) {
				Cliente o = new Cliente(mio.get(0),mio.get(1),mio.get(2),mio.get(3),mio.get(4),mio.get(5));
			}
			else if(PanelIngresarUsuario.ocupacion.equals("Administrador")) {
				Administrador o = new Administrador(mio.get(0),mio.get(1),mio.get(2),mio.get(3),mio.get(4),mio.get(5),Integer.parseInt(mio.get(6)),mio.get(7));
			}
		}
		else if (selectedOpc.equals("Cancelar")) {
			Datos.guardarDatos();
			Main.v.cont.removeAll();
			Main.v.cont.add(new PanelAdmin());
			Main.v.pack();
		}
	}

}
