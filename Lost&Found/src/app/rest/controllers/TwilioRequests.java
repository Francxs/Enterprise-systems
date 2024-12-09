package app.rest.controllers;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface TwilioRequests {
	
	@POST("2010-04-01/Accounts/{AccountSid}/Messages.json") //replace AccountSid with yours
	@FormUrlEncoded
	public Call<ResponseBody> testSMS(
			              @Path("AccountSid") String accountSid, //replace "AccountSid" (green) with yours
						  @Field("To") String to, 
						  @Field("MessagingServiceSid") String messagingServiceSid, //replace "MessagingServiceSid" (green) with yours
						  @Field("Body") String body
						  );

}


