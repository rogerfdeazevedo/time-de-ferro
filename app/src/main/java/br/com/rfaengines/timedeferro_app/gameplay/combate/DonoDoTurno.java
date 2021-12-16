package br.com.rfaengines.timedeferro_app.gameplay.combate;

import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;
import br.com.rfaengines.timedeferro_app.util.Sortear;

public class DonoDoTurno {

    private static GamePlay gamePlay;

    private DonoDoTurno(){}

    public static void definir(){

        gamePlay = GamePlayManager.getGamePlay();

        if(gamePlay.getJogador().isDonoDoTurno()){
            definirComputadorComoDonoDoTurno();
        }

        if(gamePlay.getComputador().isDonoDoTurno()){
            definirJogadorComoDonoDoTurno();
        }

        if(!gamePlay.getJogador().isDonoDoTurno()
                && !gamePlay.getComputador().isDonoDoTurno()){

            disputaDonoDoTurno();

        }

    }

    private static void definirJogadorComoDonoDoTurno(){
        gamePlay.getJogador().setDonoDoTurno(true);
        gamePlay.getComputador().setDonoDoTurno(false);
        gamePlay.getCombate().setCombateLog("Jogador começa o turno ...");
    }

    private static void definirComputadorComoDonoDoTurno(){
        gamePlay.getComputador().setDonoDoTurno(true);
        gamePlay.getJogador().setDonoDoTurno(false);
        gamePlay.getCombate().setCombateLog("Computador começa o turno ...");
    }

    private static void disputaDonoDoTurno(){

        int indexMissão = gamePlay.getLevelAtual() - 1;

        HeroiDTO heroi = gamePlay.getAventura().getMissoes().get(indexMissão).getHeroiDTO();
        AntagonistaDTO antagonista = gamePlay.getAventura().getMissoes().get(indexMissão).getAntagonistaDTO();

        int iniciativaJogador = Sortear.num(1, 10) + heroi.getSorte();
        int iniciativaComputador = Sortear.num(1, 10) + antagonista.getSorte();

        gamePlay.getJogador().setIniciativa(iniciativaJogador);
        gamePlay.getComputador().setIniciativa(iniciativaComputador);

        if(gamePlay.getComputador().getIniciativa() >= gamePlay.getJogador().getIniciativa()) {

            definirComputadorComoDonoDoTurno();

        } else {

            definirJogadorComoDonoDoTurno();

        }

    }

}
