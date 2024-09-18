package com.example.whatsappservice.models;

import com.example.whatsappservice.enums.StatusMessage;
import com.example.whatsappservice.enums.TypeMessage;
import com.example.whatsappservice.service.WhatsAppService;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("WHATSAPP")
public class WhatsAppMessage extends Message {

    @Column(name = "numero_telephone")
    private String numeroTelephone;

    // Default constructor for JPA
    public WhatsAppMessage() {
        super();
    }

    // Constructor with parameters
    public WhatsAppMessage(String contenu, LocalDateTime horodatage, StatusMessage status, TypeMessage type, String numeroTelephone) {
        super(contenu, horodatage, status, type);
        this.numeroTelephone = numeroTelephone;
    }

    @Override
    public void envoyer() {
        WhatsAppService whatsAppService = new WhatsAppService();
        whatsAppService.sendWhatsAppMessage(this);
    }

    // Getter and Setter methods
    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }
}
