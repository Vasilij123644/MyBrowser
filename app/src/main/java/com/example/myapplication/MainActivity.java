package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private WebView WebView;
    private EditText EditText;
    private final String defaultUrl = "https://google.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView = (WebView) findViewById(R.id.WebView);
        EditText = (EditText) findViewById(R.id.editTextTextPersonName1);
        WebSettings ws = WebView.getSettings();
        ws.setJavaScriptEnabled(true);
        WebView.loadUrl(defaultUrl);
        WebView.setWebViewClient(new WebViewClient());
        EditText.setText(defaultUrl);
    }
    @Override
    public void onBackPressed() {
        if (WebView.canGoBack())
            WebView.goBack();
        else
            super.onBackPressed();
    }

    public void ClickButton(View view) {
        if(Patterns.WEB_URL.matcher(EditText.getText()).matches() == true)
            WebView.loadUrl(EditText.getText().toString());
        else
            WebView.loadUrl(defaultUrl + "search?q=" + EditText.getText().toString());
    }
}