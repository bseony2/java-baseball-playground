package baseball.game;

import baseball.enums.BallStatus;

public class Ball {
    private final int position;
    private final int value;

    public Ball(int position, int value) {
        this.position = position;
        this.value = value;
    }

    public BallStatus play(Ball ball) {
        if(isStrike(ball)) {
            return BallStatus.STRIKE;
        }
        if(isBall(ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean isBall(Ball ball) {
        return this.position != ball.position && this.value == ball.value;
    }

    private boolean isStrike(Ball ball) {
        return this.position == ball.position && this.value == ball.value;
    }
}
