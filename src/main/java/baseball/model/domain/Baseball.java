package baseball.model.domain;

import baseball.constant.Constant;

public class Baseball {
    private int ballCount;
    private int strikeCount;
    private boolean isNothing;
    private boolean isStart;
    private boolean isSuccess;

    public Baseball(int ballCount, int strikeCount, boolean isNothing, boolean isStart, boolean isSuccess) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        this.isNothing = isNothing;
        this.isStart = isStart;
        this.isSuccess = isSuccess;
    }

    public Baseball(int ballCount, int strikeCount, boolean isNothing, boolean isSuccess) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
        this.isNothing = isNothing;
        this.isSuccess = isSuccess;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public boolean isNothing() {
        return isNothing;
    }

    public boolean isStart() {
        return isStart;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public class Result {
        private StringBuilder message;

        public void setMessage() {
            message = new StringBuilder();
            getBallCountMessage();
            getBallMessage();
            getSpacingMessage();
            getStrikeCountMessage();
            getStrikeMessage();
            getNothingMessage();
        }

        private void getBallMessage() {
            if (getBallCount() > 0) {
                message.append(Constant.BALL);
            }
        }

        private void getStrikeMessage() {
            if (getStrikeCount() > 0) {
                message.append(Constant.STRIKE);
            }
        }

        private void getSpacingMessage() {
            if (getBallCount() > 0 && getStrikeCount() > 0) {
                message.append(Constant.SPACING);
            }
        }

        private void getBallCountMessage() {
            if (getBallCount() > 0) {
                message.append(getBallCount());
            }
        }

        private void getStrikeCountMessage() {
            if (getStrikeCount() > 0) {
                message.append(getStrikeCount());
            }
        }

        private void getNothingMessage() {
            if (getBallCount() == 0 && getStrikeCount() == 0) {
                message.append(Constant.NOTHING);
            }
        }
    }
}
