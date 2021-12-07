package br.com.rfaengines.timedeferro_app.gameplay;

import br.com.rfaengines.timedeferro_app.dto.participante.JogadorDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class Jogador extends JogadorDTO {

    public boolean isContinue(){
        if(qtdContinue <= Sistema.CONTINUE_MAXIMO ) {
            return true;
        } else {
            return false;
        }
    }

}
