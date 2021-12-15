package br.com.rfaengines.timedeferro_app.dto.personagem;

import java.util.List;

import br.com.rfaengines.timedeferro_app.dto.caracteristica.HabilidadeDTO;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class PersonagemDTO {
    private Tipo tipo;
    private int Energia;
    private int Sorte;
    private List<HabilidadeDTO> habilidades;
    private HabilidadeDTO especial;
    private String nome;
    private String historico;
}
