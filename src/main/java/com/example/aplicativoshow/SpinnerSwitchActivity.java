package com.example.aplicativoshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;

public class SpinnerSwitchActivity extends AppCompatActivity {

    Spinner spinnerColors;
    Switch switchShowSelectedColor;
    ImageView imageColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_switch);
        setTitle("Spinner e Switch");

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        spinnerColors = findViewById(R.id.spinnerColors);
        switchShowSelectedColor = findViewById(R.id.switchShowSelectedColor);
        imageColor = findViewById(R.id.imageColor);

        String[] listColors = new String[]{"Vermelho", "Verde", "Azul"};

        ArrayAdapter<String> colorsArrayAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, listColors
        );

        spinnerColors.setAdapter(colorsArrayAdapter);

        spinnerColors.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        imageColor.setBackgroundColor(Color.RED);
                        break;

                    case 1:
                        imageColor.setBackgroundColor(Color.GREEN);
                        break;

                    case 2:
                        imageColor.setBackgroundColor(Color.BLUE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        switchShowSelectedColor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    imageColor.setVisibility(View.VISIBLE);
                }
                else {
                    imageColor.setVisibility(View.INVISIBLE);
                }
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