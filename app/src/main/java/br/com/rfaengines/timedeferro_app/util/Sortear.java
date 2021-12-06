package br.com.rfaengines.timedeferro_app.util;

import java.util.Random;

public class Sortear {

    public static int num(int min, int max){
        return new Random().nextInt(max - min) + min;
    }

}
