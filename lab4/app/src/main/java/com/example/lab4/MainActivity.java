package com.example.lab4;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBox;
    private ToggleButton toggleButton;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioGroup radioGroup;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = findViewById(R.id.checkBox);
        toggleButton = findViewById(R.id.toggleButton);
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioGroup = findViewById(R.id.radioGroup);
        imageButton = findViewById(R.id.imageButton);

        // слушатель события изменения состояния CompoundButton
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            // onCheckedChanged - вызывается, когда пользователь меняет состояние кнопки кликом
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "CheckBox включен", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "CheckBox выключен", Toast.LENGTH_SHORT).show();
                }
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(MainActivity.this, "ToggleButton включен", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "ToggleButton выключен", Toast.LENGTH_SHORT).show();
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButton1) {
                    Toast.makeText(MainActivity.this, "RadioButton1 нажат", Toast.LENGTH_SHORT).show();
                } else if (checkedId == R.id.radioButton2) {
                    Toast.makeText(MainActivity.this, "RadioButton2 нажат", Toast.LENGTH_SHORT).show();
                }
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "ImageButton нажата", Toast.LENGTH_SHORT).show();
            }
        });
    }
}