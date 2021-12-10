package br.com.rfaengines.timedeferro_app.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;

public class ResumoDaTretaActivity extends AppCompatActivity {

    private Button btn_heroiDoDia;

    private TextView txtView_PlayerStatus;
    private TextView txtView_Cenario;
    private TextView txtView_Problema;
    private TextView txtView_AntagonistaTipo;
    private TextView txtView_AntagonistaHabilidade_1;
    private TextView txtView_AntagonistaHabilidade_2;
    private TextView txtView_AntagonistaEspecial;

    private ImageView imgView_Antagonista;

    GamePlay gamePlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_da_treta);
        getSupportActionBar().hide();

        carregarComponentes();
        carregarGamePlay();
        carregarDadosUi();
        carregarSpriteAntagonista();

        btn_heroiDoDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResumoDaTretaActivity.this, HeroiDoDiaActivity.class);
                startActivity(intent);
            }
        });

    }

    private void carregarComponentes(){
        txtView_PlayerStatus = findViewById(R.id.txtView_PlayerStatus);
        btn_heroiDoDia = findViewById(R.id.btn_heroiDoDia);
        txtView_Cenario = findViewById(R.id.txtView_Cenario);
        txtView_Problema = findViewById(R.id.txtView_Problema);
        txtView_AntagonistaTipo = findViewById(R.id.txtView_AntagonistaTipo);
        txtView_AntagonistaHabilidade_1 = findViewById(R.id.txtView_AntagonistaHabilidade_1);
        txtView_AntagonistaHabilidade_2 = findViewById(R.id.txtView_AntagonistaHabilidade_2);
        txtView_AntagonistaEspecial = findViewById(R.id.txtView_AntagonistaEspecial);
        imgView_Antagonista = findViewById(R.id.imgView_Antagonista);
    }

    private void carregarGamePlay(){
        gamePlay = GamePlayManager.getGamePlay();
    }

    private void carregarDadosUi(){

        String qtdContinues = txtView_PlayerStatus.getText() + " " + gamePlay.getJogador().getQtdContinue();
        txtView_PlayerStatus.setText(qtdContinues );

        int levelAtual = GamePlayManager.getGamePlay().getLevelAtual();

        String cenario = txtView_Cenario.getText() + " " + gamePlay.getAventura().getMissoes().get(levelAtual).getCenarioDTO().getDescricao();
        txtView_Cenario.setText(cenario);

        String problema = txtView_Problema.getText() + " " + gamePlay.getAventura().getMissoes().get(levelAtual).getProblemaDTO().getDescricao();
        txtView_Problema.setText(problema);

        String antagonista = gamePlay.getAventura().getMissoes().get(levelAtual).getAntagonistaDTO().getNome();
        txtView_AntagonistaTipo.setText(antagonista);

        String habilidade_1 = gamePlay.getAventura().getMissoes().get(levelAtual).getAntagonistaDTO().getHabilidades().get(0).getNome();
        txtView_AntagonistaHabilidade_1.setText(habilidade_1);

        String habilidade_2 = gamePlay.getAventura().getMissoes().get(levelAtual).getAntagonistaDTO().getHabilidades().get(1).getNome();
        txtView_AntagonistaHabilidade_2.setText(habilidade_2);

        String especial = gamePlay.getAventura().getMissoes().get(levelAtual).getAntagonistaDTO().getEspecial().getNome();
        txtView_AntagonistaEspecial.setText(especial);

    }

    private void carregarSpriteAntagonista() {

        if(txtView_AntagonistaTipo.getText().toString().toLowerCase().contains("carlao agiota")) {
            imgView_Antagonista.setImageResource(R.drawable.img_antagonista_1);
        }

        if(txtView_AntagonistaTipo.getText().toString().toLowerCase().contains("luma madeira")) {
            imgView_Antagonista.setImageResource(R.drawable.img_antagonista_2);
        }

        if(txtView_AntagonistaTipo.getText().toString().toLowerCase().contains("toninho")) {
            imgView_Antagonista.setImageResource(R.drawable.img_antagonista_3);
        }

        if(txtView_AntagonistaTipo.getText().toString().toLowerCase().contains("pingu lin")) {
            imgView_Antagonista.setImageResource(R.drawable.img_antagonista_4);
        }

        if(txtView_AntagonistaTipo.getText().toString().toLowerCase().contains("juninho fanatico")) {
            imgView_Antagonista.setImageResource(R.drawable.img_antagonista_5);
        }

    }


}