package com.example.notfication_control;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button b;

    NotificationManager notificationManager;
    NotificationChannel notificationChannel;
    Notification.Builder builder;
    private final String channelId = "my_channel_01";
    private final String description = "Test notification";
    private static final int NOTIFICATION_PERMISSION_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.button);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, After_notification.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(
                        MainActivity.this,
                        0,
                        i,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

                @SuppressLint("RemoteViewLayout")
                RemoteViews contentView = new RemoteViews(getPackageName(), R.layout.activity_after_notification);

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    notificationChannel = new NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH);

                    notificationChannel.enableLights(true);                         //Optional
                    notificationChannel.setLightColor(Color.GREEN);                 //Optional
                    notificationChannel.enableVibration(false);                     //Optional

                    notificationManager.createNotificationChannel(notificationChannel);

                    builder = new Notification.Builder(MainActivity.this, channelId)
                            .setContentTitle("Hello")
                            .setContentText("Please click on this notification")
                            .setSmallIcon(R.drawable.ic_launcher_background)        //Optional
                            .setContentIntent(pendingIntent);

                }else {
                    builder = new Notification.Builder(MainActivity.this, channelId)
                            .setContentTitle("Hello")
                            .setContentText("Please click on this notification")
                            .setSmallIcon(R.drawable.ic_launcher_background)        //Optional
                            .setContentIntent(pendingIntent);
                }

                notificationManager.notify(1234, builder.build());
            }
        });
    }
}