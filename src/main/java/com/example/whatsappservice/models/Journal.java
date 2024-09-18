package com.example.whatsappservice.models;

import com.example.whatsappservice.enums.NiveauJournal;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


public class Journal {
    private NiveauJournal niveauJournal;
    private List<EntreeJournal> entreesJournal;

    // Constructor
    public Journal(NiveauJournal niveauJournal) {
        this.niveauJournal = niveauJournal;
    }

    // Log a message with a specific level
    public void journaliserMessage(String message, NiveauJournal niveau) {
        if (niveau.compareTo(this.niveauJournal) >= 0) {
            EntreeJournal entree = new EntreeJournal(message, niveau);
            entreesJournal.add(entree);
            System.out.println("Journal: " + message + " [Niveau: " + niveau + "]");
        }
    }

    // Retrieve all log entries by a specific level
    public List<EntreeJournal> filtrerJournauxParNiveau(NiveauJournal niveau) {
        List<EntreeJournal> result = new ArrayList<>();
        for (EntreeJournal entree : entreesJournal) {
            if (entree.getNiveau().equals(niveau)) {
                result.add(entree);
            }
        }
        return result;
    }

    // Clear all log entries
    public void viderJournaux() {
        entreesJournal.clear();
        System.out.println("Tous les journaux ont été vidés.");
    }
}
