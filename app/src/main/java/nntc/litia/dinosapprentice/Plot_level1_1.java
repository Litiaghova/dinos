package nntc.litia.dinosapprentice;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Plot_level1_1 extends AppCompatActivity {

    Table_level1 tableOne = new Table_level1();

    Delay delay = new Delay();
    public int line = 0;
    public Animation a;
    public ImageView imageView2;
    public TextView textView10;
    public TextView textView11;
    public TextView textView12;
    public TextView textView13;
    public Button buttonexit;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plot1_1);

        final Button buttonexit = (Button)findViewById(R.id.buttonexit);
        final ImageView imageView2 = (ImageView)findViewById(R.id.imageView2);
        final TextView textView10 = (TextView)findViewById(R.id.textView10);
        final TextView textView11 = (TextView)findViewById(R.id.textView11);
        final TextView textView12 = (TextView)findViewById(R.id.textView12);
        final TextView textView13 = (TextView)findViewById(R.id.textView13);
        final Button button = (Button)findViewById(R.id.button);

        /* Код достающий из массива сценарий - начало */
        textView10.setText(tableOne.onescenario[0]);
        textView11.setText(tableOne.onescenario[1]);
        textView12.setText(tableOne.onescenario[2]);
        textView13.setText(tableOne.onescenario[3]);
        /* Код достающий из массива сценарий - конец */

        /* Код скрывающий текст - начало */
        imageView2.setVisibility(View.INVISIBLE);
        textView10.setVisibility(View.INVISIBLE);
        textView11.setVisibility(View.INVISIBLE);
        textView12.setVisibility(View.INVISIBLE);
        textView13.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
        /* Код скрывающий текст - конец */

        /* Размещение игрового экрана по всему объему (Начало) */
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /* Размещение игрового экрана по всему объему (Конец) */

        /* Обработка нажатия кнопки "начать" в меню (Начало) */
        Button continuebutton = (Button) findViewById(R.id.button);
        continuebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    Intent intent = new Intent(Plot_level1_1.this, Plot_level1_2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
                // Конец конструкции
            }
        });
        /* Обработка нажатия кнопки "начать" в меню (Конец) */

        /* Обработка нажатия кнопки "начать" в меню (Начало) */
        Button buttonSkip = (Button) findViewById(R.id.buttonskip);
        buttonSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    Intent intent = new Intent(Plot_level1_1.this, Plot_level1_2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
                // Конец конструкции
            }
        });
        /* Обработка нажатия кнопки "начать" в меню (Конец) */

        /* Обработка нажатия кнопки "начать" в меню (Начало) */
        Button buttonExit = (Button) findViewById(R.id.buttonexit);
        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    Intent intent = new Intent(Plot_level1_1.this, Level_Menu.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){
                }
                // Конец конструкции
            }
        });
        /* Обработка нажатия кнопки "начать" в меню (Конец) */

        /* Запуск AsyncTask - конец */
        delay.execute();
        /* Запуск AsyncTask - конец */

    }

    /* Создание AsyncTask - начало */
    class Delay extends AsyncTask<Void, Integer, Void>{

        @Override
        protected Void doInBackground(Void... params){
            while (line <=6) {
                publishProgress(line++);
                try{
                    Thread.sleep(3000);
                    if (isCancelled()) return null;
                }
                catch (Exception e){}
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            final Button buttonexit = (Button)findViewById(R.id.buttonexit);
            final ImageView imageView2 = (ImageView)findViewById(R.id.imageView2);
            final TextView textView10 = (TextView)findViewById(R.id.textView10);
            final TextView textView11 = (TextView)findViewById(R.id.textView11);
            final TextView textView12 = (TextView)findViewById(R.id.textView12);
            final TextView textView13 = (TextView)findViewById(R.id.textView13);
            final Button button = (Button)findViewById(R.id.button);

            /* Код включающий анимацию текста - начало */
            final Animation a = AnimationUtils.loadAnimation(Plot_level1_1.this,R.anim.alpha_text);
            /* Код включающий анимацию текста - конец */

            switch (line){
                case 1: imageView2.setVisibility(View.VISIBLE); imageView2.startAnimation(a); break;
                case 2: textView10.setVisibility(View.VISIBLE); textView10.startAnimation(a); break;
                case 3: textView11.setVisibility(View.VISIBLE); textView11.startAnimation(a); break;
                case 4: textView12.setVisibility(View.VISIBLE); textView12.startAnimation(a); break;
                case 5: textView13.setVisibility(View.VISIBLE); textView13.startAnimation(a); break;
                case 6: button.setVisibility(View.VISIBLE); button.startAnimation(a); break;
                default:break;
            }
        }
    }
    /* Создание AsyncTask - конец */

    /* Обработка нажатия системной кнопки "назад" (Начало) */
    @Override
    public void onBackPressed(){
        // Начало конструкции
        try {
            Intent intent = new Intent(Plot_level1_1.this, Level_Menu.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
        }
        // Конец конструкции
    }
    /* Обработка нажатия системной кнопки "назад" (Конец) */

}