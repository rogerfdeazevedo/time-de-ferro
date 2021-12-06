package br.com.rfaengines.timedeferro_app.entity.aventura;

import br.com.rfaengines.timedeferro_app.entity.caracteristica.OrigemDoPoder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class Cenario extends ElementoAventura {
    private OrigemDoPoder origemDoPoder;

}
