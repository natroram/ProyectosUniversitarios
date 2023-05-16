package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class Controlador {
	Pane root;
	
	public Controlador() {
		this.root =  new Pane();
		createView();
	}
	
	public void createView(){
		Button btn_rojo = new Button("ROJO");
		Button btn_azul = new Button("AZUL");
		Button btn_verde = new Button("VERDE");
		
		HBox cont = new HBox();
		cont.setAlignment(Pos.CENTER);
		cont.setSpacing(30);
		cont.getChildren().addAll(btn_rojo, btn_azul, btn_verde);
		root.setPadding(new Insets(20,20,20,20));
		root.getChildren().addAll(cont);
		
		btn_rojo.setOnAction(e->{
			root.styleProperty().set("-fx-background-color: #FF0000");
		});
		
		btn_verde.setOnAction(e->{
			root.styleProperty().set("-fx-background-color: #00FF00");
		});
		
		btn_azul.setOnAction(e->{
			root.styleProperty().set("-fx-background-color: #0000FF");
		});
		
	}
	
	public Pane getRoot(){
		return this.root;
	}
	

}
