package br.com.rfaengines.timedeferro_app.gameplay.combate;

import br.com.rfaengines.timedeferro_app.dto.caracteristica.HabilidadeDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;

public class ConfrontoHabilidade {

    private static GamePlay gamePlay;

    private static int indexMissao;

    private static HabilidadeDTO habilidadePersonagemJogador;

    private static HabilidadeDTO habilidadePersonagemComputador;

    private ConfrontoHabilidade(){}

    public static void confrontar(){

        iniciar();

        if(!gamePlay.getCombate().isPersonagemFezEspecial()) {

            definirHabilidadesUtilizadas();
            definirHabilidadeMaisForte();

        }

    }

    private static void iniciar(){
        gamePlay = GamePlayManager.getGamePlay();
        indexMissao = gamePlay.getLevelAtual() - 1;
        habilidadePersonagemJogador =  new HabilidadeDTO();
        habilidadePersonagemComputador =  new HabilidadeDTO();
    }

    public static void definirHabilidadesUtilizadas(){

        HeroiDTO heroi = gamePlay.getAventura().getMissoes().get(indexMissao).getHeroiDTO();

        for (HabilidadeDTO hh : heroi.getHabilidades()) {
            if(hh.isFezHabilidade()){
                habilidadePersonagemJogador = hh;
            }
        }

        AntagonistaDTO antagonista = gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO();

        for (HabilidadeDTO ha : antagonista.getHabilidades()) {
            if(ha.isFezHabilidade()){
                habilidadePersonagemComputador = ha;
            }
        }

    }

    public static void definirHabilidadeMaisForte(){

        int antagonista = habilidadePersonagemComputador.getValor();
        int heroi = habilidadePersonagemJogador.getValor();

        if( antagonista >= heroi) {
            gamePlay.getComputador().setVencedor(true);
            gamePlay.getCombate().setCombateLog(habilidadePersonagemComputador.getNome() + "...foi mais forte...");
        } else {
            gamePlay.getJogador().setVencedor(true);
            gamePlay.getCombate().setCombateLog(habilidadePersonagemJogador.getNome() + "...foi mais forte...");
        }

    }



}
