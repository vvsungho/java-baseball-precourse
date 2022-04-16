package baseball.controller;

import baseball.config.AppConfig;
import baseball.model.service.GameService;

public class GameController {
    public void play() {
        AppConfig appConfig = new AppConfig();
        GameService gameService = appConfig.baseballService();

        gameService.startGame();
    }
}
