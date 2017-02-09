package com.example.a.a19_camera;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View v){
        String dirPath = Environment.getExternalStorageDirectory()+"/19Test";
        File dir = new File(dirPath);
        if(dir.exists() == false)
            dir.mkdirs();
        String filePath = dirPath+"/myImage.jpg";
        Uri uri = Uri.fromFile(new File(filePath));

        if(Build.VERSION.SDK_INT < 24) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intent, 1);
        }else{
            //
        }
    }
}
