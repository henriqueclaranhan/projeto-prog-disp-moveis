package com.example.aplicativoshow;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity {

    String[] listOptions = new String[]{"Tela Daora", "Calculadora", "Janela de Diálogo",
            "Radio com Botão", "Radio com Toast", "Checkbox", "Spinner e Switch", "GitHub do Desenvolvedor"};

    Intent intent;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_main);

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listOptions);

        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        switch (position){
            case 0:
                intent = new Intent(MainActivity.this, DaoraActivity.class);
                startActivity(intent);
                break;

            case 1:
                intent = new Intent(MainActivity.this, CalcActivity.class);
                startActivity(intent);
                break;

            case 2:
                AlertDialog.Builder dialogWindow = new AlertDialog.Builder(this);
                dialogWindow.setTitle("Título: Mudar de tela");
                dialogWindow.setMessage("Mensagem: Mudar para a tela da calculadora?");

                DialogInterface.OnClickListener switchScreen = (dialogInterface, i) -> {
                    intent = new Intent(MainActivity.this, CalcActivity.class );
                    startActivity(intent);
                };

                dialogWindow.setPositiveButton("Sim", switchScreen);
                dialogWindow.setNegativeButton("Cancelar", null);
                dialogWindow.show();
                break;

            case 3:
                intent = new Intent(MainActivity.this, RadioWithButtonActivity.class);
                startActivity(intent);
                break;

            case 4:
                intent = new Intent(MainActivity.this, RadioWithToastActivity.class);
                startActivity(intent);
                break;

            case 5:
                intent = new Intent(MainActivity.this, CheckboxActivity.class);
                startActivity(intent);
                break;

            case 6:
                intent = new Intent(MainActivity.this, SpinnerSwitchActivity.class);
                startActivity(intent);
                break;

            case 7:
                intent = new Intent(MainActivity.this, DeveloperGitHubActivity.class);
                startActivity(intent);
                break;
        }

    }
}