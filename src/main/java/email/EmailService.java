package email;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class EmailService {

    private void sendEmail() {

        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        //Establishing a session with required user details
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("baloghtimea20@gmail.com", "");
            }
        });


    }

}
