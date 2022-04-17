package baseball.controller;

import baseball.config.AppConfig;
import baseball.constant.Constant;
import baseball.model.domain.Baseball;
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

            printResult();
        }
    }

    private void initConfig() {
        AppConfig appConfig = new AppConfig();
        gameService = appConfig.baseballService();
        commonService = appConfig.commonService();
    }

    private void initGame() {
        baseball = new Baseball(0, 0, false, true, false);
        number = new Number(null, commonService.getGameRandomNumber(Constant.NUMBER_LENGTH_VALUE));
    }

    private void printResult() {
        printBallCount();
        printBall();
        printSpacing();
        printStrikeCount();
        printStrike();
        printNothing();
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

    private void printBall() {
        if (baseball.getBallCount() > 0) {
            OutputView.printBall();
        }
    }

    private void printStrike() {
        if (baseball.getStrikeCount() > 0) {
            OutputView.printStrike();
        }
    }

    private void printSpacing() {
        if (baseball.getBallCount() > 0 && baseball.getStrikeCount() > 0) {
            OutputView.printSpacing();
        }
    }

    private void printBallCount() {
        if (baseball.getBallCount() > 0) {
            OutputView.printCount(baseball.getBallCount());
        }
    }

    private void printStrikeCount() {
        if (baseball.getStrikeCount() > 0) {
            OutputView.printCount(baseball.getStrikeCount());
        }
    }

    private void printNothing() {
        if (baseball.getBallCount() == 0 && baseball.getStrikeCount() == 0) {
            OutputView.printNothing();
        }
    }

    private void printEndGame() {
        if (baseball.isSuccess()) {
            OutputView.printEndGame();
        }
    }
}
