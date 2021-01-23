package com.example.yeonori1209;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ExperienceActivity02 extends AppCompatActivity {

    ImageView d01,d02,d03,d04,d05,d06;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience02);

        d01 = findViewById(R.id.d01);
        d01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity02.this, ExperienceActivity02_1.class);
                startActivity(intent);
            }
        });

        d02 = findViewById(R.id.d02);
        d02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity02.this, ExperienceActivity02_2.class);
                startActivity(intent);
            }
        });

        d03 = findViewById(R.id.d03);
        d03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity02.this, com.example.yeonori1209.ExperienceActivity02_3.class);
                startActivity(intent);
            }
        });

        d04 = findViewById(R.id.d04);
        d04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity02.this, com.example.yeonori1209.ExperienceActivity02_4.class);
                startActivity(intent);
            }
        });

        d05 = findViewById(R.id.d05);
        d05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity02.this, ExperienceActivity02_5.class);
                startActivity(intent);
            }
        });

        d06 = findViewById(R.id.d06);
        d06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //클릭 했을경우
                Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity02.this, com.example.yeonori1209.ExperienceActivity02_6.class);
                startActivity(intent);
            }
        });
    }
    public void but2(View view) {
        Intent intent = new Intent(com.example.yeonori1209.ExperienceActivity02.this, Culture_exActivity.class);
        startActivity(intent);
    }
}
