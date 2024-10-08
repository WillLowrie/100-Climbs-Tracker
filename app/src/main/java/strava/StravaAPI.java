package strava;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class StravaAPI {
    // TO-DO: Implement constructor.

    private static Logger logger = LogManager.getLogger(StravaAPI.class.getName());

    private static final OkHttpClient client = new OkHttpClient().newBuilder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10,  TimeUnit.SECONDS)
        .build();

    // For testing purposes only.
    private static final String accessToken = "68087cb654fdf8b8534c19dc5fc561c6f3e479eb";

    public Response getEndpoint(String endpoint, Map<String, String> params) {

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

        logger.info("Calling endpoint: " + stravaGetUrl.build());
        System.out.println("Calling endpoint: " + stravaGetUrl.build());

        Request getRequest = new Request.Builder()
            .url(stravaGetUrl.build())
            .addHeader("Authorization", "Bearer " + accessToken)
            .build();

        logger.debug("Detailed endpoint request: " + getRequest);
        System.out.println("Detailed endpoint request: " + getRequest);
        
        try {
            // TO-DO: Look into reponse Callback.
            logger.info("Sending GET request to endpoint - " + endpoint);
            System.out.println("Sending GET request to endpoint - " + endpoint);
            Response getResponse = client.newCall(getRequest).execute();
            return getResponse;
        } catch (IOException err) {
            // TO-DO: Implement logging over printing.
            logger.error("Get request failed - " + err);
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
