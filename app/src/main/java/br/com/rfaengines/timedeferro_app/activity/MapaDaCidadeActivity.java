package br.com.rfaengines.timedeferro_app.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;

public class MapaDaCidadeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_da_cidade);
        getSupportActionBar().hide();
    }
}