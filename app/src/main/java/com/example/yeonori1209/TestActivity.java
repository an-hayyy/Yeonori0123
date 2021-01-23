package com.example.yeonori1209;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;


public class TestActivity extends Activity implements View.OnClickListener {
    Chronometer ch;
    Button btnStart, btnEnd;
    FrameLayout caltime;
    RadioGroup rGroup;
    CalendarView cv;
    TimePicker tp;
    RadioButton rdoDate, rdoTime;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        ch = (Chronometer) findViewById(R.id.ch);
        btnStart = (Button) findViewById(R.id.btnStart);
        btnEnd = (Button) findViewById(R.id.btnEnd);
        caltime = (FrameLayout) findViewById(R.id.caltime);
        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        cv = (CalendarView) findViewById(R.id.cal);
        tp = (TimePicker) findViewById(R.id.time);
        rdoDate = (RadioButton) findViewById(R.id.rdoDate);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);
        txtResult = (TextView) findViewById(R.id.txtResult);

        btnStart.setOnClickListener(this);
        btnEnd.setOnClickListener(this);

        rdoDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cv.setVisibility(View.VISIBLE);
                tp.setVisibility(View.INVISIBLE);

            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cv.setVisibility(View.INVISIBLE);
                tp.setVisibility(View.VISIBLE);

            }
        });

    }



    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnStart:
                rGroup.setVisibility(View.VISIBLE);
                caltime.setVisibility(View.VISIBLE);
                btnStart.setEnabled(false);
                btnEnd.setEnabled(true);
                ch.setTextColor(Color.RED);
                ch.setBase(SystemClock.elapsedRealtime());
                ch.start();
                break;
            case R.id.btnEnd:
                rGroup.setVisibility(View.INVISIBLE);
                caltime.setVisibility(View.INVISIBLE);
                btnStart.setEnabled(true);
                btnEnd.setEnabled(false);
                ch.setTextColor(Color.BLUE);
                ch.stop();

                long time = cv.getDate();
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date(time));

                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH) + 1;
                int day = cal.get(Calendar.DAY_OF_MONTH);

                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();

                txtResult.setText(
                        year+"년"+month+"월"+day+"일"+
                                hour+"시"+minute+"분");

                break;
        }

    }
}



