package com.example.pril.Long_game.Long_game_first;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pril.Long_game.Long_game;
import com.example.pril.R;
import com.example.pril.Solo_game.SoloGame_itog;

public class SoloGame_long1_5 extends AppCompatActivity {

        private TextView tv_points;
        private  TextView tv_timer;
        private  TextView tv_quest;
        private TextView tv_rez;
        private Button b1;
        private  Button b2;
        private  Button b3;
        private  Button b4;
        private ImageButton b_next;
        private boolean is_started = true;
        private int count = 0;
        private int points = 0;
        private String points_st;
        private String count_st;

        @SuppressLint("SetTextI18n")
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sologame_long1_5);
            //Связываем элементы по id
            Intent intent = getIntent();
            points_st = intent.getStringExtra("POINTS");
            count_st = intent.getStringExtra("COUNT");
            points += Integer.parseInt(points_st);
            count += Integer.parseInt(count_st);
            tv_timer = findViewById(R.id.tv_timer);
            tv_quest = findViewById(R.id.tv_quest);
            tv_points = findViewById(R.id.tv_points);
            tv_rez = findViewById(R.id.tv_rez);
            b1 = findViewById(R.id.b1);
            b2 = findViewById(R.id.b2);
            b3 = findViewById(R.id.b3);
            b4 = findViewById(R.id.b4);
            b_next = findViewById(R.id.b_next);
            //
            toolbar1();
            //вызов и использование элементов


            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    points+=1;
                    b2.setVisibility(View.GONE);
                    b3.setVisibility(View.GONE);
                    b4.setVisibility(View.GONE);
                    b1.setVisibility(View.GONE);
                    tv_rez.setVisibility(View.VISIBLE);
                    tv_rez.setText("GOOD");
                    tv_points.setText("Очки: "+String.valueOf(points));
                    Toast.makeText(getApplicationContext(), "+1", Toast.LENGTH_SHORT).show();

                }
            });


            b2.setOnClickListener(new View.OnClickListener() {//Правильно
                @Override
                public void onClick(View v) {

                    b2.setVisibility(View.GONE);
                    b3.setVisibility(View.GONE);
                    b4.setVisibility(View.GONE);
                    b1.setVisibility(View.GONE);
                    tv_rez.setVisibility(View.VISIBLE);
                    tv_rez.setText("No...No...");

                    Toast.makeText(getApplicationContext(), "0", Toast.LENGTH_SHORT).show();
                }
            });


            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    b2.setVisibility(View.GONE);
                    b3.setVisibility(View.GONE);
                    b4.setVisibility(View.GONE);
                    b1.setVisibility(View.GONE);
                    tv_rez.setVisibility(View.VISIBLE);
                    tv_rez.setText("No...No...");
                    Toast.makeText(getApplicationContext(), "0", Toast.LENGTH_SHORT).show();
                }
            });


            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    b2.setVisibility(View.GONE);
                    b3.setVisibility(View.GONE);
                    b4.setVisibility(View.GONE);
                    b1.setVisibility(View.GONE);
                    tv_rez.setVisibility(View.VISIBLE);
                    tv_rez.setText("No...No...");
                    Toast.makeText(getApplicationContext(), "0", Toast.LENGTH_SHORT).show();
                }
            });

            //ПЕРЕХОД НА СЛЕД ЛЕВЕЛ
            b_next.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    is_started = false;
                    Intent intent = new Intent(SoloGame_long1_5.this, SoloGame_itog.class);
                    intent.putExtra("POINTS",String.valueOf(points));
                    intent.putExtra("COUNT", String.valueOf(count));
                    intent.putExtra("GAME", "ДОЛГАЯ");
                    intent.putExtra("LEVEL", "1");
                    startActivity(intent);
                    finishAffinity();

                }
            });

            //вопрос
            tv_quest.setText("6589 = 4; 5893 = 3; 1236 = 1;\n" +
                    " 1234 = 0; 0000 = 4; 5794 = 1; \n" +
                    "1111 = 0; 4444 = 0; 7268 = 3; \n" +
                    "1679 = 2; 3697 = 2" +
                    "2793 = 1; 4895 = 3\n" +
                    "Вопрос: 5894 = ?");
            tv_points.setText("Очки: "+String.valueOf(points));
            Go_thread();






        }
        //ПОТОК

        private void Go_thread(){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (is_started){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv_timer.setText(String.valueOf(count));

                            }
                        });
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        count++;
                    }



                }
            }).start();




        }
        //тулбар
        private void toolbar1() {
            ImageView left_icon = findViewById(R.id.left_icon);
            ImageView right_icon = findViewById(R.id.right_icon);


            //кнопкa перехода обратно в меню на тулбаре (слева)
            left_icon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count = 20;
                    is_started = false;
                    Intent intent = new Intent(SoloGame_long1_5.this, Long_game.class);
                    startActivity(intent);
                    finishAffinity();
                }
            });
        }



    }




