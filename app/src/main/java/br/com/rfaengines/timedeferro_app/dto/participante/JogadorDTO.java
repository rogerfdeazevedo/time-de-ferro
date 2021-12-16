package br.com.rfaengines.timedeferro_app.dto.participante;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class JogadorDTO extends ParticipanteDTO {
    protected int qtdContinue;
    protected boolean gameOver;
}
