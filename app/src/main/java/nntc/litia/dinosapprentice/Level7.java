package nntc.litia.dinosapprentice;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class Level7 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    // Переменная - это место в памяти, в котором будет хранится информация
    // public - указывает, что доступ к переменной будет открытым
    public int numLeft; // Переменная для работы с левой картинкой + текст
    public int numRight; // Переменная для работы с правой картинкой + текст
    // Выделение памяти для работы массива
    Array array = new Array();
    // Генератор случайности
    Random random = new Random();
    // Переменная для счётчика правильных ответов
    public int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal_level);

        /* Установка текста из файла (Начало) */
        // Создание переменной для работы с текстом
        TextView text_levels = findViewById(R.id.text_levels);
        // Установка текста из файла "string"
        text_levels.setText(R.string.level7);
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

        /* Вызов диалогового окна 2-го уровня (Начало) */

        dialog = new Dialog(this); // Создание нового диалогового окна
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // Скрытие заголовка диалогового окна
        dialog.setContentView(R.layout.previewdialog); // Путь к макету даилогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // Прозрачный фон
        dialog.setCancelable(false); // Окно нальзя закрыть системной кнопкой назад

        // Установка картинки в диалоговое окно (Начало)
        ImageView previewimg = (ImageView)dialog.findViewById(R.id.previewimg);
        previewimg.setImageResource(R.drawable.dialog2);
        // Установка картинки в диалоговое окно (Конец)

        // Установка задания в диалоговое окно (Начало)
        TextView textdescription = (TextView)dialog.findViewById(R.id.text1);
        textdescription.setText(R.string.dialogtext7_1);
        // Установка задания в диалоговое окно (Конец)

        /* Кнопка закрытия диалогового окна - Х (Начало) */
        TextView btnClose = (TextView)dialog.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Обрабатывание нажатия кнопки (Начало) */
                try {
                    // Вернуться назад к выбору уровня (Начало)
                    // Intent - намерение
                    Intent intent = new Intent(Level7.this, Level_Menu.class);
                    // Запуск намериния
                    startActivity(intent);
                    finish();
                    // Вернуться назад к выбору уровня (Конец)
                } catch (Exception e){

                }
                // Закрытие диалогового окна
                dialog.dismiss();
                /* Обрабатывание нажатия кнопки (Конец) */
            }
        });
        /* Кнопка закрытия диалогового окна - Х (Конец) */

        /* Кнопка продолжить - диалоговое окно (Начало) */
        Button btndialogcontinue = (Button)dialog.findViewById(R.id.btndialogcontinue);
        btndialogcontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Закрытие диалогового окна
               dialog.dismiss();
            }
        });
        /* Кнопка продолжить - диалоговое окно (Конец) */

        dialog.show(); // Показ диалогового окна

        /* Вызов диалогового окна 2-го уровня (Конец) */

        // -----------------------------------------
        dialogEnd = new Dialog(this); // Создание нового диалогового окна
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE); // Скрытие заголовка диалогового окна
        dialogEnd.setContentView(R.layout.dialogend); // Путь к макету даилогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT)); // Прозрачный фон
        dialogEnd.setCancelable(false); // Окно нальзя закрыть системной кнопкой назад

        /* Текст в конце на диалоговм окне (Начало) */
        TextView textDescriptionEnd = (TextView)dialogEnd.findViewById(R.id.text2);
        textDescriptionEnd.setText(R.string.dialogtext7_2);
        /* Текст в конце на диалоговм окне (Конец) */

        /* Кнопка закрытия диалогового окна - Х (Начало) */
        TextView btnClose2 = (TextView)dialogEnd.findViewById(R.id.btnClose);
        btnClose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Обрабатывание нажатия кнопки (Начало) */
                try {
                    // Вернуться назад к выбору уровня (Начало)
                    // Intent - намерение
                    Intent intent = new Intent(Level7.this, Level_Menu.class);
                    // Запуск намериния
                    startActivity(intent);
                    finish();
                    // Вернуться назад к выбору уровня (Конец)
                } catch (Exception e){

                }
                // Закрытие диалогового окна
                dialogEnd.dismiss();
                /* Обрабатывание нажатия кнопки (Конец) */
            }
        });
        /* Кнопка закрытия диалогового окна - Х (Конец) */

        /* Кнопка продолжить - диалоговое окно (Начало) */
        Button btndialogcontinue2 = (Button)dialogEnd.findViewById(R.id.btndialogcontinue);
        btndialogcontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent intent = new Intent(Level7.this, Level8.class);
                    startActivity(intent);
                    finish();
                }
                catch (Exception e){

                }
                // Закрытие диалогового окна
                dialogEnd.dismiss();
            }
        });
        /* Кнопка продолжить - диалоговое окно (Конец) */


        // -----------------------------------------

        /* Обработка нажатия кнопки "назад" (Начало) */
        Button button_back = (Button) findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    // Вернуться к выбору уровня (Начало)
                    Intent intent = new Intent(Level7.this, Level_Menu.class); // СОздание намерения перехода
                    startActivity(intent); // Запуск намерения
                    finish(); // Закрыть этот класс
                    // Вернуться к выбору уровня (Конец)
                }catch (Exception e){
                }
                // Конец конструкции
            }
        });
        /* Обработка нажатия кнопки "назад" (Конец) */

        /* Массив для прогресса игры-уровня (Начало) */
        final int[] progress  = {
                R.id.point1,
                R.id.point2,
                R.id.point3,
                R.id.point4,
                R.id.point5,
                R.id.point6,
                R.id.point7,
                R.id.point8,};
        /* Массив для прогресса игры-уровня (Конец) */

        /* Подключение анимации (Начало) */
        final Animation a = AnimationUtils.loadAnimation(Level7.this, R.anim.alpha);
        /* Подключение анимации (Конец) */

        /* Подготовка работы 1-го уровня, левой стороны (Начало) */
        // Генерация случайного числа
        numLeft = random.nextInt(12);
        // Вызов картинки из массива
        img_left.setImageResource(array.images7[numLeft]);
        // Вызов текста из массива
        text_left.setText(array.texts7[numLeft]);
        /* Подготовка работы 1-го уровня, левой стороны (Конец) */

        /* Подготовка работы 1-го уровня, правой стороны (Начало) */
        // Генерация случайного числа
        numRight = random.nextInt(12);

        // Цикл, с предусловием, проверяющий равенсто чисел (Начало)
        // Пока левое число равно правому, генерировать новое правое число
        while (array.strong7[numLeft]==array.strong7[numRight]){
            numRight = random.nextInt(12);
        }
        // Цикл, с предусловием, проверяющий равенсто чисел (Конец)
        // Вызов картинки из массива
        img_right.setImageResource(array.images7[numRight]);
        // Вызов текста из массива
        text_right.setText(array.texts7[numRight]);
        /* Подготовка работы 1-го уровня, правой стороны (Конец) */

        /* Обработка нажатия на левую картинку (Начало) */
        // Выбор именно setOnTouchListener, потому что нужно обработать два состояния, начало и конец прикосновения
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            // MotionEvent определяет касание пальцем экрана
            public boolean onTouch(View view, MotionEvent event) {
                /* Условие касания картинки (Начало) */
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                // Касание картинки - приложить палец (Начало)

                    // Блокировка правой картинки, если коснулись левой
                    img_right.setEnabled(false);

                    // Условие показателя верной-неверной картинки
                    if (array.strong7[numLeft]>array.strong7[numRight]){
                        // Если левое число больше правого, показать картинку "верно"
                        img_left.setImageResource(R.drawable.img_true);
                    } else {
                        // Если левое число меньше правого, показать картинку "не верно"
                        img_left.setImageResource(R.drawable.img_folse);
                    }
                    // Касание картинки - приложить палец (Конец)

                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    // Не касание картинки - отпустить палец (Начало)
                    if (array.strong7[numLeft]>array.strong7[numRight]){
                        // Если левое число больше правого
                        if(count<8){
                            count=count+1;
                        }

                        // Закрашивание прогресса серым цветом (Начало)
                        for(int i=0; i<8; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        // Закрашивание прогресса серым цветом (Конец)

                        // Закрашивание прогресса зеленым цветом и определение правильных ответов (Начало)
                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        // Закрашивание прогресса зеленым цветом и определение правильных ответов (Конец)
                    } else {
                        // Если левое число меньше правого
                        /* Игра не может уходить в минус, поэтому если игрок ошибается при нуле, то ноль остается таким же */
                        if (count>0){
                            /* Игра не может уходить в минус, поэтому если игрок ошибается при единице, то число смещается на ноль */
                            if(count==1){
                                count=0;
                            }
                            else {
                                count=count-2;
                            }
                        }
                        // Закрашивание прогресса серым цветом (Начало)
                        for(int i=0; i<7; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        // Закрашивание прогресса серым цветом (Конец)

                        // Закрашивание прогресса зеленым цветом и определение правильных ответов (Начало)
                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        // Закрашивание прогресса зеленым цветом и определение правильных ответов (Конец)
                    }
                    // Не касание картинки - отпустить палец (Конец)

                    // Если счётчик достиг максимума
                    if (count==8){
                        // Выход из уровня

                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level", 1);
                        if (level>7){

                        }else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",8);
                            editor.commit();
                        }

                        dialogEnd.show(); // Показ диалогового окна
                    } else {
                        // Генерация случайного числа
                        numLeft = random.nextInt(12);
                        // Вызов картинки из массива
                        img_left.setImageResource(array.images7[numLeft]);
                        // Вызов текста из массива
                        text_left.setText(array.texts7[numLeft]);
                        /* Подготовка работы 1-го уровня, левой стороны (Конец) */

                        /* Подготовка работы 1-го уровня, правой стороны (Начало) */
                        // Генерация случайного числа
                        numRight = random.nextInt(12);

                        // Цикл, с предусловием, проверяющий равенсто чисел (Начало)
                        // Пока левое число равно правому, генерировать новое правое число
                        while (array.strong7[numLeft]==array.strong7[numRight]){
                            numRight = random.nextInt(12);
                        }
                        // Цикл, с предусловием, проверяющий равенсто чисел (Конец)
                        // Вызов картинки из массива
                        img_right.setImageResource(array.images7[numRight]);
                        // Вызов текста из массива
                        text_right.setText(array.texts7[numRight]);

                        // Включение правой картинки
                        img_right.setEnabled(true);

                    }
                }

                /* Условие касания картинки (Конец) */

                return true;
            }
        });
        /* Обработка нажатия на левую картинку (Конец) */

        /* Обработка нажатия на правую картинку (Начало) */
        // Выбор именно setOnTouchListener, потому что нужно обработать два состояния, начало и конец прикосновения
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            // MotionEvent определяет касание пальцем экрана
            public boolean onTouch(View view, MotionEvent event) {
                /* Условие касания картинки (Начало) */
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    // Касание картинки - приложить палец (Начало)

                    // Блокировка левой картинки, если коснулись правой
                    img_left.setEnabled(false);

                    // Условие показателя верной-неверной картинки
                    if (array.strong7[numLeft]<array.strong7[numRight]){
                        // Если левое число больше правого, показать картинку "верно"
                        img_right.setImageResource(R.drawable.img_true);
                    } else {
                        // Если левое число меньше правого, показать картинку "не верно"
                        img_right.setImageResource(R.drawable.img_folse);
                    }
                    // Касание картинки - приложить палец (Конец)

                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    // Не касание картинки - отпустить палец (Начало)
                    if (array.strong7[numLeft]<array.strong7[numRight]){
                        // Если правое число больше левого
                        if(count<8){
                            count=count+1;
                        }

                        // Закрашивание прогресса серым цветом (Начало)
                        for(int i=0; i<8; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        // Закрашивание прогресса серым цветом (Конец)

                        // Закрашивание прогресса зеленым цветом и определение правильных ответов (Начало)
                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        // Закрашивание прогресса зеленым цветом и определение правильных ответов (Конец)
                    } else {
                        // Если левое число меньше правого
                        /* Игра не может уходить в минус, поэтому если игрок ошибается при нуле, то ноль остается таким же */
                        if (count>0){
                            /* Игра не может уходить в минус, поэтому если игрок ошибается при единице, то число смещается на ноль */
                            if(count==1){
                                count=0;
                            }
                            else {
                                count=count-2;
                            }
                        }
                        // Закрашивание прогресса серым цветом (Начало)
                        for(int i=0; i<7; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        // Закрашивание прогресса серым цветом (Конец)

                        // Закрашивание прогресса зеленым цветом и определение правильных ответов (Начало)
                        for(int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        // Закрашивание прогресса зеленым цветом и определение правильных ответов (Конец)
                    }
                    // Не касание картинки - отпустить палец (Конец)

                    // Если счётчик достиг максимума
                    if (count==8){
                        // Выход из уровня

                        SharedPreferences save = getSharedPreferences("Save", MODE_PRIVATE);
                        final int level = save.getInt("Level", 1);
                        if (level>7){

                        }else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",8);
                            editor.commit();
                        }

                        dialogEnd.show(); // Показ диалогового окна
                    } else {
                        // Генерация случайного числа
                        numLeft = random.nextInt(12);
                        // Вызов картинки из массива
                        img_left.setImageResource(array.images7[numLeft]);
                        // Вызов текста из массива
                        text_left.setText(array.texts7[numLeft]);
                        /* Подготовка работы 1-го уровня, левой стороны (Конец) */

                        /* Подготовка работы 1-го уровня, правой стороны (Начало) */
                        // Генерация случайного числа
                        numRight = random.nextInt(12);

                        // Цикл, с предусловием, проверяющий равенсто чисел (Начало)
                        // Пока левое число равно правому, генерировать новое правое число
                        while (array.strong7[numLeft]==array.strong7[numRight]){
                            numRight = random.nextInt(12);
                        }
                        // Цикл, с предусловием, проверяющий равенсто чисел (Конец)
                        // Вызов картинки из массива
                        img_right.setImageResource(array.images7[numRight]);
                        // Вызов текста из массива
                        text_right.setText(array.texts7[numRight]);

                        // Включение левой картинки
                        img_left.setEnabled(true);

                    }
                }

                /* Условие касания картинки (Конец) */

                return true;
            }
        });
        /* Обработка нажатия на правую картинку (Конец) */
    }

    /* Обработка нажатия системной кнопки "назад" (Начало) */
    @Override
    public void onBackPressed(){
        // Начало конструкции
        try {
            Intent intent = new Intent(Level7.this, Level_Menu.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
        }
        // Конец конструкции


    }
    /* Обработка нажатия системной кнопки "назад" (Конец) */
}