package com.example.a.a03_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Intent intent = getIntent();
        String strId = intent.getStringExtra("id");
        String strPw = intent.getStringExtra("pw");
        Toast.makeText(this, "id : "+strId, Toast.LENGTH_SHORT).show();

        Intent intent2 = new Intent();
        intent2.putExtra("myResult", "123123123");
        setResult(RESULT_OK, intent2);
    }
}
