package br.com.rfaengines.timedeferro_app.factory;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import br.com.rfaengines.timedeferro_app.dto.aventura.AventuraDTO;
import br.com.rfaengines.timedeferro_app.dto.aventura.CenarioDTO;
import br.com.rfaengines.timedeferro_app.dto.aventura.ProblemaDTO;
import br.com.rfaengines.timedeferro_app.dto.caracteristica.HabilidadeDTO;
import br.com.rfaengines.timedeferro_app.dto.participante.ComputadorDTO;
import br.com.rfaengines.timedeferro_app.dto.participante.JogadorDTO;
import br.com.rfaengines.timedeferro_app.dto.personagem.AntagonistaDTO;
import lombok.extern.java.Log;

@Log
public class FactoryTest {

    protected List<String> parametros;

    protected List<AntagonistaDTO> antagonistas;

    @Before
    public void preCon(){
        carregarParametros();
        carregarAntagonistas();
    }

    @Test
    public void participanteJogadorTest(){
        JogadorDTO jogadorDTO = ParticipanteFactory.novoJogador();
        Assert.assertFalse(jogadorDTO.isDonoDoTurno());
        Assert.assertFalse(jogadorDTO.isVencedor());
        Assert.assertEquals(3, jogadorDTO.getQtdContinue());
        log.info(jogadorDTO.toString());
    }

    @Test
    public void participanteComputadorTest(){
        ComputadorDTO computadorDTO = ParticipanteFactory.novoComputador();
        Assert.assertFalse(computadorDTO.isDonoDoTurno());
        Assert.assertFalse(computadorDTO.isVencedor());
        log.info(computadorDTO.toString());
    }

    @Test
    public void novoCenarioTest(){
        CenarioDTO cenarioDTO = CenarioFactory.novoCenario(parametros);
        Assert.assertNotNull(cenarioDTO);
        log.info(cenarioDTO.toString());
    }

    @Test
    public void novoProblemaTest(){
        ProblemaDTO problemaDTO = ProblemaFactory.novoProblema(parametros);
        Assert.assertNotNull(problemaDTO);
        log.info(problemaDTO.toString());
    }

    @Test
    public void novoAntagonistaTest(){
        AntagonistaDTO antagonistaDTO = AntagonistaFactory.novoAntagonista(antagonistas);
        Assert.assertNotNull(antagonistaDTO);
        log.info(antagonistaDTO.getNome());
    }

    @Test
    public void novaAventuraTest(){
        List<String> cenarios = parametros;
        List<String> problemas = parametros;
        AventuraFactory aventuraFactory
                = new AventuraFactory(cenarios, problemas, antagonistas);
        AventuraDTO aventuraDTO = aventuraFactory.novaAventura();
        Assert.assertNotNull(aventuraDTO);
        log.info(aventuraDTO.getMissoes().get(0).getCenarioDTO().getDescricao());
    }

    protected void carregarParametros(){
        parametros = new ArrayList<>();
        int qtd = 5;
        for(int i=1;i<=qtd;i++){
            parametros.add("item_"+i);
        }
    }

    protected void carregarAntagonistas(){
        antagonistas = new ArrayList<>();
        int qtd = 5;
        for(int i=1;i<=qtd;i++){
            antagonistas.add(criarAntagonista(i));
        }
    }

    private AntagonistaDTO criarAntagonista(int id){

        AntagonistaDTO antagonistaDTO = new AntagonistaDTO();
        antagonistaDTO.setNome("antagonista_" + id);

        HabilidadeDTO habilidade_1= new HabilidadeDTO();
        habilidade_1.setNome("antagonista_" + id + "_h1");
        HabilidadeDTO habilidade_2 = new HabilidadeDTO();
        habilidade_2.setNome("antagonista_" + id + "_h2");

        List<HabilidadeDTO> habilidades = new ArrayList<>();
        habilidades.add(habilidade_1);
        habilidades.add(habilidade_2);
        antagonistaDTO.setHabilidades(habilidades);

        HabilidadeDTO especial = new HabilidadeDTO();
        especial.setNome("antagonista_" + id + "_esp");
        antagonistaDTO.setEspecial(especial);

        return antagonistaDTO;
    }

}
