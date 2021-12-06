package br.com.rfaengines.timedeferro_app.factory;

import br.com.rfaengines.timedeferro_app.R;
import br.com.rfaengines.timedeferro_app.entity.aventura.Cenario;
import br.com.rfaengines.timedeferro_app.entity.aventura.ElementoAventura;
import br.com.rfaengines.timedeferro_app.entity.caracteristica.OrigemDoPoder;
import br.com.rfaengines.timedeferro_app.util.AppUtil;

public class CenarioFactory extends AbstractFactory {

    @Override
    protected void carregarParam() {
        AppUtil appUtil = new AppUtil();
        param.add(appUtil.getRes(R.string.cenario_1));
        param.add(appUtil.getRes(R.string.cenario_2));
        param.add(appUtil.getRes(R.string.cenario_3));
        param.add(appUtil.getRes(R.string.cenario_4));
        param.add(appUtil.getRes(R.string.cenario_5));
    }

    @Override
    public ElementoAventura novo() {
        Cenario cenario = new Cenario();
        cenario.setDescricao(param.get(getSort(1, param.size())));
        cenario.setOrigemDoPoder(OrigemDoPoder.values()[getSort(1, OrigemDoPoder.values().length)]);
        return cenario;
    }


}
