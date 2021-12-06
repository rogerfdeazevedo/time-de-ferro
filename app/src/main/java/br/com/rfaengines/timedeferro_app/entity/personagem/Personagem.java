package br.com.rfaengines.timedeferro_app.entity.personagem;

import java.util.List;

import br.com.rfaengines.timedeferro_app.entity.caracteristica.Habilidade;
import br.com.rfaengines.timedeferro_app.entity.caracteristica.Tipo;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class Personagem {
    private Tipo tipo;
    private int Energia;
    private int Sorte;
    private List<Habilidade> habilidadeList;
    private Habilidade especial;
    private String nome;
}
