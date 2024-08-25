package strava;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import okhttp3.HttpUrl;
import strava.StravaAPI;

public class Auth {

    private static final StravaAPI strava = new StravaAPI();

    public void initiateOAuthFlow() {

        HttpUrl oAuthRequestUrl = strava.getOAuthRequest().url();

        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(oAuthRequestUrl.toString()));
            }
        } catch (IOException | URISyntaxException err) {
            System.err.println(err);
        }

    }
    
}
