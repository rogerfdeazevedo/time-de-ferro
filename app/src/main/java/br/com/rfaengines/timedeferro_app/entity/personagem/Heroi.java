package br.com.rfaengines.timedeferro_app.entity.personagem;

import br.com.rfaengines.timedeferro_app.entity.caracteristica.Estilo;
import br.com.rfaengines.timedeferro_app.entity.caracteristica.OrigemDoPoder;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class Heroi extends Personagem {
    private OrigemDoPoder origemDoPoder;
    private Estilo estilo;
    private String fraseDeEfeito;
    private String historico;
}
