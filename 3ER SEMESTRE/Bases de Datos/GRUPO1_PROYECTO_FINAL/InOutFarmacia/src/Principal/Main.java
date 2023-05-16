
package Principal;

import Farmacia.UI.FrmNotaBodega;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;


public class Main {


    public static void main(String[] args) 
    {
        String claveMysql = "root";
        try
        {
           java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() 
            {
                FrmNotaBodega principal = new FrmNotaBodega(claveMysql);
                Rectangle r = principal.getBounds();
                Toolkit t = Toolkit.getDefaultToolkit();
                Dimension d = t.getScreenSize();
                int posX = (d.width - r.width) / 2;
                int posY = (d.height - r.height) / 2;
                principal.setLocation(posX, posY);
                principal.setVisible(true);
            }
            });
        }
        catch(Exception ex)
        {
            
        }
    }
    
}
