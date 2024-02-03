package Presentation;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class accountCreationEmailP {
    Session newSession = null;
    MimeMessage mimeMessage;
    private static int number = 0;
    public static void EmailSend(String name , String emailId , String password , int PIN) throws MessagingException , AddressException , IOException{
        Scanner scanner = new Scanner(System.in);
        accountCreationEmailP mail = new accountCreationEmailP();
        mail.setupServerProperties();
        mail.draftEmail(name , emailId , password , PIN);
        mail.sendEmail();
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
    private MimeMessage draftEmail(String name , String emailId , String password , int PIN) throws AddressException , MessagingException , IOException {
        String[] emailRecipients = {emailId};
        System.out.println(emailId);
        String emailSubject = "Account Creation Email";
        String emailBody = "Hey " + name + " Welcome to Bank Management System. Your account has been created.Your PIN : " + PIN + " and password : " + password;
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
