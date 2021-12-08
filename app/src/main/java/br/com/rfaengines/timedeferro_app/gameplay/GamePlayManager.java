package br.com.rfaengines.timedeferro_app.gameplay;

import java.util.List;

import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;

public class GamePlayManager {

    private List<HeroiDTO> herois;
    private List<String> cenarios;
    private List<String> problemas;
    private List<AntagonistaDTO> antagonistas;

    private GamePlay gamePlay;

    public GamePlayManager(List<HeroiDTO> herois, List<String> cenarios, List<String> problemas
            , List<AntagonistaDTO> antagonistas){
        this.herois = herois;
        this.cenarios = cenarios;
        this.problemas = problemas;
        this.antagonistas = antagonistas;
    }

    public GamePlay getGamePlay(){
        if(this.gamePlay!=null){
            return this.gamePlay;
        } else {
            this.gamePlay = new GamePlay(this.herois, this.cenarios, this.problemas, this.antagonistas);
            return this.gamePlay;
        }
    }

}
