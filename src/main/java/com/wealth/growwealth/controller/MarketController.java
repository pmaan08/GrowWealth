package com.wealth.growwealth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

@RestController
public class MarketController {

    @Value("${polygon.api.base.url}")
    private String baseUrl;

    @Value("${polygon.api.key}")
    private String apiKey;

    @GetMapping("/api/market")
    public Object getMarketData(
            @RequestParam String symbol,
            @RequestParam String from,
            @RequestParam String to) {

        String url = String.format(
                "%s/v2/aggs/ticker/%s/range/1/day/%s/%s?apiKey=%s",
                baseUrl, symbol, from, to, apiKey);


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        try{
            HttpResponse<String> response= client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (IOException | InterruptedException e) {
            return Map.of("error", "failed to fetch data:  " + e.getMessage());
        }

    }
}
