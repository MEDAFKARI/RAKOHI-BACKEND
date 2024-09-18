package com.example.whatsappservice.models;

import com.example.whatsappservice.enums.StatusMessage;
import com.example.whatsappservice.enums.TypeMessage;
import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "message_type")
public abstract class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contenu")
    private String contenu;

    @Column(name = "horodatage")
    private LocalDateTime horodatage;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusMessage status;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TypeMessage type;

    // Default constructor for JPA
    public Message() {
    }

    // Parameterized constructor
    public Message(String contenu, LocalDateTime horodatage, StatusMessage status, TypeMessage type) {
        this.contenu = contenu;
        this.horodatage = horodatage;
        this.status = status;
        this.type = type;
    }

    // Getter and Setter methods
    public Long getId() {
        return id;
    }

    public String getContenu() {
        return contenu;
    }

    public LocalDateTime getHorodatage() {
        return horodatage;
    }

    public StatusMessage getStatus() {
        return status;
    }

    public TypeMessage getType() {
        return type;
    }

    // Abstract method to be implemented by subclasses
    public abstract void envoyer();
}
