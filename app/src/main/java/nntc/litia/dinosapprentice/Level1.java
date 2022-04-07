package nntc.litia.dinosapprentice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class Level1 extends AppCompatActivity {

    // Переменная - это место в памяти, в котором будет хранится информация
    // public - указывает, что доступ к переменной будет открытым
    public int numLeft; // Переменная для работы с левой картинкой + текст
    public int numRight; // Переменная для работы с правой картинкой + текст
    // Выделение памяти для работы массива
    Array array = new Array();
    // Генератор случайности
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal_level);

        /* Установка текста из файла (Начало) */
        // Создание переменной для работы с текстом
        TextView text_levels = findViewById(R.id.text_levels);
        // Установка текста из файла "string"
        text_levels.setText(R.string.level1);
        /* Установка текста из файла (Конец) */

        // Код обращения к картинке по id (Левая)
        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        // Код для скругления углов этой картинки
        img_left.setClipToOutline(true);

        // Код обращения к картинке по id (Правая)
        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        // Код для скругления углов этой картинки
        img_right.setClipToOutline(true);

        // Путь к левой части уровня (Текст)
        final TextView text_left = findViewById(R.id.text_left);
        // Путь к правой части уровня (Текст)
        final TextView text_right = findViewById(R.id.text_right);

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

        /* Работа 1-го уровня, левой стороны (Начало) */
        // Генерация случайного числа от 0-9
        numLeft = random.nextInt(10);
        // Вызов картинки из массива
        img_left.setImageResource(array.images1[numLeft]);
        // Вызов текста из массива
        text_left.setText(array.texts1[numLeft]);
        /* Работа 1-го уровня, левой стороны (Конец) */

        /* Работа 1-го уровня, правой стороны (Начало) */
        // Генерация случайного числа от 0-9
        numRight = random.nextInt(10);

        // Цикл, с предусловием, проверяющий равенсто чисел (Начало)
        // Пока левое число равно правому, генерировать новое правое число
        while (numLeft == numRight){
            numRight = random.nextInt(10);
        }
        // Вызов картинки из массива
        img_right.setImageResource(array.images1[numRight]);
        // Вызов текста из массива
        text_right.setText(array.texts1[numRight]);
        // Цикл, с предусловием, проверяющий равенсто чисел (Конец)

        /* Работа 1-го уровня, правой стороны (Конец) */
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