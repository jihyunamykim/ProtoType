package com.example.a60029511.firebasetest;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import static android.webkit.WebSettings.LOAD_NO_CACHE;

/**
 * 신한 모바일 웹을 직접 연결
 */
public class WebmainActivity extends AppCompatActivity {
    WebView webView;
    //백키 처리
    int flag = 0;

    @Override
    public void onBackPressed() {
        if(webView.canGoBack())
            webView.goBack();
        else
            if(flag == 0){
                Toast.makeText(this,"한번 더 뒤로가기를 누르시면 종료됩니다.", Toast.LENGTH_SHORT).show();
                flag++;
                handler.sendEmptyMessageDelayed(0,1000*2);
            }
            else{
                super.onBackPressed();
            }
    }

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            flag = 0;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webmain);
        Log.i("SH","[토큰]="+ FirebaseInstanceId.getInstance().getToken());
        webView = (WebView)findViewById(R.id.webView);
        //웹뷰 설정 부분
        //프레임웍을 사용할 경우 내부적으로 세팅이 된다.
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                return super.onJsAlert(view, url, message, result);
            }

            @Override
            public boolean onJsConfirm(WebView view, String url, String message, JsResult result) {
                return super.onJsConfirm(view, url, message, result);
            }

            @Override
            public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, JsPromptResult result) {
                return super.onJsPrompt(view, url, message, defaultValue, result);
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setCacheMode(LOAD_NO_CACHE);
        webView.getSettings().setDatabaseEnabled(true); //모바일 데이터베이스를 허용하겠다
        webView.loadUrl("https://m.shinhan.com");

    }
}
