package com.example.lab10;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ProgressBar progressBar;
    RatingBar ratingBar;
    TextView text;
    ToggleButton button;
    boolean isRunning = false;
    static final int NUM_STARS = 5;
    float step = 0.5f;
    float rating = 1.0f;
    Thread background;
    Handler handler = new Handler(Looper.getMainLooper());
    Runnable updateProgress = new Runnable() {
        @SuppressLint("SetTextI18n")
        public void run() {
            progressBar.incrementProgressBy(1);
            text.setText(getString(R.string.progress_text, progressBar.getProgress()));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress);
        text = findViewById(R.id.text);
        ratingBar = findViewById(R.id.rating);
        button = findViewById(R.id.button_start);

        TextView label = findViewById(R.id.text_value);
        ratingBar.setNumStars(NUM_STARS);
        ratingBar.setRating(rating);
        ratingBar.setStepSize(step);

        progressBar.setProgress(0);
        text.setText(getString(R.string.progress_text, 0));
        label.setText(String.valueOf(rating));

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                label.setText(getString(R.string.rating_label, rating));
            }
        });

        Button buttonReset = findViewById(R.id.button_reset);
        Button buttonDown = findViewById(R.id.button_down);
        Button buttonUp = findViewById(R.id.button_up);

        buttonReset.setOnClickListener(this);
        buttonDown.setOnClickListener(this);
        buttonUp.setOnClickListener(this);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int but = v.getId();
        if (but == R.id.button_start) {
            if (button.isChecked()) {
                background = new Thread(new Runnable() {
                    public void run() {
                        while (isRunning) {
                            try {
                                Thread.sleep((long) (1000 / ratingBar.getRating()));
                                handler.post(updateProgress);
                            } catch (InterruptedException e) {
                                Log.e("ERROR", "Thread Interrupted");
                            }
                        }
                    }
                });
                isRunning = true;
                background.start();
            } else {
                isRunning = false;
            }
        } else if (but == R.id.button_reset) {
            isRunning = false;
            progressBar.setProgress(0);
            text.setText(getString(R.string.progress_text, 0));
        } else if (but == R.id.button_down) {
            rating -= step;
            if (rating < 0.5)
                rating = 0.5F;
            ratingBar.setRating(rating);
        } else if (but == R.id.button_up) {
            rating += step;
            if (rating > NUM_STARS)
                rating = NUM_STARS;
            ratingBar.setRating(rating);
        }
    }
}