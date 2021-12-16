package br.com.rfaengines.timedeferro_app.activity;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import br.com.rfaengines.timedeferro_app.R;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.Estilo;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.OrigemDoPoder;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;

public class HeroiDoDiaActivity extends AppCompatActivity {

    private ImageView imgView_Heroi;

    private TextView txtView_Cenario;
    private TextView txtView_Problema;
    private TextView txtView_Heroi_Nome;
    private TextView txtView_Heroi_Historico;
    private TextView txtView_Heroi_OrigemDoPoder;
    private TextView txtView_Heroi_Estilo;
    private TextView txtView_Heroi_Habilidade_1;
    private TextView txtView_Heroi_Habilidade_2;
    private TextView txtView_Heroi_Especial;

    private Button btn_HeroiEsquerda;
    private Button btn_HeroiDireita;
    private Button btn_EnviarHeroi;

    private GamePlay gamePlay;

    private int levelAtual;
    private int indexHeroi;
    private int indexHeroiMaximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroi_do_dia);
        getSupportActionBar().hide();

        carregarComponentes();
        carregarDadosUI();

        btn_HeroiEsquerda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indexHeroi>=1){
                    indexHeroi--;
                    carregarAtributosHeroi();
                    carregarIconesOrigemDoPoder();
                    carregarIconesEstilo();
                    carregarSpriteHeroi();
                } else {
                    Toast.makeText(HeroiDoDiaActivity.this, "Não tem mais heróis a esquerda!", LENGTH_SHORT).show();
                }
            }
        });

        btn_EnviarHeroi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                selecionarHeroi();

                Intent intent = new Intent(HeroiDoDiaActivity.this, CombateActivity.class);
                startActivity(intent);

            }
        });

        btn_HeroiDireita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(indexHeroi < indexHeroiMaximo){
                    indexHeroi++;
                    carregarAtributosHeroi();
                    carregarIconesOrigemDoPoder();
                    carregarIconesEstilo();
                    carregarSpriteHeroi();
                } else {
                    Toast.makeText(HeroiDoDiaActivity.this, "Não tem mais heróis a direita!", LENGTH_SHORT).show();
                }
            }
        });

    }

    private void selecionarHeroi(){
        HeroiDTO heroiSelecionado = gamePlay.getHerois().get(indexHeroi);
        gamePlay.selecionarHeroi(heroiSelecionado);
    }

    private void carregarComponentes(){

        imgView_Heroi = findViewById(R.id.imgView_Heroi_ActivityHeroiDoDia);

        txtView_Cenario = findViewById(R.id.txtView_Cenario_ActivityHeroiDoDia);
        txtView_Problema = findViewById(R.id.txtView_Problema_ActivityHeroiDoDia);

        txtView_Heroi_Nome = findViewById(R.id.txtView_Heroi_Nome_ActivityHeroiDoDia);
        txtView_Heroi_Historico = findViewById(R.id.txtView_Heroi_Historico_ActivityHeroiDoDia);
        txtView_Heroi_OrigemDoPoder = findViewById(R.id.txtView_Heroi_OrigemDoPoder_ActivityHeroiDoDia);
        txtView_Heroi_Estilo = findViewById(R.id.txtView_Heroi_Estilo_ActivityHeroiDoDia);
        txtView_Heroi_Habilidade_1 = findViewById(R.id.txtView_Heroi_Habilidade_1_ActivityHeroiDoDia);
        txtView_Heroi_Habilidade_2 = findViewById(R.id.txtView_Heroi_Habilidade_2_ActivityHeroiDoDia);
        txtView_Heroi_Especial = findViewById(R.id.txtView_Heroi_Especial_ActivityHeroiDodia);

        btn_HeroiEsquerda = findViewById(R.id.btn_HeroiEsquerda_ActivityHeroiDoDia);
        btn_HeroiDireita = findViewById(R.id.btn_HeroiDireita_ActivityHeroiDoDia);
        btn_EnviarHeroi = findViewById(R.id.btn_EnviarHeroi_ActivityHeroiDoDia);

        gamePlay = GamePlayManager.getGamePlay();

        levelAtual = gamePlay.getLevelAtual() - 1;
        indexHeroi = 0;
        indexHeroiMaximo = gamePlay.getHerois().size() - 1;

    }

    private void carregarDadosUI(){
        carregarResumoDaTreta();
        carregarIconesTretaCenario();
        carregarIconesTretaProblema();
        carregarAtributosHeroi();
        carregarIconesOrigemDoPoder();
        carregarIconesEstilo();
        carregarSpriteHeroi();
    }

    private void carregarResumoDaTreta(){

        String cenario = gamePlay.getAventura().getMissoes().get(levelAtual).getCenarioDTO().getDescricao();
        txtView_Cenario.setText(getString(R.string.game_cenario).replace("%s", ""));

        String problema = gamePlay.getAventura().getMissoes().get(levelAtual).getProblemaDTO().getDescricao();
        txtView_Problema.setText(getString(R.string.game_problema).replace("%s", ""));

    }

    private void carregarAtributosHeroi(){

        String nome = gamePlay.getHerois().get(indexHeroi).getNome();
        txtView_Heroi_Nome.setText(nome);

        String historico = gamePlay.getHerois().get(indexHeroi).getHistorico();
        txtView_Heroi_Historico.setText(historico);

        OrigemDoPoder origemDoPoder = gamePlay.getHerois().get(indexHeroi).getOrigemDoPoder();
        txtView_Heroi_OrigemDoPoder.setText(getString(R.string.game_heroi_origem_do_poder, origemDoPoder.toString()));

        Estilo estilo = gamePlay.getHerois().get(indexHeroi).getEstilo();
        txtView_Heroi_Estilo.setText(getString(R.string.game_heroi_estilo, estilo.toString()));

        String habilidade_1 = gamePlay.getHerois().get(indexHeroi).getHabilidades().get(0).getNome()
                + ": " + gamePlay.getHerois().get(indexHeroi).getHabilidades().get(0).getValor();
        txtView_Heroi_Habilidade_1.setText(habilidade_1);

        String habilidade_2 = gamePlay.getHerois().get(indexHeroi).getHabilidades().get(1).getNome()
                + ": " + gamePlay.getHerois().get(indexHeroi).getHabilidades().get(1).getValor();
        txtView_Heroi_Habilidade_2.setText(habilidade_2);

        String especial = gamePlay.getHerois().get(indexHeroi).getEspecial().getNome();
        txtView_Heroi_Especial.setText(especial);

    }

    private void carregarIconesTretaCenario(){

        OrigemDoPoder origemDoPoder = gamePlay.getAventura().getMissoes().get(levelAtual).getCenarioDTO().getOrigemDoPoder();

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

        Estilo estilo = gamePlay.getAventura().getMissoes().get(levelAtual).getProblemaDTO().getEstilo();

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

    private void carregarIconesOrigemDoPoder(){

        OrigemDoPoder origemDoPoder = gamePlay.getHerois().get(indexHeroi).getOrigemDoPoder();

        if(OrigemDoPoder.CIENCIA.equals(origemDoPoder)){
            txtView_Heroi_OrigemDoPoder.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_origem_poder_a, 0);
        }

        if(OrigemDoPoder.SOBRENATURAL.equals(origemDoPoder)){
            txtView_Heroi_OrigemDoPoder.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_origem_poder_b, 0);
        }

        if(OrigemDoPoder.MUTANTE.equals(origemDoPoder)){
            txtView_Heroi_OrigemDoPoder.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_origem_poder_c, 0);
        }

        if(OrigemDoPoder.NATURAL.equals(origemDoPoder)){
            txtView_Heroi_OrigemDoPoder.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_origem_poder_d, 0);
        }

    }

    private void carregarIconesEstilo(){

        Estilo estilo = gamePlay.getHerois().get(indexHeroi).getEstilo();

        if(Estilo.SUPORTE.equals(estilo)){
            txtView_Heroi_Estilo.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_estilo_a, 0);
        }

        if(Estilo.CONTROLE.equals(estilo)){
            txtView_Heroi_Estilo.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_estilo_b, 0);
        }

        if(Estilo.LUTADOR.equals(estilo)){
            txtView_Heroi_Estilo.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.img_ico_estilo_c, 0);
        }

    }

    private void carregarSpriteHeroi() {

        String nome = txtView_Heroi_Nome.getText().toString();

        if(getString(R.string.heroi_1_nome).equals(nome)) {
            imgView_Heroi.setImageResource(R.drawable.img_heroi_1);
        }

        if(getString(R.string.heroi_2_nome).equals(nome)) {
            imgView_Heroi.setImageResource(R.drawable.img_heroi_2);
        }

        if(getString(R.string.heroi_3_nome).equals(nome)) {
            imgView_Heroi.setImageResource(R.drawable.img_heroi_3);
        }

        if(getString(R.string.heroi_4_nome).equals(nome)) {
            imgView_Heroi.setImageResource(R.drawable.img_heroi_4);
        }

        if(getString(R.string.heroi_5_nome).equals(nome)) {
            imgView_Heroi.setImageResource(R.drawable.img_heroi_5);
        }

    }


}