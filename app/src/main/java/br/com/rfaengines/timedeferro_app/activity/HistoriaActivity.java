package br.com.rfaengines.timedeferro_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import br.com.rfaengines.timedeferro_app.R;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.Estilo;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.HabilidadeDTO;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.OrigemDoPoder;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.Tipo;
import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;

public class HistoriaActivity extends AppCompatActivity {

    private Button btn_Avancar;

    private List<HeroiDTO> herois;
    private List<String> cenarios;
    private List<String> problemas;
    private List<AntagonistaDTO> antagonistas;

    private GamePlay gamePlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);
        getSupportActionBar().hide();

        carregarComponentes();

        btn_Avancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carregarCenarios();
                carregarProblemas();
                carregarAntagonistas();
                carregarHerois();
                carregarGamePlay();
                Intent intent = new Intent(HistoriaActivity.this, MapaDaCidadeActivity.class);
                startActivity(intent);
            }
        });

    }

    private void carregarComponentes(){
        btn_Avancar = findViewById(R.id.btn_Avancar_ActivityHistoria);
    }

    /**
     * COMEÇAR JOGO - INICIO
     * obs.: Para depois, refatorar pq eu acho que fiz tudo do jeito mais dificl
     * demorei muito pra começar a codificar
     * **/

    private void carregarGamePlay(){
        gamePlay = new GamePlay(herois, cenarios, problemas, antagonistas);
        GamePlayManager.setGamePlay(gamePlay);
        gamePlay.iniciar();
    }

    /**
     * CARREGAR PARAMETROS STRINGS
     * obs.: Para depois, refatorar pq eu acho que fiz tudo do jeito mais dificl
     * demorei muito pra começar a codificar
     * **/

    private void carregarCenarios(){
        this.cenarios = new ArrayList<>();
        String[] resCenarios = getResources().getStringArray(R.array.cenarios);
        for (String cenario : resCenarios) {
            cenarios.add(cenario);
        }
    }

    private void carregarProblemas(){
        this.problemas = new ArrayList<>();
        String[] resProblemas = getResources().getStringArray(R.array.problemas);
        for (String problema : resProblemas) {
            problemas.add(problema);
        }
    }

    private List<HabilidadeDTO> getHabilidades(String h1, String h2){

        HabilidadeDTO hab1 = new HabilidadeDTO();
        hab1.setNome(h1);
        HabilidadeDTO hab2 = new HabilidadeDTO();
        hab2.setNome(h2);

        List<HabilidadeDTO> habilidades = new ArrayList<>();
        habilidades.add(hab1);
        habilidades.add(hab2);

        return habilidades;

    }

    private HabilidadeDTO getEspecial(String esp) {
        HabilidadeDTO especial = new HabilidadeDTO();
        especial.setNome(esp);
        return especial;
    }

    private void carregarAntagonistas() {

        AntagonistaDTO antagonista_1 = new AntagonistaDTO();
        antagonista_1.setNome(getResources().getString(R.string.antagonista_1_nome));
        antagonista_1.setHistorico(getResources().getString(R.string.antagonista_1_historico));
        antagonista_1.setHabilidades(getHabilidades(getResources().getString(R.string.antagonista_1_h1), getResources().getString(R.string.antagonista_1_h2)));
        antagonista_1.setEspecial(getEspecial(getResources().getString(R.string.antagonista_1_esp)));

        AntagonistaDTO antagonista_2 = new AntagonistaDTO();
        antagonista_2.setNome(getResources().getString(R.string.antagonista_2_nome));
        antagonista_2.setHistorico(getResources().getString(R.string.antagonista_2_historico));
        antagonista_2.setHabilidades(getHabilidades(getResources().getString(R.string.antagonista_2_h1), getResources().getString(R.string.antagonista_2_h2)));
        antagonista_2.setEspecial(getEspecial(getResources().getString(R.string.antagonista_2_esp)));

        AntagonistaDTO antagonista_3 = new AntagonistaDTO();
        antagonista_3.setNome(getResources().getString(R.string.antagonista_3_nome));
        antagonista_3.setHistorico(getResources().getString(R.string.antagonista_3_historico));
        antagonista_3.setHabilidades(getHabilidades(getResources().getString(R.string.antagonista_3_h1), getResources().getString(R.string.antagonista_3_h2)));
        antagonista_3.setEspecial(getEspecial(getResources().getString(R.string.antagonista_3_esp)));

        AntagonistaDTO antagonista_4 = new AntagonistaDTO();
        antagonista_4.setNome(getResources().getString(R.string.antagonista_4_nome));
        antagonista_4.setHistorico(getResources().getString(R.string.antagonista_4_historico));
        antagonista_4.setHabilidades(getHabilidades(getResources().getString(R.string.antagonista_4_h1), getResources().getString(R.string.antagonista_4_h2)));
        antagonista_4.setEspecial(getEspecial(getResources().getString(R.string.antagonista_4_esp)));

        AntagonistaDTO antagonista_5 = new AntagonistaDTO();
        antagonista_5.setNome(getResources().getString(R.string.antagonista_5_nome));
        antagonista_5.setHistorico(getResources().getString(R.string.antagonista_5_historico));
        antagonista_5.setHabilidades(getHabilidades(getResources().getString(R.string.antagonista_5_h1), getResources().getString(R.string.antagonista_5_h2)));
        antagonista_5.setEspecial(getEspecial(getResources().getString(R.string.antagonista_5_esp)));

        this.antagonistas = new ArrayList<>();
        this.antagonistas.add(antagonista_1);
        this.antagonistas.add(antagonista_2);
        this.antagonistas.add(antagonista_3);
        this.antagonistas.add(antagonista_4);
        this.antagonistas.add(antagonista_5);

    }

    private void carregarHerois(){

        HeroiDTO heroi_1 = new HeroiDTO();
        heroi_1.setNome(getResources().getString(R.string.heroi_1_nome));
        heroi_1.setHistorico(getResources().getString(R.string.heroi_1_historico));
        heroi_1.setOrigemDoPoder(OrigemDoPoder.valueOf(getResources().getString(R.string.heroi_1_origem_poder).toUpperCase()));
        heroi_1.setEstilo(Estilo.valueOf(getResources().getString(R.string.heroi_1_estilo).toUpperCase()));
        heroi_1.setTipo(Tipo.valueOf(getResources().getString(R.string.heroi_1_tipo).toUpperCase()));
        heroi_1.setHabilidades(getHabilidades(getResources().getString(R.string.heroi_1_h1), getResources().getString(R.string.heroi_1_h2)));
        heroi_1.setEspecial(getEspecial(getResources().getString(R.string.heroi_1_esp)));

        HeroiDTO heroi_2 = new HeroiDTO();
        heroi_2.setNome(getResources().getString(R.string.heroi_2_nome));
        heroi_2.setHistorico(getResources().getString(R.string.heroi_2_historico));
        heroi_2.setOrigemDoPoder(OrigemDoPoder.valueOf(getResources().getString(R.string.heroi_2_origem_poder).toUpperCase()));
        heroi_2.setEstilo(Estilo.valueOf(getResources().getString(R.string.heroi_2_estilo).toUpperCase()));
        heroi_2.setTipo(Tipo.valueOf(getResources().getString(R.string.heroi_2_tipo).toUpperCase()));
        heroi_2.setHabilidades(getHabilidades(getResources().getString(R.string.heroi_2_h1), getResources().getString(R.string.heroi_2_h2)));
        heroi_2.setEspecial(getEspecial(getResources().getString(R.string.heroi_2_esp)));

        HeroiDTO heroi_3 = new HeroiDTO();
        heroi_3.setNome(getResources().getString(R.string.heroi_3_nome));
        heroi_3.setHistorico(getResources().getString(R.string.heroi_3_historico));
        heroi_3.setOrigemDoPoder(OrigemDoPoder.valueOf(getResources().getString(R.string.heroi_3_origem_poder).toUpperCase()));
        heroi_3.setEstilo(Estilo.valueOf(getResources().getString(R.string.heroi_3_estilo).toUpperCase()));
        heroi_3.setTipo(Tipo.valueOf(getResources().getString(R.string.heroi_3_tipo).toUpperCase()));
        heroi_3.setHabilidades(getHabilidades(getResources().getString(R.string.heroi_3_h1), getResources().getString(R.string.heroi_3_h2)));
        heroi_3.setEspecial(getEspecial(getResources().getString(R.string.heroi_3_esp)));

        HeroiDTO heroi_4 = new HeroiDTO();
        heroi_4.setNome(getResources().getString(R.string.heroi_4_nome));
        heroi_4.setHistorico(getResources().getString(R.string.heroi_4_historico));
        heroi_4.setOrigemDoPoder(OrigemDoPoder.valueOf(getResources().getString(R.string.heroi_4_origem_poder).toUpperCase()));
        heroi_4.setEstilo(Estilo.valueOf(getResources().getString(R.string.heroi_4_estilo).toUpperCase()));
        heroi_4.setTipo(Tipo.valueOf(getResources().getString(R.string.heroi_4_tipo).toUpperCase()));
        heroi_4.setHabilidades(getHabilidades(getResources().getString(R.string.heroi_4_h1), getResources().getString(R.string.heroi_4_h2)));
        heroi_4.setEspecial(getEspecial(getResources().getString(R.string.heroi_4_esp)));

        HeroiDTO heroi_5 = new HeroiDTO();
        heroi_5.setNome(getResources().getString(R.string.heroi_5_nome));
        heroi_5.setHistorico(getResources().getString(R.string.heroi_5_historico));
        heroi_5.setOrigemDoPoder(OrigemDoPoder.valueOf(getResources().getString(R.string.heroi_5_origem_poder).toUpperCase()));
        heroi_5.setEstilo(Estilo.valueOf(getResources().getString(R.string.heroi_5_estilo).toUpperCase()));
        heroi_5.setTipo(Tipo.valueOf(getResources().getString(R.string.heroi_5_tipo).toUpperCase()));
        heroi_5.setHabilidades(getHabilidades(getResources().getString(R.string.heroi_5_h1), getResources().getString(R.string.heroi_5_h2)));
        heroi_5.setEspecial(getEspecial(getResources().getString(R.string.heroi_5_esp)));

        this.herois = new ArrayList<>();
        this.herois.add(heroi_1);
        this.herois.add(heroi_2);
        this.herois.add(heroi_3);
        this.herois.add(heroi_4);
        this.herois.add(heroi_5);

    }

}