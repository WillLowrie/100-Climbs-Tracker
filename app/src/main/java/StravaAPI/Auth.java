package StravaAPI;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;
import StravaAPI.Athlete;
import StravaAPI.ResponseHandler;

public class Auth {

    private static final OkHttpClient client = new OkHttpClient().newBuilder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10,  TimeUnit.SECONDS)
        .build();

    public static void redirectToAuth() {

        HttpUrl oauthUrl = new HttpUrl.Builder()
            .scheme("https")
            .build();

        Request getOauth = new Request.Builder()
            .url("https://www.strava.com/oauth/authorize")
            .build();

        try {
            Response authResponse = client.newCall(getOauth).execute();
            System.out.println(authResponse);
        } catch (IOException err) {
            // TO-DO: Implement this error handling.
            System.out.println(err.getMessage());
        }

    }

    public boolean verifyAuth() {
        // Verifies required athelete information can be retrieved.
        
        OkHttpClient client = new OkHttpClient();

        try {
            Response athlete = Athlete.getAthlete(client);
            if (athlete.isSuccessful()) {
                return true;
            } else {
                ResponseHandler.handleBadResponse(athlete);
                return false;
            }
        } catch (IOException err) {
            // TO-DO: Implement this error handling.
            System.out.println(err.getMessage());
            return false;
        }

    }

    public static void authFlow() {
        // TO-DO: Implement OAuth2 flow.
    }
    
}
