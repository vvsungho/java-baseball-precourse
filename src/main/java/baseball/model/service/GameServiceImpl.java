package baseball.model.service;

import baseball.constant.Constant;
import baseball.model.domain.Baseball;
import java.util.HashSet;
import java.util.Set;

public class GameServiceImpl implements GameService {
    private final CommonService commonService;

    public GameServiceImpl(CommonService commonService) {
        this.commonService = commonService;
    }

    @Override
    public Baseball getResult(String userNumber, String givenNumber) {
        int ballCount = countBall(userNumber, givenNumber);
        int strikeCount = countStrike(userNumber, givenNumber);

        return Baseball.createBaseballResult(ballCount, strikeCount);
    }

    @Override
    public void validatePlayGameNumber(String str) {
        validateNumber(str);
        validateAllowValue(str);
        validateNumberLength(str);
        validateDuplicateNumber(str);
    }

    @Override
    public void validateRestartGameNumber(String str) {
        if (!(str.equals(Constant.RESTART_GAME_VALUE) || str.equals(Constant.END_GAME_VALUE))) {
            throw new IllegalArgumentException(Constant.INVALID_INPUT_MESSAGE);
        }
    }

    private void validateNumber(String str) {
        validateEmptyValue(str);
        validateNumberValue(str);
    }

    private void validateEmptyValue(String str) {
        if (commonService.isEmpty(str)) {
            throw new IllegalArgumentException(Constant.INVALID_INPUT_MESSAGE);
        }
    }

    private void validateNumberValue(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ne) {
            throw new IllegalArgumentException(Constant.INVALID_INPUT_MESSAGE);
        }
    }

    private void validateAllowValue(String str) {
        if (str.contains(Constant.NOT_ALLOW_NUMBER_VALUE)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberLength(String str) {
        if (str.length() != Constant.NUMBER_LENGTH_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(String str) {
        if (isDuplicateNumber(str)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicateNumber(String str) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            uniqueNumbers.add(Character.getNumericValue(str.charAt(i)));
        }
        return str.length() != uniqueNumbers.size();
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
}
