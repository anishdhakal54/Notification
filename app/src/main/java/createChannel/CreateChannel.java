package createChannel;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

public class CreateChannel {
    Context context;
    public  final  static  String channel_1="Channel1";
    public final static  String channel_2="Channel2";

    public CreateChannel(Context context) {
        this.context = context;
    }

    public  void createChannel()
    {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            NotificationChannel channel1 = new NotificationChannel(channel_1,"Channel 1", NotificationManager.IMPORTANCE_HIGH);
            channel1.setDescription("this is channel 1");

            NotificationChannel channel2 = new NotificationChannel(channel_2,"Channel 2", NotificationManager.IMPORTANCE_LOW);
            channel1.setDescription("this is channel 2");

            NotificationManager notificationManager=context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel1);
            notificationManager.createNotificationChannel(channel2);
        }
    }
}
