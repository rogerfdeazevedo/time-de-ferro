package br.com.rfaengines.timedeferro_app.factory;

import static android.widget.Toast.LENGTH_SHORT;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.com.rfaengines.timedeferro_app.R;
import br.com.rfaengines.timedeferro_app.activity.TutorialActivity;
import br.com.rfaengines.timedeferro_app.entity.aventura.Aventura;
import br.com.rfaengines.timedeferro_app.entity.aventura.Cenario;
import br.com.rfaengines.timedeferro_app.entity.aventura.Missao;
import br.com.rfaengines.timedeferro_app.entity.aventura.Problema;
import br.com.rfaengines.timedeferro_app.entity.caracteristica.Estilo;
import br.com.rfaengines.timedeferro_app.entity.caracteristica.Habilidade;
import br.com.rfaengines.timedeferro_app.entity.caracteristica.OrigemDoPoder;
import br.com.rfaengines.timedeferro_app.entity.caracteristica.Tipo;
import br.com.rfaengines.timedeferro_app.entity.personagem.Antagonista;
import br.com.rfaengines.timedeferro_app.gameplay.Sistema;

public class AventuraFactory {

    public static Aventura novaAventura(){
        Aventura aventura = new Aventura();
//        aventura.setId_aventura();
//        aventura.setData();
        aventura.setMissaoList(novaMissaoList());
        return aventura;
    }

    private static Missao novaMissao(int level, Cenario cenario, Problema problema
    , Antagonista antagonista){
        Missao missao = new Missao();
//        missao.setId_issao();
//        missao.setData();
        missao.setLevel(level);
        missao.setCenario(cenario);
        missao.setProblema(problema);
        missao.setAntagonista(antagonista);
        return missao;
    }

    private static Cenario novoCenario(){

        List<String> param = new ArrayList<>();
        param.add(String.valueOf(R.string.cenario_1));
        param.add(String.valueOf(R.string.cenario_2));
        param.add(String.valueOf(R.string.cenario_3));
        param.add(String.valueOf(R.string.cenario_4));
        param.add(String.valueOf(R.string.cenario_5));

        int max = param.size();
        int sort = Sortear.num(1,max);

        Cenario cenario = new Cenario();
        cenario.setDesc(param.get(sort));

        max = OrigemDoPoder.values().length;
        sort = Sortear.num(1,max);

        cenario.setOrigemDoPoder(OrigemDoPoder.values()[sort]);

        return cenario;
    }

    private static Problema novoProblema(){

        List<String> param = new ArrayList<>();
        param.add(String.valueOf(R.string.problema_1));
        param.add(String.valueOf(R.string.problema_2));
        param.add(String.valueOf(R.string.problema_3));
        param.add(String.valueOf(R.string.problema_4));
        param.add(String.valueOf(R.string.problema_5));

        int max = param.size();
        int sort = Sortear.num(1,max);

        Problema problema = new Problema();
        problema.setDesc(param.get(sort));

        max = Estilo.values().length;
        sort = Sortear.num(1,max);

        problema.setEstilo(Estilo.values()[sort]);

        return problema;
    }

    private static Antagonista novoAntagonista(){

        List<String> strNome = new ArrayList<>();
        strNome.add(String.valueOf(R.string.antagonista_1));
        strNome.add(String.valueOf(R.string.antagonista_2));
        strNome.add(String.valueOf(R.string.antagonista_3));
        strNome.add(String.valueOf(R.string.antagonista_4));
        strNome.add(String.valueOf(R.string.antagonista_5));

        int max = strNome.size();
        int sort = Sortear.num(1,max);

        Antagonista antagonista = new Antagonista();
        antagonista.setTipo(Tipo.values()[Sortear.num(1,3)]);
        antagonista.setEnergia(3);
        antagonista.setSorte(Sortear.num(1,10));

        Habilidade h1 = new Habilidade();
        h1.setDesc("");
        h1.setValor(Sortear.num(1,10));

        Habilidade h2 = new Habilidade();
        h1.setDesc("");
        h1.setValor(Sortear.num(1,10));

        List<Habilidade> habilidadeList = new ArrayList<>();
        habilidadeList.add(h1);
        habilidadeList.add(h1);
        antagonista.setHabilidadeList(habilidadeList);

        Habilidade especial = new Habilidade();
        especial.setDesc("");
        especial.setValor(0);

        antagonista.setNome(strNome.get(sort));

        return antagonista;
    }

    private static List<Missao> novaMissaoList(){
        List<Missao> missaoList = new ArrayList<>();
        for (int i=0; i<Sistema.LEVEL_MAXIMO; i++) {
            missaoList.add(novaMissao(i,
                    novoCenario(),
                    novoProblema(),
                    novoAntagonista()));
        }
        return missaoList;
    }

}
