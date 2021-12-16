package br.com.rfaengines.timedeferro_app.gameplay.combate;

import br.com.rfaengines.timedeferro_app.dto.caracteristica.HabilidadeDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlay;
import br.com.rfaengines.timedeferro_app.gameplay.GamePlayManager;
import br.com.rfaengines.timedeferro_app.gameplay.Sistema;

public class AcaoDoTurno {

    private static GamePlay gamePlay;

    private static int indexMissao;

    private AcaoDoTurno(){}

    public static void definirAcao(){

        gamePlay = GamePlayManager.getGamePlay();

        indexMissao = gamePlay.getLevelAtual() - 1;

        if(gamePlay.getJogador().isDonoDoTurno()) {
            habilitarHabilidades();
        }

        if(gamePlay.getComputador().isDonoDoTurno()) {
            personagemComputadorAtaca();
            habilitarHabilidades();
        }

    }

    private static void habilitarHabilidades(){
        gamePlay.getCombate().setHabilitarHabilidades(true);
        gamePlay.getCombate().setCombateLog("Ação do jogador ... escolha uma das ações abaixo...");
    }

    public static void personagemComputadorAtaca(){

        AntagonistaDTO antagonista = gamePlay.getAventura().getMissoes().get(indexMissao).getAntagonistaDTO();

        if(antagonista.getEspecial().getValor() >= Sistema.ESPECIAL_MAXIMO){

            antagonista.getEspecial().setFezHabilidade(true);
            gamePlay.getAventura().getMissoes().get(indexMissao).setAntagonistaDTO(antagonista);

            gamePlay.getCombate().setCombateLog("Ação do computador ... " + antagonista.getNome()
                    + " ... faz seu especial ... " + antagonista.getEspecial().getNome()
                    + ": " + antagonista.getEspecial().getValor());

        } else {

            HabilidadeDTO h1 = antagonista.getHabilidades().get(0);
            HabilidadeDTO h2 = antagonista.getHabilidades().get(1);
            int index = 0;

            if(h1.getValor() >= h2.getValor()) {
                index = 0;
            } else {
                index = 1;
            }

            antagonista.getHabilidades().get(index).setFezHabilidade(true);
            gamePlay.getAventura().getMissoes().get(indexMissao).setAntagonistaDTO(antagonista);

            gamePlay.getCombate().setCombateLog("Ação do computador ... " + antagonista.getNome()
                    + " ... faz sua habilidade ... " + antagonista.getHabilidades().get(index).getNome()
                    + ": " +  antagonista.getHabilidades().get(index).getValor());

        }

    }

}
