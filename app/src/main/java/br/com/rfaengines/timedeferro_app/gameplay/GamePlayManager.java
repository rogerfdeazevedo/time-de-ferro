package br.com.rfaengines.timedeferro_app.gameplay;

public class GamePlayManager {

    private static GamePlay gamePlay = null;

    private GamePlayManager(){}

    public static GamePlay getGamePlay(){
        return gamePlay;
    }

    public static void setGamePlay(GamePlay gamePlay){
        GamePlayManager.gamePlay = gamePlay;
    }

}
