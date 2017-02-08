package com.example.a.a11_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myText = (TextView) findViewById(R.id.myTextView);
        TestSQLiteHandler dbHandler = new TestSQLiteHandler(this);
        dbHandler.insert("kim", 10, "서울");
        dbHandler.insert("hello", 11, "busan");
        dbHandler.insert("홍길동", 12, "인천");
        dbHandler.update("hello", 13);

        String str = dbHandler.selectAll();
        myText.setText(str);
    }
}








