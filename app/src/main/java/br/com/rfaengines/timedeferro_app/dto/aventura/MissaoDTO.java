package br.com.rfaengines.timedeferro_app.dto.aventura;

import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class MissaoDTO {
    private int id_issao;
    private String data;
    private int level;
    private CenarioDTO cenarioDTO;
    private ProblemaDTO problemaDTO;
    private AntagonistaDTO antagonistaDTO;
    private HeroiDTO heroiDTO;
    private EstrategiaDTO estrategiaDTO;
    private Rank rank;
    private int score;
}
