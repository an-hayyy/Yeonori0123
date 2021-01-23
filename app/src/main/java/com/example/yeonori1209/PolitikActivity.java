package com.example.yeonori1209;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PolitikActivity extends AppCompatActivity {

    ImageView politikicon01,politikicon02;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politik);

        //사회 보장제도
        politikicon01 = findViewById(R.id.politikicon01);
        politikicon01.setOnClickListener(new View.OnClickListener() { // 정책열람 이미지 버튼 이벤트 정의
            @Override
            public void onClick(View v) { //클릭 했을경우
                //버튼 클릭 시 정책 열람으로 이동
                Intent intent = new Intent(com.example.yeonori1209.PolitikActivity.this, com.example.yeonori1209.BasiclifeActivity.class);
                startActivity(intent);
            }
        });

        //임신출산 자녀교육
        politikicon02 = findViewById(R.id.politikicon02);
        politikicon02.setOnClickListener(new View.OnClickListener() { // 정책열람 이미지 버튼 이벤트 정의
            @Override
            public void onClick(View v) { //클릭 했을경우
                //버튼 클릭 시 정책 열람으로 이동
                Intent intent = new Intent(com.example.yeonori1209.PolitikActivity.this, com.example.yeonori1209.PregnancybirthActivity.class);
                startActivity(intent);
            }
        });
    }
}