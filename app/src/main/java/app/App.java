package app;

import java.io.IOException;
import strava.Auth;
import strava.StravaAPI;

public class App {
    public static void main(String[] args) {
        
        // StravaAPI strava = new StravaAPI();
        // Response athlete = strava.getEndpoint("athlete", null);
        // try{
        //     System.out.println(athlete.body().string());
        // } catch (IOException err) {
        //     System.err.println(err);
        // }
        // Response authInitiate = strava.authEndpoint();
        // try {
        //     System.out.println(authInitiate.body().string());
        // } catch (IOException err) {
        //     System.err.println(err);
        // }
        Auth authFlow = new Auth();
        authFlow.initiateOAuthFlow();

    }
}
