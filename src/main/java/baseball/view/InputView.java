package baseball.view;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String printInputNumber() {
        System.out.println(Constant.INPUT_MESSAGE);
        return Console.readLine();
    }

    public static void printRestart() {
        System.out.println(Constant.RESTART_MESSAGE);
    }
}
