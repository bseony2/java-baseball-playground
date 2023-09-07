package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallsGenerator {
    private static final int BALL_SIZE = 3;
    List<Integer> balls = new ArrayList<>();

    public void generate() {
        while(balls.size()<BALL_SIZE) {
            balls.add(getNewBall());
        }
    }

    private Integer getNewBall() {
        int result = getRandomNumber();
        while(this.balls.contains(result)) {
            result = getRandomNumber();
        }
        return result;
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

}
