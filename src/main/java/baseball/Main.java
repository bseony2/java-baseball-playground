package baseball;

import baseball.enums.GameStatus;
import baseball.game.Balls;
import baseball.game.BallsGenerator;
import baseball.game.PlayResult;
import baseball.utils.UserInputValidations;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final BallsGenerator ballsGenerator = new BallsGenerator();
    static final Scanner sc = new Scanner(System.in);
    static Balls balls;
    public static void main(String[] args) {
        do {
            newGame();
        } while (1==isEnd());
    }

    private static void newGame() {
        balls = new Balls(ballsGenerator.generate());
        PlayResult result;
        do {
            int userInput = getUserAnswer();
            Balls userBalls = new Balls(Arrays.asList( (userInput / 100), (userInput / 10) % 10, userInput % 10) );
            result = balls.play(userBalls);
            result.getAnswer();
        } while (!result.isGameEnd());
    }

    private static int isEnd() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userInput = sc.nextInt();
        while(GameStatus.NEW.getValue()!=userInput && GameStatus.END.getValue()!=userInput) {
            System.out.println();
            System.out.println("입력값을 확인해주십시오");

            System.out.print("숫자를 입력해 주세요 : ");
            userInput = sc.nextInt();
        }
        return userInput;
    }

    private static int getUserAnswer() {
        System.out.print("숫자를 입력해 주세요 : ");
        int userInput = sc.nextInt();
        while(!UserInputValidations.validateUserInput(userInput)) {
            System.out.println();
            System.out.println("입력값을 확인해주십시오");

            System.out.print("숫자를 입력해 주세요 : ");
            userInput = sc.nextInt();
        }

        return userInput;
    }
}
