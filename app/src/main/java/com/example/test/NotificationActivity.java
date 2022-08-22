package com.example.test;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.app.PendingIntent.FLAG_UPDATE_CURRENT;

public class NotificationActivity extends AppCompatActivity {

    private int REQUEST_ACT = 1;

    String s1,s2,s3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        Button nbtn = (Button) findViewById(R.id.addNtfButton);

        nbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotificationActivity.this, PopupNotificationActivity.class);
                startActivityForResult(intent,REQUEST_ACT);
            }
        });


    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == REQUEST_ACT) {
            if(resultCode == RESULT_OK) {
                s1 = data.getStringExtra("disaster");
                s2 = data.getStringExtra("damage");
                s3 = data.getStringExtra("location");

                TextView disasterText = (TextView) findViewById(R.id.text_NotificationDisaster);
                TextView damageText = (TextView) findViewById(R.id.text_NotificationDamage);
                TextView locationText = (TextView) findViewById(R.id.text_NotificationLocation);

                disasterText.setText(s1);
                damageText.setText(s2);
                locationText.setText(s3);

                sendNotification();

            }
        }


    }
    public void sendNotification() {

        NotificationCompat.Builder builder;
        String channelId="channel";
        String channelName = "Channel Name";
        int importance = NotificationManager.IMPORTANCE_LOW;
        Intent intent1 = new Intent(NotificationActivity.this.getApplicationContext(),MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingNotificationIntent = PendingIntent.getActivity(NotificationActivity.this,0,intent1,PendingIntent.FLAG_UPDATE_CURRENT);


        NotificationManager notificationManager = (NotificationManager) this.getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(channelId,channelName,importance);
            notificationManager.createNotificationChannel(mChannel);

            builder = new NotificationCompat.Builder(this,channelId);

        }
        else
        {
            builder = new NotificationCompat.Builder(this);
        }

        builder .setSmallIcon(R.drawable.surviver)
                .setWhen(System.currentTimeMillis())
                .setContentTitle("서바이버 주변알리미")
                .setContentText(s3 + "에서 " + s1 + "발생으로 " + s2)
                .setContentIntent(pendingNotificationIntent)
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setVibrate(new long[]{1, 1000});


        notificationManager.notify(1,builder.build());

    }

}

