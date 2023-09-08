package baseball.game;

import baseball.enums.BallStatus;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final List<Ball> balls = new ArrayList<>();

    public Balls(List<Integer> balls) {
        for(int i=0; i<3; i++) {
            this.balls.add(new Ball(i+1, balls.get(i)));
        }
    }

    public BallStatus play(Ball userBall) {
        return balls.stream()
                .map(ball -> ball.play(userBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }

    public PlayResult play(Balls userAnswer) {
        PlayResult result = new PlayResult();

        for(Ball userBall : userAnswer.balls) {
            BallStatus status = this.play(userBall);
            result.report(status);
        }

        return result;
    }
}
