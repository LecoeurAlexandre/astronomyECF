package com.example.observation.tool;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.chrono.IsoEra;



public class RestClient<T,V> {
    private String urlApiUtilisateur = "http://localhost:8082/api/";
    private String urlApiCelestObject = "http://localhost:8081/api/";
    private String urlApiToken = "http://localhost:8084/api/test";
    private RestTemplate template;
    private HttpHeaders httpHeaders;
    private HttpStatus httpStatus;

    public RestClient() {
        template = new RestTemplate();
        httpHeaders = new HttpHeaders();
        httpHeaders.add("Accept", "*/*");
        httpHeaders.add("content-type", "application/json");
    }

    public T getUser(String userUri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApiUtilisateur+userUri, HttpMethod.GET, requestEntity, type);
        return response.getBody();
    }

    public T getCelestObject(String celestObjectUri, Class<T> type) {
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApiCelestObject+celestObjectUri, HttpMethod.GET, requestEntity, type);
        return response.getBody();
    }

    public boolean testToken(String token, Class<T> type) {
        httpHeaders.add("Authorization", token);
        HttpEntity<String> requestEntity = new HttpEntity<>("", httpHeaders);
        ResponseEntity<T> response = template.exchange(urlApiToken, HttpMethod.GET, requestEntity, type);
        if(response.hasBody()) {
            return response.getStatusCode().is2xxSuccessful();
        }
        return false;
    }
}