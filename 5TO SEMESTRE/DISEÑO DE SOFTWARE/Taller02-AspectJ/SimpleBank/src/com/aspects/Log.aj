package com.aspects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;

public aspect Log {
    File file = new File("log.txt");
    Calendar cal = Calendar.getInstance();
    //Aspecto: Deben hacer los puntos de cortes (pointcut) para crear un log con los tipos de transacciones realizadas.
    pointcut success() : call(* create*(..) );
    after() : success() {
    	System.out.println("**** User created ****");
    }
    
    pointcut deposit() : call (* moneyMakeTransaction());
    after(): deposit() {
    	System.out.println("****** transaccion completada ******");
    	
    	try {
	    	if(!file.exists()) {
	    		file.createNewFile();
	    	}
	    	
	    	FileWriter fwriter = new FileWriter(file,true);
	    	BufferedWriter b_writer = new BufferedWriter(fwriter);
	    	b_writer.write("Deposito realizado en: " + cal.getTime() + "\n");
	    	b_writer.close();
    	} catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    pointcut retiro() : call (* moneyWithdrawal());
    after() : retiro() {
    	System.out.println("****** transaccion completada ******");
    	
    	try {
    	if(!file.exists()) {
    		file.createNewFile();
    	}
    	
    	FileWriter fwriter = new FileWriter(file,true); //contenido se agrega al archivo no se sobreescribe
    	BufferedWriter b_writer = new BufferedWriter(fwriter);
    	b_writer.write("Retiro realizado en: " + cal.getTime() + "\n");
    	b_writer.close();
    	} catch(Exception a) {
    		System.out.println(a.getMessage());
    	}
    }
}
