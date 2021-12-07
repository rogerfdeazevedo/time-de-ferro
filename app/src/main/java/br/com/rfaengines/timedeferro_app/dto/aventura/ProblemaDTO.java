package br.com.rfaengines.timedeferro_app.dto.aventura;

import br.com.rfaengines.timedeferro_app.dto.caracteristica.Estilo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class ProblemaDTO {
    private Estilo estilo;
    private String descricao;
}
