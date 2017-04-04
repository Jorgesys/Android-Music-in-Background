package com.jorgesys.musicbackground;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by jorgesys on 02/02/2015.
 */

/* Add declaration of this service into the AndroidManifest.xml inside application tag*/

public class BackgroundSoundService extends Service {

    private static final String TAG = "BackgroundSoundService";
    MediaPlayer player;

    public IBinder onBind(Intent arg0) {
        Log.i(TAG, "onBind()" );
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        player = MediaPlayer.create(this, R.raw.jorgesys_song);
        player.setLooping(true); // Set looping
        player.setVolume(100,100);
        Toast.makeText(this, "Service started...", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreate() , service started...");

    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        player.start();
        return Service.START_STICKY;
    }

    public IBinder onUnBind(Intent arg0) {
        Log.i(TAG, "onUnBind()");
        return null;
    }

    public void onStop() {
        Log.i(TAG, "onStop()");
    }
    public void onPause() {
        Log.i(TAG, "onPause()");
    }
    @Override
    public void onDestroy() {
        player.stop();
        player.release();
        Toast.makeText(this, "Service stopped...", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "onCreate() , service stopped...");
    }

    @Override
    public void onLowMemory() {
        Log.i(TAG, "onLowMemory()");
    }
}
