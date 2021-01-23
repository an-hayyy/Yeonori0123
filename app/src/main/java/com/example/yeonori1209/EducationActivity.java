package com.example.yeonori1209;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EducationActivity extends AppCompatActivity {

    ImageView education01,education02,education03;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education);

        education01 = findViewById(R.id.education01);
        education01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.yeonori1209.EducationActivity.this, KoreaEducationActivity.class);
                startActivity(intent);
            }
        });

        education02 = findViewById(R.id.education02);
        education02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.yeonori1209.EducationActivity.this, ForeigneducationActivity.class);
                startActivity(intent);
            }
        });

        education03 = findViewById(R.id.education03);
        education03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(com.example.yeonori1209.EducationActivity.this, TranslationActivity.class);
                startActivity(intent);
            }
        });
    }
}