package br.com.rfaengines.timedeferro_app.entity.aventura;

import br.com.rfaengines.timedeferro_app.entity.caracteristica.Estilo;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class Problema {
    private Estilo estilo;
    private String desc;
}
