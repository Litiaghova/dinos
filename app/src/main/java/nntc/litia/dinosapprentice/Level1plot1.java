package nntc.litia.dinosapprentice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Level1plot1 extends AppCompatActivity {
    // Переменаня для переключения изображения по таймеру
    static int j = 0;
    // Переменные для хранения звука уровня
    private MediaPlayer sound_plot_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1_plot1);

        sound_plot_1 = MediaPlayer.create(this, R.raw.history_sound_1_lvl);
        sound_plot_1.start();

        Log.d(TAG, "Активити загрузки создано");

        Integer[] i = {
                R.drawable.plot1,
                R.drawable.plot2,
                R.drawable.plot3,
                R.drawable.plot4,
                R.drawable.plot5,
                R.drawable.plot6,
                R.drawable.plot7,
                R.drawable.plot8,
                R.drawable.plot9,
                R.drawable.plot11,

        };

        ImageView iview = findViewById(R.id.imageView_message_image);
        /* Переключение фонового изображения по таймеру (Начало) */
        j=0;
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                if(j>=i.length)
                    return;
                iview.setImageResource(i[j]);
                j++;
                handler.postDelayed(this, 13000);
            }
        });
        /* Переключение фонового изображения по таймеру (Конец) */

        /* Размещение игрового экрана по всему объему (Начало) */
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                             | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        /* Размещение игрового экрана по всему объему (Конец) */

        /* Кнопка "назад" из загрузки в меню (Начало) */
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    Intent intent = new Intent(Level1plot1.this, Level_Menu.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
                // Конец конструкции
            }
        });
        /* Кнопка "назад" из загрузки в меню (Конец) */

        /* Кнопка "пропустить" из загрузки к уровню (Начало) */
        Button button_skip = (Button) findViewById(R.id.button_skip);
        button_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    Intent intent = new Intent(Level1plot1.this, Level1.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
                // Конец конструкции
            }
        });
        /* Кнопка "пропустить" из загрузки к уровню (Конец) */
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
        if (sound_plot_1 != null) {
            sound_plot_1.pause();
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Активити загрузки остановленно и находится в состоянии onStop");
        if (sound_plot_1 != null) {
            sound_plot_1.stop();
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Активити загрузки уничтожено и находится в состоянии onDestroy");
        if (sound_plot_1 != null) {
            sound_plot_1.stop();
        }
    }

    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }

    final String TAG = "lifecycle";

    /* Обработка нажатия системной кнопки "назад" (Начало) */
    @Override
    public void onBackPressed(){
        // Начало конструкции
        try {
            Intent intent = new Intent(Level1plot1.this, Level_Menu.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
        }
        // Конец конструкции
    }
    /* Обработка нажатия системной кнопки "назад" (Конец) */
}