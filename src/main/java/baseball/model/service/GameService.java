package baseball.model.service;

import baseball.model.domain.Baseball;

public interface GameService {
    void startGame();
    Baseball getResult(String userNumber, String givenNumber);
    boolean isValidPlayGameNumber(String str);
}
