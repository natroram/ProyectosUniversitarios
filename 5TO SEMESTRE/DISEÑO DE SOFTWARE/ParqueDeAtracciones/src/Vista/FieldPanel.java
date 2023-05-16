package Vista;

import javax. swing .*;
import javax.swing.border.Border;

import java.awt.*;
import java.util.*;
public class FieldPanel extends JPanel {
	String crite,valo;
	String[] cri,vals;
	Boolean[] boo;
	Border blackline, raisedetched, loweredetched,
    raisedbevel, loweredbevel, empty;
	Border compound;
	Border redline = BorderFactory.createLineBorder(Color.red);
	ArrayList<JTextField> jtexts = new ArrayList<JTextField>();
	public FieldPanel(String criterio,String[] c,String val,String[] v,Boolean[] b) {
		crite=criterio;
		valo=val;
		cri=c;
		vals=v;
		boo=b;
		this.setLayout(new GridLayout(cri.length+1,2,10,10));
		JLabel l = new JLabel(crite);
		JLabel x= new JLabel(valo);
		add(l);
		add(x);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		empty = BorderFactory.createEmptyBorder(5,5,5,5);
		compound = BorderFactory.createCompoundBorder(
                raisedbevel, loweredbevel);
		compound = BorderFactory.createCompoundBorder(
                redline, compound);
		compound = BorderFactory.createCompoundBorder(
                empty, compound);
		l.setBorder(compound);
		x.setBorder(compound);
		for (int i=0;i<(cri.length);i++) {
			JLabel p= new JLabel(cri[i]);
			add(p);
			if(vals==null) {
				JTextField e= new JTextField();
				add(e);
				if(boo==null) {
					e.setEnabled(true);
			}
				else if(boo[i]==true) {
					e.setEnabled(true);
				}else {
					e.setEnabled(false);
				}
				jtexts.add(e);
			}
			else {
				JTextField e= new JTextField(vals[i]);
				add(e);
				if(boo==null) {
					e.setEnabled(true);
				}
				else if(boo[i]==true) {
					e.setEnabled(true);
				}else {
					e.setEnabled(false);
				}
				jtexts.add(e);
			}
			
		}
		
	}
	
	
	public FieldPanel(String criterio,String[] c,String val,String[] v) {
		crite=criterio;
		valo=val;
		cri=c;
		vals=v;
		this.setLayout(new GridLayout(cri.length+1,2,10,10));
		JLabel l = new JLabel(crite);
		JLabel x= new JLabel(valo);
		add(l);
		add(x);
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		empty = BorderFactory.createEmptyBorder(5,5,5,5);
		compound = BorderFactory.createCompoundBorder(
                raisedbevel, loweredbevel);
		compound = BorderFactory.createCompoundBorder(
                redline, compound);
		compound = BorderFactory.createCompoundBorder(
                empty, compound);
		l.setBorder(compound);
		x.setBorder(compound);
		for (int i=0;i<(cri.length);i++) {
			JLabel p= new JLabel(cri[i]);
			add(p);
			if(vals==null) {
				JTextField e= new JTextField();
				jtexts.add(e);
				add(e);
			}
			else {
				JTextField e= new JTextField(vals[i]);
				jtexts.add(e);
				add(e);
				
			}
			
			
		}	
	}
	
	public ArrayList<String> getAllStrings() {
	    Component[] comps = this.getComponents();
	    ArrayList<String> compList = new ArrayList<String>();
	    for (Component comp : comps) {
	        if (comp instanceof JTextField)
		        compList.add(((JTextField) comp).getText());
	    }
	    return compList;
	}
	
	
	public String getCriterio() {
		return crite;
		
	}
}