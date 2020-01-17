package com.e.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import createChannel.CreateChannel;

public class MainActivity extends AppCompatActivity {
private  Button btn1, btn2;
private int i=0;
private NotificationManagerCompat notificationManagerCompat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationManagerCompat=NotificationManagerCompat.from(this);
        CreateChannel channel=new CreateChannel(this);
        channel.createChannel();

        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);


        //btn1 click listener
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                displayNotify1();

            }
        });

        //btn2  click listener
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i=i+1;
                displayNotify2();
            }
        });
    }
    private void displayNotify1()
    {
        Notification notification= new NotificationCompat.Builder(this,CreateChannel.channel_1)
                .setSmallIcon(R.drawable.ic_adb_black_24dp)
                .setContentTitle("1st Notification")
                .setContentText("this is first notification")
                .setCategory(NotificationCompat.CATEGORY_EVENT)
                .build();
        notificationManagerCompat.notify(i,notification);

    }

    private void displayNotify2()
    {
        Notification notification= new NotificationCompat.Builder(this,CreateChannel.channel_2)
                .setSmallIcon(R.drawable.ic_album_black_24dp)
                .setContentTitle("2nd Notification")
                .setContentText("this is second notification")
                .setCategory(NotificationCompat.CATEGORY_EVENT)
                .build();
        notificationManagerCompat.notify(i,notification);

    }
}
