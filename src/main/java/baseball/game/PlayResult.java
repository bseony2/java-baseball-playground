package baseball.game;

import baseball.enums.BallStatus;

public class PlayResult {
    int strike;
    int ball;

    public PlayResult() {
        this.strike = 0;
        this.ball = 0;
    }
    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void getAnswer() {
        String result = "";
        if(isNothing()) {
            System.out.println("NOTHING");
            return;
        }

        if(ball > 0) {
            result += this.ball + "볼 ";
        }

        if(strike > 0) {
            result += this.strike + "스트라이크";
        }
        System.out.println(result);
    }

    private boolean isNothing() {
        return this.ball == 0 && this.strike == 0;
    }


    public void report(BallStatus status) {
        if(BallStatus.isBall(status)) {
            this.ball += 1;
        }
        if(BallStatus.isStrike(status)) {
            this.strike += 1;
        }
    }

    public boolean isGameEnd() {
        return this.strike == 3;
    }
}
