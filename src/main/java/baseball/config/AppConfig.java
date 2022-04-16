package baseball.config;

import baseball.model.service.CommonService;
import baseball.model.service.CommonServiceImpl;
import baseball.model.service.GameService;
import baseball.model.service.GameServiceImpl;

public class AppConfig {
    public GameService baseballService() {
        return new GameServiceImpl(commonService());
    }

    public CommonService commonService() {
        return new CommonServiceImpl();
    }
}



