package br.com.rfaengines.timedeferro_app.entity.aventura;

import java.util.List;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
public class Aventura {
    private int id_aventura;
    private String data;
    private List<Missao> missaoList;
}
