package br.com.rfaengines.timedeferro_app.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.rfaengines.timedeferro_app.R;

public class TutorialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        getSupportActionBar().hide();
    }
}