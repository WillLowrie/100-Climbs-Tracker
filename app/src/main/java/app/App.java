package app;

import StravaAPI.APICall;
import okhttp3.Response;

public class App {
    public static void main(String[] args) {
        
        APICall apiClient = new APICall();
        Response athlete = apiClient.stravaAPIGet("athlete", null);
        System.out.println(athlete.toString());

    }
}
