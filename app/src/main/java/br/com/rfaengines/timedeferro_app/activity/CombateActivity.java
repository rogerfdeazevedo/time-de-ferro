package br.com.rfaengines.timedeferro_app.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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


    }


    private void carregarComponentes(){

        txtView_Heroi_Nome = findViewById(R.id.txtView_Heroi_Nome_ActivityCombate);
        txtView_Heroi_Energia = findViewById(R.id.txtView_Heroi_Energia_ActivityCombate);
        txtView_Heroi_Sorte = findViewById(R.id.txtView_Heroi_Sorte_ActivityCombate);
        txtView_Heroi_Especial = findViewById(R.id.txtView_Heroi_Especial_ActivityCombate);

        txtView_Antagonista_Nome = findViewById(R.id.txtView_Antagonista_Nome_ActivityCombate);
        txtView_Antagonista_Energia = findViewById(R.id.txtView_Antagonista_Energia_ActivityCombate);
        txtView_Antagonista_Sorte = findViewById(R.id.txtView_Antagonista_Sorte_ActivityCombate);
        txtView_Antagonista_Especial = findViewById(R.id.txtView_Antagonista_Especial_ActivityCombate);

        txtView_Log = findViewById(R.id.txtView_Log_ActivityCombate);

        imgView_Versus_Heroi = findViewById(R.id.imgView_Versus_Heroi_ActivityCombate);
        imgView_Versus_Antagonista = findViewById(R.id.imgView_Versus_Antagonista_ActivityCombate);

        btn_Habilidade_1 = findViewById(R.id.btn_Habilidade_1_ActivityCombate);
        btn_Habilidade_2 = findViewById(R.id.btn_Habilidade_2_ActivityCombate);
        btn_Especial = findViewById(R.id.btn_Especial_ActivityCombate);

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

        if(getString(R.string.heroi_1_nome).equals(nome)) {
            imgView_Versus_Heroi.setImageResource(R.drawable.img_heroi_1);
        }

        if(getString(R.string.heroi_2_nome).equals(nome)) {
            imgView_Versus_Heroi.setImageResource(R.drawable.img_heroi_2);
        }

        if(getString(R.string.heroi_3_nome).equals(nome)) {
            imgView_Versus_Heroi.setImageResource(R.drawable.img_heroi_3);
        }

        if(getString(R.string.heroi_4_nome).equals(nome)) {
            imgView_Versus_Heroi.setImageResource(R.drawable.img_heroi_4);
        }

        if(getString(R.string.heroi_5_nome).equals(nome)) {
            imgView_Versus_Heroi.setImageResource(R.drawable.img_heroi_5);
        }

    }

    private void carregarSpriteAntagonista() {

        String nome = txtView_Antagonista_Nome.getText().toString();

        if(getString(R.string.antagonista_1_nome).equals(nome)) {
            imgView_Versus_Antagonista.setImageResource(R.drawable.img_antagonista_1);
        }

        if(getString(R.string.antagonista_2_nome).equals(nome)) {
            imgView_Versus_Antagonista.setImageResource(R.drawable.img_antagonista_2);
        }

        if(getString(R.string.antagonista_3_nome).equals(nome)) {
            imgView_Versus_Antagonista.setImageResource(R.drawable.img_antagonista_3);
        }

        if(getString(R.string.antagonista_4_nome).equals(nome)) {
            imgView_Versus_Antagonista.setImageResource(R.drawable.img_antagonista_4);
        }

        if(getString(R.string.antagonista_5_nome).equals(nome)) {
            imgView_Versus_Antagonista.setImageResource(R.drawable.img_antagonista_5);
        }

    }


}