package com.example.whatsappservice.models;

import com.example.whatsappservice.enums.NiveauJournal;

import java.time.LocalDateTime;

public class EntreeJournal {

    private String message;
    private NiveauJournal niveau;
    private LocalDateTime horodatage;

    // Constructor
    public EntreeJournal(String message, NiveauJournal niveau) {
        this.message = message;
        this.niveau = niveau;
        this.horodatage = LocalDateTime.now();
    }

    // Getters
    public String getMessage() {
        return message;
    }

    public NiveauJournal getNiveau() {
        return niveau;
    }

    public LocalDateTime getHorodatage() {
        return horodatage;
    }
}

