package br.com.rfaengines.timedeferro_app.factory;

import br.com.rfaengines.timedeferro_app.entity.participante.Computador;
import br.com.rfaengines.timedeferro_app.entity.participante.Jogador;

public class ParticipanteFactory {

    public static Jogador novoJogador(){
        Jogador jogador = new Jogador();
        jogador.setDonoDoTurno(false);
        jogador.setVencedor(false);
        jogador.setQtdContinue(3);
        return jogador;
    }

    public static Computador novoComputador(){
        Computador computador = new Computador();
        computador.setDonoDoTurno(false);
        computador.setVencedor(false);
        return computador;
    }

}
