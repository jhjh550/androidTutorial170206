package com.example.a.a09_pullparser;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    class WeatherData{
        int day;
        int hour;
        float temp;
        String wfKor;
    }

    ArrayList<WeatherData> list = new ArrayList<>();
    enum DataType {none, hourType, dayType, tempType, wfKorType}
    DataType type = DataType.none;

    TextView weatherTextView;
    class MyPullParserTask extends AsyncTask<String, Void, String>{

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            weatherTextView.setText(s);
        }


        @Override
        protected String doInBackground(String... params) {
            String res = "";
            try {
                XmlPullParser xpp = XmlPullParserFactory.newInstance().newPullParser();
                URL url = new URL(params[0]);
                xpp.setInput(url.openStream(), "utf-8");
                int eventType = xpp.getEventType();

                while(eventType != XmlPullParser.END_DOCUMENT){
                    switch (eventType){
                        case XmlPullParser.START_TAG:
                            if(xpp.getName().equals("hour")){
                                type = DataType.hourType;
                            }else if(xpp.getName().equals("wfKor")){

                            }
                            break;
                        case XmlPullParser.TEXT:
                            switch (type){
                                case hourType:
                                    break;
                                case dayType:
                                    break;
                                case tempType:
                                    break;
                                case wfKorType:
                                    break;
                            }
                            type = DataType.none;
                            break;
                        case XmlPullParser.END_TAG:
                            break;
                    }
                    eventType = xpp.next();
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            return res;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherTextView = (TextView) findViewById(R.id.weatherTextView);
        MyPullParserTask task = new MyPullParserTask();
        task.execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000");
    }
}
