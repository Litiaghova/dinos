package nntc.litia.dinosapprentice;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer sound_main_activity;

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }

    final String TAG = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sound_main_activity = MediaPlayer.create(this, R.raw.rain);
        sound_main_activity.setLooping(true);
        sound_main_activity.start();

        Log.d(TAG, "Активити загрузки создано");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading);

        /* Размещение игрового экрана по всему объему экрана (Начало) */
        Window w = getWindow();
        // Скрытие навигационных кнопок на устройстве
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                             | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        /* Размещение игрового экрана по всему объему экрана (Конец) */

        /* Таймер появления загрузочного экрана (Начало) */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, ActivityMenu.class);
                startActivity(i);
                finish();
            }
        },6*1000);
        /* Таймер появления загрузочного экрана (Конец) */
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Активити загрузки становится видимым");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "Активити загрузки получает фокус и переходит в состояние onResume");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Активити загрузки приостановленно и находится в состоянии onPause");
        if (sound_main_activity != null) {
            sound_main_activity.pause();
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Активити загрузки остановленно и находится в состоянии onStop");
        if (sound_main_activity != null) {
            sound_main_activity.stop();
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Активити загрузки уничтожено и находится в состоянии onDestroy");
        if (sound_main_activity != null) {
            sound_main_activity.stop();
        }
    }
}