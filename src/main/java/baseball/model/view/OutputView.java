package baseball.model.view;

import baseball.constant.Constant;
import baseball.model.domain.Baseball;

public class OutputView {
    public static void printResult(Baseball baseball) {
        System.out.println(getResultMessage(baseball));
    }

    public static String getResultMessage(Baseball baseball) {
        if (baseball.isNothing()) {
            return Constant.NOTHING;
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (baseball.getBallCount() > 0) {
            stringBuilder.append(getBaseballTypeCount(baseball.getBallCount(), Constant.BALL));
            stringBuilder.append(" ");
        }

        if (baseball.getStrikeCount() > 0) {
            stringBuilder.append(baseball.getStrikeCount() + Constant.STRIKE);
        }

        return stringBuilder.toString().trim();
    }

    public static String printEndGame() {
        return Constant.SUCCESS_MESSAGE;
    }

    private static String getBaseballTypeCount(int count, String type) {
        return count + type;
    }
}
