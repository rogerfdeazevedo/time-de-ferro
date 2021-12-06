package br.com.rfaengines.timedeferro_app.entity.aventura;

import br.com.rfaengines.timedeferro_app.entity.caracteristica.OrigemDoPoder;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class Cenario {
    private OrigemDoPoder origemDoPoder;
    private String desc;
}
