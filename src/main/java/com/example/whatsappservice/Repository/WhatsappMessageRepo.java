package com.example.whatsappservice.Repository;

import com.example.whatsappservice.models.WhatsAppMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WhatsappMessageRepo extends JpaRepository<WhatsAppMessage, Long> {
}
