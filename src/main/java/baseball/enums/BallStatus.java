package baseball.enums;

public enum BallStatus {
    STRIKE
    , BALL
    , NOTHING;

    public static boolean isBall(BallStatus status) {
        return BALL.equals(status);
    }

    public static boolean isStrike(BallStatus status) {
        return STRIKE.equals(status);
    }

    public boolean isNotNothing() {
        return !this.equals(NOTHING);
    }
}
