package com.example.lab5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResource());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }


    private int getLayoutResource() {
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            return R.layout.activity_main_horizontal;
        } else {
            return R.layout.activity_main_vertical;
        }
    }


    @SuppressLint({"NonConstantResourceId", "DefaultLocale"})
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        final LinearLayout mylayout = (LinearLayout)findViewById(R.id.root);
        int color;
        switch (item.getItemId()) {
            case R.id.red:

                color = ContextCompat.getColor(this, R.color.red);
                mylayout.setBackgroundColor(color);
                return true;
            case R.id.green:

                color = ContextCompat.getColor(this, R.color.green);
                mylayout.setBackgroundColor(color);
                return true;
            case R.id.blue:

                color = ContextCompat.getColor(this, R.color.blue);
                mylayout.setBackgroundColor(color);
                return true;
            case R.id.exit:
                finish();
                return true;
            case R.id.add_text_field:
                addTextField();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void addTextField() {
        LinearLayout rootLayout = findViewById(R.id.root);
        EditText textField = new EditText(this);
        textField.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        textField.setHint("Enter text");
        textField.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        textField.setBackground(ContextCompat.getDrawable(this, R.drawable.edit_text_background));
        rootLayout.addView(textField);
    }
}
