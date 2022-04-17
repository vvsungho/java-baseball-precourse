package baseball.model.domain;

public class Number {
    private String userNumber;
    private String randomNumber;

    public Number(String userNumber, String randomNumber) {
        this.userNumber = userNumber;
        this.randomNumber = randomNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public String getRandomNumber() {
        return randomNumber;
    }
}
