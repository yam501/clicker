package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.os.Bundle;
import android.widget.TextView;

public class Statistic extends AppCompatActivity {

    public TextView statMoney,statClick,statAutoMoney,statEarned,statAutoEarned;        // Подключение TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);
        statClick = (TextView) findViewById(R.id.statclick);                            // Привязка TextView по id указаном в activity_statistic.xml
        statAutoMoney = (TextView) findViewById(R.id.statauto);
        statMoney = (TextView) findViewById(R.id.statmoney);
        statEarned = (TextView) findViewById(R.id.statEarned);
        statAutoEarned = (TextView) findViewById(R.id.statautoearned);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    runOnUiThread(new Runnable() {                                      // Специальный поток который изменят UI интерфейсы, в данном случае TextView
                        @SuppressLint("SetTextI18n")                                    // Т.к это поток, он постоянно перезаписывает(обновляет) данные в TextView
                        @Override
                        public void run() {
                            statClick.setText(MainActivity.countClick + " количество нажатий на кнопку без автоклика");
                            statAutoMoney.setText(MainActivity.spendAutoMoney + "$ потраченных на улучшение автоклика");
                            statMoney.setText(MainActivity.spendMoney + "$ потраченных на улучшение клика");
                            statEarned.setText(MainActivity.earnedMoney + "$");
                            statAutoEarned.setText(MainActivity.earnedAutoClick + "$ заработанных на автоклике");
                        }
                    });
                    try {
                        Thread.sleep(1000);                                        // Thread.sleep(1000), чтобы обновление происходило каждую секунду
                    } catch (Exception e) {
                    }
                }
            }
        }).start();
    }
}