/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soldado;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author david,edits: Gabriel
 */
public class Soldado {
    //El estado del soldado se cambió a boolean: True si está vivo, False
    //si está muerto.
    boolean estado = true;
    double posicionX;
    double posicionY;
    //Las rutas de los archivos ahora son atributos, para referenciarlas siempre
    //que las necesitemos, en vez de escribirlas a cada rato.
    String rutaCuerpo = "";
    String rutaCuerpoMuerto = "";
    ImageView cuerpo;
    int id;

    
    public Soldado(double posicionX, double posicionY, int tamanox, int tamanoy) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        try{
            cuerpo = new ImageView(new Image(rutaCuerpo, posicionX, posicionY, false, false));
            cuerpo.setFitHeight(tamanoy);
            cuerpo.setFitWidth(tamanox);
        } catch(Exception e) {
            System.err.println("No se pudo cargar la imagen del cuerpo, error en la ruta.");
        }
        
    }
    
    public Soldado(int enumeracion){
        this.id = enumeracion;
    }

    public ImageView getCuerpo() {
        return cuerpo;
    }

    public boolean isAlive() {
        return estado;
    }

    public double getPosicionX() {
        return posicionX;
    }

    public double getPosicionY() {
        return posicionY;
    }

   
    public void matar(Soldado soldado) {
        soldado.estado = false;
        try{
            Image nruta = new Image(rutaCuerpoMuerto);
            cuerpo.setImage(nruta);
        } catch(Exception e) {
            System.err.println("Error al cargar la imagen del cuerpo muerto.");
        }
        
    }

    private boolean getEstado() {
        return this.estado;
    }
    
    public boolean equals(Soldado sold){
        return this.id == sold.id;
    }

    @Override
    public String toString() {
        return "Soldado{" + "estado=" + estado + ", id=" + id + '}';
    }
    
    

}
