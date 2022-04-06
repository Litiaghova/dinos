package nntc.litia.dinosapprentice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class ActivityMenu extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        /* Размещение игрового экрана по всему объему (Начало) */
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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