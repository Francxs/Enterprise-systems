package app.components;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
//import com.twilio.converter.Promoter;

//import java.net.URI;
//import java.math.BigDecimal;

@Component
public class TwilioSender {
	
	// Find your Account Sid and Token at twilio.com/console
	  public static final String ACCOUNT_SID = " ";
	  public static final String AUTH_TOKEN = " ";
	  
	  
	  static {
	        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	    }

	    public void sendSMS(String recipientNumber, String messageBody) {
	        Message message = Message.creator(
	            new PhoneNumber(recipientNumber),
	            new PhoneNumber(" "), // Replace with your Twilio message SID
	            messageBody
	        ).create();
	        System.out.println("Message sent! SID: " + message.getSid());
	    }
	  
}
	




