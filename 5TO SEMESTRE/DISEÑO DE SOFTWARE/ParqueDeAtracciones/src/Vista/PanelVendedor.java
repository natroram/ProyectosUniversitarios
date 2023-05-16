package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import Control.ControlEstandar;

public class PanelVendedor extends JPanel {
	JButton bArchivo, bAyuda, bPyC;
	JToolBar BarraH;
	JLabel saludo;

	public PanelVendedor() {
		bArchivo = new JButton("Archivo");
		bPyC = new JButton("Procesos y consultas");
		bAyuda = new JButton("Ayuda");
		BarraH = new JToolBar();
		saludo = new JLabel("Bienvenido clic en procesos y consultas para seleccionar lo que desea");

		BarraH.add(bArchivo);
		BarraH.add(bPyC);
		BarraH.add(bAyuda);

		this.setLayout(new BorderLayout());
		add(BarraH, BorderLayout.NORTH);
		add(saludo, BorderLayout.CENTER);
		
	}
}
