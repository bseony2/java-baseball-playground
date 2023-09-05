import java.util.Random;
import java.util.ArrayList;

class Game {
    ArrayList<Integer> numbers = new ArrayList<>();
    Random random = new Random();
    int[] playerAnswer;
    int ball;
    int strike;

    boolean valueValidation;
    boolean isGameOver = false;

    public Game() {
        generateNumbers();

        for(int i=0; i<3; i++) {
            System.out.print(numbers.get(i) + " ");
        }
        System.out.println();
    }


    void generateNumbers() {
        numbers.clear();
        while(numbers.size() < 3) {
            numbers.add(getRandomNumber());
        }
    }

    int getRandomNumber() {
        int result = 0;
        while(result == 0 || numbers.contains(result)) {
            result = random.nextInt(9);
        }
        return result;
    }

    void setAnswer() {
        int[] answer = getPlayerAnswer();
        if(!validateAnswer(answer)) {
            warnBadAnswer();
            answer = getPlayerAnswer();
        }
        this.playerAnswer = answer;
    }

    static int[] getPlayerAnswer() {
        System.out.print("숫자를 입력해 주세요 : ");
        int answer = Main.sc.nextInt();

        int[] result = new int[3];
        result[0] = answer / 100;
        result[1] = (answer % 100) / 10;
        result[2] = answer % 10;
        return result;
    }

    boolean validateAnswer(int[] answer) {
        this.valueValidation = true;

        validateAllValue(answer);

        return this.valueValidation;
    }

    void validateAllValue(int[] answer) {
        int index = 0;
        while(this.valueValidation && index < numbers.size()) {
            validateValue(answer[index]);
            index += 1;
        }
    }

    void validateValue(int value) {
        if(10< value || value < 1) this.valueValidation = false;
    }

    void setResult() {
        this.strike = 0;
        this.ball = 0;

        getContainsAmt();
        getCorrectLocationNumber();

        ball = ball - strike;
    }

    void getContainsAmt() {
        for(int value : this.playerAnswer) {
            addContainsNumber(value);
        }
    }
    void addContainsNumber(int value) {
        if(numbers.contains(value)) this.ball += 1;
    }

    void getCorrectLocationNumber() {
        for(int i=0; i<3; i++) {
            addCorrectLocationNumber(i, this.playerAnswer[i]);
        }
    }

    void addCorrectLocationNumber(int index, int value) {
        if(numbers.get(index) == value) this.strike += 1;
    }

    void reactToPlayer() {
        if(this.strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            this.isGameOver = true;
            return;
        }
        if(this.strike == 0 && this.ball == 0) {
            System.out.println("낫싱");
            return;
        }

        if(this.ball > 0) {
            System.out.println(this.ball + "볼 ");
        }
        if(this.strike > 0) {
            System.out.print(this.strike + "스트라이크");
        }
        System.out.println();
    }

    static void warnBadAnswer() {
        System.out.println("올바른 숫자 형식을 입력해주세요.");
    }
}
