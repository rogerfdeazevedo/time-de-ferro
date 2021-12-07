package br.com.rfaengines.timedeferro_app.factory;

import br.com.rfaengines.timedeferro_app.dto.participante.ComputadorDTO;
import br.com.rfaengines.timedeferro_app.dto.participante.JogadorDTO;
import br.com.rfaengines.timedeferro_app.gameplay.Computador;
import br.com.rfaengines.timedeferro_app.gameplay.Jogador;
import br.com.rfaengines.timedeferro_app.gameplay.Sistema;

public class ParticipanteFactory {

    public static Jogador novoJogador(){
        Jogador jogador = new Jogador();
        jogador.setDonoDoTurno(false);
        jogador.setVencedor(false);
        jogador.setQtdContinue(Sistema.CONTINUE_MAXIMO);
        return jogador;
    }

    public static Computador novoComputador(){
        Computador computador = new Computador();
        computador.setDonoDoTurno(false);
        computador.setVencedor(false);
        return computador;
    }

}
