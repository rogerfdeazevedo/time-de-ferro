package br.com.rfaengines.timedeferro_app.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;

public class CombateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combate);
        getSupportActionBar().hide();
    }
}