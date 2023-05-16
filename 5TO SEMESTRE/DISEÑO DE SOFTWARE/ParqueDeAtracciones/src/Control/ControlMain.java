package Control;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import Modelo.ErroresAplicacion.Exception_Informacion_Usuario;
import Vista.InterfazVendedor;
import Vista.PanelVendedor;
import Vista.VentanaInicio;
import Modelo.Main.Main;
import Modelo.baseDatos.Datos;

public class ControlMain extends ControlEstandar{
	JButton btn;
	public static int contador=0;
	@Override
	public void actionPerformed(ActionEvent e) {
		String selectedOpc = e.getActionCommand();
		if(selectedOpc.equals("Haga clic "
				+ "para ver fotos de los autores del sistema")) {
			btn=(JButton) e.getSource();
			if(contador==0) {
				String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
				ImageIcon icon = new ImageIcon(ruta+"1.jpeg");
				Image img = icon.getImage(); 
				Image nuevaim = img.getScaledInstance(btn.getWidth()-15, btn.getHeight()-50,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon(nuevaim);
				btn.setIcon(icon);
				contador=1;
			}
			else if(contador==1) {
				String ruta = System.getProperty("user.dir")+"\\src\\temp\\";
				ImageIcon icon = new ImageIcon(ruta+"2.jpeg");
				Image img = icon.getImage(); 
				Image nuevaim = img.getScaledInstance(btn.getWidth()-15, btn.getHeight()-50,  java.awt.Image.SCALE_SMOOTH ) ;  
				icon = new ImageIcon(nuevaim);
				btn.setIcon(icon);
				contador=2;
			}
			else {
				btn.setIcon(null);
				contador=0;
			}
		}
	}
}
