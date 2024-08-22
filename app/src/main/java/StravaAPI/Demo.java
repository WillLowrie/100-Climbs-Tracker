package StravaAPI;

import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Demo {
    final OkHttpClient client = new OkHttpClient();

    public String getIssPosition() throws IOException {

        Request request = new Request.Builder()
            .url("http://api.open-notify.org/iss-now.json")
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();

        }
    }
}