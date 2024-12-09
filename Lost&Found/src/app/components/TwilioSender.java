package app.components;

import okhttp3.Credentials;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;

@Component
public class TwilioSender {

    @Autowired
    private TwilioApiService twilioApiService;
    
    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.messaging.service.sid}")
    private String messagingServiceSid;

    public void sendSMS(String recipientNumber, String messageBody) {
        String authHeader = Credentials.basic(accountSid, authToken);
        TwilioMessage twilioMessage = new TwilioMessage(recipientNumber, messagingServiceSid, messageBody);
        Call<ResponseBody> call = twilioApiService.sendMessage(authHeader, accountSid, twilioMessage.getTo(), twilioMessage.getFrom(), twilioMessage.getBody());
        try {
            Response<ResponseBody> response = call.execute();
            if (response.isSuccessful()) {
                System.out.println("Message sent! Response: " + response.body().string());
            } else {
                System.out.println("Failed to send message. Error: " + response.errorBody().string());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
