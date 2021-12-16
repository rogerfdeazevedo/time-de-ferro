package br.com.rfaengines.timedeferro_app.factory;

import java.util.List;

import br.com.rfaengines.timedeferro_app.dto.caracteristica.Tipo;
import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.gameplay.Sistema;
import br.com.rfaengines.timedeferro_app.util.Sortear;

public class AntagonistaFactory {

    private AntagonistaFactory(){}

    public static AntagonistaDTO novoAntagonista(List<AntagonistaDTO> antagonistas){

        int a = Sortear.num(0, antagonistas.size() - 1);
        int t = Sortear.num(0, Tipo.values().length - 1);

        AntagonistaDTO antagonistaDTO = antagonistas.get(a);
        antagonistaDTO.setTipo(Tipo.values()[t]);
        antagonistaDTO.setEnergia(Sistema.ENERGIA_MAXIMO);
        antagonistaDTO.setSorte(Sortear.num(1,Sistema.SORTE_MAXIMO));
        antagonistaDTO.getHabilidades().get(0).setValor(Sortear.num(1,Sistema.HABILIDADE_MAXIMO));
        antagonistaDTO.getHabilidades().get(0).setFezHabilidade(false);
        antagonistaDTO.getHabilidades().get(1).setValor(Sortear.num(1,Sistema.HABILIDADE_MAXIMO));
        antagonistaDTO.getHabilidades().get(1).setFezHabilidade(false);
        antagonistaDTO.getEspecial().setValor(0);
        antagonistaDTO.getEspecial().setFezHabilidade(false);

        return antagonistaDTO;
    }

}
