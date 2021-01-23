package com.example.yeonori1209;

import android.app.TabActivity;
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
public class PregnancybirthActivity extends TabActivity implements YouTubePlayer.OnInitializedListener{ //TabActivity를 extends 해준다.

    public static final String API_KEY = "AIzaSyCmQvbIqHA1o9JyUldBvVudV7-GWZbjZ5s";
    public static final String VIDEO_ID = "sTTZ20zEWxE";

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
        setContentView(R.layout.activity_pregnancybirth);


        TabHost tabHost = getTabHost();

        //tab1에 Kim이라는 태그를 붙여줌
        TabHost.TabSpec tab1 = tabHost.newTabSpec("Group1").setIndicator("임신과 출산");
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);//레이아웃과 연결

        TabHost.TabSpec tab2 = tabHost.newTabSpec("Group2").setIndicator("영유아 건강관리");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);

        TabHost.TabSpec tab3 = tabHost.newTabSpec("Group3").setIndicator("영유아보육 및 유아교육");
        tab3.setContent(R.id.tab3);
        tabHost.addTab(tab3);

        tabHost.setCurrentTab(0);

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
                    "YouTubePlayer.onInitializationFailure(): " + result.toString(),
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