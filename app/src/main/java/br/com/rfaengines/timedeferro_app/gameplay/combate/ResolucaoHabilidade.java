package br.com.rfaengines.timedeferro_app.gameplay.combate;

import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;

public class ResolucaoHabilidade {

    private static GamePlay gamePlay;

    private static int indexMissao;

    private static AntagonistaDTO personagemComputador;

    private static HeroiDTO personagemJogador;

    private ResolucaoHabilidade(){}

    public static void resolver(){

        inciar();

        if(!gamePlay.getCombate().isPersonagemFezEspecial()){

            definirQuemPerdeuEnergia();

        }

    }

    private static void definirQuemPerdeuEnergia(){

        if(gamePlay.getJogador().isVencedor()){
            personagemComputadorPerdeEnergia();
        } else {
            personagemJogadorPerdeEnergia();
        }

    }

    private static void inciar(){
        gamePlay = GamePlayManager.getGamePlay();
        indexMissao = gamePlay.getLevelAtual() - 1;
        personagemComputador = gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO();
        personagemJogador = gamePlay.getAventura().getMissoes().get(indexMissao).getHeroiDTO();
    }

    private static void personagemComputadorPerdeEnergia(){

        int energiaAtual = personagemComputador.getEnergia() - 1;

        personagemComputador.setEnergia(energiaAtual);
        gamePlay.getAventura().getMissoes().get(indexMissao).setAntagonistaDTO(personagemComputador);

        gamePlay.getCombate().setCombateLog(personagemComputador.getNome() + " sofre dano e perdeu Energia...");

    }

    private static void personagemJogadorPerdeEnergia(){

        int energiaAtual = personagemJogador.getEnergia() - 1;

        personagemJogador.setEnergia(energiaAtual);
        gamePlay.getAventura().getMissoes().get(indexMissao).setHeroiDTO(personagemJogador);

        gamePlay.getCombate().setCombateLog(personagemJogador.getNome() + " sofre dano e perdeu Energia...");
    }

}
