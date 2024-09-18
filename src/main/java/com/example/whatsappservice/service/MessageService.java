package com.example.whatsappservice.service;

import com.example.whatsappservice.Repository.MessageRepository;
import com.example.whatsappservice.enums.StatusMessage;
import com.example.whatsappservice.enums.TypeMessage;
import com.example.whatsappservice.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // Save a message to the journal
    public void saveMessageToJournal(String contenu, TypeMessage type, StatusMessage status) {
        Message message = new Message(contenu, LocalDateTime.now(), status, type) {
            @Override
            public void envoyer() {
                // Implement the message sending logic if needed
            }
        };
        messageRepository.save(message); // Save message in the database
    }
}
