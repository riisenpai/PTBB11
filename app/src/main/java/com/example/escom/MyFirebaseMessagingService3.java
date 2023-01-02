package com.example.escom;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.escom.databinding.ActivityHomeBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService3 extends FirebaseMessagingService {
    private static final String CHANNEL_ID = "test_kanal";
    private static final String TAG = "Service";
    private NotificationManagerCompat notifPermintaanSemdang;
    public MyFirebaseMessagingService3() {
    }

    @Override
    public void onNewToken(@NonNull String token) {
        Log.d(TAG, "Refreshed token: " + token);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        if (remoteMessage.getData().size() > 0) {
            displayNotification(remoteMessage.getNotification());
    }

}

    private void displayNotification(RemoteMessage.Notification notification) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Notifikasi";
            String description = "Notifikasi Mahasiswa Melakukan Permintaan Seminar dan Sidang";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            notifPermintaanSemdang.createNotificationChannel(channel);
        }
        Intent resultIntent = new Intent(this, PermintaanActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addNextIntentWithParentStack(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(0,
                        PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.mahasiswa)
                .setContentTitle("Info Dari Mahasiswa")
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Mahasiswa melakukan Permintaan Seminar dan Sidang"))
                .setContentIntent(resultPendingIntent)
                .addAction(R.drawable.mahasiswa, "Lihat", resultPendingIntent)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        notifPermintaanSemdang.notify(113, builder.build());
    }
    }