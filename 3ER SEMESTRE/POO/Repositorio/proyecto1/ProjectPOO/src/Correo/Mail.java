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
import java.io.IOException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mail {
    final String username = "proyectopoo2020";
    final String password = "NAPF_EAPB_NRRY1234";
    String fromEmail = "proyectopoo2020@gmail.com";
    String toEmail ;
    public Mail(String asunto,String mensaje,String correodestino){
        this.toEmail=correodestino;
	Properties properties = new Properties();
	properties.put("mail.smtp.auth", "true");
	properties.put("mail.smtp.starttls.enable", "true");
	properties.put("mail.smtp.host", "smtp.gmail.com");
	properties.put("mail.smtp.port","587");
	
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
    
    public static void main(String[] args) {
        Mail c= new Mail("ASUNTO","MENSAJE: Hola Nicole","napilco@espol.edu.ec");
        System.out.println("Listo");
    }
}

    
    
    
    
    
    
    