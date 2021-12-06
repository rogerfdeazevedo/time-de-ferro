package br.com.rfaengines.timedeferro_app.factory;

import org.junit.Assert;
import org.junit.Test;

import br.com.rfaengines.timedeferro_app.entity.aventura.Problema;
import lombok.extern.java.Log;

@Log
public class FactoryTest {

    @Test
    public void novoCenarioTest(){
//        Cenario cenario = (Cenario) new CenarioFactory().novo();
//        Assert.assertNotNull(cenario);
//        log.info(cenario.toString());

//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        String str = appContext.getResources().getString(R.string.cenario_1);
//        log.info(str);
    }

    @Test
    public void novoProblemaTest(){
        Problema problema = AventuraFactory.novoProblema();
        Assert.assertNotNull(problema);
        log.info(problema.toString());
    }

}
