package org.shinhan16200100.simpleshot;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 화면 전화 - 인텐트 날리기 (startActivity)
        // 1. 다음 넘어갈 화면을 준비한다(layout xml,java)
        // 2. AndroidMainfest.xml 에 Activity 를 등록한다
        // 3. Intent 객체를 만들어서 startActivity 한다

        Button b = (Button)findViewById(R.id.loginbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getApplicationContext(),//현재 화면의 제어권자
                        GroupContentsActivity.class);// 다음 넘어갈 클래스 지정
                startActivity(intent);//다음 화면으로 넘어간다
            }
        });
    }
}
