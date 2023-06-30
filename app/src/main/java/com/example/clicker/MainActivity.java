package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static public int currentMoney = 0;                                     // переменная с текущими деньгами
    static public int countMoney = 5;                                       // начальная сумма денег за клик
    static public int autoClick = 0;                                        // переменная для автоклика

    static public int spendMoney = 0;                                       // переменная запоминающая потраченные деньги на клик
    static public int countClick;                                           // переменная считающая клики
    static public int spendAutoMoney = 0;                                   // переменная запомищающая потраченные деньги на автоклике
    static public int earnedMoney = 0;                                      // переменная со всеми заработанными деньгами
    static public int earnedAutoClick = 0;


    ImageButton click,market,statistic;                                     // подключение кнопок
    @SuppressLint("StaticFieldLeak")
    static public TextView money;                                           // подключение TextView для отображение денег
    private static SharedPreferences preferences;                           // объект предназначенный для чтения данных в записи


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (ImageButton) findViewById(R.id.click);                     // Привязка по id
        market = (ImageButton) findViewById(R.id.market);
        statistic = (ImageButton) findViewById(R.id.statistic);
        money = (TextView) findViewById(R.id.money);
        load_save();
        click();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    currentMoney += autoClick;
                    earnedAutoClick += autoClick;
                    earnedMoney += autoClick;
                    runOnUiThread(new Runnable() {                          // специальный поток который изменят UI
                        @SuppressLint("SetTextI18n")
                        @Override
                        public void run() {
                            money.setText(currentMoney + "");
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    save();
                }
            }
        }).start();
    }

    // Метод обработки нажатия на кнопки
    void click(){
        click.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                currentMoney += countMoney;                                 // При нажатии к текущей общей сумме прибавляется количество денег за клик
                countClick += 1;                                            // К счетчику нажатий прибавляется 1, т.е одно нажатие
                earnedMoney += countMoney;                                  // Считаются заработанные в общем деньги
                money.setText(currentMoney + "");                           // в money(TextView) на главном активити выводится актуальное количество денег
                save();
            }
        });
        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent market = new Intent(MainActivity.this, Market.class);
                startActivity(market);
            }
        });
        statistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent statistic = new Intent(MainActivity.this, Statistic.class);
                startActivity(statistic);
            }
        });
    }

    // Метод сохранения
    void save(){
        preferences = getPreferences(MODE_PRIVATE);           // указываем доступ, чтобы только это приложение имело эти данные
        SharedPreferences.Editor editor = preferences.edit(); // класс для сохранения данных по ключу и значению
        editor.putInt("money", currentMoney);                 // сохраняем текущие деньги по ключу "money"
        editor.putInt("count",countMoney);                    // сохраняем текущие прибавление денег по ключу "count"
        editor.putInt("auto",autoClick);
        editor.putInt("spendMoney",spendMoney);
        editor.putInt("countClick",countClick);
        editor.putInt("spendAutoMoney",spendAutoMoney);
        editor.putInt("earnedMoney",earnedMoney);
        editor.putInt("earnedAutoClick",earnedAutoClick);
        editor.apply();
    }

    // Метод для загрузки
    void load_save(){
        preferences = getPreferences(MODE_PRIVATE);
        currentMoney = preferences.getInt("money",0);
        countMoney = preferences.getInt("count", countMoney);
        autoClick = preferences.getInt("auto",autoClick);
        spendMoney = preferences.getInt("spendMoney",spendMoney);
        countClick = preferences.getInt("countClick",countClick);
        spendAutoMoney = preferences.getInt("spendAutoMoney",spendAutoMoney);
        earnedMoney = preferences.getInt("earnedMoney",earnedMoney);
        earnedAutoClick = preferences.getInt("earnedAutoClick",earnedAutoClick);
        money.setText(currentMoney + "");
    }

}