package pl.sda.JavaFXWeather.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.sda.JavaFXWeather.model.Weather;


import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WeatherService {
    Scanner scanner = new Scanner(System.in);
    private String finalURL;
    private String url;
    private String apiKey;
    private Weather weather;


    public WeatherService(String url, String apiKey) {
        this.url = url;
        this.apiKey = apiKey;
    }

    public float getRealTemp(String city){
        weather = createObject(city);
        return weather.getCurrent().getTemp_c();

    }

    public float getFeelTemp(String city){
        weather = createObject(city);
        return weather.getCurrent().getFeelslike_c();

    }

    private Weather createObject(String city){
        finalURL = url + "?key=" + apiKey + "&q=" + city;
        URL jsonURL = null;
        try {
            jsonURL = new URL(finalURL);
            ObjectMapper objectMapper = new ObjectMapper();
            Weather weather = objectMapper.readValue(jsonURL, Weather.class);
            return weather;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }





}
