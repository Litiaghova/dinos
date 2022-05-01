package nntc.litia.dinosapprentice;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class ActivityMenu extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    private MediaPlayer sound_activity_menu;

    final String TAG = "lifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        sound_activity_menu = MediaPlayer.create(this, R.raw.song1);
        sound_activity_menu.setLooping(true);
        sound_activity_menu.start();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /* Размещение игрового экрана по всему объему (Начало) */
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                             | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        /* Размещение игрового экрана по всему объему (Конец) */

        /* Обработка нажатия кнопки "начать" в меню (Начало) */
        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    Intent intent = new Intent(ActivityMenu.this, Level_Menu.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
                // Конец конструкции
            }
        });
        /* Обработка нажатия кнопки "начать" в меню (Конец) */

        /* Обработка нажатия кнопки "выход" в меню (Начало) */
        Button buttonLeave = (Button) findViewById(R.id.buttonLeave);
        buttonLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    finish();
                }catch (Exception e){
                }
                // Конец конструкции
            }
        });
        /* Обработка нажатия кнопки "выход" в меню (Конец) */
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Активити главного меню становится видимым");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG, "Активити главного меню получает фокус и переходит в состояние onResume");
        /* Размещение игрового экрана по всему объему (Начало) */
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                             | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        /* Размещение игрового экрана по всему объему (Конец) */

    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG, "Активити главного меню приостановленно и находится в состоянии onPause");
        if (sound_activity_menu != null) {
            sound_activity_menu.pause();
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG, "Активити главного меню остановленно и находится в состоянии onStop");
        if (sound_activity_menu != null) {
            sound_activity_menu.stop();
        }
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "Активити главного меню уничтожено и находится в состоянии onDestroy");
        if (sound_activity_menu != null) {
            sound_activity_menu.stop();
        }
    }

    /* Выход из игры системной кнопкой "назад" (Начало) */
    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
           backToast = Toast.makeText(getBaseContext(), "Нажмите ещё раз, чтобы выйти из игры", Toast.LENGTH_SHORT);
           backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
    /* Выход из игры системной кнопкой "назад" (Конец) */
}