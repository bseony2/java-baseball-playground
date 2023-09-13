package baseball.utils;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserInputValidations {
    private static final int MIN_BALL_VALUE = 1;
    private static final int MAX_BALL_VALUE = 9;

    public static boolean valideAllInputUnit(List<Integer> balls) {
        return balls.stream().allMatch(UserInputValidations::unitSizeValidate);
    }

    public static boolean unitSizeValidate(int ball) {
        return MIN_BALL_VALUE <= ball && ball <= MAX_BALL_VALUE;
    }

    public static boolean duplicationValidate(List<Integer> balls) {
        return balls.stream().distinct().count() == balls.size();
    }

    public static boolean numberLength(List<Integer> input) {
        return input.size() == 3;
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
