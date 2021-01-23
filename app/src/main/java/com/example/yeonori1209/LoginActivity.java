package com.example.yeonori1209;


import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


public class LoginActivity extends AppCompatActivity {
    EditText passwd, userid;
    int i = 0;

    int version = 1;
    com.example.yeonori1209.DatabaseOpenHelper helper;
    SQLiteDatabase database;
    String sql;
    Cursor cursor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userid = findViewById(R.id.userid);
        passwd = findViewById(R.id.userpass);

        helper = new com.example.yeonori1209.DatabaseOpenHelper(com.example.yeonori1209.LoginActivity.this, com.example.yeonori1209.DatabaseOpenHelper.tableName, null, version);
        database = helper.getWritableDatabase();


    }

    public void btn2(View view) {
        String id = userid.getText().toString();
        String pw = passwd.getText().toString();
        String salt = "!@#$%^";

        Security securityA = new Security();
        String user = securityA.getHash(id+salt);
        String pass = securityA.getHash(pw+salt);

        if(id.length() == 0 || pw.length() == 0) {
            Toast toast = Toast.makeText(com.example.yeonori1209.LoginActivity.this, "아이디와 비밀번호는 필수 입력사항입니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        sql = "SELECT id FROM "+ helper.tableName + " WHERE id = '" + user + "'";
        cursor = database.rawQuery(sql, null);

        if(cursor.getCount() != 1){
            Toast toast = Toast.makeText(com.example.yeonori1209.LoginActivity.this, "존재하지 않는 아이디입니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;

        }

        sql = "SELECT pw FROM "+ helper.tableName + " WHERE id = '" + user + "'";
        cursor = database.rawQuery(sql, null);

        cursor.moveToNext();
        if(!pass.equals(cursor.getString(0))){
            i++;
            fail(i);
        }else{
            Toast toast = Toast.makeText(com.example.yeonori1209.LoginActivity.this, "로그인성공", Toast.LENGTH_SHORT);
            toast.show();
            Intent intent = new Intent(getApplicationContext(), com.example.yeonori1209.ExperienceActivity.class);
            startActivity(intent);
            finish();
        }
        cursor.close();
    }

    public void btn(View view) {
        Intent intent = new Intent(com.example.yeonori1209.LoginActivity.this, Agreement_Activity.class);
        startActivity(intent);
    }

    public void fail(int i) {
        if (i<5){
            Toast.makeText(getApplicationContext(), "비밀번호입력" + i + "회 실패\n5회 실패시 앱이 종료됩니다", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(), "비밀번호 " + i + "회 실패\n앱이 종료됩니다", Toast.LENGTH_SHORT).show();
            ActivityCompat.finishAffinity(this);
        }
    }
  }