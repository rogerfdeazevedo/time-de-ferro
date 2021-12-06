package br.com.rfaengines.timedeferro_app.gameplay;

import br.com.rfaengines.timedeferro_app.entity.aventura.Aventura;
import br.com.rfaengines.timedeferro_app.entity.participante.Computador;
import br.com.rfaengines.timedeferro_app.entity.participante.Jogador;
import br.com.rfaengines.timedeferro_app.factory.AventuraFactory;
import br.com.rfaengines.timedeferro_app.factory.ParticipanteFactory;

public class GamePlay {

    private Jogador jogador;
    private Computador computador;
    private Aventura aventura;

    public GamePlay(){}

    public void start(){
        iniciarParticipantes();
        iniciarAventura();
    }

    private void iniciarParticipantes() {
        jogador = ParticipanteFactory.novoJogador();
        computador = ParticipanteFactory.novoComputador();
    }

    private void iniciarAventura(){
        aventura = AventuraFactory.novaAventura();
    }

}
