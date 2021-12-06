package br.com.rfaengines.timedeferro_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;

public class MainActivity extends AppCompatActivity {

    private Button btn_novo_jogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
        iniciarComponente_btn_novo_jogo();

        btn_novo_jogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Carragar variaveis do jogo
                Intent intent = new Intent(MainActivity.this, HistoriaActivity.class);
                startActivity(intent);
            }
        });

    }

    private void iniciarComponente_btn_novo_jogo(){
        btn_novo_jogo = findViewById(R.id.btn_novo_jogo_id);
    }

    private void carregarUmObjetoComRecursosString(){

    }

}