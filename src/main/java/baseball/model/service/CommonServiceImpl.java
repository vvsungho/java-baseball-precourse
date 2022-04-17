package baseball.model.service;

import baseball.constant.Constant;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class CommonServiceImpl implements CommonService {

    @Override
    public String getGameRandomNumber(int length) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        uniqueNumbers = addAndGetUniqueNumber(uniqueNumbers, length);

        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : uniqueNumbers) {
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }

    @Override
    public String getReadLine() {
        return Console.readLine();
    }

    private Set<Integer> addAndGetUniqueNumber(Set<Integer> uniqueNumbers, int length) {
        uniqueNumbers.add(getRandomNumber());
        if (uniqueNumbers.size() != length) {
            addAndGetUniqueNumber(uniqueNumbers, length);
        }
        return uniqueNumbers;
    }
    @Override
    public boolean isEmpty(String str) {
        return str == null || str.equals("");
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(Constant.MIN_VALUE, Constant.MAX_VALUE);
    }
}
