package baseball.controller;

import baseball.config.AppConfig;
import baseball.constant.Constant;
import baseball.model.domain.Baseball;
import baseball.model.domain.BaseballMessage;
import baseball.model.domain.Number;
import baseball.model.service.CommonService;
import baseball.model.service.GameService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private Baseball baseball;
    private Number number;
    private GameService gameService;
    private CommonService commonService;

    public void play() {
        initConfig();
        initGame();
        while (baseball.isStart()) {
            startGame();
            checkRestartGame();
        }
    }

    private void startGame() {
        while (!baseball.isSuccess()) {
            number.setUserNumber(InputView.printInputNumber());
            gameService.validatePlayGameNumber(number.getUserNumber());
            baseball = gameService.getResult(number.getUserNumber(), number.getRandomNumber());

            BaseballMessage baseballMessage = new BaseballMessage(baseball);
            printResult(baseballMessage);
        }
    }

    private void initConfig() {
        AppConfig appConfig = new AppConfig();
        gameService = appConfig.baseballService();
        commonService = appConfig.commonService();
    }

    private void initGame() {
        baseball = Baseball.initializeBaseball();
        number = Number.initializeNumber(commonService.getGameRandomNumber(Constant.NUMBER_LENGTH_VALUE));
    }

    private void printResult(BaseballMessage baseballMessage) {
        printGameResult(baseballMessage.getGameResultMessage());
        printEndGame();
    }

    private void checkRestartGame() {
        InputView.printRestart();
        String str = commonService.getReadLine();
        gameService.validateRestartGameNumber(str);

        boolean isStart = str.equals(Constant.RESTART_GAME_VALUE);
        if (isStart) {
            this.initGame();
        }
    }

    private void printGameResult(String message) {
        OutputView.printGameResult(message);
    }

    private void printEndGame() {
        if (baseball.isSuccess()) {
            OutputView.printEndGame();
        }
    }
}
