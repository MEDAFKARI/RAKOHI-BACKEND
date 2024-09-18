package com.example.whatsappservice.controller;

import com.example.whatsappservice.enums.StatusMessage;
import com.example.whatsappservice.enums.TypeMessage;
import com.example.whatsappservice.models.WhatsAppMessage;
import com.example.whatsappservice.service.WhatsAppService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/whatsapp")
public class WhatsAppController {

    private final WhatsAppService whatsAppService;

    // Constructor injection for WhatsAppService
    public WhatsAppController(WhatsAppService whatsAppService) {
        this.whatsAppService = whatsAppService;
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam String numeroTelephone, @RequestParam String contenu) {
        // Create a WhatsAppMessage instance
        WhatsAppMessage message = new WhatsAppMessage(
                contenu, // Message content
                LocalDateTime.now(), // Current date and time
                StatusMessage.SENT, // Assuming 'SENT' is a valid status
                TypeMessage.WHATSAPP, // Assuming 'WHATSAPP' is a valid type
                numeroTelephone // Phone number
        );

        // Call the sendWhatsAppMessage method
        whatsAppService.sendWhatsAppMessage(message);

        return "Message sent successfully";
    }
}
