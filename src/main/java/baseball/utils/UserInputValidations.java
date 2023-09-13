package baseball.utils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserInputValidations {
    private static final int MIN_BALL_VALUE = 1;
    private static final int MAX_BALL_VALUE = 9;

    public static boolean valideAllInputUnit(List<Integer> balls) {
        if(!balls.stream().allMatch(UserInputValidations::unitSizeValidate)) {
            throw new IllegalArgumentException("각 자리의 크기는 1이상 9이하여야 합니다.");
        }
        return true;
    }

    public static boolean unitSizeValidate(int ball) {
        return MIN_BALL_VALUE <= ball && ball <= MAX_BALL_VALUE;
    }

    public static boolean duplicationValidate(List<Integer> balls) {
        if(balls.stream().distinct().count() != balls.size()) {
            throw new IllegalArgumentException("각 숫자는 중복될 수 없습니다.");
        }

        return true;
    }

    public static boolean numberLength(List<Integer> input) {
        if(input.size() != 3) {
            throw new IllegalArgumentException("Balls의 크기는 3이어야 합니다.");
        }
        return true;
    }

    public static boolean validateUserInput(List<Integer> input) {
        if(!valideAllInputUnit(input) || !duplicationValidate(input) || !numberLength(input)) {
            return false;
        }

        return valideAllInputUnit(input) && duplicationValidate(input) && numberLength(input);
    }

    public static List<Integer> convertInputToList(int balls) {
        List<Integer> result = new ArrayList<>();
        while(balls != 0) {
            result.add(balls % 10);
            balls /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}
