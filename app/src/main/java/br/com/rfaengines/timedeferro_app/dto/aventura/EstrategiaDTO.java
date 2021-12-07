package br.com.rfaengines.timedeferro_app.dto.aventura;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class EstrategiaDTO {
    private TipoEstrategia tipoEstrategia;
    private int bonus;
    private String descricao;
}
