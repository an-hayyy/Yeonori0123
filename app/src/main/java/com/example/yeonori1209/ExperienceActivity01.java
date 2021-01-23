package com.example.yeonori1209;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ExperienceActivity01 extends AppCompatActivity {

    ImageView f01,f02,f03,f04,f05,f06;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience01);

        f01 = findViewById(R.id.f01);
        f01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity01.this, ExperienceActivity01_1.class);
                startActivity(intent);
            }
        });

        f02 = findViewById(R.id.f02);
        f02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity01.this, ExperienceActivity01_2.class);
                startActivity(intent);
            }
        });

        f03 = findViewById(R.id.f03);
        f03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity01.this, ExperienceActivity01_3.class);
                startActivity(intent);
            }
        });

        f04 = findViewById(R.id.f04);
        f04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity01.this, com.example.yeonori1209.ExperienceActivity01_4.class);
                startActivity(intent);
            }
        });

        f05 = findViewById(R.id.f05);
        f05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity01.this, ExperienceActivity01_5.class);
                startActivity(intent);
            }
        });

        f05 = findViewById(R.id.f06);
        f05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity01.this, ExperienceActivity01_6.class);
                startActivity(intent);
            }
        });

    }
}
