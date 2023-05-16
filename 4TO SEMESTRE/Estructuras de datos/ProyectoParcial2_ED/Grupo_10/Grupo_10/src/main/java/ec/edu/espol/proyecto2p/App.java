package ec.edu.espol.proyecto2p;

import ec.edu.espol.clases.Arbol;
import ec.edu.espol.soporte.FileManager;
import ec.edu.espol.soporte.Graphics;
import ec.edu.espol.soporte.IndexFolder;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage stageMain;

    @Override
    public void start(Stage stage) throws IOException {
        //scene = new Scene(loadFXML("primary"), 640, 480);
        stageMain = new Stage();
        stage = stageMain;
        VistaApp vista = new VistaApp();
       
        stage.setTitle(vista.titulo);
        //scene = new Scene(vista.getRoot());
        //String url="C:\\Users\\ReynaldoPC\\Downloads";
        //scene = new Scene(new Graphics().generarRectangulos(new FileManager().getDirTree(new File(url))));
        Scene scene2 = new Scene(vista.getRoot());
        stage.setScene(scene2);
        stage.show();
    }
    
    public static void cambiarTitulo(String ttl){
        stageMain.setTitle(ttl);
    }
    public Stage getStageMain() {
        return stageMain;
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        //test(); //solo es para probar codigo
        launch();
    }
    
    
    private static void test(){
        FileManager fm = new FileManager();
        Arbol<IndexFolder,String> a = fm.getDirTree(new File("C:\\Users\\ReynaldoPC\\Downloads"));
        System.out.println(a.toStringClaveValor());
        System.out.println(a.getRoot().getValor());
    }
}