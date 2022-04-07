package nntc.litia.dinosapprentice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;


public class Level1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal_level);

        // Код обращения к картинке по id (Левая)
        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        // Код для скругления углов этой картинки
        img_left.setClipToOutline(true);

        // Код обращения к картинке по id (Правая)
        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        // Код для скругления углов этой картинки
        img_right.setClipToOutline(true);

        /* Размещение игрового экрана по всему объему (Начало) */
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /* Размещение игрового экрана по всему объему (Конец) */

        /* Обработка нажатия кнопки "назад" (Начало) */
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    // Вернуться к выбору уровня (Начало)
                    Intent intent = new Intent(Level1.this, Level_Menu.class); // СОздание намерения перехода
                    startActivity(intent); // Запуск намерения
                    finish(); // Закрыть этот класс
                    // Вернуться к выбору уровня (Конец)
                }catch (Exception e){
                }
                // Конец конструкции
            }
        });
        /* Обработка нажатия кнопки "назад" (Конец) */
    }

    /* Обработка нажатия системной кнопки "назад" (Начало) */
    @Override
    public void onBackPressed(){
        // Начало конструкции
        try {
            Intent intent = new Intent(Level1.this, Level_Menu.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
        }
        // Конец конструкции


    }
    /* Обработка нажатия системной кнопки "назад" (Конец) */
}