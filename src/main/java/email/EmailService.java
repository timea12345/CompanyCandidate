package email;


import com.sun.net.ssl.internal.ssl.Provider;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.security.Security;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;

public class EmailService {

     private void sendEmail() {

         Security.addProvider(new Provider());
         Properties prop = new Properties();
         prop.setProperty("mail.transport.protocol", "smtp");
         prop.setProperty("mail.host", "smtp.gmail.com");
         prop.put("mail.smtp.auth", "true");
         prop.put("mail.smtp.port", "465");
         prop.put("mail.smtp.socketFactory.port", "465");
         prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
         prop.put("mail.smtp.socketFactory.fallback", "false");
         prop.setProperty("mail.smtp.quitwait", "false");

        //Establishing a session with required user details
//         Properties props = new Properties();
         Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("baloghtimea20@gmail.com", "timea123!");
            }
        });



        try {
            MimeMessage message = new MimeMessage(session);
            InternetAddress[] receiverAddresses = InternetAddress.parse("baloghtimea20@gmail.com, balogh_timea1993@yahoo.com");

            message.setRecipients(Message.RecipientType.TO, receiverAddresses);
            message.setSubject("Test mail");
            message.setSentDate(Date.from(Instant.now()));
            message.setText("salut");


            Multipart multipart = new MimeMultipart();
            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent("hello", "text/html");
            multipart.addBodyPart(mimeBodyPart);
            message.setContent(multipart);


            MimeBodyPart attachmentBodyPart = new MimeBodyPart();
            attachmentBodyPart.attachFile(new File("accepted-candidate.json"));
            multipart.addBodyPart(attachmentBodyPart);

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Mail could not be sent");
        }
    }

    public static void main(String[] args) {
       EmailService mail = new EmailService();
       mail.sendEmail();
    }

}
