package br.com.rfaengines.timedeferro_app.factory;

import br.com.rfaengines.timedeferro_app.gameplay.Sistema;
import br.com.rfaengines.timedeferro_app.gameplay.participantes.Computador;
import br.com.rfaengines.timedeferro_app.gameplay.participantes.Jogador;

public class ParticipanteFactory {

    public static Jogador novoJogador(){
        Jogador jogador = new Jogador();
        jogador.setDonoDoTurno(false);
        jogador.setVencedor(false);
        jogador.setQtdContinue(Sistema.TANTATIVAS_MAXIMO);
        jogador.setGameOver(false);
        return jogador;
    }

    public static Computador novoComputador(){
        Computador computador = new Computador();
        computador.setDonoDoTurno(false);
        computador.setVencedor(false);
        return computador;
    }

}
