package br.com.rfaengines.timedeferro_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.rfaengines.timedeferro_app.R;

public class ResumoDaTretaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_da_treta);
        getSupportActionBar().hide();
    }
}