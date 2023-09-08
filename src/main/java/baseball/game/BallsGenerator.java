package baseball.game;

import baseball.utils.UserInputValidations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallsGenerator {
    private static final int BALL_SIZE = 3;
    public List<Integer> balls = new ArrayList<>();

    public List<Integer> generate() {
        List<Integer> balls = new ArrayList<>();
        while(balls.size()<BALL_SIZE) {
            balls.add(getNewBall());
        }

        return balls;
    }

    private Integer getNewBall() {
        int result = getRandomNumber();
        while(this.balls.contains(result) || !UserInputValidations.unitSizeValidate(result)) {
            result = getRandomNumber();
        }
        return result;
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(8) + 1;
    }

}
