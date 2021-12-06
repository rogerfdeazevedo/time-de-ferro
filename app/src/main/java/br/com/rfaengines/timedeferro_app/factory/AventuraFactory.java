package br.com.rfaengines.timedeferro_app.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.rfaengines.timedeferro_app.R;
import br.com.rfaengines.timedeferro_app.entity.aventura.Aventura;
import br.com.rfaengines.timedeferro_app.entity.aventura.Cenario;
import br.com.rfaengines.timedeferro_app.entity.aventura.Missao;
import br.com.rfaengines.timedeferro_app.entity.aventura.Problema;
import br.com.rfaengines.timedeferro_app.entity.caracteristica.Estilo;
import br.com.rfaengines.timedeferro_app.entity.caracteristica.Habilidade;
import br.com.rfaengines.timedeferro_app.entity.caracteristica.Tipo;
import br.com.rfaengines.timedeferro_app.entity.personagem.Antagonista;
import br.com.rfaengines.timedeferro_app.gameplay.Sistema;
import br.com.rfaengines.timedeferro_app.util.Sortear;

public class AventuraFactory {

    public static Aventura novaAventura(){
        Aventura aventura = new Aventura();
//        aventura.setId_aventura();
//        aventura.setData();
        aventura.setMissaoList(novaMissaoList());
        return aventura;
    }

    private static Missao novaMissao(int level){
        Missao missao = new Missao();
//        missao.setId_issao();
//        missao.setData();
        missao.setLevel(level);
        missao.setCenario((Cenario) new CenarioFactory().novo());
        missao.setProblema(new Problema());
        missao.setAntagonista(new Antagonista());
        return missao;
    }

    public static Problema novoProblema(){

        List<String> param = new ArrayList<>();
        param.add(String.valueOf(R.string.problema_1));
        param.add(String.valueOf(R.string.problema_2));
        param.add(String.valueOf(R.string.problema_3));
        param.add(String.valueOf(R.string.problema_4));
        param.add(String.valueOf(R.string.problema_5));

        int max = param.size();
        int sort = Sortear.num(1,max);

        Problema problema = new Problema();
        problema.setDescricao(param.get(sort));

        max = Estilo.values().length;
        sort = Sortear.num(1,max);

        problema.setEstilo(Estilo.values()[sort]);

        return problema;
    }

    public static Antagonista novoAntagonista(){

        List<String> strNome = new ArrayList<>();
        strNome.add(String.valueOf(R.string.antagonista_1_nome));
        strNome.add(String.valueOf(R.string.antagonista_2_nome));
        strNome.add(String.valueOf(R.string.antagonista_3_nome));
        strNome.add(String.valueOf(R.string.antagonista_4_nome));
        strNome.add(String.valueOf(R.string.antagonista_5_nome));

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

    public static List<Missao> novaMissaoList(){
        List<Missao> missaoList = new ArrayList<>();
        for (int i=0; i<Sistema.LEVEL_MAXIMO; i++) {
            missaoList.add(novaMissao(i));
        }
        return missaoList;
    }

}
