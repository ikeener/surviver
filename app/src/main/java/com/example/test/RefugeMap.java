package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class RefugeMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refuge_map);

        WebView m = (WebView) findViewById(R.id.web);
        WebSettings webSettings =m.getSettings();
        webSettings.setJavaScriptEnabled(true);
        m.setWebViewClient(new WebViewClient());
        Intent intent = getIntent();

        String name = intent.getExtras().getString("rname");
        m.loadUrl("https://www.google.com/maps/search/" +  name);
    }
}
