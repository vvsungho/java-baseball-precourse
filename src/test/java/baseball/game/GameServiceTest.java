package baseball.game;

import baseball.config.AppConfig;
import baseball.model.service.GameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class GameServiceTest {
    private GameService gameService;
    @BeforeEach
    public void setService() {
        AppConfig appConfig = new AppConfig();
        gameService = appConfig.baseballService();
    }

    @DisplayName("야구게임 입력 값 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"731", "528", "698", "141", "144", "2579", "016", "773", "717", "abc", "ABC", "1A3B5", "123A", "*23", "1ㅇ3"})
    public void isValidPlayGameNumberTest(String input) {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> {
                    gameService.validatePlayGameNumber(input);
                }
        );
    }

    @DisplayName("야구게임 결과 출력")
    @ParameterizedTest
    @CsvSource(value = {"539:1볼", "356:1스트라이크", "527:2볼 1스트라이크", "375:2볼", "138:낫싱", "257:3스트라이크"}, delimiter = ':')
    public void compareTest(String userNumber, String expected) {
        String givenNumber = "257";

//        Baseball baseball = gameService.getResult(userNumber, givenNumber);
//        String result = OutputView.getResultMessage(baseball);

//        assertEquals(expected, result);
    }

}
