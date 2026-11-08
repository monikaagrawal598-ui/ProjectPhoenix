package com.phoenix;

import java.net.HttpURLConnection;
import java.net.URL;

public class HealthChecker {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/health");

            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);

            int statusCode = connection.getResponseCode();

            if (statusCode == 200) {
                System.exit(0);
            } else {
                System.exit(1);
            }

        } catch (Exception e) {
            System.exit(1);
        }
    }
}