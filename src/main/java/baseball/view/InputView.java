package baseball.view;

import baseball.enums.GameStatus;
import baseball.utils.UserInputValidations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static baseball.utils.UserInputValidations.convertInputToList;

public class InputView {

    static Scanner sc = new Scanner(System.in);
    public static List<Integer> getUserAnswer() {
        List<Integer> result = new ArrayList<>();
        try {
            System.out.print("숫자를 입력해 주세요 : ");
            int userInput = sc.nextInt();
            result = convertInputToList(userInput);
            UserInputValidations.validateUserInput(result);
        }   catch(Exception e) {
            System.out.println(e.getMessage() + " 입력값을 확인해주십시오");
            getUserAnswer();
        }

        return result;
    }

    public static int isEnd() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int userInput = sc.nextInt();
        while(GameStatus.NEW.getValue()!=userInput && GameStatus.END.getValue()!=userInput) {
            System.out.println();
            System.out.println("입력값을 확인해주십시오");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userInput = sc.nextInt();
        }
        return userInput;
    }
}
