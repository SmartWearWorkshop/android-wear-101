package com.mokoversity.mywearapp;

import android.app.Activity;
import android.app.Notification;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.NotificationCompat.WearableExtender;

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        two();
    }

    private void zero() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Zero")
                .setContentText("You're at step zero.")
                .setSmallIcon(R.drawable.bg_eliza);

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        mNotificationManager.notify(0x07, builder.build());
    }

    // set background on wearbale device
    private void one() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Onw")
                .setContentText("You're at step one.")
                .setSmallIcon(R.drawable.bg_eliza)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.bg_eliza));

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0x08, builder.build());
    }


    // Add second page
    private void two() {
        // main notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Two")
                .setContentText("You're at step two.")
                .setSmallIcon(R.drawable.bg_eliza)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.bg_eliza));

        // second page
        NotificationCompat.Builder secondPageNotification = new NotificationCompat.Builder(this)
                .setContentTitle("Second Page")
                .setContentText("This is second page");

        // Add second page with wearable extender and extend the main notification
        Notification notification = new WearableExtender()
                .addPage(secondPageNotification.build())
                .extend(builder)
                .build();

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(0x09, notification);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
