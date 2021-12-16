package br.com.rfaengines.timedeferro_app.gameplay.combate;

import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;
import br.com.rfaengines.timedeferro_app.gameplay.Sistema;

public class Especial {

    private static GamePlay gamePlay;

    private static int indexMissao;

    private Especial(){}

    public static void habilitarEspecial(){

        gamePlay = GamePlayManager.getGamePlay();

        indexMissao = gamePlay.getLevelAtual() - 1;

        if(gamePlay.getJogador().isDonoDoTurno()) {
            habilitarEspecialHeroi();
        }

        if(gamePlay.getComputador().isDonoDoTurno()) {
            habilitarEspecialComputador();
        }


    }

    private static void habilitarEspecialHeroi(){

        HeroiDTO heroi = gamePlay.getAventura().getMissoes().get(indexMissao).getHeroiDTO();

        if(heroi.getEspecial().getValor() >= Sistema.ESPECIAL_MAXIMO) {
            gamePlay.getCombate().setHabilitarEspecialHeroi(true);
            gamePlay.getCombate().setCombateLog("Especial do Herói habilitado ...");
        }

    }

    private static void habilitarEspecialComputador(){

        AntagonistaDTO antagonista = gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO();

        if(antagonista.getEspecial().getValor() >= Sistema.ESPECIAL_MAXIMO) {
            gamePlay.getCombate().setHabilitarEspecialAntagonista(true);
            gamePlay.getCombate().setCombateLog("Especial do Meliante habilitado ...");
        }

    }


}
