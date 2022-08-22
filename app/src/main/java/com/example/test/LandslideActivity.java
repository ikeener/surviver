package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LandslideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landslide);
    }

    public void onButtonClickRefuge(View view)
    {
        Intent intent = new Intent(this, RefugeActivity.class);
        startActivity(intent);
    }
}