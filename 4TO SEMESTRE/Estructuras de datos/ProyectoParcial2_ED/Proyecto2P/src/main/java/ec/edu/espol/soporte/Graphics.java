/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.soporte;

import ec.edu.espol.clases.Arbol;
import ec.edu.espol.clases.Nodo;
import ec.edu.espol.proyecto2p.VistaApp;
import java.util.LinkedList;
import java.util.Map;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
//import ec.edu.espol.clases.LinkedList;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


/**
 *
 * @author Claudio Olvera
 */
public class Graphics {
    int HEIGHT = 600;
    int WIDTH = 1280;
    boolean isHbox = true;
    int deepLvl = 3;
    Pos pos = Pos.TOP_LEFT;

    //colores
    Color cnImg=Color.rgb(253, 203, 110);
    Color cnVideo=Color.rgb(162, 155, 254);
    Color cnAudio=Color.rgb(130, 88, 159);
    Color cnWord=Color.rgb(116, 185, 255);
    Color cnPdfs=Color.rgb(214, 48, 49);
    Color cnExcel=Color.rgb(85, 239, 196);
    Color cnDiapositivas=Color.rgb(249, 127, 81);
    Color cnOthers = Color.rgb(178, 190, 195);

    public int getHEIGHT() {
        return HEIGHT;
    }

    public void setHEIGHT(int HEIGHT) {
        this.HEIGHT = HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public void setWIDTH(int WIDTH) {
        this.WIDTH = WIDTH;
    }
    
    
    
    private Pane generarRectangulos(Arbol<IndexFolder,String> tree, double height, double width, boolean isHbox){
        long size = tree.getValor().getSize();
        
        if(isHbox){
            HBox pane = new HBox();
            pane.setSpacing(2);
            pane.setPadding(new Insets(1,1,1,1));
            pane.setBackground(this.getBacground(tree.getValor()));
            pane.setAlignment(pos);
            pane.setMinHeight(height);
            pane.setMinWidth(width);
            for(Arbol<IndexFolder,String> t:tree.getRoot().getHijos()){
                double porc =(t.getValor().getSize()*100)/size;
                if(porc>1){
                    double nw =width*porc/100;
                    double nh =height;
                    VBox b = generarRectangulosV(t, nh,nw);
                    /*
                    Label lb = new Label(t.toString()+": "+size+" Kb");
                    pane.getChildren().add(lb);
                    */
                    b.setBackground(this.getBacground(t.getValor()));
                    b.setAlignment(pos);
                    pane.setAlignment(pos);
                    //pane.getChildren().add(b);
                    
                    StackPane spane = new StackPane();
                    spane.setMinHeight(nh);
                    spane.setMinWidth(nw);
                    spane.setAlignment(Pos.TOP_LEFT);
                    
                    Label lb = new Label(t.getClave()+":\n"+VistaApp.transformacion(t.getValor().getSize()));
                    lb.setAlignment(Pos.TOP_LEFT);
                    spane.getChildren().add(b);
                    spane.getChildren().add(lb);
                    
                    spane.setBorder(new Border(new BorderStroke(this.getColor(tree.getValor()), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                    
                    pane.getChildren().add(spane);
                    
                    
                }
            }
            return pane;
        }else{
            VBox pane = new VBox();
            pane.setSpacing(2);
            pane.setPadding(new Insets(1,1,1,1));
            pane.setBackground(this.getBacground(tree.getValor()));
            pane.setAlignment(pos);
            pane.setMinHeight(height);
            pane.setMinWidth(width);

            for(Arbol<IndexFolder,String> t:tree.getRoot().getHijos()){
                double porc =(t.getValor().getSize()*100)/size;
                if(porc>1){
                    double nw =width;
                    double nh =height*porc/100;
                    HBox b = generarRectangulosH(t, nh,nw);
                    b.setBackground(this.getBacground(t.getValor()));
                    b.setAlignment(pos);
                    pane.setAlignment(pos);
                    //pane.getChildren().add(b);
                    
                    StackPane spane = new StackPane();
                    spane.setMinHeight(nh);
                    spane.setMinWidth(nw);
                    spane.setAlignment(Pos.TOP_LEFT);
                    
                    Label lb = new Label(t.getClave());
                    lb.setAlignment(Pos.TOP_LEFT);
                    spane.getChildren().add(b);
                    spane.getChildren().add(lb);
                    pane.getChildren().add(spane);
                }
            }

            return pane;
        }
        
    }
    
    private HBox generarRectangulosH(Arbol<IndexFolder,String> tree, double height, double width){
        long size = tree.getValor().getSize();
        HBox pane = new HBox();
        pane.setBackground(this.getBacground(tree.getValor()));
        pane.setMinHeight(height);
        pane.setMinWidth(width);
        
        for(Arbol<IndexFolder,String> t:tree.getRoot().getHijos()){
            double porc =(t.getValor().getSize()*100)/size;
            if(porc>1){
                double nw =width*porc/100;
                double nh =height;
                VBox vb = (VBox) generarRectangulosV(t,nh,nw);
                vb.setBackground(this.getBacground(t.getValor()));
                vb.setAlignment(Pos.TOP_RIGHT);
                pane.setAlignment(Pos.TOP_RIGHT);
                pane.getChildren().add(vb);
            }
        }
        return pane;
        
    }
    
    private VBox generarRectangulosV(Arbol<IndexFolder,String> tree, double height, double width){
        long size = tree.getValor().getSize();
        VBox pane = new VBox();
        pane.setBackground(this.getBacground(tree.getValor()));
        pane.setMinHeight(height);
        pane.setMinWidth(width);
        
        for(Arbol<IndexFolder,String> t:tree.getRoot().getHijos()){
            double porc =(t.getValor().getSize()*100)/size;
            if(porc>1){
                double nw =width;
                double nh =height*porc/100;
                HBox hb = generarRectangulosH(t, nh,nw);
                //hb.setMinWidth(nw);
                //hb.setMinHeight(nh);
                hb.setBackground(this.getBacground(t.getValor()));
                hb.setAlignment(pos);
                pane.setAlignment(pos);
                pane.getChildren().add(hb);
            }
        }
        return pane;
        
    }
    
    public Pane generarRectangulos(Arbol<IndexFolder,String> tree){
        return generarRectangulos(tree,HEIGHT,WIDTH, isHbox);
    }
    
    private Color getColor(IndexFolder index){
        int r=0;
        int g=0;
        int b=0;
        
        r+= (int)index.getnAudio()*cnAudio.getRed()*255;
        r+= (int)index.getnDiapositivas()*cnDiapositivas.getRed()*255;
        r+= (int)index.getnExcel()*cnExcel.getRed()*255;
        r+= (int)index.getnImg()*cnImg.getRed()*255;
        r+= (int)index.getnOthers()*cnOthers.getRed()*255;
        r+= (int)index.getnPdfs()*cnPdfs.getRed()*255;
        r+= (int)index.getnVideo()*cnVideo.getRed()*255;
        r+= (int)index.getnWord()*cnWord.getRed()*255;
        r=(int)(r/index.getnFiles());
        
        g+= index.getnAudio()*cnAudio.getGreen()*255;
        g+= index.getnDiapositivas()*cnDiapositivas.getGreen()*255;
        g+= index.getnExcel()*cnExcel.getGreen()*255;
        g+= index.getnImg()*cnImg.getGreen()*255;
        g+= index.getnOthers()*cnOthers.getGreen()*255;
        g+= index.getnPdfs()*cnPdfs.getGreen()*255;
        g+= index.getnVideo()*cnVideo.getGreen()*255;
        g+= index.getnWord()*cnWord.getGreen()*255;
        g=g/index.getnFiles();
        
        b+= index.getnAudio()*cnAudio.getBlue()*255;
        b+= index.getnDiapositivas()*cnDiapositivas.getBlue()*255;
        b+= index.getnExcel()*cnExcel.getBlue()*255;
        b+= index.getnImg()*cnImg.getBlue()*255;
        b+= index.getnOthers()*cnOthers.getBlue()*255;
        b+= index.getnPdfs()*cnPdfs.getBlue()*255;
        b+= index.getnVideo()*cnVideo.getBlue()*255;
        b+= index.getnWord()*cnWord.getBlue()*255;
        b=b/index.getnFiles();
        
        return Color.rgb((int)r, (int)g, (int)b);
    }
    
    private Background getBacground(IndexFolder index){
        return new Background(new BackgroundFill(this.getColor(index),null,null));
    }
}

