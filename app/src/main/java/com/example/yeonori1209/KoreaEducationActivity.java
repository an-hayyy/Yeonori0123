package com.example.yeonori1209;

import android.app.TabActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class KoreaEducationActivity extends TabActivity { //TabActivity를 extends 해준다.

    Button button01,button02,button03,button04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_koreaeducation);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Group1").setIndicator("무료온라인학습");
        tab1.setContent(R.id.koreatab1);
        tabHost.addTab(tab1);//레이아웃과 연결

        TabHost.TabSpec tab2 = tabHost.newTabSpec("Group2").setIndicator("간단한 회화");
        tab2.setContent(R.id.koreatab2);
        tabHost.addTab(tab2);

        tabHost.setCurrentTab(0);

        //세종누리학당 바로가기 버튼
        button01 = (Button)findViewById(R.id.sejong);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sejonghakdang.org/opencourse/koreanlecture/list.do"));
                startActivity(intent);
            }
        });

        button02 = (Button)findViewById(R.id.koreanuniv);
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://korean.cuk.edu/"));
                startActivity(intent);
            }
        });

        button03 = (Button)findViewById(R.id.ebseducation);
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ebs.co.kr/durian/kr/course"));
                startActivity(intent);
            }
        });

        button04 = (Button)findViewById(R.id.dmh);
        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://storytelling.nlcy.go.kr/DmhMain/DmhMainRecommendList.do"));
                startActivity(intent);
            }
        });
    }
}