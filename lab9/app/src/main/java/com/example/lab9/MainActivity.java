package com.example.lab9;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Chronometer chronometer;
    private RelativeLayout layout;
    long timeWhenStopped = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chronometer = (Chronometer)findViewById(R.id.chronometer);
        layout = findViewById(R.id.mainLayout);
    }
    @Override
    public void onClick(View v) {
        int but = v.getId();
        if (but == R.id.button_start) {
            chronometer.setBase(SystemClock.elapsedRealtime() +
                    timeWhenStopped);
            chronometer.start();
        }
        else if (but == R.id.button_stop) {
            timeWhenStopped = chronometer.getBase() -
                    SystemClock.elapsedRealtime();
            chronometer.stop();
        }
        else if (but == R.id.button_reset) {
            chronometer.setBase(SystemClock.elapsedRealtime());
            timeWhenStopped = 0;
        }
    }
    @SuppressLint("SetTextI18n")
    public void addDynamicControl(View view) {
        Button dynamicButton = new Button(this);
        dynamicButton.setLayoutParams(new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
        dynamicButton.setText("Dynamic Button");
        dynamicButton.setId(View.generateViewId()); // Генерация уникального ID
        dynamicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Обработка нажатия на динамически добавленную кнопку
            }
        });
        layout.addView(dynamicButton); // Добавление кнопки на макет
    }

}