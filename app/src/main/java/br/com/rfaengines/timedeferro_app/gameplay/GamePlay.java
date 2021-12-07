package br.com.rfaengines.timedeferro_app.gameplay;

import java.util.List;

import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.factory.AventuraFactory;
import br.com.rfaengines.timedeferro_app.factory.ParticipanteFactory;

public class GamePlay {

    private Jogador jogador;
    private Computador computador;
    private Aventura aventura;

    private List<HeroiDTO> herois;
    private List<String> cenarios;
    private List<String> problemas;
    private List<AntagonistaDTO> antagonistas;

    private HeroiDTO heroiAtual;

    private int levelAtual;

    public GamePlay(List<HeroiDTO> herois, List<String> cenarios, List<String> problemas
            , List<AntagonistaDTO> antagonistas){
        this.herois = herois;
        this.cenarios = cenarios;
        this.problemas = problemas;
        this.antagonistas = antagonistas;
        this.levelAtual = Sistema.LEVEL_INICIAL;
    }

    public void iniciar(){
        carregarParticipantes();
        carregarAventura();
    }

    private void carregarParticipantes() {
        this.jogador = ParticipanteFactory.novoJogador();
        this.computador = ParticipanteFactory.novoComputador();
    }

    private void carregarAventura(){
        AventuraFactory aventuraFactory
                = new AventuraFactory(this.cenarios, this.problemas, this.antagonistas);
        this.aventura = aventuraFactory.novaAventura();
    }

    public void selecionarHeroi(HeroiDTO heroiSelecionado){
        this.heroiAtual = heroiSelecionado;
    }

    public void avancarProximoLevel(){
        if(this.levelAtual<Sistema.LEVEL_MAXIMO){
            this.levelAtual++;
        }
    }

}
