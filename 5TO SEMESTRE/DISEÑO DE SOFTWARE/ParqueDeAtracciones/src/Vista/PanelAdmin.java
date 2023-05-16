package Vista;

import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*;

import Control.*;

public class PanelAdmin extends JPanel {
	JMenu bArchivo, bAyuda, bPyC;
	JMenuItem usu,salir,crear, veratrac,acerca;
	JMenuBar BarraH;
	JLabel saludo;

	public PanelAdmin() {
		bArchivo = new JMenu("Archivo");
		bPyC = new JMenu("Procesos y consultas");
		crear = new JMenuItem("Crear nuevo Usuario");
		veratrac = new JMenuItem("Crear Atracciones");
		usu = new JMenuItem("Usuario");
		usu.addActionListener(new ControlMenuBar());
		salir = new JMenuItem("Salir");
		salir.addActionListener(new ControlMenuBar());
		crear.addActionListener(new ControlPanelAdmin());
		veratrac.addActionListener(new ControlPanelAdmin());
		bArchivo.add(usu);
		bArchivo.add(salir);
		bPyC.add(crear);
		bPyC.add(veratrac);
		bAyuda = new JMenu("Ayuda");
		acerca = new JMenuItem("Acerca de:");
		acerca.addActionListener(new ControlMenuBar());
		bAyuda.add(acerca);
		BarraH = new JMenuBar();
		saludo = new JLabel("Bienvenido Administrador Haga clic en procesos y "
				+ "consultas para seleccionar lo que desea",SwingConstants.CENTER);
		saludo.setFont(new Font("Courier New", Font.ITALIC, 17));
		
		this.setLayout(new BorderLayout());
		BarraH.add(bArchivo);
		BarraH.add(bPyC);
		BarraH.add(bAyuda);
		add(BarraH, BorderLayout.NORTH);
		add(saludo, BorderLayout.CENTER);
		
	}
	
	
}