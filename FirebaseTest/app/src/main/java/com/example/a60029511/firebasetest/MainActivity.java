package com.example.a60029511.firebasetest;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    String nameStr;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //xml로 만들어진 view를 자바 코드에서 참조하기 위해 가져오는 코드 => 데이터바인딩
        TextView name = (TextView)findViewById(R.id.name);
        //name.setText(nameStr);
        //Log.i("SH",nameStr);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        //0번 상황을 메시지로 던진다
        //handler.sendEmptyMessage(0);
        //1초 후에
        handler.sendEmptyMessageDelayed(0,1000*1);
    }

    //손쉽세 화면처리 및 다양항 기능을 제어할 수 있다.
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if( msg.what == 0){
                //최초 체크
                progressBar.setVisibility(View.VISIBLE);
                //망 체크 : 연결된 망이 없으면 안내후 종료
                //해외인지 체크 : 접속한 클라이언트의 IP를 확인하여 진단
                //             : 내부 시나리오에 의해 처리
                //버전체크 : 업데이트 내역이 존재하는가?(하이브리드 기준)
                //        : 네이티브인 경우 자동 업데이트 혹은 강제업데이트 유도

                //중복 단말(로그인시도시) 체크

                //신한뱅킹으로 이동 ! 화면전환 담당 : Intent
                Intent intent = new Intent(MainActivity.this, WebmainActivity.class);
                startActivity(intent);
                //앱종료
                finish();

            }
        }
    };
}
