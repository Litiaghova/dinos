package nntc.litia.dinosapprentice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Level_Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_menu);

        /* Размещение игрового экрана по всему объему (Начало) */
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /* Размещение игрового экрана по всему объему (Конец) */

        /* Обработка нажатия кнопки "назад" в меню (Начало) */
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    Intent intent = new Intent(Level_Menu.this, ActivityMenu.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
                // Конец конструкции
            }
        });
        /* Обработка нажатия кнопки "назад" в меню (Конец) */

        /* Кнопка для перехода на 1-первый уровень (Начало) */
        TextView textView1  = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Level_Menu.this, Level1.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
            }
        });
        /* Кнопка для перехода на 1-первый уровень (Конец) */

        /* Кнопка для перехода на 2-второй уровень (Начало) */
        TextView textView2  = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Level_Menu.this, Level2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
            }
        });
        /* Кнопка для перехода на 2-второй уровень (Конец) */

        /* Кнопка для перехода на 3-третий уровень (Начало) */

        /* Кнопка для перехода на 3-третий уровень (Конец) */

        /* Кнопка для перехода на 4-четвертый уровень (Начало) */

        /* Кнопка для перехода на 4-четвертый уровень (Конец) */
    }

    /* Обработка нажатия системной кнопки "назад" (Начало) */
    @Override
    public void onBackPressed(){
        // Начало конструкции
        try {
            Intent intent = new Intent(Level_Menu.this, ActivityMenu.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
        }
        // Конец конструкции
    }
    /* Обработка нажатия системной кнопки "назад" (Конец) */
}