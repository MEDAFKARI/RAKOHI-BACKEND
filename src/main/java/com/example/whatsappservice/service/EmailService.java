package com.example.whatsappservice.service;

import com.example.whatsappservice.models.EmailMessage;
import jakarta.mail.*;
import jakarta.mail.internet.*;
import java.util.Properties;

public class EmailService {

    private String host = "smtp.example.com"; // Replace with your SMTP server
    private String from = "your-email@example.com"; // Replace with your email address
    private String username = "your-username"; // SMTP username
    private String password = "your-password"; // SMTP password

    public void sendEmail(EmailMessage emailMessage) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailMessage.getAdresseemail()));
            message.setSubject(emailMessage.getSujet());
            message.setText(emailMessage.getContenu());

            Transport.send(message);
            System.out.println("Email sent successfully.");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
