package br.com.rfaengines.timedeferro_app.gameplay.combate;

import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;

public class FimDoTurno {

    private static GamePlay gamePlay;

    private static int indexMissao;

    private static AntagonistaDTO personagemComputador;

    private static HeroiDTO personagemJogador;

    private FimDoTurno(){}

    public static void verificarVencedor(){

        inciar();
        verificarPersonagemJogador();
        verificarPersonagemComputador();


    }


    private static void inciar(){
        gamePlay = GamePlayManager.getGamePlay();
        indexMissao = gamePlay.getLevelAtual() - 1;
        personagemComputador = gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO();
        personagemJogador = gamePlay.getAventura().getMissoes().get(indexMissao).getHeroiDTO();
    }

    private static void verificarPersonagemJogador(){

        if(personagemJogador.getEnergia() <= 0){

            gamePlay.getJogador().setVencedor(false);
            gamePlay.getComputador().setVencedor(true);

            gamePlay.getCombate().setFimDoCombate(true);

            gamePlay.getCombate().setCombateLog(personagemJogador.getNome() + " ... ficou sem energia ...");

        }

    }

    private static void verificarPersonagemComputador(){

        if(personagemComputador.getEnergia() <= 0) {

            gamePlay.getJogador().setVencedor(true);
            gamePlay.getComputador().setVencedor(false);

            int especialAtual = personagemJogador.getEspecial().getValor() + 1;

            personagemJogador.getEspecial().setValor(especialAtual);

            gamePlay.getAventura().getMissoes().get(indexMissao).setHeroiDTO(personagemJogador);

            gamePlay.getCombate().setFimDoCombate(true);

            gamePlay.getCombate().setCombateLog(personagemComputador.getNome() + " ... ficou sem energia ...");

        }

    }

}
