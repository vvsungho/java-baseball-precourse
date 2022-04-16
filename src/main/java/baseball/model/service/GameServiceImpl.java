package baseball.model.service;

import baseball.constant.Constant;
import baseball.model.domain.Baseball;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.HashSet;
import java.util.Set;

public class GameServiceImpl implements GameService {
    private final CommonService commonService;
    private boolean isStart = false;
    private boolean isSuccess = false;

    public GameServiceImpl(CommonService commonService) {
        this.commonService = commonService;
    }

    @Override
    public void startGame() {
        prepareGame();
        while (isStart) {
            playGame();
        }
    }

    @Override
    public boolean isValidPlayGameNumber(String str) {
        if (!isValidNumber(str)) {
            return false;
        }

        if (str.contains(Constant.NOT_ALLOW_NUMBER_VALUE)) {
            InputView.printInputNumberCondition();
            return false;
        }

        if (str.length() != Constant.NUMBER_LENGTH_VALUE) {
            InputView.printInvalidInputLength();
            return false;
        }

        if (isDuplicateNumber(str)) {
            InputView.printInputDuplication();
            return false;
        }

        return true;
    }

    private void playGame() {
        this.isSuccess = false;
        String givenNumber = commonService.getGameRandomNumber(Constant.NUMBER_LENGTH_VALUE);

        while (!isSuccess) {
            InputView.printInputNumber();
            String userNumber = commonService.getReadLine();
            if(isValidPlayGameNumber(userNumber)) {
                throw new IllegalArgumentException(Constant.INVALID_INPUT_MESSAGE);
            }

            Baseball baseball = getResult(userNumber, givenNumber);
            isSuccess = baseball.isSuccess();

            if (isSuccess) {
                OutputView.printEndGame();
            }
        }

        checkRestartGame();
    }

    private boolean isValidRestartGameNumber(String str) {
        if (!(str.equals(Constant.RESTART_GAME_VALUE) || str.equals(Constant.END_GAME_VALUE))) {
            return false;
        }
        return true;
    }

    private boolean isValidNumber(String str) {
        if (isEmpty(str)) {
            InputView.printInputNumber();
            return false;
        }

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ne) {
            InputView.printInvalidInput();
            return false;
        }

        return true;
    }

    private boolean isDuplicateNumber(String str) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            uniqueNumbers.add(Character.getNumericValue(str.charAt(i)));
        }
        return str.length() != uniqueNumbers.size();
    }

    private void prepareGame() {
        this.isStart = true;
    }

    private int countBall(String userNumber, String givenNumber) {
        int count = 0;
        for (int i = 0; i < userNumber.length(); i++) {
            count+=checkContainNumberAndNotSameLocation(givenNumber, userNumber.charAt(i), i);
        }
        return count;
    }

    private int checkContainNumberAndNotSameLocation(String givenNumber, char number, int index) {
        return givenNumber.charAt(index) != number && givenNumber.contains(String.valueOf(number)) ? 1 : 0;
    }

    private int countStrike(String userNumber, String givenNumber) {
        int count = 0;
        for (int i = 0; i < userNumber.length(); i++) {
            count+=checkContainNumberAndSameLocation(userNumber.charAt(i), givenNumber.charAt(i));
        }
        return count;
    }

    private int checkContainNumberAndSameLocation(char number1, char number2) {
        return number1 == number2 ? 1 : 0;
    }

    @Override
    public Baseball getResult(String userNumber, String givenNumber) {
        int ballCount = countBall(userNumber, givenNumber);
        int strikeCount = countStrike(userNumber, givenNumber);

        Baseball baseball = new Baseball(ballCount, strikeCount, ballCount == 0 && strikeCount == 0, strikeCount == Constant.NUMBER_LENGTH_VALUE);
        OutputView.printResult(baseball);

        return baseball;
    }

    private boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    private void checkRestartGame() {
        InputView.printRestart();
        String str = commonService.getReadLine();
        if (isValidRestartGameNumber(str)) {
            throw new IllegalArgumentException(Constant.INVALID_INPUT_MESSAGE);
        }
        this.isStart = str.equals(Constant.RESTART_GAME_VALUE);
    }
}
