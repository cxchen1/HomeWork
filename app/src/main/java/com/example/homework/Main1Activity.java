package com.example.homework;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class Main1Activity extends AppCompatActivity {
    private String s1;
    private String s2;
    private EditText loginHint;
    private EditText passWordHint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        //设置登录页面账号提示框中的字体大小
        loginHint = (EditText) findViewById(R.id.loginHint);
        SpannableString spannableString = new SpannableString("手机号 邮箱");
        AbsoluteSizeSpan textSize = new AbsoluteSizeSpan(14, true);
        spannableString.setSpan(textSize, 0, spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        loginHint.setHint(spannableString);

        passWordHint = (EditText) findViewById(R.id.passWordHint);
        SpannableString spannableString1 = new SpannableString("请输入密码");
        spannableString1.setSpan(textSize, 0, spannableString1.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        passWordHint.setHint(spannableString1);



        HashMap users = new HashMap<String,String>();
        users.put(s1,s2);


        Button loginButton1 = findViewById(R.id.loginButton1);
        loginButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s1=loginHint.getText().toString();
                s2=passWordHint.getText().toString();
                Bundle bundleSimple = new Bundle();
                bundleSimple.putString("user", s1);
                bundleSimple.putString("pwd", s2);
                Intent intent = new Intent(Main1Activity.this, Main3Activity.class);
                intent.putExtras(bundleSimple);
                startActivity(intent);
            }
        });
    }

}
