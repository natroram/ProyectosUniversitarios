/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Correo;


/**
 *
 * @author User
 */

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;


public class Mail {
    final String username = "proyectopoo2020";
    final String password = "wgxurwoxufiveeox";
    final String fromEmail = "proyectopoo2020@gmail.com";
    String toEmail ;
    public Mail(String correodestino){
        this.toEmail=correodestino;
    }
    /**
     * Metodo encargado de armar la estructura de un email y que permite enviarlo.
     * @param asunto parametro que contendra el asunto o motivo del email
     * @param mensaje parametro que contiene el cuerpo del email
     */
    
    
    public void sendMail(String asunto, String mensaje){
	Properties properties = new Properties();
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	
	Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        @Override
	protected PasswordAuthentication getPasswordAuthentication() {
	return new PasswordAuthentication(username,password);
	}
	});
	MimeMessage msg = new MimeMessage(session);
	try {
	    msg.setFrom(new InternetAddress(fromEmail));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            msg.setSubject(asunto); //Asunto del Correo
            Multipart emailContent = new MimeMultipart();
            //Text body part
            MimeBodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText(mensaje); //Contenido del correo
            emailContent.addBodyPart(textBodyPart);
            msg.setContent(emailContent);
            Transport.send(msg);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            // TODO Auto-generated catch block
	}
    
   
    
    
    //la morision es mi pasion
}

    
    
    
    
    
    
    