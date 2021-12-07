package br.com.rfaengines.timedeferro_app.factory;

import java.util.List;

import br.com.rfaengines.timedeferro_app.dto.aventura.ProblemaDTO;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.Estilo;
import br.com.rfaengines.timedeferro_app.util.Sortear;

public class ProblemaFactory {

    private ProblemaFactory(){}

    public static ProblemaDTO novoProblema(List<String> problemas){
        int i = Sortear.num(0, problemas.size() - 1);
        int x = Sortear.num(0, Estilo.values().length - 1);
        ProblemaDTO problemaDTO = new ProblemaDTO();
        problemaDTO.setDescricao(problemas.get(i));
        problemaDTO.setEstilo(Estilo.values()[x]);
        return problemaDTO;
    }

}
