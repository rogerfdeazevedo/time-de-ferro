package br.com.rfaengines.timedeferro_app.gameplay;

import java.util.List;

import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.HeroiDTO;
import br.com.rfaengines.timedeferro_app.factory.AventuraFactory;
import br.com.rfaengines.timedeferro_app.factory.HeroiFactory;
import br.com.rfaengines.timedeferro_app.factory.ParticipanteFactory;
import br.com.rfaengines.timedeferro_app.gameplay.combate.Combate;
import br.com.rfaengines.timedeferro_app.gameplay.participantes.Computador;
import br.com.rfaengines.timedeferro_app.gameplay.participantes.Jogador;

public class GamePlay {

    private Jogador jogador;
    private Computador computador;
    private Aventura aventura;
    private Combate combate;

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
        iniciarParticipantes();
        iniciarAventura();
        iniciarHerois();
        iniciarCombate();
    }

    private void iniciarParticipantes() {
        this.jogador = ParticipanteFactory.novoJogador();
        this.computador = ParticipanteFactory.novoComputador();
    }

    private void iniciarAventura(){
        AventuraFactory aventuraFactory
                = new AventuraFactory(this.cenarios, this.problemas, this.antagonistas);
        this.aventura = aventuraFactory.novaAventura();
    }

    private void iniciarHerois(){
        this.herois = HeroiFactory.distribuirPontosDeAtributos(this.herois);
    }

    private void iniciarCombate(){
        this.combate = new Combate();
    }

    public void selecionarHeroi(HeroiDTO heroiSelecionado){
        this.heroiAtual = heroiSelecionado;
        int indexMissao = this.levelAtual - 1;
        this.aventura.getMissoes().get(indexMissao).setHeroiDTO(this.heroiAtual);
    }

    public void avancarProximoLevel(){
        if(this.levelAtual<Sistema.LEVEL_MAXIMO){
            this.levelAtual++;
        }
    }

    public int getLevelAtual() {
        return levelAtual;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public Computador getComputador() {
        return computador;
    }

    public Aventura getAventura() {
        return aventura;
    }

    public Combate getCombate(){
        return combate;
    }

    public List<HeroiDTO> getHerois() {
        return herois;
    }

}
