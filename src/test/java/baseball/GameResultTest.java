package baseball;

import baseball.game.Balls;
import baseball.game.PlayResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

public class GameResultTest {
    Balls balls;

    @BeforeEach
    void init() {
        this.balls = new Balls(Arrays.asList(1, 2, 3));
    }
    @Test
    @DisplayName("원볼 원 스트라이크")
    void oneBalloneStrike() {
        PlayResult result = balls.play(new Balls(Arrays.asList(2, 4, 3)));
        assertThat(result.getBall() == 1 && result.getStrike() == 1).isTrue();

        result = balls.play(new Balls(Arrays.asList(1, 3, 5)));
        assertThat(result.getBall() == 1 && result.getStrike() == 1).isTrue();
    }

    @Test
    @DisplayName("nothing")
    void nothing() {
        PlayResult result = balls.play(new Balls(Arrays.asList(4, 5, 6)));
        assertThat(result.getBall() == 0 && result.getStrike() == 0).isTrue();

        result = balls.play(new Balls(Arrays.asList(9, 7, 5)));
        assertThat(result.getBall() == 0 && result.getStrike() == 0).isTrue();
    }

    @Test
    @DisplayName("3볼")
    void allBall() {
        PlayResult result = balls.play(new Balls(Arrays.asList(3, 1, 2)));
        assertThat(result.getBall() == 3).isTrue();

        result = balls.play(new Balls(Arrays.asList(2, 3, 1)));
        assertThat(result.getBall() == 3).isTrue();
    }

    @Test
    @DisplayName("3스트라이크")
    void allStrike() {
        PlayResult result = balls.play(new Balls(Arrays.asList(1, 2, 3)));
        assertThat(result.isGameEnd()).isTrue();

    }
}
