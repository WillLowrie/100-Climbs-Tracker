package StravaAPI;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Athlete {

    private static Logger logger = LogManager.getLogger(Athlete.class);

    // For testing purposes only.
    final String accessToken = "416a854b3cf598b0a20b001f80579e34bc7707d5";

    public static Response getAthlete(OkHttpClient client) throws IOException {

        String getAthleteEndpoint = "https://www.strava.com/api/v3/athlete"; 

        Request getAthelete = new Request.Builder()
            .url(getAthleteEndpoint)
            .build();

        Response athleteResponse = client.newCall(getAthelete).execute();

        return athleteResponse;
    
    }
    
}
