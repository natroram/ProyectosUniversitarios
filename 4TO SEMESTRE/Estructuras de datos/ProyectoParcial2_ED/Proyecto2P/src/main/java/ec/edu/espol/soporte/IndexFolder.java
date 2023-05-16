/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.soporte;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Claudio Olvera
 */
public class IndexFolder{
    private Long size;
    private int nFiles;
    
    private int nImg;
    private int nVideo;
    private int nAudio;
    private int nWord;
    private int nPdfs;
    private int nExcel;
    private int nDiapositivas;
    private int nOthers;

    public IndexFolder(Long size) {
        this.size = size;
        nFiles=0;
        nImg =0;
        nVideo=0;
        nAudio=0;
        nOthers=0;
        nWord=0;
        nPdfs=0;
        nExcel=0;
        nDiapositivas=0;
    }

    public IndexFolder(File file) {
        this.size = file.length();
        nFiles=0;
        nImg =0;
        nVideo=0;
        nAudio=0;
        nOthers=0;
        nWord=0;
        nPdfs=0;
        nExcel=0;
        nDiapositivas=0;
    } 
    
    public void contarArchivo(File file){
        this.size+=file.length();
        if(file != null && file.isFile()){
            nFiles++;
            String fileName = file.getName();
            String fe = "";
            if (fileName.contains(".")){
                 fe = fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase();
            }
            switch(fe){
                //imagenes
                case "ico":
                    this.nImg++;
                    break;
                case "jpg":
                    this.nImg++;
                    break;
                case "jpeg":
                    this.nImg++;
                    break;
                case "png":
                    this.nImg++;
                    break;
                case "gif":
                    this.nImg++;
                    break;
                //audio
                case "mp3":
                    this.nAudio++;
                    break;
                case "occ":
                    this.nAudio++;
                    break;
                case "acc":
                    this.nAudio++;
                    break;
                
                //Video
                case "mp4":
                    this.nVideo++;
                    break;
                case "avi":
                    this.nVideo++;
                    break;
                case "mkv":
                    this.nVideo++;
                    break;
                case "dvd":
                    this.nVideo++;
                    break;
                case "wmv":
                    this.nVideo++;
                    break;
                case "mov":
                    this.nVideo++;
                    break;
                case "mpg1":
                    this.nVideo++;
                    break;
                case "mpg2":
                    this.nVideo++;
                    break;
                case "flv":
                    this.nVideo++;
                    break;
                case "ra":
                    this.nVideo++;
                    break;
                case "rv":
                    this.nVideo++;
                    break;
                case "rvm":
                    this.nVideo++;
                    break;
                case "rm":
                    this.nVideo++;
                    break;
                case "3gp":
                    this.nVideo++;
                    break;
                
                //Word;
                case "doc":
                    this.nVideo++;
                    break;
                case "docx":
                    this.nVideo++;
                    break;
                
                //nPdfs;
                case "pdf":
                    this.nVideo++;
                    break;
                case "xcf":
                    this.nVideo++;
                    break;
                
                //nExcel;
                case "xls":
                    this.nVideo++;
                    break;
                case "xlsx":
                    this.nVideo++;
                    break;
                
                //nDiapositivas;
                case "ppt":
                    this.nVideo++;
                    break;
                case "pptx":
                    this.nVideo++;
                    break;
                case "pptm":
                    this.nVideo++;
                    break;
                
                default:
                    this.nOthers++;
                    break;
            }
    }
    }
    
    public void sumarDirectorios(IndexFolder index){
        this.nAudio+=index.nAudio;
        this.nDiapositivas+=index.nDiapositivas;
        this.nExcel+=index.nExcel;
        this.nImg+=index.nImg;
        this.nOthers+=index.nOthers;
        this.nPdfs+=index.nPdfs;
        this.nVideo+=index.nVideo;
        this.nWord+=index.nWord;
        
        this.nFiles+=index.nFiles;
        this.size+=index.size;
    }
    
    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public int getnFiles() {
        return nFiles;
    }

    public int getnImg() {
        return nImg;
    }

    public int getnVideo() {
        return nVideo;
    }

    public int getnAudio() {
        return nAudio;
    }

    public int getnWord() {
        return nWord;
    }

    public int getnPdfs() {
        return nPdfs;
    }

    public int getnExcel() {
        return nExcel;
    }

    public int getnDiapositivas() {
        return nDiapositivas;
    }

    public int getnOthers() {
        return nOthers;
    }

    @Override
    public String toString() {
        return "IndexFolder{" + "size=" + size + ", nFiles=" + nFiles + ", nImg=" + nImg + ", nVideo=" + nVideo + ", nAudio=" + nAudio + ", nWord=" + nWord + ", nPdfs=" + nPdfs + ", nExcel=" + nExcel + ", nDiapositivas=" + nDiapositivas + ", nOthers=" + nOthers + '}';
    }
}
