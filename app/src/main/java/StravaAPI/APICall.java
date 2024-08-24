package StravaAPI;

import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class APICall {
    // TO-DO: Implement constructor.

    private static final OkHttpClient client = new OkHttpClient().newBuilder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10,  TimeUnit.SECONDS)
        .build();

    // For testing purposes only.
    private static final String accessToken = "416a854b3cf598b0a20b001f80579e34bc7707d5";

    public Response stravaAPIGet(String endpoint, Map<String, String> params) {

        HttpUrl.Builder stravaGetUrl = new HttpUrl.Builder()
            .scheme("https")
            .host("www.strava.com")
            .addPathSegment("api")
            .addPathSegment("v3")
            .addPathSegments(endpoint); // TO-DO: Check if this works with a no / path.

        if (params != null) {
            for(Map.Entry<String, String> param: params.entrySet()) {
                stravaGetUrl.addQueryParameter(param.getKey(), param.getValue());
            }
        }

        Request getRequest = new Request.Builder()
            .url(stravaGetUrl.build())
            .addHeader("Authorization", "Bearer " + accessToken)
            .build();
        
        try {
            // TO-DO: Look into reponse Callback.
            Response getResponse = client.newCall(getRequest).execute();
            return getResponse;
        } catch (IOException err) {
            // TO-DO: Implement logging over printing.
            System.err.println("Get request failed - " + err);
            Response errResponse = new Response.Builder()
                .request(getRequest)
                .code(200)
                .message("IOException")
                .build();
            return errResponse;
        }
    }
    
}
