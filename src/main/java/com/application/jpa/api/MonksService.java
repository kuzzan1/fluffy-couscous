package com.application.jpa.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jonas on 2017-06-12.
 */
@Component
public class MonksService {

    @Autowired
    private RestTemplate restTemplate;
    private final static String BASE_URL = "https://soccer.sportmonks.com/api/v2.0/";

    private Map<String, Object> cached = new HashMap<>();

    private String getApiKey( String url ) {
        url = BASE_URL + url;
        String apiKey = ApiKey.getApiKey();
        return url.contains( "?" ) ? url + "&api_token=" + apiKey : url + "?api_token=" + apiKey;
    }


    public <T> T get( String requestUrl, final Class<T> clazz ) {
        String apiKey = getApiKey(requestUrl);
        if(cached.containsKey(apiKey)) {
            return (T) cached.get(apiKey);
        } else {
            T object = exchange(apiKey, clazz, HttpMethod.GET);
            cached.put(apiKey, object);
            return object;
        }
    }


    private <T> T exchange( final String requestUrl, final Class<T> clazz, final HttpMethod method ) {
        T body = restTemplate.exchange(requestUrl, method, null, clazz).getBody();
        System.out.println(requestUrl);
        return body;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
