package br.com.rfaengines.timedeferro_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.Estilo;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.OrigemDoPoder;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;

public class ResumoDaTretaActivity extends AppCompatActivity {

    private TextView txtView_StatusJogador_Tentativas;
    private TextView txtView_Cenario;
    private TextView txtView_Problema;
    private TextView txtView_Antagonista_Nome;
    private TextView txtView_Antagonista_Historico;
    private TextView txtView_Antagonista_Habilidade_1;
    private TextView txtView_Antagonista_Habilidade_2;
    private TextView txtView_Antagonista_Especial;

    private ImageView imgView_Antagonista;

    private Button btn_HeroiDoDia;

    private GamePlay gamePlay;

    private int indexMissao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_da_treta);
        getSupportActionBar().hide();

        carregarComponentes();
        carregarDadosUI();

        btn_HeroiDoDia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResumoDaTretaActivity.this, HeroiDoDiaActivity.class);
                startActivity(intent);

            }
        });

    }

    private void carregarComponentes(){

        txtView_StatusJogador_Tentativas = findViewById(R.id.txtView_StatusJogador_Tentativas_ActivityResumoDaTreta);

        txtView_Cenario = findViewById(R.id.txtView_Cenario_ActivityResumoDaTreta);
        txtView_Problema = findViewById(R.id.txtView_Problema_ActivityResumoDaTreta);
        txtView_Antagonista_Nome = findViewById(R.id.txtView_Antagonista_Nome_ActivityResumoDaTreta);
        txtView_Antagonista_Historico = findViewById(R.id.txtView_Antagonista_Historico_ActivityResumoDaTreta);
        txtView_Antagonista_Habilidade_1 = findViewById(R.id.txtView_Antagonista_Habilidade_1_ActivityResumoDaTreta);
        txtView_Antagonista_Habilidade_2 = findViewById(R.id.txtView_Antagonista_Habilidade_2_ActivityResumoDaTreta);
        txtView_Antagonista_Especial = findViewById(R.id.txtView_Antagonista_Especial_ActivityResumoDaTreta);

        imgView_Antagonista = findViewById(R.id.imgView_Antagonista_ActivityResumoDaTreta);

        btn_HeroiDoDia = findViewById(R.id.btn_HeroiDoDia_ActivityResumoDaTreta);

        gamePlay = GamePlayManager.getGamePlay();

        indexMissao = gamePlay.getLevelAtual() - 1;

    }

    private void carregarDadosUI(){
        carregarStatusJogador();
        carregarResumoDaTreta();
        carregarAtributosAntagonista();
        carregarIconesTretaCenario();
        carregarIconesTretaProblema();
        carregarSpriteAntagonista();
    }

    private void carregarStatusJogador(){
        String qtdStr = "" + gamePlay.getJogador().getQtdContinue();
        String tentativas = getString(R.string.game_continue, qtdStr);
        txtView_StatusJogador_Tentativas.setText(tentativas);
    }

    private void carregarResumoDaTreta(){

        String cenario = gamePlay.getAventura().getMissoes().get(indexMissao).getCenarioDTO().getDescricao();
        txtView_Cenario.setText(getString(R.string.game_cenario, cenario));

        String problema = gamePlay.getAventura().getMissoes().get(indexMissao).getProblemaDTO().getDescricao();
        txtView_Problema.setText(getString(R.string.game_problema, problema));

    }

    private void carregarAtributosAntagonista(){

        String nome = gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO().getNome();
        txtView_Antagonista_Nome.setText(getString(R.string.game_antagonista, nome));

        String historico = gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO().getHistorico();
        txtView_Antagonista_Historico.setText(historico);

        String habilidade_1 = gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO().getHabilidades().get(0).getNome()
                + ": " + gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO().getHabilidades().get(0).getValor();
        txtView_Antagonista_Habilidade_1.setText(habilidade_1);

        String habilidade_2 = gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO().getHabilidades().get(1).getNome()
                + ": " + gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO().getHabilidades().get(1).getValor();
        txtView_Antagonista_Habilidade_2.setText(habilidade_2);

        String especial = gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO().getEspecial().getNome();
        txtView_Antagonista_Especial.setText(especial);

    }

    private void carregarIconesTretaCenario(){

        OrigemDoPoder origemDoPoder = gamePlay.getAventura().getMissoes().get(indexMissao).getCenarioDTO().getOrigemDoPoder();

        if(OrigemDoPoder.CIENCIA.equals(origemDoPoder)){
            txtView_Cenario.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_origem_poder_a, 0);
        }

        if(OrigemDoPoder.SOBRENATURAL.equals(origemDoPoder)){
            txtView_Cenario.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_origem_poder_b, 0);
        }

        if(OrigemDoPoder.MUTANTE.equals(origemDoPoder)){
            txtView_Cenario.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_origem_poder_c, 0);
        }

        if(OrigemDoPoder.NATURAL.equals(origemDoPoder)){
            txtView_Cenario.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_origem_poder_d, 0);
        }

    }

    private void carregarIconesTretaProblema(){

        Estilo estilo = gamePlay.getAventura().getMissoes().get(indexMissao).getProblemaDTO().getEstilo();

        if(Estilo.SUPORTE.equals(estilo)){
            txtView_Problema.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_estilo_a, 0);
        }

        if(Estilo.CONTROLE.equals(estilo)){
            txtView_Problema.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_estilo_b, 0);
        }

        if(Estilo.LUTADOR.equals(estilo)){
            txtView_Problema.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_estilo_c, 0);
        }

    }

    private void carregarSpriteAntagonista() {

        String nome = txtView_Antagonista_Nome.getText().toString();

        if(getString(R.string.game_antagonista, getString(R.string.antagonista_1_nome)).equals(nome)) {
            imgView_Antagonista.setImageResource(R.drawable.img_antagonista_1);
        }

        if(getString(R.string.game_antagonista, getString(R.string.antagonista_2_nome)).equals(nome)) {
            imgView_Antagonista.setImageResource(R.drawable.img_antagonista_2);
        }

        if(getString(R.string.game_antagonista, getString(R.string.antagonista_3_nome)).equals(nome)) {
            imgView_Antagonista.setImageResource(R.drawable.img_antagonista_3);
        }

        if(getString(R.string.game_antagonista, getString(R.string.antagonista_4_nome)).equals(nome)) {
            imgView_Antagonista.setImageResource(R.drawable.img_antagonista_4);
        }

        if(getString(R.string.game_antagonista, getString(R.string.antagonista_5_nome)).equals(nome)) {
            imgView_Antagonista.setImageResource(R.drawable.img_antagonista_5);
        }

    }


}