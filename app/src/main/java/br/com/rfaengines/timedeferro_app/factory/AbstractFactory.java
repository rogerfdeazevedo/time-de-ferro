package br.com.rfaengines.timedeferro_app.factory;

import java.util.ArrayList;
import java.util.List;

import br.com.rfaengines.timedeferro_app.entity.aventura.ElementoAventura;
import br.com.rfaengines.timedeferro_app.util.Sortear;

public abstract class AbstractFactory {

    protected static List<String> param;

    public AbstractFactory(){
        this.param = new ArrayList<String>();
        carregarParam();
    }

    protected abstract void carregarParam();

    public abstract ElementoAventura novo();

    protected static int getSort(int min, int max){
        return Sortear.num(min, max);
    }

}
