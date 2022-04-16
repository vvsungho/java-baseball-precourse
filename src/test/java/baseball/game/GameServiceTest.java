package baseball.game;

import baseball.config.AppConfig;
import baseball.model.domain.Baseball;
import baseball.model.service.GameService;
import baseball.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameServiceTest {
    private GameService gameService;
    @BeforeEach
    public void setService() {
        AppConfig appConfig = new AppConfig();
        gameService = appConfig.baseballService();
    }

    @DisplayName("야구게임 입력 값 검증")
    @ParameterizedTest
    @CsvSource(value = {"731:true", "528:true", "698:true", "141:false", "144:false", "2579:false", "016:false", "773:false", "717:false", "abc:false", "ABC:false", "1A3B5:false", "123A:false", "*23:false", "1ㅇ3:false"}, delimiter = ':')
    public void isValidPlayGameNumberTest(String input, String expected) {
        boolean isSuccess = gameService.isValidPlayGameNumber(input);
        assertEquals(Boolean.parseBoolean(expected), isSuccess);
    }

    @DisplayName("야구게임 결과 출력")
    @ParameterizedTest
    @CsvSource(value = {"539:1볼", "356:1스트라이크", "527:2볼 1스트라이크", "375:2볼", "138:낫싱", "257:3스트라이크"}, delimiter = ':')
    public void compareTest(String userNumber, String expected) {
        String givenNumber = "257";

        Baseball baseball = gameService.getResult(userNumber, givenNumber);
        String result = OutputView.getResultMessage(baseball);

        assertEquals(expected, result);
    }

}
