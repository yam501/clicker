package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;

public class Market extends AppCompatActivity {

    Button ClickUp,ClickUp2,ClickUp3,ClickUp4,ClickUp5,ClickUp6,ClickUp7;           // Подключаем кнопки улучшений

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
        ClickUp = (Button) findViewById(R.id.clickUp);                              // Привязываем кнопки по id, которые указаны в activity_market.xml
        ClickUp2 = (Button) findViewById(R.id.clickUp2);
        ClickUp3 = (Button) findViewById(R.id.clickUp3);
        ClickUp4 = (Button) findViewById(R.id.clickUp4);
        ClickUp5 = (Button) findViewById(R.id.clickUp5);
        ClickUp6 = (Button) findViewById(R.id.clickUp6);
        ClickUp7 = (Button) findViewById(R.id.clickUp7);

        // Обработчики нажатий на улучшение

        ClickUp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (MainActivity.currentMoney >= 50) {                              // Проверка условия, хватает ли денег на покупку улучшения
                    MainActivity.countMoney += 5;                                   // Добавление денег к нажатию за клик
                    MainActivity.currentMoney -= 50;                                // Вычитание денег за улучшение
                    MainActivity.spendMoney += 50;                                  // Прибавление к переменной отвечающей за все улучшение для клика пользователя
                    MainActivity.money.setText(MainActivity.currentMoney + "");     // Обновление TextView на activity_main
                }
            }
        });
        ClickUp2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (MainActivity.currentMoney >= 500) {
                    MainActivity.countMoney += 50;
                    MainActivity.currentMoney -= 500;
                    MainActivity.spendMoney += 500;
                    MainActivity.money.setText(MainActivity.currentMoney + "");
                }
            }
        });
        ClickUp3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (MainActivity.currentMoney >= 1000) {
                    MainActivity.countMoney += 100;
                    MainActivity.currentMoney -= 1000;
                    MainActivity.spendMoney += 1000;
                    MainActivity.money.setText(MainActivity.currentMoney + "");
                }
            }
        });
        ClickUp4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (MainActivity.currentMoney >= 10000) {
                    MainActivity.autoClick += 100;                                  // Прибавление к переменной автоклика
                    MainActivity.currentMoney -= 10000;
                    MainActivity.spendAutoMoney += 10000;                           // Прибавление к переменной отвечающей за потраченные деньги на улучшение автоклика
                    MainActivity.money.setText(MainActivity.currentMoney + "");
                }
            }
        });
        ClickUp5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (MainActivity.currentMoney >= 50000) {
                    MainActivity.countMoney += 10000;
                    MainActivity.currentMoney -= 50000;
                    MainActivity.spendMoney += 50000;
                    MainActivity.money.setText(MainActivity.currentMoney + "");
                }
            }
        });
        ClickUp6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (MainActivity.currentMoney >= 1000000) {
                    MainActivity.autoClick += 1000;
                    MainActivity.currentMoney -= 1000000;
                    MainActivity.spendAutoMoney += 1000000;
                    MainActivity.money.setText(MainActivity.currentMoney + "");
                }
            }
        });
        ClickUp7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                if (MainActivity.currentMoney >= 2500) {
                    MainActivity.autoClick += 75;
                    MainActivity.currentMoney -= 2500;
                    MainActivity.spendAutoMoney += 2500;
                    MainActivity.money.setText(MainActivity.currentMoney + "");
                }
            }
        });
    }
}