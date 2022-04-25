package nntc.litia.dinosapprentice;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Plot_level1_2 extends AppCompatActivity {

    Table_level1 tableOne = new Table_level1();

    Delay delay = new Delay();
    public int line = -1;
    public int counterFirstLine = 0;
    public int counterSecondLine = 0;
    public int secondYes = 0;

    public Animation a;


    public TextView textView20;
    public TextView textView21;
    public Button button5;
    public Button button4;
    public TextView textView22;
    public TextView textView23;
    public TextView textView24;
    public TextView textView25;
    public TextView textView26;
    public Button button2;
    public Button button3;
    public TextView textView27;
    public TextView textView28;
    public TextView textView29;
    public TextView textView30;
    public TextView textView31;
    public TextView textView32;
    public TextView textView33;
    public Button buttonexit;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plot1_2);

        final Button buttonexit = (Button)findViewById(R.id.buttonexit);
        final Button button2 = (Button)findViewById(R.id.button2);
        final Button button3 = (Button)findViewById(R.id.button3);
        final Button button5 = (Button)findViewById(R.id.button5);
        final Button button4 = (Button)findViewById(R.id.button4);
        final TextView textView20 = (TextView)findViewById(R.id.textView20);
        final TextView textView21 = (TextView)findViewById(R.id.textView21);
        final TextView textView23 = (TextView)findViewById(R.id.textView23);
        final TextView textView24 = (TextView)findViewById(R.id.textView24);
        final TextView textView25 = (TextView)findViewById(R.id.textView25);
        final TextView textView26 = (TextView)findViewById(R.id.textView26);
        final TextView textView28 = (TextView)findViewById(R.id.textView28);
        final TextView textView29 = (TextView)findViewById(R.id.textView29);
        final TextView textView30 = (TextView)findViewById(R.id.textView30);
        final TextView textView31 = (TextView)findViewById(R.id.textView31);
        final TextView textView32 = (TextView)findViewById(R.id.textView32);
        final TextView textView33 = (TextView)findViewById(R.id.textView33);
        final Button button = (Button)findViewById(R.id.button);

        /* Код достающий из массива сценарий - начало */
        textView20.setText(tableOne.twoscenario[0]);
        textView21.setText(tableOne.twoscenario[1]);
        textView23.setText(tableOne.twoscenario[2]);
        textView24.setText(tableOne.twoscenario[3]);
        textView25.setText(tableOne.twoscenario[4]);
        textView26.setText(tableOne.twoscenario[5]);
        textView28.setText(tableOne.twoscenario[6]);
        textView29.setText(tableOne.twoscenario[7]);
        textView30.setText(tableOne.twoscenario[8]);
        textView31.setText(tableOne.twoscenario[9]);
        textView32.setText(tableOne.twoscenario[10]);
        textView33.setText(tableOne.twoscenario[11]);

        /* Код достающий из массива сценарий - конец */

        /* Код скрывающий текст - начало */
        textView20.setVisibility(View.INVISIBLE);
        textView21.setVisibility(View.INVISIBLE);
        textView23.setVisibility(View.INVISIBLE);
        textView24.setVisibility(View.INVISIBLE);
        textView25.setVisibility(View.GONE);
        textView26.setVisibility(View.INVISIBLE);
        textView28.setVisibility(View.INVISIBLE);
        textView29.setVisibility(View.INVISIBLE);
        textView30.setVisibility(View.INVISIBLE);
        textView31.setVisibility(View.INVISIBLE);
        textView32.setVisibility(View.GONE);
        textView33.setVisibility(View.GONE);
        button.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.INVISIBLE);
        button4.setVisibility(View.INVISIBLE);
        button5.setVisibility(View.INVISIBLE);
        /* Код скрывающий текст - конец */

        /* Размещение игрового экрана по всему объему (Начало) */
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /* Размещение игрового экрана по всему объему (Конец) */

        /* Обработка нажатия кнопки "начать" в меню (Начало) */
        Button buttonStart = (Button) findViewById(R.id.button);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Начало конструкции
                try {
                    Intent intent = new Intent(Plot_level1_2.this, Level1.class);
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
                    Intent intent = new Intent(Plot_level1_2.this, Level1.class);
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
                    Intent intent = new Intent(Plot_level1_2.this, Plot_level1_1.class);
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
            while (line <=20) {
                if (counterFirstLine == 0 & line == 4){
                    line = 4;
                }else{
                    if(counterSecondLine==0 & line==10){
                        line=10;
                    } else {
                        if(secondYes==1 & line == 12){
                            line=14;
                        }
                publishProgress(line=line+1);
                try{
                    Thread.sleep(3000);
//                    if (isCancelled()) return null;
                }
                catch (Exception e){}
            }}}
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values){
            final Button buttonexit = (Button)findViewById(R.id.buttonexit);
            final Button button2 = (Button)findViewById(R.id.button2);
            final Button button3 = (Button)findViewById(R.id.button3);
            final Button button5 = (Button)findViewById(R.id.button5);
            final Button button4 = (Button)findViewById(R.id.button4);
            final TextView textView20 = (TextView)findViewById(R.id.textView20);
            final TextView textView21 = (TextView)findViewById(R.id.textView21);
            final TextView textView23 = (TextView)findViewById(R.id.textView23);
            final TextView textView24 = (TextView)findViewById(R.id.textView24);
            final TextView textView25 = (TextView)findViewById(R.id.textView25);
            final TextView textView26 = (TextView)findViewById(R.id.textView26);
            final TextView textView28 = (TextView)findViewById(R.id.textView28);
            final TextView textView29 = (TextView)findViewById(R.id.textView29);
            final TextView textView30 = (TextView)findViewById(R.id.textView30);
            final TextView textView31 = (TextView)findViewById(R.id.textView31);
            final TextView textView32 = (TextView)findViewById(R.id.textView32);
            final TextView textView33 = (TextView)findViewById(R.id.textView33);
            final Button button = (Button)findViewById(R.id.button);

            /* Код включающий анимацию текста - начало */
            final Animation a = AnimationUtils.loadAnimation(Plot_level1_2.this,R.anim.alpha_text);
            /* Код включающий анимацию текста - конец */

            switch (line){
                case 1: textView20.setVisibility(View.VISIBLE); textView20.startAnimation(a); break;
                case 2: textView21.setVisibility(View.VISIBLE); textView21.startAnimation(a); break;
                case 3: textView23.setVisibility(View.VISIBLE); textView23.startAnimation(a);break;
                case 4: button5.setVisibility(View.VISIBLE); button5.startAnimation(a);
                        button5.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                try {
                                    if(counterFirstLine==0) {
                                        button5.setBackgroundResource(R.drawable.button_stroke_black95_press_white_together);
                                        counterFirstLine = 1;
                                    }
                                } catch (Exception e) {}
                            }
                        });
                        button4.setVisibility(View.VISIBLE); button4.startAnimation(a);
                        button4.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                try {
                                    if(counterFirstLine==0) {
                                        button4.setBackgroundResource(R.drawable.button_stroke_black95_press_white_together);
                                        counterFirstLine = 1;
                                    }
                                    textView24.setVisibility(View.GONE);
                                    line = line+1;
                                } catch (Exception e) {}
                            }
                        }); break;
                case 5: textView24.setVisibility(View.VISIBLE); textView24.startAnimation(a);
                        textView25.setVisibility(View.GONE); line = line+1; break;
                case 6: textView25.setVisibility(View.VISIBLE); textView25.startAnimation(a); break;
                case 7: textView26.setVisibility(View.VISIBLE); textView26.startAnimation(a); break;
                case 8: textView28.setVisibility(View.VISIBLE); textView28.startAnimation(a); break;
                case 9: textView29.setVisibility(View.VISIBLE); textView29.startAnimation(a); break;
                case 10: button2.setVisibility(View.VISIBLE); button2.startAnimation(a);
                        button2.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                try {
                                    if (counterSecondLine == 0){
                                    button2.setBackgroundResource(R.drawable.button_stroke_black95_press_white_together);
                                    counterSecondLine = 1;

                                    // Варианты ответов которые надо спрятать
                                    textView32.setVisibility(View.GONE);
                                    textView33.setVisibility(View.GONE);

                                    secondYes = 1;
                                }} catch (Exception e) {}
                            }
                        });
                         button3.setVisibility(View.VISIBLE); button3.startAnimation(a);
                        button3.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View v){
                                try {
                                    if (counterSecondLine == 0){
                                    button3.setBackgroundResource(R.drawable.button_stroke_black95_press_white_together);
                                    counterSecondLine = 1;

                                    textView30.setVisibility(View.GONE);
                                    textView31.setVisibility(View.GONE);

                                        line=line+2;

                                    textView32.setVisibility(View.INVISIBLE);
                                    textView33.setVisibility(View.INVISIBLE);

                                }} catch (Exception e) {}
                            }
                        });break;
                case 11: textView30.setVisibility(View.VISIBLE); textView30 .startAnimation(a); break;
                case 12: textView31.setVisibility(View.VISIBLE); textView31.startAnimation(a); break;
                case 13: textView32.setVisibility(View.VISIBLE); textView32.startAnimation(a); break;
                case 14: textView33.setVisibility(View.VISIBLE); textView33.startAnimation(a); break;
                case 15: button.setVisibility(View.VISIBLE); button.startAnimation(a); break;
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
            Intent intent = new Intent(Plot_level1_2.this, Plot_level1_1.class);
            startActivity(intent);
            finish();
        }catch (Exception e){
        }
        // Конец конструкции
    }
    /* Обработка нажатия системной кнопки "назад" (Конец) */

}