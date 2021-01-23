package com.example.yeonori1209;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView Politik; //이미지 파일 정책열람
    ImageView Sos;
    ImageView Experience;
    ImageView Education;
    ImageView Myongjicollege;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Politik = findViewById(R.id.Politik);
        Sos = findViewById(R.id.Sos);
        Experience = findViewById(R.id.Experience);
        Education = findViewById(R.id.Education);
        Myongjicollege = findViewById(R.id.Myongjicollege);

        Politik.setOnClickListener(new View.OnClickListener() { // 정책열람 이미지 버튼 이벤트 정의
            @Override

            public void onClick(View v) { //클릭 했을경우
                //버튼 클릭 시 정책 열람으로 이동
                Intent intent = new Intent(com.example.yeonori1209.MainActivity.this, com.example.yeonori1209.PolitikActivity.class);
                startActivity(intent);
            }
        });

        Sos.setOnClickListener(new View.OnClickListener() { // 정책열람 이미지 버튼 이벤트 정의
            @Override

            public void onClick(View v) { //클릭 했을경우
                //버튼 클릭 시 정책 열람으로 이동
                Intent intent = new Intent(com.example.yeonori1209.MainActivity.this, com.example.yeonori1209.SosActivity.class);
                startActivity(intent);
            }
        });

        Experience.setOnClickListener(new View.OnClickListener() { // 정책열람 이미지 버튼 이벤트 정의
            @Override

            public void onClick(View v) { //클릭 했을경우
                //버튼 클릭 시 정책 열람으로 이동
                Intent intent = new Intent(com.example.yeonori1209.MainActivity.this, com.example.yeonori1209.LoginActivity.class);
                //Intent intent = new Intent(MainActivity.this, ExperienceActivity.class);
                startActivity(intent);
            }
        });

        Education.setOnClickListener(new View.OnClickListener() { // 정책열람 이미지 버튼 이벤트 정의
            @Override

            public void onClick(View v) { //클릭 했을경우
                //버튼 클릭 시 정책 열람으로 이동
                Intent intent = new Intent(com.example.yeonori1209.MainActivity.this, com.example.yeonori1209.EducationActivity.class);
                startActivity(intent);
            }
        });
        Myongjicollege.setOnClickListener(new View.OnClickListener() { // 정책열람 이미지 버튼 이벤트 정의
            @Override

            public void onClick(View v) { //클릭 했을경우
                //버튼 클릭 시 정책 열람으로 이동
                Intent intent = new Intent(com.example.yeonori1209.MainActivity.this, com.example.yeonori1209.TranslationActivity.class);
                startActivity(intent);
            }
        });
    }
}
