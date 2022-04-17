package baseball.view;

import baseball.constant.Constant;

public class OutputView {
    public static void printGameResult(String message) {
        System.out.println(message);
    }

    public static void printEndGame() {
        System.out.println(Constant.SUCCESS_MESSAGE);
    }

    public static void printBall() {
        System.out.println(Constant.BALL);
    }

    public static void printStrike() {
        System.out.println(Constant.STRIKE);
    }

    public static void printNothing() {
        System.out.println(Constant.NOTHING);
    }

    public static void printCount(int count) {
        System.out.println(count);
    }

    public static void printSpacing() {
        System.out.println(" ");
    }
}
