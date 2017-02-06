package com.example.a.a03_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onstart", Toast.LENGTH_SHORT).show();
    }

    private static final int req_code = 100;
    public void onBtnClicked(View v){
        Intent intent = new Intent(this, MyActivity.class);
        intent.putExtra("id", "abcde");
        intent.putExtra("pw", "12345");
        startActivityForResult(intent, req_code);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == req_code){
            if(resultCode == RESULT_OK){
                String str = data.getStringExtra("myResult");
                Toast.makeText(this, "result : "+str, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
