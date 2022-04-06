package com.energizo.kumohmap.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.energizo.kumohmap.R;
import com.energizo.kumohmap.view.menu.MainActivity;

public class Logo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                myStartActivity(MainActivity.class);
            }
        },2500);
    }

    private void myStartActivity(Class c){
        Intent intent = new Intent(this,c);
        finish();
        startActivity(intent);
    }
}