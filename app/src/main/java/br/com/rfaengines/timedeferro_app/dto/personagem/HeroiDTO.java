package br.com.rfaengines.timedeferro_app.dto.personagem;

import br.com.rfaengines.timedeferro_app.dto.caracteristica.Estilo;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.OrigemDoPoder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class HeroiDTO extends PersonagemDTO {
    private OrigemDoPoder origemDoPoder;
    private Estilo estilo;
    private String fraseDeEfeito;
    private String historico;
}
