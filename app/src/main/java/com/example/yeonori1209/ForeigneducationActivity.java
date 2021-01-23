package com.example.yeonori1209;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ForeigneducationActivity extends AppCompatActivity {

    Button button01, button02, button03, button04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foreigneducation);

        //국가평생교육진흥원 늘배움 바로가기
        button01 = findViewById(R.id.foreigneducation01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.lifelongedu.go.kr/main.do?TOP_CD=urn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Astatus%3AResponder&SECOND_CD=urn%3Aoasis%3Anames%3Atc%3ASAML%3A2.0%3Astatus%3AUnknownPrincipal&"));
                startActivity(intent);
            }
        });

        //서울특별시 평생학습포털 바로가기
        button02 = findViewById(R.id.foreigneducation02);
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://sll.seoul.go.kr/main/MainView.dunet"));
                startActivity(intent);
            }
        });

        //경기도 평생학습포털 지식(G-seek) 바로가기
        button03 = findViewById(R.id.foreigneducation03);
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gseek.kr/main/intro"));
                startActivity(intent);
            }
        });

        //EBS english 바로가기
        button04 = findViewById(R.id.foreigneducation04);
        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ebse.co.kr/apps/main/main.do"));
                startActivity(intent);
            }
        });
    }
}
