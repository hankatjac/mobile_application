package ca.hank.forclass1;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class InternetActivity extends AppCompatActivity implements View.OnClickListener {

    WebView webView;
    Button btnLoad;
    String url="https://www.yahoo.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet);
        init();
    }


    public void init(){
        webView = findViewById(R.id.webView);

        btnLoad = findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);
    }

    public void onClick(View v){

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient());

    }


    public void onBackPressed(){
        if (webView.canGoBack()){
            webView.goBack();
        }
        else{
            super.onBackPressed();
        }
    }
}
