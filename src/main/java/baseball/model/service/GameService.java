package baseball.model.service;

import baseball.model.domain.Baseball;

public interface GameService {
    Baseball getResult(String userNumber, String givenNumber);
    boolean isValidPlayGameNumber(String str);
    boolean isValidRestartGameNumber(String str);
}
