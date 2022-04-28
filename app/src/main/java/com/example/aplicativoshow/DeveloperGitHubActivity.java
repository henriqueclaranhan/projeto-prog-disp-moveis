package com.example.aplicativoshow;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DeveloperGitHubActivity extends AppCompatActivity {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_github);
        setTitle("Henrique Claranhan");

        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        WebView henriqueGitHubWebView = findViewById(R.id.henriqueGitHubWebView);
        WebSettings webSettings = henriqueGitHubWebView.getSettings();

        webSettings.setJavaScriptEnabled(true);
        webSettings.setSupportZoom(false);

        henriqueGitHubWebView.loadUrl("https://www.github.com/henriqueclaranhan/");
        henriqueGitHubWebView.setWebViewClient(new WebViewClient());
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