package baseball.view;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String printInputNumber() {
        System.out.println(Constant.INPUT_MESSAGE);
        return Console.readLine();
    }

    public static void printInvalidInput() {
        System.out.println(Constant.INVALID_INPUT_MESSAGE);
    }

    public static void printInvalidInputLength() {
        System.out.println(Constant.INVALID_INPUT_LENGTH_MESSAGE);
    }

    public static void printInputNumberCondition() {
        System.out.println(Constant.INPUT_NUMBER_MESSAGE);
    }

    public static void printInputDuplication() {
        System.out.println(Constant.INVALID_INPUT_DUPLICATION_MESSAGE);
    }

    public static void printRestart() {
        System.out.println(Constant.RESTART_MESSAGE);
    }
}
