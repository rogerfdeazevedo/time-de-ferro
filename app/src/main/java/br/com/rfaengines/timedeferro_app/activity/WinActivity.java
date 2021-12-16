package br.com.rfaengines.timedeferro_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;

public class WinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);

        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                proximaTela();
            }
        }, 10000);

    }


    private void proximaTela() {
        Intent intent = new Intent(WinActivity.this, MapaDaCidadeActivity.class);
        startActivity(intent);
        finish(); //Finaliza a activity, para que não seja possível voltar nela pelo menu de navegação padrão android.
    }

}