package app;

import java.io.IOException;

import StravaAPI.*;

public class App {
    public static void main(String[] args) {
        Demo demo = new Demo();
        try {
            String issPosition = demo.getIssPosition();
            System.out.println(issPosition);
        }
        catch (IOException err) {
            System.out.println(err);
        }
    }
}
