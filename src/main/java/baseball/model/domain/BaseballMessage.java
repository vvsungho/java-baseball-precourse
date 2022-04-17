package baseball.model.domain;

import baseball.constant.Constant;

public class BaseballMessage {
    private StringBuilder message;

    public BaseballMessage (Baseball baseball) {
        message = new StringBuilder();
        getBallCountMessage(baseball);
        getBallMessage(baseball);
        getSpacingMessage(baseball);
        getStrikeCountMessage(baseball);
        getStrikeMessage(baseball);
        getNothingMessage(baseball);
    }

    private void getBallMessage(Baseball baseball) {
        if (baseball.getBallCount() > 0) {
            message.append(Constant.BALL);
        }
    }

    private void getStrikeMessage(Baseball baseball) {
        if (baseball.getStrikeCount() > 0) {
            message.append(Constant.STRIKE);
        }
    }

    private void getSpacingMessage(Baseball baseball) {
        if (baseball.getBallCount() > 0 && baseball.getStrikeCount() > 0) {
            message.append(Constant.SPACING);
        }
    }

    private void getBallCountMessage(Baseball baseball) {
        if (baseball.getBallCount() > 0) {
            message.append(baseball.getBallCount());
        }
    }

    private void getStrikeCountMessage(Baseball baseball) {
        if (baseball.getStrikeCount() > 0) {
            message.append(baseball.getStrikeCount());
        }
    }

    private void getNothingMessage(Baseball baseball) {
        if (baseball.getBallCount() == 0 && baseball.getStrikeCount() == 0) {
            message.append(Constant.NOTHING);
        }
    }

    public String getGameResultMessage() {
        return message.toString();
    }
}
