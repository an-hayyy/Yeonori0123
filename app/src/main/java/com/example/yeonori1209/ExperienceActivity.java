package com.example.yeonori1209;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ExperienceActivity extends AppCompatActivity {

    ImageView ex01,ex02,ex03;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);

        //음식체험
        ex01 = findViewById(R.id.ex01);
        ex01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity.this, com.example.yeonori1209.ExperienceActivity01.class);
                startActivity(intent);
            }
        });

        //의상체험
        ex02 = findViewById(R.id.ex02);
        ex02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity.this, ExperienceActivity02.class);
                startActivity(intent);
            }
        });

        //문화체험
        ex03 = findViewById(R.id.ex03);
        ex03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity.this, ExperienceActivity03.class);
                startActivity(intent);
            }
        });

    }
}
