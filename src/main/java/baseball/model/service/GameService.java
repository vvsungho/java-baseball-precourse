package baseball.model.service;

import baseball.model.domain.Baseball;

public interface GameService {
    Baseball getResult(String userNumber, String givenNumber);
    void validatePlayGameNumber(String str);
    void validateRestartGameNumber(String str);
}
