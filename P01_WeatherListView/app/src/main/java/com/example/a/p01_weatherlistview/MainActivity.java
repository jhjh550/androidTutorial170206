package com.example.a.p01_weatherlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    class WeatherData{
        String weather;
        float temperature;
        int day;
        int hour;
    }
    class WeatherAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return weatherList.size();
        }

        @Override
        public Object getItem(int position) {
            return weatherList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.item_view, null);
            }
            TextView textView1 = (TextView)convertView.findViewById(R.id.weatherInfo1);
            TextView textView2 = (TextView)convertView.findViewById(R.id.weatherInfo2);
            WeatherData data = weatherList.get(position);
            String info1 = "날씨 : "+data.weather + ", 온도 : "+ data.temperature;
            Date date = new Date();
            date.setDate(data.hour);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일  HH시");
            String info2 = sdf.format(date);
            textView1.setText(info1);
            textView2.setText(info2);
            return convertView;
        }
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

        ListView listView = (ListView) findViewById(R.id.myListView);
        WeatherAdapter adapter = new WeatherAdapter();
        listView.setAdapter(adapter);
    }
}
