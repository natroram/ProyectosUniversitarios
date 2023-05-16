package Vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.EmptyBorder;

import Control.ControlEstandar;

public class InterfazGestorAtracciones extends JPanel implements InterfazVista{
	Container cont;
	JPanel p1,p2;
	JButton bArchivo, bAyuda, bPyC, bAbrir, bCerrar, bSolMant;
	JToolBar BarraH;
	JComboBox cajaAtracciones;
	JLabel texto1;

	public InterfazGestorAtracciones(){
			setSize(700,600);
			setVisible(true);
			
			bArchivo = new JButton("Archivo");
			bPyC = new JButton("Procesos y consultas");
			bAyuda = new JButton("Ayuda");
			BarraH = new JToolBar();
			p1 = new JPanel();
			p1.setLayout(new GridLayout());
			texto1 = new JLabel("Seleccione la atraccion:");
			cajaAtracciones = new JComboBox();
			cajaAtracciones.setModel(new DefaultComboBoxModel(new String[] {"Rueda de la fortuna", "Monta\u00F1a rusa", "Carritos chocones"}));
			p2 = new JPanel();
			p2.setLayout(new GridLayout());
			bAbrir = new JButton("Abrir");
			bCerrar = new JButton("Cerrar");
			bSolMant = new JButton("Solicitar mantenimiento");
			
			BarraH.add(bArchivo);
			BarraH.add(bPyC);
			BarraH.add(bAyuda);
			
			cont.setLayout(new BorderLayout());
			cont.add(BarraH, BorderLayout.NORTH);
			cont.add(p1, BorderLayout.CENTER);
			cont.add(p2, BorderLayout.SOUTH);
			
			p1.add(texto1);
			p1.add(cajaAtracciones);
			//p1.setSize(100, 100);
			
			p2.add(bAbrir);
			p2.add(bSolMant);
			p2.add(bCerrar);
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