package br.com.rfaengines.timedeferro_app.dto.aventura;

import br.com.rfaengines.timedeferro_app.dto.caracteristica.OrigemDoPoder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class CenarioDTO {
    private OrigemDoPoder origemDoPoder;
    private String descricao;
}
