package com.example.yeonori1209;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SosActivity extends AppCompatActivity {

    ImageView sos01,sos02,sos03;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);

        //취업 및 직업훈련
        sos01 = findViewById(R.id.sos01);
        sos01.setOnClickListener(new View.OnClickListener() { // 취업 및 직업훈련
            @Override
            public void onClick(View v) { //클릭 했을경우
                //버튼 클릭 시 정책 열람으로 이동
                Intent intent = new Intent(com.example.yeonori1209.SosActivity.this, TrainingActivity.class);
                startActivity(intent);
            }
        });

        //
        sos02 = findViewById(R.id.sos02);
        sos02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.example.yeonori1209.SosActivity.this, com.example.yeonori1209.SoS02Activity.class );
                startActivity(intent);
            }
        });

        sos03 = findViewById(R.id.sos03);
        sos03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.example.yeonori1209.SosActivity.this, SoS03Activity.class );
                startActivity(intent);
            }
        });
    }
}
