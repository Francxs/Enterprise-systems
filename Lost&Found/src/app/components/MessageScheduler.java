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

//    private boolean initialMessageSent = false;
//    private int messageCount = 0;
//    private static final int MAX_MESSAGES = 4;
//    private String recipientNumber;
//    private String messageBody;
//
//    public void sendInitialMessage(int foundID) {
//        FoundReportDTO report = foundReportComponent.getReport(foundID)
//                .orElseThrow(() -> new RuntimeException("Found report not found"));
//        UserDTO user = foundReportComponent.getUser(report.getIdNumber())
//                .orElseThrow(() -> new RuntimeException("User not found"));
//        recipientNumber = "+63" + user.getPhoneNumber().substring(1);
//        messageBody = "Thank you for sending a Found Report. We appreciate your honesty<3 : " + report.getFoundDetails();
//        
//        twilioSender.sendSMS(recipientNumber, messageBody);
//        initialMessageSent = true;
//        messageCount = 1; // Initial message counts as the first message
//    }
//
//    @Scheduled(fixedRate = 15000)
//    public void sendScheduledMessage() {
//        if (initialMessageSent && messageCount < MAX_MESSAGES) {
//            String scheduledMessageBody = "Your Item is about to be auctioned for a starting price of 15,000 Php";
//            twilioSender.sendSMS(recipientNumber, scheduledMessageBody);
//            messageCount++;
//        }
//    }
    
    
    //  Just change to 5 seconds interval (5000)  
	//  New Code
	  private static final int MAX_MESSAGES = 5;
	  private static final String[] SCHEDULED_MESSAGES = {
	      "We are processing your found item report. Thank you for your patience.",
	  "Your found item is being carefully reviewed by our team.",
	  "We are preparing to connect potential claimants with your found item.",
	  "Your item is about to be auctioned for a starting price of 15,000 Php"
	  };
	
	  private boolean initialMessageSent = false;
	  private int messageCount = 0;
	  private String recipientNumber;
	  private int foundReportId;
	
	  public void sendInitialMessage(int foundID) {
	      try {
	          FoundReportDTO report = foundReportComponent.getReport(foundID)
	                  .orElseThrow(() -> new RuntimeException("Found report not found"));
	      UserDTO user = foundReportComponent.getUser(report.getIdNumber())
	              .orElseThrow(() -> new RuntimeException("User not found"));
	      
	      recipientNumber = "+63" + user.getPhoneNumber().substring(1);
	      foundReportId = foundID;
	      
	      String initialMessage = String.format(
	          "Thank you for submitting a found report for item details: %s. " +
	          "We will keep you updated on the process.", 
	          report.getFoundDetails()
	      );
	      
	      twilioSender.sendSMS(recipientNumber, initialMessage);
	      initialMessageSent = true;
	      messageCount = 1;
	  } catch (Exception e) {
	      // Log the error or handle it appropriately
	      System.err.println("Failed to send initial message: " + e.getMessage());
	      }
	  }
	
	  @Scheduled(fixedRate = 8000) // Changed to 1 minute between messages
	  public void sendScheduledMessage() {
	      if (initialMessageSent && messageCount < MAX_MESSAGES) {
	          try {
	              // Get the current message based on message count
	          String scheduledMessage = SCHEDULED_MESSAGES[messageCount - 1];
	          
	          // Optional: You could add the found report ID or other context
	          scheduledMessage += " (Report ID: " + foundReportId + ")";
	          
	          twilioSender.sendSMS(recipientNumber, scheduledMessage);
	          messageCount++;
	      } catch (Exception e) {
	          // Log the error or handle it appropriately
	          System.err.println("Failed to send scheduled message: " + e.getMessage());
	          }
	      }
	  }
}
