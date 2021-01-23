package com.example.yeonori1209;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ExperienceActivity03 extends AppCompatActivity {
    ImageView c01,c02,c03,c04,c05;

    //연습용
    ImageView c06;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience03);

        c01 = findViewById(R.id.c01);
        c01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity03.this, com.example.yeonori1209.ExperienceActivity03_1.class);
                startActivity(intent);
            }
        });

        c02 = findViewById(R.id.c02);
        c02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity03.this, com.example.yeonori1209.ExperienceActivity03_2.class);
                startActivity(intent);
            }
        });

        c03 = findViewById(R.id.c03);
        c03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity03.this, com.example.yeonori1209.ExperienceActivity03_3.class);
                startActivity(intent);
            }
        });

        c04 = findViewById(R.id.c04);
        c04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity03.this, com.example.yeonori1209.ExperienceActivity03_4.class);
                startActivity(intent);
            }
        });

        c05 = findViewById(R.id.c05);
        c05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity03.this, com.example.yeonori1209.ExperienceActivity03_5.class);
                startActivity(intent);
            }
        });

        c06 = findViewById(R.id.c06);
        c06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity03.this, com.example.yeonori1209.ExperienceActivity03_6.class);
                startActivity(intent);
            }
        });
    }
}
