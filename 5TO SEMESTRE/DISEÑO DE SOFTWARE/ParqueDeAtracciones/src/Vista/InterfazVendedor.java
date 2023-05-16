package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

import Control.ControlEstandar;

public class InterfazVendedor extends JFrame implements InterfazVista {
	Container cont;
	JButton bArchivo, bAyuda, bPyC;
	JToolBar BarraH;
	JLabel saludo;

	public InterfazVendedor() {
		setSize(600, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Vendedor: ");

		bArchivo = new JButton("Archivo");
		bPyC = new JButton("Procesos y consultas");
		bAyuda = new JButton("Ayuda");
		BarraH = new JToolBar();
		saludo = new JLabel("Bienvenido clic en procesos y consultas para seleccionar lo que desea");

		BarraH.add(bArchivo);
		BarraH.add(bPyC);
		BarraH.add(bAyuda);

		cont = this.getContentPane();
		cont.setLayout(new BorderLayout());
		cont.add(BarraH, BorderLayout.NORTH);
		cont.add(saludo, BorderLayout.CENTER);

	}

	@Override
	public void setControlador(ControlEstandar c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void arranca() {
		// TODO Auto-generated method stub

	}
}
