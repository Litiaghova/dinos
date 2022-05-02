package nntc.litia.dinosapprentice;

import android.content.Intent;
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

public class Level5plot1 extends AppCompatActivity {

    static int j = 0;

    private MediaPlayer sound_plot_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1_plot1);

        sound_plot_2 = MediaPlayer.create(this, R.raw.history_sound_5_lvl);
        sound_plot_2.start();

        Log.d(TAG, "Активити 5 загрузки создано");

        /* Переключение фонового изображения по таймеру (Начало) */
        Integer[] i = {
                R.drawable.lvl5_1plot,
                R.drawable.lvl5_2plot,
                R.drawable.lvl5_3plot,
                R.drawable.lvl5_4plot,
                R.drawable.lvl5_5plot,
                R.drawable.lvl5_6plot,
                R.drawable.lvl5_7plot,

        };

        ImageView iview = findViewById(R.id.imageView_message_image);

        j=0;
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            public void run() {
                if(j>=i.length)
                    return;
                //int randomNum = r.nextInt(7);
                iview.setImageResource(i[j]);
                j++;
                handler.postDelayed(this, 8600);
            }
        });
        /* Переключение фонового изображения по таймеру (Конец) */

        /* Размещение игрового экрана по всему объему (Начало) */
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                             | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        /* Размещение игрового экрана по всему объему (Конец) */

        /* Обработка нажатия кнопки "назад" в меню (Начало) */
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    Intent intent = new Intent(Level5plot1.this, Level_Menu.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
                // Конец конструкции
            }
        });
        /* Обработка нажатия кнопки "назад" в меню (Конец) */

        /* Обработка нажатия кнопки "назад" в меню (Начало) */
        Button button_skip = (Button) findViewById(R.id.button_skip);
        button_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    Intent intent = new Intent(Level5plot1.this, Level5.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
                // Конец конструкции
            }
        });
        /* Обработка нажатия кнопки "назад" в меню (Конец) */
    }

    @Override
    protected void onStart() {

        super.onStart();
        Log.d(TAG, "Активити 5 становится видимым");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "Активити 5 получает фокус и переходит в состояние onResume");

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Активити 5 приостановленно и находится в состоянии onPause");
        if (sound_plot_2 != null) {
            sound_plot_2.pause();
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Активити 5 остановленно и находится в состоянии onStop");
        if (sound_plot_2 != null) {
            sound_plot_2.stop();
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Активити 5 уничтожено и находится в состоянии onDestroy");
        if (sound_plot_2 != null) {
            sound_plot_2.stop();
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
            Intent intent = new Intent(Level5plot1.this, Level_Menu.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
        }
        // Конец конструкции
    }
    /* Обработка нажатия системной кнопки "назад" (Конец) */
}