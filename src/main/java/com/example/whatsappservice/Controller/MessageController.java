package com.example.whatsappservice.Controller;

import com.example.whatsappservice.enums.StatusMessage;
import com.example.whatsappservice.enums.TypeMessage;
import com.example.whatsappservice.models.EmailResponse;
import com.example.whatsappservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/send-email")
    public ResponseEntity<?> getSendEmail() {
        EmailResponse response = new EmailResponse("Email saved to journal");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/send-email")
    public String sendEmail(@RequestBody String emailContent) {
        messageService.saveMessageToJournal(emailContent, TypeMessage.EMAIL, StatusMessage.SENT);
        return "Email saved to journal";
    }

    @PostMapping("/send-whatsapp")
    public String sendWhatsApp(@RequestBody String whatsappContent) {
        messageService.saveMessageToJournal(whatsappContent, TypeMessage.WHATSAPP, StatusMessage.SENT);
        return "WhatsApp message saved to journal";
    }
}
