package com.example.a60029511.a20170902test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 화면 한개를 담당!
 */
public class MainActivity extends AppCompatActivity {

    /*onCreate 기능은 처음 화면로딩 될 때*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //xml로 구성된 화면을 생성하며 액티비티의 화면으로 설정 , 그 화면을 유저가 보게 된다.
        setContentView(R.layout.activity_main);
        //Log.i("SH","로그");
    }
}
