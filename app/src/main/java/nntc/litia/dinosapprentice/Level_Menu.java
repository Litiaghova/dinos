package nntc.litia.dinosapprentice;

import android.content.Intent;
import android.content.SharedPreferences;
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

        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
        final int level = save.getInt("Level", 1);

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
                    if(level>=1){
                    Intent intent = new Intent(Level_Menu.this, Plot_level1_1.class);
                    startActivity(intent);
                    finish();}else{}
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
                    if(level>=2){
                    Intent intent = new Intent(Level_Menu.this, Level2.class);
                    startActivity(intent);
                    finish();}else{}
                }catch (Exception e){
                }
            }
        });
        /* Кнопка для перехода на 2-второй уровень (Конец) */

        /* Кнопка для перехода на 3-третий уровень (Начало) */
        TextView textView3  = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{if(level>=3){
                    Intent intent = new Intent(Level_Menu.this, Level3.class);
                    startActivity(intent);
                    finish();}else{}
                }catch (Exception e){
                }
            }
        });
        /* Кнопка для перехода на 3-третий уровень (Конец) */

        /* Кнопка для перехода на 4-четвертый уровень (Начало) */
        TextView textView4  = (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{if(level>=4){
                    Intent intent = new Intent(Level_Menu.this, Level4.class);
                    startActivity(intent);
                    finish();}else{}
                }catch (Exception e){
                }
            }
        });
        /* Кнопка для перехода на 4-четвертый уровень (Конец) */

        /* Кнопка для перехода на 5-четвертый уровень (Начало) */
        TextView textView5  = (TextView)findViewById(R.id.textView5);
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{if(level>=5){
                    Intent intent = new Intent(Level_Menu.this, Level5.class);
                    startActivity(intent);
                    finish();}else{}
                }catch (Exception e){
                }
            }
        });
        /* Кнопка для перехода на 5-четвертый уровень (Конец) */

        /* Кнопка для перехода на 6-четвертый уровень (Начало) */
        TextView textView6  = (TextView)findViewById(R.id.textView6);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{if(level>=6){
                    Intent intent = new Intent(Level_Menu.this, Level6.class);
                    startActivity(intent);
                    finish();}else{}
                }catch (Exception e){
                }
            }
        });
        /* Кнопка для перехода на 6-четвертый уровень (Конец) */

        /* Кнопка для перехода на 7-четвертый уровень (Начало) */
        TextView textView7  = (TextView)findViewById(R.id.textView7);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{if(level>=7){
                    Intent intent = new Intent(Level_Menu.this, Level7.class);
                    startActivity(intent);
                    finish();}else{}
                }catch (Exception e){
                }
            }
        });
        /* Кнопка для перехода на 7-четвертый уровень (Конец) */

        /* Кнопка для перехода на 8-четвертый уровень (Начало) */
        TextView textView8  = (TextView)findViewById(R.id.textView8);
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{if(level>=8){
                    Intent intent = new Intent(Level_Menu.this, Level8.class);
                    startActivity(intent);
                    finish();}else{}
                }catch (Exception e){
                }
            }
        });
        /* Кнопка для перехода на 8-четвертый уровень (Конец) */

        final int [] x={
               R.id.textView1,
                R.id.textView2,
                R.id.textView3,
                R.id.textView4,
                R.id.textView5,
                R.id.textView6,
                R.id.textView7,
                R.id.textView8,
        };

        /* Цикл, который расставляет числа по порядку - начало */
        for (int i=1; i<level; i++){
            TextView tv = findViewById(x[i]);
            tv.setText(""+(i+1));
        }
        /* Цикл, который расставляет числа по порядку - конец */
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