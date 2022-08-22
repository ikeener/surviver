package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class HospitalMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_map);

        Intent intent = getIntent();
        String name = intent.getExtras().getString("hname");

        WebView m = (WebView) findViewById(R.id.web);
        WebSettings webSettings =m.getSettings();
        webSettings.setJavaScriptEnabled(true);
        m.setWebViewClient(new WebViewClient());
        m.loadUrl("https://www.google.com/maps/search/" + name);

    }
}
