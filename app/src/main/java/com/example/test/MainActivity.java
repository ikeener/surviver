package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onButtonClickLogin(View view) {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    public void onButtonClickSettings(View view){
        Intent intent = new Intent (this,SettingsActivity.class);
        startActivity(intent);
    }
    public void onButtonClickFire(View view) {
        Intent intent = new Intent (this, FireActivity.class);
        startActivity(intent);
    }
    public void onButtonClickTyphoon(View view){
        Intent intent = new Intent (this,TyphoonActivity.class);
        startActivity(intent);
    }
    public void onButtonClickEarthquake(View view){
        Intent intent = new Intent (this,EarthquakeActivity.class);
        startActivity(intent);
    }
    public void onButtonClickLandslide(View view){
        Intent intent = new Intent (this,LandslideActivity.class);
        startActivity(intent);
    }
    public void onButtonClickNotification(View view) {
        Intent intent = new Intent (this, NotificationActivity.class);
        startActivity(intent);
    }

}
