package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private float mTextSize = 20;
    private EditText mEdit;
    private TextView tSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // установка содержимого активности из файла макета
        setContentView(R.layout.activity_main);

        mEdit = findViewById(R.id.edit_text);
        tSize = findViewById(R.id.size);

        Button buttonB = findViewById(R.id.button_b);
        Button buttonI = findViewById(R.id.button_i);
        Button buttonSans = findViewById(R.id.button_sans);

        // ***
        Button buttonSerif = findViewById(R.id.button_serif);
        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonMonospace = findViewById(R.id.button_monospace);

        // установкfа слушателей кликов
        buttonB.setOnClickListener(this);
        buttonI.setOnClickListener(this);
        buttonSans.setOnClickListener(this);

        // ***
        buttonSerif.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMonospace.setOnClickListener(this);
    }

    @SuppressLint({"NonConstantResourceId", "DefaultLocale"})
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_plus:
                if (mTextSize < 72) {
                    mTextSize += 2;
                    mEdit.setTextSize(mTextSize);
                    tSize.setText(String.format("%.0f", mTextSize));
                }
                break;
            case R.id.button_minus:
                if (mTextSize > 18) {
                    mTextSize -= 2;
                    mEdit.setTextSize(mTextSize);
                    tSize.setText(String.format("%.0f", mTextSize));
                }
                break;
            case R.id.button_b:
                //  getTypeface - получения текущего шрифта из объекта TextView
                if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                    // setTypeface - установка шрифта текста в объекте TextView
                    // 1 параметр: объект Typeface, представляющий шрифт
                    // 2 параметр: флаг, определяющий стиль шрифта
                    mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD_ITALIC);
                else if (mEdit.getTypeface().getStyle() == Typeface.BOLD_ITALIC)
                    mEdit.setTypeface(mEdit.getTypeface(), Typeface.ITALIC);
                else if (mEdit.getTypeface().getStyle() == Typeface.BOLD)
                    mEdit.setTypeface(Typeface.create(mEdit.getTypeface(), Typeface.NORMAL));
                else
                    mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD);
                break;
            case R.id.button_i:
                // ***
                if (mEdit.getTypeface().getStyle() == Typeface.BOLD)
                    mEdit.setTypeface(mEdit.getTypeface(), Typeface.BOLD_ITALIC);
                else if (mEdit.getTypeface().getStyle() == Typeface.BOLD_ITALIC)
                    mEdit.setTypeface(Typeface.create(mEdit.getTypeface(), Typeface.BOLD));
                else if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                    mEdit.setTypeface(mEdit.getTypeface(), Typeface.NORMAL);
                else
                    mEdit.setTypeface(mEdit.getTypeface(), Typeface.ITALIC);
                break;
            case R.id.button_sans:
                if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                    mEdit.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC);
                else if (mEdit.getTypeface().getStyle() == Typeface.BOLD_ITALIC)
                    mEdit.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD_ITALIC);
                else if (mEdit.getTypeface().getStyle() == Typeface.BOLD)
                    mEdit.setTypeface(Typeface.SANS_SERIF, Typeface.BOLD);
                else
                    mEdit.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL);
                break;
            case R.id.button_serif:
                if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                    mEdit.setTypeface(Typeface.SERIF, Typeface.ITALIC);
                else if (mEdit.getTypeface().getStyle() == Typeface.BOLD_ITALIC)
                    mEdit.setTypeface(Typeface.SERIF, Typeface.BOLD_ITALIC);
                else if (mEdit.getTypeface().getStyle() == Typeface.BOLD)
                    mEdit.setTypeface(Typeface.SERIF, Typeface.BOLD);
                else
                    mEdit.setTypeface(Typeface.SERIF, Typeface.NORMAL);
                break;
            case R.id.button_monospace:
                // ***
                if (mEdit.getTypeface().getStyle() == Typeface.ITALIC)
                    mEdit.setTypeface(Typeface.MONOSPACE, Typeface.ITALIC);
                else if (mEdit.getTypeface().getStyle() == Typeface.BOLD_ITALIC)
                    mEdit.setTypeface(Typeface.MONOSPACE, Typeface.BOLD_ITALIC);
                else if (mEdit.getTypeface().getStyle() == Typeface.BOLD)
                    mEdit.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
                else
                    mEdit.setTypeface(Typeface.MONOSPACE, Typeface.NORMAL);
                break;
        }
    }
}