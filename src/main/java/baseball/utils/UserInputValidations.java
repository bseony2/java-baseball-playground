package baseball.utils;


public class UserInputValidations {
    private static final int MIN_BALL_VALUE = 1;
    private static final int MAX_BALL_VALUE = 9;

    public static boolean unitSizeValidate(int ball) {
        return MIN_BALL_VALUE <= ball && ball <= MAX_BALL_VALUE;
    }

    public static boolean duplicationValidate(int balls) {
        return (balls / 100) != ((balls / 10) % 10) && (balls / 100) != (balls % 10) && ((balls / 10) % 10) != (balls % 10);
    }

    public static boolean numberLength(int input) {
        return 100 <= input && input <= 999;
    }
}
