package com.example.aplicativoshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RadioWithToastActivity extends AppCompatActivity {

    TextView ageTextView;
    RadioGroup radioGroupAges;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_with_toast);
        setTitle("Radio com Toast");

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ageTextView = findViewById(R.id.ageTextView);
        radioGroupAges = findViewById(R.id.radioGroupAges);

        radioGroupAges.setOnCheckedChangeListener(radioGroupAgesListener);

        Intent thisIntent = getIntent();
        CharSequence selectedName = thisIntent.getCharSequenceExtra("name");

        if (selectedName != null) {
            ageTextView.setText(String.format("Olá, %s. %s", selectedName, ageTextView.getText().toString()));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    RadioGroup.OnCheckedChangeListener radioGroupAgesListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup agesGroup, int checkedId) {

            RadioButton checkedAgeRadio = findViewById(radioGroupAges.getCheckedRadioButtonId());
            CharSequence age = checkedAgeRadio.getText();

            Toast.makeText(getApplicationContext(), "Sua idade é: " + age, Toast.LENGTH_SHORT).show();
        }
    };
}