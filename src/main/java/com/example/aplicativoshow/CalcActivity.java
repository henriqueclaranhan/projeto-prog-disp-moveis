package com.example.aplicativoshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {

    EditText num1, num2;
    TextView result;
    Button btnSum, btnSubtract, btnMultiply, btnDivide, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        setTitle("Calculadora");

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        num1 = findViewById(R.id.numInput1);
        num2 = findViewById(R.id.numInput2);
        result = findViewById(R.id.result);

        btnSum = findViewById(R.id.sum);
        btnSubtract = findViewById(R.id.subtract);
        btnMultiply = findViewById(R.id.multiply);
        btnDivide = findViewById(R.id.divide);
        btnClear = findViewById(R.id.clear);

        btnSum.setOnClickListener(this);
        btnSubtract.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
        btnClear.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public double getNum1() {
        return Double.parseDouble(num1.getText().toString());
    }

    public double getNum2() {
        return Double.parseDouble(num2.getText().toString());
    }

    public boolean areInputsValid(int operationType) {
        boolean valid = true;
        String num1Text = num1.getText().toString();
        String num2Text = num2.getText().toString();

        if(num1Text.equals("") || num1Text.equals(".") || num1Text.equals("-") || num1Text.equals("-.")) {
            num1.setError("Preencha este campo!");
            num1.requestFocus();
            valid = false;
        }

        if(num2Text.equals("") || num2Text.equals(".") || num2Text.equals("-") || num2Text.equals("-.")) {
            num2.setError("Preencha este campo!");
            num2.requestFocus();
            valid = false;
        }

        if(operationType == 3 && valid) {
            if(getNum2() == 0) {
                num2.setError("Não é possível dividir por 0!");
                num2.requestFocus();
                valid = false;
            }
        }

        return valid;
    }

    public void sumInputs() {
        String text = String.format("RESULTADO: %.2f", getNum1() + getNum2());
        result.setText(text);
    }

    public void subtractInputs() {
        String text = String.format("RESULTADO: %.2f", getNum1() - getNum2());
        result.setText(text);
    }

    public void multiplyInputs() {
        String text = String.format("RESULTADO: %.2f", getNum1() * getNum2());
        result.setText(text);
    }

    public void divideInputs() {
        String text = String.format("RESULTADO: %.2f", getNum1() / getNum2());
        result.setText(text);
    }

    public void clearInputsFocus() {
        num1.clearFocus();
        num2.clearFocus();
    }

    public void clearAll() {
        num1.setText("");
        num1.setError(null);

        num2.setText("");
        num2.setError(null);

        result.setText("RESULTADO");
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.sum:
                if(areInputsValid(0)) {
                    clearInputsFocus();
                    sumInputs();
                }
                break;

            case R.id.subtract:
                if(areInputsValid(1)) {
                    clearInputsFocus();
                    subtractInputs();
                }
                break;

            case R.id.multiply:
                if(areInputsValid(2)) {
                    clearInputsFocus();
                    multiplyInputs();
                }
                break;

            case R.id.divide:
                if(areInputsValid(3)) {
                    clearInputsFocus();
                    divideInputs();
                }
                break;

            case R.id.clear:
                clearInputsFocus();
                clearAll();
                break;
        }
    }
}