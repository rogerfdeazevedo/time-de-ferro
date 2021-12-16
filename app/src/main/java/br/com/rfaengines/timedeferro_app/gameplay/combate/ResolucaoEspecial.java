package br.com.rfaengines.timedeferro_app.gameplay.combate;

import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;

public class ResolucaoEspecial {

    private static GamePlay gamePlay;

    private static int indexMissao;

    private static AntagonistaDTO personagemComputador;

    private static HeroiDTO personagemJogador;

    private ResolucaoEspecial(){}

    public static void resolver(){

        inciar();

        if(gamePlay.getCombate().isPersonagemFezEspecial()){

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

    private static void inciar() {
        gamePlay = GamePlayManager.getGamePlay();
        indexMissao = gamePlay.getLevelAtual() - 1;
        personagemComputador = gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO();
        personagemJogador = gamePlay.getAventura().getMissoes().get(indexMissao).getHeroiDTO();
    }

    private static void personagemComputadorPerdeEnergia(){

        int energiaAtual = personagemComputador.getEnergia() - personagemJogador.getEspecial().getValor();

        personagemJogador.getEspecial().setValor(0);
        personagemComputador.setEnergia(energiaAtual);

        gamePlay.getAventura().getMissoes().get(indexMissao).setHeroiDTO(personagemJogador);
        gamePlay.getAventura().getMissoes().get(indexMissao).setAntagonistaDTO(personagemComputador);

        gamePlay.getCombate().setCombateLog(personagemComputador.getNome() + " sofre dano de Especial e perdeu Energia...");

    }

    private static void personagemJogadorPerdeEnergia(){

        int energiaAtual = personagemJogador.getEnergia() - personagemComputador.getEspecial().getValor();

        personagemComputador.getEspecial().setValor(0);
        personagemJogador.setEnergia(energiaAtual);

        gamePlay.getAventura().getMissoes().get(indexMissao).setHeroiDTO(personagemJogador);
        gamePlay.getAventura().getMissoes().get(indexMissao).setAntagonistaDTO(personagemComputador);

        gamePlay.getCombate().setCombateLog(personagemJogador.getNome() + " sofre dano de Especial e perdeu Energia...");
    }

}
