package com.example.yeonori1209;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Agreement_Activity extends AppCompatActivity {

    CheckBox checkbox1,checkbox2,checkbox3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agreement);

        checkbox1 = findViewById(R.id.checkBox1) ;
        checkbox2 =  findViewById(R.id.checkBox2) ;
        checkbox3 =  findViewById(R.id.checkBox3) ;



    }

     public  void all_check(View view){
         if(checkbox3.isChecked()==true){

             checkbox1.setChecked(true) ;
             checkbox2.setChecked(true) ;
         }else{

             checkbox1.setChecked(false);
             checkbox2.setChecked(false);
         }
    }

    public void btn_check(View view) {


        if(checkbox1.isChecked()==false|| checkbox2.isChecked()==false) {
            //아이디와 비밀번호는 필수 입력사항입니다.
            Toast.makeText(getApplicationContext(), "모든 약관에 동의 하셔야 합니다.", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            Toast.makeText(getApplicationContext(), "약관동의 확인", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(com.example.yeonori1209.Agreement_Activity.this, com.example.yeonori1209.SignupActivity.class);
            startActivity(intent);
        }
    }



}