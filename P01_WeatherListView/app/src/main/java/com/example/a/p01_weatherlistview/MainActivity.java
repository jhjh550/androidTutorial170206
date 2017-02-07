package com.example.a.p01_weatherlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class WeatherData{
        String weather;
        float temperature;
        int day;
        int hour;
    }
    ArrayList<WeatherData> weatherList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=0; i<20; i++){
            WeatherData data = new WeatherData();
            switch (i%4){
                case 0:
                    data.weather = "흐림";
                    break;
                case 1:
                    data.weather = "맑음";
                    break;
                case 2:
                    data.weather = "비";
                    break;
                case 3:
                    data.weather = "눈";
                    break;
            }
            data.temperature = 10.0f;
            data.day = (i*3)/24;
            data.hour = (i*3)%24;
            weatherList.add(data);
        }
    }
}
