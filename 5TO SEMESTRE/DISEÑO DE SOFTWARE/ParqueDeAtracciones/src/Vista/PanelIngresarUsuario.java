package Vista;
import javax. swing .*;
import javax.swing.border.Border;
import Control.*;
import java.awt.*;
import java.util.ArrayList;
import Vista.FieldPanel;

public class PanelIngresarUsuario extends JPanel {
	public static String ocupacion="";
	JPanel p1,p2,p3,p4;
	JLabel l1,l2,l3;
	JButton b1,b2;
	FieldPanel fp;
	Border blackline, raisedetched, loweredetched,
	raisedbevel, loweredbevel, empty;
	Border compound;
	Border redline = BorderFactory.createLineBorder(Color.red);
	static String[] c = {"Nombre: ","Cedula: ","Telefono: ","Usuario: ","Email: ","Contraseña: ",
			"Sueldo: ","Lugar: "};
	public PanelIngresarUsuario() {
		this.setLayout(new GridBagLayout());
		fp = new FieldPanel("Dictamen",c,"Ingrese aqui",null);
		p1= new JPanel();
		p2= new JPanel();
		p3= new JPanel();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0; 
		constraints.gridy = 0;
		constraints.gridwidth = 6; 
		constraints.gridheight = 1; 
		constraints.weighty = 1.0;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.CENTER;
		constraints.anchor = GridBagConstraints.CENTER;
		p1.setLayout(new BorderLayout(10,10));
		l1= new JLabel("INGRESAR USUARIO NUEVO",SwingConstants.CENTER);
		l2= new JLabel("Complete todos los datos a continuacion para añadir un nuevo usuario",SwingConstants.CENTER);
		p1.add(l1,BorderLayout.NORTH);
		p1.add(l2,BorderLayout.CENTER);
		this.add(p1,constraints);
		constraints.gridx = 1; 
		constraints.gridy = 1; 
		constraints.gridwidth = 4; 
		constraints.gridheight = 4; 
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		p2.add(fp);
		this.add(p2,constraints);
		l3= new JLabel("Ocupacion");
		JMenuBar sssx =new JMenuBar();
		JMenu sss = new JMenu("Escoga una Ocupacion");
		sssx.add(sss);
		JMenuItem m12 = new JMenuItem("Admin");
		JMenuItem m22 = new JMenuItem("Vendedor");
		JMenuItem m32 = new JMenuItem("Cliente");
		JMenuItem m42 = new JMenuItem("Operario");

		m12.addActionListener(new ControlMenuOcupacion());
		m22.addActionListener(new ControlMenuOcupacion());
		m32.addActionListener(new ControlMenuOcupacion());
		m42.addActionListener(new ControlMenuOcupacion());
		
		sss.add(m12);
		sss.add(m22);
		sss.add(m32);
		sss.add(m42);
		p4= new JPanel();
		p4.add(l3,BorderLayout.SOUTH);
		p4.add(sssx,BorderLayout.PAGE_END);
		constraints.gridx = 1; 
		constraints.gridy = 5; 
		constraints.gridwidth = 2; 
		constraints.gridheight = 2; 
		this.add(p4,constraints);
		b1=new JButton("Aceptar");
		b1.addActionListener(new ControlPanIngresarUsuario());
		b2=new JButton("Cancelar");
		b2.addActionListener(new ControlPanIngresarUsuario());
		p3.add(b1);
		p3.add(b2);
		constraints.gridx = 1; 
		constraints.gridy =8; 
		constraints.gridwidth = 2; 
		constraints.gridheight = 1; 
		this.add(p3,constraints);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		empty = BorderFactory.createEmptyBorder(5,5,5,5);
		compound = BorderFactory.createCompoundBorder(
                raisedbevel, loweredbevel);
		compound = BorderFactory.createCompoundBorder(
                redline, compound);
		compound = BorderFactory.createCompoundBorder(
                empty, compound);
		p1.setBorder(compound);
		p2.setBorder(compound);
		l2.setBorder(compound);
		l1.setBorder(compound);
		p4.setBorder(compound);
		p3.setBorder(compound);

	}
	
	public ArrayList<String> getFPTexts(){
		return fp.getAllStrings();
	}
}
