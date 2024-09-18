package com.example.whatsappservice.models;

import com.example.whatsappservice.enums.StatusMessage;
import com.example.whatsappservice.enums.TypeMessage;
import com.example.whatsappservice.service.EmailService;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("EMAIL")
public class EmailMessage extends Message {

    @Column(name = "adresse_email", nullable = false)
    private String adresseemail;

    @Column(name = "sujet", nullable = false)
    private String sujet;

    // Default constructor for JPA
    public EmailMessage() {
        super();
    }

    // Constructor with parameters
    public EmailMessage(String contenu, LocalDateTime horodatage, StatusMessage status, TypeMessage type, String adresseemail, String sujet) {
        super(contenu, horodatage, status, type);
        this.adresseemail = adresseemail;
        this.sujet = sujet;
    }

    @Override
    public void envoyer() {
        EmailService emailService = new EmailService();
        emailService.sendEmail(this);
    }

    // Getter and Setter methods
    public String getAdresseemail() {
        return adresseemail;
    }

    public void setAdresseemail(String adresseemail) {
        this.adresseemail = adresseemail;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }
}
