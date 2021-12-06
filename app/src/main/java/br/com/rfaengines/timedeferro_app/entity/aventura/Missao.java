package br.com.rfaengines.timedeferro_app.entity.aventura;

import br.com.rfaengines.timedeferro_app.entity.personagem.Antagonista;
import br.com.rfaengines.timedeferro_app.entity.personagem.Heroi;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
@NoArgsConstructor
public class Missao extends ElementoAventura{
    private int id_issao;
    private String data;
    private int level;
    private Cenario cenario;
    private Problema problema;
    private Antagonista antagonista;
    private Heroi heroi;
    private Estrategia estrategia;
    private Rank rank;
    private int score;
}
