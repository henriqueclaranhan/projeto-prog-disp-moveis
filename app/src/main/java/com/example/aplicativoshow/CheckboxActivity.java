package com.example.aplicativoshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class CheckboxActivity extends AppCompatActivity {
    CheckBox checkBoxMundial, checkBoxPequeno, checkBoxRegando;
    int iconRight, iconWrong;
    ImageView imageAnswerMundial, imageAnswerPequeno, imageAnswerRegando;
    Button buttonCheckAlternatives;
    TextView textScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);
        setTitle("Checkbox");

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        iconRight = R.drawable.ic_baseline_done_24;
        iconWrong = R.drawable.ic_baseline_close_24;

        checkBoxMundial = findViewById(R.id.checkBoxMundial);
        checkBoxPequeno = findViewById(R.id.checkBoxPequeno);
        checkBoxRegando = findViewById(R.id.checkBoxRegando);
        imageAnswerMundial = findViewById(R.id.imageAnswerMundial);
        imageAnswerPequeno = findViewById(R.id.imageAnswerPequeno);
        imageAnswerRegando = findViewById(R.id.imageAnswerRegando);
        textScore = findViewById(R.id.textScore);
        buttonCheckAlternatives = findViewById(R.id.buttonCheckAlternatives);

        buttonCheckAlternatives.setOnClickListener(view -> {
            checkAlternatives();
            disableCheckBoxes();
            showImageAnswers();
            buttonCheckAlternatives.setEnabled(false);
            buttonCheckAlternatives.setVisibility(View.INVISIBLE);
        });
    }

    void disableCheckBoxes() {
        checkBoxMundial.setEnabled(false);
        checkBoxPequeno.setEnabled(false);
        checkBoxRegando.setEnabled(false);
    }

    void showImageAnswers() {
        imageAnswerMundial.setVisibility(View.VISIBLE);
        imageAnswerPequeno.setVisibility(View.VISIBLE);
        imageAnswerRegando.setVisibility(View.VISIBLE);
    }

    void showScoreText(int score) {
        textScore.setText(score + " / 3");
        textScore.setVisibility(View.VISIBLE);
    }

    void checkAlternatives() {
        int score = 0;

        if (checkBoxMundial.isChecked()) {
            imageAnswerMundial.setImageResource(this.iconRight);
            score++;
        }

        if (checkBoxPequeno.isChecked()) {
            imageAnswerPequeno.setImageResource(this.iconRight);
            score++;
        }

        if (checkBoxRegando.isChecked()) {
            imageAnswerRegando.setImageResource(this.iconRight);
            score++;
        }

        showScoreText(score);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}