package baseball;

import baseball.enums.BallStatus;
import baseball.game.Ball;
import baseball.game.Balls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class BallTest {
    private Ball ball;
    private Balls balls;

    @BeforeEach
    void initBall() {
        ball = new Ball(1, 4);
        balls = new Balls(Arrays.asList(1, 2, 3));
    }

    @Test
    @DisplayName("볼 테스트")
    void ball() {
        assertThat(ball.play(new Ball(2, 4))).isEqualTo(BallStatus.BALL);
        assertThat(ball.play(new Ball(3, 4))).isEqualTo(BallStatus.BALL);

        assertThat(balls.play(new Ball(2, 1))).isEqualTo(BallStatus.BALL);
        assertThat(balls.play(new Ball(3, 1))).isEqualTo(BallStatus.BALL);
        assertThat(balls.play(new Ball(1, 2))).isEqualTo(BallStatus.BALL);
        assertThat(balls.play(new Ball(3, 2))).isEqualTo(BallStatus.BALL);
        assertThat(balls.play(new Ball(1, 3))).isEqualTo(BallStatus.BALL);
        assertThat(balls.play(new Ball(2, 3))).isEqualTo(BallStatus.BALL);
    }

    @Test
    @DisplayName("스트라이크 테스트")
    void strike() {
        assertThat(ball.play(new Ball(1, 4))).isEqualTo(BallStatus.STRIKE);

        assertThat(balls.play(new Ball(1, 1))).isEqualTo(BallStatus.STRIKE);
        assertThat(balls.play(new Ball(2, 2))).isEqualTo(BallStatus.STRIKE);
        assertThat(balls.play(new Ball(3, 3))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    @DisplayName("nothing 테스트")
    void nothing(){
        assertThat(ball.play(new Ball(1, 3))).isEqualTo(BallStatus.NOTHING);
        assertThat(ball.play(new Ball(2, 2))).isEqualTo(BallStatus.NOTHING);
        assertThat(ball.play(new Ball(3, 6))).isEqualTo(BallStatus.NOTHING);

        assertThat(balls.play(new Ball(1, 4))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(1, 5))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(1, 6))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(1, 7))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(1, 8))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(1, 9))).isEqualTo(BallStatus.NOTHING);

        assertThat(balls.play(new Ball(2, 4))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(2, 5))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(2, 6))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(2, 7))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(2, 8))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(2, 9))).isEqualTo(BallStatus.NOTHING);

        assertThat(balls.play(new Ball(3, 4))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(3, 5))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(3, 6))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(3, 7))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(3, 8))).isEqualTo(BallStatus.NOTHING);
        assertThat(balls.play(new Ball(3, 9))).isEqualTo(BallStatus.NOTHING);

    }
}
