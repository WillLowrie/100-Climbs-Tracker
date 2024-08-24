package app;

import java.io.IOException;

import StravaAPI.*;

public class App {
    public static void main(String[] args) {
        Auth authFlow = new Auth();

        authFlow.redirectToAuth();
    }
}
