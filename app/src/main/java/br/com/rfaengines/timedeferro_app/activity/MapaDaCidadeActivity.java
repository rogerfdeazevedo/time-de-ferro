package br.com.rfaengines.timedeferro_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;

public class MapaDaCidadeActivity extends AppCompatActivity {

    private ImageView imgView_Lvl1;

    private TextView txtView_PlayerStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_da_cidade);
        getSupportActionBar().hide();

        carregarComponentes();
        carregarDadosUi();

        imgView_Lvl1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
                Intent intent = new Intent(MapaDaCidadeActivity.this, ResumoDaTretaActivity.class);
                startActivity(intent);
         }
        });
    }

    private void carregarComponentes(){
        imgView_Lvl1 = findViewById(R.id.imgView_Lvl1);
        txtView_PlayerStatus = findViewById(R.id.txtView_PlayerStatus);
    }

    private void carregarDadosUi(){
        String qtdContinues = txtView_PlayerStatus.getText() + " " + GamePlayManager.getGamePlay().getJogador().getQtdContinue();
        txtView_PlayerStatus.setText(qtdContinues );
    }

}