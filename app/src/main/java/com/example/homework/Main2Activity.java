package com.example.homework;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String user = intent.getStringExtra("user");
        String pwd = intent.getStringExtra("pwd");


        TextView t1=findViewById(R.id.T1);
        t1.setText("账号管理               "+user);
        TextView t2=findViewById(R.id.T2);
        t2.setText("密码                      "+pwd);


        LinearLayout button_backward = findViewById(R.id.button_backward);
        button_backward.setOnClickListener(new View.OnClickListener(){
                                               @Override
                                               public void onClick(View view){
                                                   Intent intent = new Intent(Main2Activity.this,Main1Activity.class);
                                                   startActivity(intent);
                                               }
                                           }
        );


    }
}
