package com.example.aplicativoshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class RadioWithButtonActivity extends AppCompatActivity {

    RadioGroup radioGroupNames;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_with_button);
        setTitle("Radio com Botão");

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        btnNext = findViewById(R.id.buttonNext);
        radioGroupNames = findViewById(R.id.radioGroupAges);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RadioWithButtonActivity.this, RadioWithToastActivity.class);

                RadioButton checkedNameRadio = findViewById(radioGroupNames.getCheckedRadioButtonId());
                CharSequence selectedName = checkedNameRadio.getText().toString();

                intent.putExtra("name", selectedName);

                startActivity(intent);
            }
        });
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