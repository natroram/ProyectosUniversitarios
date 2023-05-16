/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soldado;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    String rutaCuerpo = "src/Imagenes/warriorParado.png";
    String rutaCuerpoMuerto = "src/Imagenes/warriorMuerto.png";
    ImageView cuerpo;
    int id;

    
    public Soldado(double posicionX, double posicionY, int tamanox, int tamanoy) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        try{
            cuerpo = new ImageView(new Image(new FileInputStream(rutaCuerpo), posicionX, posicionY, false, false));
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
        System.out.println("Soldado " + id + " ha sido asesinado.");
        try{
            Image nruta = new Image(new FileInputStream(rutaCuerpoMuerto));
            cuerpo.setImage(nruta);
        } catch(FileNotFoundException e) {
            System.err.println("Error al cargar la imagen del cuerpo muerto.");
        }
        
    }

    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public boolean equals(Soldado sold){
        return this.id == sold.id;
    }

    @Override
    public String toString() {
        return "Soldado{" + "estado=" + estado + ", id=" + id + '}';
    }
    
    public int getID() {
        return this.id;
    }
    
    public void preparado() {
        try {
            Image nruta = new Image(new FileInputStream("src/Imagenes/preparado.png"));
            cuerpo.setImage(nruta);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void ataque_der() {
        try {
            Image nruta = new Image(new FileInputStream("src/Imagenes/warriorAtacando.png"));
            cuerpo.setImage(nruta);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void ataque_izq() {
        try {
            Image nruta = new Image(new FileInputStream("src/Imagenes/warriorAtacandoVolteado.png"));
            cuerpo.setImage(nruta);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public void normal() {
        try {
            Image nruta = new Image(new FileInputStream(rutaCuerpo));
            cuerpo.setImage(nruta);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }


}
