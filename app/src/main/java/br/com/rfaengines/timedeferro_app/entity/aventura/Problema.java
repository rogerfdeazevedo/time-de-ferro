package br.com.rfaengines.timedeferro_app.entity.aventura;

import br.com.rfaengines.timedeferro_app.entity.caracteristica.Estilo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class Problema extends ElementoAventura{
    private Estilo estilo;
}
