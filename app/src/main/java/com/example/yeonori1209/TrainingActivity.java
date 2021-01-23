package com.example.yeonori1209;

import android.app.TabActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

@SuppressWarnings("deprecation")
public class TrainingActivity extends TabActivity implements YouTubePlayer.OnInitializedListener { //TaibActivty를 extends 해준다.

    Button button01,button02,button03,button04,button05,button06,button07,button08;

    public static final String API_KEY = "AIzaSyCmQvbIqHA1o9JyUldBvVudV7-GWZbjZ5s";
    public static final String VIDEO_ID = "EM4moWi2r-8";

    private YouTubePlayer youTubePlayer;
    private YouTubePlayerFragment youTubePlayerFragment;
    private TextView textVideoLog;
    private Button btnViewFullScreen;

    private static final int RQS_ErrorDialog = 1;

    private MyPlayerStateChangeListener myPlayerStateChangeListener;
    private MyPlaybackEventListener myPlaybackEventListener;

    String log = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        TabHost tabHost = getTabHost();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("Group1").setIndicator("취업");
        tab1.setContent(R.id.sos01_1);
        tabHost.addTab(tab1);//레이아웃과 연결

        TabHost.TabSpec tab2 = tabHost.newTabSpec("Group2").setIndicator("직업훈련");
        tab2.setContent(R.id.sos01_2);
        tabHost.addTab(tab2);

        tabHost.setCurrentTab(0);

        //외국인 종합안내센터
        button01 = (Button)findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.moj.go.kr/moj/196/subview.do"));
                startActivity(intent);
            }
        });

        //서울글로벌센터 홈페이지 바로가기
        button02 = (Button)findViewById(R.id.button02);
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://global.seoul.go.kr/index.do"));
                startActivity(intent);
            }
        });

        //워크넷 홈페이지 바로가기
        button03 = (Button)findViewById(R.id.button03);
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.work.go.kr/seekWantedMain.do"));
                startActivity(intent);
            }
        });

        //한국직업정보시스템 홈페이지 바로가기
        button04 = (Button)findViewById(R.id.button04);
        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://know.work.go.kr/"));
                startActivity(intent);
            }
        });

        //고용복지플러스센터 홈페이지 바로가기
        button05 = (Button)findViewById(R.id.button05);
        button05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.work.go.kr/jobcenter/index.do"));
                startActivity(intent);
            }
        });

        //한국여성인력개발센터 연합 홈페이지 바로가기
        button06 = (Button)findViewById(R.id.button06);
        button06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.vocation.or.kr/main.aspx"));
                startActivity(intent);
            }
        });

        // 고용노동부 홈페이지 바로가기
        button07 = (Button)findViewById(R.id.button07);
        button07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moel.go.kr/index.do"));
                startActivity(intent);
            }
        });

        // 고용노동부 직업능력개발정보망 홈페이지 바로가기
        button08 = (Button)findViewById(R.id.button08);
        button08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hrd.go.kr/hrdp/ma/pmmao/indexNew.do"));
                startActivity(intent);
            }
        });

        youTubePlayerFragment = (YouTubePlayerFragment)getFragmentManager()
                .findFragmentById(R.id.youtubeplayerfragment);
        youTubePlayerFragment.initialize(API_KEY, this);

        textVideoLog = (TextView)findViewById(R.id.videolog);

        myPlayerStateChangeListener = new MyPlayerStateChangeListener();
        myPlaybackEventListener = new MyPlaybackEventListener();

        btnViewFullScreen = (Button)findViewById(R.id.btnviewfullscreen);
        btnViewFullScreen.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                youTubePlayer.setFullscreen(true);
            }});

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult result) {

        if (result.isUserRecoverableError()) {
            result.getErrorDialog(this, RQS_ErrorDialog).show();
        } else {
            Toast.makeText(this,
                    "성공!!!!!!!!!!!!!!!!!! " + result.toString(),
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                        boolean wasRestored) {

        youTubePlayer = player;

        Toast.makeText(getApplicationContext(),
                "YouTubePlayer.onInitializationSuccess()",
                Toast.LENGTH_LONG).show();

        youTubePlayer.setPlayerStateChangeListener(myPlayerStateChangeListener);
        youTubePlayer.setPlaybackEventListener(myPlaybackEventListener);

        if (!wasRestored) {
            player.cueVideo(VIDEO_ID);
        }

    }

    private final class MyPlayerStateChangeListener implements YouTubePlayer.PlayerStateChangeListener {

        private void updateLog(String prompt){
            log +=  "MyPlayerStateChangeListener" + "\n" +
                    prompt + "\n\n=====";
            textVideoLog.setText(log);
        };

        @Override
        public void onAdStarted() {
            updateLog("onAdStarted()");
        }

        @Override
        public void onError(
                com.google.android.youtube.player.YouTubePlayer.ErrorReason arg0) {
            updateLog("onError(): " + arg0.toString());
        }

        @Override
        public void onLoaded(String arg0) {
            updateLog("onLoaded(): " + arg0);
        }

        @Override
        public void onLoading() {
            updateLog("onLoading()");
        }

        @Override
        public void onVideoEnded() {
            updateLog("onVideoEnded()");
        }

        @Override
        public void onVideoStarted() {
            updateLog("onVideoStarted()");
        }

    }

    private final class MyPlaybackEventListener implements YouTubePlayer.PlaybackEventListener {

        private void updateLog(String prompt){
            log +=  "MyPlaybackEventListener" + "\n-" +
                    prompt + "\n\n=====";
            textVideoLog.setText(log);
        };

        @Override
        public void onBuffering(boolean arg0) {
            updateLog("onBuffering(): " + String.valueOf(arg0));
        }

        @Override
        public void onPaused() {
            updateLog("onPaused()");
        }

        @Override
        public void onPlaying() {
            updateLog("onPlaying()");
        }

        @Override
        public void onSeekTo(int arg0) {
            updateLog("onSeekTo(): " + String.valueOf(arg0));
        }

        @Override
        public void onStopped() {
            updateLog("onStopped()");
        }

    }
}