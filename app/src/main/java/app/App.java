package app;

import java.io.IOException;

import kotlin.jvm.internal.PackageReference;
import okhttp3.Response;
import strava.StravaAPI;

public class App {
    public static void main(String[] args) {
        
        StravaAPI strava = new StravaAPI();
        Response athlete = strava.getEndpoint("athlete", null);
        try{
            System.out.println(athlete.body().string());
        } catch (IOException err) {
            System.err.println(err);
        }

    }
}
