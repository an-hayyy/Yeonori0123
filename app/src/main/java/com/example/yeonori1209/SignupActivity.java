package com.example.yeonori1209;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    int version = 1;
    com.example.yeonori1209.DatabaseOpenHelper helper;
    SQLiteDatabase database;

    EditText idEditText, pwEditText;
    String sql;
    Cursor cursor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        idEditText = findViewById(R.id.userid);
        pwEditText = findViewById(R.id.userpass);


        helper = new com.example.yeonori1209.DatabaseOpenHelper(com.example.yeonori1209.SignupActivity.this, com.example.yeonori1209.DatabaseOpenHelper.tableName, null, version);
        database = helper.getWritableDatabase();

    }
    public void btn3(View view) {

        String id = idEditText.getText().toString();
        String pw = pwEditText.getText().toString();
        String salt = "!@#$%^";

        Security securityA = new Security();
        String rtn1 = securityA.getHash(id+salt);
        String rtn2 = securityA.getHash(pw+salt);



        if(id.length() == 0 || pw.length() == 0) {
            Toast toast = Toast.makeText(com.example.yeonori1209.SignupActivity.this, "아이디와 비밀번호는 필수 입력사항입니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        sql = "SELECT id FROM "+ helper.tableName + " WHERE id = '" + rtn1 + "'";
        cursor = database.rawQuery(sql, null);

        if(cursor.getCount() != 0){
            Toast toast = Toast.makeText(com.example.yeonori1209.SignupActivity.this, "이미 존재하는 아이디입니다.", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            helper.insertUser(database,rtn1,rtn2);
            Toast toast = Toast.makeText(com.example.yeonori1209.SignupActivity.this, "가입이 완료되었습니다. 로그인을 해주세요.", Toast.LENGTH_SHORT);
            toast.show();
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
}