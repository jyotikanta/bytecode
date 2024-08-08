package org.parallel;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class AsyncRestClient {
    public static void main(String[] args) throws InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/users"))
                .build();

        CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        // Do other tasks while waiting for the response...
        System.out.println("Doing other tasks...");
        responseFuture.thenAccept(response -> {
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response: " + response.body());
        }); // Ensure the main thread waits for the response
        for(int i=0;i<100000;i++){
            System.out.print(i+"\t");
        }
        Thread.sleep(10000);
        System.out.printf("Doing Some other task...");
    }
}

