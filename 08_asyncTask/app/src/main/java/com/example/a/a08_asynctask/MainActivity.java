package com.example.a.a08_asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    class MyAsyncTask extends AsyncTask<Integer, Float, String>{
        @Override
        protected String doInBackground(Integer... params) {
            int i = params[0];
            for(; i<100; i++){
                Log.d("AsyncTask", "count : "+i);
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

        MyAsyncTask task = new MyAsyncTask();
        task.execute(30);
    }
}
