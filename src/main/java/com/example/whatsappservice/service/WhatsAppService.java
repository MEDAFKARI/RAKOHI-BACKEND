package com.example.whatsappservice.service;

import com.example.whatsappservice.models.WhatsAppMessage;
import org.springframework.stereotype.Service;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class WhatsAppService {

    public static final String ACCOUNT_SID = "your_account_sid"; // Replace with your Twilio Account SID
    public static final String AUTH_TOKEN = "your_auth_token"; // Replace with your Twilio Auth Token
    public static final String WHATSAPP_SENDER = "whatsapp:+14155238886"; // Replace with your Twilio WhatsApp number

    public void sendWhatsAppMessage(WhatsAppMessage whatsAppMessage) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                        new PhoneNumber("whatsapp:" + whatsAppMessage.getNumeroTelephone()),
                        new PhoneNumber(WHATSAPP_SENDER),
                        whatsAppMessage.getContenu())
                .create();

        System.out.println("WhatsApp message sent: " + message.getSid());
    }
}
