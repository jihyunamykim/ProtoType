package com.example.a60029511.uitest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

//가장 먼저 구동되는 화면(근거 필터)

public class MainActivity extends AppCompatActivity {
    EditText uid;
    EditText upw;

    //화면을 구성, 많은 연산을 수행하면 않된다 -> 사용자가 앱의 화면을 늦게 봄
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //xml에 배치된 위젯 or 요소들을자바 코드에거 접근하기 위해 아이디를 넣어서 해당 객체를 획득한다
        uid = (EditText)findViewById(R.id.uid);
        upw = (EditText)findViewById(R.id.upw);
    }
    //공인 인증서 로그인 클릭하면 호출!!
    public void onAuthLogin(View view) {
        Toast.makeText(this, "공인인증서 로그인을 클릭하셨습니다.", Toast.LENGTH_SHORT).show();
    }
    //ID와 비밀번호를 입력하고 로그인 클릭하면 호출!!
    public void onLogin(View view) {
        //1.값체크
        if(TextUtils.isEmpty(uid.getText().toString())){
            uid.setError("이용자아이디는 영문,숫자,대소문자 구분 없이 4~16자 입니다.");
            return;
        }
        if(TextUtils.isEmpty(upw.getText().toString())){
            upw.setError("비밀번호를 입력해주세요");
            return;
        }
        Toast.makeText(this, "로그인되셨습니다.", Toast.LENGTH_SHORT).show();
    }
}
