package app.components;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface TwilioApiService {

    @POST("Accounts/{AccountSid}/Messages.json")
    @FormUrlEncoded
    Call<ResponseBody> sendMessage(
        @Header("Authorization") String authHeader,
        @Path("AccountSid") String accountSid,
        @Field("To") String to,
        @Field("MessagingServiceSid") String messagingServiceSid,
        @Field("Body") String body
    );
}
