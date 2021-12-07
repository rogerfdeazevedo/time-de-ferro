package br.com.rfaengines.timedeferro_app.dto.aventura;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class AventuraDTO {
    protected int id_aventura;
    protected String data;
    protected List<MissaoDTO> missoes;
}
