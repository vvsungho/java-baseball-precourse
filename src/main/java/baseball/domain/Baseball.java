package baseball.domain;

public class Baseball {
    private int ballCount;
    private int strikeCount;
    private boolean isNothing;
    private boolean isSuccess;

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

    public boolean isSuccess() {
        return isSuccess;
    }
}
