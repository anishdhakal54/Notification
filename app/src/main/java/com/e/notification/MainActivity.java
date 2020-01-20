package com.e.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
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
// Create an explicit intent for an Activity in your app
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification= new NotificationCompat.Builder(this,CreateChannel.channel_1)
                .setSmallIcon(R.drawable.ic_adb_black_24dp)
                .setContentTitle("1st Notification")
                .setContentText("this is first notification")
                .setCategory(NotificationCompat.CATEGORY_EVENT).setContentIntent(pendingIntent)
            . addAction(R.drawable.ic_snooze, "reply",
            pendingIntent).addAction(R.drawable.ic_snooze,"Test",pendingIntent)
                .build();
        notificationManagerCompat.notify(i,notification);

    }

    private void displayNotify2()
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification= new NotificationCompat.Builder(this,CreateChannel.channel_2)
                .setSmallIcon(R.drawable.ic_album_black_24dp)
                .setContentTitle("2nd Notification")
                .setContentText("this is second notification")
                .setCategory(NotificationCompat.CATEGORY_EVENT).setCategory(NotificationCompat.CATEGORY_EVENT)
                .setContentIntent(pendingIntent)
                . addAction(R.drawable.ic_snooze, "reply",
                        pendingIntent).addAction(R.drawable.ic_snooze,"Test",pendingIntent)
                .build();
        notificationManagerCompat.notify(i,notification);

    }
}
