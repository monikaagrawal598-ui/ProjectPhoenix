
package com.phoenix;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class PhoenixApplication {

    public static String getStatus() {
        return "RUNNING";
    }

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(
            new InetSocketAddress("0.0.0.0", 8080), 0
        );

        server.createContext("/health", exchange -> {
            String response = "Phoenix Status: " + getStatus();

            exchange.getResponseHeaders()
                    .set("Content-Type", "text/plain");

            exchange.sendResponseHeaders(200, response.length());

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response.getBytes());
            }
        });

        server.start();

        System.out.println("PROJECT PHOENIX STARTED");
        System.out.println("Health endpoint: http://localhost:8080/health");
    }
}
