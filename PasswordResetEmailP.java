package Presentation;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class PasswordResetEmailP {
    Session newSession = null;
    MimeMessage mimeMessage;
    private static int PIN = 0;
    //    private static int number = 0;
    public static int AccountResetEmail(String emailId) throws MessagingException, AddressException, IOException {
        PasswordResetEmailP mail = new PasswordResetEmailP();
        mail.setupServerProperties();
        mail.draftEmail(emailId);
        mail.sendEmail();
        return PIN;
    }
    private void sendEmail() throws MessagingException{
        String fromUser = "ahmedmalikcomputer@gmail.com";
        String fromUseraPassword = "fxly lqwx eiaj mocf";
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost , fromUser , fromUseraPassword);
        transport.sendMessage(mimeMessage , mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email Successfully sent!!!");
    }
    private MimeMessage draftEmail(String emailId) throws AddressException , MessagingException , IOException {
        String[] emailRecipients = {emailId};
        String emailSubject = "Password Reset Email";
        Random random = new Random();
        PIN = random.nextInt(900000) + 100000;
        String emailBody = "Welcome Back to  Bank Management System.\nHere is the 6 digit PIN to reset Your Password : " + PIN;
        for(int i = 0 ; i < emailRecipients.length ; i++){
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailRecipients[i]));
        }
        mimeMessage.setSubject(emailSubject);
        mimeMessage.setDescription(emailBody);
        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody , "text/html");
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(bodyPart);
        mimeMessage.setContent(multipart);
        return mimeMessage;
    }
    private void setupServerProperties(){
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port" , "587");
        properties.put("mail.smtp.auth" , "true");
        properties.put("mail.smtp.starttls.enable" , "true");
        newSession = Session.getDefaultInstance(properties , null);
        mimeMessage = new MimeMessage(newSession);
    }
}
