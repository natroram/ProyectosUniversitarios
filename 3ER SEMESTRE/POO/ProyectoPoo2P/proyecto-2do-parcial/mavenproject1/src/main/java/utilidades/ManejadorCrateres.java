package utilidades;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;

public class ManejadorCrateres {
    private Crateres cr;
    private Circle circulo;
    private BorderPane root;

    /**
    * Constructor clase Crateres
    * @param creater Crateres
    * @param circulo Circle
    * @param root BorderPane
    */
    
    public ManejadorCrateres(Crateres creater, Circle circulo, BorderPane root) {
        this.cr = creater;
        this.circulo = circulo;
        this.root = root;
        event();
    }

    public Crateres getCr() {
        return cr;
    }

    /**
     * Este metodo maneja el evento MouseClicked que se genera cada vez que se aplasta 
     * sobre uno de los crateres, crea una nuevo contenedor para mostrar la informacion
     */
    private void  event(){
        circulo.setOnMouseClicked((MouseEvent e) ->{
            VBox info = new VBox();
            TextArea texto = new TextArea();
            texto.setMinSize(200, 400);
            texto.setMaxSize(200, 500);
            texto.appendText("Crater ID: "+String.valueOf(cr.getIdCrater())+ "\n");
            texto.appendText("Nombre: " + cr.getNombre()+ "\n");
            texto.appendText("Radio: "+ String.valueOf(cr.getRadio())+ "\n");
            texto.appendText("Latitud: "+ String.valueOf(cr.getLatitud())+ "\n");
            texto.appendText("Longitud: "+ String.valueOf(cr.getLongitud())+ "\n");
            if(cr.isVisitado()){
                texto.appendText("Este crater ya ha sido explorado:"+ "\n");
                texto.appendText("MINERALES: "+ "\n");
                String[] mine = cr.getMinerales().split("/");
                for(String m: mine){
                    texto.appendText(m + "\n");
                }
            }else{
                texto.appendText("Este crater no ha sido explorado");
            }
            info.getChildren().addAll(texto);
            info.setAlignment(Pos.BOTTOM_RIGHT);
            info.setPadding(new Insets(30,30,30,30));
            root.setBottom(info);
            info.setMouseTransparent(true);
        });
    }
}
