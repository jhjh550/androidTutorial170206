package com.example.a.a22_fragment2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick(View v){
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.frame);
        switch (v.getId()){
            case R.id.btnAdd:
                if(fragment == null){
                    fragment = new BlankFragment();
                    FragmentTransaction tr = fm.beginTransaction();
                    tr.add(R.id.frame, fragment, "counter");
                    tr.commit();
                }
                break;
            case R.id.btnRemove:
                break;
            case R.id.btnReplace:
                break;
            case R.id.btnHide:
                break;
        }
    }
}








