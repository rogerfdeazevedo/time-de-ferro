package br.com.rfaengines.timedeferro_app.factory;

import java.util.List;

import br.com.rfaengines.timedeferro_app.dto.aventura.CenarioDTO;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.OrigemDoPoder;
import br.com.rfaengines.timedeferro_app.util.Sortear;

public class CenarioFactory  {

    private CenarioFactory(){};

    public static CenarioDTO novoCenario(List<String> cenarios){
        int i = Sortear.num(0, cenarios.size() - 1);
        int x = Sortear.num(0, OrigemDoPoder.values().length - 1);
        CenarioDTO cenarioDTO = new CenarioDTO();
        cenarioDTO.setDescricao(cenarios.get(i));
        cenarioDTO.setOrigemDoPoder(OrigemDoPoder.values()[x]);
        return cenarioDTO;
    }

}
