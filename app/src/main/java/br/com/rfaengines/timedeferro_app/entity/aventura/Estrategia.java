package br.com.rfaengines.timedeferro_app.entity.aventura;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class Estrategia extends ElementoAventura {
    private TipoEstrategia tipoEstrategia;
    private int bonus;
}
