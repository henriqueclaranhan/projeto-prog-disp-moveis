package com.example.aplicativoshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DaoraActivity extends AppCompatActivity {

    TextView textViewDontClick;
    Button btnDontClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daora);
        setTitle("Tela Daora");

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        textViewDontClick = findViewById(R.id.textViewDontClick);
        btnDontClick = findViewById(R.id.btnDontClick);

        btnDontClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewDontClick.setText("Você não deveria ter clicado...");
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