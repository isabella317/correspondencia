package Modelo.Entidades;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/*CLASE ENCARGADA DE ENVIAR MENSAJES INFORMATIVOS A CORREOS DE USUARIOS.*/
public class NotificarCorreo {

    final String correoEnvia = "olvidoclaves@gmail.com";
    final String claveCorreo = "olvidoclaves123";
    char[] clavei = claveCorreo.toCharArray();

    public void mandarCorreo(String correo, String clave) throws MessagingException {

        // La configuración para enviar correo  
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.user", correoEnvia);
        properties.put("mail.smtp.auth", "true");

        // Obtener la sesion  
        Session session = Session.getInstance(properties);
        session.setDebug(true);
       

            // Crear el cuerpo del mensaje  
            MimeMessage mimeMessage = new MimeMessage(session);
            // Agregar quien envía el correo  
            mimeMessage.setFrom(new InternetAddress(correoEnvia));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
            // Agregar el asunto al correo  
            mimeMessage.setSubject("Recuperación contraseña");
            // Creo la parte del mensaje  
            mimeMessage.setText("Cordial saludo \n\nEstimado usuario\n\n\nDebido a la solicitud de contraseña que usted ha realizado se le ha asignado el siguiente codigo : " + clave + " que podrá utilizar para iniciar sesión en la aplicación.\n\n");

            // Enviar el mensaje  
            Transport t = session.getTransport("smtp");
            t.connect(correoEnvia, claveCorreo);

            t.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
            System.out.println("Correo enviado");

        
    }

}
