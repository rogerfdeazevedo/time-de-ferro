package br.com.rfaengines.timedeferro_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;
import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;

public class CombateActivity extends AppCompatActivity {

    private TextView txtView_Heroi_Nome;
    private TextView txtView_Heroi_Energia;
    private TextView txtView_Heroi_Sorte;
    private TextView txtView_Heroi_Especial;

    private TextView txtView_Antagonista_Nome;
    private TextView txtView_Antagonista_Energia;
    private TextView txtView_Antagonista_Sorte;
    private TextView txtView_Antagonista_Especial;

    private TextView txtView_Log;

    private ImageView imgView_Versus_Heroi;
    private ImageView imgView_Versus_Antagonista;

    private Button btn_Habilidade_1;
    private Button btn_Habilidade_2;
    private Button btn_Especial;

    private GamePlay gamePlay;

    private int indexMissao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combate);
        getSupportActionBar().hide();

        carregarComponentes();
        carregarDadosUI();

        inicioDoTurno();
        verificaEspecialJogador();


        btn_Habilidade_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamePlay.getAventura().getMissoes().get(indexMissao).getHeroiDTO().getHabilidades().get(0).setFezHabilidade(true);
                turnoDoJogador();
            }
        });

        btn_Habilidade_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamePlay.getAventura().getMissoes().get(indexMissao).getHeroiDTO().getHabilidades().get(1).setFezHabilidade(true);
                turnoDoJogador();
            }
        });

        btn_Especial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gamePlay.getAventura().getMissoes().get(indexMissao).getHeroiDTO().getEspecial().setFezHabilidade(true);
                turnoDoJogador();
            }
        });

    }


    private void inicioDoTurno(){

        gamePlay.getCombate().iniciarStatusCombate();

        gamePlay.getCombate().donoDoTurno();
        txtView_Log.setText(gamePlay.getCombate().getCombateLog());

        gamePlay.getCombate().acaoDoTurno();
        mostrarLogUI();

    }


    private void verificaEspecialJogador(){

        if(gamePlay.getCombate().isHabilitarEspecialHeroi()) {
            btn_Especial.setVisibility(View.VISIBLE);
        }

    }

    private void turnoDoJogador(){

        gamePlay.getCombate().acaoDoComputador();
        mostrarLogUI();

        gamePlay.getCombate().confrontoHabilidade();
        mostrarLogUI();

        gamePlay.getCombate().resolucaoHabilidade();
        mostrarLogUI();

        gamePlay.getCombate().resolucaoEspecial();
        mostrarLogUI();

        gamePlay.getCombate().fimDoTurno();
        mostrarLogUI();

        if(gamePlay.getJogador().isVencedor()){
            gamePlay.avancarProximoLevel();
            sucesso();
        }

        if(gamePlay.getComputador().isVencedor()) {

            if(gamePlay.getJogador().aindaTemTentativas()) {
                gamePlay.getJogador().reduzirTentativas();
                falha();
            } else {
                gamePlay.getJogador().setGameOver(true);
                gameOver();
            }
        }


    }

    private void sucesso(){
        Intent intent = new Intent(CombateActivity.this, WinActivity.class);
        startActivity(intent);
    }

    private void falha(){
        Intent intent = new Intent(CombateActivity.this, GameOverActivity.class);
        startActivity(intent);
    }

    private void gameOver(){
        Intent intent = new Intent(CombateActivity.this, GameOverActivity.class);
        startActivity(intent);
    }

    private void mostrarLogUI()  {
        String log = gamePlay.getCombate().getCombateLog();
        txtView_Log.invalidate();
        txtView_Log.setText(log);

        Toast toastMessage = Toast.makeText(getApplicationContext(),log,Toast.LENGTH_SHORT);
        toastMessage.setGravity(Gravity.TOP, 0, 0);
        toastMessage.show();

    }


   private void carregarComponentes(){

        txtView_Heroi_Nome = findViewById(R.id.combateActivity_txtView_Heroi_Nome);
        txtView_Heroi_Energia = findViewById(R.id.combateActivity_txtView_Heroi_Energia);
        txtView_Heroi_Sorte = findViewById(R.id.combateActivity_txtView_Heroi_Sorte);
        txtView_Heroi_Especial = findViewById(R.id.combateActivity_txtView_Heroi_Especial);

        txtView_Antagonista_Nome = findViewById(R.id.combateActivity_txtView_Antagonista_Nome);
        txtView_Antagonista_Energia = findViewById(R.id.combateActivity_txtView_Antagonista_Energia);
        txtView_Antagonista_Sorte = findViewById(R.id.combateActivity_txtView_Antagonista_Sorte);
        txtView_Antagonista_Especial = findViewById(R.id.combateActivity_txtView_Antagonista_Especial);

        txtView_Log = findViewById(R.id.combateActivity_txtView_Log);

        imgView_Versus_Heroi = findViewById(R.id.combateActivity_imgView_Versus_Heroi);
        imgView_Versus_Antagonista = findViewById(R.id.combateActivity_imgView_Versus_Antagonista);

        btn_Habilidade_1 = findViewById(R.id.combateActivity_btn_Habilidade_1);
        btn_Habilidade_2 = findViewById(R.id.combateActivity_btn_Habilidade_2);
        btn_Especial = findViewById(R.id.combateActivity_btn_Especial);

        gamePlay = GamePlayManager.getGamePlay();

        indexMissao = gamePlay.getLevelAtual() - 1;

    }

    private void carregarDadosUI(){
        carregarStatusHeroi();
        carregarStatusAntagonista();
        carregarSpriteHeroi();
        carregarSpriteAntagonista();
    }

    private void carregarStatusHeroi(){

        HeroiDTO heroi = gamePlay.getAventura().getMissoes().get(indexMissao).getHeroiDTO();

        txtView_Heroi_Nome.setText(heroi.getNome());
        txtView_Heroi_Energia.setText(getString(R.string.game_energia, heroi.getEnergia()+""));
        txtView_Heroi_Sorte.setText(getString(R.string.game_sorte, heroi.getSorte()+""));
        txtView_Heroi_Especial.setText(getString(R.string.game_especial_pontos, heroi.getEspecial().getValor()+""));

    }

    private void carregarStatusAntagonista(){

        AntagonistaDTO antagonista = gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO();

        txtView_Antagonista_Nome.setText(antagonista.getNome());
        txtView_Antagonista_Energia.setText(getString(R.string.game_energia, antagonista.getEnergia()+""));
        txtView_Antagonista_Sorte.setText(getString(R.string.game_sorte, antagonista.getSorte()+""));
        txtView_Antagonista_Especial.setText(getString(R.string.game_especial_pontos, antagonista.getEspecial().getValor()+""));

    }

    private void carregarSpriteHeroi() {

        String nome = txtView_Heroi_Nome.getText().toString();

        if(getString(R.string.db_heroi_1_nome).equals(nome)) {
            imgView_Versus_Heroi.setImageResource(R.drawable.img_heroi_1);
        }

        if(getString(R.string.db_heroi_2_nome).equals(nome)) {
            imgView_Versus_Heroi.setImageResource(R.drawable.img_heroi_2);
        }

        if(getString(R.string.db_heroi_3_nome).equals(nome)) {
            imgView_Versus_Heroi.setImageResource(R.drawable.img_heroi_3);
        }

        if(getString(R.string.db_heroi_4_nome).equals(nome)) {
            imgView_Versus_Heroi.setImageResource(R.drawable.img_heroi_4);
        }

        if(getString(R.string.db_heroi_5_nome).equals(nome)) {
            imgView_Versus_Heroi.setImageResource(R.drawable.img_heroi_5);
        }

    }

    private void carregarSpriteAntagonista() {

        String nome = txtView_Antagonista_Nome.getText().toString();

        if(getString(R.string.db_antagonista_1_nome).equals(nome)) {
            imgView_Versus_Antagonista.setImageResource(R.drawable.img_antagonista_1);
        }

        if(getString(R.string.db_antagonista_2_nome).equals(nome)) {
            imgView_Versus_Antagonista.setImageResource(R.drawable.img_antagonista_2);
        }

        if(getString(R.string.db_antagonista_3_nome).equals(nome)) {
            imgView_Versus_Antagonista.setImageResource(R.drawable.img_antagonista_3);
        }

        if(getString(R.string.db_antagonista_4_nome).equals(nome)) {
            imgView_Versus_Antagonista.setImageResource(R.drawable.img_antagonista_4);
        }

        if(getString(R.string.db_antagonista_5_nome).equals(nome)) {
            imgView_Versus_Antagonista.setImageResource(R.drawable.img_antagonista_5);
        }

    }

}