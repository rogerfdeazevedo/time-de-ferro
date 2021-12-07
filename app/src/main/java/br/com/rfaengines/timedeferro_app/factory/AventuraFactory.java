package br.com.rfaengines.timedeferro_app.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.rfaengines.timedeferro_app.dto.aventura.AventuraDTO;
import br.com.rfaengines.timedeferro_app.dto.aventura.MissaoDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.gameplay.Aventura;
import br.com.rfaengines.timedeferro_app.gameplay.Sistema;

public class AventuraFactory {

    private List<String> cenarios;
    private List<String> problemas;
    private List<AntagonistaDTO> antagonistas;

    public AventuraFactory(List<String> cenarios, List<String> problemas
            , List<AntagonistaDTO> antagonistas){
        this.cenarios = cenarios;
        this.problemas = problemas;
        this.antagonistas = antagonistas;
    }

    public Aventura novaAventura() {
        Aventura aventura = new Aventura();
        //aventura.setId_aventura();
        //aventura.setData();
        aventura.setMissoes(criarMissoes());
        return aventura;
    }

    private List<MissaoDTO> criarMissoes(){
        List<MissaoDTO> missoes = new ArrayList<>();
        for (int i=0; i < Sistema.LEVEL_MAXIMO; i++) {
            missoes.add(novaMissao(i));
        }
        return missoes;
    }

    private MissaoDTO novaMissao(int level){
        MissaoDTO missaoDTO = new MissaoDTO();
        //missaoDTO.setId_issao();
        //missaoDTO.setData();
        missaoDTO.setLevel(level);
        missaoDTO.setCenarioDTO(CenarioFactory.novoCenario(this.cenarios));
        missaoDTO.setProblemaDTO(ProblemaFactory.novoProblema(this.problemas));
        missaoDTO.setAntagonistaDTO(AntagonistaFactory.novoAntagonista(this.antagonistas));
        return missaoDTO;
    }

}
