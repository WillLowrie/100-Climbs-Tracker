package StravaAPI;

import java.io.IOException;
import java.util.Map;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Get {

    private static final OkHttpClient client = new OkHttpClient().newBuilder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10,  TimeUnit.SECONDS)
        .build();

    public Response stravaAPIGet(String endpoint, Map<String, String> params) {

        HttpUrl.Builder stravaGetUrl = new HttpUrl.Builder()
            .scheme("https")
            .host("www.strava.com")
            .addPathSegment("api")
            .addPathSegment("v3");

        String[] pathSegmentList = endpoint.split("[/]");
        for (int i = 0; i < pathSegmentList.length; i++) {
            stravaGetUrl.addPathSegment(pathSegmentList[i]);
        }

        if (params != null) {
            for(Map.Entry<String, String> param: params.entrySet()) {
                stravaGetUrl.addQueryParameter(param.getKey(), param.getValue());
            }
        }

        Request getRequest = new Request.Builder()
            .url(stravaGetUrl.build())
            .build();
        
        try {
            // TO-DO: Look into reponse Callback.
            Response getResponse = client.newCall(getRequest).execute();
            return getResponse;
        } catch (IOException err) {
            // TO-DO: Implement exception handling (can use finally to gracefully handle error).
            System.err.println("Get request failed - " + err);
        } finally {
            Response errResponse = Response.Builder()
                .request(stravaGetUrl.build())
                .code(200)
                .message("IOException")
                .build();
            return errResponse;
        }
    }
    
}
