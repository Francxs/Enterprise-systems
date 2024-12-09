package app.config;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import app.components.TwilioApiService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

    @Bean
    public Retrofit provideRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        return new Retrofit.Builder()
                .baseUrl("https://api.twilio.com/2010-04-01/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Bean
    public TwilioApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(TwilioApiService.class);
    }
}
