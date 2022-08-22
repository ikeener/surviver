package com.example.test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class FireActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);
    }

    public void onButtonClickHospital(View view)
    {
        Intent intent = new Intent(this, HospitalActivity.class);
        startActivity(intent);
    }

    public void onButtonClickRefuge(View view)
    {
        Intent intent = new Intent(this, RefugeActivity.class);
        startActivity(intent);
    }
}
