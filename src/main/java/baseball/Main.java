package baseball;

import baseball.enums.GameStatus;
import baseball.game.Balls;
import baseball.game.BallsGenerator;
import baseball.game.PlayResult;
import baseball.view.InputView;

import java.util.List;

public class Main {
    static final BallsGenerator ballsGenerator = new BallsGenerator();
    static Balls balls;
    public static void main(String[] args) {
        do {
            newGame();
        } while (GameStatus.isUserWnatNewGame(InputView.isEnd()));
    }

    private static void newGame() {
        System.out.println("=========================");
        System.out.println("======== NEW GAME========");
        System.out.println("=========================");
        balls = new Balls(ballsGenerator.generate());
        PlayResult result;
        do {
            List<Integer> userInput = InputView.getUserAnswer();
            Balls userBalls = new Balls(userInput);
            result = balls.play(userBalls);
            result.getAnswer();
        } while (!result.isGameEnd());
    }
}
