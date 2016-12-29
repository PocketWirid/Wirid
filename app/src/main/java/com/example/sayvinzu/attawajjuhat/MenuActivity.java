package com.example.sayvinzu.attawajjuhat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by SAYVINZU on 27/07/2016.
 */
public class MenuActivity extends AppCompatActivity {

    Button pagi, pengaturan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu);

        pagi = (Button)findViewById(R.id.b_pagi);
        pengaturan = (Button)findViewById(R.id.b_pengaturan);

        pagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuActivity.this,MainActivity.class);
                startActivity(i);
            }
        });

        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent in = new Intent(MenuActivity.this,SettingActivity.class);
//                startActivity(in);
            }
        });


    }
}
