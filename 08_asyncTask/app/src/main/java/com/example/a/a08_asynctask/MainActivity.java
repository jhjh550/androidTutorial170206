package com.example.a.a08_asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView myTextView;
    class MyAsyncTask extends AsyncTask<Integer, Float, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            myTextView.setText(s);
        }

        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);
            myTextView.setText("count : "+values[0]);
        }

        @Override
        protected String doInBackground(Integer... params) {
            int i = params[0];
            for(; i<100; i++){
                Log.d("AsyncTask", "count : "+i);
                publishProgress((float)i);
//                myTextView.setText("count : "+i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "do in background done";
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myTextView = (TextView) findViewById(R.id.myTextView);

        MyAsyncTask task = new MyAsyncTask();
        task.execute(30);
    }
}
