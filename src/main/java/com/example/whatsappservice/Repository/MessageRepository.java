package com.example.whatsappservice.Repository;
import com.example.whatsappservice.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    // Additional query methods can be added here if needed
}
