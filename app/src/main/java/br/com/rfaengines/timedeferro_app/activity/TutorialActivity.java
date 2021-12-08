package br.com.rfaengines.timedeferro_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import br.com.rfaengines.timedeferro_app.R;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.Estilo;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.HabilidadeDTO;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.OrigemDoPoder;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.Tipo;
import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import lombok.extern.java.Log;

@Log
public class TutorialActivity extends AppCompatActivity {

    private Button btn_comecar;

    private List<HeroiDTO> herois;
    private List<String> cenarios;
    private List<String> problemas;
    private List<AntagonistaDTO> antagonistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        getSupportActionBar().hide();

        btn_comecar = findViewById(R.id.btn_comecar);

        btn_comecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TutorialActivity.this, MapaDaCidadeActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * NOVO JOGO - INICIO
     * obs.: Para depois, refatorar pq eu acho que fiz tudo do jeito mais dificl
     * demorei muito pra começar a codificar
     * **/

     private void novoJogo(){
         carregarParametros();
         GamePlay gamePlay = new GamePlay(herois, cenarios, problemas, antagonistas);
         gamePlay.iniciar();
     }

    /**
     * CARREGAR PARAMETROS STRINGS
     * obs.: Para depois, refatorar pq eu acho que fiz tudo do jeito mais dificl
     * demorei muito pra começar a codificar
     * **/

    private void carregarParametros(){
        log.log(Level.OFF,"-- CARREGAR PARAMETROS STRINGS - INICIO --");
        carregarCenarios();
        carregarProblemas();
        carregarAntagonistas();
        carregarHerois();
        log.log(Level.OFF,"-- CARREGAR PARAMETROS STRINGS - FIM ------");
    }

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

    private void carregarAntagonistas() {

        List<HabilidadeDTO> habilidades = new ArrayList<>();
        habilidades.add(new HabilidadeDTO());
        habilidades.add(new HabilidadeDTO());

        HabilidadeDTO especial = new HabilidadeDTO();

        AntagonistaDTO antagonista_1 = new AntagonistaDTO();
        antagonista_1.setNome(getResources().getString(R.string.antagonista_1_nome));
        antagonista_1.setHabilidades(habilidades);
        antagonista_1.getHabilidades().get(0).setNome(getResources().getString(R.string.antagonista_1_h1));
        antagonista_1.getHabilidades().get(1).setNome(getResources().getString(R.string.antagonista_1_h2));
        antagonista_1.setEspecial(especial);
        antagonista_1.getEspecial().setNome(getResources().getString(R.string.antagonista_1_esp));

        AntagonistaDTO antagonista_2 = new AntagonistaDTO();
        antagonista_2.setNome(getResources().getString(R.string.antagonista_2_nome));
        antagonista_2.setHabilidades(habilidades);
        antagonista_2.getHabilidades().get(0).setNome(getResources().getString(R.string.antagonista_2_h1));
        antagonista_2.getHabilidades().get(1).setNome(getResources().getString(R.string.antagonista_2_h2));
        antagonista_2.setEspecial(especial);
        antagonista_2.getEspecial().setNome(getResources().getString(R.string.antagonista_2_esp));

        AntagonistaDTO antagonista_3 = new AntagonistaDTO();
        antagonista_3.setNome(getResources().getString(R.string.antagonista_3_nome));
        antagonista_3.setHabilidades(habilidades);
        antagonista_3.getHabilidades().get(0).setNome(getResources().getString(R.string.antagonista_3_h1));
        antagonista_3.getHabilidades().get(1).setNome(getResources().getString(R.string.antagonista_3_h2));
        antagonista_3.setEspecial(especial);
        antagonista_3.getEspecial().setNome(getResources().getString(R.string.antagonista_3_esp));

        AntagonistaDTO antagonista_4 = new AntagonistaDTO();
        antagonista_4.setNome(getResources().getString(R.string.antagonista_4_nome));
        antagonista_4.setHabilidades(habilidades);
        antagonista_4.getHabilidades().get(0).setNome(getResources().getString(R.string.antagonista_4_h1));
        antagonista_4.getHabilidades().get(1).setNome(getResources().getString(R.string.antagonista_4_h2));
        antagonista_4.setEspecial(especial);
        antagonista_4.getEspecial().setNome(getResources().getString(R.string.antagonista_4_esp));

        AntagonistaDTO antagonista_5 = new AntagonistaDTO();
        antagonista_5.setNome(getResources().getString(R.string.antagonista_5_nome));
        antagonista_5.setHabilidades(habilidades);
        antagonista_5.getHabilidades().get(0).setNome(getResources().getString(R.string.antagonista_5_h1));
        antagonista_5.getHabilidades().get(1).setNome(getResources().getString(R.string.antagonista_5_h2));
        antagonista_5.setEspecial(especial);
        antagonista_5.getEspecial().setNome(getResources().getString(R.string.antagonista_5_esp));

        this.antagonistas = new ArrayList<>();
        this.antagonistas.add(antagonista_1);
        this.antagonistas.add(antagonista_2);
        this.antagonistas.add(antagonista_3);
        this.antagonistas.add(antagonista_4);
        this.antagonistas.add(antagonista_5);

    }

    private void carregarHerois(){

        List<HabilidadeDTO> habilidades = new ArrayList<>();
        habilidades.add(new HabilidadeDTO());
        habilidades.add(new HabilidadeDTO());

        HabilidadeDTO especial = new HabilidadeDTO();

        HeroiDTO heroi_1 = new HeroiDTO();
        heroi_1.setNome(getResources().getString(R.string.heroi_1_nome));
        heroi_1.setOrigemDoPoder(OrigemDoPoder.valueOf(getResources().getString(R.string.heroi_1_origem_poder).toUpperCase()));
        heroi_1.setEstilo(Estilo.valueOf(getResources().getString(R.string.heroi_1_estilo).toUpperCase()));
        heroi_1.setTipo(Tipo.valueOf(getResources().getString(R.string.heroi_1_tipo).toUpperCase()));
        heroi_1.setHabilidades(habilidades);
        heroi_1.getHabilidades().get(0).setNome(getResources().getString(R.string.heroi_1_h1));
        heroi_1.getHabilidades().get(1).setNome(getResources().getString(R.string.heroi_1_h2));
        heroi_1.setEspecial(especial);
        heroi_1.getEspecial().setNome(getResources().getString(R.string.heroi_1_esp));

        HeroiDTO heroi_2 = new HeroiDTO();
        heroi_2.setNome(getResources().getString(R.string.heroi_2_nome));
        heroi_2.setOrigemDoPoder(OrigemDoPoder.valueOf(getResources().getString(R.string.heroi_2_origem_poder).toUpperCase()));
        heroi_2.setEstilo(Estilo.valueOf(getResources().getString(R.string.heroi_2_estilo).toUpperCase()));
        heroi_2.setTipo(Tipo.valueOf(getResources().getString(R.string.heroi_2_tipo).toUpperCase()));
        heroi_2.setHabilidades(habilidades);
        heroi_2.getHabilidades().get(0).setNome(getResources().getString(R.string.heroi_2_h1));
        heroi_2.getHabilidades().get(1).setNome(getResources().getString(R.string.heroi_2_h2));
        heroi_2.setEspecial(especial);
        heroi_2.getEspecial().setNome(getResources().getString(R.string.heroi_2_esp));

        HeroiDTO heroi_3 = new HeroiDTO();
        heroi_3.setNome(getResources().getString(R.string.heroi_3_nome));
        heroi_3.setOrigemDoPoder(OrigemDoPoder.valueOf(getResources().getString(R.string.heroi_3_origem_poder).toUpperCase()));
        heroi_3.setEstilo(Estilo.valueOf(getResources().getString(R.string.heroi_3_estilo).toUpperCase()));
        heroi_3.setTipo(Tipo.valueOf(getResources().getString(R.string.heroi_3_tipo).toUpperCase()));
        heroi_3.setHabilidades(habilidades);
        heroi_3.getHabilidades().get(0).setNome(getResources().getString(R.string.heroi_3_h1));
        heroi_3.getHabilidades().get(1).setNome(getResources().getString(R.string.heroi_3_h2));
        heroi_3.setEspecial(especial);
        heroi_3.getEspecial().setNome(getResources().getString(R.string.heroi_3_esp));

        HeroiDTO heroi_4 = new HeroiDTO();
        heroi_4.setNome(getResources().getString(R.string.heroi_4_nome));
        heroi_4.setOrigemDoPoder(OrigemDoPoder.valueOf(getResources().getString(R.string.heroi_4_origem_poder).toUpperCase()));
        heroi_4.setEstilo(Estilo.valueOf(getResources().getString(R.string.heroi_4_estilo).toUpperCase()));
        heroi_4.setTipo(Tipo.valueOf(getResources().getString(R.string.heroi_4_tipo).toUpperCase()));
        heroi_4.setHabilidades(habilidades);
        heroi_4.getHabilidades().get(0).setNome(getResources().getString(R.string.heroi_4_h1));
        heroi_4.getHabilidades().get(1).setNome(getResources().getString(R.string.heroi_4_h2));
        heroi_4.setEspecial(especial);
        heroi_4.getEspecial().setNome(getResources().getString(R.string.heroi_4_esp));

        HeroiDTO heroi_5 = new HeroiDTO();
        heroi_5.setNome(getResources().getString(R.string.heroi_5_nome));
        heroi_5.setOrigemDoPoder(OrigemDoPoder.valueOf(getResources().getString(R.string.heroi_5_origem_poder).toUpperCase()));
        heroi_5.setEstilo(Estilo.valueOf(getResources().getString(R.string.heroi_5_estilo).toUpperCase()));
        heroi_5.setTipo(Tipo.valueOf(getResources().getString(R.string.heroi_5_tipo).toUpperCase()));
        heroi_5.setHabilidades(habilidades);
        heroi_5.getHabilidades().get(0).setNome(getResources().getString(R.string.heroi_5_h1));
        heroi_5.getHabilidades().get(1).setNome(getResources().getString(R.string.heroi_5_h2));
        heroi_5.setEspecial(especial);
        heroi_5.getEspecial().setNome(getResources().getString(R.string.heroi_5_esp));

        this.herois = new ArrayList<>();
        this.herois.add(heroi_1);
        this.herois.add(heroi_2);
        this.herois.add(heroi_3);
        this.herois.add(heroi_4);
        this.herois.add(heroi_5);

    }

}