/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.net.URISyntaxException;
import java.security.CodeSource;

/**
 *
 * @author User
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            CodeSource codeSource = Launcher.class.getProtectionDomain().getCodeSource();
            File jarFile;
            jarFile = new File(codeSource.getLocation().toURI().getPath());
            String jarDir = jarFile.getParentFile().getPath();
            //System.out.println(jarDir);
            System.setProperty("jarDir",jarDir);
        } catch (URISyntaxException ex) {
            ex.printStackTrace();
        }
        
        //System.out.println(CONSTANTES.class.getProtectionDomain().getCodeSource().getLocation().toURI());
        //System.out.println(System.getProperty("java.home"));
        //System.out.println(System.getProperty("java.library.path"));
        //System.out.println(System.getProperty("java.ext.dirs"));
        //System.out.println(System.getProperty("java.class.path"));
        //System.out.println(System.getProperty("user.dir"));
        App.main(args);
    }
    
}
