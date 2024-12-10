package app.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import app.dto.FoundReportDTO;
import app.dto.UserDTO;

@Component
public class MessageScheduler {

    @Autowired
    private TwilioSender twilioSender;

    @Autowired
    private FoundReportComponent foundReportComponent;

    private boolean initialMessageSent = false;
    private int messageCount = 0;
    private static final int MAX_MESSAGES = 4;
    private String recipientNumber;
    private String messageBody;

    public void sendInitialMessage(int foundID) {
        FoundReportDTO report = foundReportComponent.getReport(foundID)
                .orElseThrow(() -> new RuntimeException("Found report not found"));
        UserDTO user = foundReportComponent.getUser(report.getIdNumber())
                .orElseThrow(() -> new RuntimeException("User not found"));
        recipientNumber = "+63" + user.getPhoneNumber().substring(1);
        messageBody = "Thank you for sending a Found Report. We appreciate your honesty<3 : " + report.getFoundDetails();
        
        twilioSender.sendSMS(recipientNumber, messageBody);
        initialMessageSent = true;
        messageCount = 1; // Initial message counts as the first message
    }

    @Scheduled(fixedRate = 15000)
    public void sendScheduledMessage() {
        if (initialMessageSent && messageCount < MAX_MESSAGES) {
            String scheduledMessageBody = "Your Item is about to be auctioned for a starting price of 15,000 Php";
            twilioSender.sendSMS(recipientNumber, scheduledMessageBody);
            messageCount++;
        }
    }
}
