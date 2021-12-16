package br.com.rfaengines.timedeferro_app.gameplay.participantes;

import br.com.rfaengines.timedeferro_app.dto.participante.JogadorDTO;
import br.com.rfaengines.timedeferro_app.gameplay.Sistema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class Jogador extends JogadorDTO {

    public boolean aindaTemTentativas(){
        if(qtdContinue>0) {
            return true;
        } else {
            return false;
        }
    }

    public void reduzirTentativas(){
        if(qtdContinue>0) {
            this.qtdContinue--;
        }
    }

}
