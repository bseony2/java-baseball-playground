package baseball;

import static org.assertj.core.api.Assertions.*;

import baseball.game.BallsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsGeneratorTest {
    BallsGenerator ballGenerator;
    @BeforeEach
    void init() {
        this.ballGenerator = new BallsGenerator();
        this.ballGenerator.generate();
    }
    @Test
    @DisplayName("3자리수 확인")
    void getRandomNumberTest() {
        assertThat(ballGenerator.balls.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("중복숫자 없는지 확인")
    void bllasDuplicationTest() {
        for(int i=0; i<ballGenerator.balls.size(); i++) {
            Integer selectBall = ballGenerator.balls.get(i);
            assertThat(
                    ballGenerator.balls.stream()
                    .filter(ball -> ball.equals(selectBall))
                    .count()
            ).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("각 자리의 숫자 확인")
    void ballSizeTest() {
        for(int ball : ballGenerator.balls) {
            assertThat(1<= ball && ball <=9).isTrue();
        }
    }
}
